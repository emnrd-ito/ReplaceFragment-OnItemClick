package example.com.replacefragments_onitemclick.model;

import android.os.Parcel;
import android.os.Parcelable;

public class EmployeeListRestrictionsParcelable implements Parcelable {

//    public final static String RESTRICT_BY_NONE = "None"; // No restrictions, i.e. all employees
//    public final static String RESTRICT_BY_LOCATION = "Location";
//    public final static String RESTRICT_BY_DIVISION = "Division";
//    public final static String RESTRICT_BY_LOCATION_AND_DIVISION = "LocationAndDivision";

    public final static String BUNDLE_KEY = "EmployeeListRestrictionsParcelable";
//    public final static String BUNDLE_KEY_LOCATION = "Location";
//    public final static String BUNDLE_KEY__DIVISION = "Division";

//    private Boolean restrictByNone;
//    private Boolean restrictByLocation;
//    private Boolean restrictByDivision;
//    private Boolean restrictByLocationAndDivision;

    // if location and division are "", then display all
    private String location;
    private String division;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeValue(this.restrictByNone);
//        dest.writeValue(this.restrictByLocation);
//        dest.writeValue(this.restrictByDivision);
//        dest.writeValue(this.restrictByLocationAndDivision);

        dest.writeString(this.location);
        dest.writeString(this.division);
    }

    public EmployeeListRestrictionsParcelable() {
        location = "";
        division = "";
    }

    protected EmployeeListRestrictionsParcelable(Parcel in) {

        // class loader parameter not needed for Boolean
//        this.restrictByNone = (Boolean) in.readValue(null);
//        this.restrictByLocation = (Boolean) in.readValue(null);
//        this.restrictByDivision = (Boolean) in.readValue(null);
//        this.restrictByLocationAndDivision = (Boolean) in.readValue(null);

        this.location = in.readString();
        this.division = in.readString();
    }

    public static final Creator<EmployeeListRestrictionsParcelable> CREATOR = new Creator<EmployeeListRestrictionsParcelable>() {
        @Override
        public EmployeeListRestrictionsParcelable createFromParcel(Parcel source) {
            return new EmployeeListRestrictionsParcelable(source);
        }

        @Override
        public EmployeeListRestrictionsParcelable[] newArray(int size) {
            return new EmployeeListRestrictionsParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
