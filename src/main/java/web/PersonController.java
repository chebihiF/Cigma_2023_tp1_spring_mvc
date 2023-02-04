package web;

import entities.Person;
import metier.PersonMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/peoples")
public class PersonController {
    private final PersonMetier metier;

    public PersonController(PersonMetier metier) {
        this.metier = metier;
    }

    @GetMapping("")
    public String ListPerson(Model model){
        try {
            List<Person> people = metier.getAll();
            model.addAttribute("peoples",people);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "peoples";
    }
}
