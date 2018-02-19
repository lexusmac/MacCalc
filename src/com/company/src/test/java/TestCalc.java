package com.Calc.Test;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.Calc.Main;

public class TestCalc {
    private com.Calc.Main calculator = new Main();
    @DataProvider
    public Object[][] summParamData() {
        return new Object[][]{
                {0, calculator.calc(-2, 2,'+')},
                {500000, calculator.calc(1000000, 2,'/')},
                {6, calculator.calc(2, 3,'*')},
                {0, calculator.calc(0, 0,'-')},
                {-100, calculator.calc(-30, -70,'+')},
                {10000, calculator.calc(3000, 7000,'+')},
        };
    }

    @Test(dataProvider = "summParamData")
    public void p3(int rez, int sumDigit) {
        assertEquals(rez, sumDigit);
        System.out.println("p3(set param): The result is true = " + rez);
    }

     @Test
     public void p2() throws Exception {
         Assert.assertEquals(2, calculator.calc(1,1,'+' ));
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
}
