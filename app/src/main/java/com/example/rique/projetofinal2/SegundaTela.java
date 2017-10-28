package com.example.rique.projetofinal2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Henrique Nunes Mendes
//******************************************************







public class SegundaTela extends AppCompatActivity {


  private DBHelper dh;                                        //BANCO DE DADOS
  EditText etNome, etCpf, etIdade, etTelefone, etEmail;       //VARIÁVEIS EDIT TEXT
  Button btInserir, btListar, btVolt;                         //VARIÁVEIS DE BOTÕES


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_segunda_tela);

    this.dh = new DBHelper(this);
    etNome = (EditText) findViewById(R.id.etNome);
    etCpf = (EditText) findViewById(R.id.etCPF);
    etIdade = (EditText) findViewById(R.id.etIdade);
    etTelefone = (EditText) findViewById(R.id.etTelefone);
    etEmail = (EditText) findViewById(R.id.etEmail);


    btInserir = (Button) findViewById(R.id.bInserir);
    btListar = (Button) findViewById(R.id.bListar);


    btInserir.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (etNome.getText().length() > 0 && etCpf.getText().length() > 0 && etIdade.getText().length() > 0 && etTelefone.getText().length() > 0
          && etEmail.getText().length() > 0) {
          dh.insert(etNome.getText().toString(), etCpf.getText().toString(), etIdade.getText().toString(), etTelefone.getText().toString(), etEmail.getText().toString());
          AlertDialog.Builder adb = new AlertDialog.Builder(SegundaTela.this);
          adb.setTitle("Sucesso!");
          adb.setMessage("Cadastro realizado com sucesso!");
          adb.show();

          etNome.setText("");
          etCpf.setText("");
          etIdade.setText("");
          etTelefone.setText("");
          etEmail.setText("");

        } else {

          AlertDialog.Builder adb = new AlertDialog.Builder(SegundaTela.this);
          adb.setTitle("Erro!");
          adb.setMessage("Todos os campos devem ser preenchidos!");
          adb.show();

          etNome.setText("");
          etCpf.setText("");
          etIdade.setText("");
          etTelefone.setText("");
          etEmail.setText("");

        }

        btListar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            List<Contato> contatos = dh.queryGetAll();

            if (contatos == null) {
              AlertDialog.Builder adb = new AlertDialog.Builder(SegundaTela.this);
              adb.setTitle("Mensagem");
              adb.setMessage("Não tem registros preenchidos!");
              adb.show();

              return;
            }

            for (int i = 0; i < contatos.size(); i++) {
              Contato contato = (Contato) contatos.get(i);
              AlertDialog.Builder adb = new AlertDialog.Builder(SegundaTela.this);
              adb.setTitle("Registro " + i);
              adb.setMessage("Nome: " + contato.getNome() + "\nCpf: " + contato.getCPF() + "\nIdade: " + contato.getIdade() + "\nTelefone: " + contato.getTelefone() + "\nEmail: " + contato.getEmail());
              adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                }
              });

              adb.show();


            }


          }
        });


      }
    });


    btVolt = (Button) findViewById(R.id.bVoltar);
    btVolt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        voltarParaPrimeiraTela();
      }
    });
  }

  void voltarParaPrimeiraTela() {

    Intent intent = new Intent();
    intent.setClass(SegundaTela.this, PrimeiraTela.class);
    startActivity(intent);
    finish();

  }
}
