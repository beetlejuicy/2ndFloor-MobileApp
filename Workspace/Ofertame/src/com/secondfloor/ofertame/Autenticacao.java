package com.secondfloor.ofertame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Autenticacao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacao);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.autenticacao, menu);
        return true;
    }
    
}
