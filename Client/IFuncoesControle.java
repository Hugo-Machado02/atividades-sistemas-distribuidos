import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFuncoesControle extends Remote{
    void btnPower() throws RemoteException;
    void btnAumentaVolume() throws RemoteException;
    void btnDiminuiVolume() throws RemoteException;
    void btnAvancaCanal() throws RemoteException;
    void btnVoltaCanal() throws RemoteException;
}