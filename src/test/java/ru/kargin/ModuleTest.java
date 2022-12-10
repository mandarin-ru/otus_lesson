package ru.kargin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleTest {

    @Test
    public void main() {
    }

    @Test
    public void intFoo() {
        Module a = new Module();
        assertEquals(3,a.intFoo());
    }
}