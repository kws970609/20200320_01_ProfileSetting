package kr.co.tjoeun.a20200320_01_profilesetting;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import kr.co.tjoeun.a20200320_01_profilesetting.databinding.ActivityMainBinding;

public abstract class BaseActivity extends AppCompatActivity {



    public Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();

}
