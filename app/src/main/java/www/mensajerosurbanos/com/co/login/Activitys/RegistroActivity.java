package www.mensajerosurbanos.com.co.login.Activitys;


import android.content.Context;
import android.content.Intent;
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

public class RegistroActivity extends AppCompatActivity {


    private Context context;

    @BindView(R.id.edit_emailReg)
    EditText edit_email;

    @BindView(R.id.edit_passReg)
    EditText edit_pass;

    @BindView(R.id.btn_singReg)
    Button btn_singReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ButterKnife.bind(this);

        context = this;
        final String email = edit_email.getText().toString();

        final AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext());


        btn_singReg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(edit_email.getText().toString().trim().isEmpty() && edit_pass.getText().toString().trim().isEmpty()){

                    Toast.makeText(context, R.string.no_camp,Toast.LENGTH_LONG).show();
                }else{
                    admin.agregar(edit_email.getText().toString(),edit_pass.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    Toast.makeText(context, R.string.exit,Toast.LENGTH_LONG).show();
                }


            }
        });

    }

}
