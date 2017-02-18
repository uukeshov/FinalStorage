package storage.com.finalstorage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import storage.com.finalstorage.R;
import storage.com.finalstorage.service.FirebaseHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener {

    private String mUsername;
    private String mPhotoUrl;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseHelper firebaseHelper = FirebaseHelper.getInstance();
    private List<String> ordersList = new ArrayList<>();

    ArrayAdapter<String> arrayAdapter;

    /**/
    static final String TAG = "myLogs";
    private ScaleAnimation shrinkAnim;
    private RecyclerView mRecyclerView;
    private GoogleApiClient client;
    private ProgressBar pb;
    private String query;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (mFirebaseUser == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CreateOrderActivity.class);
                startActivity(it);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //scale animation to shrink floating actionbar
        shrinkAnim = new ScaleAnimation(1.15f, 0f, 1.15f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

       /* mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        checkInternetConnection = new CheckInternetConnection();

        if (checkInternetConnection.hasConnection(this) == true) {
            final FirebaseRecyclerAdapter<Store, MovieViewHolder> adapter = new FirebaseRecyclerAdapter<Store, MovieViewHolder>(
                    Store.class,
                    R.layout.movie_board_item,
                    MovieViewHolder.class,
                    mDatabaseReference.child(Constants.ROOT_PATH).child(Constants.USERID).child("density").child(String.valueOf(getDensitydpi())).child(Constants.STORE_PATH).getRef()
            ) {
                @Override
                protected void populateViewHolder(final MovieViewHolder viewHolder, final Store store, int position) {
                    Boolean isValid = false;
                    if (searchType == Constants.SEARCH || query != null) {
                        isValid = SearchandSpllitter.splitter(store.getStoreTags(), query);
                    }

                    if (searchType == Constants.GET_ALL_CATALOGS) {
                        isValid = true;
                    }

                    if (searchType == Constants.GET_BY_STORE) {
                        isValid = storeType == store.getStoreType();
                    }

                    if (searchType == Constants.GET_BY_LIKE) {
                        catalogDB = new CatalogDB(MainActivity.this);
                        isValid = catalogDB.checkExisten(store.getStoreId());
                    }

                    if (isValid == true) {
                        viewHolder.getTvMovieName().setText(store.getMovieName());
                        Picasso.with(MainActivity.this).load(store.getMoviePoster()).into(viewHolder.getIvMoviePoster());
                        viewHolder.getIvMoviePoster().setVisibility(View.VISIBLE);
                        viewHolder.getTvMovieName().setVisibility(View.VISIBLE);
                        viewHolder.getCard_view().setVisibility(View.VISIBLE);
                        likeSingltone.addStore(store);
                        store.setPosition(position);

                        mRecyclerView.addOnItemTouchListener(
                                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        likeSingltone.setPos(position);
                                        Intent myIntent = new Intent(MainActivity.this, ViewPagerSampleActivity.class);
                                        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        MainActivity.this.startActivity(myIntent);
                                    }
                                })
                        );
                    }
                    pb.setVisibility(ProgressBar.INVISIBLE);
                }
            };
            mRecyclerView.setAdapter(adapter);
        }
        if (checkInternetConnection.hasConnection(this) == false) {
            Intent myIntent = new Intent(this, OnInternetConnectionFailedActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(myIntent);
            finish();
        }
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            //finish();
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, CreateOrderActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, ReportsActivity.class));
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            mFirebaseAuth.signOut();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}