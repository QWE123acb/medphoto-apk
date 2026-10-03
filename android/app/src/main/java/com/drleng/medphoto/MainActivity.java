package com.drleng.medphoto;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册应用内安装插件（自动更新）
        registerPlugin(InstallPlugin.class);
        // 锁定网页文字缩放为 100%，避免跟随系统字体大小设置导致界面文字过大
        WebView webView = getBridge().getWebView();
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setTextZoom(100);
        }
    }
}
