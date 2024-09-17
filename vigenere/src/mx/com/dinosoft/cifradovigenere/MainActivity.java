package mx.com.dinosoft.cifradovigenere;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	Button btnCifrar;
	EditText etText, etKey, etCifrado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCifrar = (Button) findViewById(R.id.btnCifrar);
		etText = (EditText) findViewById(R.id.etText);
		etKey = (EditText) findViewById(R.id.etKey);
		etCifrado = (EditText) findViewById(R.id.etCifrado);

		etCifrado.setVisibility(View.GONE);
		btnCifrar.setOnClickListener(this);

	}

	@SuppressLint("DefaultLocale")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCifrar:
			String sTexto = etText.getText().toString().toUpperCase();
			String sClave = etKey.getText().toString().toUpperCase();
			String salida;
			Vigenere vigenere = new Vigenere();
			
			salida = vigenere.cifrar(sTexto, sClave);
			
			etCifrado.setText(salida.toLowerCase());
			etCifrado.setVisibility(View.VISIBLE);

			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}