import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Televisao extends UnicastRemoteObject implements IFuncoesControle{
    private boolean ligado;
    private int volume;
    private int canal;

    public Televisao() throws RemoteException{
        super();
        this.ligado = false;
        this.volume = 95;
        this.canal = 2;
    }

    public void btnPower() throws RemoteException{
        if(this.ligado){
            this.ligado = false;
            System.out.println("Desligando a TV");
        }else{
            this.ligado = true;
            System.out.println("Ligando a TV");
        }
    }
    
    public void btnAumentaVolume() throws RemoteException{
        if(this.ligado){
            if(this.volume < 100){
                this.volume++;
            }
            System.out.println("Volume: " +  + this.volume);
        }
        else{
            System.out.println("A TV está desligada");
        }
    }

    public void btnDiminuiVolume() throws RemoteException{
        if(this.ligado){
            if(this.volume > 0){
                this.volume--;
            }
            System.out.println("Volume: " + this.volume);
        }
        else{
            System.out.println("A TV está desligada");
        }
        
    }

    public void btnAvancaCanal() throws RemoteException{
        

        if(this.ligado){
            if(this.canal < 20){
                this.canal++;
            }else{
                this.canal = 1;
            }
            System.out.println("Canal: " + this.canal);
        }
        else{
            System.out.println("A TV está desligada");
        }
    }


    public void btnVoltaCanal() throws RemoteException{
        
        if(this.ligado){
            if(this.canal > 1){
                this.canal--;
            }else{
                this.canal = 20;
            }
            System.out.println("Canal: " + this.canal);
        }
        else{
            System.out.println("A TV está desligada");
        }
    }

    public static void main(String[] args) {
        try {
            try {
                LocateRegistry.createRegistry(3019);
                System.out.println("RMI Registry sendo executado na porta 3019!");
            } catch (Exception e) {
                System.err.println("O RMI Registy já está sendo executado");
                e.printStackTrace();
            }

            Televisao tvObj = new Televisao();
            Registry registry = LocateRegistry.getRegistry(3019);
            registry.rebind("TelevisaoObj", tvObj);

            System.out.println("TV Pronta para ser controlada via RMI");
        } catch (Exception e) {
            System.err.println("Erro ao executar o sistema da televisao: " + e);
            e.printStackTrace();
        }
    }
}
