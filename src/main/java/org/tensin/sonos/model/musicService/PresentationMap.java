package org.tensin.sonos.model.musicService;


import java.net.URL;

import org.simpleframework.xml.Attribute;

public class PresentationMap
{
	@Attribute(name="Version")
	private String version;
	
	@Attribute(name="Uri")
	private URL uri;
	
	
	public String toString()
	{
		return "Version=" + version + ", Uri" + uri;
	}


	public String getVersion() {
		return version;
	}


	public URL getUri() {
		return uri;
	}
	

}
