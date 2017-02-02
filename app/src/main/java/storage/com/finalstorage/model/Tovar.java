package storage.com.finalstorage.model;

/**
 * Created by vamsi on 18-Jul-16.
 */

public class Tovar {

    public String movieName;
    public String moviePoster;

    public Tovar() {
    }

    public Tovar(String movieName, String moviePoster) {
        this.movieName = movieName;
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
