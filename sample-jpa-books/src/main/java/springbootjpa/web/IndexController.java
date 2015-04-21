package springbootjpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootjpa.domain.Book;
import springbootjpa.repository.BookRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by vitaliy on 17.04.15.
 */
@Controller
public class IndexController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        List<Book> books = this.bookRepository.findAll();
        model.put("books", books);
        model.put("name", "Vitaliy");
        return "index";
    }
}
