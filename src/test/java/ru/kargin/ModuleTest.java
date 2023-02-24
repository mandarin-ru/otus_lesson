package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;

public class ModuleTest {

    @Test
    public void test1()  throws ArithmeticException{
        //Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
        Module obj = new Module(1,0,1);
        double compare = 0;
        assertArrayEquals(new double[]{0,0}, obj.solve(), compare);
    }

    @Test
    public void test2()  throws ArithmeticException{
        //Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
        Module obj = new Module(1,0,-1);
        double compare = 0;
        assertArrayEquals(new double[]{1,-1}, obj.solve(), compare);
    }

    @Test
    public void test3()  throws ArithmeticException{
        //Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
        Module obj = new Module(1,2,1);
        double compare = 0;
        assertArrayEquals(new double[]{-1,-1}, obj.solve(), compare);
    }

    @Test (expected = ArithmeticException.class)
    public void testException() throws ArithmeticException{
        //Написать тест, который проверяет, что коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение.
        Module obj = new Module(0,2,1);
        obj.solve();
    }

    @Test
    public void test3_2()  throws ArithmeticException{
        //Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
        Module obj = new Module(1,2.000001,1);
        double compare = 0;
        assertArrayEquals(new double[]{-1,-1}, obj.solve(), compare);
    }

    @Test (expected = NullPointerException.class)
    public void test4()  throws NullPointerException{
        Module obj = new Module(Double.NaN, Double.NaN, Double.NaN);
        obj.solve();
    }

    @Test (expected = NullPointerException.class)
    public void test4_2()  throws NullPointerException{
        Module obj = new Module(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        obj.solve();
    }
}