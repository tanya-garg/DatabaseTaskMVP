package com.databasetaskmvp.homepage;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.databasetaskmvp.R;
import com.databasetaskmvp.adapters.InstituteAdapter;
import com.databasetaskmvp.addinstituteinfo.AddInstituteActivity;
import com.databasetaskmvp.base.BaseActivity;
import com.databasetaskmvp.interfaces.OnClickInterface;
import com.databasetaskmvp.pojo.InstituteModel;
import com.databasetaskmvp.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomePageView, OnClickInterface {

    @BindView(R.id.iv_search)
    AppCompatImageView ivSearch;
    @BindView(R.id.et_search)
    AppCompatEditText etSearch;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.rv_institutes)
    RecyclerView rvInstitutes;
    @BindView(R.id.fb_add)
    FloatingActionButton fbAdd;
    private List<InstituteModel> mInstituteModelList;
    private List<InstituteModel> mDuplicateList;
    private InstituteAdapter mInstituteAdapter;
    private HomePagePresenter homePagePresenter;
    private InstituteModel instituteModel;
    private int adapterPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initVariables();
    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_home;
    }
    /**
     * initializing variables.
     */
    private void initVariables() {
        mInstituteModelList = new ArrayList<>();
        mDuplicateList = new ArrayList<>();
        homePagePresenter = new HomePagePresenter(this);
        mInstituteAdapter = new InstituteAdapter(mInstituteModelList, mDuplicateList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvInstitutes.setLayoutManager(linearLayoutManager);
        rvInstitutes.setAdapter(mInstituteAdapter);
        homePagePresenter.fetchInstitutes();

        /*etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mInstituteAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }*/
        }

    @OnClick(R.id.fb_add)
    public void onViewClicked() {
        openInstituteInfoActivity(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK && data != null && data.getParcelableExtra("instituteData") != null) {
                    instituteModel = data.getParcelableExtra("instituteData");
                    homePagePresenter.setInstituteModel(instituteModel);
                } else if (resultCode == AppConstants.UPDATING_INSTITUTE_CODE && data != null && data.getParcelableExtra("instituteData") != null) {
                    instituteModel = data.getParcelableExtra("instituteData");
                    homePagePresenter.updateInstituteModel(instituteModel);
                }
                break;
        }
    }

    @Override
    public void getAllInstitutesList(List<InstituteModel> modelList) {
        mInstituteModelList.clear();
        mInstituteModelList.addAll(modelList);
        mDuplicateList.addAll(modelList);
        mInstituteAdapter.notifyDataSetChanged();
    }

    @Override
    public void isInstituteAdded(boolean isAdded) {
        if (isAdded) {
            mInstituteModelList.add(0, instituteModel);
            mDuplicateList.add(0, instituteModel);
            mInstituteAdapter.notifyItemInserted(0);

        } else {
            showToastLong(getString(R.string.failed_to_add_institute));
        }
    }

    @Override
    public void isInstituteUpdated(boolean isUpdated) {
        if (isUpdated) {
            mDuplicateList.set(mDuplicateList.indexOf(mInstituteModelList.get(adapterPosition)), instituteModel);
            mInstituteModelList.set(adapterPosition, instituteModel);
            mInstituteAdapter.notifyItemChanged(adapterPosition);
        } else {
            showToastLong(getString(R.string.failed_to_update));
        }
    }

    @Override
    public void onClick(final int position, final InstituteModel instituteModel) {
        adapterPosition = position;
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update_delete_info);
        dialog.setCancelable(true);
        AppCompatTextView updateTv = dialog.findViewById(R.id.tv_update);
        AppCompatTextView deleteTv = dialog.findViewById(R.id.tv_delete);
        updateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstituteInfoActivity(instituteModel);
                dialog.dismiss();
            }
        });
        deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePagePresenter.deleteInstitute(instituteModel);
                mInstituteModelList.remove(instituteModel);
                mDuplicateList.remove(instituteModel);
                mInstituteAdapter.notifyItemRemoved(position);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * Method to open add institute info activity to update and add institute info.
     */
    private void openInstituteInfoActivity(InstituteModel instituteModel) {
        Intent intent = new Intent(HomeActivity.this, AddInstituteActivity.class);
        if (instituteModel != null) {
            intent.putExtra("instituteData", instituteModel);
            intent.putExtra("updatingInfo", true);
        }
        startActivityForResult(intent, 100);
    }
}
