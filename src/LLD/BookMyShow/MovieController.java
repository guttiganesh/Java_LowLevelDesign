package LLD.BookMyShow;

import LLD.BookMyShow.Enums.City;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityToMoviesMap;
    List<Movie> allMovies;

    public MovieController() {
        this.cityToMoviesMap = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie,City city){
        allMovies.add(movie);
        cityToMoviesMap.computeIfAbsent(city, k -> new ArrayList<>()).add(movie);
    }

    public Movie getMovieByName(String movieName){
        return allMovies.stream().filter(movie ->
                movie.getMovieName().equalsIgnoreCase(movieName)).findFirst().orElse(null);
    }

    public List<Movie> getMoviesByCity(City city){
        if(cityToMoviesMap.containsKey(city)) return cityToMoviesMap.get(city);
        return Collections.emptyList();
    }
}
