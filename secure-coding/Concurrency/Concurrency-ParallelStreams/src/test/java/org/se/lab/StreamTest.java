package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest
{
    private List<String> list;

    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
    }


    @Test
    public void testForEach()
    {
        list.stream().forEach((s) -> System.out.println(s));
    }


    @Test
    public void testCount()
    {
        long count = list.stream().count();

        Assert.assertEquals(9, count);
    }


    @Test
    public void testSorted()
    {
        List<String> l = list.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals("[acht, drei, eins, fünf, neun, sechs, sieben, vier, zwei]", l.toString());
    }


    @Test
    public void testMap()
    {
        List<String> l = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());

        Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", l.toString());
    }


    @Test
    public void testLimit()
    {
        List<String> l = list.stream().limit(4).collect(Collectors.toList());

        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }


    @Test
    public void testFilter()
    {
        long count = list.stream().filter((s) -> s.length() > 4).count();

        Assert.assertEquals(2, count);
    }
}
