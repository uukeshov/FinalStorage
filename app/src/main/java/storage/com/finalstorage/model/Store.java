package storage.com.finalstorage.model;

/**
 * Created by vamsi on 18-Jul-16.
 */

public class Store {

    private String movieName;
    private String moviePoster;
    private Integer storeId;
    private Integer pages;
    private Integer storeType;
    private String storeTags;
    private Integer position;
    private String storeJournalLink;


    public Store() {
    }

    public Store(String movieName, String moviePoster, Integer storeId, Integer pages, Integer storeType, String storeTags, Integer position, String storeJournalLink) {
        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.storeId = storeId;
        this.pages = pages;
        this.storeType = storeType;
        this.storeTags = storeTags;
        this.position = position;
        this.storeJournalLink = storeJournalLink;
    }

    public String getStoreJournalLink() {
        return storeJournalLink;
    }

    public void setStoreJournalLink(String storeJournalLink) {
        this.storeJournalLink = storeJournalLink;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getStoreTags() {
        return storeTags;
    }

    public void setStoreTags(String storeTags) {
        this.storeTags = storeTags;
    }
}
