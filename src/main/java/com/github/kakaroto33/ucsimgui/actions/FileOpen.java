package com.github.kakaroto33.ucsimgui.actions;

import com.github.kakaroto33.ucsimgui.services.UgManager;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileChooser.FileChooserDialog;
import com.intellij.openapi.fileChooser.FileChooserFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class FileOpen extends AnAction {

    //-- EXTENDS AnAction ----------------------------------------------------------------------------------------------

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        // Using the event, create and show a dialog
        Project currentProject = event.getProject();
        StringBuilder message = new StringBuilder(event.getPresentation().getText() + " Selected!");
        // If an element is selected in the editor, add info about it.
        Navigatable selectedElement = event.getData(CommonDataKeys.NAVIGATABLE);
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement);
        }


        FileChooserDescriptor descriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("hex");
        FileChooserDialog chooser = FileChooserFactory.getInstance().createFileChooser(descriptor, currentProject, null); //, UgToolFactory.getInstance().getUgToolForm().getPanelMain().getComponent(0));
        final VirtualFile[] files;
        files = chooser.choose(null);
        if (files.length == 0) {
            System.out.println("No File selected !");
            return;
        }
        VirtualFile file = files[0];
//        UgToolFactory ass;
//        event.getProject().getComponent(ass);
        //outputDirectoryPanel.setText(file.getPath());
        //val descriptor = FileChooserDescriptorFactory.createSingleFileDescriptor("hex");
        //toolWindow.UgToolForm
        //FileChooserFactory.getInstance().createFileChooser(descriptor, null);
        if (currentProject != null) {
            //UgToolFactory toolWindow = (UgToolFactory) ToolWindowManager.getInstance(currentProject).getToolWindow("uCsim GUI");
            System.out.println("UgToolFactory OK: " + file.getPath());
            UgManager projectService = currentProject.getService(UgManager.class);
            projectService.loadFile(file);
        }
    }
}

