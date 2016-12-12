// Singleton
package example.com.replacefragments_onitemclick.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import example.com.replacefragments_onitemclick.model.EmployeeListRestrictionsParcelable;

public class FragmentChange implements FragmentChangeListener {

    private final String TAG = "FragmentChange";

    // all the possible fragments to display
    // note that 0 - 3 correspond to MainActivity.onNavigationDrawerItemSelected(int position)
    static final public int FRAGMENT_POP = -1;
    static final public int FRAGMENT_EMPLOYEE_LIST = 0;
    static final public int FRAGMENT_LOCATIONS_LIST = 1;
    static final public int FRAGMENT_DIVISIONS_LIST = 2;
    static final public int FRAGMENT_ABOUT = 3;
    static final public int FRAGMENT_DIVISIONS_LIST_FAN = 4;
    static final public int FRAGMENT_LOCATIONS_EMPLOYEE_LIST = 5;
    static final public int FRAGMENT_DIVISIONS_EMPLOYEE_LIST = 6;
    static final public int FRAGMENT_INDIVIDUAL = 7;
    //static final public int FRAGMENT_ROUTE = 7;

    private Stack<FragmentChangeEvent> fragmentStack = new Stack<>();

    private static FragmentChange instance;
    private int mPosition = 0;

    // constructor
    public FragmentChange() {
    }


    public static FragmentChange getInstance() {
        if (instance == null) {
            instance = new FragmentChange();
        }
        return instance;
    }

    @Override
    public void onFragmentChange(FragmentChangeEvent fragmentChangeEvent, final FragmentManager fragmentManager) {

        Bundle bundle = new Bundle();

        mPosition = fragmentChangeEvent.getPosition();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (mPosition) {
            case FRAGMENT_EMPLOYEE_LIST: // App start or from onNavigationDrawerItemSelected

                EmployeeListRestrictionsParcelable employeeListRestrictionsParcelable = new EmployeeListRestrictionsParcelable();
                employeeListRestrictionsParcelable.setLocation("");
                employeeListRestrictionsParcelable.setDivision("");

                EmployeesVerticalFragment fragment = new EmployeesVerticalFragment();

                fragmentTransaction.replace(example.com.replacefragments_onitemclick.R.id.container, fragment);
                fragmentStack.clear();  // start over with the stack at the All Employee list
                fragmentStack.push(fragmentChangeEvent);
                break;

            case FRAGMENT_INDIVIDUAL: // display an individual

                IndividualFragment individualFragment = new IndividualFragment();

                bundle = new Bundle();
                bundle.putParcelable(IndividualFragment.BUNDLE_KEY, fragmentChangeEvent.getEmployeeDataParcelable());
                individualFragment.setArguments(bundle);

                fragmentTransaction.replace(example.com.replacefragments_onitemclick.R.id.container, individualFragment);
                break;

            default:
                break; // do nothing
        }

        fragmentTransaction.commit(); // IllegalStateException:

    }

}
