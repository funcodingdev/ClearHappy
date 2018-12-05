package com.hasee.clearhappy.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hasee.clearhappy.R;
import com.hasee.clearhappy.interfaces.GameViewInterface;
import com.hasee.clearhappy.view.GameView;


public class GameActivity extends AppCompatActivity implements GameViewInterface {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
        gameView = (GameView)findViewById(R.id.myGameView);
        gameView.setGameViewInterface(this);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), msg.obj.toString(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void showMsg(String msg) {
        Message message = new Message();
        message.obj = msg;
        handler.sendMessage(message);
    }
}
