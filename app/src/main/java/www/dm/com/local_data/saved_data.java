package www.dm.com.local_data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class saved_data {

    public String get_lan(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("language", Context.MODE_PRIVATE);
        return sharedPreferences.getString("lan", "en");

    }


    //GET NAME
    public String get_name(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("personal_info", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "0");
        return name;
    }

    //GET EMAIL
    public String get_email(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("personal_info", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "0");
        return email;
    }

    //GET PHONE
    public String get_id(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("personal_info", MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "0");
        return id;
    }


    //GET LOGIN STATUS
    public Boolean get_login_status(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("login_bool", MODE_PRIVATE);
        Boolean status = sharedPreferences.getBoolean("login_bool", false);
        return status;
    }

    //GET DATE
    public String get_date(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("date", MODE_PRIVATE);
        String date = sharedPreferences.getString("date", "0");
        return date;
    }

    //GET DAY
    public int get_day(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("day", MODE_PRIVATE);
        int day = sharedPreferences.getInt("day", 1);
        return day;
    }

}
