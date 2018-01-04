package sharma.astha;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "SystemSettings";
	private static final int DATABASE_VERSION = 10;
	private static final String KEY_CONTACTS = "Contacts";
	private static final String KEY_DURATION = "TimeDuration";
	private static final String KEY_PASSWORD = "Password";
	private static final String TABLE_NAME = "Settings";
	private static final String DATABASE_PATH = "/data/data/sharma.astha/databases";
	private Context context;
	public DatabaseHandler(Context context)
	{
		super(context,DATABASE_NAME,null,DATABASE_VERSION);          //second arg in object to CursorFactory, which is static interface inside SQLiteDatabase
		Log.d("super call:","constructor called");
		this.context=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d("inside oncreate called:","starting db creation");
		String query="CREATE TABLE "+TABLE_NAME +"("+KEY_CONTACTS+" TEXT, "+KEY_DURATION+" INTEGER, "+KEY_PASSWORD+" TEXT)";
		db.execSQL(query);
		Log.d("oncreate called:","db created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		Log.d("onupgrde called:","db droped");
		onCreate(db);
		Log.d("onupdate called:","db updated");
	}

	public void addDetails(String contact, long durationMs, String password) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=this.getWritableDatabase();
		Log.d("creating Settings","inside addDetails");
		ContentValues values=new ContentValues();
		values.put(KEY_CONTACTS, contact);
		values.put(KEY_DURATION, durationMs);
		values.put(KEY_PASSWORD, password);
		db.insert(TABLE_NAME, null, values);
		Log.d("db path",db.getPath());
		db.close();
		Log.d("creating Settings","Settings created successfully!");
		
	}

	public String[] getContacts()
	{
		String[] contacts = null;
		String contactsString = null;
		Log.d("log", "inside getcontacts");
		SQLiteDatabase db=getReadableDatabase();
		String query="SELECT "+KEY_CONTACTS +" FROM "+TABLE_NAME;
		Cursor c=db.rawQuery(query, null);
		if(c.moveToFirst())
		{	
			Log.d("log", "inside if");
			contactsString=c.getString(0);
			Log.d("number1", contactsString);
		}
		contacts=contactsString.split(",");
		db.close();
		return contacts;
	}
	
	public long getDuration()
	{
		long duration = 0;
		SQLiteDatabase db=getReadableDatabase();
		String query="SELECT "+KEY_DURATION +" FROM "+TABLE_NAME;
		Cursor c=db.rawQuery(query, null);
		if(c.moveToFirst())
		{
			duration=c.getLong(0);
		}
		db.close();
		return duration;
	}
	
	public String getPassword()
	{
		String password = null;
		SQLiteDatabase db=getReadableDatabase();
		String query="SELECT "+KEY_PASSWORD +" FROM "+TABLE_NAME;
		Cursor c=db.rawQuery(query, null);
		if(c.moveToFirst())
		{
			password=c.getString(0);
		}
		db.close();
		return password;
	}
	
	public void updateContacts(String newContacts)
	{
		SQLiteDatabase db=getWritableDatabase();
		String query="UPDATE "+TABLE_NAME+ " SET "+KEY_CONTACTS+" ='"+newContacts+"'";
		Log.d("log", "inside update table2");
		db.execSQL(query);
		db.close();
	}
	
	public void updateDuration(Long newDuration)
	{
		SQLiteDatabase db=getWritableDatabase();
		String query="UPDATE "+TABLE_NAME+ " SET "+KEY_DURATION+" ='"+newDuration+"'";
		db.execSQL(query);
		db.close();
	}
	
	public void updatePassword(String newPassword)
	{
		SQLiteDatabase db=getWritableDatabase();
		String query="UPDATE "+TABLE_NAME+ " SET "+KEY_PASSWORD+" ='"+newPassword+"'";
		db.execSQL(query);
		db.close();
	}

	public void deactivate() {
		// TODO Auto-generated method stub
		context.deleteDatabase(DATABASE_NAME);
		
	}
	
	public static boolean databaseExist()
	{
	    File dbFile = new File(DATABASE_PATH+"/"+DATABASE_NAME);
	    return dbFile.exists();
	}

}
