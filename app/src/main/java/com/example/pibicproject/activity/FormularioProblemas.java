package com.example.pibicproject.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pibicproject.R;
import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.example.pibicproject.helper.Base64Custom;
import com.example.pibicproject.helper.DateCustom;
import com.example.pibicproject.model.Movimentacao;
import com.example.pibicproject.model.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class FormularioProblemas extends AppCompatActivity {
    private SeekBar seekBarGravidade;
    private SeekBar seekBarUrgencia;
    private SeekBar seekBarTendencia;
    private TextView textGravidade;
    private TextView textUrgencia;
    private TextView textTendencia;
    private TextView nome;
    private TextView tv_prioridade;
    private TextView textView4;
    private FloatingActionButton fabSalvar;
    private TextInputEditText campoData;
    private Movimentacao movimentacao;
    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
    private Double ACAefluentett;
    private Double ACAmetaistt;
    private Double ACAquimicott;
    private Double ETEaguatt;
    private Double ETEprodutostt;
    private Double GERaguatt;
    private Double GERdocumentott;
    private Double GERgasestt;
    private Double LAVaguatt;
    private Double LAVquimicott;
    private Double ACAefluenteGerado;
    private Double ACAmetaisGerado;
    private Double ACAquimicoGerado;
    private Double ETEaguaGerado;
    private Double ETEprodutosGerado;
    private Double GERaguaGerado;
    private Double GERdocumentoGerado;
    private Double GERgasesGerado;
    private Double LAVaguaGerado;
    private Double LAVquimicoGerado;
    private String problemasTotal;
    private TipoProblemaEnum tipoProblemaEnum;










    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_formulario_problemas);



            Intent intent = getIntent();
            String parametro = (String) intent.getSerializableExtra("nome");
            nome = (TextView) findViewById(R.id.textView3);




            seekBarGravidade = findViewById(R.id.seekBarGravidade);
            seekBarUrgencia = findViewById(R.id.seekBarUrgencia);
            seekBarTendencia = findViewById(R.id.seekBarTendencia);
            textGravidade = findViewById(R.id.textGravidade);
            textUrgencia = findViewById(R.id.textUrgencia);
            textTendencia = findViewById(R.id.textTendencia);
            tv_prioridade = findViewById(R.id.tv_prioridade);
            fabSalvar = findViewById(R.id.fabSalvar);

            textView4 = findViewById(R.id.textView4);
            campoData = findViewById(R.id.editData);

            //Preenche campo data com a data atual

            campoData.setText(DateCustom.dataAtual());
            recuperarProblemaTotal();
            nome.setText(parametro);






            seekBarGravidade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



                    seekBarGravidade.getProgress();
                    preecheResultado();


                    String labelg = "GRAVIDADE:";
                    switch (progress) {
                        case 1:
                            labelg = labelg + "(Sem Gravidade)";
                            break;
                            case 2:
                                    labelg = labelg + "(Pouco Grave)";
                                    break;
                                case 3:
                                    labelg = labelg + "(Grave)";
                                    break;
                                case 4:
                                    labelg = labelg + "(Muito Grave)";
                                    break;
                                case 5:
                                    labelg = labelg + "(Gravíssimo)";
                                    break;
                            }

                            textGravidade.setText(labelg);

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }


                    });

            seekBarUrgencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                    seekBarUrgencia.getProgress();
                    preecheResultado();


                    String labelu = "URGÊNCIA:";
                    switch (progress) {
                        case 1:
                            labelu = labelu +"(Pode Esperar)";
                            break;
                        case 2:
                            labelu = labelu + "(Pouco Urgente)";
                            break;
                        case 3:
                            labelu = labelu + "(Urgente)";
                            break;
                        case 4:
                            labelu = labelu + "(Muito Urgente)";
                            break;
                        case 5:
                            labelu = labelu + "(Urgentíssimo)";
                            break;


                    }

                    textUrgencia.setText(labelu);


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }


            });

            seekBarTendencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    seekBarTendencia.getProgress();
                    preecheResultado();

                    String labelt = "TENDÊNCIA:";
                    switch (progress) {
                        case 1:
                            labelt = labelt +"(Nunca Ocorreu)";
                            break;
                        case 2:
                            labelt = labelt + "(Ocorre com Pouca Frequência)";
                            break;
                        case 3:
                            labelt = labelt + "(Ocorre com Frequência)";
                            break;
                        case 4:
                            labelt = labelt + "(Ocorre com Muita Frequência)";
                            break;
                        case 5:
                            labelt = labelt + "(Ocorre Sempre)";
                            break;


                    }

                    textTendencia.setText(labelt);


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }


            });





            }

    private void preecheResultado() {
        int resultadoTotal = (seekBarGravidade.getProgress())*(seekBarTendencia.getProgress())*(seekBarUrgencia.getProgress());


        if( resultadoTotal <= 24 ){
            textView4.setText("Muito Baixa");
            textView4.setBackgroundColor(Color.parseColor("#006400"));
        }else if( resultadoTotal>25 && resultadoTotal<=49 ){
            textView4.setText("Baixa");
            textView4.setBackgroundColor(Color.parseColor("#228B22"));
        }else if( resultadoTotal>50 && resultadoTotal<=74 ){
            textView4.setText("Média");
            textView4.setBackgroundColor(Color.parseColor("#FFFF00"));
        }else if ( resultadoTotal>75 && resultadoTotal<=99 ){
            textView4.setText("Alta");
            textView4.setBackgroundColor(Color.parseColor("#FF8C00"));
        }else{
            textView4.setText("Extrema");
            textView4.setBackgroundColor(Color.parseColor("#FF0000"));
        }
    }

    //metodo salvas problema botao

    public void salvarProblema(View view){

        if(validarCamposProblema()){


            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            String valor = textView4.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.ACAEfluente);
            movimentacao.setData(data);

            

            movimentacao.salvar(data);


        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.ACAVapores);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.ACAMetais);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.ETEprodutosQuimicos);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.ETEUsoDeAgua);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.GERDocumeto);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.GERGases);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.GERUsodeAgua);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.LAVAUsoDeAgua);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        } else if (validarCamposProblema()){
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            movimentacao.setTipoProblemaEnum(TipoProblemaEnum.LAVEfluente);
            movimentacao.setData(data);



            movimentacao.salvar(data);

        }

        this.finish();
    }

//    public TipoProblemaEnum getTipoProblema() {
//        return TipoProblemaEnum(nome);
   // }

    public Boolean validarCamposProblema() {
        String textoData = campoData.getText().toString();
        String textNome = nome.getText().toString();
        String textoPrioridade = textView4.getText().toString();


        return true;
    }

    public void recuperarProblemaTotal(){
        String emailUsuario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64(emailUsuario);
        DatabaseReference usuarioRef = firebaseRef.child("usuarios").child(idUsuario);

        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                Usuario usuario = dataSnapshot.getValue(Usuario.class);
                /*ACAmetaistt = usuario.getTtACAmetais();
                ACAquimicott = usuario.getTtACAquimico();
                ACAefluentett = usuario.getTtACAefluente();
                GERgasestt = usuario.getTtGERgases();
                GERdocumentott = usuario.getTtGERdocumento();
                GERaguatt = usuario.getTtGERagua();
                ETEaguatt = usuario.getTtEETEagua();
                ETEprodutostt = usuario.getTtETEprodutos();
                LAVquimicott = usuario.getTtLAVquimico();
                LAVaguatt = usuario.getTtLAVagua();*/

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

    }

};













