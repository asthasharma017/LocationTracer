package sharma.astha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activation extends Activity implements OnClickListener, OnItemSelectedListener{
    private static final int REQUEST_CODE = 0;
	/** Called when the activity is first created. */
	public static DatabaseHandler db=null;
	Button b4,b5;
	EditText et1,et2,et3;
	Spinner s1;
	String durationString,password1,password2,contact;
	long durationMs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        String str[]=new String[]{"2 minute","15 minuts","30 minuits","1 hour","2 hour","5 hour","12 hour","1 day"};
        ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,str);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1 = (Spinner)findViewById(R.id.s1);
        s1.setAdapter(data);
        s1.setOnItemSelectedListener(this);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }
	@Override

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId()==b4.getId())
		{
			password1=et2.getText().toString();
			password2=et3.getText().toString();
			contact=et1.getText().toString();
			if(contact.equals("")||contact==null)
			{
				Toast.makeText(this, "Please enter a mobile number", Toast.LENGTH_LONG).show();
			}
			else if(password1.equals("")||password1==null&&password2.equals("")||password2==null)
			{
				Toast.makeText(this, "Please enter a password", Toast.LENGTH_LONG).show();
			}
			else if(!password1.equals(password2))
			{
				Toast.makeText(this, "Password mismatch", Toast.LENGTH_LONG).show();
			}
			else
			{
				db = new DatabaseHandler(this);
				db.addDetails(contact, durationMs, password1);
				Intent i=new Intent(this, LocationTracer.class); 
		        startActivityForResult(i, REQUEST_CODE);

			}
		}
		if(v.getId()==b5.getId())
		{
			Intent i=new Intent(Intent.ACTION_MAIN );
			i.addCategory(Intent.CATEGORY_HOME);  
	        startActivity(i);

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
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Intent i=new Intent(this, SystemActivated.class); 
        startActivity(i);

	}
}
