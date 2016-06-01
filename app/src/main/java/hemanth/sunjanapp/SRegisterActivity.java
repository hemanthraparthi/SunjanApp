package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class SRegisterActivity extends Activity {
    EditText Customer_name,Phone_number,Length,Shoulder,Chest,Stomach,Hand_length,Hand_loose,Collar;
    String customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar;
    Button Submit;
    Context ctx=this;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sregister_layout);
        Customer_name=(EditText) findViewById(R.id.editText);
        Phone_number=(EditText) findViewById(R.id.editText11);
        Length=(EditText) findViewById(R.id.editText1);
        Shoulder=(EditText) findViewById(R.id.editText2);
        Chest=(EditText) findViewById(R.id.editText3);
        Stomach=(EditText) findViewById(R.id.editText4);
        Hand_length=(EditText) findViewById(R.id.editText5);
        Hand_loose=(EditText) findViewById(R.id.editText6);
        Collar=(EditText) findViewById(R.id.editText7);
        Submit=(Button) findViewById(R.id.ssubmit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer_name=Customer_name.getText().toString();
                phone_number=Phone_number.getText().toString();
                length=Length.getText().toString();
                shoulder=Shoulder.getText().toString();
                chest=Chest.getText().toString();
                stomach=Stomach.getText().toString();
                hand_length=Hand_length.getText().toString();
                hand_loose=Hand_loose.getText().toString();
                collar=Collar.getText().toString();
                if(customer_name.isEmpty()||phone_number.isEmpty()||length.isEmpty()||shoulder.isEmpty()||chest.isEmpty()||stomach.isEmpty()||hand_length.isEmpty()||hand_loose.isEmpty()||collar.isEmpty())
                {
                    if(phone_number.length()!=10)
                    {
                        Toast.makeText(getBaseContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getBaseContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
                    }

                }


                else {
                    DatabaseOperationss DB = new DatabaseOperationss(ctx);
                    DB.putInfo(DB, customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar);
                    Toast.makeText(getBaseContext(), "Customer is added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
