package services;

import entities.Photo;
import entities.PhotoList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPhotoDataService {
    
    Call<PhotoList> getEmployeeData();


}
