package www.dm.com.Main_Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.dm.com.Main_Screen.Scenario_Previous_Analyzis.controller.previous_analyzis;
import www.dm.com.Main_Screen.Scenario_analyze.analyze;
import www.dm.com.Main_Screen.Scenario_messages.controller.messages;
import www.dm.com.Main_Screen.Scenario_profile_settings.profile_settings;
import www.dm.com.R;
import www.dm.com.utils.utils;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks, View.OnClickListener {
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    ImageView menu;
    Button analzing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //DEFINE VARS
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);
        menu = findViewById(R.id.menu);
        analzing = findViewById(R.id.analzing);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, drawer);

        //SET ON CLICK LISTNER
        menu.setOnClickListener(this);
        analzing.setOnClickListener(this);

        //ADD FRAGMENT TO MAIN PAGE ANALYZING
        new utils().Replace_Fragment(new analyze(),R.id.frag,this);

        //CALL BOTTOM NAVIGATION
        nav_bootom();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        if(position == 0)
        {
            new utils().Replace_Fragment(new previous_analyzis(),R.id.frag,this); //CALL PREVIOUS ANALZES FRAGMENT
        }
        else if(position == 1)
        {
            new utils().Replace_Fragment(new profile_settings(),R.id.frag,this); //CALL PREVIOUS PROFILE FRAGMENT
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mNavigationDrawerFragment.closeDrawer();
    }

    @Override
    public void onBackPressed() {

        if (mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.closeDrawer();
        } else {

            moveTaskToBack(true);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.menu) {
            mNavigationDrawerFragment.openDrawer(); //MENU OPEN DRAWER
        }
        else if(view.getId() == R.id.analzing)
        {
            //REPLACE HOME TO MAIN PAGE ANALYZING
            new utils().Replace_Fragment(new analyze(),R.id.frag,this);
        }
    }

    //**BOTTOM NAVIGATION
    private void nav_bootom() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home) {
                    new utils().Replace_Fragment(new analyze(),R.id.frag,MainActivity.this); //HOME FRAGMENT
                }
                else if (item.getItemId() == R.id.msg) {
                    new utils().Replace_Fragment(new messages(),R.id.frag,MainActivity.this); //HOME MESSAGES
                }
                else if (item.getItemId() == R.id.profile) {
                   new utils().Replace_Fragment(new profile_settings(),R.id.frag,MainActivity.this); //HOME MESSAGES
                }
                return true;
            }
        });
    }
}
