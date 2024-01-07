package com.github.kakaroto33.ucsimgui.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
final class UgConfigurable implements Configurable {

    private UgComponent mySettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered in an applicationConfigurable EP

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "SDK: Application Settings Example";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new UgComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        UgState settings = UgState.getInstance();
        boolean modified = !mySettingsComponent.getUserNameText().equals(settings.userId);
        modified |= mySettingsComponent.getIdeaUserStatus() != settings.ideaStatus;
        return modified;
    }

    @Override
    public void apply() {
        UgState settings = UgState.getInstance();
        settings.userId = mySettingsComponent.getUserNameText();
        settings.ideaStatus = mySettingsComponent.getIdeaUserStatus();
        UgWorkspace work = UgWorkspace.getInstance();
        work.Test = mySettingsComponent.getProjectText();
    }

    @Override
    public void reset() {
        UgState settings = UgState.getInstance();
        mySettingsComponent.setUserNameText(settings.userId);
        mySettingsComponent.setIdeaUserStatus(settings.ideaStatus);
        UgWorkspace work = UgWorkspace.getInstance();
        mySettingsComponent.setProjectText(work.Test);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

}
