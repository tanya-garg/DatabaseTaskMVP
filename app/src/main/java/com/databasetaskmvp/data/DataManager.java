package com.databasetaskmvp.data;


import com.databasetaskmvp.DatabaseTaskApplication;
import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

/**
 * Created by appinventiv on 27/3/18.
 */

public class DataManager implements IDataManager {


    private static DataManager instance;
    private static InstituteDatabase instituteDatabase;

    private DataManager() {
        instituteDatabase = DatabaseTaskApplication.instituteDatabase;
    }

    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null)
                    instance = new DataManager();
            }
        }
        return instance;
    }


    @Override
    public List<InstituteModel> getAllInstitutes() {
        return instituteDatabase.getAllInstituteList();
    }

    @Override
    public long addInstitute(InstituteModel instituteModel) {
        return instituteDatabase.addInstitute(instituteModel);
    }

    @Override
    public int updateInstituteData(InstituteModel instituteModel) {
        return instituteDatabase.updateInstituteInfo(instituteModel);
    }

    @Override
    public void deleteInstitute(InstituteModel instituteModel) {
        instituteDatabase.deleteInstitute(instituteModel);
    }


}
