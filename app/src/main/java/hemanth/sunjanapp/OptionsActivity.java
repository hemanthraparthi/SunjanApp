package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class OptionsActivity extends Activity {
    TextView Customer_name,Phone_Number,Length,Inside,Buttom,Thies,Hips,Waist,Fullround;
    String customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround;
    Button Update,Delete;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_layout);
        Customer_name=(TextView) findViewById(R.id.text);
        Phone_Number=(TextView) findViewById(R.id.text11);
        Length=(TextView) findViewById(R.id.text1);
        Inside=(TextView) findViewById(R.id.text2);
        Buttom=(TextView) findViewById(R.id.text3);
        Thies=(TextView) findViewById(R.id.text4);
        Hips=(TextView) findViewById(R.id.text5);
        Waist=(TextView) findViewById(R.id.text6);
        Fullround=(TextView) findViewById(R.id.text7);
        Update=(Button)findViewById(R.id.update);
        Delete=(Button)findViewById(R.id.delete);
        Bundle BN= getIntent().getExtras();
        customer_name=BN.getString("customer_name");
        phone_number=BN.getString("phone_number");
        length=BN.getString("length");
        inside=BN.getString("inside");
        buttom=BN.getString("buttom");
        thies=BN.getString("thies");
        hips=BN.getString("hips");
        waist=BN.getString("waist");
        fullround=BN.getString("fullround");
        Customer_name.setText("Customer Name :"+customer_name);
        Phone_Number.setText("Phone Number :"+phone_number);
        Length.setText("Length :"+length);
        Inside.setText("Inside :"+inside);
        Buttom.setText("Buttom :"+buttom);
        Thies.setText("Thies :"+thies);
        Hips.setText("Hips :"+hips);
        Waist.setText("Waist :"+waist);
        Fullround.setText("Fullround :"+fullround);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle BN= new Bundle();
                BN.putString("customer_name",customer_name);
                BN.putString("phone_number",phone_number);
                BN.putString("length",length);
                BN.putString("inside",inside);
                BN.putString("buttom",buttom);
                BN.putString("thies",thies);
                BN.putString("hips",hips);
                BN.putString("waist",waist);
                BN.putString("fullround",fullround);
                Intent i=new Intent("Update_Activity");
                i.putExtras(BN);
                startActivity(i);
                finish();

            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle BN= new Bundle();
                BN.putString("customer_name",customer_name);
                BN.putString("phone_number",phone_number);
                BN.putString("length",length);
                BN.putString("inside",inside);
                BN.putString("buttom",buttom);
                BN.putString("thies",thies);
                BN.putString("hips",hips);
                BN.putString("waist",waist);
                BN.putString("fullround",fullround);
                Intent i=new Intent("Delete_Activity");
                i.putExtras(BN);
                startActivity(i);
                finish();
            }
        });


    }
}
