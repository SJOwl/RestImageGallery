package au.sj.owl.restimagegallery
import android.app.Application
import timber.log.Timber.DebugTree
import timber.log.Timber


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}
