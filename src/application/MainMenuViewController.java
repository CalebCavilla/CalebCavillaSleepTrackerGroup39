package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.application.Application;

public class MainMenuViewController extends Main {
	
	Scene mainMenuView;
	
    @FXML
    private Button dashBoardButton;

    @FXML
    private Button diaryButton;

    @FXML
    private Button scheduleButton;

    @FXML
    private Button settingsButton;

    @FXML
    void switchDashboardView(ActionEvent event) {
		Scene dashboardView = new Scene(new Label("Dashboard"));
		applicationStage.setScene(dashboardView);
		applicationStage.setTitle("Dashboard");
		applicationStage.show();
    }

    @FXML
    void switchDiaryView(ActionEvent event) {
    	Scene diaryView = new Scene(new Label("Diary"));
		applicationStage.setScene(diaryView);
		applicationStage.setTitle("Diary");
		applicationStage.show();
    }

    @FXML
    void switchScheduleView(ActionEvent event) {
    	Scene scheduleView = new Scene(new Label("Schedule"));
		applicationStage.setScene(scheduleView);
		applicationStage.setTitle("Schedule");
		applicationStage.show();
    }	

    @FXML
    void switchSettingsView(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox settingsRoot = loader.load(new FileInputStream("src/application/SettingsView.fxml"));
			SettingsController settingsController = (SettingsController) loader.getController();
			settingsController.applicationStage = applicationStage;
			Scene settingsView = new Scene(settingsRoot,250,250);
			settingsController.settingsView = settingsView;
			settingsController.mainMenuView = mainMenuView;
			applicationStage.setScene(settingsView);
			applicationStage.setTitle("Settings");
			applicationStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
