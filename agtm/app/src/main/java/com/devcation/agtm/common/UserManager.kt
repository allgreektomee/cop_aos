package com.devcation.agtm.common

import android.content.Context

class UserManager private constructor(context: Context) {

    var userName: String = ""
    var userPw: String = ""

    companion object {
        @Volatile
        private var userManager: UserManager? = null


        fun getInstance(context: Context) =
            userManager ?: synchronized(UserManager::class.java) {
                userManager ?: UserManager(context).also {
                    userManager = it
                }
            }
    }
}