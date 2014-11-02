package kg.android.instagram.instandroid;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> photos) {
        super(context, android.R.layout.simple_list_item_1, photos);
    }

}
