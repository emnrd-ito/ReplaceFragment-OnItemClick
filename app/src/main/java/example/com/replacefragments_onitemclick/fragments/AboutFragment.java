package example.com.replacefragments_onitemclick.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.replacefragments_onitemclick.R;
import example.com.replacefragments_onitemclick.model.EmployeeDataParcelable;

public class AboutFragment extends Fragment {

    private String TAG = "AboutFragment";

    public AboutFragment () {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // set title for action bar
        ActionBar actionBar = ((AppCompatActivity)context).getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.title_section4));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        View view = inflater.inflate(R.layout.about, container, false);

        TextView textView = (TextView) view.findViewById(R.id.version_number);
        textView.setText("1.0.0");

        // dates

        textView = (TextView) view.findViewById(R.id.employees_download_date);
        textView.setText("01:01:01");

        textView = (TextView) view.findViewById(R.id.locations_download_date);
        textView.setText("02:02:02");

        textView = (TextView) view.findViewById(R.id.divisions_download_date);
        textView.setText("03:03:03");

        return view;
    }

}
