package evicentemedina.esperpento;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.fragments.AllCommunitiesFragment;
import evicentemedina.esperpento.fragments.HomeFragment;
import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navHeaderUsername = headerView.findViewById(R.id.nav_header_username);

        String username = getIntent().getStringExtra("user"),
               userpass = getIntent().getStringExtra("pass");

        navHeaderUsername.setText(username);

        if(savedInstanceState == null){
            SharedPreferences sp = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("username", username);
            editor.putString("userpass", userpass);
            editor.apply();

            changeFragment(R.layout.fragment_home);
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_home) {
            changeFragment(R.layout.fragment_home);
        }else if(id == R.id.nav_my_communities) {

        }else if(id == R.id.nav_all_communities){
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlAllComm(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getInt("s") == 1){
                                Bundle args = new Bundle();
                                args.putString("json", response.getJSONArray("c").toString());
                                Fragment fragment = new AllCommunitiesFragment();
                                fragment.setArguments(args);
                                getFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.content_main, fragment)
                                        .commit();
                            }else
                                changeFragment(R.layout.fragment_all_communities);
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
            );
            VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }else if(id == R.id.nav_preferences) {

        }else if(id == R.id.nav_about) {

        }else if(id == R.id.nav_logout) {
            SharedPreferences sp = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(int layoutResource){
        Fragment fragment;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        switch(layoutResource){
            case R.layout.fragment_home:
                fragment = new HomeFragment();
                break;
            case R.layout.fragment_all_communities:
                fragment = new AllCommunitiesFragment();
                break;
            default:
                fragment = new HomeFragment();
        }
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();
    }
}
