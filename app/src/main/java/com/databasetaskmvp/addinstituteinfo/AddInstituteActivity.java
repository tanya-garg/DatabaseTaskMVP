package com.databasetaskmvp.addinstituteinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;

import com.databasetaskmvp.R;
import com.databasetaskmvp.base.BaseActivity;
import com.databasetaskmvp.pojo.InstituteModel;
import com.databasetaskmvp.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddInstituteActivity extends BaseActivity {

    @BindView(R.id.tv_add_new)
    AppCompatTextView tvAddNew;
    @BindView(R.id.et_institute_name)
    AppCompatEditText etInstituteName;
    @BindView(R.id.tl_name)
    TextInputLayout tlName;
    @BindView(R.id.et_institute_address)
    AppCompatEditText etInstituteAddress;
    @BindView(R.id.tl_address)
    TextInputLayout tlAddress;
    @BindView(R.id.et_institute_description)
    AppCompatEditText etInstituteDescription;
    @BindView(R.id.tl_description)
    TextInputLayout tlDescription;
    @BindView(R.id.et_institute_phone)
    AppCompatEditText etInstitutePhone;
    @BindView(R.id.tl_phone)
    TextInputLayout tlPhone;
    @BindView(R.id.et_institute_email)
    AppCompatEditText etInstituteEmail;
    @BindView(R.id.tl_email)
    TextInputLayout tlEmail;
    @BindView(R.id.et_courses)
    AppCompatEditText etCourses;
    @BindView(R.id.tl_courses)
    TextInputLayout tlCourses;
    @BindView(R.id.btn_add)
    AppCompatButton btnAdd;
    @BindView(R.id.parent_view)
    NestedScrollView parentView;

    private boolean updatingInfo = false;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra("instituteData") && getIntent().getParcelableExtra("instituteData") != null) {
            InstituteModel instituteModel = getIntent().getParcelableExtra("instituteData");
            setInstitutesInfo(instituteModel);
            if (getIntent().hasExtra("updatingInfo")) {
                updatingInfo = getIntent().getBooleanExtra("updatingInfo", false);
            }
        }
    }


    @Override
    protected int getResourceId() {
        return R.layout.activity_add_institute;
    }

    /**
     * Method to set institute infos on views.
     */
    private void setInstitutesInfo(InstituteModel institutesInfo) {
        if (institutesInfo.getId() != -1) {
            id = institutesInfo.getId();
        }
        if (institutesInfo.getInstituteName() != null) {
            etInstituteName.setText(institutesInfo.getInstituteName());
        }
        if (institutesInfo.getInstituteAddress() != null) {
            etInstituteAddress.setText(institutesInfo.getInstituteAddress());
        }
        if (institutesInfo.getInstituteDescription() != null) {
            etInstituteDescription.setText(institutesInfo.getInstituteDescription());
        }
        if (institutesInfo.getPhone() != null) {
            etInstitutePhone.setText(institutesInfo.getPhone());
        }
        if (institutesInfo.getEmail() != null) {
            etInstituteEmail.setText(institutesInfo.getEmail());
        }
        if (institutesInfo.getCourses() != null) {
            etCourses.setText(institutesInfo.getCourses());
        }
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        if (validateAllInfo()) {
            InstituteModel instituteModel = new InstituteModel();
            instituteModel.setInstituteName(etInstituteName.getText().toString().trim());
            instituteModel.setInstituteAddress(etInstituteAddress.getText().toString().trim());
            instituteModel.setInstituteDescription(etInstituteDescription.getText().toString().trim());
            instituteModel.setPhone(etInstitutePhone.getText().toString().trim());
            instituteModel.setEmail(etInstituteEmail.getText().toString().trim());
            instituteModel.setCourses(etCourses.getText().toString().trim());
            Intent intent = new Intent();
            intent.putExtra("instituteData", instituteModel);
            if (updatingInfo) {
                instituteModel.setId(id);
                setResult(AppConstants.UPDATING_INSTITUTE_CODE, intent);
            } else {
                setResult(RESULT_OK, intent);
            }
            finish();
        }
    }

    /**
     * Validate all fields.
     */
    private boolean validateAllInfo() {
        if (TextUtils.isEmpty(etInstituteName.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_name), Snackbar.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etInstituteAddress.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_address), Snackbar.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etInstituteDescription.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_description), Snackbar.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etInstitutePhone.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_phone), Snackbar.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etInstituteEmail.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_email), Snackbar.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etCourses.getText().toString().trim())) {
            Snackbar.make(parentView, getString(R.string.please_enter_courses), Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
