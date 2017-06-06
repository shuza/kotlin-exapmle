package makrosh.shuza.kotlin_exapmle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import makrosh.shuza.kotlin_exapmle.root.App
import makrosh.shuza.kotlin_exapmle.root.ApplicationComponent
import makrosh.shuza.kotlin_exapmle.ui.UserListActivityMVP
import makrosh.shuza.kotlin_exapmle.ui.UserModel
import javax.inject.Inject

class UserListActivity : AppCompatActivity(), UserListActivityMVP.View {
    @BindView(R.id.rvUserList)
    lateinit var rvUserList: RecyclerView

    @Inject
    lateinit var presenter: UserListActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).component.inject(this)
        ButterKnife.bind(this)
    }

    override fun showLoadingDialog() {

    }

    override fun showErrorMessage(message: String) {

    }

    override fun addUserListItem(model: UserModel) {

    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
        presenter.loadUserList()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxUnsubscribe()
    }

}
