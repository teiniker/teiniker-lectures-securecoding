package org.se.lab;

import java.util.ArrayList;
import java.util.List;

class NetworkServiceImpl    // package private
    implements NetworkService
{
    private String iface = "0.0.0.0";

    public NetworkServiceImpl(List<String> history)
    {
        this.history = history;
    }

    @Override
    public String getIPAddress(String iface)
    {
        execute("ifconfig " + iface);
        return iface;
    }

    @Override
    public void assignIPAddress(String iface, String ip)
    {
        execute("ifconfig " + iface + " " + ip);
    }


    // Simulate the execution on the command line
    private List<String> history = new ArrayList<>();
    private void execute(String cmd)
    {
        String line = "# " + cmd;
        System.out.println(line);
        history.add(line);
    }

    public List<String> getHistory()
    {
        return history;
    }
}
