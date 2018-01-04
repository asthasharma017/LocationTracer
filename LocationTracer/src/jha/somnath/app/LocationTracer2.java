package jha.somnath.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LocationTracer2 extends Activity implements OnClickListener{
private Button b1,b2;
private TextView tv1,tv2;
private EditText ed1,ed2;

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main2);
	b1=(Button)findViewById(R.id.b1);
	b2=(Button)findViewById(R.id.b2);
	tv1=(TextView)findViewById(R.id.tv1);
	tv2=(TextView)findViewById(R.id.tv2);
	ed1=(EditText)findViewById(R.id.edt1);
	ed2=(EditText)findViewById(R.id.edt2);
	tv1.setTextColor(Color.CYAN);
	tv2.setTextColor(Color.CYAN);
	b1.setTextColor(Color.MAGENTA);
	b2.setTextColor(Color.RED);
	b1.setOnClickListener(this);
	b2.setOnClickListener(this);
	Intent i3=super.getIntent();
	Bundle b= i3.getExtras();
	String s= b.getString("msg");
	Toast.makeText(this,s, Toast.LENGTH_LONG).show();
	
}

	public void onClick(View v) {
		int x= v.getId();
		switch(x)
		{
		case R.id.b1:
			Intent i = new Intent(this,LocationTracer3.class);
			startActivity(i);
		break;
		case R.id.b2:
			Intent i2 = new Intent(this,LocationTracerActivity.class);
			startActivity(i2);
		break;
		}
		
		
	}

}