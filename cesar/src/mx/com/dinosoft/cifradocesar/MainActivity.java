package mx.com.dinosoft.cifradocesar;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{

	EditText etTexto;
	TextView tvROT[];
	int size = 26;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etTexto = (EditText) findViewById(R.id.etTexto);
		tvROT = new TextView[size];

		for (int i = 0; i < size; i++) {
			String s = "tvROT" + (i + 1);
			int ID = getResources().getIdentifier(s, "id",
					"mx.com.dinosoft.cifradocesar");
			tvROT[i] = (TextView) findViewById(ID);
			tvROT[i].setVisibility(View.GONE);
		}
		
		etTexto.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable et) {
				String s = et.toString();
				String salida[] = new String[size];
				Cesar cesar = new Cesar();
				for(int i=0; i<size; i++){
					salida[i] = cesar.cifrar(s,i+1);
					tvROT[i].setText("ROT"+(i+1)+".- "+salida[i]);
					tvROT[i].setVisibility(View.VISIBLE);
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}