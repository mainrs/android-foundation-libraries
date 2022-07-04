package net.zerotask.libraries.android.foundation.app.initializers

import net.zerotask.libraries.android.foundation.BuildConfig
import net.zerotask.libraries.android.foundation.app.Initializer
import timber.log.Timber

object TimberInitializer : Initializer {
    override fun initialize() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
