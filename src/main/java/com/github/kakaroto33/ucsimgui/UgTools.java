package com.github.kakaroto33.ucsimgui;

import java.io.File;
import java.util.Objects;

public abstract class UgTools {

    /**
     * Check if we are in windows.
     * @return boolean
     */
    public static boolean isWindows()
    {
        return (Objects.equals(File.separator, "\\"));
        //return System.getProperty("os.name").startsWith("Windows");
    }
}
