package com.example.recyclerviewhv;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.recyclerviewhv.adapters.MainAdapter;
import com.example.recyclerviewhv.databinding.MainActivityBinding;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  IUserAdapter {

    MainActivityBinding mainActivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Fresco.initialize(this);

        mainActivityBinding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainActivityBinding.mainRecyclerView.setAdapter(new MainAdapter(this,generateCartList(),this));
    }

    public List<User> generateCartList() {
        List<User> list = new ArrayList<>();
        list.add(new User("Apple", "12/12/12","https://media.istockphoto.com/photos/red-apple-with-leaf-picture-id683494078?k=6&m=683494078&s=612x612&w=0&h=aVyDhOiTwUZI0NeF_ysdLZkSvDD4JxaJMdWSx2p3pp4="));
        list.add(new User("Banana", "12/12/12","https://media.istockphoto.com/photos/banana-picture-id636739634?k=6&m=636739634&s=612x612&w=0&h=BQ9Z6DobjFzclh3LN7nKSljrRqycJPCq65CS8rtUHU4="));
        list.add(new User("Orange", "12/12/12","https://media.istockphoto.com/photos/orange-fruit-isolated-on-white-picture-id477836156?k=6&m=477836156&s=612x612&w=0&h=so0IENCIE95_bgdadhstzVSBoAOqEyAnwr1TirAXdsY="));
        list.add(new User("Mango", "12/12/12","https://images-na.ssl-images-amazon.com/images/I/41EvGpCFECL.jpg"));
        list.add(new User("Carrot", "12/12/12","https://www.culturedfoodlife.com/wp-content/uploads/2017/04/Carrot.png"));
        list.add(new User("WaterMellon", "12/12/12","https://i5.walmartimages.ca/images/Large/805/2_r/6000196088052_R.jpg"));
        list.add(new User("Carrot", "12/12/12","https://www.culturedfoodlife.com/wp-content/uploads/2017/04/Carrot.png"));
        list.add(new User("WaterMellon", "12/12/12","https://i5.walmartimages.ca/images/Large/805/2_r/6000196088052_R.jpg"));
        list.add(new User("Carrot", "12/12/12","https://www.culturedfoodlife.com/wp-content/uploads/2017/04/Carrot.png"));
        list.add(new User("WaterMellon", "12/12/12","https://i5.walmartimages.ca/images/Large/805/2_r/6000196088052_R.jpg"));
        return list;
    }

    @Override
    public void onClickUser(User userItem, int position) {
        Toast.makeText(MainActivity.this, userItem.name, Toast.LENGTH_SHORT).show();
    }

}
