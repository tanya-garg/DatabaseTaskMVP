package com.databasetaskmvp.homepage;

import com.databasetaskmvp.base.BaseModel;
import com.databasetaskmvp.pojo.InstituteModel;



public class HomePageModel extends BaseModel<HomePageModelListener> {

    public HomePageModel(HomePageModelListener listener) {
        super(listener);
    }

    @Override
    public void init() {

    }

    /**
     * Method to get institutes list from database.
     */
    void getInstitutes() {
        getListener().getInstitutesList(getDataManager().getAllInstitutes());
    }

    /**
     * Method to add institute into database.
     */
    void addInstitute(InstituteModel instituteModel) {
        if (getDataManager().addInstitute(instituteModel) != -1) {
            getListener().isInstituteAdded(true);
        } else {
            getListener().isInstituteAdded(false);
        }
    }

    /**
     * Method to update institute data.
     */
    void updateInstitute(InstituteModel instituteModel) {
        if (getDataManager().updateInstituteData(instituteModel) != -1) {
            getListener().isInstituteUpdated(true);
        }
        else {
            getListener().isInstituteUpdated(false);
        }
    }

    /**
     * Method to delete institute from database.
     */
    void deleteInstitute(InstituteModel instituteModel) {
        getDataManager().deleteInstitute(instituteModel);
    }
}
