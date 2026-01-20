package com.demo.userdetailsapplication.data.api

import com.demo.userdetailsapplication.data.model.WeatherResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Streaming
import retrofit2.http.Url

interface ApiService {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String
    ): WeatherResponse

    /*1. GET Request – No Parameters*/
    @GET("posts")
    suspend fun getPosts(): List<CommonResponse>

    /*2. GET Request – With Path Parameter
    * URL: /users/5 */
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): CommonResponse

    /*3. GET Request – With Query Parameter
    * URL: /search?query=android */
    @GET("search")
    suspend fun search(@Query("query") searchText: String): CommonResponse

    /*4. GET Request – Multiple Query Params
    * URL: /products?category=mobile&limit=20 */
    @GET("product")
    suspend fun fetchProduct(
        @Query("category") mobile: String,
        @Query("limit") limit: String
    ): CommonResponse

    /*5. GET Request – QueryMap(When dynamic parameters required,in a product listing page, the filters change based on user selections — category, brand, rating,)
    * URL: /products?category=mobile&brand=samsung&sort=price&min=10000&max=30000&page=1
    * URL: /products?category=mobile&rating=4&discount=10 */
    @GET("products")
    suspend fun fetchDynamicProd(@QueryMap options: Map<String, String>): CommonResponse

    /*6. POST Request – With JSON Body*/
    @POST("login")
    suspend fun login(@Body request: CommonRequest): CommonResponse

    /*7. POST Request – With Path + Body
    * URL: /users/5/update */
    @POST("/users/{id}/update")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Body request: CommonRequest
    ): CommonResponse
    /*8. PUT Request – Full Update(When you want to replace the full object)
    * URL: /users/5 */
    @PUT("/users/{id}")
    suspend fun updatePut(
        @Path("id") id: Int,
        @Body request: CommonRequest
    ): CommonResponse

    /*9.PATCH Request – Partial Update(When you want to update only some fields) one or multiple we can do update(insta-bio)*/
    @PATCH("path/{id}")
    suspend fun updatePartial(
        @Path("id") postId: Int,
        @Body fields: Map<String, Any>
    ): CommonResponse

    /*10.DELETE(Response<Unit> Because backend returns no JSON only status code.)*/
    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") postId: Int): Response<Unit>

    /*11. Sending Custom Header(@Header: Used to add a single, specific HTTP header to a request or response.)*/
    @GET("profile")
    suspend fun fetchData(@Header("Authorization") token: String): CommonResponse

    /*12. Static Headers(@Headers: Used to add multiple HTTP headers at once using an array of key-value pairs.)*/
    @Headers("Content-Type: application/json", "Accept: application/xml")
    @GET("profile")
    suspend fun getDeta(): CommonResponse

    /*13. Multipart – Upload Image / File*/
    @Multipart
    @POST("upload")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("description") desc: RequestBody
    ): CommonResponse

    /*14.Download File (Streaming)*/
    interface ApiService {
        @Streaming
        @GET
        suspend fun downloadFile(@Url fileUrl: String): Response<ResponseBody>
    }
}

data class CommonRequest(
    val email: String,
    val password: String
)

data class CommonResponse(
    val status: String,
    val statusCode: String
)