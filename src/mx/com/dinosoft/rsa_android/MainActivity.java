package mx.com.dinosoft.rsa_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	Button btnRSA;
	EditText size;
	TextView p, q, n, d, e, z;
	RSA rsa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		size = (EditText) findViewById(R.id.size);
		btnRSA = (Button) findViewById(R.id.btnRSA);
		p = (TextView) findViewById(R.id.p);
		q = (TextView) findViewById(R.id.q);
		n = (TextView) findViewById(R.id.n);
		d = (TextView) findViewById(R.id.d);
		e = (TextView) findViewById(R.id.e);
		z = (TextView) findViewById(R.id.z);

		btnRSA.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		int tam = Integer.parseInt(size.getText().toString());
		if(tam<16){
			Toast.makeText(this, "El tamaño debe ser mayor igual que 16", Toast.LENGTH_SHORT).show();
		}else{
			switch (v.getId()) {
				case R.id.btnRSA:
					rsa = new RSA(tam);
					rsa.generaClaves();
					p.setText("P " + rsa.getP().toString().length() + " : "
							+ rsa.getP().toString());
					q.setText("Q " + rsa.getQ().toString().length() + " : "
							+ rsa.getQ().toString());
					n.setText("N " + rsa.getN().toString().length() + " : "
							+ rsa.getN().toString());
					d.setText("D " + rsa.getD().toString().length() + " : "
							+ rsa.getD().toString());
					e.setText("E " + rsa.getE().toString().length() + " : "
							+ rsa.getE().toString());
					z.setText("Z " + rsa.getZ().toString().length() + " : "
							+ rsa.getZ().toString());
				break;
	
			}
		}
	}

}
