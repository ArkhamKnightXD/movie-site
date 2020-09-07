package arkham.knight.movie.services;

import arkham.knight.movie.models.Movie;
import arkham.knight.movie.repositories.MovieRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> getAllMovies(){

        return movieRepository.findAll();
    }


    public void saveAllMoviesFromTheJsonFile(InputStream inputStream, TypeReference<List<Movie>> typeReference){

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            List<Movie> movieList = objectMapper.readValue(inputStream,typeReference);

            movieRepository.saveAll(movieList);

            System.out.println("Data Saved!");

        } catch (IOException e){

            System.out.println("Unable to save data: " + e.getMessage());
        }
    }

    public void saveAllMovies(ResponseEntity<Movie[]> responseEntity){

        List<Movie> movieList = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));

        movieRepository.saveAll(movieList);
    }
}
