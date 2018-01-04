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

public class ChangePassword extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button b20,b3;
	EditText et5,et6,et7;
	String password1,password2,oldPassword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main10);
        b20=(Button)findViewById(R.id.b20);
        b20.setOnClickListener(this);
        b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(this);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);
        et7=(EditText)findViewById(R.id.et7);
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b20.getId())
		{
			oldPassword=et5.getText().toString();
			password1=et6.getText().toString();
			password2=et7.getText().toString();
			if((password1.equals("")||password1==null)||(password2.equals("")||password2==null)||(oldPassword.equals("")||oldPassword==null))
			{
				Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();

			}
			else
			{
				if(oldPassword.equals(db.getPassword()))
				{
					if(!password1.equals(password2))
					{
						Toast.makeText(this, "New password mismatch", Toast.LENGTH_LONG).show();
						
					}	
					else
					{
						db.updatePassword(password1);	
						Intent i=new Intent();
						setResult(10,i);
						finish();
					}
				}
				else  
				{
					Toast.makeText(this, "Incorrect old password", Toast.LENGTH_LONG).show();
				}
			}
		}
		else if(arg0.getId()==b3.getId())
		{
			Intent i=new Intent(this,Settings.class);
		  	startActivity(i);
		}
		
		
	}
}


