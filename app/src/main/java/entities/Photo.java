package entities;

public class Photo {
    private int idAlbum;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(int idAlbum, int id, String title, String url, String thumbnailUrl){
         this.idAlbum=idAlbum;
         this.id=id;
         this.title=title;
         this.url=url;
         this.thumbnailUrl=thumbnailUrl;
     }

    public void setIdAlbum(int IdAlbum){
        this.idAlbum=idAlbum;
    }
    public int getIdAlbum(){
        return idAlbum;
    }
    public void setid(int id){
        this.id=id;
    }
    public int getid(){
        return id;
    }
    public void setTitle(String title){ this.title=title; }
    public String getTitle(){
        return title;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl(){
        return url;
    }
    public void getThumbanailUrl(String thumbnailUrl){
        this.thumbnailUrl=thumbnailUrl;
    }
    public String getThumbanailUrl(){
        return thumbnailUrl;
    }


}
