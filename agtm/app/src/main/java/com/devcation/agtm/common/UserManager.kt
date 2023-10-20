package com.devcation.agtm.common

import android.content.Context
import com.devcation.agtm.dataModel.user.MeResult

class UserManager private constructor(context: Context) {

    var userName: String = "woori"
    var userPw: String = "dnfl12!@"

    lateinit var me: MeResult

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