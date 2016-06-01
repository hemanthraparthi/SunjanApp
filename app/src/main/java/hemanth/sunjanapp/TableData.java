package hemanth.sunjanapp;

import android.provider.BaseColumns;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class TableData {
    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String Customer_Name = "customer_name" ;
        public static final String Phone_Number = "phone_number";
        public static final String Length = "length" ;
        public static final String Inside = "inside" ;
        public static final String Buttom = "buttom" ;
        public static final String Thies = "thies" ;
        public static final String Hips = "hips" ;
        public static final String Waist = "waist" ;
        public static final String Fullround = "fullround" ;
        public static final String Database_Name = "user_info" ;
        public static final String Table_Name = "reg_info" ;
    }

}
