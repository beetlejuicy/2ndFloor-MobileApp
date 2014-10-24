package com.secondfloor.ofertame;

import com.secondfloor.model.Autenticacao;
import com.secondfloor.ofertame.task.LogonConsumidorTaks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends Activity {
	private Button btnEntrar;
	private EditText txtUserName;
	private EditText txtPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in_screen);

		btnEntrar = (Button) findViewById(R.id.btnSingIn);
		txtUserName = (EditText) findViewById(R.id.etUserName);
		txtPass = (EditText) findViewById(R.id.etPass);

		btnEntrar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Autenticacao autenticacao = new Autenticacao();
				autenticacao.setNome(txtUserName.getText().toString());
				autenticacao.setSenha(txtPass.getText().toString());

				LogonConsumidorTaks logonConsumidorTaks = new LogonConsumidorTaks(SignInActivity.this);
				logonConsumidorTaks.execute(autenticacao);

			}
		});
	}

}
