package www.mensajerosurbanos.com.co.login.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.mensajerosurbanos.com.co.login.Models.CardModelo;
import www.mensajerosurbanos.com.co.login.R;
import www.mensajerosurbanos.com.co.login.RecyclerViewAdapter;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapterEmail;
    private TextView text_emailR;
    String email;

    ArrayList<CardModelo> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        text_emailR = findViewById(R.id.text_emailR);

        recyclerView = findViewById(R.id.recicler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        lista = new ArrayList<>();

        adapterEmail = new RecyclerViewAdapter(lista);
        recyclerView.setAdapter(adapterEmail);

        obtener();


        email = getIntent().getStringExtra("email");
        text_emailR.setText("Email: " + email);


    }

    public void obtener(){

        lista.add(new CardModelo("Email"));
        lista.add(new CardModelo("Email"));
        lista.add(new CardModelo("Email"));

        adapterEmail.notifyDataSetChanged();

    }
}
