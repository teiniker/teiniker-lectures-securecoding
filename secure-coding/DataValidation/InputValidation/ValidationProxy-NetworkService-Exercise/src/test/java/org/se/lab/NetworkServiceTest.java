package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NetworkServiceTest
{
    private NetworkkService service;
    private List<String> history;
    @Before
    public void setup()
    {
        history = new ArrayList<String>();
        service = NetworkkService.newInstance(history);
    }

    @Test
    public void testNetworkService()
    {
        service.assignIPAddress("eth0", "127.0.0.7");
        service.getIPAddress("eth0");

        String expected = "[" +
                "# ifconfig eth0 127.0.0.7, " +
                "# ifconfig eth0" +
                "]";
        Assert.assertEquals(expected,  history.toString());
    }

    public void testActivateInterface_ValidInterfaces()
    {
        service.getIPAddress("eth0");
        service.getIPAddress("eth1");
        service.getIPAddress("eth2");
        service.getIPAddress("eth3");
        service.getIPAddress("eth4");
        service.getIPAddress("eth5");
        service.getIPAddress("eth6");
        service.getIPAddress("eth7");
        service.getIPAddress("eth8");

        service.getIPAddress("lo");

        service.getIPAddress("wlan0");
        service.getIPAddress("wlan1");
        service.getIPAddress("wlan2");
        service.getIPAddress("wlan3");
        service.getIPAddress("wlan4");
        service.getIPAddress("wlan5");
        service.getIPAddress("wlan6");
        service.getIPAddress("wlan7");
        service.getIPAddress("wlan8");
        service.getIPAddress("wlan9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIPAddress_NullInterface()
    {
        service.getIPAddress(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIPAddress_EmptyInterface()
    {
        service.getIPAddress("  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIPAddress_UnknownInterface()
    {
        service.getIPAddress("ethx");
    }


    @Test
    public void testValidIpAddresses()
    {
        service.assignIPAddress("eth0", "0.0.0.0");
        service.assignIPAddress("eth0", "255.255.255.255");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_Null()
    {
        service.assignIPAddress("eth0",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_Empty()
    {
        service.assignIPAddress("eth0","  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidSeparator()
    {
        service.assignIPAddress("eth0","172:217:21:7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidFirstByte_TooBig()
    {
        service.assignIPAddress("eth0","256.217.21.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidSecondtByte_TooBig()
    {
        service.assignIPAddress("eth0","127.256.21.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidThirdByte_TooBig()
    {
        service.assignIPAddress("eth0","127.217.256.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidFourthByte_TooBig()
    {
        service.assignIPAddress("eth0","127.217.21.256");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidFirstByte_WrongChar()
    {
        service.assignIPAddress("eth0","x.217.21.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidSecondByte_WrongChar()
    {
        service.assignIPAddress("eth0","127.x.21.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidThirdByte_WrongChar()
    {
        service.assignIPAddress("eth0","127.217.x.7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIpAddress_InvalidFourthByte_WrongChar()
    {
        service.assignIPAddress("eth0","127.217.21.x");
    }

}
