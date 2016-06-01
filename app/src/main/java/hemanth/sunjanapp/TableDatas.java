package hemanth.sunjanapp;

import android.provider.BaseColumns;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class TableDatas {
    public TableDatas()
    {

    }

    public static abstract class TableInfos implements BaseColumns
    {
        public static final String Customer_Name = "customer_name" ;
        public static final String Phone_Number = "phone_number";
        public static final String Length = "length" ;
        public static final String Shoulder = "shoulder" ;
        public static final String Chest = "chest" ;
        public static final String Stomach = "stomach" ;
        public static final String Hand_Length = "hand_length" ;
        public static final String Hand_Loose = "hand_loose" ;
        public static final String Collar = "collar" ;
        public static final String Database_Name = "shirt_info" ;
        public static final String Table_Name = "s_info" ;
    }

}
