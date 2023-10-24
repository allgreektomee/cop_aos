package com.devcation.agtm.repository

import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.network.Api
import com.devcation.agtm.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getWine(page:Int, username:String) = client.getWine(page, username)
    suspend fun getWineDetail(username:String, id:Int) = client.getWineDetail(id, username)
    suspend fun getWineReviews( id:Int,username:String, page: Int) = client.getWineReviews(id, username, page)

    suspend fun wineReviews( id:Int,username:String, page: Int, review: Review) = client.wineReviews(id, username, page, review )

    suspend fun getWineType( type:String , username:String, page: Int) = client.getWineType( type, username, page)

    suspend  fun getWineRecommand(username:String, recommand:String, page:Int) = client.getWineRecommand(username, recommand, page)




    suspend fun login(signIn: SignIn) = client.login(signIn)
    suspend fun logout() = client.logout()
    suspend fun me(username: String) = client.me(username)
    suspend fun signup(signup: SignUp) = client.signup(signup)
    suspend fun getUserWineReviews(username: String, page: Int) = client.getUserWineReviews(username, page)
    suspend fun getUserClassReviews(username: String, page: Int) = client.getUserClassReviews(username, page)

    suspend fun getUserWineLikes(username: String, page: Int) = client.getUserWineLikes(username, page)

    suspend fun getUserClassLikes(username: String, page: Int) = client.getUserClassLikes(username, page)

    suspend fun getUserWineOrder(username: String, page: Int) = client.getUserWineOrder(username, page)

    suspend fun getUserClassOrder(username: String, page: Int) = client.getUserClassOrder(username, page)


    suspend fun getAgtmClass(username: String, page: Int) = client.getAgtmClass(username, page)
    suspend fun getAgtmClassDetail(id : Int, username: String) = client.getAgtmClassDetail(id, username)

    suspend fun getAgtmClassReviews( id:Int, username:String, page: Int) = client.getAgtmClassReviews(id, username, page)

    suspend fun agtmClassReviews( id:Int,username:String, page: Int, review: Review) = client.agtmClassReviews(id, username, page, review )




    suspend fun getWineLikeToggle(username: String, id: Int, param: LikeType) = client.getWineLikeToggle(username, id, param)

    suspend fun getAgtmClassLikeToggle(username: String, id: Int, param: LikeType) = client.getAgtmClassLikeToggle(username,  id, param)




    suspend fun getNoticeType(type : Int, page: Int) = client.getNoticeType(type, page)

    suspend fun getNotice(page: Int) = client.getNotice(page)

    suspend fun getNoticeDetail(id : Int) = client.getNoticeDetail(id)

}