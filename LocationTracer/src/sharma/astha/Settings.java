package sharma.astha;

import static sharma.astha.Activation.db;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Settings extends Activity implements OnClickListener, OnItemSelectedListener{
    private static final int REQUEST_CODE = 0;
	/** Called when the activity is first created. */
	Button b11,b12,b13,b23;
	Spinner s2;
	private String durationString;
	private long durationMs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main8);
        String str[]=new String[]{"2 minute","15 minuts","30 minuits","1 hour","2 hour","5 hour","12 hour","1 day"};
        ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,str);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2 = (Spinner)findViewById(R.id.s2);
        s2.setAdapter(data);
        s2.setOnItemSelectedListener(this);
        b11=(Button)findViewById(R.id.b11);
        b11.setOnClickListener( this);
        b12=(Button)findViewById(R.id.b12);
        b12.setOnClickListener( this);
        b13=(Button)findViewById(R.id.b13);
        b13.setOnClickListener( this);
        b23=(Button)findViewById(R.id.b23);
        b23.setOnClickListener( this);
               
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b11.getId())
		{
			Intent i=new Intent(this,ContactList.class);
		  	startActivity(i);
		}
		else if(arg0.getId()==b12.getId())
		{
			Intent i=new Intent(this,ChangePassword.class);
		  	startActivityForResult(i, REQUEST_CODE);
		}
		else if(arg0.getId()==b13.getId())
		{
			Intent i=new Intent(this,Deactivation.class);
		  	startActivity(i);
		}
		else if(arg0.getId()==b23.getId())
		{
			Intent i=new Intent(Intent.ACTION_MAIN );
			i.addCategory(Intent.CATEGORY_HOME);  
	        startActivity(i);
		}
	  	
					
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode==10)
		{
			Toast.makeText(this, "Password changed", Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		durationString=(String) arg0.getItemAtPosition(arg2);
		if(durationString.equals("2 minute"))
        	durationMs=120000;
        else if(durationString.equals("15 minuts"))
        	durationMs=900000;
        else if(durationString.equals("30 minuits"))
        	durationMs=1800000;
        else if(durationString.equals("1 hour"))
        	durationMs=3600000;
        else if(durationString.equals("2 hour"))
        	durationMs=7200000;
        else if(durationString.equals("5 hour"))
        	durationMs=18000000;
        else if(durationString.equals("12 hour"))
        	durationMs=43200000;
        else if(durationString.equals("1 day"))
        	durationMs=86400000;
		db.updateDuration(durationMs);
		Intent i=new Intent(this, LocationTracer.class); 
        startActivityForResult(i, REQUEST_CODE);
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

