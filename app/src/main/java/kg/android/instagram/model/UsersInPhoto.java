package kg.android.instagram.model;

import com.google.gson.annotations.Expose;

public class UsersInPhoto {

    @Expose
    private Position position;
    @Expose
    private User user;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
