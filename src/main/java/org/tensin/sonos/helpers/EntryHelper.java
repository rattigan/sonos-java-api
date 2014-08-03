/*
 * Copyright 2009 David Wheeler
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tensin.sonos.helpers;

import org.tensin.sonos.model.Entry;

import java.text.MessageFormat;

/**
 * The Class EntryHelper.
 *
 * @author David WHEELER
 * @author Serge SIMON
 */
public final class EntryHelper {

    /** The format for a metadata tag: 0: id 1: parent id 2: title 3: upnp:class. */
    private static final MessageFormat METADATA_FORMAT = new MessageFormat("<DIDL-Lite xmlns:dc=\"http://purl.org/dc/elements/1.1/\" "
            + "xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" " + "xmlns:r=\"urn:schemas-rinconnetworks-com:metadata-1-0/\" "
            + "xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\">" + "<item id=\"{0}\" parentID=\"{1}\" restricted=\"true\">" + "<dc:title>{2}</dc:title>"
            + "<upnp:class>{3}</upnp:class>" + "<desc id=\"cdudn\" nameSpace=\"urn:schemas-rinconnetworks-com:metadata-1-0/\">"
            + "RINCON_AssociatedZPUDN</desc>" + "</item></DIDL-Lite>");


    /**
     * Creates an Entry for the given url.
     *
     * @param url
     *            the String representation of the url. format: [[scheme:]//]host[:port]/resource
     * @return An entry that refers to the given url resource
     */
    public static final Entry createEntryForUrl(final String url) {
        String res;
        if (url.startsWith("http:")) {
            // replace protocol part
            res = url.replace("cifs:", "x-rincon-mp3radio:");
        } else if (url.startsWith("cifs:")) {
            res = url.replace("cifs:", "x-file-cifs:");
        } else {
            res = url;
        }
        return new Entry("URL:" + url, url, "URL:", "URL", "", "", "object.item.audioItem.audioBroadcast", res, "");
    }

    public static String compileMetadataString(final Entry entry) {
        // Not too sure what's up with this, but it doesn't seem to like having long upnp class names
        String upnpClass = entry.getUpnpClass();
        if (upnpClass.startsWith("object.container")) {
            upnpClass = "object.container";
        }
        return METADATA_FORMAT.format(new Object[] { entry.getId(), entry.getParentId(), entry.getTitle(), upnpClass });
    }

}
