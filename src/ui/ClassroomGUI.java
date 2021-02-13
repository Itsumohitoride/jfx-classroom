package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	
    @FXML
    private BorderPane mainPanel;
    
    @FXML
    private TextField txtUserSing;

    @FXML
    private PasswordField txtPasswordSing;
	
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
    private DatePicker birthDay;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhoto;

    @FXML
    private ComboBox<String> favoriteBrowser;

    @FXML
    private TableView<UserAccount> tableViewUserAccount;

    @FXML
    private TableColumn<UserAccount, String> tableViewUsername;

    @FXML
    private TableColumn<UserAccount, String> tableViewGender;

    @FXML
    private TableColumn<UserAccount, String> tableViewCareer;

    @FXML
    private TableColumn<UserAccount, String> tableViewBirthday;

    @FXML
    private TableColumn<UserAccount, String> tableViewBrowser;
	
	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}
	
	private void initializateTableView() {
		
		ObservableList<UserAccount> observableList;
		observableList = FXCollections.observableArrayList(classroom.getUsers());
		
		tableViewUserAccount.setItems(observableList);
		tableViewUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("name"));
		tableViewGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		tableViewCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
		tableViewBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
		tableViewBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("Browser"));
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
		
		favoriteBrowser.setPromptText("Select");
		favoriteBrowser.getItems().addAll("Google","Opera GX","Opera","FireFox");
	}
	
	public void loadAccountList() throws IOException{
		
		String messageName = "";
		String messagePhoto = "";
		
		Image image;;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		
		fxmlLoader.setController(this);
		Parent accountList = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setCenter(accountList);
		initializateTableView();
		
		messageName = classroom.searchName(txtUserSing.getText(),txtPasswordSing.getText());
		messagePhoto = classroom.searchPhoto(txtUserSing.getText(),txtPasswordSing.getText());
		
		image = new Image(messagePhoto);
		
		userPhoto.setImage(image);
		
		labelNameUser.setText(messageName);
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
	
	public String genderUser() {
		
		String message = "";
		
		if(genderMale.isSelected()) {
			message = "Male";
		}
		else if(genderFemale.isSelected()) {
			message = "Female";
		}
		else if(genderOther.isSelected()) {
			message = "Other";
		}
		
		return message;
	}
	
	public String careerUsed() {
		
		String message = "";
		
		if(careerSofware.isSelected()) {
			message += "Sofware Engineering\n";
		}
		if(careerTelematic.isSelected()) {
			message += "Telematic Engineering\n";
		}
		if(careerIndustrial.isSelected()) {
			message += "Industrial Engineering";
		}
		
		return message;
	}
	
	public void createAccount(ActionEvent event) throws IOException {
		
		if(txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPhoto.getText().equals("") || (!genderMale.isSelected() && !genderFemale.isSelected() && !genderOther.isSelected()) || (!careerSofware.isSelected() && !careerTelematic.isSelected() && !careerIndustrial.isSelected()) || birthDay.getValue() == null || favoriteBrowser.getValue() == null) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Validaton Error");
			alert.setHeaderText(null);
			alert.setContentText("You must fill each field in the form");
			
			alert.showAndWait();
		}
		else {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Acciunt Created");
			alert.setHeaderText(null);
			alert.setContentText("The new account has been created");
			
			alert.showAndWait();
			
			String career = careerUsed();
			String gender = genderUser();
			
			File image = new File(txtPhoto.getText());
			String location = image.toURI().toString();
			
			classroom.addUser(txtUsername.getText(), txtPassword.getText(), location, gender, career, birthDay.getValue().toString(), favoriteBrowser.getValue().toString());
			
			loadLogin();
		}
	}
	
	public void browseBotton(ActionEvent event) throws IOException{
		
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.setTitle("View Pictures");
		File file = fileChooser.showOpenDialog(null);
		
		if(file != null) {
			txtPhoto.appendText(file.getAbsolutePath());
		}
	}
}
