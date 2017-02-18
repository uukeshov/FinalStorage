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
}
