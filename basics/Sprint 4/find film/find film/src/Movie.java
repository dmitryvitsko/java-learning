import java.util.Objects;

public class Movie {
    String title;
    int releaseYear;

    public String description() {
        return '"' + title + "\" (" + releaseYear + " год)";
    }

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Movie movie = (Movie) obj;
        return Objects.equals(title, movie.title) && Objects.equals(releaseYear, movie.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear);
    }
}