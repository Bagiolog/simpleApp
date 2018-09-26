package services;

import java.util.List;

import entities.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServices {
    @GET("/photos")
    Call<List<Photo>> getAllPhotos();
}
