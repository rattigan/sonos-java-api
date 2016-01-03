package org.tensin.sonos.model.musicService;


import java.net.URL;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name="Service")
public class MusicService
{
	@Attribute(name = "Id")
	private String serviceId;
	
	@Attribute(name = "Name")
	private String name;
	
	@Attribute(name = "Version")
	private String version;
	
	@Attribute(name = "Uri")
	private URL url;
	
	@Attribute(name = "SecureUri")
	private URL secureUrl;
	
	@Attribute(name = "ContainerType")
	private String containerType;
	
	@Attribute(name = "Capabilities")
	private String capabilities;
	
	@Element (name="Policy",type=Policy.class)
	private Policy policy;
	
	@Element (name = "Presentation")
	private Presentation presentation;
	
	
	public String toString()
	{
		return "Name= " + name + ", Version=" + version + ", URL=" + url;
	}


	public String getServiceId() {
		return serviceId;
	}


	public String getName() {
		return name;
	}


	public String getVersion() {
		return version;
	}


	public URL getUrl() {
		return url;
	}


	public URL getSecureUrl() {
		return secureUrl;
	}


	public String getContainerType() {
		return containerType;
	}


	public String getCapabilities() {
		return capabilities;
	}


	public Policy getPolicy() {
		return policy;
	}


	public Presentation getPresentation() {
		return presentation;
	}

}
