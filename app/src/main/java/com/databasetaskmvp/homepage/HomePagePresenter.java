package com.databasetaskmvp.homepage;

import com.databasetaskmvp.base.BasePresenter;
import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

/**
 * Created by appinventiv on 20/4/18.
 */

public class HomePagePresenter extends BasePresenter<HomePageView> implements HomePageModelListener {


    private HomePageModel homePageModel;

    public HomePagePresenter(HomePageView view) {
        super(view);
    }

    @Override
    protected void setModel() {
        homePageModel = new HomePageModel(this);
    }

    @Override
    protected void destroy() {
        homePageModel.detachListener();
        homePageModel = null;
    }

    @Override
    protected void initView() {

    }

    /**
     * Method to get institute info from view and add to database.
     */
    void setInstituteModel(InstituteModel instituteModel) {
        homePageModel.addInstitute(instituteModel);
    }

    /**
     * Method to fetch institutes list from database.
     */
    void fetchInstitutes() {
        homePageModel.getInstitutes();
    }

    /**
     * Method to update institute .
     */
    void updateInstituteModel(InstituteModel instituteModel) {
        homePageModel.updateInstitute(instituteModel);
    }

    /**
     * Method to delete institute.
     * */
    void deleteInstitute(InstituteModel instituteModel){
        homePageModel.deleteInstitute(instituteModel);
    }

    @Override
    public void getInstitutesList(List<InstituteModel> modelList) {
        getView().getAllInstitutesList(modelList);
    }

    @Override
    public void isInstituteAdded(boolean success) {
        getView().isInstituteAdded(success);
    }

    @Override
    public void isInstituteUpdated(boolean isUpdated) {
        getView().isInstituteUpdated(isUpdated);
    }
}
