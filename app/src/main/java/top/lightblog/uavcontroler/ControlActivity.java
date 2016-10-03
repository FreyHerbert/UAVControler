package top.lightblog.uavcontroler;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import top.lightblog.asynctask.SwitchBlinkTask;
import top.lightblog.helper.*;

public class ControlActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{

    //震动传感器
    private Vibrator vibrator;
    long [] pattern = {0,25};   // 震动设置
    //声明控件
    private Button btnSwitch;
    private Button btnForward;
    private Button btnBack;
    private Button btnLeft;
    private Button btnRight;
    private Button btnLaunch;
    private Button btnLanding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Screen.setFullScreen(this);

        //获取震动传感器
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        //获取所有button添加到List中
        List<Button> btnList = new ArrayList<Button>();
        btnList.add(btnSwitch  = (Button)findViewById(R.id.btn_switch));
        btnList.add(btnForward = (Button)findViewById(R.id.btn_forward));
        btnList.add(btnBack = (Button)findViewById(R.id.btn_back));
        btnList.add(btnLeft = (Button)findViewById(R.id.btn_left));
        btnList.add(btnRight = (Button)findViewById(R.id.btn_right));
        btnList.add(btnLaunch = (Button)findViewById(R.id.btn_launch));
        btnList.add(btnLanding = (Button)findViewById(R.id.btn_landing));

        //所有button添加onClick和onTouch监听器
        for(Button btn : btnList){
            btn.setOnClickListener(this);
            btn.setOnTouchListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        //触发按钮释放震动反馈
        vibrator.vibrate(pattern,-1);
        switch (view.getId()){
            case R.id.btn_switch:   new SwitchBlinkTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, btnSwitch);
                break;
            case R.id.btn_forward:
                break;
            case R.id.btn_back:
                break;
            case R.id.btn_left:
                break;
            case R.id.btn_right:
                break;
            case R.id.btn_launch:
                break;
            case R.id.btn_landing:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //触发按钮按下震动反馈
        vibrator.vibrate(pattern,-1);
        return false;
    }
}
