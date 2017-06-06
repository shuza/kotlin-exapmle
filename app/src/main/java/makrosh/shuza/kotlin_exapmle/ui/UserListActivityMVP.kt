package makrosh.shuza.kotlin_exapmle.ui

import rx.Observable

/**
 * Created by Boka on 06-Jun-17.
 */

interface UserListActivityMVP {

    interface View {
        fun showLoadingDialog()
        fun showErrorMessage(message: String)
        fun addUserListItem(model: UserModel)
    }

    interface Presenter {
        fun setView(view: UserListActivityMVP.View)
        fun loadUserList()
        fun rxUnsubscribe()
    }

    interface Model {
        fun getUserList(): Observable<UserModel>
    }

}
