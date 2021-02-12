package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	
    @FXML
    private BorderPane mainPanel;
	
	@FXML
    private Label labelNameUser;

    @FXML
    private ImageView userPhoto;

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
	
	public void initializate() {
		
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
	
	public void loadLogin(ActionEvent event) throws IOException{
		
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
	
	public void loadAccountList(ActionEvent event) throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		
		fxmlLoader.setController(this);
		Parent accountList = fxmlLoader.load();
		
		mainPanel.getChildren().clear();
		mainPanel.setCenter(accountList);
		initializateTableView();
	}
	
	public void logInBotton(ActionEvent event) {
		
		boolean verific = false;
		
		for(int i = 0; i<2 && !verific; i++) {
			
		}
		
	}
	
	public void signUpBotton(ActionEvent event) {
		
	}
}
