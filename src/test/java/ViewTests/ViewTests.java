package ViewTests;

import java.io.IOException;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
			MainController cont = loader.getController();
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
	
	private void checkResult(FxRobot robot, String result) {
		Assertions.assertThat(robot.lookup("#ResultsLabel")
				.queryAs(Label.class)).hasText(result);
	}
	
	private void checkAddition(FxRobot robot, String recentResult, String newResult, String num1, String num2) {
		checkResult(robot, recentResult);
		enterNums(robot, num1, num2);
		robot.clickOn("#AddButton");
		checkResult(robot, newResult);
	}
	
	@Test
	public void testAddition(FxRobot robot) {
		checkAddition(robot, "0", "15", "10", "5");
		checkAddition(robot, "15", "20", "7", "13");
		checkAddition(robot, "20", "8", "9", "-1");
		checkAddition(robot, "8", "-5", "0", "-5");
	}
	
}