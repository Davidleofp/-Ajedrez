
package Modelo;

import Controlador.Cliente;
import java.io.IOException;


public class Log_Cliente {
    
    private Cliente appCliente;
    
    public Log_Cliente() {
    }

    public Cliente getAppCliente() {
        if(appCliente == null){
            appCliente = new Cliente();
        }
        return appCliente;
    }
    
    
    public void iniciar(){
        
        try {
            getAppCliente().conectar();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
