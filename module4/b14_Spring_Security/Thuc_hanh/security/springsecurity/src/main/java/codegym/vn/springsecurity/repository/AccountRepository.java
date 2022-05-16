package codegym.vn.springsecurity.repository;

import codegym.vn.springsecurity.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByUsername(String username);
}
