package example.com.replacefragments_onitemclick.fragments;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.replacefragments_onitemclick.R;
import example.com.replacefragments_onitemclick.adapters.EmployeesRecyclerAdapter;
import example.com.replacefragments_onitemclick.decoration.DividerDecoration;
import example.com.replacefragments_onitemclick.model.EmployeeListRestrictionsParcelable;

public class EmployeesVerticalFragment extends RecyclerFragment {

    private final String TAG = "EmployeesVerticalFrame";

    protected EmployeesRecyclerAdapter mAdapter;

    public EmployeesVerticalFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable =
                this.getArguments().getParcelable(EmployeeListRestrictionsParcelable.BUNDLE_KEY);

        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.section_list);

        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(getItemDecoration());

        mRecyclerView.getItemAnimator().setAddDuration(1000);
        mRecyclerView.getItemAnimator().setChangeDuration(1000);
        mRecyclerView.getItemAnimator().setMoveDuration(1000);
        mRecyclerView.getItemAnimator().setRemoveDuration(1000);

        mAdapter = getAdapter(); // EmployeesRecyclerAdapter

        mAdapter.addEmployeesToRowItems();

        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //Log.d(TAG, "mAdapter: " + mAdapter);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        // set title for action bar
        String title = getResources().getString(R.string.title_section1);
        String device_size = getResources().getString(R.string.device_size); // TODO remove for production
        actionBar.setTitle(title + " : " + device_size);

        return rootView;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected RecyclerView.ItemDecoration getItemDecoration() {
        //We must draw dividers ourselves if we want them in a list
        return new DividerDecoration(getActivity());
    }

    @Override
    protected int getDefaultItemCount() {
        return 100;
    }

    //    @Override
    protected EmployeesRecyclerAdapter getAdapter() {

        return new EmployeesRecyclerAdapter(getActivity());
    }
}
