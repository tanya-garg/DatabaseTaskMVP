package com.databasetaskmvp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.databasetaskmvp.pojo.InstituteModel;
import com.databasetaskmvp.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appinventiv on 21/4/18.
 */

public class InstituteDatabase extends SQLiteOpenHelper {


    public InstituteDatabase(Context context) {
        super(context, AppConstants.DATABASE_NAME, null, AppConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AppConstants.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Drop table if existed.
        sqLiteDatabase.execSQL(AppConstants.DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    /**
     * Adding institute info into database.
     */
    public long addInstitute(InstituteModel instituteModel) {

        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppConstants.INSTITUTE_NAME, instituteModel.getInstituteName());
        values.put(AppConstants.INSTITUTE_ADDRESS, instituteModel.getInstituteAddress());
        values.put(AppConstants.INSTITUTE_DESCRIPTION, instituteModel.getInstituteDescription());
        values.put(AppConstants.INSTITUTE_PHONE, instituteModel.getPhone());
        values.put(AppConstants.INSTITUTE_EMAIL, instituteModel.getEmail());
        values.put(AppConstants.INSTITUTE_COURSES, instituteModel.getCourses());

        // insert row
        long id = db.insert(AppConstants.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    /**
     * Method to update institute info.
     */
    public int updateInstituteInfo(InstituteModel instituteModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppConstants.INSTITUTE_NAME, instituteModel.getInstituteName());
        values.put(AppConstants.INSTITUTE_ADDRESS, instituteModel.getInstituteAddress());
        values.put(AppConstants.INSTITUTE_DESCRIPTION, instituteModel.getInstituteDescription());
        values.put(AppConstants.INSTITUTE_PHONE, instituteModel.getPhone());
        values.put(AppConstants.INSTITUTE_EMAIL, instituteModel.getEmail());
        values.put(AppConstants.INSTITUTE_COURSES, instituteModel.getCourses());

        return db.update(AppConstants.TABLE_NAME, values, AppConstants.ID + " = ?",
                new String[]{String.valueOf(instituteModel.getId())});
    }

    /**
     * Method to delete institute infos.
     */
    public void deleteInstitute(InstituteModel instituteModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AppConstants.TABLE_NAME, AppConstants.ID + " = ?",
                new String[]{String.valueOf(instituteModel.getId())});
        db.close();
    }

    /*
    * Getting all institutes list from database.
    * */
    public List<InstituteModel> getAllInstituteList() {
        List<InstituteModel> instituteModelList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(AppConstants.GET_ALL_INSTITUTES, null);
        if (cursor.moveToFirst()) {
            do {
                InstituteModel instituteModel = new InstituteModel();
                instituteModel.setId(cursor.getInt(cursor.getColumnIndex(AppConstants.ID)));
                instituteModel.setInstituteName(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_NAME)));
                instituteModel.setInstituteAddress(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_ADDRESS)));
                instituteModel.setInstituteDescription(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_DESCRIPTION)));
                instituteModel.setPhone(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_PHONE)));
                instituteModel.setEmail(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_EMAIL)));
                instituteModel.setCourses(cursor.getString(cursor.getColumnIndex(AppConstants.INSTITUTE_COURSES)));
                instituteModelList.add(instituteModel);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return instituteModelList;
    }
}
