//package com.example.mindyourpet
//
//import androidx.room.Room
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.platform.app.InstrumentationRegistry
//import com.example.mindyourpet.database.PetDatabase
//import com.example.mindyourpet.database.ReminderDatabaseDao
//import junit.framework.Assert.assertNull
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert.assertEquals
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import java.io.IOException
//
//
//@RunWith(AndroidJUnit4::class)
//class ReminderDatabaseTest {
//
//    private lateinit var ReminderDao: ReminderDatabaseDao
//    private lateinit var db: PetDatabase
//
//    @Before
//    fun createDb() {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//        // Using an in-memory database because the information stored here disappears when the
//        // process is killed.
//        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
//            // Allowing main thread queries, just for testing.
//            .allowMainThreadQueries()
//            .build()
//        sleepDao = db.ReminderDatabaseDao
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun insertAndGetNight() = runBlocking {
//        val night = SleepNight()
//        sleepDao.insert(night)
//        val tonight = sleepDao.getTonight()
//        assertEquals(-1, tonight?.sleepQuality)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun getBestQualityFromEmptyDB() = runBlocking {
//        assertNull(sleepDao.getBestQuality())
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun getBestQualityAndGetNumNightsWithQuality() = runBlocking {
//        sleepDao.insert(SleepNight(sleepQuality = 1))
//        sleepDao.insert(SleepNight(sleepQuality = 4))
//        sleepDao.insert(SleepNight(sleepQuality = 4))
//        assertEquals(4, sleepDao.getBestQuality())
//        assertEquals(1, sleepDao.getNumNightsWithQuality(1))
//        assertEquals(0, sleepDao.getNumNightsWithQuality(2))
//        assertEquals(2, sleepDao.getNumNightsWithQuality(4))
//        assertEquals(2, sleepDao.getNumNightsWithBestQuality())
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun methodsWithSingleRecord() = runBlocking {
//        val originalSleepQuality = 2
//        val updatedSleepQuality = 5
//
//        // Test that we can insert and retrieve a SleepNight.
//        sleepDao.insert(SleepNight(sleepQuality = originalSleepQuality))
//        val tonight = assertNotNull(sleepDao.getTonight())
//        assertEquals(originalSleepQuality, tonight.sleepQuality)
//        val selectedNight = assertNotNull(sleepDao.get(tonight.nightId))
//
//        // Test that we can update a SleepNight.
//        selectedNight.sleepQuality = updatedSleepQuality
//        sleepDao.update(selectedNight)
//        assertEquals(updatedSleepQuality, selectedNight.sleepQuality)
//
//        // Test that clear() deletes our SleepNight.
//        sleepDao.clear()
//        assertNull(sleepDao.get(tonight.nightId))
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun deleteANightById() = runBlocking {
//        val id1 = sleepDao.insert(SleepNight(sleepQuality = 4))
//        val id2 = sleepDao.insert(SleepNight(sleepQuality = 3))
//        sleepDao.deleteANightById(id1)
//        assertNull(sleepDao.get(id1))
//        assertEquals(3, sleepDao.get(id2)?.sleepQuality)
//    }
