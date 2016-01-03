package org.tensin.sonos.model.musicService;

import org.simpleframework.xml.Element;

public class Presentation {
    @Element(name = "Strings", required = false)
    private Strings strings;

    @Element(name = "PresentationMap", required = false)
    private PresentationMap presentationMap;

    public String toString() {
        return strings + ":" + presentationMap;

    }

}
