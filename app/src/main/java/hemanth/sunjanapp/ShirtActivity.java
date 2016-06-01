package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class ShirtActivity extends Activity{
    Button Check,Register;
    String customer_name,phone_number;
    EditText Customer_name;
    Context ctx=this;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shirt_layout);
        Customer_name=(EditText)findViewById(R.id.customer_name);
        Check=(Button)findViewById(R.id.search);
        Register=(Button)findViewById(R.id.register);
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phone_number=Customer_name.getText().toString();
                customer_name=Customer_name.getText().toString();
                if(phone_number.isEmpty()||customer_name.isEmpty())
                {
                    Toast.makeText(getBaseContext(),"Fill Search Field",Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseOperationss dop = new DatabaseOperationss(ctx);
                    Cursor CR = dop.getInfo(dop);
                    CR.moveToFirst();
                    boolean loginstatus = false;
                    String Name = "";
                    String Number = "";
                    String Length = "";
                    String Shoulder = "";
                    String Chest = "";
                    String Stomach = "";
                    String Handlength = "";
                    String Handloose = "";
                    String Collar = "";
                    do {
                        if(CR.isBeforeFirst())
                        {
                        }
                        else {
                            if (customer_name.equals(CR.getString(0)) || phone_number.equals(CR.getString(1))) {
                                loginstatus = true;
                                Name = CR.getString(0);
                                Number = CR.getString(1);
                                Length = CR.getString(2);
                                Shoulder = CR.getString(3);
                                Chest = CR.getString(4);
                                Stomach = CR.getString(5);
                                Handlength = CR.getString(6);
                                Handloose = CR.getString(7);
                                Collar = CR.getString(8);

                            }
                        }
                    }while (CR.moveToNext());
                    if (loginstatus == true) {
                        Toast.makeText(getBaseContext(), "CUSTOMER EXISTS", Toast.LENGTH_SHORT).show();
                        Bundle BN = new Bundle();
                        BN.putString("customer_name", Name);
                        BN.putString("phone_number", Number);
                        BN.putString("length", Length);
                        BN.putString("shoulder", Shoulder);
                        BN.putString("chest", Chest);
                        BN.putString("stomach", Stomach);
                        BN.putString("hand_length", Handlength);
                        BN.putString("hand_loose", Handloose);
                        BN.putString("collar", Collar);
                        Intent i = new Intent("SOptions_Activity");
                        i.putExtras(BN);
                        startActivity(i);
                    } else {
                        Toast.makeText(getBaseContext(), "NO CUSTOMER EXISTS", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("Sregister_Activity");
                startActivity(i);
            }
        });
    }

}
