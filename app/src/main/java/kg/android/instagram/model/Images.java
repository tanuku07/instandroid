package kg.android.instagram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("low_resolution")
    @Expose
    private Image lowResolution;
    @Expose
    private Image thumbnail;
    @SerializedName("standard_resolution")
    @Expose
    private Image standardResolution;

    public Image getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(Image lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Image standardResolution) {
        this.standardResolution = standardResolution;
    }

}
