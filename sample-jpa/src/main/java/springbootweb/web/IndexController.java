package springbootweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springbootweb.domain.Note;
import springbootweb.repository.NoteRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by vitaliy on 17.04.15.
 */
@Controller
public class IndexController {
    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping("/")
    @Transactional(readOnly = true)
    public String index(Map<String, Object> model) {
        List<Note> notes = this.noteRepository.findAll();
        model.put("notes", notes);
        return "index";
    }

}
