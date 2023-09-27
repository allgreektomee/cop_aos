package com.devcation.agtm.network

import com.devcation.agtm.dataModel.agtmClass.AgtmClassDetailResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassReviewResult
import com.devcation.agtm.dataModel.user.Login
import com.devcation.agtm.dataModel.user.MeResult
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.dataModel.user.SignUpResult
import com.devcation.agtm.dataModel.wine.WineResult
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    //wine
    @GET("api/v1/wine/") // 와인 목록 ?page=1
    suspend fun getWine(@Query("page") page: Int) : List<WineResult>

    @GET("api/v1/wine/{id}") // 와인 상세
    suspend fun getWineDetail(@Path("id") id:Int) : WineDetailResult

    @GET("api/v1/wine/{id}/reviews") // 와인 상세, 와인리뷰
    suspend fun getWineReviews(@Path("id") id:Int, @Query("page") page: Int) : List<WineReviewResult>


    //users
    @POST("api/v1/users/login") // 로그인
    suspend fun login(@Body param : Login) : Map<String,Any>

    @GET("api/v1/users/me") // 사용자 정보
    suspend fun me() : MeResult

    @POST("api/v1/users/logout") // 로그아웃
    suspend fun logout() : Map<String,Any>

    @POST("api/v1/users/signup") // 회원가입
    suspend fun signup(@Body param : SignUp) : SignUpResult

    //users - reivews
    @GET("api/v1/users/@{username}/reviews/wine") // 사용자 작성 와인리뷰
    suspend fun getUserWineReviews(@Path("username") username:String, @Query("page") page: Int) : List<WineReviewResult>

    @GET("api/v1/users/@{username}/reviews/class") // 사용자 작성 클래스
    suspend fun getUserClassReviews(@Path("username") username:String, @Query("page") page: Int) : List<AgtmClassReviewResult>

    //Class
    @GET("api/v1/class") // 사용자 정보
    suspend fun getAgtmClass() : List<AgtmClassResult>

    @GET("api/v1/class/{id}") // 사용자 정보
    suspend fun getAgtmClassDetail(@Path("id") id:Int) : AgtmClassDetailResult
}