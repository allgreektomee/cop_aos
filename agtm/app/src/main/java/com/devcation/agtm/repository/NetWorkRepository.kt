package com.devcation.agtm.repository

import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.network.Api
import com.devcation.agtm.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getWine(page:Int) = client.getWine(page)
    suspend fun getWineDetail(id:Int) = client.getWineDetail(id)
    suspend fun getWineReviews(id:Int , page: Int) = client.getWineReviews(id, page)



    suspend fun getWineType(type:String , page: Int) = client.getWineType(type, page)

    suspend fun getWineRecommand(recommand:String , page: Int) = client.getWineRecommand(recommand, page)




    suspend fun login(signIn: SignIn) = client.login(signIn)
    suspend fun logout() = client.logout()
    suspend fun me(username: String) = client.me(username)
    suspend fun signup(signup: SignUp) = client.signup(signup)
    suspend fun getUserWineReviews(username: String, page: Int) = client.getUserWineReviews(username, page)
    suspend fun getUserClassReviews(username: String, page: Int) = client.getUserClassReviews(username, page)

    suspend fun getUserWineLikes(username: String, page: Int) = client.getUserWineLikes(username, page)

    suspend fun getUserClassLikes(username: String, page: Int) = client.getUserClassLikes(username, page)

    suspend fun getAgtmClass(page: Int) = client.getAgtmClass(page)
    suspend fun getAgtmClassDetail(id : Int) = client.getAgtmClassDetail(id)



    suspend fun getWineLikeToggle(username: String, id: Int, param: LikeType) = client.getWineLikeToggle(username, id, param)

    suspend fun getAgtmClassLikeToggle(username: String, id: Int, param: LikeType) = client.getAgtmClassLikeToggle(username,  id, param)




    suspend fun getNoticeType(type : Int, page: Int) = client.getNoticeType(type, page)

    suspend fun getNotice(page: Int) = client.getNotice(page)

    suspend fun getNoticeDetail(id : Int) = client.getNoticeDetail(id)

}