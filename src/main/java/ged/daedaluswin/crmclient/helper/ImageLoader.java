package ged.daedaluswin.crmclient.helper;

import javax.swing.*;

/**
 * Created by TeoGia on 10 April 2015.
 *
 * This class implements a simple ImageLoader (used by the IconMapping class) to pre-load the project's Images.
 */

public class ImageLoader {

    protected static ImageIcon getIcon (String path) {
        ImageLoader imageLoader = new ImageLoader();
        ImageIcon icon = imageLoader.createImageIcon(path);
        return icon;
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
