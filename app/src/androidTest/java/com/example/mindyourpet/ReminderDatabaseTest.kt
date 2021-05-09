package com.example.mindyourpet
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


    fun initializeDatabase() {
        //Fake data for the prototype
        val task1 = Reminder(
            petId = 1,
            taskTitle = "Bingo's Lunchtime",
            taskFrequency = 1,
            taskDescription = "Give 2 cups of dog food to Bingo",
            //parameters weren't implemented fully
            reminderTime = 0,
            taskLastCompleted = 0,
            taskLastReminded = 0
        )

        val task2 = Reminder(
            petId = 2,
            taskTitle = "Jeans Medicine",
            taskFrequency = 2,
            taskDescription = "Give Jeans his medicine.",
            //parameters weren't implemented fully
            reminderTime = 0,
            taskLastCompleted = 0,
            taskLastReminded = 0
        )

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
    fun getTaskDescription() = runBlocking {
        Assert.assertEquals(
            "Give 2 cups of dog food to Bingo",
            reminderDao.getTask(1).taskDescription
        )
        Assert.assertEquals("Give Jeans his medicine.", reminderDao.getTask(2).taskDescription)
    }

    @Test
    @Throws(Exception::class)
    fun getTaskTitle() = runBlocking {
        Assert.assertEquals("Bingo's Lunchtime", reminderDao.getTask(1).taskTitle)
        Assert.assertEquals("Jeans Medicine", reminderDao.getTask(2).taskTitle)

    }

    @Test
    @Throws(Exception::class)
    fun getTaskPetId() = runBlocking {
        Assert.assertEquals(2, reminderDao.getTask(2).petId)
        Assert.assertEquals(1, reminderDao.getTask(1).petId)
    }

    @Test
    @Throws(Exception::class)
    fun getTaskFrequency() = runBlocking {
        Assert.assertEquals(2, reminderDao.getTask(2).taskFrequency)
        Assert.assertEquals(1, reminderDao.getTask(1).taskFrequency)
    }

    @Test
    @Throws(Exception::class)
    fun getTaskLastReminder() = runBlocking {
        Assert.assertEquals(0, reminderDao.getTask(2).taskLastReminded)
    }

    @Test
    @Throws(Exception::class)
    fun whenWasTaskLastCompleted() = runBlocking {
        Assert.assertEquals(0, reminderDao.getTask(1).taskLastCompleted)
    }

    //Not finished.
    @Test
    @Throws(Exception::class)
    fun reminderTimeTesting() = runBlocking {
        Assert.assertEquals(0, reminderDao.getTask(1).reminderTime)
    }

    @Test
    @Throws(Exception::class)
    fun getNumOfReminders() = runBlocking {
        Assert.assertEquals(2, reminderDao.getCountOfTasks())
        //testing delete a specific task with taskId
        reminderDao.deleteTask(1)
        Assert.assertEquals(1, reminderDao.getCountOfTasks())

    }

    @Test
    @Throws(Exception::class)
    fun clearAllTasks() = runBlocking {
        Assert.assertEquals(2, reminderDao.getCountOfTasks())
        //testing clearing
        reminderDao.clearAllTasks()
        Assert.assertEquals(0, reminderDao.getCountOfTasks())

    }

    @Test
    @Throws(Exception::class)
    fun getPetIdWithTaskTitle() = runBlocking {
        val temp = reminderDao.getPetIdByTaskTitle("Bingo's Lunchtime")
        Assert.assertEquals(1, temp.petId)
    }

    @Test
    @Throws(Exception::class)
    fun getNumOfRemindersWithSamePetID() = runBlocking {
        val numOfTasks = reminderDao.getTasksByPetID(1)
        Assert.assertEquals(1, numOfTasks.get(0).petId)

    }

}