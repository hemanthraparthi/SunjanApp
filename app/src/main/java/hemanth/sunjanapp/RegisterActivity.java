package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class RegisterActivity extends Activity {
    EditText Customer_name,Phone_number,Length,Inside,Buttom,Thies,Hips,Waist,Fullround;
    String customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround;
    Button Submit;
    Context ctx=this;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Customer_name=(EditText) findViewById(R.id.editText);
        Phone_number=(EditText) findViewById(R.id.editText11);
        Length=(EditText) findViewById(R.id.editText1);
        Inside=(EditText) findViewById(R.id.editText2);
        Buttom=(EditText) findViewById(R.id.editText3);
        Thies=(EditText) findViewById(R.id.editText4);
        Hips=(EditText) findViewById(R.id.editText5);
        Waist=(EditText) findViewById(R.id.editText6);
        Fullround=(EditText) findViewById(R.id.editText7);
        Submit=(Button) findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer_name=Customer_name.getText().toString();
                phone_number=Phone_number.getText().toString();
                length=Length.getText().toString();
                inside=Inside.getText().toString();
                buttom=Buttom.getText().toString();
                thies=Thies.getText().toString();
                hips=Hips.getText().toString();
                waist=Waist.getText().toString();
                fullround=Fullround.getText().toString();
                if(customer_name.isEmpty()||phone_number.isEmpty()||length.isEmpty()||inside.isEmpty()||buttom.isEmpty()||thies.isEmpty()||hips.isEmpty()||waist.isEmpty()||fullround.isEmpty())
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
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInfo(DB, customer_name, phone_number, length, inside, buttom, thies, hips, waist, fullround);
                    Toast.makeText(getBaseContext(), "Customer is added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

}
