package com.vimal.core.models

import android.content.Intent

data class ActivityNavigationData(var intent: Intent? = null, var finishCurrent: Boolean = false, var activityClass: Class<*>? = null)