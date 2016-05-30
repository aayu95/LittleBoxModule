package in.aayush.littleboxmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowUserDetails extends AppCompatActivity {
    TextView uid,uname,uftime,uttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_details);


        uid = (TextView) findViewById(R.id.tvid1);
        uname = (TextView) findViewById(R.id.tvname1);
        uftime = (TextView) findViewById(R.id.tvfrom1);
        uttime = (TextView) findViewById(R.id.tvto1);


        Intent intent = getIntent();


        uid.setText(String.valueOf(intent.getIntExtra(UserList.userid, 0)));
        uname.setText(intent.getStringExtra(UserList.username));
        uftime.setText(intent.getStringExtra(UserList.fromtime));
        uttime.setText(intent.getStringExtra(UserList.totime));
    }
}
