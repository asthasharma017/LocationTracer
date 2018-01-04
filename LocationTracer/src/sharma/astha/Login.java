package sharma.astha;

import android.app.Activity;
import android.content.Intent;
import static sharma.astha.Activation.db;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button b9,b10;
	EditText et4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);
        b9=(Button)findViewById(R.id.b9);
        b9.setOnClickListener( this);
        b10=(Button)findViewById(R.id.b10);
        b10.setOnClickListener( this);
        et4=(EditText)findViewById(R.id.et4);
       
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b9.getId())
		{
			Log.d("log","inside if");
			db=new DatabaseHandler(this);
			String password=db.getPassword();
			if(password.equals(et4.getText().toString()))
			{
				Intent i=new Intent(this,Settings.class);
			    startActivity(i);
			}
			else
			{
				Toast.makeText(this, "Wrong Password...!\n\tTry Again\n", Toast.LENGTH_LONG).show();		
			}
		}
	  	else if(arg0.getId()==b10.getId())
	  	{
	  		Intent i=new Intent(Intent.ACTION_MAIN );
			i.addCategory(Intent.CATEGORY_HOME);  
	        startActivity(i);

	  	}
	}
}

