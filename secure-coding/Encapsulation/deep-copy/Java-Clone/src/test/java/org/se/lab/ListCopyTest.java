package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListCopyTest
{
    @Test
    public void testArrayListCopyConstructor()
    {
        List<User> original = new ArrayList<>();
        original.add(new User(1, "Homer", "Simpson", "homer.simpson@fhj.at"));
        original.add(new User(7, "Bart", "Simpson", "bart.simpson@fhj.at"));

        List<User> copy = new ArrayList<>(original);
        copy.get(0).setId(666);

        // The original list will be modified as well => shallow copy!
        Assert.assertEquals(666, original.get(0).getId());
    }

    @Test
    public void testArrayListClone()
    {
        ArrayList<User> original = new ArrayList<>();
        original.add(new User(1, "Homer", "Simpson", "homer.simpson@fhj.at"));
        original.add(new User(7, "Bart", "Simpson", "bart.simpson@fhj.at"));

        List<User> copy = (List<User>) original.clone();
        copy.get(0).setId(666);

        // The original list will be modified as well => shallow copy!
        Assert.assertEquals(666, original.get(0).getId());
    }

    @Test
    public void testArrayListDeepCopy()
    {
        ArrayList<User> original = new ArrayList<>();
        original.add(new User(1, "Homer", "Simpson", "homer.simpson@fhj.at"));
        original.add(new User(7, "Bart", "Simpson", "bart.simpson@fhj.at"));

        List<User> copy = new ArrayList<>();
        for(User u : original)
        {
            copy.add(u.clone());
        }
        copy.get(0).setId(666);

        // The original list will be modified as well => shallow copy!
        Assert.assertEquals(1, original.get(0).getId());
    }

}
