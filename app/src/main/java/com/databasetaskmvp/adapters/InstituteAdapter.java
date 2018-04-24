package com.databasetaskmvp.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databasetaskmvp.R;
import com.databasetaskmvp.interfaces.OnClickInterface;
import com.databasetaskmvp.pojo.InstituteModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by appinventiv on 21/4/18.
 */

public class InstituteAdapter extends RecyclerView.Adapter<InstituteAdapter.InstituteViewHolder> {


    private List<InstituteModel> mInstituteModelList;
    private List<InstituteModel> mDuplicateList;
    private OnClickInterface onClickInterface;


    public InstituteAdapter(List<InstituteModel> mInstituteModelList, List<InstituteModel> mDuplicateList, OnClickInterface onClickInterface) {
        this.mInstituteModelList = mInstituteModelList;
        this.mDuplicateList = mDuplicateList;
        this.onClickInterface = onClickInterface;
    }

    @Override
    public InstituteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InstituteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_institute, parent, false));
    }

    @Override
    public void onBindViewHolder(InstituteViewHolder holder, int position) {
        if (mInstituteModelList.get(position).getInstituteName() != null) {
            holder.tvInstituteName.setText(mInstituteModelList.get(position).getInstituteName());
        }
        if (mInstituteModelList.get(position).getInstituteAddress() != null) {
            holder.tvInstituteAddress.setText(mInstituteModelList.get(position).getInstituteAddress());
        }
        if (mInstituteModelList.get(position).getInstituteDescription() != null) {
            holder.tvInstituteDescription.setText(mInstituteModelList.get(position).getInstituteDescription());
        }
        if (mInstituteModelList.get(position).getPhone() != null) {
            holder.tvInstitutePhone.setText(mInstituteModelList.get(position).getPhone());
        }
        if (mInstituteModelList.get(position).getEmail() != null) {
            holder.tvInstituteEmail.setText(mInstituteModelList.get(position).getEmail());
        }
        if (mInstituteModelList.get(position).getCourses() != null) {
            holder.tvTotalCourses.setText(mInstituteModelList.get(position).getCourses());
        }
    }

    @Override
    public int getItemCount() {
        return mInstituteModelList.size();
    }

    class InstituteViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_institute_name)
        AppCompatTextView tvInstituteName;
        @BindView(R.id.tv_institute_address)
        AppCompatTextView tvInstituteAddress;
        @BindView(R.id.tv_institute_description)
        AppCompatTextView tvInstituteDescription;
        @BindView(R.id.tv_phone)
        AppCompatTextView tvPhone;
        @BindView(R.id.tv_institute_phone)
        AppCompatTextView tvInstitutePhone;
        @BindView(R.id.tv_email)
        AppCompatTextView tvEmail;
        @BindView(R.id.tv_institute_email)
        AppCompatTextView tvInstituteEmail;
        @BindView(R.id.tv_institute_courses)
        AppCompatTextView tvInstituteCourses;
        @BindView(R.id.tv_total_courses)
        AppCompatTextView tvTotalCourses;

        InstituteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickInterface.onClick(getAdapterPosition(),mInstituteModelList.get(getAdapterPosition()));
                }
            });
        }
    }





}
