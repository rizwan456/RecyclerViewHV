package com.example.recyclerviewhv.adapters;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewhv.IUserAdapter;
import com.example.recyclerviewhv.R;
import com.example.recyclerviewhv.User;
import com.example.recyclerviewhv.databinding.HorizontalBinding;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<User> userList;
    HorizontalBinding horizontalBinding;
    IUserAdapter iUserAdapter;

    public HorizontalAdapter(List<User> userList,IUserAdapter iUserAdapter) {
        this.userList = userList;
        this.iUserAdapter=iUserAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        horizontalBinding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.horizontal_items,viewGroup,false);
        return new HorizontalViewHolder(horizontalBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof  HorizontalViewHolder){
            HorizontalViewHolder horizontalViewHolder=(HorizontalViewHolder) viewHolder;
            horizontalViewHolder.dataBinding(userList.get(i),i);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        private HorizontalBinding horizontalBinding;

        public HorizontalViewHolder(HorizontalBinding horizontalBinding) {
            super(horizontalBinding.getRoot());
            this.horizontalBinding = horizontalBinding;
        }

        public void dataBinding(final User user,final int pos) {
            if(horizontalBinding == null)
                return;

            horizontalBinding.himageView.setImageURI(Uri.parse(user.imgeURL));
            horizontalBinding.hnameTXT.setText(user.name);
            horizontalBinding.hdateTXT.setText(user.Date);

            horizontalBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iUserAdapter.onClickUser(user,pos);
                }
            });
        }
    }
}
