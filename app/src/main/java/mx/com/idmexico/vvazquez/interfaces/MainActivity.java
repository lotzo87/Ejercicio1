package mx.com.idmexico.vvazquez.interfaces;

import android.content.Intent;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelUser;
import mx.com.idmexico.vvazquez.interfaces.Sql.UserDataSource;
import mx.com.idmexico.vvazquez.interfaces.Util.Preferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eUsuario;
    private EditText eContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_login).setOnClickListener(this);
        findViewById(R.id.activity_main_registro).setOnClickListener(this);
        eUsuario = (EditText) findViewById(R.id.activity_main_usuario);
        eContra = (EditText) findViewById(R.id.activity_main_contrasenia);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_main_login:
                validaAcceso();
                break;
            case R.id.activity_main_registro:
                registraUsuario();
        }

    }

    private void registraUsuario() {
        Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    private void validaAcceso() {
        final String usuario   = eUsuario.getText().toString();
        final String contra = eContra.getText().toString();
        //final String usr ="Victor";
        //final String pwd = "V1c70r";
        UserDataSource usrSrc = new UserDataSource(getApplicationContext());
        List<ModelUser> modelUsr = usrSrc.getUser(usuario, contra);
        if (!modelUsr.isEmpty()) {
            if (usuario.equals(modelUsr.get(0).getUser()) && contra.equals(modelUsr.get(0).getPassword())) {
                Toast.makeText(getApplicationContext(), R.string.login_adv, Toast.LENGTH_SHORT).show();
                Preferences p = new Preferences(getApplicationContext());
                p.saveLastSession(String.valueOf(modelUsr.get(0).getId()), java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()));
                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("user_name_key", usuario);
                startActivity(intent);
            } else
                Toast.makeText(getApplicationContext(), R.string.reg_adv, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), R.string.reg_adv, Toast.LENGTH_SHORT).show();

    }
}
