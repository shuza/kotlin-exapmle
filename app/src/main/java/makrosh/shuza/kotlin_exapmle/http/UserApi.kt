package makrosh.shuza.kotlin_exapmle.http

import makrosh.shuza.kotlin_exapmle.http.pojo.UserListPojo
import makrosh.shuza.kotlin_exapmle.ui.UserModel
import retrofit2.http.GET
import rx.Observable

/**
 * Created by Shuza on 06-Jun-17.
 */

interface UserApi {

    @GET("/api/users?page=2")
    fun getUsers(): Observable<UserListPojo>
}
