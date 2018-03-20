package com.example.asus.demmi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by asus on 12/03/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;
    private List<Post>  postList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Views declarations.
        public TextView userImage, userName, location, postTime, postContent, tag, contactButton, shareButton;
        public FlexboxLayout tagsContainer;

        @SuppressLint("CutPasteId")
        public ViewHolder(View itemView) {
            super(itemView);

            /*** ID flow control 'post_card' **/

            // Views id combinations.
            userImage = (TextView) itemView.findViewById(R.id.image_name);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            location = (TextView) itemView.findViewById(R.id.location);
            postTime = (TextView) itemView.findViewById(R.id.post_content);
            postContent = (TextView) itemView.findViewById(R.id.post_content);
            tag = (TextView) itemView.findViewById(R.id.tag);
            contactButton = (TextView) itemView.findViewById(R.id.contact_button);
            shareButton = (TextView) itemView.findViewById(R.id.share_button);
            tagsContainer = (FlexboxLayout) itemView.findViewById(R.id.tags_container);


            /****/
        }
    }

    public PostAdapter(Context mContext, List<Post> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("ASSERT", "onCreateViewHolder");
        // Here is all the post controls

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
