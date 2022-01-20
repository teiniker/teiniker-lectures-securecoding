package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class FloatingPointCalculatorTest
{
    @Test
    public void testAdd100Times()
    {
        FloatingPointCalculator calc = new FloatingPointCalculator();

        double sum = calc.add100Times("0.1");

        double expected = 10.0;
        System.out.printf("%.50f\n",expected);
        System.out.printf("%.50f\n",sum);
        Assert.assertEquals(expected, sum, 1E-20);
    }

    @Test
    public void testAdd100TimesUsingLong()
    {
        FloatingPointCalculator calc = new FloatingPointCalculator();

        double sum = calc.add100Times(10);

        double expected = 10.0;
        System.out.printf("%.50f\n",expected);
        System.out.printf("%.50f\n",sum);
        Assert.assertEquals(expected, sum, 1E-20);
    }
}
