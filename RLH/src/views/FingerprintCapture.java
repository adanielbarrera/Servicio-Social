/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;

/**
 *
 * @author juancarloscastillocarrillo
 */
public class FingerprintCapture {
    
    private DPFPCapture capture = DPFPGlobal.getCaptureFactory().createCapture();

    public void init() {
        // Configurar el capturador de huellas
        capture.addDataListener(new DPFPDataAdapter() {
            //@Override
            public void fingerTouched(DPFPSensorEvent event) {
                System.out.println("Se ha tocado el lector de huellas.");
                // Iniciar la captura de la huella
                startCapture();
            }
        });
    }

    public void startCapture() {
        capture.startCapture();
        System.out.println("Lector de huellas listo para capturar.");
    }
    
    public static void main(String[] args) {
        FingerprintCapture fingerprintCapture = new FingerprintCapture();
        fingerprintCapture.init();
        
        

        // Aquí podrías tener tu interfaz de usuario o lógica de aplicación
        // que espera a que el usuario coloque el dedo en el lector.
    }
}
