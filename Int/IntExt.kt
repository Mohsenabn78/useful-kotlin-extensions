// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

/**
 * is it even or odd
 */
fun Int.isEven() = this.mode(2) == 0
fun Int.isOdd() = this.mod(2) != 0

/**
 * Reverses the digits of an integer.
 *
 * Example:
 * ```
 * println(1234.reverse()) // 4321
 * ```
 * @return The integer with its digits reversed.
 */
fun Int.reverse(): Int {
    return this.toString().reversed().toInt()
}

/**
 * Checks whether an integer is a perfect square.
 *
 * Example:
 * ```
 * println(16.isSquare()) //   true
 * println(17.isSquare()) //   false
 * ```
 * @return True if the integer is a perfect square, false otherwise.
 */
fun Int.isSquare(): Boolean {
    val sqrt = sqrt(this.toDouble()).toInt()
    return sqrt * sqrt == this
}

/**
 * This function formats an integer by adding commas as thousands separators, making it
 * easier to read and understand large numbers.The formatted output is returned as a string.
 *
 * Example:
 * ```
 * println(1234567.formatWithCommas()) // 1,234,567
 * ```
 * @return A string representation of the integer value with commas added as thousands separators.
 */
fun Int.formatWithCommas(): String {
    return String.format("%,d", this)
}
