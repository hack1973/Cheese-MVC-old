package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hackman on 5/28/2017.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    HashMap<String, String> cheeses = new HashMap<>();


    //Request path = /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        //model.addAttribute("cheeseName", cheeseName);
        //model.addAttribute("cheeseDescription", cheeseDescription);
        model.addAttribute("title", "My Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        //model.addAttribute("cheeseName", cheeseName);
        //model.addAttribute("cheeseDescription", cheeseDescription);
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(Model model, @RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        model.addAttribute("cheeseName", cheeseName);
        model.addAttribute("cheeseDescription", cheeseDescription);
        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }
}
