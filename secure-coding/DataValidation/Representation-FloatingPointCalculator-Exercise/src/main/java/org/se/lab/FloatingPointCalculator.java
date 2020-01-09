package org.se.lab;

public class FloatingPointCalculator
{

    public double add100Times(String eurAsString)
    {
        double eur = Double.parseDouble(eurAsString);
        double sum = 0.0;
        for(int i = 0; i< 100; i++)
        {
            sum += eur;
        }
        return sum;
    }
}
