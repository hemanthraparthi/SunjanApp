package hemanth.sunjanapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class DatabaseOperationss extends SQLiteOpenHelper {
    public static final int Database_Version = 1;
    public String Create_Query = "CREATE TABLE " + TableDatas.TableInfos.Table_Name + "(" + TableDatas.TableInfos.Customer_Name + " TEXT,"+ TableDatas.TableInfos.Phone_Number + " TEXT," + TableDatas.TableInfos.Length + " TEXT,"+ TableDatas.TableInfos.Shoulder+ " TEXT,"+ TableDatas.TableInfos.Chest + " TEXT,"+ TableDatas.TableInfos.Stomach + " TEXT,"+ TableDatas.TableInfos.Hand_Length + " TEXT,"+ TableDatas.TableInfos.Hand_Loose + " TEXT,"+ TableDatas.TableInfos.Collar + " TEXT);";

    public DatabaseOperationss(Context context) {
        super(context, TableDatas.TableInfos.Database_Name,null, Database_Version);
        Log.d("DataBase Operationss ", "DataBases Created ");
    }
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(Create_Query);
        Log.d("DataBase Operationss ", "User Added ");
    }
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
    public void putInfo(DatabaseOperationss dop, String name,String phone, String length,String shoulder,String chest,String stomach,String handllength,String handloose,String collar) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(TableDatas.TableInfos.Customer_Name, name);
        CV.put(TableDatas.TableInfos.Phone_Number,phone);
        CV.put(TableDatas.TableInfos.Length, length);
        CV.put(TableDatas.TableInfos.Shoulder, shoulder);
        CV.put(TableDatas.TableInfos.Chest, chest);
        CV.put(TableDatas.TableInfos.Stomach, stomach);
        CV.put(TableDatas.TableInfos.Hand_Length, handllength);
        CV.put(TableDatas.TableInfos.Hand_Loose, handloose);
        CV.put(TableDatas.TableInfos.Collar, collar);
        long k = SQ.insert(TableDatas.TableInfos.Table_Name, null, CV);
        Log.d("DataBase Operationss ", "User Added into DB of shirt ");
    }
    public Cursor getInfo(DatabaseOperationss dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableDatas.TableInfos.Customer_Name, TableDatas.TableInfos.Phone_Number, TableDatas.TableInfos.Length, TableDatas.TableInfos.Shoulder, TableDatas.TableInfos.Chest, TableDatas.TableInfos.Stomach, TableDatas.TableInfos.Hand_Length,TableDatas.TableInfos.Hand_Loose, TableDatas.TableInfos.Collar};
        Cursor CR = SQ.query(TableDatas.TableInfos.Table_Name, coloumns, null, null, null, null, null);
        return CR;
    }
    public void updateuser(DatabaseOperationss dop, String name,String phone, String length,String shoulder,String chest,String stomach,String handllength,String handloose,String collar,String rphone, String rlength,String rshoulder,String rchest,String rstomach,String rhandllength,String rhandloose,String rcollar)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        String selection = TableDatas.TableInfos.Customer_Name+ " LIKE ? AND "+ TableDatas.TableInfos.Phone_Number+ " LIKE ? AND "+ TableDatas.TableInfos.Length+ " Like ? AND "+ TableDatas.TableInfos.Shoulder+ " Like ? AND "+ TableDatas.TableInfos.Chest+ " Like ? AND "+ TableDatas.TableInfos.Stomach+ " Like ? AND "+ TableDatas.TableInfos.Hand_Length+ " Like ? AND "+ TableDatas.TableInfos.Hand_Loose+ " Like ? AND "+ TableDatas.TableInfos.Collar+ " Like ? ";
        String[] args={name,phone,length,shoulder,chest,stomach,handllength,handloose,collar};
        ContentValues values=new ContentValues();
        values.put(TableDatas.TableInfos.Phone_Number,rphone);
        values.put(TableDatas.TableInfos.Length, rlength);
        values.put(TableDatas.TableInfos.Shoulder, rshoulder);
        values.put(TableDatas.TableInfos.Chest, rchest);
        values.put(TableDatas.TableInfos.Stomach, rstomach);
        values.put(TableDatas.TableInfos.Hand_Length, rhandllength);
        values.put(TableDatas.TableInfos.Hand_Loose, rhandloose);
        values.put(TableDatas.TableInfos.Collar, rcollar);
        SQ.update(TableDatas.TableInfos.Table_Name,values,selection,args);

    }
    public void deleteuser(DatabaseOperationss dop, String name,String phone, String length,String shoulder,String chest,String stomach,String handllength,String handloose,String collar)
    {
        String selection = TableDatas.TableInfos.Customer_Name+ " LIKE ? AND "+ TableDatas.TableInfos.Phone_Number+ " LIKE ? AND "+ TableDatas.TableInfos.Length+ " Like ? AND "+ TableDatas.TableInfos.Shoulder+ " Like ? AND "+ TableDatas.TableInfos.Chest+ " Like ? AND "+ TableDatas.TableInfos.Stomach+ " Like ? AND "+ TableDatas.TableInfos.Hand_Length+ " Like ? AND "+ TableDatas.TableInfos.Hand_Loose+ " Like ? AND "+ TableDatas.TableInfos.Collar+ " Like ? ";
        String args[]={name,phone,length,shoulder,chest,stomach,handllength,handloose,collar};
        SQLiteDatabase SQ= dop.getWritableDatabase();
        SQ.delete(TableDatas.TableInfos.Table_Name,selection,args);
    }
}
