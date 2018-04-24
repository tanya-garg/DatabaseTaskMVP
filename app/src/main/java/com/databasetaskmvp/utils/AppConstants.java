package com.databasetaskmvp.utils;

/**
 * Created by appinventiv on 21/4/18.
 */

public class AppConstants {

    public final static int UPDATING_INSTITUTE_CODE = 200;

    // Database name
    public final static String DATABASE_NAME = "instituteDatabase";
    public final static int DATABASE_VERSION = 1;

    //Table name
    public final static String TABLE_NAME = "instituteDetails";

    // Columns name
    public final static String ID = "id";
    public final static String INSTITUTE_NAME = "instituteName";
    public final static String INSTITUTE_ADDRESS = "instituteAddress";
    public final static String INSTITUTE_DESCRIPTION = "instituteDescription";
    public final static String INSTITUTE_PHONE = "institutePhone";
    public final static String INSTITUTE_EMAIL = "instituteEmail";
    public final static String INSTITUTE_COURSES = "instituteCourses";

    //Creating institute table.
    final public static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + INSTITUTE_NAME + " TEXT,"
            + INSTITUTE_ADDRESS + " TEXT,"
            + INSTITUTE_DESCRIPTION + " TEXT,"
            + INSTITUTE_PHONE + " TEXT,"
            + INSTITUTE_EMAIL + " TEXT,"
            + INSTITUTE_COURSES + " TEXT"
            + ")";

    //Deleting Table
    final public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    //Getting all contacts from Table
    final public static String GET_ALL_INSTITUTES = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
            ID + " DESC";
}
