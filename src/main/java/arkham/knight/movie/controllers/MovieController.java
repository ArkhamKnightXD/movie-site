package arkham.knight.movie.controllers;

import arkham.knight.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
}
