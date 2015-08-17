package kg.android.instagram.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import kg.android.instagram.R;
import kg.android.instagram.model.Media;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {
    private List<Media> mediaList;
    private Context context;

    public MediaAdapter(Context context, List<Media> mediaList) {
        this.mediaList = mediaList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.media_item, viewGroup, false);
        return new MediaAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Media media = mediaList.get(position);
        Picasso.with(context).load(media.getImages().getLowResolution().getUrl()).into(viewHolder.ivFeedCenter);
        Picasso.with(context).load(media.getUser().getProfilePicture()).into(viewHolder.ivUserProfile);
        viewHolder.username.setText(media.getUser().getUsername());
        viewHolder.likesCount.setText(Integer.toString(media.getLikes().getCount()));
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ivFeedCenter)
        ImageView ivFeedCenter;
        @Bind(R.id.profile_image)
        ImageView ivUserProfile;
        @Bind(R.id.profile_name)
        TextView username;
        @Bind(R.id.tsLikesCounter)
        TextView likesCount;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
