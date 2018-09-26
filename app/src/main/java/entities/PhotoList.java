package entities;

import java.util.ArrayList;

public class PhotoList {

    private ArrayList<Photo> photoArrayList;

    public ArrayList<Photo>getPhotoArrayList(){
        return photoArrayList;
    }
    public void setPhotoArrayList(ArrayList<Photo> photoArrayList){
        this.photoArrayList=photoArrayList;
    }
}
