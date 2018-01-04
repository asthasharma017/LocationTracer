package sharma.astha;

import static sharma.astha.Activation.db;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;

public class LocationTracer extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	String[] contacts;
	long duration;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contacts=db.getContacts();
        duration=db.getDuration();
        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        updateWithNewLocation(location);
        MyLocationListener mll=new MyLocationListener();
        locationManager.requestLocationUpdates(provider, duration, 10,(LocationListener) mll);
        Intent i=new Intent();
        setResult(RESULT_OK,i);
		finish();
    }
   
    private void updateWithNewLocation(Location location) {
    	String sms="My current location is\n";
    	if(location != null) 
    	{
    		double latitude = location.getLatitude();
    		double longitude = location.getLongitude();
    		sms+="Latitude = "+latitude+"\nLongitude = "+longitude+"\n";
    		Geocoder gc = new Geocoder(this, Locale.getDefault());
    		try
    		{
    			List<Address> addresses = gc.getFromLocation(latitude, longitude, 1);
    			StringBuilder sb = new StringBuilder();
    			if (addresses.size() > 0)
    			{
    				Address address = addresses.get(0);
    				for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
    				sb.append(address.getAddressLine(i)).append("\n");
    				sb.append(address.getLocality()).append("\n");
    				sb.append(address.getPostalCode()).append("\n");
    				sb.append(address.getCountryName());
    			}
    			sms+= sb.toString();
    		}
    		catch (IOException e) {}
    	}
    	else
    	{
    		sms+= "No location found";
    	}
    	SmsManager sm = SmsManager.getDefault();
    	for(int i=0;i<contacts.length;i++)
    	{
    		sm.sendTextMessage(contacts[i], null, sms, null, null);
    	}

    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Intent.ACTION_MAIN );
		i.addCategory(Intent.CATEGORY_HOME);  
        startActivity(i);
					
	}
	
	class MyLocationListener implements LocationListener
	{

		public void onLocationChanged(Location loc) {
			updateWithNewLocation(loc);
			
		}

		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}


