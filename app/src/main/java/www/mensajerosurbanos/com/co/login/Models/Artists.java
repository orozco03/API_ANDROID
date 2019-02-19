package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class Artists {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("image")
    Image [] listaImg;

    public Image[] getListaImg() {
        return listaImg;
    }

    public void setListaImg(Image[] listaImg) {
        this.listaImg = listaImg;
    }

    public Artists(Image[] listaImg) {

        this.listaImg = listaImg;
    }

    public Artists(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
