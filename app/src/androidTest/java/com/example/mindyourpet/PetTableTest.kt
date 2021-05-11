package com.example.mindyourpet

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.mindyourpet.database.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws


@RunWith(AndroidJUnit4::class)
class PetTableTest {

    private lateinit var petDao: PetDatabaseDao
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
        petDao = db.PetDatabaseDao

        initializeDatabase()
    }

    fun initializeDatabase(){

        val p = Pet(petId = 0, name = "Bingo", speciesId = CAT_ID)
        val p1 = Pet(petId = 1, name = "Jeans", speciesId = DOG_ID)
        val p2 = Pet(petId = 2, name = "Kim", speciesId = FISH_ID)
        val p3 = Pet(petId = 3, name = "Bob", speciesId = MONKEY_ID)
        val p4 = Pet(petId = 4, name = "Burro", speciesId = BIRD_ID)
        val p5 = Pet(petId = 5, name ="Elvert", speciesId =  CAT_ID)

        runBlocking {
            petDao.addPet(p)
            petDao.addPet(p1)
            petDao.addPet(p2)
            petDao.addPet(p3)
            petDao.addPet(p4)
            petDao.addPet(p5)
        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    //this method is to get info with petId
    //it will return name and speciesId
    @Test
    @Throws(Exception::class)
    fun getName() = runBlocking {
        val newPet = petDao.getName(1)
        assertEquals("Bingo", newPet.name)
        assertEquals(0, newPet.speciesId)
        val newPet1 = petDao.getName(2)
        assertEquals("Jeans", newPet1.name)
        assertEquals(1, newPet1.speciesId)
    }

    //For Species Id: 0 == cat 1 == dog 2 == bird 3 == Monkey 4 == fish
    @Test
    @Throws(Exception::class)
    fun getAllSameSpeciesName() = runBlocking {

        var allCats = petDao.getAllSpeciesId(CAT_ID)
        assertEquals(2, allCats.size)
        assertEquals("Bingo", allCats.get(0).name)
        assertEquals("Elvert", allCats.get(1).name)
    }

    //test returns petid with given name as
    @Test
    @Throws(Exception::class)
    fun getPetIdWithName() = runBlocking {
        val petNameReturn = petDao.getPetId("Bingo")
        assertEquals(1, petNameReturn.petId)
    }

    @Test
    @Throws(Exception::class)
    fun getAllPets() = runBlocking {
        val allPets = petDao.getAllPets()
        assertEquals(6, allPets.size)
        assertEquals("Bingo", allPets.get(0).name)
        assertEquals("Jeans", allPets.get(1).name)
        assertEquals("Kim", allPets.get(2).name)
        assertEquals("Bob", allPets.get(3).name)
        assertEquals("Burro", allPets.get(4).name)
        assertEquals("Elvert", allPets.get(5).name)
    }

}