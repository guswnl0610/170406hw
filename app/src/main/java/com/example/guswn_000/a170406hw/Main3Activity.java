package com.example.guswn_000.a170406hw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
{
    TextView name, menu1,menu2,menu3,tvtel,tvaddress,tvdate;
    ImageView imageView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = (TextView)findViewById(R.id.txtname);
        menu1 = (TextView)findViewById(R.id.etmenu1);
        menu2 = (TextView)findViewById(R.id.etmenu2);
        menu3 = (TextView)findViewById(R.id.etmenu3);
        tvtel = (TextView)findViewById(R.id.tvTel);
        tvaddress = (TextView)findViewById(R.id.tvURL);
        tvdate = (TextView)findViewById(R.id.tvRegdate);
        back = (Button)findViewById(R.id.btnback) ;
        imageView = (ImageView)findViewById(R.id.imgno);
        Intent intent = getIntent();
        Restaurant res = intent.getParcelableExtra("restinfo");

        name.setText(res.getName());
        menu1.setText(res.getmenu1());
        menu2.setText(res.getmenu2());
        menu3.setText(res.getmenu3());
        tvtel.setText(res.getTel());
        tvdate.setText(res.getDate());
        tvaddress.setText(res.getHomepage());
        if(res.getCategorynum() == 1) // 치킨
        {
            imageView.setImageResource(R.drawable.chicken);
        }
        else if (res.getCategorynum() == 2) //피자
        {
            imageView.setImageResource(R.drawable.pizza);
        }
        else //햄버거
        {
            imageView.setImageResource(R.drawable.hamburger);
        }
    }

    public void onClick(View v)
    {
        Intent intent = getIntent();
        Restaurant res = intent.getParcelableExtra("restinfo");
        switch (v.getId())
        {
            case R.id.btnback:
                finish();
                break;
            case R.id.imageView2://전화
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+res.getTel()));
                startActivity(intent2);
                break;

            case R.id.imageView3:
                Intent intent3 = new Intent(Intent.ACTION_VIEW,Uri.parse(res.getHomepage()));
                startActivity(intent3);
                break;
        }
    }
}
