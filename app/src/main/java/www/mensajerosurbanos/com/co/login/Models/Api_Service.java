package www.mensajerosurbanos.com.co.login.Models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Service {

    @GET("/2.0/?method=tag.gettopartists&tag=disco&api_key=9c3a5715ea0419dea0015d769ba1e254&format=json")
    Call<Topartists> getAllArtists();
}
