package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuPrincipal {
    public static void lerMenu() {
        File file = new File("menuprincipal.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String texto;
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarUsuarios() {
        int numCadastros = CadastroPessoa.cadastrados();
        if (numCadastros == 0) {
            System.out.println("Nenhum usuário cadastrado");
        } else {
            File file = new File("dados");
            for (File listFile : file.listFiles()) {
                try (FileReader fr = new FileReader(listFile);
                     BufferedReader reader = new BufferedReader(fr)) {
                    System.out.println(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void buscarUsuario() {
        File file = new File("dados");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = teclado.nextLine().toUpperCase();
        Pattern pattern = Pattern.compile(nomeUsuario);
        int count = 0;

        for (File fileArquivos : Objects.requireNonNull(file.listFiles())) {

            try (FileReader fr = new FileReader(fileArquivos);
                 BufferedReader br = new BufferedReader(fr)) {
                String texto = br.readLine();
                if (texto != null) {
                    Matcher matcher = pattern.matcher(texto.toUpperCase());
                    while (matcher.find()) {
                        count++;
                        System.out.println(texto);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (count == 0) {
            System.out.println("Nenhum usuário encontrado");
        }

    }

}
