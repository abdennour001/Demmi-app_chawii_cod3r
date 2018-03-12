package com.example.asus.demmi;

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
import android.widget.EditText;
import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

/**
 * Created by asus on 27/12/2017.
 */

public class HomeController extends Fragment {

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        materialDesignFAM = (FloatingActionMenu) getView().findViewById(R.id.add_something);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) getView().findViewById(R.id.material_design_floating_action_menu_item3);

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
}
