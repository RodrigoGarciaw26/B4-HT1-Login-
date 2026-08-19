package org.rodrigogarcia.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.rodrigogarcia.system.ClasePrincipal;
import org.rodrigogarcia.system.utils.SceneManager;

public class ViewFactory {

    private final String PATH_VIEWS = "/org/joserosales/system/view/";

    public Scene loadFileFXML(String nameFXML, int width, int height) {
        String pathOfFile = PATH_VIEWS + nameFXML;
        try {
            //FXMLLoader
            FXMLLoader loaderFXML = new FXMLLoader();
            //Leer la URL del archivo
            //Llamar al archivo main
            URL urlFile = ClasePrincipal.class.getResource(pathOfFile);
            loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loaderFXML.setLocation(urlFile);

            return new Scene(loaderFXML.load(), width, height);

        } catch (IOException e) {
            throw new UncheckedIOException(e);

        }
    }

    public void loadScene(String nameFXML) {
        Scene scene = null;
        try {
            switch (nameFXML) {
                case "login" -> {
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setTitle("LOGIN DE USUARIOS");
                    SceneManager.getInstanciaSceneManager().getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("LoginView.fxml", 400, 500);
                }
                default ->
                    scene = loadFileFXML("LoginView.fxml", 400, 500);
            }
            SceneManager.getInstanciaSceneManager().changeScene(scene);

        } catch (NullPointerException objetoNulo) {
            //Alert
            System.out.println("error load scene");
        }

    }

    public void viewLogin() {
        loadScene("login");
    }

}
