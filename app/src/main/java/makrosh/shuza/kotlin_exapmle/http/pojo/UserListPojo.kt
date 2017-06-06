package makrosh.shuza.kotlin_exapmle.http.pojo

import com.google.gson.annotations.SerializedName
import makrosh.shuza.kotlin_exapmle.ui.UserModel

/**
 * Created by Shuza on 06-Jun-17.
 */

class UserListPojo {

    @SerializedName("page")
    var pageNo:Int = -1

    @SerializedName("data")
    var userList: MutableList<UserModel> = mutableListOf<UserModel>()

}
