package makrosh.shuza.kotlin_exapmle.ui

import android.util.Log
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Shuza on 06-Jun-17.
 */

class UserListPresenter(private val model: UserListActivityMVP.Model) : UserListActivityMVP.Presenter {
    private var view: UserListActivityMVP.View? = null
    private var subscription: Subscription? = null

    override fun setView(view: UserListActivityMVP.View) {
        this.view = view
    }

    override fun loadUserList() {
        subscription = model.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<UserModel> {
                    override fun onCompleted() {
                    }

                    override fun onNext(t: UserModel?) {
                        view?.addUserListItem(t!!)
                    }

                    override fun onError(e: Throwable?) {
                        view?.showErrorMessage(e!!.message.toString())
                    }

                })
    }

    override fun rxUnsubscribe() {
        subscription?.unsubscribe()
    }

}
