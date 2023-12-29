package com.github.kakaroto33.ucsimgui.simulators;

import com.intellij.openapi.vfs.VirtualFile;

public abstract class UgSimulator {

    //-- SUPPORTED SIMULATOR TYPES -------------------------------------------------------------------------------------
    public static final String SIMULATOR_S51        = "S51";

    //-- PUBLIC METHODS ------------------------------------------------------------------------------------------------

    public boolean loadFile(VirtualFile file)
    {
        if (!file.exists()) return false;


        return true;
    }

    public String getListSimulators()
    {
        String fuu = "";

        return fuu;
    }

    //-- ABSTRACT METHODS ----------------------------------------------------------------------------------------------

    public abstract String getExample(int num);

}
