package in.aayush.littleboxmodule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserList extends AppCompatActivity implements ListView.OnItemClickListener  {
    public static final String userid = "userid";
    public static final String username = "username";
    public static final String fromtime = "fromtime";
    public static final String totime = "totime";

    public static final String ROOT_URL = "http://androidcodetadka.com./";

     ListView listView;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listView = (ListView) findViewById(R.id.lvuser);
        getUser();
        listView.setOnItemClickListener(this);
    }


    private void getUser() {

        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);


        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        RetrofitAPIGet api = adapter.create(RetrofitAPIGet.class);
       // Toast.makeText(UserList.this, "Hello123", Toast.LENGTH_SHORT).show();

        api.getUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> list, Response response) {
              //  Toast.makeText(UserList.this, "heya", Toast.LENGTH_SHORT).show();
                loading.dismiss();
                users = list;
                showList();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(UserList.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


    private void showList(){

        String[] names = new String[users.size()];


        for(int i=0; i<users.size(); i++){

            names[i] = users.get(i).getUserName();

        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.ulist,names);
        listView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, ShowUserDetails.class);

        User user = users.get(position);

        intent.putExtra(userid,user.getUserId());
        intent.putExtra(username,user.getUserName());
        intent.putExtra(fromtime,user.getFromTime());
        intent.putExtra(totime,user.getToTime());

        startActivity(intent);

    }
}
