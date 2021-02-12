package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	
    @FXML
    private BorderPane mainPanel;
    
    @FXML
    private TextField txtUserSing;

    @FXML
    private TextField txtPasswordSing;
	
	@FXML
    private Label labelNameUser;

    @FXML
    private ImageView userPhoto;
    
    @FXML
    private RadioButton genderMale;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton genderFemale;

    @FXML
    private RadioButton genderOther;

    @FXML
    private CheckBox careerSofware;

    @FXML
    private CheckBox careerTelematic;

    @FXML
    private CheckBox careerIndustrial;

    @FXML
    private DatePicker txtBirthDay;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhoto;

    @FXML
    private ComboBox<?> txtFavoriteBrowser;

    @FXML
    private TableView<UserAccount> tableViewUserAccount;

    @FXML
    private TableColumn<UserAccount, String> tableViewUsername;

    @FXML
    private TableColumn<UserAccount, String> tableViewGender;

    @FXML
    private TableColumn<UserAccount, ArrayList<String>> tableViewCareer;

    @FXML
    private TableColumn<UserAccount, String> tableViewBirthday;

    @FXML
    private TableColumn<UserAccount, String> tableViewBrowser;

    @FXML
    void logOut(ActionEvent event) {

    }
	
	Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	private void initializateTableView() {
		
		ObservableList<UserAccount> observableList;
		observableList = FXCollections.observableArrayList(classroom.getUsers());
		
		tableViewUserAccount.setItems(observableList);
		tableViewUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("name"));
		tableViewGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		tableViewCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,ArrayList<String>>("career"));
		tableViewBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
		tableViewBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("browser"));
	}
	
	public void loadLogin() throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);
		Parent loginAccount = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setTop(loginAccount);
	}
	
	public void loadRegister(ActionEvent event) throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		
		fxmlLoader.setController(this);
		Parent registerAccount = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setTop(registerAccount);
	}
	
	public void loadAccountList() throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		
		fxmlLoader.setController(this);
		Parent accountList = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setCenter(accountList);
		initializateTableView();
	}
	
	public void logInBotton(ActionEvent event) throws IOException {
		
		boolean verific = false;
		
		if(txtUserSing.getText().equals("") || txtPasswordSing.getText().equals("")) {
				
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Validation Error");
			alert.setHeaderText(null);
			alert.setContentText("All fields must be filled");
			
			alert.showAndWait();
		}
		else if(!txtUserSing.getText().equals("") || !txtPasswordSing.getText().equals("")) {
			
			verific = classroom.searchUser(txtUserSing.getText(), txtPasswordSing.getText());
			
			if(!verific) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Log in incorrect");
				alert.setHeaderText(null);
				alert.setContentText("The username and password given are incorrect");
				
				alert.showAndWait();
			}
			else if(verific) {
				loadAccountList();
			}
		}
	}
	
	public void createAccount(ActionEvent event) {
		
		if(txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPhoto.getText().equals("") || (!genderMale.isSelected() && !genderFemale.isSelected())) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Validation Error");
			alert.setHeaderText(null);
			alert.setContentText("All fields must be filled");
			
			alert.showAndWait();
		}
	}
}
