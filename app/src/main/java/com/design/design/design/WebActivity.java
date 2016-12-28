package com.design.design.design;

import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    String url = "https://www.google.al";
    private WebView google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        openGoogle();
    }
    protected void openGoogle(){
        google = (WebView) findViewById( R.id.webView) ;
        google.setWebViewClient(new newBroswer());
        google.getSettings().setLoadsImagesAutomatically(true);
        google.getSettings().setJavaScriptEnabled(true);
        google.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        google.loadUrl(url.toString());
    }
    private class newBroswer extends WebViewClient {

        public boolean shouldOverridweUrlLoading (WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
