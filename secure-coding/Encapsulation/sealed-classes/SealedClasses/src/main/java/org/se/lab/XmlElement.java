package org.se.lab;

public sealed interface XmlElement permits Dependency
{
    String toXml();
}
