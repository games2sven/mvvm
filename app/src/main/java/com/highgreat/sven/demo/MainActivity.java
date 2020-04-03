package com.highgreat.sven.demo;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.highgreat.sven.demo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView list;
    List<User> data=new ArrayList<>();

    User user;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        list=(ListView)findViewById(R.id.listView);
//        data.add(new User("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg","1","1"));
//        data.add(new User("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg","2","2"));
//        data.add(new User("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg","3","3"));
//        data.add(new User("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg","4","4"));
//        list.setAdapter(new CommAdapter<User>(this,getLayoutInflater(),R.layout.item,BR.user,data));
        ActivityMainBinding viewDataBinding;
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user=new User("http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg","Sven","123");
        viewDataBinding.setUser(user);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setName("zhou");
                user.setPassword("*****");
            }
        },5000);

    }
}
