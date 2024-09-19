/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAOs.PersonalDAO;
import java.io.ByteArrayOutputStream;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author SSM01
 */
public class Camara {

    private Webcam webcam;
    private WebcamPanel webcamPanel;
    private BufferedImage imagenCapturada;

    public Camara() {
        webcam = Webcam.getDefault();
    }

    public void initCamara() {
        if (webcam != null && !webcam.isOpen()) {
            webcam.open();
        }
    }

    //metodo para capturar una imagen de la camara
    public void capturarImagen() {

        imagenCapturada = webcam.getImage();
    }

    //metodo para obtener la imagen capturada
    public BufferedImage getImage() {
        return imagenCapturada;
    }

    public WebcamPanel getWebcamPanel() {
        if (webcamPanel == null) {
            try {
                webcamPanel = new WebcamPanel(webcam);
                webcamPanel.setMirrored(false);
            } catch (Exception e) {
                System.err.println("Error inicializando camara: " + e);
            }
        }
        return webcamPanel;
    }

//metodo para enviar la imagen al personal DAO para guardarla    
    public void enviarimagenAPersonalDao(PersonalDAO personalDAO) {
        if (imagenCapturada != null) {
            try {
                byte[] imagenBytes = convertBufferedImageToBytes(imagenCapturada, "png");
                personalDAO.guardarFoto(imagenBytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //metodo para convertir BufferedImage a un arreglo de bytes y guardarle en la base de datos
    public static byte[] convertBufferedImageToBytes(BufferedImage imagen, String formato) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imagen, formato, baos);
        return baos.toByteArray();
    }

    //metodo para convertir byte[] a buffered image
    public BufferedImage convertirBytesABufferedImage(byte[] imageBytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }
}
