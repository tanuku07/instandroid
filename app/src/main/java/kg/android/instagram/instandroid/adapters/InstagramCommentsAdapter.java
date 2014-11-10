package kg.android.instagram.instandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kg.android.instagram.instandroid.R;
import kg.android.instagram.instandroid.model.Comment;

public class InstagramCommentsAdapter  extends ArrayAdapter<Comment> {

    public InstagramCommentsAdapter(Context context, List<Comment> comments) {
        super(context, android.R.layout.simple_list_item_1, comments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_comment, parent, false);
        }

        ImageView avatarPhoto = (ImageView) convertView.findViewById(R.id.userAvatarImageView);
        TextView usernameTextView = (TextView) convertView.findViewById(R.id.comentatorTextView);
        TextView commentTextView = (TextView) convertView.findViewById(R.id.commentTextView);

        avatarPhoto.setImageResource(0);

        Picasso.with(getContext()).load(comment.avatarURL).into(avatarPhoto);

        usernameTextView.setText(comment.username);

        commentTextView.setText(comment.comment);

        return convertView;
    }
}

