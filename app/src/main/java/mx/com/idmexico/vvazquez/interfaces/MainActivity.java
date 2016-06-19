package mx.com.idmexico.vvazquez.interfaces;

import android.content.Intent;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eUsuario;
    private EditText eContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_login).setOnClickListener(this);
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
        }

    }

    private void validaAcceso() {
        final String usuario   = eUsuario.getText().toString();
        final String contra = eContra.getText().toString();
        final String usr ="Victor";
        final String pwd = "V1c70r";

            if(usuario.equals(usr) && contra.equals(pwd))
            {
                Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("user_name_key",usuario);
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();

    }
}
