package makrosh.shuza.kotlin_exapmle.root

import android.app.Application
import makrosh.shuza.kotlin_exapmle.http.UserApiModule
import makrosh.shuza.kotlin_exapmle.ui.UserListModule

/**
 * Created by Shuza on 06-Jun-17.
 */

class App : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        val component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .userApiModule(UserApiModule())
                .userListModule(UserListModule())
                .build()
        this.component = component
    }
}
