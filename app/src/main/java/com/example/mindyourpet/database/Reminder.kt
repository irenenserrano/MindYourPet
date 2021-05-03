package com.example.mindyourpet.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder_table")

data class Reminder(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "pet_id")
    val petId: Long,

    @ColumnInfo(name = "task_title")
    val taskTitle: String,

    @ColumnInfo(name = "task_frequency")
    val taskFrequency: Int,
    //1=daily 2=weekly 3=monthly

    @ColumnInfo(name = "task_description")
    val taskDescription: String,

    @ColumnInfo(name = "reminder_time")
    val reminderTime: Long,
    //minutes after midnight

    @ColumnInfo(name = "task_completed")
    var taskLastCompleted: Int,
    //current time in millis

    @ColumnInfo(name = "last_reminded")
    var taskLastReminded: Long,
    //current time in millis
)