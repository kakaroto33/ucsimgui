package com.github.kakaroto33.ucsimgui.simulators;

import com.github.kakaroto33.ucsimgui.UgTools;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.HashMap;
import java.util.Map;
import java.net.URL;

public abstract class UgSimulator {

    //-- SUPPORTED SIMULATOR TYPES -------------------------------------------------------------------------------------

    /**
     * Defines simulator supported
     */
    public enum Simulator {
        S51 ("Intel MCS51 Family", "ucsim_51"),
        /*
ucsim_51
ucsim_m6800
ucsim_m6809
ucsim_m68hc08
ucsim_m68hc11
ucsim_m68hc12
ucsim_mos6502
ucsim_pdk
ucsim_rxk
ucsim_stm8
ucsim_tlcs
ucsim_xa
ucsim_z80
         */
        M6800 ("Z80 Microcontroller", "ucsim_z80"),
        ;

        private final String description;
        private final String executable;

        Simulator(String desc, String execName) {
            description = desc;
            executable = execName;
        }
        public String getExecutable() {
            if (UgTools.isWindows()) {
                return executable + ".exe";
            }
            return executable;
        }

        public String getDescription() {
            return description;
        }
    }
    //public static final String SIMULATOR_S51        = "S51";

    //-- PUBLIC METHODS ------------------------------------------------------------------------------------------------

    public boolean loadFile(VirtualFile file)
    {
        if (!file.exists()) return false;

        URL res = this.getClass().getResource("/myfont.ttf");
        res.getPath();

        return true;
    }


    //-- PUBLIC STATIC METHODS -----------------------------------------------------------------------------------------

    public static Map<String, String> getListSimulators()
    {
        Map<String, String> keyValueMap = new HashMap<>();
        for ( Simulator sim: Simulator.values()) {
            keyValueMap.put(sim.getExecutable(), sim.getDescription());
        }
        return keyValueMap;
    }

    //-- ABSTRACT METHODS ----------------------------------------------------------------------------------------------

    public abstract String getExample(int num);

}
