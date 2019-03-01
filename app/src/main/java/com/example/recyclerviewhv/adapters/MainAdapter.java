package com.example.recyclerviewhv.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.recyclerviewhv.IUserAdapter;
import com.example.recyclerviewhv.R;
import com.example.recyclerviewhv.User;
import com.example.recyclerviewhv.databinding.BottomViewBinding;
import com.example.recyclerviewhv.databinding.MainRecyclerBinding;
import com.example.recyclerviewhv.databinding.TopViewBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MainRecyclerBinding mainRecyclerBinding;
    TopViewBinding topViewBinding;
    BottomViewBinding bottomViewBinding;
    Context context;
    List<User> user;

    IUserAdapter userAdapter;
    public MainAdapter(Context context, List<User> user,IUserAdapter userAdapter) {
        this.context = context;
        this.user = user;
        this.userAdapter=userAdapter;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        if(i==0)
        {
            topViewBinding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.top_view,viewGroup,false);
            return new TopViewHolder(topViewBinding);
        }
        else // 2
        {
            bottomViewBinding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.bottom_view,viewGroup,false);
            return new BottomViewHolder(bottomViewBinding);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {

        if(viewHolder instanceof  TopViewHolder){
            TopViewHolder topViewHolder=(TopViewHolder) viewHolder;
            topViewHolder.bindData(context,user);
        }else if(viewHolder instanceof BottomViewHolder){
            BottomViewHolder bottomViewHolder=(BottomViewHolder) viewHolder;
            bottomViewHolder.bindData(context,user);
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


    class TopViewHolder extends  RecyclerView.ViewHolder{
        private TopViewBinding topViewBinding;
        public TopViewHolder(TopViewBinding topViewBinding) {
            super(topViewBinding.getRoot());
            this.topViewBinding=topViewBinding;
        }

        public void bindData(Context context, List<User> user){
            topViewBinding.hRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            topViewBinding.hRecyclerView.setAdapter(new HorizontalAdapter(user,userAdapter));
        }
    }

    class BottomViewHolder extends  RecyclerView.ViewHolder{
        private BottomViewBinding bottomViewBinding;

        public BottomViewHolder(BottomViewBinding bottomViewBinding) {
            super(bottomViewBinding.getRoot());
            this.bottomViewBinding=bottomViewBinding;
        }

        public void bindData(Context context, List<User> user){
            bottomViewBinding.vRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            bottomViewBinding.vRecyclerView.setAdapter(new VerticalAdapter(user,userAdapter));
        }
    }

}
