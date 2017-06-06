package makrosh.shuza.kotlin_exapmle.ui

import rx.Observable

/**
 * Created by Shuza on 06-Jun-17.
 */

class UserListModel(private val repository: Repository) : UserListActivityMVP.Model {

    override fun getUserList(): Observable<UserModel> {
        return repository.getUsersFromNetwork()
    }

}
