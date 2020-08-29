package com.example.kalici_degiskenler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
/*
* Telefon her yatay pozisyona geldiği zaman veya yatay pozisyondan dikey pozisyona geldiği zaman
* uygulama yeniden başlar bu durumda daha önceden yapılan işlemlerdeki kaydedilen verilerin kaybolmasına
* sebep olur Bunu önlemek için kalıcı değişkenler kullanılır*/
public class MainActivity extends AppCompatActivity {
Button btn_arttir;
TextView tv_sayac;
int sayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //eğer null değilse yani içerisine birşeyler eklendi ise
        if(savedInstanceState != null){
            sayac= savedInstanceState.getInt("sayacdegeri");
            tv_sayac.setText("Sayac : "+sayac);
        }
        //eğer daha önceden içeriye herhangi bir değer eklenmedi ise
        else{
            sayac =0;
        }
        setContentView(R.layout.activity_main);
        btn_arttir = (Button)findViewById(R.id.btn_arttir);
        tv_sayac = (TextView)findViewById(R.id.tv_id);
        btn_arttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayac++;
                tv_sayac.setText("Sayac : "+sayac);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //Bundle içerisine kaydetmek istediğim verileri ekliyorum
        super.onSaveInstanceState(outState);
        outState.putInt("sayacdegeri",sayac);
    }
}
