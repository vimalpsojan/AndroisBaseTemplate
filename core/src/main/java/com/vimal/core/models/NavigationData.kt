package com.vimal.core.models

import android.os.Bundle
import androidx.annotation.IdRes

data class NavigationData(@IdRes val id: Int, val bundle: Bundle? = null)