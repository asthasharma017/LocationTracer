package sharma.astha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button b1,b2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(DatabaseHandler.databaseExist())
        {
        	Intent i=new Intent(this,Login.class);
	        startActivity(i);
        }
        setContentView(R.layout.main1);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.setOnClickListener( this);
        b2.setOnClickListener( this);
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b1.getId())
		{
			Intent i=new Intent(this,Activation.class);
	        startActivity(i);
		}
		else
		{
			Intent i=new Intent(Intent.ACTION_MAIN );
			i.addCategory(Intent.CATEGORY_HOME);  
	        startActivity(i);
		}
	}
}