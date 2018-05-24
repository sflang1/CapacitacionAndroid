package sitis.org.sitismvvmexample.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import sitis.org.sitismvvmexample.data.models.Seguro

@Dao
interface SeguroDao{
    @Insert
    fun insert(seguro:Seguro)

    @Update
    fun update(seguro:Seguro)

    @Delete
    fun delete(seguro:Seguro)

    @Query("SELECT * FROM seguro WHERE id = :id")
    fun getById(id:Long):Maybe<Seguro>

    @Query("SELECT * FROM seguro")
    fun getAll(): Single<List<Seguro>>

    @Query("SELECT * FROM seguro")
    fun list(): Flowable<List<Seguro>>
}