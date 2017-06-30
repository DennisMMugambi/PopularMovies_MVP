package husaynhakeem.io.popularmovies.data;

import android.arch.persistence.room.Entity;
import android.content.ContentValues;
import android.net.Uri;

import husaynhakeem.io.popularmovies.models.Movie;

import static husaynhakeem.io.popularmovies.provider.MoviesContract.BASE_CONTENT_URI;
import static husaynhakeem.io.popularmovies.provider.MoviesContract.POPULAR_MOVIES_PATH;

/**
 * Created by husaynhakeem on 6/27/17.
 */

@Entity(tableName = "movie_popular")
public class PopularMovie extends Movie {

    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
            .appendPath(POPULAR_MOVIES_PATH)
            .build();

    public static final String TABLE_NAME = "movie_popular";

    public PopularMovie(ContentValues contentValues) {
        super(contentValues);
    }

    public static PopularMovie[] toMovies(ContentValues[] values) {

        if (values == null || values.length == 0)
            return null;

        PopularMovie[] movies = new PopularMovie[values.length];
        for (int i = 0; i < values.length; i++) {
            movies[i] = new PopularMovie(values[i]);
        }
        return movies;
    }
}
