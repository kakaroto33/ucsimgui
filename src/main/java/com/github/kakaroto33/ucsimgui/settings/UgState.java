package com.github.kakaroto33.ucsimgui.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 * This state is stored in IDE Intellij Settings, common on all projects.
 */
@State(
        name = "com.github.kakaroto33.ucsimgui.settings.UgState",
        storages = @Storage("uCsimGUI-settings.xml")
)
final class UgState implements PersistentStateComponent<UgState> {

    public String userId = "John Q. Public";
    public boolean ideaStatus = false;

    static UgState getInstance() {
        return ApplicationManager.getApplication().getService(UgState.class);
    }

    @Nullable
    @Override
    public UgState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull UgState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
