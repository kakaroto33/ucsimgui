package com.github.kakaroto33.ucsimgui.toolWindow;

import com.github.kakaroto33.ucsimgui.services.UgManager;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class UgToolForm implements Disposable {
    private JPanel panelMain;
    private JPanel panelEditorArea;
    private JPanel panelToolBar;
    private JTabbedPane tabbedPane1;
    private JRadioButton radioButton1;
    private JTextArea textAreaFileName;
    private JPanel panelToolBarFile;
    private JPanel panelToolBarRun;
    private JPanel panelEditor;
    private JPanel panelMessages;
    private JTextPane textPaneMessages;
    private JSplitPane splitPaneMain;
    private JSplitPane splitPaneEditor;
    private JSplitPane splitPaneTools;

    //-- NON FORM COMPONENTS -------------------------------------------------------------------------------------------
    private final Editor oapiEditor;

    //-- PUBLIC METHODS ------------------------------------------------------------------------------------------------

    public UgToolForm()
    {
        // Get plugin.xml Action Group to create SDK native action toolbar, place it on reserved JPanel
        ActionManager actionManager     = ActionManager.getInstance();
        ActionGroup groupWorkingFile    = (ActionGroup) actionManager.getAction("com.github.kakaroto33.ucsimgui.actions.group.WorkingFile");
        ActionToolbar actionWorkingFile = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_TITLE, groupWorkingFile, true);
        actionWorkingFile.setTargetComponent(panelToolBarFile.getRootPane());
        actionWorkingFile.setOrientation(SwingConstants.HORIZONTAL);
        panelToolBarFile.add(BorderLayout.EAST, actionWorkingFile.getComponent());

        // Get plugin.xml Action Group to create SDK native action toolbar, place it on reserved JPanel
        ActionGroup groupRun    = (ActionGroup) actionManager.getAction("com.github.kakaroto33.ucsimgui.actions.group.RunForrestRun");
        ActionToolbar actionRun = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_TITLE, groupRun, true);
        actionRun.setTargetComponent(panelToolBarRun.getRootPane());
        actionRun.setOrientation(SwingConstants.HORIZONTAL);
        panelToolBarRun.add(BorderLayout.CENTER, actionRun.getComponent());

        // Create native Intellij editor with lots features
        EditorFactory editorFactory = EditorFactory.getInstance();
        oapiEditor   = editorFactory.createEditor(editorFactory.createDocument("Empty Document"));
        panelEditor.add(BorderLayout.CENTER, oapiEditor.getComponent());

        updateLooks();

    }

    public JPanel getPanelMain() { return panelMain; }

    /**
     * Update custom look and feel, is not full OK with theme changes.
     * TODO: Maybe look how to make it native way..
     */
    public void updateLooks()
    {
        changeSplitPaneDivider(splitPaneMain);
        changeSplitPaneDivider(splitPaneEditor);
        changeSplitPaneDivider(splitPaneTools);
    }

    /**
     * Change JSplitPane divider look and feel to line with 1 pixel
     */
    public static void changeSplitPaneDivider(JSplitPane split)
    {
        split.setUI(new BasicSplitPaneUI()
        {
            @Override
            public BasicSplitPaneDivider createDefaultDivider()
            {
                return new BasicSplitPaneDivider(this)
                {
                    public void setBorder(Border b) {}

                    @Override
                    public void paint(Graphics g)
                    {
                        //https://stackoverflow.com/questions/8934169/how-to-change-the-color-or-background-color-of-jsplitpane-divider
//                        g.setColor(Color.BLACK);
//                        g.fillRect(0, 0, getSize().width, getSize().height);
                        g.setColor(null);
                        if (this.orientation == JSplitPane.HORIZONTAL_SPLIT) {
                            g.fillRect(0, 0, 1, getSize().height);
                        } else {
                            g.fillRect(0, 0, getSize().width, 1);
                        }

                        super.paint(g);
                    }
                };
            }
        });
    }

    //-- IMPLEMENTS Disposable -----------------------------------------------------------------------------------------

    @Override
    public void dispose() {
        UgManager.LOGGER.info("dispose(): " + this.getClass());
        // Need dispose created Intellij Editor, this is manually called on dispose of UgToolWindow.
        EditorFactory.getInstance().releaseEditor(oapiEditor);
    }
}
