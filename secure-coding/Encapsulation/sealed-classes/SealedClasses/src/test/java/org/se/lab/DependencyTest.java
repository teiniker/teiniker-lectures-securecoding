package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class DependencyTest
{
    @Test
    public void testDependency()
    {
        XmlElement dependency = new Dependency("junit", "junit", "4.13.1");

        String expected =   "<dependency>" +
                                "<groupId>junit</groupId>" +
                                "<artifactId>junit</artifactId>" +
                                "<version>4.13.1</version>" +
                            "</dependency>";
        Assert.assertEquals(expected, dependency.toXml());
    }
}
