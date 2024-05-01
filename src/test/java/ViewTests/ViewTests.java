package ViewTests;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CalcModel;
import view.MainController;

@ExtendWith(ApplicationExtension.class)
public class ViewTests
{
	@Start
	private void start(Stage stage)
	
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("../view/main.fxml"));
	    try
		{
			BorderPane view = loader.load();
			MainController cont = new MainController();
			cont.setModel(new CalcModel());
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} 
	    catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void enterNums(FxRobot robot, String num1, String num2) {
		robot.clickOn("#NumberOne").write(num1);
		robot.clickOn("#NumberTwo").write(num2);
	}
	
	@Test
	public void testButton(FxRobot robot) {
		enterNums(robot, "12","3");
	}
	
}
