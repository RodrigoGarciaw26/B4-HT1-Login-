package org.rodrigogarcia.system;

import javafx.application.Application;
import javafx.stage.Stage;
import org.rodrigogarcia.system.utils.SceneManager;
import org.rodrigogarcia.system.utils.ViewFactory;

public class ClasePrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stageRoot) {
        SceneManager.getInstanciaSceneManager().setStagePrincipal(stageRoot);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

}
