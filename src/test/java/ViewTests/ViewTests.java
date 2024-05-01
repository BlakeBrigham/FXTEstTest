package ViewTests;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CalcModel;
import view.MainController;

public class ViewTests
{
	@Start
	private void start(Stage stage)
	
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("main.fxml"));
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
	    MainController cont = loader.getController();
	    CalcModel model =new CalcModel(); 
	    cont.setModel(model);
	}
	
	@Test
	public void testButton(FxRobot robot) {
		robot.clickOn("");
	}
	
}
