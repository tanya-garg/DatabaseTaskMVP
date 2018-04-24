package com.databasetaskmvp.homepage;

import com.databasetaskmvp.base.BaseModelListener;
import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

/**
 * Created by appinventiv on 20/4/18.
 */

public interface HomePageModelListener extends BaseModelListener {

    void getInstitutesList(List<InstituteModel> modelList);

    void isInstituteAdded(boolean success);

    void isInstituteUpdated(boolean isUpdated);

}
