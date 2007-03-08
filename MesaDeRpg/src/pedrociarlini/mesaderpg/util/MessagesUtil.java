package pedrociarlini.mesaderpg.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessagesUtil {

    private static final String BUNDLE_NAME = "pedrociarlini.mesaderpg.ui.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private MessagesUtil() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
