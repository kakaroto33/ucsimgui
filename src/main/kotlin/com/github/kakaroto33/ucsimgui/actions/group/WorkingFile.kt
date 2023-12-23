package com.github.kakaroto33.ucsimgui.actions.group

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup

class WorkingFile : DefaultActionGroup() {
    override fun update(event: AnActionEvent) {
        // Enable/disable depending on whether a user is editing...
    }
}