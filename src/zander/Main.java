package zander;

/**
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{

    /**
     *
     * @param organizerWindow
     * @throws Exception
     */
    @Override
    public void start(Stage organizerWindow) throws Exception
    {
        organizerWindow.initStyle(StageStyle.DECORATED);
        organizerWindow.setTitle("Organizer");
        FXMLLoader loader;
        //if(System.getProperty("os.name").startsWith("Windows"))
            loader = new FXMLLoader(getClass().getResource("Organizer.fxml"));
        organizerWindow.setResizable(true);
        organizerWindow.setScene(createScene(loader.load()));
        organizerWindow.getScene().getStylesheets().add("Midna.css");
        Organizer organizer = loader.getController();
        organizer.initialize(organizerWindow);
        organizerWindow.show();
    }

    /**
     *
     * @param layout
     * @return
     */
    private Scene createScene(Pane layout)
    {
        return new Scene(layout, Color.TRANSPARENT);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
