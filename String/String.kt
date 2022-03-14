// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions


fun String.Companion.empty() = ""


/**
 * email validation pattern
 */
fun String.isValidEmail(): Boolean= this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * url validation
 */
fun String.isUrl(): Boolean {
    return URLUtil.isValidUrl(this)
}

/**
 * phone number validation
 */
fun String.isPhoneNumber(): Boolean {
    return android.util.Patterns.PHONE.matcher(this).matches()
}

/**
 * hex to RGB converter
 */
fun String.hextoRGB() : Triple<String, String, String>{
  var name = this
  if (!name.startsWith("#")){
      name = "#$this"
  }
  var color = Color.parseColor(name)
  var red = Color.red(color)
  var green = Color.green(color)
  var blue = Color.blue(color)

  return Triple(red.toString(), green.toString(), blue.toString())
}

/**
 * string to date converter
 */
fun String.toDate(withFormat: String = "yyyy/MM/dd hh:mm"): Date {
    val dateFormat = SimpleDateFormat(withFormat)
    var convertedDate = Date()
    try {
        convertedDate = dateFormat.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return convertedDate
}