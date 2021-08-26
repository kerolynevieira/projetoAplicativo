package com.example.pibicproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pibicproject.R;
import com.example.pibicproject.adapter.AdapterMovimentacao;
import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.example.pibicproject.helper.Base64Custom;
import com.example.pibicproject.model.Movimentacao;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity {

    private MaterialCalendarView calendarView;
    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();

    private RecyclerView recyclerView;
    private AdapterMovimentacao adapterMovimentacao;
    private List<Movimentacao> movimentacoes = new ArrayList<>();
    private  DatabaseReference movimentacaoRef;
    private  String mesAnoSelecionado;
    private ValueEventListener valueEventListenerMovimentacoes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Menu Principal");
        setSupportActionBar(toolbar);

        calendarView = findViewById(R.id.calendarView);

        configuraCalendarView();

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        Movimentacao mov = new Movimentacao();
//        mov.s
//        movimentacoes.add(new Movimentacao());
        adapterMovimentacao = new AdapterMovimentacao(movimentacoes, this);
        recyclerView = findViewById(R.id.recyclerMovimentos);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMovimentacao);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }

    public void recuperarMovimentacoes()
    {
        String emailUsuario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64(emailUsuario);

        movimentacaoRef = firebaseRef.child("movimentacao")
                                     .child(idUsuario)
                                     .child(mesAnoSelecionado);

        valueEventListenerMovimentacoes = movimentacaoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot datasnapshot)
            {
                movimentacoes.clear();

                for (DataSnapshot dados: datasnapshot.getChildren())
                {
                    Movimentacao movimentacao =dados.getValue(Movimentacao.class);
                    movimentacoes.add(movimentacao);
                }

                adapterMovimentacao.notifyDataSetChanged();

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSair:
                autenticacao.signOut();
                startActivity(new Intent(this, MainActivity2Intro.class) );
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void adicionarIqa(View view){

        startActivity(new Intent(this, MainActivity.class));

    }

    public void adicionarGut(View view){
        startActivity(new Intent(this, Tela02.class));

    }
    public void adicionarGrafico(View view){

    }

    public void configuraCalendarView(){
        CharSequence meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        calendarView.setTitleMonths(meses);
        CalendarDay dataAtual = calendarView.getCurrentDate();
        String mesSelecionado = String.format("%02d",(dataAtual.getMonth() + 1));
        mesAnoSelecionado = String.valueOf( mesSelecionado + "" + dataAtual.getYear());

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                String mesSelecionado = String.format("%02d",(date.getMonth() + 1));
                mesAnoSelecionado = String.valueOf((mesSelecionado + 1) + "" + date.getYear());
                movimentacaoRef.removeEventListener(valueEventListenerMovimentacoes);
                recuperarMovimentacoes();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recuperarMovimentacoes();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        movimentacaoRef.removeEventListener(valueEventListenerMovimentacoes);


    }
}