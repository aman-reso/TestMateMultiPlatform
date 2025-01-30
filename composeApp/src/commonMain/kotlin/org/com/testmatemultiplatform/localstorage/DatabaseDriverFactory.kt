package org.com.testmatemultiplatform.localstorage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.sqldelight.Query
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import org.com.testmatemultiplatform.TestMateDb
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmOverloads
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

class DatabaseHelper(driverFactory: DatabaseDriverFactory) {
    private val driver = driverFactory.createDriver()
    val database = TestMateDb(driver)
}

class PostRepository(private val db: TestMateDb) {
    private val queries = db.testMateDbQueries

    fun observePosts(): Flow<List<Post>> {
        return queries.getAllPosts { id, name, timestamp ->
            Post(
                id = id,
                title = name,
                content = timestamp
            )
        }.asFlow().mapToList(Dispatchers.IO)

    }

    suspend fun insertPost(post: Post) {
        withContext(Dispatchers.Default) {
            db.testMateDbQueries.transaction {
                db.testMateDbQueries.insertPost(post.title, post.content)
            }
        }
    }
}

class PostViewModel(private val repository: PostRepository?) : ViewModel() {
    val posts: StateFlow<List<Post>> = repository?.observePosts()?.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    ) ?: MutableStateFlow(emptyList())

    fun addPost(post: Post) {
        viewModelScope.launch {
            repository?.insertPost(post)
        }
    }
}


data class Post(
    val id: Long = 0,
    val title: String,
    val content: String
)

fun <T : Any> Query<T>.asFlow(): Flow<Query<T>> = flow {
    val channel = Channel<Unit>(CONFLATED)
    channel.trySend(Unit)

    val listener = Query.Listener { channel.trySend(Unit) }

    addListener(listener)
    try {
        for (item in channel) {
            emit(this@asFlow)
        }
    } finally {
        removeListener(listener)
    }
}

@JvmOverloads
fun <T : Any> Flow<Query<T>>.mapToOne(
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = map {
    withContext(context) {
        it.executeAsOne()
    }
}

@JvmOverloads
fun <T : Any> Flow<Query<T>>.mapToOneOrDefault(
    defaultValue: T,
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = map {
    withContext(context) {
        it.executeAsOneOrNull() ?: defaultValue
    }
}

@JvmOverloads
fun <T : Any> Flow<Query<T>>.mapToOneOrNull(
    context: CoroutineContext = Dispatchers.Default
): Flow<T?> = map {
    withContext(context) {
        it.executeAsOneOrNull()
    }
}

@JvmOverloads
fun <T : Any> Flow<Query<T>>.mapToOneNotNull(
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = mapNotNull {
    withContext(context) {
        it.executeAsOneOrNull()
    }
}

@JvmOverloads
fun <T : Any> Flow<Query<T>>.mapToList(
    context: CoroutineContext = Dispatchers.Default
): Flow<List<T>> = map {
    withContext(context) {
        it.executeAsList()
    }
}