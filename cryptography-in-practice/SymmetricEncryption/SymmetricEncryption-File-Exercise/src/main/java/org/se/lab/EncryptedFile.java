package org.se.lab;

import java.io.*;

public class EncryptedFile
{
    // TODO: Implement missing operations

    protected void save(String filename, byte[] data)
    {
        try(FileOutputStream fos = new FileOutputStream(new File(filename)))
        {
            fos.write(data);
        }
        catch(IOException e)
        {
            throw new IllegalStateException("Unable to save file: " + filename, e);
        }
    }

    protected byte[] load(String filename)
    {
        try(FileInputStream fis = new FileInputStream(new File(filename)))
        {
            return fis.readAllBytes();
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Unable read file: " + filename,e);
        }
    }
}
