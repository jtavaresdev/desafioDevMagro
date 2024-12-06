package dominio;

import dominio.exception.*;

import java.io.*;
import java.util.Scanner;

public class CadastroPessoa {
    public static int cadastrados() {
        File file = new File("dados");
        File[] files = file.listFiles();
        return files.length;
    }

    public static void cadastroInit() {
        System.out.println("============================");
        Scanner teclado = new Scanner(System.in);
        File file = new File("perguntas.txt");
        File fileDados = new File("dados");
        Pessoa pessoa = new Pessoa();
        File cadastroTemp = new File(fileDados, "cadastrotemp.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(cadastroTemp);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String texto;
            int count = 1;
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
                String resposta = teclado.nextLine().trim();
                if (count == 1 && resposta.length() < 10) {
                    throw new NameFormatException();
                } else if (count == 2) {
                    if (checagemDeEmail(resposta)){
                        throw new EmailExistException();
                    }
                } else if (count == 2 && !resposta.contains("@")) {
                    throw new EmailFormatException();
                } else if (count == 3 && Integer.parseInt(resposta) < 18) {
                    throw new AgeException();
                } else if (count == 4 && !resposta.contains(",")) {
                    throw new HeightFormatException();
                }
                bw.write(resposta);
                bw.flush();
                bw.newLine();
                if (count == 1) {
                    pessoa.setNome(resposta);
                } else if (count == 2) {
                    pessoa.setEmail(resposta);
                } else if (count == 3) {
                    pessoa.setIdade(Integer.parseInt(resposta));
                } else if (count == 4) {
                    String s = resposta.replaceAll(",", ".");
                    pessoa.setAltura(Double.parseDouble(s));
                }
                count++;
            }
            String nomeArquivo = String.valueOf(cadastrados()) + " - " + pessoa.getNome().toUpperCase().replaceAll(" ", "") + ".TXT";
            File fileName = new File(file, nomeArquivo);
            copiarTemporario(cadastroTemp, nomeArquivo);
            cadastroTemp.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NameFormatException | EmailFormatException | AgeException | HeightFormatException |
                 EmailExistException | Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copiarTemporario(File file, String nomeArquivo) {
        File file1 = new File("dados", nomeArquivo);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(file1);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String texto;
            while ((texto = br.readLine()) != null) {
                bw.write(texto);
                bw.flush();
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checagemDeEmail(String email) throws EmailExistException, Exception {
        File file = new File("dados");
        for (File listFile : file.listFiles()) {
            try (FileReader fr = new FileReader(listFile);
                 BufferedReader br = new BufferedReader(fr)) {
                br.readLine();
                String emailT = br.readLine();
                if (email.equals(emailT)){
                    return true;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;

    }


}
