package org.tensin.sonos.model.musicService;



import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * This class simply exists to facilitate parsing of the MusicService xml.
 * @author bsutton
 *
 */

@Root(name="Services")
public class MusicServiceContainer
{
	@Attribute(name="SchemaVersion")
	private String schemaVersion;
	
	@ElementList(name="Service", inline=true, type=MusicService.class)
	private List<MusicService> musicServices;

    public List<MusicService> getMusicServices() {
        return musicServices;
    }
    
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for (MusicService service: musicServices)
    	{
    		sb.append(service);
    		sb.append("\n");
    	}
    	return sb.toString();
    }
    
  }
