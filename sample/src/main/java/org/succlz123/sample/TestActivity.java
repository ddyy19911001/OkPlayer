package org.succlz123.sample;

import org.succlz123.okplayer.utils.OkPlayerUtils;
import org.succlz123.okplayer.view.OkVideoView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by succlz123 on 15/12/2.
 */
public class TestActivity extends AppCompatActivity {
    private OkVideoView mOkVideoView;
    private Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test);

        mOkVideoView = (OkVideoView) findViewById(R.id.ok_video_view);

//        String storagePath = Environment.getExternalStorageDirectory().getAbsolutePath();
//        mUri = Uri.parse(storagePath + File.separator + "0.mp4");

        mUri = Uri.parse("http://121.41.72.231/hls/demo1.m3u8");
        mOkVideoView.setRendererContentType(OkPlayerUtils.TYPE_HLS);
        mOkVideoView.setVideoUri(mUri);
    }

    @Override
    public void onNewIntent(Intent intent) {
        mOkVideoView.onNewIntent();
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        mOkVideoView.onResume(mUri);
    }

    @Override
    public void onPause() {
        super.onPause();
        mOkVideoView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOkVideoView.onDestroy();
    }
}
