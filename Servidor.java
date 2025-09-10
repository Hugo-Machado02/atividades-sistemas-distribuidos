import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try(ServerSocket servidor = new ServerSocket(8928)){
            System.out.println("Servidor Aguardando conexão");
            Socket socket = servidor.accept();
            System.out.println("Cliente Conectado");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            boolean op = true;

            while (op) {
                String mensagem = entrada.readLine();
                if(!mensagem.equals("sair")){
                    System.out.println("-> Mensagem Recebida: " + mensagem);
                    saida.println("Servidor Respondeu: " + mensagem);
                }
                else{
                    System.out.println("-> O Cliente encerrou a conexão");
                    saida.println("Conexão encerrada pelo cliente!");
                    op = false;
                }
            }

            socket.close();

        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }
}