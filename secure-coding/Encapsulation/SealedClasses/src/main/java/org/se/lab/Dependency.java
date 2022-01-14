package org.se.lab;

public final class Dependency
    implements XmlElement
{
    private final String groupId;
    private final String artifactId;
    private final String version;

    public Dependency(String groupId, String artifactId, String version)
    {
        // TODO: Validate parameters
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    @Override
    public String toXml()
    {
        StringBuilder xml = new StringBuilder();
        xml.append("<dependency>")
                .append("<groupId>").append(groupId).append("</groupId>")
                .append("<artifactId>").append(artifactId).append("</artifactId>")
                .append("<version>").append(version).append("</version>")
                .append("</dependency>");
        return xml.toString();
    }
}
