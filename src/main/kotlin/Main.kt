var score = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

fun main() {

    val pins = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    val pins2 = listOf(10, 10, 10, 0, 0, 4, 6, 5, 5, 10, 1, 3, 7, 3, 1, 1)
    val pins3 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    val pins4 = listOf(0, 0, 1, 0, 0, 8, 0, 0, 7, 0, 0, 10, 7, 0, 5, 4, 9, 1, 6, 2)
    val pins5=listOf(5,5,6,4,3,7,0,10,2,8,9,1,4,6,7,3,3,7,0,10,10)

    println("Frames:")
    println(series(pins))
    println("Total: ${score.last()}\n")

    clean()

    println("Frames:")
    println(series(pins2))
    println("Total: ${score.last()}\n")

    clean()

    println("Frames:")
    println(series(pins3))
    println("Total: ${score.last()}\n")

    clean()

    println("Frames:")
    println(series(pins4))
    println("Total: ${score.last()}\n")

    clean()

    println("Frames:")
    println(series(pins5))
    println("Total: ${score.last()}\n")

}

fun series(pins: List<Int>): List<Int> {

    var c = 0
    var i = 0
    while (i < pins.size && c < score.size) {

        if (pins[i] == 10) {

            strike(score, pins[i], pins[i + 1], pins[i + 2], c)
            i++

        } else if (pins[i] + pins[i + 1] < 10) {

            open(score, pins[i], pins[i + 1], c)
            if (i + 2 >= pins.size) {
                i++
            } else {
                i += 2
            }

        } else if (pins[i] + pins[i + 1] == 10) {

            spare(score, pins[i], pins[i + 1], pins[i + 2], c)
            if (i + 2 >= pins.size) {
                i++
            } else {
                i += 2
            }

        }
        c++
    }

    return score
}

private fun strike(score: MutableList<Int>, a: Int, b: Int, c: Int, i: Int) {

    score[i] = score[i] + a + b + c
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

private fun open(score: MutableList<Int>, a: Int, b: Int, i: Int) {

    score[i] = score[i] + a + b
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

private fun spare(score: MutableList<Int>, a: Int, b: Int, c: Int, i: Int) {

    score[i] = score[i] + a + b + c
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

fun clean() {

    score = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

}