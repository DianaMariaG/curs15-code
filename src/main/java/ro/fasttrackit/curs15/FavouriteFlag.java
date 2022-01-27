package ro.fasttrackit.curs15;

import java.util.Objects;

public class FavouriteFlag {
    private boolean favourite;

    public FavouriteFlag() {
        this.favourite = false;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavouriteFlag that = (FavouriteFlag) o;
        return favourite == that.favourite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favourite);
    }

    @Override
    public String toString() {
        return String.valueOf(favourite);
    }
}
