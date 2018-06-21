package cn.zgy.rxtools.activity;


import android.os.Bundle;
import android.view.View;

import cn.zgy.rxtool.RxActivityTool;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.multitype.normal.NormalActivity;
import cn.zgy.rxtools.refresh.activity.MainRefreshActivity;
import cn.zgy.rxview.activity.ActivityBase;

public class OtherActivity extends ActivityBase implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        initView();
    }

    private void initView() {
        findViewById(R.id.banner).setOnClickListener(this);
        findViewById(R.id.multitype).setOnClickListener(this);
        findViewById(R.id.rxeasyhttp).setOnClickListener(this);
        findViewById(R.id.refresh).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.banner){
            RxActivityTool.skipActivity(this, BannerActivity.class);
        }

        if(v.getId() == R.id.multitype){
            RxActivityTool.skipActivity(this, NormalActivity.class);
        }

        if(v.getId() == R.id.rxeasyhttp){
            RxActivityTool.skipActivity(this, RxEasyHttpActivity.class);
        }
        if(v.getId() == R.id.refresh){
            RxActivityTool.skipActivity(this, MainRefreshActivity.class);
        }
    }
}
