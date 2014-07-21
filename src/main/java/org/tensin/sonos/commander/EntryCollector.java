package org.tensin.sonos.commander;

import com.google.common.collect.Lists;
import org.tensin.sonos.control.BrowseHandle;
import org.tensin.sonos.control.EntryCallback;
import org.tensin.sonos.model.Entry;

import java.util.Collection;
import java.util.List;

/**
 */
public class EntryCollector implements EntryCallback {
    List<Entry> entries = Lists.newArrayList();

    @Override
    public void addEntries(BrowseHandle handle, Collection<Entry> entries) {
        this.entries.addAll(entries);
    }

    @Override
    public void retrievalComplete(BrowseHandle handle, boolean completedSuccessfully) {
        synchronized (handle) {
            handle.notify();
        }
    }

    @Override
    public void updateCount(BrowseHandle handle, int count) {

    }

    public List<Entry> getEntries() {
        return entries;
    }
}
