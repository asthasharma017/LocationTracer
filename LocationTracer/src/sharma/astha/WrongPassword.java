package sharma.astha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WrongPassword extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button b11,b12;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main7);
        b11=(Button)findViewById(R.id.b11);
        b11.setOnClickListener( this);
        b12=(Button)findViewById(R.id.b12);
        b12.setOnClickListener( this);
       
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b11.getId())
		{
			Intent i=new Intent(this,Login.class);
		  	startActivity(i);
		}
		else if(arg0.getId()==b12.getId())
		{
			Intent i=new Intent(Intent.ACTION_MAIN );
			i.addCategory(Intent.CATEGORY_HOME);  
	        startActivity(i);
		}
					
	}
}

