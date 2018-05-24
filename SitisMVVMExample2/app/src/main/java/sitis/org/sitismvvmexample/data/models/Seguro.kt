package sitis.org.sitismvvmexample.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity
class Seguro(@PrimaryKey(autoGenerate = true) val id : Long?,
             val aseguradora:String,
             val beneficiario:String,
             val fecha:Date)