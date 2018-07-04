package com.example.asus.demmi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 27/12/2017.
 */

public class HomeController extends Fragment {

    ListView postsList;
    ArrayList<Post> postArrayList = new ArrayList<>();
    PostsAdapter postsAdapter;

    User user;

    FloatingActionMenu materialDesignFAM;
    com.github.clans.fab.FloatingActionButton floatingActionButton1;
    com.github.clans.fab.FloatingActionButton floatingActionButton2;
    com.github.clans.fab.FloatingActionButton floatingActionButton3;

    public void HomeController(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.home_layout, container, false);

        if(getArguments() != null){
            user = (User) getArguments().getSerializable("user");
        }

        postsList = (ListView) rootView.findViewById(R.id.postsList);

        postsAdapter = new PostsAdapter(getContext(), postArrayList);
        postsList.setAdapter(postsAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        materialDesignFAM = (FloatingActionMenu) getView().findViewById(R.id.add_something);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Post post = new Post(user.getUserName(),user.getPhoneNumber(), user.getWilaya(), user.getRegion(),
                        "some text");
                postArrayList.add(post);
                postsAdapter.notifyDataSetChanged();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

            }
        });

    }

    public class PostsAdapter extends BaseAdapter{

        ArrayList<Post> postArrayList;
        private Context context;

        public PostsAdapter(Context context, ArrayList<Post> postArrayList){
            this.context = context;
            this.postArrayList = postArrayList;
        }

        @Override
        public int getCount() {
            return postArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return postArrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Post post = postArrayList.get(i);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.post_layout,null);

            TextView username = (TextView) view.findViewById(R.id.username);
            TextView userwilaya = (TextView) view.findViewById(R.id.userwilaya);
            TextView userregion = (TextView) view.findViewById(R.id.userregion);
            TextView body = (TextView) view.findViewById(R.id.body);
            TextView userphonenumber = (TextView) view.findViewById(R.id.userphonenumber);

            username.setText(post.getUserName());
            userwilaya.setText(post.getUserWilaya());
            userregion.setText(post.getUserRegion());
            userphonenumber.setText(post.getUserPhoneNumber());
            body.setText(post.getBody());

            return view;
        }
    }
}
