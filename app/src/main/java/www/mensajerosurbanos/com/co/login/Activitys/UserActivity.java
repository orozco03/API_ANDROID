package www.mensajerosurbanos.com.co.login.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.mensajerosurbanos.com.co.login.Models.Api_Service;
import www.mensajerosurbanos.com.co.login.Models.Artists;
import www.mensajerosurbanos.com.co.login.Models.ListArtistas;
import www.mensajerosurbanos.com.co.login.Models.RetrofitClientInstance;
import www.mensajerosurbanos.com.co.login.Models.Topartists;
import www.mensajerosurbanos.com.co.login.R;
import www.mensajerosurbanos.com.co.login.RecyclerViewAdapter;

public class UserActivity extends AppCompatActivity {

    String email;

    @BindView(R.id.recicler)
    RecyclerView recyclerView;

    @BindView(R.id.text_emailR)
    TextView text_emailR;

    //@BindView(R.id.text_url)
    //TextView text_url;

    ArrayList<Artists> lista;

    private RecyclerViewAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);


        lista = new ArrayList<>();

        //adapterEmail = new RecyclerViewAdapter(lista);
        //recyclerView.setAdapter(adapterEmail);

        progressDialog = new ProgressDialog(UserActivity.this);
        progressDialog.setMessage("Cargando....");
        progressDialog.show();

        recyclerView = findViewById(R.id.recicler);
        adapter = new RecyclerViewAdapter(this, lista);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);


        email = getIntent().getStringExtra("email");
        text_emailR.setText("Email: " + email);

        Api_Service service = RetrofitClientInstance.getRetrofitInstance().create(Api_Service.class);
        Call<Topartists> call = service.getAllArtists();

        call.enqueue(new Callback<Topartists>() {
            @Override
            public void onResponse(Call<Topartists> call, Response<Topartists> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<Topartists> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UserActivity.this, "Algo anda mal!", Toast.LENGTH_LONG).show();
            }
        });
    }

    //public void Navigation(View view){
    //    Intent i = new Intent(this, Main2Activity.class);
    //    i.putExtra("web", text_url.getText().toString());
    //    startActivity(i);
    //}

        private void generateDataList (Topartists photoList){
            Collections.addAll(lista, photoList.getArtists().getArtists());
            adapter.notifyDataSetChanged();
        }

}



