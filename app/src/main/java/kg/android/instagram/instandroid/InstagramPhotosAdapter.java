package kg.android.instagram.instandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> photos) {
        super(context, android.R.layout.simple_list_item_1, photos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        TextView captionTextView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imgPhoto = (ImageView) convertView.findViewById(R.id.imageView);

        captionTextView.setText(photo.caption);
        imgPhoto.getLayoutParams().height = photo.imageHeight;

        imgPhoto.setImageResource(0);

        Picasso.with(getContext()).load(photo.imageURL).into(imgPhoto);

        return convertView;
    }
}
