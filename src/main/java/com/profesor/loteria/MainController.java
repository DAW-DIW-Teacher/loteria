package com.profesor.loteria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final String FICHERO_SONIDO = "music/wrong.mp3";
    @FXML
    private TextField inputBoleto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputBoleto.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,5}")) {
                inputBoleto.setText(oldValue);
                try {
                    Media sound = new Media(getClass().getResource(FICHERO_SONIDO).toExternalForm());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                } catch (Exception e) {
                    System.out.println("Error al intentar cargar los sonidos de la aplicación.");
                }
            }
        });
    }

    public void handlerGenerarBoleto(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("boletoView.fxml"));
            Parent root = loader.load();

            BoletoController controlador = loader.getController();
            controlador.setNumero(inputBoleto.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            System.out.println("No se ha podido cargar la segunda ventana");
        }
    }
}
