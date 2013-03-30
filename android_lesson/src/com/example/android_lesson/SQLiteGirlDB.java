package com.example.android_lesson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteGirlDB {

	// set a DB....
	// first, DB NAME.
	public static final String DATABASE_NAME = "GirlDB";
	// second, TABLE NAME, 1 DB can hold many TABLEs.
	public static final String DATABASE_TABLE = "GirlDB_table";
	// third, row id and row name, 1 TABLE can hold many ROWs.
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "person_name";
	public static final String KEY_HOTNESS = "person_hotness";
	public static final String KEY_DESCRIPTION = "person_description";
	// final, set DB version.
	public static final int DATABASE_VERSION = 1;

	// set a Context for DBhelper to use
	private DbHelper GirlDB_generater;
	private final Context GirlDB_context;
	private SQLiteDatabase GirlSQL;

	// extends SQLiteOpenHelper to setup DB
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			// execSQL need to use SQL language,
			// we use String to make one SQL code
			// watch out for those space in SQL code.
			db.execSQL("CREATE TABLE " + DATABASE_TABLE
			+ " ("
			+ KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ KEY_NAME + " TEXT NOT NULL, "
			+ KEY_HOTNESS + " TEXT NOT NULL, "
			+ KEY_DESCRIPTION + " TEXT NOT NULL"
			+ ");"
			);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			// check db is exist or not, if exist, call onCreate()
			db.execSQL("DROP TABLE IF EXIST " + DATABASE_TABLE);
			onCreate(db);

		}

	}

	// connect "SQLiteGirlDB" class with "SQLiteOpenHelper" by Context
	public SQLiteGirlDB(Context c) {
		GirlDB_context = c;
	}
	
	// we set a open() method for SQLiteGirlDB class
	// SQLiteGirlDB.open() can call this method
	public SQLiteGirlDB open() throws SQLException{
		GirlDB_generater = new DbHelper(GirlDB_context);
		GirlSQL = GirlDB_generater.getWritableDatabase();
		return this;
	}
	
	// we set a close() method for SQLiteGirlDB class
	// SQLiteGirlDB.close() can call this method
	public void close(){
		GirlDB_generater.close();
	}

	public long dataSaving(String nameData, String hotnessData,
			String descriptionData) {
		// TODO Auto-generated method stub
		ContentValues dataContent = new ContentValues();
		dataContent.put(KEY_NAME, nameData);
		dataContent.put(KEY_HOTNESS, hotnessData);
		dataContent.put(KEY_DESCRIPTION, descriptionData);
		return GirlSQL.insert(DATABASE_TABLE, null, dataContent );
		
	}

	public String getData() throws SQLException{
		// TODO Auto-generated method stub
		String[] dataColumns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS, KEY_DESCRIPTION };
		Cursor callData = GirlSQL.query(DATABASE_TABLE, dataColumns,null,null,null,null, null);
		String callDataResult = "";
		
		// column 0
		int iRowID = callData.getColumnIndex(KEY_ROWID);
		// column 1
		int iName = callData.getColumnIndex(KEY_NAME);
		// column 2
		int iHotness = callData.getColumnIndex(KEY_HOTNESS);
		// column 3
		int iDescription = callData.getColumnIndex(KEY_DESCRIPTION);
		
		for (callData.moveToFirst(); !callData.isAfterLast(); callData.moveToNext()){
			
			callDataResult = callDataResult 
					+ callData.getString(iRowID) + " "
					+ callData.getString(iName) + " "
					+ callData.getString(iHotness) + " "
					+ callData.getString(iDescription) + " "
					+ "\n" ;
			
		}
		
		return callDataResult;
	}

	public String getName(long idNumber) throws SQLException{
		// TODO Auto-generated method stub
		String[] dataColumns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS, KEY_DESCRIPTION };
		Cursor callData = GirlSQL.query(DATABASE_TABLE, dataColumns, KEY_ROWID + "=" + idNumber, null,null,null, null);
		
		if(callData != null){
			callData.moveToFirst();
			// get column 1 => getString(1)
			String name = callData.getString(1);
			return name;
		}		
		return null;
	}

	public String getHotness(long idNumber) throws SQLException{
		// TODO Auto-generated method stub
		String[] dataColumns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS, KEY_DESCRIPTION };
		Cursor callData = GirlSQL.query(DATABASE_TABLE, dataColumns, KEY_ROWID + "=" + idNumber, null,null,null, null);
		
		if(callData != null){
			callData.moveToFirst();
			// get column 2 => getString(2)
			String hotness = callData.getString(2);
			return hotness;
		}		
		return null;
	}

	public String getDescription(long idNumber) throws SQLException{
		// TODO Auto-generated method stub
		String[] dataColumns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS, KEY_DESCRIPTION };
		Cursor callData = GirlSQL.query(DATABASE_TABLE, dataColumns, KEY_ROWID + "=" + idNumber, null,null,null, null);
		
		if(callData != null){
			callData.moveToFirst();
			// get column 3 => getString(3)
			String description = callData.getString(1);
			return description;
		}		
		return null;
	}

	public void updateEntry(long idNumber_modified, String nameData_modified,
			String descriptionData_modified) throws SQLException{
		// TODO Auto-generated method stub
		ContentValues dataUpdate = new ContentValues();
		dataUpdate.put(KEY_NAME, nameData_modified );
		dataUpdate.put(KEY_HOTNESS, descriptionData_modified );
		GirlSQL.update(DATABASE_TABLE, dataUpdate, KEY_ROWID + "=" + idNumber_modified, null);
	}

	public void deleteEntry(long idNumber_delete) throws SQLException{
		// TODO Auto-generated method stub
		GirlSQL.delete(DATABASE_TABLE, KEY_ROWID + "=" + idNumber_delete, null);
	}
	

}
