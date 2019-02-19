package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class Topartists {

    @SerializedName("topartists")
    ListArtistas artists;

    public ListArtistas getArtists() {
        return artists;
    }

    public void setArtists(ListArtistas artists) {
        this.artists = artists;
    }
}
