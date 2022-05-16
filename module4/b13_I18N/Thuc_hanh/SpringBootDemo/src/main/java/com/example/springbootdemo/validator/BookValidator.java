package com.example.springbootdemo.validator;

import com.example.springbootdemo.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (book.getName().equalsIgnoreCase("The Duc")) {
            errors.rejectValue("name", "name.theduc");
        }

        String author = book.getAuthor();
        if (author.length() < 3 || author.length() > 11) {
            errors.rejectValue("author", "book.create.bookform.author.invalidrange"
                , new String[]{"3", "11"}, "Độ dài của chuỗi chưa chính xác");
        }
    }
}
