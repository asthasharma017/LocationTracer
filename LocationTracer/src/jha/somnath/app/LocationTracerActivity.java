package jha.somnath.app;


import android.app.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class LocationTracerActivity extends Activity implements OnClickListener{
	private Button b1;
	private Button b2;
	private ImageView img; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        img=(ImageView)findViewById(R.id.img);
         
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.setTextColor(Color.MAGENTA);
        b2.setTextColor(Color.RED);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
	public void onClick(View arg0) {
	
		Intent i= new Intent(this,LocationTracer2.class);
		Bundle b=new Bundle();
		b.putString("msg","Welcome To Location Tracer");
		i.putExtras(b);
        startActivity(i);
	}
}