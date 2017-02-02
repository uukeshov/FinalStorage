package storage.com.finalstorage.model;

/**
 * Created by uukeshov on 16.08.2016.
 */
public class StoreData {
    private Integer id;
    private String link;

    public StoreData() {
    }

    public StoreData(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StoreData(Integer id, String link) {
        this.id = id;
        this.link = link;
    }
}
