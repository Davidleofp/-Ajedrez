
package Modelo;

import Controlador.Servidor;


public class Log_Servidor {
    
    private Log_Servidor appServidor;
    
    public Log_Servidor() {
    }

    public Log_Servidor getAppServidor() {
        if(appServidor == null){
            appServidor = new Log_Servidor();
        }
        return appServidor;
    }
    
    
    public void iniciar(){
        /*getAppServidor().activar(true);
        getAppServidor().escucharClientes();
        getAppServidor().activar(false)  */
    }
}
