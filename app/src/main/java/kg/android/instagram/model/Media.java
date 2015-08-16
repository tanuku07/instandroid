package kg.android.instagram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Media {

    @Expose
    private Object attribution;
    @Expose
    private List<String> tags = new ArrayList<>();
    @Expose
    private String type;
    @Expose
    private Location location;
    @Expose
    private Comments comments;
    @Expose
    private String filter;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @Expose
    private String link;
    @Expose
    private Likes likes;
    @Expose
    private Images images;
    @SerializedName("users_in_photo")
    @Expose
    private List<UsersInPhoto> usersInPhoto = new ArrayList<>();
    @Expose
    private Caption caption;
    @SerializedName("user_has_liked")
    @Expose
    private boolean userHasLiked;
    @Expose
    private String id;
    @Expose
    private User user;

    public Object getAttribution() {
        return attribution;
    }

    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public List<UsersInPhoto> getUsersInPhoto() {
        return usersInPhoto;
    }

    public void setUsersInPhoto(List<UsersInPhoto> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
    }

    public Object getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public boolean isUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
