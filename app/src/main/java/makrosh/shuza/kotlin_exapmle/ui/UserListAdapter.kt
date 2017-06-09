package makrosh.shuza.kotlin_exapmle.ui

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import makrosh.shuza.kotlin_exapmle.R
import kotlin.properties.Delegates

/**
 * Created by Shuza on 07-Jun-17.
 */

class UserListAdapter(private var userList: MutableList<UserModel>) : RecyclerView.Adapter<UserListAdapter.UserItemViewHolder>() {

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.tvUserId.text = userList[position].id.toString()
        holder.tvUserName.text = userList[position].firstName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return UserItemViewHolder(view)
    }

    fun addUserRow(userModel: UserModel) {
        userList.add(userModel)
        notifyDataSetChanged()
    }


    class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPhoto: ImageView by Delegates.notNull<ImageView>()
        var tvUserId: TextView by Delegates.notNull<TextView>()
        var tvUserName: TextView by Delegates.notNull<TextView>()

        init {
            ivPhoto = itemView.findViewById(R.id.ivUserListRow) as ImageView
            tvUserId = itemView.findViewById(R.id.tvUserListId) as TextView
            tvUserName = itemView.findViewById(R.id.tvUserListName) as TextView
        }
    }

}
