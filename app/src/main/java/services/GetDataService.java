package services;

import java.util.List;

import entities.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("/photos")
    Call<List<Photo>> getAllPhotos(@Query("albumId") int album);
}
