package kg.android.instagram.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Likes {

    @Expose
    private int count;
    @Expose
    private List<User> data = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
