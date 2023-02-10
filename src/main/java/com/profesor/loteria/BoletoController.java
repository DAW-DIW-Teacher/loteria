package com.profesor.loteria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoletoController implements Initializable {
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    private ArrayList<TextField> numeroONCE;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numeroONCE = new ArrayList<TextField>();
        numeroONCE.add(field5);
        numeroONCE.add(field4);
        numeroONCE.add(field3);
        numeroONCE.add(field2);
        numeroONCE.add(field1);
    }
    public void setNumero(String text) {

        StringBuilder sb = new StringBuilder(text);
        while (sb.length() <5) {
            sb.insert(0,'0');
        }
        for (int i = 0; i <sb.length();i++) {
            TextField temp = numeroONCE.get(i);
            temp.setText(sb.substring(i, i + 1));
        }
    }
    public void handlerCerrarVentana(ActionEvent actionEvent) {
        ((Stage)(((Node)(actionEvent.getSource())).getScene().getWindow())).close();
    }
}
