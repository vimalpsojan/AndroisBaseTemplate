package com.vimal.core.ui

import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.appbar.CollapsingToolbarLayout

interface ToolbarProvider {
    val navigationController: NavController
    val appBarConfiguration: AppBarConfiguration
    fun setUpToolbar(toolbar: Toolbar?, collapsingToolbarLayout: CollapsingToolbarLayout? = null)
    fun toggleDrawerEnabled(enableDrawer: Boolean)
    fun setTitleText(title: String?)
}