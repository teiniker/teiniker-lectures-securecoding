package org.se.lab;

import java.io.Serializable;

public class Product 
    implements Serializable
{
    private static final long serialVersionUID = -574191274210224033L;

    /*
     * Constructor
     */
    public Product(String name, long quantity)
    {
        setName(name);
        setQuantity(quantity);
    }

    public Product(String name, String quantity)
    {
        this(name, Long.parseLong(quantity));
    }

    /*
     * Property: name
     */
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        if (name == null)
            throw new IllegalArgumentException("Parameter name is null!");

        this.name = name;
    }


    /*
     * Property: quantity
     */
    private long quantity;
    public long getQuantity()
    {
        return quantity;
    }
    public void setQuantity(long quantity)
    {
        if (quantity <= 0)
            throw new IllegalArgumentException("Parameter quantity is invalid!");

        this.quantity = quantity;
    }

    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Product [name=" + name + ", quantity=" + quantity + "]";
    }
}
