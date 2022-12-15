package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ModuleTest {

    @Test
    public void test1(){
        //Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
        Module obj = new Module(1,0,1);
        double compare = 0;
        assertArrayEquals(new double[]{0,0}, obj.solve(), compare);
    }

    @Test
    public void test2(){
        //Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
        Module obj = new Module(1,0,-1);
        double compare = 0;
        assertArrayEquals(new double[]{1,-1}, obj.solve(), compare);
    }
}