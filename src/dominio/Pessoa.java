package dominio;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String email;
    private int idade;
    private double altura;

    public Pessoa(){

    }

    public Pessoa(String nome, String email, int idade, double altura) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.altura = altura;
    }




    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
