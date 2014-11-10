package kg.android.instagram.instandroid.model;

import java.io.Serializable;

public class Comment implements Serializable {
    public String username;
    public String comment;
    public String avatarURL;

    public Comment (String user, String com,String url){
        this.comment = com;
        this.username = user;
        this.avatarURL = url;
    }

}
