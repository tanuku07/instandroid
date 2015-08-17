package kg.android.instagram.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import kg.android.instagram.R;
import kg.android.instagram.model.Media;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {
    private List<Media> mediaList;

    public MediaAdapter(List<Media> mediaList) {
        this.mediaList = mediaList;
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
        viewHolder.ivFeedCenter.setImageURI(Uri.parse(media.getImages().getLowResolution().getUrl()));
        viewHolder.ivUserProfile.setImageURI(Uri.parse(media.getUser().getProfilePicture()));
        viewHolder.username.setText(media.getUser().getUsername());
        viewHolder.likesCount.setText(Integer.toString(media.getLikes().getCount()));
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ivFeedCenter)
        SimpleDraweeView ivFeedCenter;
        @Bind(R.id.profile_image)
        SimpleDraweeView ivUserProfile;
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
