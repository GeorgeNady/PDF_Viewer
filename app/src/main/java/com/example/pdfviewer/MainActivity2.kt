package com.example.pdfviewer

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val url = "http://triggs.djvu.org/djvu-editions.com/BIBLES/DRV/Download.pdf"
        val finalURL = "https://drive.google.com/viewerng/viewer?embedded=true&url=$url"

        progressBar.visibility = View.VISIBLE

        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)


                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }

            }
        }

        webView.loadUrl(finalURL)

    }
}