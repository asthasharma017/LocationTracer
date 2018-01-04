package sharma.astha;

import java.util.ArrayList;
import static sharma.astha.Activation.db;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ContactList extends ListActivity implements OnClickListener{
    private static final int REQUEST_CODE = 0;
	/** Called when the activity is first created. */
	Button b14,b15,b22;
	ArrayList<String> unCheckedContacts;
	String[] contacts;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main9);
        b14=(Button)findViewById(R.id.b14);
        b14.setOnClickListener( this);
        b15=(Button)findViewById(R.id.b15);
        b15.setOnClickListener( this);
        b22=(Button)findViewById(R.id.b22);
        b22.setOnClickListener( this);
        contacts=db.getContacts();
        ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,contacts);
        setListAdapter(data);
        //display contacts with names
    }
    protected void onListItemClick(ListView l,View v,int position,long id)
    {
    	unCheckedContacts=new ArrayList<String>();
    	l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	SparseBooleanArray sba=l.getCheckedItemPositions();
    	for(int i=0;i<l.getCount();i++)
        {
        	if(!sba.get(i))
        	{
        		unCheckedContacts.add((String) l.getItemAtPosition(i));
        	}
        }    	
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==b14.getId())
		{
			if(unCheckedContacts==null)
			{
				Toast.makeText(this, "No contact Selected", Toast.LENGTH_LONG).show();
			}
			else
			{
				String contacts = "";
				for(int i=0;i<unCheckedContacts.size();i++)
		    	{
		    		contacts+=unCheckedContacts.get(i)+",";
		    	}
				db.updateContacts(contacts);
				Intent i=new Intent(this,LocationTracer.class);
				startActivityForResult(i,REQUEST_CODE);
			}
		}
		else if(arg0.getId()==b15.getId())
		{
			Intent i=new Intent(this,AddMoreContacts.class);
			startActivity(i);
		}	
		else if(arg0.getId()==b22.getId())
		{
			Intent i=new Intent(this,Settings.class);
			startActivity(i);
		}	
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Intent i=new Intent(this, ContactList.class); 
        startActivity(i);

	}
}


