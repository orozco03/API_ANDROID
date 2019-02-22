package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class ListArtistas {

    @SerializedName("artist")
    Artists [] artists;

    @SerializedName("@attr")
    Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public ListArtistas(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Artists[] getArtists() {
        return artists;
    }

    public void setArtists(Artists[] artists) {
        this.artists = artists;
    }
}
