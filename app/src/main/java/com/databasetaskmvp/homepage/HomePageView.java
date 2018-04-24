package com.databasetaskmvp.homepage;

import com.databasetaskmvp.base.BaseView;
import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

/**
 * Created by appinventiv on 20/4/18.
 */

public interface HomePageView extends BaseView {

    void getAllInstitutesList(List<InstituteModel> modelList);
    void isInstituteAdded(boolean isAdded);
    void isInstituteUpdated(boolean isUpdated);
}
