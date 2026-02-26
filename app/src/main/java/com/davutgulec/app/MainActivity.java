package com.davutgulec.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private WebView webView;
    private ProgressBar progressBar;

    private static final String URL_HOME       = "https://www.davutgulec.com";
    private static final String URL_CATEGORIES = "https://www.davutgulec.com/category/haberler/";
    private static final String URL_SHARE      = "https://www.davutgulec.com/haber-paylas/";
    private static final String URL_CONTACT    = "https://linktr.ee/davutgulec";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView     = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);

        // WebView ayarları
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url.startsWith("https://www.davutgulec.com") ||
                    url.startsWith("https://davutgulec.com") ||
                    url.startsWith("https://linktr.ee/davutgulec")) {
                    return false;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });

        webView.loadUrl(URL_HOME);

        // Alt menü butonları
        LinearLayout btnHome       = findViewById(R.id.btnHome);
        LinearLayout btnCategories = findViewById(R.id.btnCategories);
        LinearLayout btnShare      = findViewById(R.id.btnShare);
        LinearLayout btnContact    = findViewById(R.id.btnContact);

        btnHome.setOnClickListener(v -> webView.loadUrl(URL_HOME));
        btnCategories.setOnClickListener(v -> webView.loadUrl(URL_CATEGORIES));
        btnShare.setOnClickListener(v -> webView.loadUrl(URL_SHARE));
        btnContact.setOnClickListener(v -> webView.loadUrl(URL_CONTACT));
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
