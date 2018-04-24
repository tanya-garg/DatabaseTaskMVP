package com.databasetaskmvp.data;


import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

/**
 * Created by appinventiv on 27/3/18.
 */

interface IDataManager {

    List<InstituteModel> getAllInstitutes();

    long addInstitute(InstituteModel instituteModel);

    int updateInstituteData(InstituteModel instituteModel);

    void deleteInstitute(InstituteModel instituteModel);
}