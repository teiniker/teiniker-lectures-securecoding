package org.se.lab;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NetworkServiceValidator   // package private
    implements NetworkService
{
    private final NetworkService service;

    public NetworkServiceValidator(NetworkService service)
    {
        this.service = service;
    }

    @Override
    public String getIPAddress(String iface)
    {
        // Validation
        if(!isValidInterface(iface))
            throw new IllegalArgumentException("Invalid network interface: " + iface);

        // Delegation
        return service.getIPAddress(iface);
    }

    @Override
    public void assignIPAddress(String iface, String ipAddress)
    {
        // Validation
        if(!isValidInterface(iface))
            throw new IllegalArgumentException("Invalid network interface: " + iface);

        if(!isValidIpAddress(ipAddress))
            throw new IllegalArgumentException("Invalid IP address: " + ipAddress);

        if(!validBytes(ipAddress))
            throw new IllegalArgumentException("Invalid IP address bytes: " + ipAddress);

        // Delegation
        service.assignIPAddress(iface, ipAddress);
    }

    @Override
    public List<String> getHistory()
    {
        return service.getHistory();
    }
                                                                    //"^eth[0-9]|lo|wlan[0-9]$"
    private final static Pattern interfacePattern = Pattern.compile("^(eth[0-9]|lo|wlan[0-9])$");
    private boolean isValidInterface(String iface)
    {
        if(iface == null || iface.isBlank())
            return false;

        String normalizedIface = Normalizer.normalize(iface, Normalizer.Form.NFKC);
        Matcher m = interfacePattern.matcher(normalizedIface);
        return m.matches();
    }

    private final static Pattern addressPattern = Pattern.compile("^([0-9]{1,3}\\.){3}[0-9]{1,3}$");
    private boolean isValidIpAddress(String ipAddress)
    {
        if(ipAddress == null || ipAddress.isBlank())
            return false;

        String normalizedIp = Normalizer.normalize(ipAddress, Normalizer.Form.NFKC);
        Matcher m = addressPattern.matcher(normalizedIp);
        return m.matches();
    }

    private boolean validBytes(String ipAddress)
    {
        String[] tokens = ipAddress.split("[.]");
        if(!isValidByte(Integer.parseInt(tokens[0]))
                || !isValidByte(Integer.parseInt(tokens[1]))
                || !isValidByte(Integer.parseInt(tokens[2]))
                || !isValidByte( Integer.parseInt(tokens[3]))
        )
            return false;
        else
            return true;
    }

    private boolean isValidByte(int b)
    {
        if(b<0 || b>255)
            return false;
        else
            return true;
    }
}
