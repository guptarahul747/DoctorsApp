package com.developer.project.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Rahul on 24/1/16.
 */
public class _Activity extends AppCompatActivity {

    public void smallToast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
