package makrosh.shuza.kotlin_exapmle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import makrosh.shuza.kotlin_exapmle.root.App
import makrosh.shuza.kotlin_exapmle.ui.UserListActivityMVP
import makrosh.shuza.kotlin_exapmle.ui.UserListAdapter
import makrosh.shuza.kotlin_exapmle.ui.UserModel
import org.jetbrains.anko.find
import javax.inject.Inject
import kotlin.properties.Delegates

class UserListActivity : AppCompatActivity(), UserListActivityMVP.View {
    @Inject
    lateinit var presenter: UserListActivityMVP.Presenter

    var adapter: UserListAdapter by Delegates.notNull<UserListAdapter>()
    private var rvTestList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).component.inject(this)
        var users: MutableList<UserModel> = mutableListOf()
        adapter = UserListAdapter(users)

        rvTestList = find(R.id.rvUserListUI)
        rvTestList!!.layoutManager = LinearLayoutManager(this)
        rvTestList!!.adapter = adapter
    }

    override fun showLoadingDialog() {

    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun addUserListItem(model: UserModel) {
        adapter.addUserRow(model)
        Toast.makeText(this, "user count: ${adapter.itemCount}", Toast.LENGTH_SHORT).show()
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
