package com.drleng.medphoto;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        // Android 15+ 强制 edge-to-edge：WebView 会延伸到状态栏和手势导航条下方，
        // 而 WebView 不支持 CSS env(safe-area-inset-*)，网页端无法自行避让。
        // 这里在原生层把系统栏 insets 设为根视图内边距，让网页整体落在安全区域内。
        ViewCompat.setOnApplyWindowInsetsListener(
                getWindow().getDecorView().findViewById(android.R.id.content),
                (view, insets) -> {
                    Insets sys = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    view.setPadding(sys.left, sys.top, sys.right, sys.bottom);
                    return insets;
                });
    }
}
