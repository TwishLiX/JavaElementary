package comparator;

import java.util.Comparator;

public class Movie {
    private final String title;
    private final String director;
    private final int year;
    private final long boxOffice;
    private final short mark;

    public Movie(String title, String director, int year, long boxOffice, short mark) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.boxOffice = boxOffice;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public long getBoxOffice() {
        return boxOffice;
    }

    public short getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + title + '\'' +
                ", Director='" + director + '\'' +
                ", Year=" + year +
                ", Box office=" + boxOffice +
                ", Mark=" + mark +
                '}';
    }

    public static final Comparator<Movie> compareByTitle = (movie1, movie2) -> {
        if (movie1.getTitle().equals(movie2.getTitle())) {
            return movie1.getYear() - movie2.getYear();
        }
        else {
            return movie1.getTitle().compareTo(movie2.getTitle());
        }
    };

    public static final Comparator<Movie> compareByYear = (movie1, movie2) -> {
        if (movie1.getYear() == movie2.getYear()) {
            return movie1.getTitle().compareTo(movie2.getTitle());
        }
        else {
            return movie1.getYear() - movie2.getYear();
        }
    };

    public static final Comparator<Movie> compareByBoxOffice = (movie1, movie2) -> {
        if (movie1.getBoxOffice() == movie2.getBoxOffice()) {
            if (movie1.getTitle().equals(movie2.getTitle())) {
                return movie1.getYear() - movie2.getYear();
            }
            else {
                return movie1.getTitle().compareTo(movie2.getTitle());
            }
        }
        else {
            return (int) (movie1.getBoxOffice() - movie2.getBoxOffice());
        }
    };

    public static final Comparator<Movie> compareByMark = (movie1, movie2) -> {
        if (movie1.getMark() == movie2.getMark()) {
            if (movie1.getTitle().equals(movie2.getTitle())) {
                return movie1.getYear() - movie2.getYear();
            }
            else {
                return movie1.getTitle().compareTo(movie2.getTitle());
            }
        }
        else {
            return movie1.getMark() - movie2.getMark();
        }
    };
}
