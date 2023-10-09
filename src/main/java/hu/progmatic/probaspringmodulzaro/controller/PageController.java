package hu.progmatic.probaspringmodulzaro.controller;

import hu.progmatic.probaspringmodulzaro.model.Person;
import hu.progmatic.probaspringmodulzaro.model.Spending;
import hu.progmatic.probaspringmodulzaro.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class PageController {

    private EntityService entityService;

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/person")
    public String personPage(Model model) {
        model.addAttribute("personList", entityService.getAllPerson());
        return "person";
    }

    @PostMapping("/add-person")
    public String addPerson(@ModelAttribute ("newPerson") Person person) {
        entityService.createNewPerson(person);
        return "redirect:/person";
    }

    @GetMapping("/add-person")
    public String addPersonPage(Model model) {
        model.addAttribute("newPerson", new Person());
        return "addPerson";
    }

    @DeleteMapping("/delete-person")
    public String deletePerson(Person person) {

    }

    @PostMapping("/add-spending")
    public String addSpending(@ModelAttribute ("newSpending")Spending spending) {
        entityService.createNewSpending(spending);
        return "redirect:/spending";
    }


    @GetMapping("/add-spending")
    public String addSpendingPage(Model model) {
        model.addAttribute("newSpending", new Spending());
        return "addSpending";
    }

    @GetMapping("/spending")
    public String spendingPage(Model model) {
        model.addAttribute("spendingList", entityService.getAllSpending());
        return "spending";
    }
}
