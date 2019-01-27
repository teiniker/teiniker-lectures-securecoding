package org.se.lab;

import java.io.File;
import java.util.Random;

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


    public String randomNumbers()
    {
        Random r = new Random();
        return Long.toHexString(r.nextLong());
    }
}
