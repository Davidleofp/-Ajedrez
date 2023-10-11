
package Controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    
    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    private int puerto;
    private String salida = "";
    
    
    private boolean activado;

    public Servidor() {
        activado = false;
        puerto = 5000;
        
        activar(true);
        Thread hilo = new Thread(){
            @Override
            public void run() {
                try {
                    escucharClientes();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
        };
        hilo.start();
    }        

    public void activar(boolean b) {
        activado = b;
    }

    public void escucharClientes() throws IOException {
        
        byte mensaje[] = new byte[100];
        
        if(activado){
            
            // Establecer puerto por donde se va a escuchar
            servidor = new ServerSocket(puerto);
            System.out.println("Esperando conexiones...");
            cliente = servidor.accept();  // Bloqueante
            // Esperar conexion
            System.out.println("Se ha conectado " + cliente.getInetAddress().getHostAddress());
            
            while(true){
                
                // Alguien se conecto, y está en la variable(objeto) cliente
                //capturar flujos
                datosEntrada = new DataInputStream(cliente.getInputStream());
                System.out.println("pruebaaaaaaa");
                datosSalida = new DataOutputStream(cliente.getOutputStream());
            
            
                // Envio/Recepcion datos
                datosEntrada.read(mensaje);
                
                //agregar logica de recibimiento de datos

                System.out.println("Recibo: " + new String(mensaje));            

                //cerrar todo
                datosEntrada.close();
                datosSalida.close();
                cliente.close();
            }
            
        }
        
        
    }
    
}
