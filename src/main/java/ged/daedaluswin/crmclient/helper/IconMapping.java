package ged.daedaluswin.crmclient.helper;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by TeoGia on 11 April 2015.
 *
 * Implements a class that uses 2 HashMaps, in order to pre-load all available Images (using ImageLoader class).
 *
 * The first HashMap (iconMap) is a static one, updated by the developer, whenever a new icon is added.
 * The second one is created after the class has been instantiated and keeps the Icon Objects of the forms' elements.
 *
 * Finally, this class is also responsible for loading the correct set of Icons into the memory, depending on screen
 * resolution.
 */

public class IconMapping {
    private static final HashMap<String, String> iconMap = new HashMap<>();
    private HashMap<String, Icon> loadedIconMap = new HashMap<>();


    private void createIconMap() {
        iconMap.put("contactManagementButton", "/images/" + rightIconSize() + "/customers.png");
        iconMap.put("title", "/images/" + rightIconSize() + "/logoOrange.png");
        iconMap.put("searchButton", "/images/" + rightIconSize() + "/search.png");
        iconMap.put("settingsButton", "/images/" + rightIconSize() + "/tools.png");
        iconMap.put("notificationsButton", "/images/" + rightIconSize() + "/help.png");
        iconMap.put("profileButton", "/images/" + rightIconSize() + "/help.png");
        iconMap.put("activityManagementButton", "/images/" + rightIconSize() + "/activities.png");
        iconMap.put("reportingOLAPsButton", "/images/" + rightIconSize() + "/help.png");
        iconMap.put("loyaltyManagementButton", "/images/" + rightIconSize() + "/help.png");
        System.out.println("Initiating icon-mapping for " + rightIconSize() + " screen resolution.");
    }

    public void loadIconMap() {
        createIconMap();
        Iterator it = iconMap.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            loadedIconMap.put((String) pair.getKey(), ImageLoader.getIcon((String) pair.getValue()));
        }
    }

    public Icon getMyIcon(String key){
       return loadedIconMap.get(key);
    }

    private static String screenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        return (width + "x" + height);
    }

    private String rightIconSize(){
        String screenResolution = screenSize();
        if (Objects.equals(screenResolution.substring(0, 4), "1024")) {return "1024x768";}
        else if (Objects.equals(screenResolution.substring(0, 4), "1280")) {return "1280x800";}
        else if (Objects.equals(screenResolution.substring(0, 4), "1680")) {return "1680x1050";}
        else if (Objects.equals(screenResolution.substring(0, 4), "1920")) {return "1920x1080";}
        else {return "1366x768";}
    }
}
