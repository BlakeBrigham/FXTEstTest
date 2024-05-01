package modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.CalcModel;

public class ModelTest {

    private CalcModel calcModel;

    DoubleProperty num1 = new SimpleDoubleProperty(5.0);
    DoubleProperty num2 = new SimpleDoubleProperty(3.0);
    DoubleProperty num3 = new SimpleDoubleProperty(-3.0);
    DoubleProperty num4 = new SimpleDoubleProperty(10.9);
    
    @BeforeEach
    public void setUp() {
        calcModel = new CalcModel();
    }

    @Test
    public void testAddition() {
    	//Test basic
        calcModel.setNum1(num1);
        calcModel.setNum2(num2);
        calcModel.add();
        assertEquals(8.0, calcModel.getResult().doubleValue());
        //Test negative numbers
        calcModel.setNum2(num3);
        calcModel.add();
        assertEquals(2.0, calcModel.getResult().doubleValue());
        //Test Decimals
        calcModel.setNum1(num4);
        calcModel.add();
        assertEquals(7.9, calcModel.getResult().doubleValue());
    }

    @Test
    public void testSubtraction() {
        calcModel.setNum1(num1);
        calcModel.setNum2(num2);
        calcModel.subtract();
        assertEquals(2.0, calcModel.getResult().doubleValue());
        
        //Test negative numbers
        calcModel.setNum2(num3);
        calcModel.subtract();
        assertEquals(8.0, calcModel.getResult().doubleValue());
        //Test Decimals
        calcModel.setNum1(num4);
        calcModel.subtract();
        assertEquals(13.9, calcModel.getResult().doubleValue());
    }

    @Test
    public void testMultiplication() {
        calcModel.setNum1(num1);
        calcModel.setNum2(num2);
        calcModel.multiply();
        assertEquals(15.0, calcModel.getResult().doubleValue());
        
        //Test negative numbers
        calcModel.setNum2(num3);
        calcModel.multiply();
        assertEquals(-15.0, calcModel.getResult().doubleValue());
        //Test Decimals
        calcModel.setNum1(num4);
        calcModel.multiply();
        assertEquals(-32.7, calcModel.getResult().doubleValue());
    }

    @Test
    public void testDivision() {
        calcModel.setNum1(num1);
        calcModel.setNum2(num2);
        calcModel.divide();
        assertEquals(1.6, calcModel.getResult().doubleValue(), 0.01);
        
        //Test negative numbers
        calcModel.setNum2(num3);
        calcModel.divide();
        assertEquals(-1.6, calcModel.getResult().doubleValue(), 0.01);
        //Test Decimals
        calcModel.setNum1(num4);
        calcModel.divide();
        assertEquals(-3.63, calcModel.getResult().doubleValue(), 0.001);
    }
}
