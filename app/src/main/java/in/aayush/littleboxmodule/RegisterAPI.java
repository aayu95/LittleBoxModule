package in.aayush.littleboxmodule;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Aayush on 30-05-2016.
 */

    public interface RegisterAPI {
        @FormUrlEncoded
        @POST("/littlebox/insert.php")
        public void insertUser(
                @Field("username") String username,
                @Field("password") String password,
                @Field("fromtime") String fromtime,
                @Field("totime") String totime,
                Callback<Response> callback);
    }

