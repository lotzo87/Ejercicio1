package mx.com.idmexico.vvazquez.interfaces.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelItem;
import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelUser;

/**
 * Created by sistemas on 25/06/2016.
 */
public class UserDataSource {
    private final SQLiteDatabase db;

    public UserDataSource(Context context) {
        MyDbHelper helper = new MyDbHelper(context);
        db=helper.getWritableDatabase();
    }
    public void saveUser(ModelUser modelUser)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.COLUMN_USER,modelUser.getUser());
        contentValues.put(MyDbHelper.COLUMN_PWD,modelUser.getPassword());
        contentValues.put(MyDbHelper.COLUMN_SESSION, String.valueOf(modelUser.getLastsession()));
        db.insert(MyDbHelper.TABLE_USER_NAME,null,contentValues);
    }

    public void deleteUser(ModelUser modelUser)
    {
        db.delete(MyDbHelper.TABLE_USER_NAME,MyDbHelper.COLUMN_USER_ID+"=?",
                new String[]{String.valueOf(modelUser.getId())});
    }

    public void deleteAll()
    {
        db.delete(MyDbHelper.TABLE_USER_NAME,null,null);
        db.delete(MyDbHelper.TABLE_ITEM_NAME, null, null);
    }

    public List<ModelUser> getAllUsers()
    {
        List<ModelUser> modelUserList = new ArrayList<>();
        Cursor cursor =db.query(MyDbHelper.TABLE_USER_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_USER_ID));
            String user=cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.TABLE_USER_NAME));
            String pasword = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_PWD));
            String session = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_SESSION));
            int rem = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_REM));
            ModelUser modelUser= new ModelUser(id, user, pasword, session, rem);
            modelUserList.add(modelUser);
        }
        return modelUserList;
    }

    public List<ModelUser> getUser(String user, String password)
    {
        List<ModelUser> modelUserList = new ArrayList<>();
        Cursor cursor =db.query(MyDbHelper.TABLE_USER_NAME, null,MyDbHelper.COLUMN_USER + "=? AND " + MyDbHelper.COLUMN_PWD + "=?",
                new String[] {user, password},null,null,null,null);
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_USER_ID));
            String usr=cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_USER));
            String pasword = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_PWD));
            String session = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_SESSION));
            int rem = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_REM));
            ModelUser modelUser= new ModelUser(id, usr, pasword, session, rem);
            modelUserList.add(modelUser);
        }
        return modelUserList;
    }
}
