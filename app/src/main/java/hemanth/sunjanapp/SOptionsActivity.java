package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class SOptionsActivity extends Activity {
    TextView Customer_name,Phone_Number,Length,Shoulder,Chest,Stomach,Hand_length,Hand_loose,Collar;
    String customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar;
    Button Update,Delete;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soptions_layout);
        Customer_name=(TextView) findViewById(R.id.text);
        Phone_Number=(TextView) findViewById(R.id.text11);
        Length=(TextView) findViewById(R.id.text1);
        Shoulder=(TextView) findViewById(R.id.text2);
        Chest=(TextView) findViewById(R.id.text3);
        Stomach=(TextView)findViewById(R.id.text4);
        Hand_length=(TextView) findViewById(R.id.text5);
        Hand_loose=(TextView) findViewById(R.id.text6);
        Collar=(TextView) findViewById(R.id.text7);
        Update=(Button)findViewById(R.id.supdate);
        Delete=(Button)findViewById(R.id.sdelete);
        Bundle BN= getIntent().getExtras();
        customer_name=BN.getString("customer_name");
        phone_number=BN.getString("phone_number");
        length=BN.getString("length");
        shoulder=BN.getString("shoulder");
        chest=BN.getString("chest");
        stomach=BN.getString("stomach");
        hand_length=BN.getString("hand_length");
        hand_loose=BN.getString("hand_loose");
        collar=BN.getString("collar");
        Customer_name.setText("Name "+customer_name);
        Phone_Number.setText("Phone Number :"+phone_number);
        Length.setText("Length :"+length);
        Shoulder.setText("Shoulder"+shoulder);
        Chest.setText("Chest "+chest);
        Stomach.setText("Stomach :"+stomach);
        Hand_length.setText("Hand Length :"+hand_length);
        Hand_loose.setText("Hand Loose :"+hand_loose);
        Collar.setText("Collar :"+collar);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle BN = new Bundle();
                BN.putString("customer_name", customer_name);
                BN.putString("phone_number", phone_number);
                BN.putString("length", length);
                BN.putString("shoulder", shoulder);
                BN.putString("chest", chest);
                BN.putString("stomach", stomach);
                BN.putString("hand_length", hand_length);
                BN.putString("hand_loose", hand_loose);
                BN.putString("collar", collar);
                Intent i=new Intent("SUpdate_Activity");
                i.putExtras(BN);
                startActivity(i);
                finish();

            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle BN = new Bundle();
                BN.putString("customer_name", customer_name);
                BN.putString("phone_number", phone_number);
                BN.putString("length", length);
                BN.putString("shoulder", shoulder);
                BN.putString("chest", chest);
                BN.putString("stomach", stomach);
                BN.putString("hand_length", hand_length);
                BN.putString("hand_loose", hand_loose);
                BN.putString("collar", collar);
                Intent i=new Intent("SDelete_Activity");
                i.putExtras(BN);
                startActivity(i);
                finish();
            }
        });


    }
}
