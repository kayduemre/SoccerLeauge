package com.emrekaydu.soccerleauge.app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//table
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name= "first_name") val firstName: String?,
    @ColumnInfo(name = "last_Name") val lastName: String?
)
