package nello.util;

import java.net.URL;

public class ResourceUtil {

    public static URL get(String resourcePath) {
        return ResourceUtil.class.getResource(resourcePath);
    }

}
