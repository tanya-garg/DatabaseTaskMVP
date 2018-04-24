package com.databasetaskmvp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by appinventiv on 21/4/18.
 */

public class InstituteModel implements Parcelable {
    private String instituteName, instituteAddress, instituteDescription, phone, email, courses;

    private int id;

    public InstituteModel() {

    }

    public InstituteModel(int id, String instituteName, String instituteAddress, String instituteDescription, String phone, String email, String courses) {
        this.id = id;
        this.instituteName = instituteName;
        this.instituteAddress = instituteAddress;
        this.instituteDescription = instituteDescription;
        this.phone = phone;
        this.email = email;
        this.courses = courses;
    }

    protected InstituteModel(Parcel in) {
        id = in.readInt();
        instituteName = in.readString();
        instituteAddress = in.readString();
        instituteDescription = in.readString();
        phone = in.readString();
        email = in.readString();
        courses = in.readString();
    }

    public static final Creator<InstituteModel> CREATOR = new Creator<InstituteModel>() {
        @Override
        public InstituteModel createFromParcel(Parcel in) {
            return new InstituteModel(in);
        }

        @Override
        public InstituteModel[] newArray(int size) {
            return new InstituteModel[size];
        }
    };


    public void setId(int id) {
        this.id = id;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public void setInstituteAddress(String instituteAddress) {
        this.instituteAddress = instituteAddress;
    }

    public void setInstituteDescription(String instituteDescription) {
        this.instituteDescription = instituteDescription;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getInstituteAddress() {
        return instituteAddress;
    }

    public String getInstituteDescription() {
        return instituteDescription;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCourses() {
        return courses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(instituteName);
        parcel.writeString(instituteAddress);
        parcel.writeString(instituteDescription);
        parcel.writeString(phone);
        parcel.writeString(email);
        parcel.writeString(courses);
    }
}

