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
	
	private void checkSubtraction(FxRobot robot, String recentResult, String newResult, String num1, String num2) {
		checkResult(robot, recentResult);
		enterNums(robot, num1, num2);
		robot.clickOn("#SubButton");
		checkResult(robot, newResult);
	}
	
	private void checkMultiplication(FxRobot robot, String recentResult, String newResult, String num1, String num2) {
		checkResult(robot, recentResult);
		enterNums(robot, num1, num2);
		robot.clickOn("#MultButton");
		checkResult(robot, newResult);
	}
	private void checkDivision(FxRobot robot, String recentResult, String newResult, String num1, String num2) {
		checkResult(robot, recentResult);
		enterNums(robot, num1, num2);
		robot.clickOn("#DivideButton");
		checkResult(robot, newResult);
	}
	
	@Test
	public void testAddition(FxRobot robot) {
		checkAddition(robot, "0", "15", "10", "5");
		checkAddition(robot, "15", "20", "7", "13");
		checkAddition(robot, "20", "8", "9", "-1");
		checkAddition(robot, "8", "-5", "-5", "0");
		checkAddition(robot, "-5", "2.5", "1.25", "1.25");
	}
	
	@Test
	public void testSubtraction(FxRobot robot) {
		checkSubtraction(robot, "0", "20", "30", "10");
		checkSubtraction(robot, "20", "-8", "5", "13");
		checkSubtraction(robot, "-8", "-3", "1", "4");
		checkSubtraction(robot, "-3", "5", "0", "-5");
		checkSubtraction(robot, "5", "-20", "-17", "3");
		checkSubtraction(robot, "-20", "2.5", "5", "2.5");
		checkSubtraction(robot, "2.5", "0.1", "1.1", "1");
	}
	
	@Test
	public void testMultiplication(FxRobot robot) {
		checkMultiplication(robot, "0", "6", "3", "2");
		checkMultiplication(robot, "6", "20", "4", "5");
		checkMultiplication(robot, "20", "-8", "8", "-1");
		checkMultiplication(robot, "-8", "-10", "-2", "5");
		checkMultiplication(robot, "-10", "2", "0.25", "8");
		checkMultiplication(robot, "2", "0.75", "6", "0.125");
	}
	
	@Test
	public void testDivision(FxRobot robot) {
		checkDivision(robot, "0", "4", "16", "4");
		checkDivision(robot, "4", "0.5", "3", "6");
		checkDivision(robot, "0.5", "-10", "100", "-10");
		checkDivision(robot, "-10", "-0.25", "-2", "8");
		checkDivision(robot, "-0.25", "3", "0.75", "0.25");
		checkDivision(robot, "3", "0.625", "0.5", "0.8");
	}
	
	@Test
	public void testMultiple(FxRobot robot) {
		checkSubtraction(robot, "0", "8", "11", "3");
	}
	
}