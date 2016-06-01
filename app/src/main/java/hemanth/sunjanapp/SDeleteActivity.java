package hemanth.sunjanapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hemanth on 5/30/2016.
 */
public class SDeleteActivity extends Activity {
    Bundle BN;
    String customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar;
    TextView Warning;
    Button Del;
    Context ctx=this;
    DatabaseOperationss dop=new DatabaseOperationss(ctx);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
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
        Warning=(TextView)findViewById(R.id.tb);
        Del=(Button) findViewById(R.id.del);
        Warning.setText("Are You Sure You Want To Delete Customer :"+customer_name);
        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dop.deleteuser(dop,customer_name,phone_number,length,shoulder,chest,stomach,hand_length,hand_loose,collar);
                Toast.makeText(getBaseContext(),"CUSTOMER REMOVED",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
