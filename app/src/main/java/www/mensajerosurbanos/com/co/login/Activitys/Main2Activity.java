package www.mensajerosurbanos.com.co.login.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.mensajerosurbanos.com.co.login.R;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        String URL = getIntent().getStringExtra("web");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(URL);
    }

    public void Closed (View view){
        finish();
    }
}
