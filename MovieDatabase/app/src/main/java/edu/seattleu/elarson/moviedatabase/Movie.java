package edu.seattleu.elarson.moviedatabase;

public class Movie {

    private String mTitle;
    private String mGenre;
    private String mUrl;
    private Float mRating;
    private Boolean mWatched;

    public Movie(String title, String genre, String url, Float rating, boolean watched) {
        setTitle(title);
        setGenre(genre);
        setUrl(url);
        setRating(0.0f);
        setIsWatched(false);
    }

    public String getTitle() {
        return mTitle;
    }
    public String getGenre() {
        return mGenre;
    }
    public String getUrl() { return mUrl; }
    public Float getRating() { return mRating;}
    public Boolean getIsWatched() {
        return mWatched;
    }


    public void setTitle(String title) {
         mTitle = title;
    }
    public void setGenre(String genre) {
        mGenre = genre;
    }
    public void setUrl(String url) { mUrl = url; }
    public void setRating(Float rating) { mRating = rating; }
    public void setIsWatched(Boolean watched) { mWatched = watched; }
}
