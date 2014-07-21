**sonos-java** : This fork is a stripped down version focused on providing a simple api to the sonos system.

	Sonos sonos = new Sonos();
	ZonePlayer player = sonos.getPlayer("Living Room");
	sonos.clearQueue(player);
	sonos.enqueue(player, "cifs://foo.bar.flac");
	sonos.play();
	sonos.close();
