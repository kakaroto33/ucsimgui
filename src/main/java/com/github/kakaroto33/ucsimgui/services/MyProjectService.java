package com.github.kakaroto33.ucsimgui.services;

import com.intellij.openapi.components.Service;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.github.kakaroto33.ucsimgui.MyBundle;

import java.util.Random;

@Service(Service.Level.PROJECT)
final class MyProjectService {

    public MyProjectService(Project project) {
        Logger.getInstance(this.getClass()).info(MyBundle.message("projectService", project.getName()));
        Logger.getInstance(this.getClass()).warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
    }

    public int getRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(100);
    }
}
