package com.example.asus.demmi;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.clans.fab.FloatingActionMenu;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by asus on 27/12/2017.
 */

public class HomeController extends Fragment {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList;
    private LinearLayout upperLayout;

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
        return inflater.inflate(R.layout.home_layout, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        upperLayout = getView().findViewById(R.id.upper_layout);

        /** Posts Adapter **/

        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        postList = new ArrayList<>();
        adapter = new PostAdapter(this.getContext(), postList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        preparePosts();

        /****/

        materialDesignFAM = (FloatingActionMenu) getView().findViewById(R.id.add_something);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item3);

        materialDesignFAM.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {

                if(opened) upperLayout.setBackgroundColor(getResources().getColor(R.color.colorOver));
                else upperLayout.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
            }
        });

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

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

    private void preparePosts() {

        Post post1= new Post();
        Post post2= new Post();
        Post post3= new Post();

        // Post 1 configuration
        post1.setPostText("السلام عليكم و رحمة الله أنا أود أن أقدم هذا البلاغ المستعجل عن حاجة ماسة إلى وحدات دم و الحالة حرجة جدا و ذلك في المستشفى الجامعي بباتنة ساعدونا و أجركم على الله.");
        post1.setPostDate(new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime());
        post1.addTag(new PostTag("طلب تبرع بالدم"));
        post1.addTag(new PostTag("A -"));
        post1.addTag(new PostTag("O +"));
        post1.addBloodType(BloodType.ANEGATIVE);
        post1.addBloodType(BloodType.OPOSITIVE);
        /* Contact of post 1*/
        Contact contact1 =new Contact();
        contact1.setUser(new User(1, "password", "بين 18 و 25", "amokranabdennour@gmail.com",
                "عبد النور", "أمقران", BloodType.ANEGATIVE, Wilaya.BATNA, "تازولت", "0797417330"));
        post1.setContactElements(contact1);
        // ###############

        // Post 2 configuration
        post2.setPostText("السلام عليكم و رحمة الله تعالى و بركاته لقد تم تحديد موعد حملة تبرع بالدم في مدينة الشلف و ذلك لفائدة عدة مستشفيات و عيادات في المنطقة و على هذا الأساس نحن نرجوا منكم أن تكونوا في الموعد و أن تساعدونا على إنقاذ الكثير من الأرواح فقطرة من دمكم قد تساوي حياة إنسان.");
        post2.setPostDate(new GregorianCalendar(2018, Calendar.FEBRUARY, 12).getTime());
        post2.addTag(new PostTag("مهم جدا"));
        post2.addTag(new PostTag("طلب تبرع بالدم"));
        post2.addTag(new PostTag("A"));
        post2.addTag(new PostTag("B"));
        post2.addTag(new PostTag("AB"));
        post2.addTag(new PostTag("O"));
        post2.addBloodType(BloodType.NONE);
        /* Contact of post 2 */
        Contact contact2 =new Contact();
        contact2.setUser(new User(2, "password", "بين 18 و 25", "chohra@gmail.com",
                "شهرة محمد ع.المالك", "أمقران", BloodType.APOSITIVE, Wilaya.CHLEF, "الآغا", "0661414530"));
        post2.setContactElements(contact2);
        // ###############

        adapter.notifyDataSetChanged();
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}