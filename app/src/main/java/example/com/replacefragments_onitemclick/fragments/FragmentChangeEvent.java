package example.com.replacefragments_onitemclick.fragments;

import example.com.replacefragments_onitemclick.model.EmployeeDataParcelable;

import java.util.EventObject;

public class FragmentChangeEvent extends EventObject {

    private int position = 0;
    private EmployeeDataParcelable employeeDataParcelable;
    private String divisionName;
    private String locationName;
    private String version;

    public FragmentChangeEvent(Object source) {
        super(new Object()); // not using source
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public EmployeeDataParcelable getEmployeeDataParcelable() {
        return employeeDataParcelable;
    }

    public void setEmployeeDataParcelable(EmployeeDataParcelable employeeDataParcelable) {
        this.employeeDataParcelable = employeeDataParcelable;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
