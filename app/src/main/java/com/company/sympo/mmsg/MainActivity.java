package com.company.sympo.mmsg;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    TextView toolbarHomeText, scrollableview;
    AssetManager am;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.example_color));*/

        ToolBarTextInitilizer("Home");


        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menu_home:
                     //   Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("Home");
                        home_content_fragment fragment = new home_content_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, fragment);
                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.menu_about_ghanerao:
                     //   Toast.makeText(getApplicationContext(), "About Ghanerao", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("About Ghanerao");
                       /* about_ghanerao_content_fragment fragment1 = new about_ghanerao_content_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame, fragment1);
                        fragmentTransaction1.commit();*/

                        About_Ghanerao_frag fragment1 = new About_Ghanerao_frag();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame, fragment1);
                        fragmentTransaction1.commit();

                        return true;
                    case R.id.menu_about_comittee:
                       // Toast.makeText(getApplicationContext(), "About Comittee", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("About Comittee");
                        about_comittee_fragment fragment2 = new about_comittee_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.frame, fragment2);
                        fragmentTransaction2.commit();
                        return true;
                    case R.id.menu_past_comittee:
                        //Toast.makeText(getApplicationContext(), "Past Comittee", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("Past Comittee");
                        about_ghanerao_content_fragment fragment3 = new about_ghanerao_content_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.frame, fragment3);
                        fragmentTransaction3.commit();
                        return true;
                    case R.id.menu_rrent_comi:
                       // Toast.makeText(getApplicationContext(), "Current Comittee", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("Current Comittee");
                        about_ghanerao_content_fragment fragment4 = new about_ghanerao_content_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.frame, fragment4);
                        fragmentTransaction4.commit();
                        return true;
                    case R.id.menu_feedback:
                       // Toast.makeText(getApplicationContext(), "FeedBack", Toast.LENGTH_SHORT).show();
                        ToolBarTextInitilizer("FeedBack");
                        feedback_fragment fragment5 = new feedback_fragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.frame, fragment5);
                        fragmentTransaction5.commit();

                        return true;

                    default:
                        //Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        home_content_fragment fragment = new home_content_fragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    /**
     * Used for setting header with font
     *
     * @param text
     */
    public void ToolBarTextInitilizer(String text) {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbarHomeText = (TextView) toolbar.findViewById(R.id.toolbarHomeText);
        am = MainActivity.this.getApplicationContext().getAssets();
        //typeface= Typeface.createFromAsset(getAssets(),"PRISTINA.TTF");
        toolbarHomeText.setText(text);
        toolbarHomeText.setTypeface(typeface);

    }


}
