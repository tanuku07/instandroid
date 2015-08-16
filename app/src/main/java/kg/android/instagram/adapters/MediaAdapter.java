package kg.android.instagram.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kg.android.instagram.R;
import kg.android.instagram.model.Media;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder>{
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
        viewHolder.title.setText(media.getCreatedTime());
        viewHolder.industry.setText(media.getId());
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView industry;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.vacancy_title);
            this.industry = (TextView) itemView.findViewById(R.id.vacancy_industry);
        }
    }

}
