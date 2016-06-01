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
 * Created by Hemanth on 5/28/2016.
 */
public class UpdateActivity extends Activity {
    Bundle BN;
    String customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround,rnumber,rlength,rinside,rbuttom,rthies,rhips,rwaist,rfullround;
    TextView Customer_name,Phone_number,Length,Inside,Buttom,Thies,Hips,Waist,Fullround;
    EditText Phone_numbe,Lengt,Insid,Butto,Thie,Hip,Wais,Fullroun;
    Button Rup;
    Context ctx=this;
    DatabaseOperations dop=new DatabaseOperations(ctx);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);
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
        Customer_name=(TextView) findViewById(R.id.tex);
        Phone_number=(TextView) findViewById(R.id.tex11);
        Length=(TextView) findViewById(R.id.tex1);
        Inside=(TextView) findViewById(R.id.tex2);
        Buttom=(TextView) findViewById(R.id.tex3);
        Thies=(TextView) findViewById(R.id.tex4);
        Hips=(TextView) findViewById(R.id.tex5);
        Waist=(TextView) findViewById(R.id.tex6);
        Fullround=(TextView) findViewById(R.id.tex7);
        Rup=(Button) findViewById(R.id.rup);
        Phone_numbe=(EditText)findViewById(R.id.edit11);
        Lengt=(EditText) findViewById(R.id.edit1);
        Insid=(EditText) findViewById(R.id.edit2);
        Butto=(EditText) findViewById(R.id.edit3);
        Thie=(EditText) findViewById(R.id.edit4);
        Hip=(EditText) findViewById(R.id.edit5);
        Wais=(EditText) findViewById(R.id.edit6);
        Fullroun=(EditText) findViewById(R.id.edit7);
        Customer_name.setText("Customer Name :"+customer_name);
        Phone_number.setText("Phone Number :"+phone_number);
        Length.setText("Length :"+length);
        Inside.setText("Inside :"+inside);
        Buttom.setText("Buttom :"+buttom);
        Thies.setText("Thies :"+thies);
        Hips.setText("Hips :"+hips);
        Waist.setText("Waist :"+waist);
        Fullround.setText("Fullround :"+fullround);

        Rup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rnumber=Phone_numbe.getText().toString();
                rlength=Lengt.getText().toString();
                rinside=Insid.getText().toString();
                rbuttom=Butto.getText().toString();
                rthies=Thie.getText().toString();
                rhips=Hip.getText().toString();
                rwaist=Wais.getText().toString();
                rfullround=Fullroun.getText().toString();


                if(rlength.isEmpty())
                    rlength=length;
                if(rinside.isEmpty())
                    rinside=inside;
                if(rbuttom.isEmpty())
                    rbuttom=buttom;
                if(rthies.isEmpty())
                    rthies=thies;
                if(rhips.isEmpty())
                    rhips=hips;
                if(rwaist.isEmpty())
                    rwaist=waist;
                if(rfullround.isEmpty())
                    rfullround=fullround;
                if(rnumber.isEmpty())
                {
                    rnumber=phone_number;
                    dop.updateuserinfo(dop,customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround,rnumber,rlength,rinside,rbuttom,rthies,rhips,rwaist,rfullround);
                    Toast.makeText(getBaseContext(),"UPDATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    if(rnumber.length()!=10)
                        Toast.makeText(getBaseContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                    else {
                        dop.updateuserinfo(dop,customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround,rnumber,rlength,rinside,rbuttom,rthies,rhips,rwaist,rfullround);
                        Toast.makeText(getBaseContext(),"UPDATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });


    }

}

