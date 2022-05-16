package com.example.springbootdemo.controller;

import com.example.springbootdemo.aspect.LoggingAspect;
import com.example.springbootdemo.exception.UserException;
import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.repository.CategoryRepository;
import com.example.springbootdemo.service.BookService;
import com.example.springbootdemo.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookValidator bookValidator;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MessageSource messageSource;

    private Logger logger = Logger.getLogger(BookController.class.getName());

    @GetMapping("create")
    public String displayCreate(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "book/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult,
                         Model model) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("list")
    public String showListBook(@RequestParam(name = "nameBook", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("books", bookService.findByName(name));
        } else {
            model.addAttribute("books", bookService.getList());
        }
        String message_vn = messageSource.getMessage("list.title", null, new Locale("vn"));
        logger.info(message_vn);
        return "book/list";
    }

    @GetMapping("listPaging")
    public String showListBookPaging(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "3") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            Model model) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("name").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("name").descending();
        }

        Pageable pageable = PageRequest.of(page - 1, size, order);

        model.addAttribute("books", bookService.findAll(pageable));
        return "book/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") int book_id, Model model) {
        model.addAttribute("book", bookService.getBookById(book_id));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(bookService.getBookById(book_id).getPublishDate()));
        return "book/detail";
    }

    @GetMapping("detail2/{id}")
    public String showDetail2(@PathVariable("id") Book book, Model model) throws Exception {
        if (book.getBookId() == 2) {
            throw new UserException("Book ID = 2");
        }
        if (book.getBookId() == 3) {
            throw new Exception("Book ID = 3");
        }
        model.addAttribute("book", book);
        return "book/detail";
    }

    @ExceptionHandler(UserException.class)
    public String errorHandler(UserException e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Book controller============");
        return "error";
    }
}
