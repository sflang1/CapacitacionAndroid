package sitis.org.eventosapp.Models

import java.util.*

data class Event(val nombre: String,
                 val description: String,
                 val imageUrl: String,
                 val date: Date,
                 val place: String,
                 val phone: String) {

}