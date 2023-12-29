package com.github.kakaroto33.ucsimgui.services;

import com.github.kakaroto33.ucsimgui.toolWindow.UgToolWindow;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.github.kakaroto33.ucsimgui.UgBundle;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@Service(Service.Level.PROJECT)
public final class UgManager implements UgManagerInterface, Disposable {

    private final Project oapiProject;
    private UgToolWindow ugToolWindow;

    public static final Logger LOGGER;

    //-- PUBLIC METHODS ------------------------------------------------------------------------------------------------

    public UgManager(Project project) {

        UgManager.LOGGER.info(UgBundle.message("projectService", project.getName()));
        UgManager.LOGGER.warn("===>" + project.getName() );
        UgManager.LOGGER.warn(" XX Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");

        oapiProject = project;
        //myProject.getDisposed();
        //LOGGER = Logger.getInstance(this.getClass());
    }

    public void setUgToolWindow(UgToolWindow toolWindow) { ugToolWindow = toolWindow; }

    public Project getUgProject() { return oapiProject; }

    public boolean loadFile(VirtualFile file) {


        LOGGER.info(" ==> loadFile: " + file.getPath());

        return true;
    }

    public void getExampleList(String a) {

    }

    //-- IMPLEMENTS Disposable -----------------------------------------------------------------------------------------

    @Override
    public void dispose() {

    }

    static {
        //Logger var0 = Logger.getInstance(UgManager.class);
        Logger var0 = Logger.getInstance("[uCSim GUI]");
        LOGGER = var0;
    }
}
