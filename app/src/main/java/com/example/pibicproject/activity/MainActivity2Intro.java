package com.example.pibicproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pibicproject.R;
import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity2Intro extends IntroActivity {

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_activity2_intro);

        verificarUsusarioLogado();;


        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment((R.layout.intro_1))
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment((R.layout.intro_3))
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment((R.layout.intro_2))
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment((R.layout.intro_cadastro))
                .build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsusarioLogado();
    }

    public  void btEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));

    }

    public  void verificarUsusarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();


        if(autenticacao.getCurrentUser() !=null){
            abrirTelaPrincipal();
        }

    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, MenuPrincipal.class));

    }
}