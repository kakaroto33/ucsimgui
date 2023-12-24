package com.github.kakaroto33.ucsimgui.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class UgToolFactory implements ToolWindowFactory {

//    lateinit var ugForm: UgToolForm;
//
//    init {
//        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
//    }

//    @override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
////        val myToolWindow = MyToolWindow(toolWindow)
////        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
////        toolWindow.contentManager.addContent(content)
//        ugForm = UgToolForm()
//
//        val content = ContentFactory.getInstance().createContent(ugForm.panelMain, null, false)
//        toolWindow.contentManager.addContent(content);
//
//    }

//    override fun shouldBeAvailable(project: Project) = true
//
//    fun getUfForm():UgToolForm
//    {
//        return ugForm;
//    }

    protected UgToolForm ugForm;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ugForm = new UgToolForm();

        Content content = ContentFactory.getInstance().createContent(ugForm.getPanelMain(), null, false);
        toolWindow.getContentManager().addContent(content);
    }


//    class MyToolWindow(toolWindow: ToolWindow) {
//
//        private val service = toolWindow.project.service<MyProjectService>()
//
//
//        fun getContent() = JBPanel<JBPanel<*>>().apply {
//            val label = JBLabel(MyBundle.message("randomLabel", "?"))
//
//            add(label)
//            add(JButton(MyBundle.message("shuffle")).apply {
//                addActionListener {
//                    label.text = MyBundle.message("randomLabel", service.getRandomNumber())
//                }
//            })
//        }
//    }
}
