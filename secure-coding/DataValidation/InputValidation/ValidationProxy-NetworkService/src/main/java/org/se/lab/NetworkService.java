package org.se.lab;

import java.util.List;

public interface NetworkService
{
    // Creation Method
    static NetworkService newInstance(List<String> history)
    {
        return new NetworkServiceValidator(new NetworkServiceImpl(history));
    }

    // Operations
    String getIPAddress(String iface);                  // ifconfig  eth0
    void assignIPAddress(String iface, String ip);      // ifconfig wlan0 69.72.169.1

    // Test Helper
    List<String> getHistory();
}
