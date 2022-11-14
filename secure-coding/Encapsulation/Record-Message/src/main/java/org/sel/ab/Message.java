package org.sel.ab;

import java.util.ArrayList;
import java.util.List;

public record Message(long id, List<String> data)
{
    // Custom Constructor
    public Message(long id, List<String> data)
    {
        if(id < 0)
            throw new IllegalArgumentException();
        if(data == null)
            throw new IllegalArgumentException();

        this.id = id;

        // create a deep copy of the data list
        this.data = new ArrayList<>(data);
    }

    // Custom getter
    public List<String> data()
    {
        // create a deep copy of the data list
        return new ArrayList<>(data);
    }
}
