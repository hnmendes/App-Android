package com.example.rique.projetofinal2;

/**
 * Created by Rique on 25/06/2017.
 */
public class Contato {

  public String getNome() {
    return Nome;
  }

  public void setNome(String nome) {
    Nome = nome;
  }

  private String Nome;

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  private String CPF;

  public String getIdade() {
    return Idade;
  }

  public void setIdade(String idade) {
    Idade = idade;
  }

  private String Idade;

  public String getTelefone() {
    return Telefone;
  }

  public void setTelefone(String telefone) {
    Telefone = telefone;
  }

  private String Telefone;

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  private String Email;

  Contato(String Nome, String CPF, String Idade, String Telefone, String Email){

    this.Nome = Nome;
    this.CPF = CPF;
    this.Idade = Idade;
    this.Telefone = Telefone;
    this.Email = Email;




  }





}


