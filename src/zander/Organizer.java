package zander;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.stage.WindowEvent;
import javafx.stage.StageStyle;

/**
 * Class used to control and handle GUI events
 * @author Zander Labuschagne 23585137
 * E-Mail: zander.labuschagne@protonmail.ch
 */
public class Organizer implements Initializable
{
    //Instance Variables
    public static Contact[] contacts;
    public static int contactsCount;
    public static String laf = "Midna.css";
    private Stage currentStage;
    public static final ObservableList<Contact> contactList = FXCollections.observableArrayList();
    //GUI Instance Variables
    @FXML private TableView addressbook;
    private TableColumn tcolName;
    private TableColumn tcolDayNo;
    private TableColumn tcolEMail;
    private TableColumn tcolAddress;
    private TableColumn tcolFax;
    private TableColumn tcolCompany;
    private TableColumn tcolPosition;
    private TableColumn tcolBirtday;
    private TableColumn tcolHomeNo;

    /**
     * Default Constructor
     */
    public Organizer()
    {
        this.contacts = new Contact[50];
        this.contactsCount = 0;
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
        this.currentStage = stage;
        getCurrentStage().setOnCloseRequest(confirmCloseEventHandler);//Set default close event

        addressbook.setEditable(false);
        tcolName = new TableColumn("Contact Name");
        tcolName.setMinWidth(150);
        tcolName.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
        tcolAddress = new TableColumn("Physical Address");
        tcolAddress.setMinWidth(200);
        tcolAddress.setCellValueFactory(new PropertyValueFactory<Contact, String>("address"));
        tcolBirtday = new TableColumn("Birthday");
        tcolBirtday.setMinWidth(50);
        tcolBirtday.setCellValueFactory(new PropertyValueFactory<PersonalContact, String>("birthday"));
        tcolCompany = new TableColumn("Company");
        tcolCompany.setMinWidth(150);
        tcolCompany.setCellValueFactory(new PropertyValueFactory<BusinessContact, String>("company"));
        tcolDayNo = new TableColumn("Contact Number");
        tcolDayNo.setMinWidth(100);
        tcolDayNo.setCellValueFactory(new PropertyValueFactory<Contact, String>("dayNo"));
        tcolEMail = new TableColumn("E-Mail Address");
        tcolEMail.setMinWidth(250);
        tcolEMail.setCellValueFactory(new PropertyValueFactory<Contact, String>("eMail"));
        tcolFax = new TableColumn("Fax Number");
        tcolFax.setMinWidth(100);
        tcolFax.setCellValueFactory(new PropertyValueFactory<BusinessContact, String>("faxNo"));
        tcolPosition = new TableColumn("Position");
        tcolPosition.setMinWidth(150);
        tcolPosition.setCellValueFactory(new PropertyValueFactory<BusinessContact, String>("position"));
        tcolHomeNo = new TableColumn("Home Number");
        tcolHomeNo.setMinWidth(100);
        tcolHomeNo.setCellValueFactory(new PropertyValueFactory<PersonalContact, String>("homeNo"));
        addressbook.getColumns().setAll(tcolName, tcolAddress, tcolDayNo, tcolHomeNo, tcolEMail, tcolBirtday, tcolCompany, tcolPosition, tcolFax);
        addressbook.setItems(contactList);
    }

    /**
     *
     * @return
     */
    public Stage getCurrentStage()
    {
        return this.currentStage;
    }

