package arkham.knight.movie;

import arkham.knight.movie.models.Movie;
import arkham.knight.movie.services.MovieService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MovieSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSiteApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, MovieService movieService) {
        return args -> {


            TypeReference<List<Movie>> typeReference = new TypeReference<List<Movie>>(){};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");

            movieService.saveAllMoviesFromTheJsonFile(inputStream,typeReference);

            /*  RestTemplate method
            String myAPIKey = "31ea4d51557c07ce32e050afb1c5494a";
            String topRatedMoviesUrl = "https://api.themoviedb.org/3/movie/top_rated?api_key=".concat(myAPIKey);

            ResponseEntity<Movie[]> responseEntityMovie = restTemplate.getForEntity(topRatedMoviesUrl, Movie[].class);

            movieService.saveAllMovies(responseEntityMovie);*/
        };
    }

}
