// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

/**
 * is it even or odd
 */
fun Int.isEven() = this.mode(2) == 0
fun Int.isOdd() = this.mod(2) != 0