package mx.com.idmexico.vvazquez.interfaces.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by sistemas on 25/06/2016.
 */
public class MyDbHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "DbSqlite";
    private final static int DATABASE_VERSION = 1;

    public static final String TABLE_ITEM_NAME ="TBLITEM";
    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_ITEM_NAME = "name";
    public static final String COLUMN_ITEM_DESC = "description";
    public static final String COLUMN_ITEM_RESOURCE = "resource_id";

    private static final String CREATE_TABLE_ITEM = String.format("create table if not exists %s " +
            "(%s integer primary key autoincrement," +
            "%s text not null," +
            "%s text not null," +
            "%s integer not null)", TABLE_ITEM_NAME, COLUMN_ID, COLUMN_ITEM_NAME,COLUMN_ITEM_DESC, COLUMN_ITEM_RESOURCE);

    // USER TABLE
    public final static  String TABLE_USER_NAME = "TBLUSER";
    public static final String COLUMN_USER_ID = BaseColumns._ID;
    public static final String COLUMN_USER = "USER";
    public static final String COLUMN_PWD = "PASSWORD";
    public static final String COLUMN_SESSION = "LAST_SESSION";
    public static final String COLUMN_REM = "REMEMBER";

    private static final String CREATE_TABLE_USER = String.format("create table if not exists %s" +
            "(%s integer primary key autoincremant, " +
            "%s text not null, " +
            "%s text not null, "+
            "%s datetime, " +
            "%s integer default 0)",TABLE_USER_NAME,COLUMN_USER_ID, COLUMN_USER,COLUMN_PWD, COLUMN_SESSION, COLUMN_REM );

    private static final String DELETE_TABLE_ITEM =
            String.format("DROP TABLE IF EXISTS ",TABLE_ITEM_NAME);

    private static final String DELETE_TABLE_USER =
            String.format("DROP TABLE IF EXISTS ", TABLE_USER_NAME);


    public MyDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ITEM_NAME);
        db.execSQL(TABLE_USER_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE_ITEM);
        db.execSQL(DELETE_TABLE_USER);
        onCreate(db);
    }
}

