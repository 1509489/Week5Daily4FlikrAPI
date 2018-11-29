package com.pixelart.week5daily4flikrapi.remotes

import com.pixelart.week5daily4flikrapi.models.FlikrData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService{
    @GET("services/feeds/photos_public.gne")
    fun getFlikrData(
        @Query("tag") tag: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: Int
    ): Single<FlikrData>
}