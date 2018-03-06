package com.Calc.Test;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.IOException;

import com.Calc.Main;

public class TestCalc {
    private com.Calc.Main calculator = new Main();
    @DataProvider
    public Object[][] summParamData() {
        return new Object[][]{
                {0.0, calculator.calc(-2, 2,'+')},
                {0.75, calculator.calc(3, 4,'/')},
                {0.3333333333333333, calculator.calc(1, 3,'/')},
                {0.001, calculator.calc(0.002, 2,'/')},
                {0.0, calculator.calc(0, 2,'/')},
                {500000.0, calculator.calc(1000000, 2,'/')},
                {10000.0, calculator.calc(3000, 7000,'+')},
                {6.0, calculator.calc(2, 3,'*')},
                {-1.0, calculator.calc(-1, 1,'*')},
                {-2.0, calculator.calc(-1, 2,'*')},
                {4.0, calculator.calc(2, -2,'-')},
                {-4.0, calculator.calc(-2, -2,'+')},
                {0.0, calculator.calc(0, 0,'-')},
        };
    }

    @Test(dataProvider = "summParamData")
    public void p3(double rez, double sumDigit) {
        assertEquals(rez, sumDigit);
        System.out.println("p3(set param): The result is true = " + sumDigit);
    }

    @DataProvider
    public Object[][] NegativeSummParamData() {
        return new Object[][]{
                {0.1, calculator.calc(-2, 2,'+')},
                {0.8, calculator.calc(3, 4,'/')},
                {0.444444, calculator.calc(1, 3,'/')},
                {0.002, calculator.calc(0.002, 2,'/')},
                {1.0, calculator.calc(0, 2,'/')},
                {2000000.0, calculator.calc(1000000, 2,'/')},
                {30000.0, calculator.calc(3000, 7000,'+')},
                {5.0, calculator.calc(2, 3,'*')},
                {1.0, calculator.calc(-1, 1,'*')},
                {2.0, calculator.calc(-1, 2,'*')},
                {-4.0, calculator.calc(2, -2,'-')},
                {4.0, calculator.calc(-2, -2,'+')},
                {1.0, calculator.calc(0, 0,'-')},
        };
    }

    @Test(dataProvider = "NegativeSummParamData")
    public void p4(double rez, double sumDigit) {
        assertNotEquals(rez, sumDigit);
        System.out.println("p4(set param): The result " + sumDigit + " is Negative, not equals to = " + rez);
    }

     @Test
     public void p2() throws Exception {
         Assert.assertEquals(2.0, calculator.calc(1,1,'+' ));
         System.out.println("p2: The result is true");
     }

     @Test(description  = "Тест просто печатает <b>p1()</b>")
     public void p1() {
         System.out.println("p1()");
         assertEquals(5, 5);
     }
     @Test(enabled=false)
     public void neverUsed() {
        System.out.println("Данный метод не будет выполнен");
     }
//     @Test(expectedExceptions = ArithmeticException.class)
//     public void divisionWithException() {
//         Assert.assertNotEquals("Infinity", calculator.calc(2,0,'/'));
//     }
//     @Test(expectedExceptions = { IOException.class, NullPointerException.class })
//     public void divisionWithException2(){
//         calculator.calc(2,0,'/');
//     }
//     @Test(expectedExceptions = ArithmeticException.class)
//     public void divisionWithException() {
//         calculator.calc(2,0,'/');
//     }
     @Test(expectedExceptions = IllegalArgumentException.class)
     public void divisionWithException() {
         System.out.println("p5 : Cannot divide by 0!");
         calculator.calc(2,0,'/');
         //System.out.println("p5 : Cannot divide by 0!");
     }
}
