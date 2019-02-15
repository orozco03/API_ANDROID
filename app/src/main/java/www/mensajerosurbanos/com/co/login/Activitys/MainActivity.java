package www.mensajerosurbanos.com.co.login.Activitys;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import www.mensajerosurbanos.com.co.login.AdminSQLiteOpenHelper;
import www.mensajerosurbanos.com.co.login.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_sinup, btn_login;
    private EditText edit_email, edit_password;
    private Cursor fila;
    private Context context;

    AdminSQLiteOpenHelper admin;
    SQLiteDatabase BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_email = findViewById(R.id.edit_user);
        edit_password = findViewById(R.id.edit_password);

        btn_login = findViewById(R.id.btn_login);
        btn_sinup = findViewById(R.id.btn_sinup);

        context = this;

        admin = new AdminSQLiteOpenHelper(context);
        BD = admin.getReadableDatabase();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        //btn_login.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {

         //       edit_email = findViewById(R.id.edit_user);
         //       edit_password = findViewById(R.id.edit_password);

         //       try {
           //         Cursor cursor =admin.login(edit_email.getText().toString(), edit_password.getText().toString());

             //       if (cursor.getCount()>0){
               //         Intent intent = new Intent(getApplicationContext(),UserActivity.class);
                 //       startActivity(intent);
                   // }else{
                     //  Toast.makeText(getApplicationContext(),"usuario incorrecto",Toast.LENGTH_LONG).show();
                   // }
                //}catch (SQLException e){
                  //  e.printStackTrace();
                //}

            //}
        //});


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
