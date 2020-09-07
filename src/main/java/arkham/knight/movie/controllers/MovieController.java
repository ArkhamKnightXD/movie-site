package arkham.knight.movie.controllers;

import arkham.knight.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title", "welcome");

        return "freemarker/cast";
    }
}
