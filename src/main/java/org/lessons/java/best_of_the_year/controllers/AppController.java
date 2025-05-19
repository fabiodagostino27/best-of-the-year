package org.lessons.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class AppController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("moviesList", this.getMoviesToString(getBestMovies()));
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songsList", this.getSongsToString(getBestSongs()));
        return "songs";
    }
    

    private List<Movie> getBestMovies() {
        List<Movie> moviesList = new ArrayList<>();

        moviesList.add(new Movie(1, "The Godfather"));
        moviesList.add(new Movie(2, "Pulp Fiction"));
        moviesList.add(new Movie(3, "The Dark Knight"));
        moviesList.add(new Movie(4, "Inception"));
        moviesList.add(new Movie(5, "Fight Club"));

        return moviesList;
    }

    private List<Song> getBestSongs() {
        List<Song> songsList = new ArrayList<>();

        songsList.add(new Song(1, "Bohemian Rhapsody"));
        songsList.add(new Song(2, "Stairway to Heaven"));
        songsList.add(new Song(3, "Hotel California"));
        songsList.add(new Song(4, "Imagine"));
        songsList.add(new Song(5, "Smells Like Teen Spirit"));

        return songsList;
    }

    private String getMoviesToString(List<Movie> moviesList) {
        String moviesString = "";
        for (int i = 0; i < moviesList.size(); i++) {
            moviesString += moviesList.get(i).getName();

            if (i < moviesList.size() - 1) {
                moviesString += ", ";
            }
        }

        return moviesString;
    }

    private String getSongsToString(List<Song> songsList) {
        String songsString = "";
        for (int i = 0; i < songsList.size(); i++) {
            songsString += songsList.get(i).getName();

            if (i < songsList.size() - 1) {
                songsString += ", ";
            }
        }

        return songsString;
    }
}
