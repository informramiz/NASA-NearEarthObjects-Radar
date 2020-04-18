package github.informramiz.asteriodradar

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import github.informramiz.asteriodradar.model.database.AsteroidsDatabase
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.database.entities.AsteroidEntity
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ramiz Raja on 18/04/2020
 */
@RunWith(AndroidJUnit4::class)
class AsteroidsDatabaseTests {
    private lateinit var asteroidDao: AsteroidDao
    private lateinit var asteroidsDatabase: AsteroidsDatabase
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().context
        asteroidsDatabase = Room.inMemoryDatabaseBuilder(context, AsteroidsDatabase::class.java)
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
        asteroidDao = asteroidsDatabase.asteroidDao
    }

    @After
    fun closeDb() {
        job.cancel()
        asteroidsDatabase.close()
    }

    @Test
    fun testEntry() = runBlocking {
        val entity = AsteroidEntity(1, "codeName", "12-12-2020",
            0.8, 2.0, 2.0,
            2.0, true, System.currentTimeMillis())
        scope.launch {
            asteroidDao.insert(entity)
            val first = asteroidDao.getAsteroids().first()
            print(first)
            assertEquals(entity, first)
        }
        delay(2000)
        Unit
    }
}