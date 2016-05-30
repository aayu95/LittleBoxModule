package in.aayush.littleboxmodule;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {
EditText fromTime , toTime , username , password ;
     int  mHour, mMinute;
    Button signup;
    int hr;
    public static final String ROOT_URL = "http://androidcodetadka.com/";

    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        fromTime=(EditText)view.findViewById(R.id.et3);
        toTime=(EditText)view.findViewById(R.id.et4);
        username=(EditText)view.findViewById(R.id.et1);
        password=(EditText)view.findViewById(R.id.et2);
        signup=(Button)view.findViewById(R.id.subtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
            }
        });
        fromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(),"TimePicker");


            }
        });
        toTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment2();
                newFragment.show(getFragmentManager(),"TimePicker");

            }
        });
    return (view);
    }

    private void insertUser() {

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ROOT_URL).build();
        RegisterAPI api = adapter.create(RegisterAPI.class);


        api.insertUser(

                username.getText().toString(),
                password.getText().toString(),
                fromTime.getText().toString(),
                toTime.getText().toString(),
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {

                        BufferedReader reader = null;

                        String output = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getActivity(), output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                        Toast.makeText(getActivity(), error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
