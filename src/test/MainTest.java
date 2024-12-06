package test;

import dominio.CadastroPessoa;
import dominio.MenuPrincipal;
import dominio.Perguntas;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        init();

    }

    public static void init() {
        MenuPrincipal.lerMenu();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite sua escolha: ");
        int escolha = teclado.nextInt();
        switch (escolha) {
            case 1:
                CadastroPessoa.cadastroInit();
                break;
            case 2:
                MenuPrincipal.listarUsuarios();
                break;
            case 3:
                Perguntas.cadastrarPergunta();
                break;
            case 4:
                System.out.println(Perguntas.excluirPergunta());
                Perguntas.formatarIndex();
                break;
            case 5:
                MenuPrincipal.buscarUsuario();
                break;
            default:
                System.out.println("Opção inválida");
        }

    }

}
