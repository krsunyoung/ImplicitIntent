package com.bit2016.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener{
//구현 안했을때 alt+enter 누르면 구현할수 있게 만들어줌.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate ---.xml 로 되어있는 파일을 버튼 클래스로 만들어서 activity위에 올리는것.
        setContentView(R.layout.activity_main);

        //Button button = (Button)findViewById(R.id.button_call);
        //button.setOnClickListener(new View.OnClickListener() {
//        아래 처럼 바꿔서 해도 된다. anonymonceclass? 어노니먼스클래스?? 이름이 없는 클래스
//        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view){
//
//            }
//        });
        //});
        findViewById(R.id.button_call).setOnClickListener(this);
        findViewById(R.id.button_address).setOnClickListener(this);
        findViewById(R.id.button_web).setOnClickListener(this);
        findViewById(R.id.button_search).setOnClickListener(this);
        findViewById(R.id.button_map).setOnClickListener(this);
        findViewById(R.id.button_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewid=view.getId();
        switch(viewid  ){
            case R.id.button_call: {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1234-5678"));
                //아래와 같이 따로 입력하게 할수 있음
                //Intent intent = new Intent(Intent.ACTION_CALL);
                //intent.setData(Uri.pase("tel:010-1234-5678");
                startActivity(intent); //마시멜로우에서 권한이 강화되서 줄이 쳐진것. [롤리팝 버전으로 낮춰짐 bradleScripts 에서 build.gradle(Modul:app) 에서       targetSdkVersion 22 로 변경
                break;
            }
            case R.id.button_address: {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(Uri.parse("content://com.android.contacts/data/phones"));
                startActivity(intent);
                break;
            }
            case R.id.button_web:{
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
                break;
            }
            case R.id.button_search:{
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.android.browser");
                intent.putExtra("query", "android");
                startActivity(intent);
                break;
            }
            case R.id.button_map:{
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
                break;
            }
            case R.id.button_share:{
                Intent intent =new Intent("com.bit2016.android.action.ACTION_SHARE");
                startActivity(intent);
                break;
            }
            default: {
                Toast.makeText(this, "unknown view", Toast.LENGTH_LONG).show();
            }
        }
    }
}
