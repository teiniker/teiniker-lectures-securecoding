package org.se.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

/*
 * Also in Java there are methods which communicate error conditions via 
 * return values.
 * We have to check these return values to make sure that the following 
 * methods van work without problems...
 */

public class FileTest
{
    @Test
    public void testFileMkDir()
    {
        File f = new File("/etc/hack");
        
        // Returns: 
        //  true if and only if the directory was created
        //  false otherwise
        boolean isCreated = f.mkdir();        
        Assert.assertFalse(isCreated);
    }

    
    
    @Test
    public void testFileDelete()
    {
        File f = new File("unknown.xml");
        
        // Returns:
        //  true if and only if the file or directory is successfully deleted
        // false otherwise
        boolean isDeleted = f.delete();
        Assert.assertFalse(isDeleted);
    }
    
    @Test(expected = NoSuchFileException.class)
    public void testFilesDelete() throws IOException
    {
        // There is another method that can be used to remove files.
        // This method throws an "NoSuchFileException".
        Files.delete(Paths.get("unknown.xml"));        
    }
}
