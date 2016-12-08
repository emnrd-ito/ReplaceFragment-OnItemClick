package example.com.replacefragments_onitemclick.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import example.com.replacefragments_onitemclick.R;
import example.com.replacefragments_onitemclick.model.EmployeeDataParcelable;

public class IndividualFragment extends Fragment {

    private String TAG = "IndividualFragment";
    public static String BUNDLE_KEY = "EmployeeDataParcelable";


    private final int MAX_ZOOM_LEVEL = 18;
    private final int DEFAULT_ZOOM_LEVEL = 13;

    private static View view;

    public IndividualFragment () {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: " + savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        final EmployeeDataParcelable employeeDataParcelable = this.getArguments().getParcelable(BUNDLE_KEY);

        view = inflater.inflate(R.layout.individual, container, false);

        // determine division logo
        String division = employeeDataParcelable.getDivision();

        // text fields
        TextView textView = (TextView) view.findViewById(R.id.employee_name);
        textView.setText(employeeDataParcelable.getName());

        textView = (TextView) view.findViewById(R.id.division);
        textView.setText(division); //employeeDataParcelable.getDivision());

        textView = (TextView) view.findViewById(R.id.title);
        textView.setText(employeeDataParcelable.getTitle());

        textView = (TextView) view.findViewById(R.id.address);
        textView.setText(employeeDataParcelable.getAddress());

        textView = (TextView) view.findViewById(R.id.city_state);
        textView.setText(employeeDataParcelable.getCity());

        textView = (TextView) view.findViewById(R.id.phone_number);
        textView.setText(employeeDataParcelable.getPhone());

        textView = (TextView) view.findViewById(R.id.email);
        textView.setText(employeeDataParcelable.getEmailAddress());

        // image buttons
        ImageButton btnDirections = (ImageButton) view.findViewById(R.id.directions_image);
        btnDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnDirections:onClick()");
            }

        });

        ImageButton btnMessage = (ImageButton) view.findViewById(R.id.message_image);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnMessage:onClick()");
            }

        });

        ImageButton btnEmail = (ImageButton) view.findViewById(R.id.email_image);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnEmail:onClick()");
            }

        });

        ImageButton btnPhone = (ImageButton) view.findViewById(R.id.phone_image);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnPhone:onClick()");
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
