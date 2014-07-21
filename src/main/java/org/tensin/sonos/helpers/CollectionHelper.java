package org.tensin.sonos.helpers;

/**
 * The Class CollectionHelper.
 */
public class CollectionHelper {
    /**
     * Single dump.
     *
     * @param l the l
     * @return the string
     */
    public static String singleDump(final Object[] l) {
        StringBuilder sb = new StringBuilder();
        if (l == null) {
            sb.append("[]");
        } else if (l.length == 0) {
            sb.append("[]");
        } else {
            int cnt = 0;
            sb.append("[");
            for (final Object o : l) {
                if (cnt++ > 0) {
                    sb.append(", ");
                }
                sb.append(o.toString());
            }
            sb.append("]");
        }
        return (sb.toString());
    }
}
