package storage.com.finalstorage.utils;

import java.util.UUID;

/**
 * Created by uukeshov on 18.02.2017.
 */

public class Utils {
    public static String getGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
