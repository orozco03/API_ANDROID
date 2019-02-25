package www.mensajerosurbanos.com.co.login.Models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Service {

    //2.0/?method=tag.gettopartists&tag=disco&api_key=9c3a5715ea0419dea0015d769ba1e254&format=json&limit=9&page=

    @GET("/2.0/?method=tag.gettopartists&tag=disco&api_key=9c3a5715ea0419dea0015d769ba1e254&format=json&limit=10")
    Call<Topartists> getAllArtists(@Query("page") int page);
}
