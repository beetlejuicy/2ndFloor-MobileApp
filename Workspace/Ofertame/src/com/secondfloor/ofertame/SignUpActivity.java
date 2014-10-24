package com.secondfloor.ofertame;

import com.secondfloor.model.Autenticacao;
import com.secondfloor.model.enums.TipoAcesso;
import com.secondfloor.ofertame.task.CadastrarConsumidorTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {
	Button btnCadastrar;
	EditText txtEmail;
	EditText txtUserName;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        
        btnCadastrar = (Button) findViewById(R.id.btnSingUp);
        txtUserName = (EditText) findViewById(R.id.etUserName);
        txtEmail = (EditText) findViewById(R.id.etEmail);
        
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Autenticacao autenticacao = new Autenticacao();
		        autenticacao.setTipoAcesso(TipoAcesso.ContaLocal);
				autenticacao.setEmail(txtEmail.getText().toString());
				autenticacao.setNome(txtUserName.getText().toString());
				
				CadastrarConsumidorTask cadastrarConsumidorTask = new CadastrarConsumidorTask(SignUpActivity.this);
				cadastrarConsumidorTask.execute(autenticacao);
			}
		});
    }
}
