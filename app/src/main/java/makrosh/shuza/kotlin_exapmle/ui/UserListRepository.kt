package makrosh.shuza.kotlin_exapmle.ui

import makrosh.shuza.kotlin_exapmle.http.UserApi
import makrosh.shuza.kotlin_exapmle.http.pojo.UserListPojo
import rx.Observable
import rx.functions.Func1

/**
 * Created by Shuza on 06-Jun-17.
 */

class UserListRepository(private val userApi: UserApi) : Repository {

    override fun getUsersFromNetwork(): Observable<UserModel> {
        var users: Observable<UserListPojo> = userApi.getUsers()
        return users.concatMap { userListPojo -> Observable.from(userListPojo.userList) }
    }

}