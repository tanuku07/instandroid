package kg.android.instagram.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    @Expose
    private Pagination pagination;
    @Expose
    private Meta meta;
    @Expose
    private List<Media> data = new ArrayList<>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Media> getData() {
        return data;
    }

    public void setData(List<Media> data) {
        this.data = data;
    }

}
