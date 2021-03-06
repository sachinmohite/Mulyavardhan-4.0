package com.mv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mv.Activity.AttendanceApproval2Activity;
import com.mv.Activity.AttendanceApproveDetailActivity;
import com.mv.Activity.CommentActivity;
import com.mv.Activity.CommunityDetailsActivity;
import com.mv.Activity.CommunityHomeActivity;
import com.mv.Activity.VideoViewActivity;
import com.mv.Model.AttendanceApproval;
import com.mv.Model.Content;
import com.mv.R;
import com.mv.Utils.Constants;
import com.mv.Utils.PreferenceHelper;
import com.mv.Utils.Utills;

import java.io.File;
import java.util.List;

/**
 * Created by user on 8/7/2018.
 */

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder>{

    private final Context mContext;
    private PreferenceHelper preferenceHelper;
    private AttendanceApproval2Activity mActivity;
    private List<AttendanceApproval> mDataList;

    public AttendanceAdapter(Context context, List<AttendanceApproval> chatList) {
        Resources resources = context.getResources();
        mActivity = (AttendanceApproval2Activity) context;
        mContext = context;
        preferenceHelper = new PreferenceHelper(mContext);
        this.mDataList = chatList;
    }
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_child_leave_application, parent, false);

        // create ViewHolder
        AttendanceAdapter.ViewHolder viewHolder = new AttendanceAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AttendanceAdapter.ViewHolder holder, int position) {

        final AttendanceApproval attendance_approval = (AttendanceApproval) mDataList.get(position);
        if(attendance_approval.getUser_Name__c()!=null)
            holder.txtName.setText(attendance_approval.getUser_Name__c()+"("+attendance_approval.getAttendanceDateC()+")");
        else
            holder.txtName.setText(attendance_approval.getAttendanceDateC());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        RelativeLayout layoutMain;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            layoutMain = (RelativeLayout) itemLayoutView.findViewById(R.id.layoutMain);
            txtName = (TextView) itemLayoutView.findViewById(R.id.txtName);

            layoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(mContext, AttendanceApproveDetailActivity.class);
                    intent.putExtra(Constants.Attendance ,mDataList.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
        }

    }

    }

