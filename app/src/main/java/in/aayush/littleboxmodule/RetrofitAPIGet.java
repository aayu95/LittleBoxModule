package in.aayush.littleboxmodule;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Aayush on 30-05-2016.
 */
public interface RetrofitAPIGet {

    @GET("/littlebox/users.php")
    public void getUsers(Callback<List<User>> response);

}
