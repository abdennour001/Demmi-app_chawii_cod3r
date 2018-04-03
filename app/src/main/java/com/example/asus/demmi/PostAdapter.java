package com.example.asus.demmi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;

/**
 * Created by asus on 12/03/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;
    private List<Post>  postList;
    private final static Date postDate = new Date();

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Views declarations.
        public List<TextView> tagList=new ArrayList<>();
        public TextView userImage, userName, location, postTime, postContent, tag, contactButton, shareButton, tag0, tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9;
        public ImageView star1, star2, star3, star4,star5;
        public List<ImageView> starList=new ArrayList<>();
        public FlexboxLayout tagsContainer;

        @SuppressLint("CutPasteId")
        public ViewHolder(View itemView) {
            super(itemView);

            /*** ID flow control 'post_card' **/

            // Views id combinations.
            userImage = (TextView) itemView.findViewById(R.id.image_name);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            location = (TextView) itemView.findViewById(R.id.location);
            postTime = (TextView) itemView.findViewById(R.id.post_time);
            postContent = (TextView) itemView.findViewById(R.id.post_content);
            contactButton = (TextView) itemView.findViewById(R.id.contact_button);
            shareButton = (TextView) itemView.findViewById(R.id.share_button);
            tagsContainer = (FlexboxLayout) itemView.findViewById(R.id.tags_container);

            // Stars.
            star1 = itemView.findViewById(R.id.star1);
            star2 = itemView.findViewById(R.id.star2);
            star3 = itemView.findViewById(R.id.star3);
            star4 = itemView.findViewById(R.id.star4);
            star5 = itemView.findViewById(R.id.star5);

            starList.add(star1);
            starList.add(star2);
            starList.add(star3);
            starList.add(star4);
            starList.add(star5);

            // Tags.
            tag0 = (TextView) itemView.findViewById(R.id.tag0);
            tag1 = (TextView) itemView.findViewById(R.id.tag1);
            tag2 = (TextView) itemView.findViewById(R.id.tag2);
            tag3 = (TextView) itemView.findViewById(R.id.tag3);
            tag4 = (TextView) itemView.findViewById(R.id.tag4);
            tag5 = (TextView) itemView.findViewById(R.id.tag5);
            tag6 = (TextView) itemView.findViewById(R.id.tag6);
            tag7 = (TextView) itemView.findViewById(R.id.tag7);
            tag8 = (TextView) itemView.findViewById(R.id.tag8);
            tag9 = (TextView) itemView.findViewById(R.id.tag9);

            tagList.add(tag0);
            tagList.add(tag1);
            tagList.add(tag2);
            tagList.add(tag3);
            tagList.add(tag4);
            tagList.add(tag5);
            tagList.add(tag6);
            tagList.add(tag7);
            tagList.add(tag8);
            tagList.add(tag9);

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("ASSERT", "onCreateViewHolder");
        /* get Date and Time. */
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        /* ***************** */
        // Here is all the post controls
        Post post= postList.get(position);
        holder.userName.setText(post.getContactElements().getUser().getFamilyName() + " " + post.getContactElements().getUser().getFirstName());
        holder.userImage.setText(post.getContactElements().getUser().getFamilyName().charAt(0) + " " + post.getContactElements().getUser().getFirstName().charAt(0));
        holder.postContent.setText(post.getPostText());
        holder.location.setText(Wilaya.valueOf(post.getContactElements().getUser().getWilaya())+ " - " + post.getContactElements().getUser().getRegion());
        //holder.postTime.setText("• " + compareDate(post.getPostDate(), date));
        holder.postTime.setText("• " + compareDate(postDate, date));
        for (int i=0; i<5; i++) {
            if(i < post.getImportance()) {
                holder.starList.get(i).setImageResource(R.drawable.ic_star_green_24dp);
            } else {
                holder.starList.get(i).setImageResource(R.drawable.ic_star_border_green_24dp);
            }
        }
        if (post.getImportance() - (int)post.getImportance() != 0) {
            holder.starList.get((int)post.getImportance()).setImageResource(R.drawable.ic_star_half_green_24dp);
        }
        int i = 0;
        for (PostTag tag:
             post.getPostTags()) {
            holder.tagList.get(i).setText(tag.getTag());
            holder.tagList.get(i).setVisibility(View.VISIBLE);
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public String compareDate(Date date1, Date date2) {

        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date1String = dateFormat.format(date1);
        String date2String = dateFormat.format(date2);

        String[] date1List = date1String.split(" ");
        String[] date2List = date2String.split(" ");

        String date1Date = date1List[0];
        String date1Time = date1List[1];

        String date2Date = date2List[0];
        String date2Time = date2List[1];

        String date1Year = date1Date.split("-")[0];
        String date1Month = date1Date.split("-")[1];
        String date1Day = date1Date.split("-")[2];
        String date1Hour = date1Time.split(":")[0];
        String date1Min = date1Time.split(":")[1];

        String date2Year = date2Date.split("-")[0];
        String date2Month = date2Date.split("-")[1];
        String date2Day = date2Date.split("-")[2];
        String date2Hour = date2Time.split(":")[0];
        String date2Min = date2Time.split(":")[1];

        int minBetween = Integer.valueOf(date2Min) - Integer.valueOf(date1Min);
        int hourBetween = Integer.valueOf(date1Hour) - Integer.valueOf(date2Hour);
        int dayBetween = Integer.valueOf(date1Day) - Integer.valueOf(date2Day);
        int monthBetween = Integer.valueOf(date1Month) - Integer.valueOf(date2Month);
        int yearBetween = Integer.valueOf(date1Year) - Integer.valueOf(date2Year);

        if(yearBetween != 0) {
            return "قبل " + String.valueOf(yearBetween) + " سنة";
        } else if (monthBetween != 0) {
            return "قبل " + String.valueOf(monthBetween) + " شهر";
        } else if (dayBetween != 0) {
            switch (dayBetween) {
                case 1:
                    return " قبل يوم";
                case 2:
                    return "قبل يومين";
                default:
                    if (dayBetween <= 10) {
                        return "قبل " + String.valueOf(dayBetween) + " أيام";
                    } else {
                        return "قبل " + String.valueOf(dayBetween) + " يوم";
                    }
            }
        } else if (hourBetween != 0) {
            switch (hourBetween) {
                case 1:
                    return " قبل ساعة";
                case 2:
                    return "قبل ساعتين";
                default:
                    if (hourBetween <= 10) {
                        return "قبل " + String.valueOf(hourBetween) + " ساعات";
                    } else {
                        return "قبل " + String.valueOf(hourBetween) + " ساعة";
                    }
            }
        } else if(minBetween != 0) {
            switch (minBetween) {
                case 1:
                    return " قبل دقيقة";
                case 2:
                    return "قبل دقيقتين";
                default:
                    if (minBetween <= 10) {
                        return "قبل " + String.valueOf(minBetween) + " دقائق";
                    } else {
                        return "قبل " + String.valueOf(minBetween) + " دقيقة";
                    }
            }
        } else {
            return "قبل أقل من دقيقة";
        }
    }
}
