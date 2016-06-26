package mx.com.idmexico.vvazquez.interfaces;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import mx.com.idmexico.vvazquez.interfaces.Fragmentos.FragmentList;
import mx.com.idmexico.vvazquez.interfaces.Fragmentos.FragmentProfile;
import mx.com.idmexico.vvazquez.interfaces.Sql.UserDataSource;
import mx.com.idmexico.vvazquez.interfaces.Util.Preferences;

/**
 * Created by sistemas on 17/06/2016.
 */
public class DetailedActivity extends AppCompatActivity implements View.OnClickListener{
    private String userName;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);
        findViewById(R.id.btnFragmentoPerfil).setOnClickListener(this);
        findViewById(R.id.btnFragmentoLista).setOnClickListener(this);
        findViewById(R.id.btnSalir).setOnClickListener(this);
        textView = (TextView) findViewById(R.id.eSession);
        userName = getIntent().getExtras().getString("user_name_key");
        textView.setText(getIntent().getExtras().getString("last_session"));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case (R.id.btnFragmentoPerfil):
                showFragmentUserProfile();
                break;
            case (R.id.btnFragmentoLista):
                showFragmentList();
                break;
            case (R.id.btnSalir):
                deleteData();
                break;
        }
    }

    private void deleteData() {
        Preferences p = new Preferences(getApplicationContext());
        UserDataSource source = new UserDataSource(getApplicationContext());
        p.deletePreferences();
        source.deleteAll();
        finish();
    }

    private void showFragmentList() {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor,new FragmentList() ).commit();
    }

    private void showFragmentUserProfile() {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor, FragmentProfile.newFragmentProfile(userName)).commit();
    }
}
