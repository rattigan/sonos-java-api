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

import org.apache.commons.logging.LogFactory;
import org.tensin.sonos.model.Entry;

/**
 * The Class EntryHelper.
 *
 * @author David WHEELER
 * @author Serge SIMON
 */
public final class EntryHelper {

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
}
