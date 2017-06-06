package makrosh.shuza.kotlin_exapmle.ui

import dagger.Module
import dagger.Provides
import makrosh.shuza.kotlin_exapmle.http.UserApi
import javax.inject.Singleton

/**
 * Created by Shuza on 06-Jun-17.
 */
@Module
class UserListModule {

    @Provides
    fun provideUserListActivityPresenter(model: UserListActivityMVP.Model): UserListActivityMVP.Presenter {
        return UserListPresenter(model)
    }

    @Provides
    fun provideUserListActivityModel(repository: Repository): UserListActivityMVP.Model {
        return UserListModel(repository)
    }

    @Provides
    @Singleton
    fun provideRepository(userApi: UserApi): Repository {
        return UserListRepository(userApi)
    }

}
