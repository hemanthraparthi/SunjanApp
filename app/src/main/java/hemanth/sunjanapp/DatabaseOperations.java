package hemanth.sunjanapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int Database_Version = 1;
    public String Create_Query = "CREATE TABLE " + TableData.TableInfo.Table_Name + "(" + TableData.TableInfo.Customer_Name + " TEXT,"+ TableData.TableInfo.Phone_Number + " TEXT," + TableData.TableInfo.Length + " TEXT,"+ TableData.TableInfo.Inside + " TEXT,"+ TableData.TableInfo.Buttom + " TEXT,"+ TableData.TableInfo.Thies + " TEXT,"+ TableData.TableInfo.Hips + " TEXT,"+ TableData.TableInfo.Waist + " TEXT,"+ TableData.TableInfo.Fullround + " TEXT);";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.Database_Name, null, Database_Version);
        Log.d("DataBase Operations ", "DataBase Created ");
    }

    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(Create_Query);
        Log.d("DataBase Operations ", "User Added ");
    }

    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public void putInfo(DatabaseOperations dop, String name,String phone, String length,String inside,String buttom,String thies,String hips,String waist,String fullround) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(TableData.TableInfo.Customer_Name, name);
        CV.put(TableData.TableInfo.Phone_Number,phone);
        CV.put(TableData.TableInfo.Length, length);
        CV.put(TableData.TableInfo.Inside, inside);
        CV.put(TableData.TableInfo.Buttom, buttom);
        CV.put(TableData.TableInfo.Thies, thies);
        CV.put(TableData.TableInfo.Hips, hips);
        CV.put(TableData.TableInfo.Waist, waist);
        CV.put(TableData.TableInfo.Fullround, fullround);
        long k = SQ.insert(TableData.TableInfo.Table_Name, null, CV);
        Log.d("DataBase Operations ", "User Added into DB ");
    }


    public Cursor getInfo(DatabaseOperations dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableData.TableInfo.Customer_Name, TableData.TableInfo.Phone_Number, TableData.TableInfo.Length, TableData.TableInfo.Inside, TableData.TableInfo.Buttom, TableData.TableInfo.Thies, TableData.TableInfo.Hips,TableData.TableInfo.Waist, TableData.TableInfo.Fullround};
        Cursor CR = SQ.query(TableData.TableInfo.Table_Name, coloumns, null, null, null, null, null);
        return CR;
    }



    public void updateuserinfo(DatabaseOperations dop,String customer_name,String phone_number,String length,String inside,String buttom,String thies,String hips,String waist,String fullround,String rphone,String rlength,String rinside,String rbuttom,String rthies,String rhips,String rwaist,String rfullround)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        String selection = TableData.TableInfo.Customer_Name+ " LIKE ? AND "+ TableData.TableInfo.Phone_Number+ " LIKE ? AND "+ TableData.TableInfo.Length+ " Like ? AND "+ TableData.TableInfo.Inside+ " Like ? AND "+ TableData.TableInfo.Buttom+ " Like ? AND "+ TableData.TableInfo.Thies+ " Like ? AND "+ TableData.TableInfo.Hips+ " Like ? AND "+ TableData.TableInfo.Waist+ " Like ? AND "+ TableData.TableInfo.Fullround+ " Like ? ";
        String[] args={customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround};
        ContentValues values=new ContentValues();
        values.put(TableData.TableInfo.Phone_Number,rphone);
        values.put(TableData.TableInfo.Length, rlength);
        values.put(TableData.TableInfo.Inside, rinside);
        values.put(TableData.TableInfo.Buttom, rbuttom);
        values.put(TableData.TableInfo.Thies, rthies);
        values.put(TableData.TableInfo.Hips, rhips);
        values.put(TableData.TableInfo.Waist, rwaist);
        values.put(TableData.TableInfo.Fullround, rfullround);
        SQ.update(TableData.TableInfo.Table_Name,values,selection,args);

    }

    public void deleteuser(DatabaseOperations dop,String customer_name,String phone_number,String length,String inside,String buttom,String thies,String hips,String waist,String fullround)
    {
        String selection = TableData.TableInfo.Customer_Name+ " LIKE ? AND "+ TableData.TableInfo.Phone_Number+" LIKE ? AND "+ TableData.TableInfo.Length+ " Like ? AND "+ TableData.TableInfo.Inside+ " Like ? AND "+ TableData.TableInfo.Buttom+ " Like ? AND "+ TableData.TableInfo.Thies+ " Like ? AND "+ TableData.TableInfo.Hips+ " Like ? AND "+ TableData.TableInfo.Waist+ " Like ? AND "+ TableData.TableInfo.Fullround+ " Like ? ";
        String args[]={customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround};
        SQLiteDatabase SQ= dop.getWritableDatabase();
        SQ.delete(TableData.TableInfo.Table_Name,selection,args);
    }

}
