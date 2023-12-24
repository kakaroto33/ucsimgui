package com.github.kakaroto33.ucsimgui.listeners;


import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.wm.IdeFrame;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;

public class Activation implements ApplicationActivationListener {
//    @Override
//    public void applicationActivated(IdeFrame ideFrame) {
//        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
//    }

    @Override
    public void applicationActivated(@NotNull IdeFrame ideFrame) {
        Logger.getInstance(this.getClass()).warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
        //System.out.println("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
    }
}