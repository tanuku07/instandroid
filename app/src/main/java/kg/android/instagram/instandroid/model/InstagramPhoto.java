package kg.android.instagram.instandroid.model;

import java.io.Serializable;
import java.util.ArrayList;

import kg.android.instagram.instandroid.model.Comment;

public class InstagramPhoto implements Serializable{
    public String username;
    public String caption;
    public String imageURL;
    public String avatarURL;
    public int likesCount;

    public ArrayList<Comment> comment_list;
}

