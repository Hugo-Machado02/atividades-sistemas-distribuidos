import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(8928)){
            System.out.println("Servidor UDP Startado!");
            System.out.println("aguardando dados...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(pacoteRecebido);

                System.out.println("Recebido: " + new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}