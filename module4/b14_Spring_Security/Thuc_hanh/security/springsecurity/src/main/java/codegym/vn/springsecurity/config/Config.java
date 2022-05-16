package codegym.vn.springsecurity.config;

import codegym.vn.springsecurity.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/index").permitAll();
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
//        http.authorizeRequests().antMatchers("/user/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        // thiết lập action trả về khi truy cập trang không có quyền
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny");

        //Thiết lập login
        http.authorizeRequests().and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/user/index")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutSuccessUrl("/logoutSuccess");
    }
}
