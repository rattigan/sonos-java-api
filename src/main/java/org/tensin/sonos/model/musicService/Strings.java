package org.tensin.sonos.model.musicService;

import java.net.URL;

import org.simpleframework.xml.Attribute;

public class Strings
{
	@Attribute (name="Version")
	private String version;
	
	@Attribute (name="Uri")
	private URL uri;
	
}
