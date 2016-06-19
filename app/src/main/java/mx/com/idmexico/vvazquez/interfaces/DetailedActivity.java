package mx.com.idmexico.vvazquez.interfaces;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;

import mx.com.idmexico.vvazquez.interfaces.Fragmentos.FragmentList;
import mx.com.idmexico.vvazquez.interfaces.Fragmentos.FragmentProfile;

/**
 * Created by sistemas on 17/06/2016.
 */
public class DetailedActivity extends AppCompatActivity implements View.OnClickListener{
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);
        findViewById(R.id.btnFragmentoPerfil).setOnClickListener(this);
        findViewById(R.id.btnFragmentoLista).setOnClickListener(this);
        userName = getIntent().getExtras().getString("user_name_key");
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
        }
    }

    private void showFragmentList() {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor,new FragmentList() ).commit();
    }

    private void showFragmentUserProfile() {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor, FragmentProfile.newFragmentProfile(userName)).commit();
    }
}
