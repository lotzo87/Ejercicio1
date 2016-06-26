package mx.com.idmexico.vvazquez.interfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by sistemas on 19/06/2016.
 */
public class Detail extends AppCompatActivity {

    String userName;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        EditText UserText = (EditText) findViewById(R.id.txtUserNameDetail);

        UserText.setText(getIntent().getExtras().getString("user_name_key"));
    }
}
