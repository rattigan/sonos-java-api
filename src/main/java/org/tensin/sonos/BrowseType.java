package org.tensin.sonos;



/**
 * Defines the set of Browse Types that sonos supports.
 * 
 * Use with Sonos.browse to get a list of the BrowseType entities the ZonePlayer contains.
 * 
 * (1) id: A: / Attributes
 * (2) id: S: / Music Shares
 * (3) id: Q: / Queues
 * (4) id: SQ: / Saved Queues
 * (5) id: R: / Internet Radio
 * (6) id: EN: / Entire Network
 *
 * @throws org.tensin.sonos.SonosException
 *             the sonos exception
 */

public enum BrowseType
{
	Artist("A:ARTIST"), PlayLists("A:PLAYLIST"), Tracks("A:TRACKS"), MusicShares("S:"), Queues("Q:"), SavedQueues("SQ"), InternetRadio("R:"), EntireNetwork("EN:");
	
	private String typeKey;

	BrowseType(String typeKey)
	{
		this.typeKey = typeKey;
	}

	public String getTypeKey() {
		return typeKey;
	}

}
