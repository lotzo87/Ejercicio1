package mx.com.idmexico.vvazquez.interfaces.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelItem;

/**
 * Created by sistemas on 25/06/2016.
 */
public class ItemDataSource {
    private final SQLiteDatabase db;

    public ItemDataSource(Context context) {
        MyDbHelper helper = new MyDbHelper(context);
        db=helper.getWritableDatabase();
    }
    public void saveItem(ModelItem modelItem)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.COLUMN_ITEM_NAME,modelItem.getName());
        contentValues.put(MyDbHelper.COLUMN_ITEM_DESC,modelItem.getDescription());
        contentValues.put(MyDbHelper.COLUMN_ITEM_RESOURCE,modelItem.getResource());
        db.insert(MyDbHelper.TABLE_ITEM_NAME,null,contentValues);
    }

    public void deleteItem(ModelItem modelItem)
    {
        db.delete(MyDbHelper.TABLE_ITEM_NAME,MyDbHelper.COLUMN_ID+"=?",
                new String[]{String.valueOf(modelItem.getId())});
    }

    public List<ModelItem> getAllItems()
    {
        List<ModelItem> modelItemList = new ArrayList<>();
        Cursor cursor =db.query(MyDbHelper.TABLE_ITEM_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_ID));
            String item_name=cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_ITEM_NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_ITEM_DESC));
            int resource_id = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.COLUMN_ITEM_RESOURCE));
            ModelItem modelItem = new ModelItem(id,item_name,description,resource_id);
            modelItemList.add(modelItem);
        }
        return modelItemList;
    }
}
