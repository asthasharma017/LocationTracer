package sharma.astha;

import static sharma.astha.Activation.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMoreContacts extends Activity implements OnClickListener{
    private static final int REQUEST_CODE = 0;
	/** Called when the activity is first created. */
	Button b21,b24;
	EditText et8;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main12);
        b21=(Button)findViewById(R.id.b21);
        b21.setOnClickListener( this);
        b24=(Button)findViewById(R.id.b24);
        b24.setOnClickListener( this);
        et8=(EditText)findViewById(R.id.et8);
                       
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b21.getId())
		{
			String number=et8.getText().toString();
			if(number.equals("")||number==null)
			{
				Toast.makeText(this, "Please enter a contact number", Toast.LENGTH_LONG).show();
			}
			else
			{
				String contacts=number;  	
				String[] arr=db.getContacts();
				for(int i=0;i<arr.length;i++)
				{
					contacts+=","+arr[i];
				}
				db.updateContacts(contacts);
				Intent i=new Intent(this,LocationTracer.class);
				startActivityForResult(i,REQUEST_CODE);
			}
		}
		
		else
		{
			Intent i=new Intent(this,ContactList.class);
			startActivity(i);
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Intent i=new Intent(this, ContactList.class); 
        startActivity(i);

	}
	
}

