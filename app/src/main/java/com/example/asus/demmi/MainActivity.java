package com.example.asus.demmi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView mTabBarTitle;
    private View tabHomeIconLayout;
    private View tabNotificationIconLayout;
    private View tabPersonIconLayout;

    private TextView notificationNumberControl;

    private int[] tabIcons = {
            R.drawable.ic_home_white_24dp,
            R.drawable.ic_notifications_white_24dp,
            R.drawable.ic_person_white_24dp,
    };

    private int[] tabIconsFocus = {
            R.drawable.ic_home_focus_24dp,
            R.drawable.ic_notifications_focus_24dp,
            R.drawable.ic_person_focus_24dp,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get the bar title.


        tabHomeIconLayout = getLayoutInflater().inflate(R.layout.custom_icon_home, null);
        tabNotificationIconLayout = getLayoutInflater().inflate(R.layout.custom_icon_notification, null);
        tabPersonIconLayout = getLayoutInflater().inflate(R.layout.custom_icon_person, null);

        notificationNumberControl = tabNotificationIconLayout.findViewById(R.id.notification_badge);

        mTabBarTitle = (TextView) findViewById(R.id.page_indicator);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorWhiteBackGround));
        tabSelectorController();

        // Set up the first focus tab icon
        setupTabIcons();
        switch(tabLayout.getSelectedTabPosition()) {
            case 0:
                tabHomeIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[0]);
                break;
            case 1:
                tabNotificationIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[1]);
                break;
            case 2:
                tabPersonIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[2]);
                break;
            default:
                break;
        }
    }

    /**
     * Tab selector controller (add events handlers to tab title and other buttons)
     * **/

    private void tabSelectorController() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tabLayout.getSelectedTabPosition()) {
                    case 0:
                        tabHomeIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[0]);
                        mTabBarTitle.setText("الصفحة الرئيسية");
                        break;
                    case 1:
                        tabNotificationIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[1]);
                        notificationNumberControl.setVisibility(View.GONE);
                        mTabBarTitle.setText("الإشعارات");
                        break;
                    case 2:
                        tabPersonIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIconsFocus[2]);
                        mTabBarTitle.setText("الملف الشخصي");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch(tabLayout.getSelectedTabPosition()) {
                    case 0:
                        tabHomeIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIcons[0]);
                        break;
                    case 1:
                        tabNotificationIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIcons[1]);
                        break;
                    case 2:
                        tabPersonIconLayout.findViewById(R.id.icon).setBackgroundResource(tabIcons[2]);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupTabIcons() {
        //tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        //tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        //tabLayout.getTabAt(2).setIcon(tabIcons[2]);

        tabHomeIconLayout.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_home_white_24dp);
        tabLayout.getTabAt(0).setCustomView(tabHomeIconLayout);

        tabNotificationIconLayout.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_notifications_white_24dp);
        tabLayout.getTabAt(1).setCustomView(tabNotificationIconLayout);

        tabPersonIconLayout.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_person_white_24dp);
        tabLayout.getTabAt(2).setCustomView(tabPersonIconLayout);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeController(), "");
        adapter.addFragment(new NotificationController(), "");
        adapter.addFragment(new ProfilController(), "");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
