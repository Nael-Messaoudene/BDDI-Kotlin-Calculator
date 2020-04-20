fun String.sayHello():String {


    val retour = "$this-Hello World"
    return retour
}
val part1 = "Bonjour"


println(part1.sayHello())

data class Etudiant(val first: String, val last: String)

val etudiant = Etudiant("Naël", "Messaoudene")

fun Etudiant.fullName(){
    println("${etudiant.first} ${etudiant.last}")
}

println(etudiant.fullName())


fun Etudiant.switch() = copy(first = last , last = first)

println(etudiant.switch())

fun List<Etudiant>.switch() = forEach{ it.switch() }