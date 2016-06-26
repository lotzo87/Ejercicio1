package mx.com.idmexico.vvazquez.interfaces.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelUser;

/**
 * Created by sistemas on 26/06/2016.
 */
public class Preferences {
    private static final String FILE_NAME ="user_preferences";
    private final SharedPreferences preferences;

    public Preferences(Context context)
    {
        preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }
    public void saveUser(String last_session)
    {
        if (!last_session.equals(""))
            preferences.edit().putString("last_session", last_session).apply();
    }
    public String getLastSession()
    {
        String last_session=preferences.getString("last_session",null);
        return last_session;

    }
}
