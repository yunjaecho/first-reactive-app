
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.toFlowable

class FakDb: Db {
    override fun getUserById(id: Int): Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPointsForUserId(id: Int): Single<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addUser(user: User): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val userMap = mutableMapOf(
        1 to User(1, "Peter"), 2 to User(2, "Laura"), 3 to User(
            3,
            "John"
        ), 4 to User(4, "Carl")
    )
    val userPointsMap = mutableMapOf(1 to 40, 2 to 23, 3 to 0, 4 to 5)

    override fun getAllUser() = userMap.values.toFlowable()

    fun getUsers(): Observable<Map.Entry<Int, String>> {
        return Observable.fromIterable(mapOf<Int, String>(1 to "Peter", 2 to "Laura", 3 to "John", 4 to "Carl").entries)
    }

    fun getPointsForUser(userId: Int): Observable<Int> {
        val pointMap = mapOf(1 to 40, 2 to 23, 3 to 0 , 4 to 5)
        return Observable.just(pointMap[userId])
    }
}

interface Db {
    fun getAllUser(): Flowable<User>
    fun getUserById(id: Int): Single<User> // Single
    fun getPointsForUserId(id: Int): Single<Int>
    fun addUser(user: User): Completable
}

data class User(val id: Int, val name: String)
class UserNotFound(message: String?) : Exception(message)