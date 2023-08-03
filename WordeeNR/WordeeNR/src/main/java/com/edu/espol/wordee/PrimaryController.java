package com.edu.espol.wordee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
/**
 *
 * @author gladys
 */

public class PrimaryController implements Initializable {

    private int intento;
    private String fraseAdvinar;
    @FXML
    private VBox panelFrases;
    private ArrayList<HBox> boxs=new ArrayList<HBox>();
    private int intentos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearTextFields();
        WordeePOO w = new WordeePOO("frases.txt");
        fraseAdvinar= w.seleccionarFrase();
        System.out.println(fraseAdvinar);
        
       

    }
    //crea un hbox con 5 cajas de texto y lo agrega al panelFrases
    private void crearTextFields() {
        HBox box = new HBox();
        for (int i=0; i<5; i++){
            TextField text = new TextField();
            box.getChildren().add(text);
            
           
        }
        panelFrases.getChildren().add(box);
        boxs.add(box);
    }
    
    //Método asociado al botón Verificar
    @FXML
    private void verificar() throws IOException {
        
        HBox box = boxs.get(boxs.size()-1);
        String[] textoPartido = fraseAdvinar.split(" ");
        String textoCompleto ="";
        int index=0;
        for (Node text: box.getChildren()){
            TextField texto = (TextField) text;
            String textoDentro = texto.getText();
            if (textoCompleto.equals("")){
                textoCompleto += textoDentro;
            }
            else{
                textoCompleto += " "+textoDentro;
            }
            if (textoDentro.equalsIgnoreCase(textoPartido[index])){
                texto.setStyle("-fx-control-inner-background: yellow;");
            }
            else{
                texto.setStyle("-fx-control-inner-background: red;");
            }
            index++;
        }
        if (!textoCompleto.equalsIgnoreCase(fraseAdvinar)){
            if (intentos <5){crearTextFields();}
            
        }
        intentos++;
        
       
        
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
