package LLD.BookMyShow;

import LLD.BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityToTheatresMap;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.cityToTheatresMap = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre,City city){
        allTheatres.add(theatre);
        cityToTheatresMap.computeIfAbsent(city,k -> new ArrayList<>()).add(theatre);
    }

    public Map<Theatre,List<Show>> getAllShows(Movie movie,City city){
        Map<Theatre,List<Show>> theatreToShowsMap  = new HashMap<>();
        List<Theatre> theatres = cityToTheatresMap.get(city);
        for(Theatre theatre:theatres){
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();
            for(Show show:shows){
                if(show.movie.getMovieId() == movie.getMovieId()) givenMovieShows.add(show);
                if(!givenMovieShows.isEmpty()) theatreToShowsMap.put(theatre,givenMovieShows);
            }
        }
        return theatreToShowsMap;
    }
}
