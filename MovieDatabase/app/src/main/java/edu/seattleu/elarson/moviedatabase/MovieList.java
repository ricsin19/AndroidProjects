package edu.seattleu.elarson.moviedatabase;

import java.util.ArrayList;

public class MovieList {

    private static MovieList sMovieList = null;
    public int currentIndex = 0;

    private ArrayList<Movie> mMovies;

    private MovieList() {
        mMovies = new ArrayList<>();
        mMovies.add(new Movie("Frozen", "animated",
                "http://frozen.disney.com/",0.0f,false));
        mMovies.add(new Movie("Star Wars", "sci-fi",
                "http://www.starwars.com/",0.0f,false));
        mMovies.add(new Movie("The Sound of Music", "musical",
                "http://www.imdb.com/title/tt0059742/",0.0f,false));
        mMovies.add(new Movie("Back to the Future", "comedy",
                "http://www.imdb.com/title/tt0088763/",0.0f,false));
        mMovies.add(new Movie("The Shining", "horror",
                "http://www.imdb.com/title/tt0081505/",0.0f,false));
    }

    public static MovieList get(){
        if (sMovieList == null) {
            sMovieList = new MovieList();
        }
        return sMovieList;
    }

    public ArrayList<Movie> getMovies() {
        return mMovies;
    }
}
