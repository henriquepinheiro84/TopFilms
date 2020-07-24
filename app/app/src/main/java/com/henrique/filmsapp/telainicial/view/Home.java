
package com.henrique.filmsapp.telainicial.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.henrique.filmsapp.R;
import com.henrique.filmsapp.telainicial.interfaces.HomeViewInterface;

public class Home extends AppCompatActivity implements HomeViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}