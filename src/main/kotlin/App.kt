import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {
    val db = FakDb()
    db.getUsers()
        .map {it.value}
        .subscribe { println(it)}

    db.getUsers()
        .flatMap { user -> db.getPointsForUser(user.key).zipWith(Observable.just(user.value), {points, username -> "$username has $points ponts"}) }
        .subscribe({println(it)})

}