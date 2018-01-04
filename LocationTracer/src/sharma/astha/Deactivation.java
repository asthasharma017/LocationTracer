package sharma.astha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import static sharma.astha.Activation.db;

public class Deactivation extends Activity implements OnClickListener{
	private static final int REQUEST_CODE = 0;
	/** Called when the activity is first created. */
	Button b18;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main11);
        b18=(Button)findViewById(R.id.b18);
        b18.setOnClickListener( this);  
        db.deactivate();
       
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Intent.ACTION_MAIN );
		i.addCategory(Intent.CATEGORY_HOME);  
        startActivity(i);		
	}
	
}


