package net.zerotask.libraries.android.foundation.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.annotation.CallSuper
import timber.log.Timber

abstract class BaseApplication : Application() {
    @CallSuper
    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(LifecycleCallbackLogger())
    }
}

private class LifecycleCallbackLogger : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Timber.d("onCreate()")
    }

    override fun onActivityStarted(activity: Activity) {
        Timber.d("onStart()")
    }

    override fun onActivityResumed(activity: Activity) {
        Timber.d("onResume()")
    }

    override fun onActivityPaused(activity: Activity) {
        Timber.d("onPause()")
    }

    override fun onActivityStopped(activity: Activity) {
        Timber.d("onStop()")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Timber.d("onSaveInstanceState()")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.d("onDestroy()")
    }
}
