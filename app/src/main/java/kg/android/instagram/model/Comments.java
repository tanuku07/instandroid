package kg.android.instagram.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Comments {

    @Expose
    private int count;
    @Expose
    private List<Comment> data = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Comment> getData() {
        return data;
    }

    public void setData(List<Comment> data) {
        this.data = data;
    }

}
