package makrosh.shuza.kotlin_exapmle.ui

/**
 * Created by Boka on 06-Jun-17.
 */

interface UserListActivityMVP {

    interface View {
        fun showLoadingDialog()
        fun showErrorMessage(message: String)
        fun showUserList()
    }

    interface Presenter {
        fun setView(view: UserListActivityMVP.View)
        fun loadUserList()
        fun rxUnsubscribe()
    }

    interface Model {

    }

}
