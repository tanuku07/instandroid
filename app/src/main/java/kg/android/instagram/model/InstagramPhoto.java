package kg.android.instagram.model;

import java.io.Serializable;
import java.util.ArrayList;

public class InstagramPhoto implements Serializable{
    public String username;
    public String caption;
    public String imageURL;
    public String avatarURL;
    public int likesCount;

    public ArrayList<Comment> comment_list;
}