    /**
     *
     * @param event
     */
    @FXML
    protected void btnAddContact_Clicked(ActionEvent event)
    {
        try
        {
            ButtonType personal = new ButtonType("Personal Contact", ButtonBar.ButtonData.OTHER);
            ButtonType business = new ButtonType("Business Contact", ButtonBar.ButtonData.OTHER);
            Alert contactPrompt = new Alert(Alert.AlertType.CONFIRMATION, "What type of contact do you want to add?", personal, business, ButtonType.CANCEL);
            contactPrompt.setHeaderText("Contact Type");
            contactPrompt.initModality(Modality.APPLICATION_MODAL);
            contactPrompt.initOwner(getCurrentStage());
            DialogPane dialogPane = contactPrompt.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource(laf).toExternalForm());
            dialogPane.getStyleClass().add("dlgDefault");
            Optional<ButtonType> result = contactPrompt.showAndWait();
            if (result.get() == personal)
            {
                //Add personal contact
                Stage addPersonalContactWindow = new Stage(StageStyle.DECORATED);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPersonalContact.fxml"));
                addPersonalContactWindow.setResizable(false);
                addPersonalContactWindow.setTitle("Add Personal Contact");
                addPersonalContactWindow.setWidth(406);
                addPersonalContactWindow.setHeight(300);
                addPersonalContactWindow.setScene(new javafx.scene.Scene((javafx.scene.layout.Pane) loader.load(), javafx.scene.paint.Color.TRANSPARENT));
                addPersonalContactWindow.getScene().getStylesheets().add(getClass().getResource(laf).toExternalForm());
                AddPersonalContact addPersonalContact = loader.<AddPersonalContact>getController();
                addPersonalContact.initialize(getCurrentStage());
                addPersonalContactWindow.showAndWait();
            }
            else if (result.get() == business)
            {
                //Add business contact
                Stage addBusinessContactWindow = new Stage(StageStyle.DECORATED);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBusinessContact.fxml"));
                addBusinessContactWindow.setResizable(false);
                addBusinessContactWindow.setTitle("Add Business Contact");
                addBusinessContactWindow.setWidth(406);
                addBusinessContactWindow.setHeight(320);
                addBusinessContactWindow.setScene(new javafx.scene.Scene((javafx.scene.layout.Pane) loader.load(), javafx.scene.paint.Color.TRANSPARENT));
                addBusinessContactWindow.getScene().getStylesheets().add(getClass().getResource(laf).toExternalForm());
                AddBusinessContact addBusinessContact = loader.<AddBusinessContact>getController();
                addBusinessContact.initialize(getCurrentStage());
                addBusinessContactWindow.showAndWait();
            }
            else
                contactPrompt.close();

        }
        catch(IOException ex)
        {
            handleException(ex);
        }
        catch (Exception ex)
        {
            handleException(ex);
        }
    }

    /**
     * Event handler method for File -> Preferences...
     * @param event
     */
    @FXML protected void mnuFile_Preferences_Clicked(ActionEvent event)
    {
        try
        {
            Stage preferencesWindow = new Stage(StageStyle.DECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Preferences.fxml"));
            preferencesWindow.setResizable(false);
            preferencesWindow.setTitle("Contacts Organizer Preferences");
            preferencesWindow.setScene(new javafx.scene.Scene((javafx.scene.layout.Pane) loader.load(), javafx.scene.paint.Color.TRANSPARENT));
            preferencesWindow.getScene().getStylesheets().add(getClass().getResource(laf).toExternalForm());
            Preferences preferences = loader.<Preferences>getController();
            preferences.initialize(getCurrentStage());
            preferencesWindow.showAndWait();

            /*getCurrentStage().close();
            Platform.runLater(() ->
            {
                try
                {
                    new Main().start(new Stage(), laf, getCurrentStage().getX(), getCurrentStage().getY(), getCurrentStage().getWidth(), getCurrentStage().getHeight(), getCurrentStage().isMaximized());
                }
                catch (Exception e)
                {
                    handleException(e);
                }
            });*/
        }
        catch (IOException ex)
        {
            handleException(ex);
        }
        catch (Exception ex)
        {
            handleException(ex);
        }
    }

    /**
     * Event handler method for File -> Exit
     * @param event
     */
    @FXML protected void mnuFile_Exit_Clicked(ActionEvent event)
    {
        Alert closeConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(getCurrentStage());
        DialogPane dialogPane = closeConfirmation.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(laf).toExternalForm());
        dialogPane.getStyleClass().add("dlgDefault");
        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (ButtonType.OK.equals(closeResponse.get()))
            System.exit(0);
    }

    /**
     * Method to prompt before exit
     * Exits application with 0 error code if user prompt is confirmed else application continues
     */
    private EventHandler<WindowEvent> confirmCloseEventHandler = event ->
    {
        Alert closeConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(getCurrentStage());
        DialogPane dialogPane = closeConfirmation.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource(laf).toExternalForm());
        dialogPane.getStyleClass().add("dlgDefault");
        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get()))
            event.consume();
    };

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
}
