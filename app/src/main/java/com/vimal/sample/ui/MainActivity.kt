package com.vimal.sample.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.vimal.core.ktx.AppCompatActivityKtx.viewBinding
import com.vimal.core.models.LoadingMessageData
import com.vimal.core.models.MessageData
import com.vimal.core.ui.BaseActivity
import com.vimal.core.ui.ToolbarProvider
import com.vimal.sample.R
import com.vimal.sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), ToolbarProvider {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override lateinit var navigationController: NavController
    private lateinit var host: NavHostFragment


    override val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
                setOf(
                        //R.id.splashFragment, R.id.dashBoardFragment
                )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.isLoading = false
        binding.message = "Loading"
        setupNavigationControl()
    }

    private fun setupNavigationControl() {
        host = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        navigationController = host.navController
    }


    override fun onLoadingMessage(messageData: LoadingMessageData) {
        if (messageData.context == null) {
            messageData.context = this
        }
        binding.isLoading = messageData.isLoading
        binding.message = messageData.getMessage()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onInfoMessage(messageData: MessageData) {
        if (messageData.context == null) {
            messageData.context = this
        }
        showDialog(
                messageData.getTitle(),
                messageData.getMessage(),
                messageData.getPositiveButton(),
                messageData.positiveAction,
                messageData.getNegativeButton(),
                messageData.negativeAction,
                messageData.getNeutralButton(),
                messageData.triggerActionOnDismiss,
                messageData.canDismiss
        )
    }

    override fun onLogout() {
        TODO("Not yet implemented")
    }

    override fun setUpToolbar(toolbar: Toolbar?, collapsingToolbarLayout: CollapsingToolbarLayout?) {
        if (toolbar == null)
            return
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navigationController)
        toolbar.setupWithNavController(navigationController, appBarConfiguration)
        if (collapsingToolbarLayout != null)
            NavigationUI.setupWithNavController(
                    collapsingToolbarLayout, toolbar, navigationController, appBarConfiguration
            )
        else
            NavigationUI.setupWithNavController(toolbar, navigationController, appBarConfiguration)
    }

    override fun toggleDrawerEnabled(enableDrawer: Boolean) {
        TODO("Not yet Drawer not available")
    }

    override fun setTitleText(title: String?) {
        setTitle(title)
    }

    private fun showDialog(
            title: String?,
            message: String?,
            positiveButton: String?,
            positiveAction: (() -> Unit)?,
            negativeButton: String?,
            negativeAction: (() -> Unit)?,
            neutralButton: String?,
            triggerActionOnDismiss: Boolean,
            canDismiss: Boolean
    ): AlertDialog {
        var isClicked = false
        val dialogBuilder = MaterialAlertDialogBuilder(this)
        dialogBuilder.setTitle(title)
        dialogBuilder.setMessage(message)
        positiveButton?.let {
            dialogBuilder.setPositiveButton(it) { dialog, _ ->
                isClicked = true
                positiveAction?.invoke()
                dialog?.dismiss()
            }
        }
        negativeButton?.let {
            dialogBuilder.setNegativeButton(it) { dialog, _ ->
                isClicked = true
                negativeAction?.invoke()
                dialog?.dismiss()
            }
        }

        neutralButton?.let {
            dialogBuilder.setNeutralButton(it) { dialog, _ ->
                isClicked = true
                dialog?.dismiss()
            }
        }
        if (negativeButton == null && positiveButton == null && neutralButton == null) {
            dialogBuilder.setNeutralButton(
                    R.string.ok
            ) { dialog, _ ->
                isClicked = true
                dialog.dismiss()
            }
        }
        if (triggerActionOnDismiss) {
            dialogBuilder.setOnDismissListener {
                if (negativeAction != null && !isClicked) {
                    negativeAction.invoke()
                } else if (positiveAction != null && !isClicked) {
                    positiveAction.invoke()
                }
            }
        }
        dialogBuilder.setCancelable(canDismiss)
        val dialog = dialogBuilder.create()
        runOnUiThread { dialog.show() }
        return dialog
    }
}