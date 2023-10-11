
package Controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    
    private Socket miServidor;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    

    public Cliente(){
        Thread hilo = new Thread(){
            @Override
            public void run() {
                try {
                    conectar();
                } catch (IOException ex) {
                       System.out.println(ex.getMessage());
                }
            }
            
        };
        hilo.start();
    }
    
    public void conectar() throws IOException {
        
        String ruta = "localhost"; // "127.0.0.1"
        int puerto = 5000;
        
        
        // Paso 1: Establecer conexion
        miServidor = new Socket(ruta, puerto);
        
        // Paso 2: Capturar flujos
        datosEntrada = new DataInputStream(miServidor.getInputStream());
        datosSalida = new DataOutputStream(miServidor.getOutputStream());
        
        datosSalida.writeChars("zorraaaaaaa");
        
        while(true){
            // Paso 3: Envio/Recepcion de datos (Se respeta la implementación del protocolo)
            String s;
            while((s = datosEntrada.readLine()) != null){
                System.out.println(s);
            }
            
            datosSalida.write("Hola mundo!".getBytes());
        
            
            
        // Paso 4: Cerrar todo, cuando todo se termine
            datosEntrada.close();
            datosSalida.close();
            miServidor.close();
        }
        
        
    }
}
