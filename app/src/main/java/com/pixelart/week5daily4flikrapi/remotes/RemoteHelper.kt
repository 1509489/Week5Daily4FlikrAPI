package com.pixelart.week5daily4flikrapi.remotes

import com.pixelart.week5daily4flikrapi.BASE_URL
import com.pixelart.week5daily4flikrapi.NO_JSON_CALLBACK
import com.pixelart.week5daily4flikrapi.QUERY_FORMAT
import com.pixelart.week5daily4flikrapi.QUERY_TAG
import com.pixelart.week5daily4flikrapi.models.FlikrData
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RemoteHelper {

    fun getFlikrData(): Single<FlikrData>{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RemoteService::class.java)

        return service.getFlikrData(QUERY_TAG, QUERY_FORMAT, NO_JSON_CALLBACK)
    }
}