package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    String text;

    @SerializedName("size")
    String size;

    Image [] listaImg;

    public Image(String text, String size, Image[] listaImg) {
        this.text = text;
        this.size = size;
        this.listaImg = listaImg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Image[] getListaImg() {
        return listaImg;
    }

    public void setListaImg(Image[] listaImg) {
        this.listaImg = listaImg;
    }
}
