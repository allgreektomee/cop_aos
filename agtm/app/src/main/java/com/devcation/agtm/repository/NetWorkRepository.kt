package com.devcation.agtm.repository

import com.devcation.agtm.dataModel.user.Login
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.network.Api
import com.devcation.agtm.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getWine(page:Int) = client.getWine(page)
    suspend fun getWineDetail(id:Int) = client.getWineDetail(id)
    suspend fun getWineReviews(id:Int , page: Int) = client.getWineReviews(id, page)




    suspend fun login(login: Login) = client.login(login)
    suspend fun me() = client.me()
    suspend fun signup(signup: SignUp) = client.signup(signup)
    suspend fun getUserWineReviews(username: String, page: Int) = client.getUserWineReviews(username, page)
    suspend fun getUserClassReviews(username: String, page: Int) = client.getUserClassReviews(username, page)

    suspend fun getAgtmClass() = client.getAgtmClass()
    suspend fun getAgtmClassDetail(id : Int) = client.getAgtmClassDetail(id)
}