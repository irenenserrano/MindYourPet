package com.example.mindyourpet
//./gradlew assembleDebug --stacktrace
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.mindyourpet.database.PetDatabase
import com.example.mindyourpet.database.Reminder
import com.example.mindyourpet.database.ReminderDatabaseDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class ReminderDatabaseTest {

    private lateinit var reminderDao: ReminderDatabaseDao
    private lateinit var db: PetDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, PetDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        reminderDao = db.ReminderDatabaseDao

        initializeDatabase()
    }

    fun initializeDatabase(){
        val task1 = Reminder(petId=0,
                            taskTitle ="Bingo's Lunchtime",
                            taskFrequency=0,
                            taskDescription = "Give 2 cups of dog food to Bingo",
                            reminderTime= 0,
                            taskLastCompleted= 0,
                            taskLastReminded = 0  )

        val task2 = Reminder(
            petId=0,
            taskTitle =" ",
            taskFrequency=0,
            taskDescription = " ",
            reminderTime= 0,
            taskLastCompleted= 0,
            taskLastReminded = 0  )

        runBlocking {
            reminderDao.addTask(task1)
            reminderDao.addTask(task2)

        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun addTaskToTheDao() = runBlocking {
        Assert.assertEquals("Give 2 cups of dog food to Bingo", reminderDao.getTask(1).taskDescription)
        Assert.assertEquals(" ", reminderDao.getTask(2).taskDescription)

    }

    //@Test
//    @Throws(Exception::class)
//    fun () = runBlocking {
//        Assert.assertEquals("Bingo's Lunchtime", reminderDao.getTask(1).taskTitle)
//    }

}