package com.codegym.springbootA04.validate;

import com.codegym.springbootA04.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if ("Vương".equals(student.getName())) {
            errors.rejectValue("name","items.notVuong2",
                    new String[] {"name", student.getName()}, "Data khác Vương");
        }
    }
}
