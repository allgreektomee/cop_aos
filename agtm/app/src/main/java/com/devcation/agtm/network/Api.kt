package com.devcation.agtm.network

import com.devcation.agtm.dataModel.agtmClass.AgtmClassDetailResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassReviewResult
import com.devcation.agtm.dataModel.like.LikesClassResult
import com.devcation.agtm.dataModel.like.LikesWineResult
import com.devcation.agtm.dataModel.notice.NoticeDetailResult
import com.devcation.agtm.dataModel.notice.NoticeResult
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.MeResult
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.dataModel.DefaultResult
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.dataModel.reviews.ReviewResult
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
    @GET("api/v1/wine/@{username}") // 와인 목록 ?page=1
    suspend fun getWine(@Query("page") page: Int, @Path("username") username:String) : List<WineResult>

    @GET("api/v1/wine/type/@{type}/@{username}") // 와인 종류별 목록
    suspend fun getWineType(@Path("type") type:String, @Path("username") username:String, @Query("page") page: Int) : List<WineResult>

    @GET("api/v1/wine/re/@{recommand}/@{username}") // 와인 종류별 목록
    suspend fun getWineRecommand(@Path("username") username:String, @Path("recommand") recommand:String,  @Query("page") page: Int) : List<WineResult>

    @GET("api/v1/wine/{id}/@{username}") // 와인 상세
    suspend fun getWineDetail(@Path("id") id:Int, @Path("username") username:String) : WineDetailResult

    @GET("api/v1/wine/{id}/reviews/@{username}") // 와인 상세, 와인리뷰
    suspend fun getWineReviews(@Path("id") id:Int, @Path("username") username:String, @Query("page") page: Int) : MutableList<ReviewResult>

    @POST("api/v1/wine/{id}/reviews/@{username}") // 와인 상세, 와인리뷰
    suspend fun wineReviews(@Path("id") id:Int, @Path("username") username:String, @Query("page") page: Int, @Body param: Review) : ReviewResult


    //users
    @POST("api/v1/users/login") // 로그인
    suspend fun login(@Body param : SignIn) : DefaultResult

    @GET("api/v1/users/me/@{username}") // 사용자 정보
    suspend fun me(@Path("username") username:String) : MeResult

    @POST("api/v1/users/logout") // 로그아웃
    suspend fun logout() : DefaultResult

    @POST("api/v1/users/signup") // 회원가입
    suspend fun signup(@Body param : SignUp) : DefaultResult

    //users - reivews
    @GET("api/v1/users/@{username}/reviews/wine") // 사용자 작성 와인리뷰
    suspend fun getUserWineReviews(@Path("username") username:String, @Query("page") page: Int) : List<WineReviewResult>

    @GET("api/v1/users/@{username}/reviews/class") // 사용자 작성 클래스
    suspend fun getUserClassReviews(@Path("username") username:String, @Query("page") page: Int) : List<AgtmClassReviewResult>

    //users - like
    @GET("api/v1/users/@{username}/likes/wine") // 사용자 좋아요 와인목록
    suspend fun getUserWineLikes(@Path("username") username:String, @Query("page") page: Int) : List<LikesWineResult>
    @GET("api/v1/users/@{username}/likes/class") // 사용자 좋아요
    suspend fun getUserClassLikes(@Path("username") username:String, @Query("page") page: Int) : List<LikesClassResult>

    //users - order
    //users - like
    @GET("api/v1/users/@{username}/order/wine") // 장바구니 와인
    suspend fun getUserWineOrder(@Path("username") username:String, @Query("page") page: Int) : List<LikesWineResult>

    @GET("api/v1/users/@{username}/order/class") // 장바구니 클래스
    suspend fun getUserClassOrder(@Path("username") username:String, @Query("page") page: Int) : List<LikesClassResult>


    @POST("api/v1/like/class/{id}/@{username}") // 토글 클래스
    suspend fun getAgtmClassLikeToggle(@Path("username") username:String, @Path("id") id:Int, @Body param : LikeType) : DefaultResult

    @POST("api/v1/like/wine/{id}/@{username}") //토글 와인
    suspend fun getWineLikeToggle(@Path("username") username:String, @Path("id") id:Int, @Body param : LikeType) : DefaultResult

    //Class
    @GET("api/v1/class/@{username}")
    suspend fun getAgtmClass(@Path("username") username:String, @Query("page") page: Int) : List<AgtmClassResult>

    @GET("api/v1/class/{id}/@{username}")
    suspend fun getAgtmClassDetail(@Path("id") id:Int, @Path("username") username:String) : AgtmClassDetailResult


    @GET("api/v1/class/{id}/reviews/@{username}") //클래스 상세 리뷰
    suspend fun getAgtmClassReviews(@Path("id") id:Int, @Path("username") username:String, @Query("page") page: Int) : MutableList<ReviewResult>

    @POST("api/v1/class/{id}/reviews/@{username}") // 클래스 상세 리뷰
    suspend fun agtmClassReviews(@Path("id") id:Int, @Path("username") username:String, @Query("page") page: Int, @Body param: Review) : ReviewResult


    //Notice
//    Noti = ("1", "Noti")
//    Event = ("2", "Event")
//    Magazine = ("3", "Magazine")
//    Banner = ("4", "Banner")
//    Link = ("5", "Link"),
    @GET("api/v1/notice/type/{type}")
    suspend fun getNoticeType(@Path("type") type:Int, @Query("page") page: Int) : List<NoticeResult>

    @GET("api/v1/notice")
    suspend fun getNotice( @Query("page") page: Int) : List<NoticeResult>

    @GET("api/v1/notice/{id}")
    suspend fun getNoticeDetail(@Path("id") id:Int) : NoticeDetailResult

}