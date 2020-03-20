package kr.co.tjoeun.a20200320_01_profilesetting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import kr.co.tjoeun.a20200320_01_profilesetting.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private static final int REQUESTFOR_ALBUM = 1000;

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
                startActivityForResult(intent,REQUESTFOR_ALBUM);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTFOR_ALBUM){
            if(resultCode == RESULT_OK) {
                if (data.getData() != null) {
                    Log.d("사진가져오기",data.getData().toString());

                }
            }
        }
    }
}
