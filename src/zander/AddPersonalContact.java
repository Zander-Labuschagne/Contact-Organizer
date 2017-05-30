package zander;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;
import javafx.stage.Modality;
import java.util.Optional;
import javafx.scene.control.TextField;
import javafx.scene.Node;

/**
 * Class used to control and handle GUI events while adding a personal contact
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 */

public class AddPersonalContact implements Initializable
{
    private Stage currentStage;
    @FXML TextField txtName;
    @FXML TextField txtDayNo;
    @FXML TextField txtHomeNo;
    @FXML TextField txtEMail;
    @FXML TextField txtAddress;
    @FXML TextField txtBirthday;


    @FXML
    protected void btnAddPersonalContact_Clicked(ActionEvent event)
    {
        try
        {
            Organizer.contactList.add(new PersonalContact(txtName.getText(), txtDayNo.getText(), txtHomeNo.getText(), txtBirthday.getText(), txtEMail.getText(), txtAddress.getText()));
            ((Node) (event.getSource())).getScene().getWindow().hide();//Hide This Window
        }
        catch (Exception ex)
        {
            handleException(ex);
        }

    }

    /**
     * method to handle exceptions
     * @param ex Exception thrown to handle
     */
    protected void handleException(Exception ex)
    {
        handleException(ex, "Error");
    }

    /**
     * method to handle exceptions with optional window title
     * @param ex Exception thrown to handle
     * @param title to be displayed in message box
     */
    protected void handleException(Exception ex, String title)
    {
        handleException(ex, title, ex.getMessage());
    }

    /**
     * method to handle exceptions with optional window title and header
     * @param ex Exception thrown to handle
     * @param title to be displayed in message box
     * @param header caption to be displayed in message box
     */
    protected void handleException(Exception ex, String title, String header)
    {
        handleException(ex, title, header, ex.toString());
    }

    /**
     * method to handle exceptions with optional window title, header and message text
     * @param ex Exception thrown to handle
     * @param title to be displayed in message box
     * @param header caption to be displayed in message box
     * @param content message for message box to contain
     */
    protected void handleException(Exception ex, String title, String header, String content)
    {
        if(ex != null)
            ex.printStackTrace();
        Alert error = new Alert(Alert.AlertType.ERROR, content);
        error.initModality(Modality.APPLICATION_MODAL);
        error.initOwner(getCurrentStage());
        error.setTitle(title);
        error.setHeaderText(header);
        DialogPane dialogPane = error.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(Organizer.laf).toExternalForm());
        dialogPane.getStyleClass().add("dlgDefault");
        error.showAndWait();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources)
    {

    }

    /**
     *
     * @param stage
     */
    public void initialize(Stage stage)
    {
        this.currentStage = currentStage;
    }

    /**
     *
     * @return
     */
    public Stage getCurrentStage()
    {
        return this.currentStage;
    }
}
