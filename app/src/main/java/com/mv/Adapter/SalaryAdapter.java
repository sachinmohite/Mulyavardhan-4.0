

package com.mv.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mv.Model.Salary;
import com.mv.R;

import java.util.List;

/**
 * Created by acer on 9/8/2016.
 */


public class SalaryAdapter extends RecyclerView.Adapter<SalaryAdapter.ViewHolder> {

    private Context mContext;
    private Resources resources;
    private List<Salary> mDataList;


    public SalaryAdapter(Context context, List<Salary> list) {
        mContext = context;
        resources = context.getResources();
        mDataList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_salary, parent, false);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSalaryAmountName, tvSalaryDateName, tvSalaryMonthName;


        public ViewHolder(View itemLayoutView) {

            super(itemLayoutView);

            tvSalaryAmountName = (TextView) itemLayoutView.findViewById(R.id.tvSalaryAmountName);
            tvSalaryDateName = (TextView) itemLayoutView.findViewById(R.id.tvSalaryDateName);
            tvSalaryMonthName = (TextView) itemLayoutView.findViewById(R.id.tvSalaryMonthName);

        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Salary salary = mDataList.get(position);
        holder.tvSalaryAmountName.setText(salary.getAmount());
        holder.tvSalaryDateName.setText(salary.getDate());
        holder.tvSalaryMonthName.setText(salary.getMonth());
    }

}
