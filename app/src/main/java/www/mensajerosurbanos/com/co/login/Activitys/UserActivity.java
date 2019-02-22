package www.mensajerosurbanos.com.co.login.Activitys;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import www.mensajerosurbanos.com.co.login.Models.RetrofitClientInstance;
import www.mensajerosurbanos.com.co.login.Models.ScrollListener;
import www.mensajerosurbanos.com.co.login.Models.Topartists;
import www.mensajerosurbanos.com.co.login.R;
import www.mensajerosurbanos.com.co.login.RecyclerViewAdapter;

public class UserActivity extends AppCompatActivity {

    String email;

    @BindView(R.id.recicler)
    RecyclerView recyclerView;

    @BindView(R.id.text_emailR)
    TextView text_emailR;

    @BindView(R.id.btn_salir)
     Button btn_salir;

    ArrayList<Artists> lista;

    private RecyclerViewAdapter adapter;
    ProgressDialog progressDialog;

    private ScrollListener scrollListener;

    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        lista = new ArrayList<>();


        progressDialog = new ProgressDialog(UserActivity.this);
        progressDialog.setMessage("Cargando....");
        progressDialog.show();

        recyclerView = findViewById(R.id.recicler);
        adapter = new RecyclerViewAdapter(this, lista);

        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);


        email = getIntent().getStringExtra("email");
        text_emailR.setText("Email: " + email);

        scroll();
        getData();


    }


    public void scroll(){
        scrollListener = new ScrollListener(gridLayoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.e("Scroll", "cargar datos....");

            }
        };

        recyclerView.addOnScrollListener(scrollListener);
    }


    public void getData(){
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






    private void generateDataList (Topartists photoList){
            Collections.addAll(lista, photoList.getArtists().getArtists());
            adapter.notifyDataSetChanged();
    }

    public void ClosedBTN (View view){
        finish();
    }

}



