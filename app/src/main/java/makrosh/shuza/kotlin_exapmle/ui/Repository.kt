package makrosh.shuza.kotlin_exapmle.ui

import rx.Observable

/**
 * Created by Shuza on 06-Jun-17.
 */

interface Repository {
    fun getUsersFromNetwork(): Observable<UserModel>
}
