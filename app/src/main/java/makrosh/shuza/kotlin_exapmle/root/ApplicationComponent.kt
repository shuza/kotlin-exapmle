package makrosh.shuza.kotlin_exapmle.root

import dagger.Component
import makrosh.shuza.kotlin_exapmle.UserListActivity
import javax.inject.Singleton

/**
 * Created by Boka on 06-Jun-17.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(target: UserListActivity)
}

