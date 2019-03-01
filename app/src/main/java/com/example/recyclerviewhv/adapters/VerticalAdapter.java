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
import com.example.recyclerviewhv.databinding.VerticalBinding;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    VerticalBinding verticalBinding;
    List<User> userList;
    IUserAdapter iUserAdapter;

    public VerticalAdapter(List<User> userList,IUserAdapter iUserAdapter) {
        this.userList = userList;
        this.iUserAdapter=iUserAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        verticalBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.vertical_items, viewGroup, false);
        return new VericalViewHolder(verticalBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof VericalViewHolder) {
            VericalViewHolder vericalViewHolder = (VericalViewHolder) viewHolder;
            vericalViewHolder.dataBinding(userList.get(i),i);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    class VericalViewHolder extends RecyclerView.ViewHolder {
        VerticalBinding verticalBinding;

        public VericalViewHolder(VerticalBinding verticalBinding) {
            super(verticalBinding.getRoot());
            this.verticalBinding = verticalBinding;
        }

        public void dataBinding(final User user,final int pos) {
            if (verticalBinding == null)
                return;

            verticalBinding.vimageView.setImageURI(Uri.parse(user.imgeURL));
            verticalBinding.vnameTXT.setText(user.name);
            verticalBinding.vdateTXT.setText(user.Date);

            verticalBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iUserAdapter.onClickUser(user,pos);
                }
            });
        }
    }


}
