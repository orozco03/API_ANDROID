package www.mensajerosurbanos.com.co.login.Activitys;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.mensajerosurbanos.com.co.login.AdminSQLiteOpenHelper;
import www.mensajerosurbanos.com.co.login.R;

public class MainActivity extends AppCompatActivity {


    private Cursor fila;
    private Context context;

    @BindView(R.id.edit_user)
     EditText edit_email;

    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.btn_login)
    Button btn_login;


    AdminSQLiteOpenHelper admin;
    SQLiteDatabase BD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = this;

        admin = new AdminSQLiteOpenHelper(context);
        BD = admin.getReadableDatabase();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }


    public void login (){
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();
        fila = BD.rawQuery("SELECT EMAIL,PASSWORD FROM USUARIOS WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'",null);

        if (fila.moveToFirst()){
            String usu = fila.getString(0);
            String pass = fila.getString(1);
            if (email.equals(usu) && password.equals(pass)){

                Intent intent = new Intent(this,UserActivity.class);
                intent.putExtra("email", email);
                edit_email.setText("");
                edit_password.setText("");
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(this, R.string.usu_incorrecto, Toast.LENGTH_LONG).show();
        }
    }

    public void registro (View view){
        Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
        startActivity(intent);
    }

}
