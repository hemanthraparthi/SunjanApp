package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/28/2016.
 */
public class DeleteActivity extends Activity {
    Bundle BN;
    String customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround;
    TextView Warning;
    Button Del;
    Context ctx=this;
    DatabaseOperations dop=new DatabaseOperations(ctx);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
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
        Warning=(TextView)findViewById(R.id.tb);
        Del=(Button) findViewById(R.id.del);
        Warning.setText("Are You Sure You Want To Delete Customer :"+customer_name);
        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dop.deleteuser(dop,customer_name,phone_number,length,inside,buttom,thies,hips,waist,fullround);
                Toast.makeText(getBaseContext(),"CUSTOMER REMOVED",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
