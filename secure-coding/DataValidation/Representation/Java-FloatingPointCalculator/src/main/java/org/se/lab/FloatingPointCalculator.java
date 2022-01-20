package org.se.lab;

/*
 * Avoid using the primitive floating point types when precise
 * computation is necessary, especially when performing currency
 * calculations.
 *
 * Because these types use a binary mantissa, they cannot precisely
 * represent many finite decimal numbers, such as 1/10, because these
 * numbers have repeating binary representations.
 *
 */

import java.math.BigDecimal;

public class FloatingPointCalculator
{
    public double add100Times(String centsAsString)
    {
        BigDecimal tenCent = new BigDecimal(centsAsString);
        BigDecimal sum = new BigDecimal("0.0");
        for(int i = 0; i< 100; i++)
        {
            sum = sum.add(tenCent);
        }
        return sum.doubleValue();
    }

    public double add100Times(long cents)
    {
        long sum = 0;
        for (int i = 0; i < 100; i++)
        {
            sum += cents;
        }
        return sum/100.0;
    }
}
