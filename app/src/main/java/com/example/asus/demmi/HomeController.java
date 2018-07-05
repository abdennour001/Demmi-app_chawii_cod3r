package com.example.asus.demmi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by asus on 27/12/2017.
 */

public class HomeController extends Fragment {

    //The firebase authenticated user
    FirebaseUser currentUser;
    FirebaseAuth mAuth;
    DatabaseReference database;

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

        // Initializing the database reference.
        database = FirebaseDatabase.getInstance().getReference();

        // Check if user is signed in (non-null)
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        if(getArguments() != null){
            user = (User) getArguments().getSerializable("user");
        }

        postsList = (ListView) rootView.findViewById(R.id.postsList);

        postsAdapter = new PostsAdapter(getContext(), postArrayList);
        postsList.setAdapter(postsAdapter);

        database.child("Posts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postArrayList.clear();
                Iterator<DataSnapshot> i = dataSnapshot.getChildren().iterator();
                while(i.hasNext()){
                    Iterator<DataSnapshot> i2 = i.next().getChildren().iterator();
                    while(i2.hasNext()){
                        Post p = i2.next().getValue(Post.class);
                        postArrayList.add(p);
                    }
                }
                postsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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

                AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                b.setTitle("طلب جديد");

                LayoutInflater inflater = getLayoutInflater();
                View dialogLayout = inflater.inflate(R.layout.add_post, null);
                b.setView(dialogLayout);
                final EditText input = dialogLayout.findViewById(R.id.post_body);
                final Spinner blood = dialogLayout.findViewById(R.id.spinner2);
                final Spinner rhesus = dialogLayout.findViewById(R.id.spinner1);

                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Random r = new Random();
                        int i1 = r.nextInt(1000000000);

                        Post post = new Post(String.valueOf(i1), user.getUserName(),user.getPhoneNumber(), user.getWilaya(), user.getRegion(),
                                input.getText().toString(), String.valueOf(blood.getSelectedItem()),
                                String.valueOf(rhesus.getSelectedItem()));
                        postArrayList.add(post);
                        postsAdapter.notifyDataSetChanged();
                        database.child("Posts").child(currentUser.getUid()).child(post.getId()).setValue(post);

                    }
                });
                b.setNegativeButton("CANCEL", null);
                b.show();
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
            TextView blood = (TextView) view.findViewById(R.id.blood);
            TextView letters = (TextView) view.findViewById(R.id.user_letters);

            username.setText(post.getUserName());
            userwilaya.setText(post.getUserWilaya());
            userregion.setText(post.getUserRegion());
            userphonenumber.setText(post.getUserPhoneNumber());
            body.setText(post.getBody());
            blood.setText(post.getBlood()+" "+post.getRhesus());
            letters.setText(post.getUserName().split(" ")[0].substring(0,1)+post.getUserName().split(" ")[1].substring(0,1));

            return view;
        }
    }
}
