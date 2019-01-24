package org.se.lab;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class FileEntry implements Serializable
{
    private static final long serialVersionUID = 1L;


    /*
     * Constructor
     */
    public FileEntry(String path, byte[] content)
    {
        setPath(path);
        setContent(content);
    }

    /*
     * Custom serialization
     */
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException
    {
        System.out.println("readObject()");
        in.defaultReadObject();

        FileOutputStream file = new FileOutputStream(getPath());
        file.write(getContent());
        file.close();
    }


    /*
     * Property: content
     */
    private byte[] content;

    public byte[] getContent()
    {
        return content;
    }

    public void setContent(byte[] content)
    {
        if (content == null)
            throw new IllegalArgumentException("Content array is null!");

        this.content = content;
    }

    /*
     * Property: path
     */
    private String path;

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        if (path == null)
            throw new IllegalArgumentException("Path value is null!");

        this.path = path;
    }

    @Override
    public String toString()
    {
        return getPath() + ":" + HexBin.encode(getContent());
    }
}
