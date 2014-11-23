package mx.com.dinosoft.cifradocesar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

	EditText etTexto;
	Button btnCifrar;
	TextView tvROT[];
	int size = 26;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etTexto = (EditText) findViewById(R.id.etTexto);
		btnCifrar = (Button) findViewById(R.id.btnCifrar);
		tvROT = new TextView[size];

		btnCifrar.setOnClickListener(this);

		for (int i = 0; i < size; i++) {
			String s = "tvROT" + (i + 1);
			int ID = getResources().getIdentifier(s, "id",
					"mx.com.dinosoft.cifradocesar");
			tvROT[i] = (TextView) findViewById(ID);
			tvROT[i].setVisibility(View.GONE);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCifrar:
			String s = etTexto.getText().toString();
			String salida[] = new String[size];
			Cesar cesar = new Cesar();
			for(int i=0; i<size; i++){
				salida[i] = cesar.cifrar(s,i+1);
				tvROT[i].setText("ROT"+(i+1)+": "+salida[i]);
				tvROT[i].setVisibility(View.VISIBLE);
			}
			
			break;
		}
	}


}