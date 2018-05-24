package sitis.org.climaapp.data.http

import io.reactivex.Single
import retrofit2.http.*


interface ClimaApi{

    @GET("public/yql")
    fun getClima(@Query("q") query:String, @Query("format") format: String, @Query("env") environment: String) : Single<QueryResult>

    @POST("")
    fun addClima(@Header("Authorization") token: String, @Body uploadObject:QueryResult)

}

// Armar el parseo de la API
class Condition(val temperature: String, val text: String)
class Item(val condition: Condition)
class Atmosphere(val humidity: String, val pressure: String)
class Channel(val atmosphere: Atmosphere, val item: Item)
class Result(val channel: Channel)
class QueryResult(val result: Result)