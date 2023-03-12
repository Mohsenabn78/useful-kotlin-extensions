
// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

fun Date.convertTo(format: String): String? {
    var dateStr: String? = null
    val df = SimpleDateFormat(format)
    try {
        dateStr = df.format(this)
    } catch (ex: Exception) {
        Log.d("date", ex.toString())
    }

    return dateStr
}

// Converts current date to Calendar
fun Date.toCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}

fun Date.isFuture(): Boolean {
    return !Date().before(this)
}

fun Date.isPast(): Boolean {
    return Date().before(this)
}

fun Date.isToday(): Boolean {
    return DateUtils.isToday(this.time)
}

fun Date.isYesterday(): Boolean {
    return DateUtils.isToday(this.time + DateUtils.DAY_IN_MILLIS)
}

fun Date.isTomorrow(): Boolean {
    return DateUtils.isToday(this.time - DateUtils.DAY_IN_MILLIS)
}

fun Date.today(): Date {
    return Date()
}

fun Date.yesterday(): Date {
    val cal = this.toCalendar()
    cal.add(Calendar.DAY_OF_YEAR, -1)
    return cal.time
}

fun Date.tomorrow(): Date {
    val cal = this.toCalendar()
    cal.add(Calendar.DAY_OF_YEAR, 1)
    return cal.time
}

fun Date.hour(): Int {
    return this.toCalendar().get(Calendar.HOUR)
}

fun Date.minute(): Int {
    return this.toCalendar().get(Calendar.MINUTE)
}

fun Date.second(): Int {
    return this.toCalendar().get(Calendar.SECOND)
}

fun Date.month(): Int {
    return this.toCalendar().get(Calendar.MONTH) + 1
}

fun Date.monthName(locale: Locale? = Locale.getDefault()): String {
    return this.toCalendar().getDisplayName(Calendar.MONTH, Calendar.LONG, locale)
}

fun Date.year(): Int {
    return this.toCalendar().get(Calendar.YEAR)
}

fun Date.day(): Int {
    return this.toCalendar().get(Calendar.DAY_OF_MONTH)
}

fun Date.dayOfWeek(): Int {
    return this.toCalendar().get(Calendar.DAY_OF_WEEK)
}

fun Date.dayOfWeekName(locale: Locale? = Locale.getDefault()): String {
    return this.toCalendar().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale)
}

fun Date.dayOfYear(): Int {
    return this.toCalendar().get(Calendar.DAY_OF_YEAR)
}

/**
 * This function calculates the number of years between two LocalDate objects.
 * It uses the ChronoUnit.YEARS enum value to calculate the difference in years between the two dates.
 * If the result is negative, it returns the absolute value of the difference.
 *
 * @param other: The other LocalDate object to calculate the difference from.
 * @return The number of years between the two LocalDate objects as a Long data type.
 */
fun LocalDate.yearsDifference(other: LocalDate): Long {
    return ChronoUnit.YEARS.between(this, other).absoluteValue
}

/**
 * This function calculates the number of months between two LocalDate objects.
 * It uses the ChronoUnit.MONTHS enum value to calculate the difference in months between the two dates.
 * If the result is negative, it returns the absolute value of the difference.
 *
 * @param other: The other LocalDate object to calculate the difference from.
 * @return The number of months between the two LocalDate objects as a Long data type.
 */
fun LocalDate.monthsDifference(other: LocalDate): Long {
    return ChronoUnit.MONTHS.between(this, other).absoluteValue
}

/**
 * This function calculates the number of days between two LocalDate objects.
 * It uses the ChronoUnit.DAYS enum value to calculate the difference in days between the two dates.
 * If the result is negative, it returns the absolute value of the difference.
 *
 * @param  other: The other LocalDate object to calculate the difference from.
 * @return The number of days between the two LocalDate objects as a Long data type.
 */
fun LocalDate.daysDifference(other: LocalDate): Long {
    return ChronoUnit.DAYS.between(this, other).absoluteValue
}

/*
Example:

fun main() {

    val date1 = LocalDate.of(1998, 9, 24)
    val date2 = LocalDate.of(2023, 3, 12)

    println(date1.yearsDifference(date2)) // 24
    println(date1.monthsDifference(date2)) // 293
    println(date1.daysDifference(date2)) // 8935
    
}
 */
