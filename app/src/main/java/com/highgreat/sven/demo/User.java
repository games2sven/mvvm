package com.highgreat.sven.demo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


/**
 * 这就是VM
 */
public class User extends BaseObservable {

    private String name;
    private String password;

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public User(String header, String name, String password) {
        this.name = name;
        this.password = password;
        this.header = header;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }



    //自定义属性：提供一个静态方法来加载image
    @BindingAdapter("bind:header")
    public static void getImage(ImageView view,String url){
        Picasso.with(view.getContext()).load(url).into(view);
    }

    public void click(View view){
        Toast.makeText(view.getContext(),getName() , Toast.LENGTH_SHORT).show();
    }

}
