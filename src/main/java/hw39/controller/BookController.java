package hw39.controller;

import hw39.model.Book;
import hw39.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookshop")
public class BookController {
    private final BookShopService service;

    @Autowired
    public BookController(BookShopService service) {
        this.service = service;
    }

    @GetMapping
    public String bookshop(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", service.getBookById(id));
        return "book-details";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "book-add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        service.addBook(book);
        return "redirect:/bookshop";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", service.getBookById(id));
        return "book-update";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute Book book) {
        book.setId(id);
        service.updateBook(book);
        return "redirect:/bookshop";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteBook(id);
        return "redirect:/bookshop";
    }
}
