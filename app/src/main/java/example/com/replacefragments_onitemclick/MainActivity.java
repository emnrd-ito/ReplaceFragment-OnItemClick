package example.com.replacefragments_onitemclick;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import example.com.replacefragments_onitemclick.adapters.DrawerItemCustomAdapter;
import example.com.replacefragments_onitemclick.fragments.AboutFragment;
import example.com.replacefragments_onitemclick.fragments.EmployeesVerticalFragment;
import example.com.replacefragments_onitemclick.model.DataModel;
import example.com.replacefragments_onitemclick.model.EmployeeListRestrictionsParcelable;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    private AppCompatActivity mActivity;

    final int EMPLOYEES_POSITION = 0;
    final int ABOUT_POSITION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;

        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        final int NUMBER_OF_DRAWER_ITEMS = 2;
        DataModel[] drawerItem = new DataModel[NUMBER_OF_DRAWER_ITEMS];

        drawerItem[EMPLOYEES_POSITION] = new DataModel(R.drawable.ic_person, getResources().getString(R.string.drawer_title_employees));
        drawerItem[ABOUT_POSITION] = new DataModel(R.drawable.ic_building, getResources().getString(R.string.drawer_title_about));

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case EMPLOYEES_POSITION:
                fragment = new EmployeesVerticalFragment();
                EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable = new EmployeeListRestrictionsParcelable();
                employeeListRestrictionsParcelable.setLocation("");
                employeeListRestrictionsParcelable.setDivision("");
                Bundle bundle = new Bundle();
                bundle.putParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY, employeeListRestrictionsParcelable);
                fragment.setArguments(bundle);
                break;

            case ABOUT_POSITION:
                fragment = new AboutFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
}
