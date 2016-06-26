package mx.com.idmexico.vvazquez.interfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelUser;
import mx.com.idmexico.vvazquez.interfaces.Sql.MyDbHelper;
import mx.com.idmexico.vvazquez.interfaces.Sql.UserDataSource;

/**
 * Created by sistemas on 26/06/2016.
 */


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText mUser = (EditText) findViewById(R.id.mUserRegister);
        final EditText mPassword = (EditText) findViewById(R.id.mPasswordRegister);
        findViewById(R.id.btnRegisterUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUser.getText().toString().trim();
                String password= mPassword.getText().toString().trim();
                if ((!userName.equals("")) && (!mPassword.equals("")))
                {
                    String date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    ModelUser modelUsr = new ModelUser(0,userName, password, date, 0);
                    UserDataSource userSrc = new UserDataSource(getApplicationContext());
                    userSrc.saveUser(modelUsr);
                    finish();
                }
            }
        });
    }
}
