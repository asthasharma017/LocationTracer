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

public class LocationTracer3 extends Activity implements OnClickListener{
private TextView tv1;
private EditText edt1;
private Button b1;
private Button b2;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main3);
b1=(Button)findViewById(R.id.b1);
b2=(Button)findViewById(R.id.b2);
tv1=(TextView)findViewById(R.id.tv1);
edt1=(EditText)findViewById(R.id.edt1);
edt1.setTextColor(Color.GRAY);
tv1.setTextColor(Color.CYAN);
b1.setTextColor(Color.MAGENTA);
b2.setTextColor(Color.RED);
b1.setOnClickListener(this);
b2.setOnClickListener(this);


}

public void onClick(View v) {
	int x= v.getId();
	switch(x)
	{
	case R.id.b1:
		Intent i = new Intent(this,LocationTracer4.class);
		startActivity(i);
	break;
	case R.id.b2:
		Intent i2 = new Intent(this,LocationTracer2.class);
		startActivity(i2);
	break;
	}
	
	
	
}

}