package example.com.replacefragments_onitemclick.fragments;


import android.support.v4.app.FragmentManager;

public interface FragmentChangeListener {
    void onFragmentChange(final FragmentChangeEvent fragmentChangeEvent, final FragmentManager fragmentManager);
}
