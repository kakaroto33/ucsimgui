package com.github.kakaroto33.ucsimgui.settings;

import com.github.kakaroto33.ucsimgui.services.UgManager;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 * This state is stored in Project Workspace Settings, will change for each project.
 */
@State(
        name = "com.github.kakaroto33.ucsimgui.settings.UgWorkspace",
        storages = @Storage("uCsimGUI-workspace.xml")
        //storages = @Storage(StoragePathMacros.WORKSPACE_FILE)
        //storages = @Storage("$PROJECT_CONFIG_DIR$/uCsimGUI-workspace.xml")

)
@Service(Service.Level.PROJECT)
final class UgWorkspace implements PersistentStateComponent<UgWorkspace> {

    public String Test = "Test in Work Space";
    public boolean ideaStatus = false;

    static UgWorkspace getInstance() {
        //return ApplicationManager.getApplication().getService(UgWorkspace.class);
        //ComponentManager.getService(UgWorkspace.class);
        //project.getService(UgManager.class);
        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        if (projects.length > 0) {
            return projects[0].getService(UgWorkspace.class);
        }
        return ProjectManager.getInstance().getDefaultProject().getService(UgWorkspace.class);
        //return ServiceManager.getService(UgWorkspace.class);

    }

    @Nullable
    @Override
    public UgWorkspace getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull UgWorkspace state) {

        XmlSerializerUtil.copyBean(state, this);
    }

}
