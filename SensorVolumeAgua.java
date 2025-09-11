import java.io.*;
import java.net.*;
import java.util.Random;

public class SensorVolumeAgua {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();){
            InetAddress enderecoServer = InetAddress.getByName("localhost");

            while (true) {
                String dados = sensor();
                byte[] buffer = dados.getBytes();

                DatagramPacket pacoteEnviado = new DatagramPacket(
                    buffer, buffer.length, enderecoServer, 8928
                );

                socket.send(pacoteEnviado);
                System.out.println("Dados enviados ao Servidor ==> " + dados);
                
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException  e) {
                    System.out.println("A thread foi interrompida.");
                    Thread.currentThread().interrupt();
                }
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static String sensor(){
        Random random = new Random();
        // Define os limites
        int minValor = 50;
        int maxValor = 80;
        
        // Gera o número aleatório
        int numRandomico = random.nextInt(maxValor - minValor + 1) + minValor;

        return "Sensor de Volume da Agua: " + numRandomico + "L";
    }
}
