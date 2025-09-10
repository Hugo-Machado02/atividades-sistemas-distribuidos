import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8928)){
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scan = new Scanner(System.in);
            boolean op = true;
            while (op) {
                System.out.printf("Digite uma Mensagem: ");
                String msgEnvio = scan.nextLine().toLowerCase();

                saida.println(msgEnvio);
                String resposta = entrada.readLine();
                
                System.out.println("-> Resposta: " + resposta);

                if(msgEnvio.equals("sair")){
                    op = false;
                }
            }
                        
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
