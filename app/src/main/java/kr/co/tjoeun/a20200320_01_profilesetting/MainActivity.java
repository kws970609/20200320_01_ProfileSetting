package kr.co.tjoeun.a20200320_01_profilesetting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import kr.co.tjoeun.a20200320_01_profilesetting.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("화면재등장","화면 재등장할때마다 실행");
    }

    @Override
    public void setupEvents() {
        binding.profilePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                갤러리에서 사진 가져오기
//                안드로이드가 제공하는 화면 => Intent로 이동.

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

    }
}
