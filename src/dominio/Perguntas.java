package dominio;

import java.io.*;
import java.util.Scanner;

public class Perguntas {
    public static void lerPerguntas() {
        System.out.println("============================");
        File file = new File("perguntas.txt");
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

    public static int contadorPerguntas() {
        File file = new File("perguntas.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            int count = 0;
            String texto;
            while ((texto = br.readLine()) != null) {
                count++;
            }
            return count;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void cadastrarPergunta() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite a nova pergunta: ");
        String perguntaTemp = teclado.nextLine();
        String pergunta = String.valueOf(contadorPerguntas() + 1) + " - " + perguntaTemp;
        File file = new File("perguntas.txt");
        File fileTemp = new File("perguntasTemp.txt");

        try (FileWriter fw = new FileWriter(fileTemp);
             BufferedWriter bw = new BufferedWriter(fw);
             FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String texto;
            while ((texto = br.readLine()) != null) {
                bw.write(texto);
                bw.flush();
                bw.newLine();
            }
            bw.write(pergunta);
            fileTemp.renameTo(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String excluirPergunta() {
        lerPerguntas();
        System.out.println("Digite o número da pergunta");
        Scanner teclado = new Scanner(System.in);
        int indexPergunta = teclado.nextInt();
        if (indexPergunta <= 4) {
            return "Opção inválida";
        }
        int numeroDePerguntas = contadorPerguntas();
        File file = new File("perguntas.txt");
        File fileTemp = new File("perguntasTem.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(fileTemp);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String texto;
            String index = String.valueOf(indexPergunta);
            while ((texto = br.readLine()) != null) {
                if (texto.startsWith(index)) {
                    continue;
                }
                bw.write(texto);
                bw.flush();
                bw.newLine();
            }
            fileTemp.renameTo(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Pergunta excluída com sucesso";
    }

    public static void formatarIndex() {
        File file = new File("perguntas.txt");
        File fileTemp = new File("perguntasTemp.txt");

        int indexPerguntas = 1;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(fileTemp);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String texto;
            while ((texto = br.readLine()) != null) {
                String[] split = texto.split(" ");
                if (!texto.startsWith(String.valueOf(indexPerguntas))) {
                    bw.write(texto.replaceFirst(split[0], String.valueOf(indexPerguntas) ));
                    bw.flush();
                    bw.newLine();
                }else {
                    bw.write(texto);
                    bw.flush();
                    bw.newLine();
                }
                indexPerguntas ++;
            }
            fileTemp.renameTo(file);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
