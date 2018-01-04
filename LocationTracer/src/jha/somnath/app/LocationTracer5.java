package jha.somnath.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LocationTracer5 extends Activity implements OnClickListener{

private TextView tv1;


	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main5);
	
	tv1=(TextView)findViewById(R.id.tv1);
	
	
	Intent i=getIntent();
	Bundle b= i.getExtras();
	String s= b.getString("msg");
	Toast.makeText(this,s,Toast.LENGTH_LONG).show();

}

	public void onClick(View v) {
		
		
	}

}