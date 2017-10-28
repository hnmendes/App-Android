package com.example.rique.projetofinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Henrique Nunes Mendes
//******************************************************




public class PrimeiraTela extends AppCompatActivity {


  Button SegundaTela,btSair;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_primeira_tela);


    SegundaTela = (Button)findViewById(R.id.bSegunda); //QUANDO FOR CLICADO NO BOTÃO DE 'FAZER CADASTRO'
    SegundaTela.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Chamasegundatela();                 //CHAMA A FUNÇÃO DA SEGUNDA TELA
      }
    });

    btSair = (Button)findViewById(R.id.bSair);     //QUANDO FOR CLICADO NO BOTÃO DE 'SAIR'
    btSair.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Finalizar();                          //CHAMA A FUNÇÃO DE SAIR
      }
    });







  }


      void Chamasegundatela(){          //OBJETIVO :FUNÇÃO - IR PARA A SEGUNDA ACTIVITY

        Intent intent = new Intent();
        intent.setClass(PrimeiraTela.this, SegundaTela.class);
        startActivity(intent);
        finish();

  }

    void Finalizar(){                   //OBJETIVO :FUNÇÃO - SAIR DO APLICATIVO
      finish();

    }



}






