package sharma.astha;

import android.app.Activity;
import static sharma.astha.Activation.db;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.telephony.SmsManager;

public class SystemActivated extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button b19;
	String[] contacts;
	long duration;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main5);
        b19=(Button)findViewById(R.id.b19);
        b19.setOnClickListener( this);

    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Intent.ACTION_MAIN );
		i.addCategory(Intent.CATEGORY_HOME);  
        startActivity(i);
					
	}
	
}


