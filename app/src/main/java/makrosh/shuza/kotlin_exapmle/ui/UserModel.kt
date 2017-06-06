package makrosh.shuza.kotlin_exapmle.ui

/**
 * Created by Shuza on 06-Jun-17.
 */

import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("id")
    var id: Int = -1

    @SerializedName("first_name")
    var firstName: String = ""

    @SerializedName("last_name")
    var lastName: String = ""

    @SerializedName("avatar")
    var photo: String = ""
}