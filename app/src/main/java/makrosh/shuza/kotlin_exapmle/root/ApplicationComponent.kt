package makrosh.shuza.kotlin_exapmle.root

import dagger.Component
import makrosh.shuza.kotlin_exapmle.UserListActivity
import makrosh.shuza.kotlin_exapmle.http.UserApiModule
import makrosh.shuza.kotlin_exapmle.ui.UserListModule
import javax.inject.Singleton

/**
 * Created by Boka on 06-Jun-17.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, UserApiModule::class, UserListModule::class))
interface ApplicationComponent {
    fun inject(target: UserListActivity)
}

