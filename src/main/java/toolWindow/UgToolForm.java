package toolWindow;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;

import javax.swing.*;
import java.awt.*;

public class UgToolForm {
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

    public UgToolForm()
    {
        ActionManager actionManager = ActionManager.getInstance();
        //DefaultActionGroup actionGroup = new DefaultActionGroup("ACTION_GROUP", false);
        //actionGroup.add(ActionManager.getInstance().getAction("deployAction"));
        //actionGroup.add(ActionManager.getInstance().getAction("com.k33.ucsimgui.PopupDialogAction"));

        //DefaultActionGroup actionGroup2 = ActionManager.getInstance().getAction("com.k33.ucsimgui.PopupDialogAction")
        ActionGroup groupWorkingFile = (ActionGroup) actionManager.getAction("com.github.kakaroto33.ucsimgui.actions.group.WorkingFile");

        //ActionToolbar actionToolbar = actionManager.createActionToolbar("ACTION_TOOLBAR", actionGroup, true);

        ActionToolbar actionWorkingFile = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_TITLE, groupWorkingFile, true);
        actionWorkingFile.setTargetComponent(panelToolBarFile.getRootPane());
        actionWorkingFile.setOrientation(SwingConstants.HORIZONTAL);
        //actionToolbar.setLayoutPolicy(SwingConstants.NORTH);
        //this.setToolbar(actionToolbar.getComponent());
        panelToolBarFile.add(BorderLayout.EAST, actionWorkingFile.getComponent());

        ActionGroup groupRun = (ActionGroup) actionManager.getAction("com.github.kakaroto33.ucsimgui.actions.group.RunForrestRun");
        ActionToolbar actionRun = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_TITLE, groupRun, true);
        actionRun.setTargetComponent(panelToolBarRun.getRootPane());
        actionRun.setOrientation(SwingConstants.HORIZONTAL);
        panelToolBarRun.add(BorderLayout.CENTER, actionRun.getComponent());

        EditorFactory editorFactory = EditorFactory.getInstance();
        Document document = editorFactory.createDocument("initialText");
        Editor editor = editorFactory.createEditor(document);
        panelEditor.add(BorderLayout.CENTER, editor.getComponent());

    }

    public JPanel getPanelMain()
    {
        return panelMain;
    }
}
