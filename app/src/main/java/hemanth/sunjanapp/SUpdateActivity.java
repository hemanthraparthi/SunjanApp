package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class SUpdateActivity extends Activity {
    Bundle BN;
    String customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar,rphone_number,rlength,rshoulder,rchest,rstomach,rhand_length,rhand_loose,rcollar;
    TextView Customer_name,Phone_number,Length,Shoulder,Chest,Stomach,Hand_length,Hand_loose,Collar;
    EditText Phone_numbe,Lengt,Shoulde,Ches,Stomac,Hand_lengt,Hand_loos,Colla;
    Button Rup;
    Context ctx=this;
    DatabaseOperationss dop=new DatabaseOperationss(ctx);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supdate_layout);
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
        Customer_name=(TextView) findViewById(R.id.tex);
        Phone_number=(TextView) findViewById(R.id.tex11);
        Length=(TextView) findViewById(R.id.tex1);
        Shoulder=(TextView) findViewById(R.id.tex2);
        Chest=(TextView) findViewById(R.id.tex3);
        Stomach=(TextView) findViewById(R.id.tex4);
        Hand_length=(TextView) findViewById(R.id.tex5);
        Hand_loose=(TextView) findViewById(R.id.tex6);
        Collar=(TextView) findViewById(R.id.tex7);
        Rup=(Button) findViewById(R.id.rup);
        Phone_numbe=(EditText)findViewById(R.id.edit11);
        Lengt=(EditText) findViewById(R.id.edit1);
        Shoulde=(EditText) findViewById(R.id.edit2);
        Ches=(EditText) findViewById(R.id.edit3);
        Stomac=(EditText) findViewById(R.id.edit4);
        Hand_lengt=(EditText) findViewById(R.id.edit5);
        Hand_loos=(EditText) findViewById(R.id.edit6);
        Colla=(EditText) findViewById(R.id.edit7);
        Customer_name.setText("Name "+customer_name);
        Phone_number.setText("Phone Number"+phone_number);
        Length.setText("Length :"+length);
        Shoulder.setText("Shoulder"+shoulder);
        Chest.setText("Chest "+chest);
        Stomach.setText("Stomach :"+stomach);
        Hand_length.setText("Hand Length :"+hand_length);
        Hand_loose.setText("Hand Loose :"+hand_loose);
        Collar.setText("Collar :"+collar);
        Rup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rphone_number=Phone_numbe.getText().toString();
                rlength=Lengt.getText().toString();
                rshoulder=Shoulde.getText().toString();
                rchest=Ches.getText().toString();
                rstomach=Stomac.getText().toString();
                rhand_length=Hand_lengt.getText().toString();
                rhand_loose=Hand_loos.getText().toString();
                rcollar=Colla.getText().toString();


                if(rlength.isEmpty())
                    rlength=length;
                if(rshoulder.isEmpty())
                    rshoulder=shoulder;
                if(rchest.isEmpty())
                    rchest=chest;
                if(rstomach.isEmpty())
                    rstomach=stomach;
                if(rhand_length.isEmpty())
                    rhand_length=hand_length;
                if(rhand_loose.isEmpty())
                    rhand_loose=hand_loose;
                if(rcollar.isEmpty())
                    rcollar=collar;
                if(rphone_number.isEmpty())
                {
                    rphone_number=phone_number;
                    dop.updateuser(dop,customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar,rphone_number,rlength,rshoulder,rchest,rstomach,rhand_length,rhand_loose,rcollar);
                    Toast.makeText(getBaseContext(),"UPDATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    if(rphone_number.length()!=10)
                        Toast.makeText(getBaseContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                    else {
                        dop.updateuser(dop,customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar,rphone_number,rlength,rshoulder,rchest,rstomach,rhand_length,rhand_loose,rcollar);
                        Toast.makeText(getBaseContext(),"UPDATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });


    }
}
