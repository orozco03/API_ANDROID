package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class Topartists {

    @SerializedName("topartists")
    InfoTop infoTop;

    public InfoTop getInfoTop() {
        return infoTop;
    }

    public void setInfoTop(InfoTop infoTop) {
        this.infoTop = infoTop;
    }
}
