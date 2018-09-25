package entities;

public class photo {
    private int idAlbum;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
     public photo(int idAlbum, int id, String title, String url, String thumbnailUrl){
         this.idAlbum=idAlbum;
         this.id=id;
         this.title=title;
         this.url=url;
         this.thumbnailUrl=thumbnailUrl;
     }
}
