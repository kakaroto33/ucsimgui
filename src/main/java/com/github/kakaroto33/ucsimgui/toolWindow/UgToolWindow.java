package com.github.kakaroto33.ucsimgui.toolWindow;

import com.github.kakaroto33.ucsimgui.services.UgManager;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class UgToolWindow implements ToolWindowFactory, Disposable {

    protected UgToolForm ugToolForm;
    protected ToolWindow oapiToolWindow;
    protected Content uiContent;

    //-- PUBLIC METHODS ------------------------------------------------------------------------------------------------

    public ToolWindow getToolWindow() {
        return oapiToolWindow;
    }

    public UgToolForm getUgToolForm() { return ugToolForm; }

    public Content getUiContent() { return uiContent; }

    //-- IMPLEMENTS ToolWindowFactory ----------------------------------------------------------------------------------

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        ugToolForm = new UgToolForm();
        oapiToolWindow = toolWindow;

        uiContent = ContentFactory.getInstance().createContent(getUgToolForm().getPanelMain(), null, false);
        //uiContent.setDisposer(toolWindow.getDisposable());
        toolWindow.getContentManager().addContent(uiContent);

        UgManager projectService = project.getService(UgManager.class);
        projectService.setUgToolWindow(this);

        Disposer.register(toolWindow.getDisposable(), this);

    }

    //-- IMPLEMENTS Disposable -----------------------------------------------------------------------------------------

    @Override
    public void dispose() {

        UgManager.LOGGER.info("dispose(): " + this.getClass());
        ugToolForm.dispose();

    }
}
