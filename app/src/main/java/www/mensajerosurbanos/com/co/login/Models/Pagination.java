package www.mensajerosurbanos.com.co.login.Models;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("page")
    private int page;

    @SerializedName("perPage")
    private int perPage;

    @SerializedName("totalPages")
    private int totalPages;

    @SerializedName("total")
    private int total;

    public Pagination(int page, int perPage, int totalPages, int total) {
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
