package org.se.lab;

import java.io.File;

public class Security
{

    public void readFile()
    {
        File data = new File("C:\\data\\data.xml");
        
        if(data.exists())
        {
            System.out.println("File exist!");
        }
    }
}
