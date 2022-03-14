
// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

/**
 * Check if the Internet connectivity is available
 */
fun Context.isInternetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

/**
 * get color & drawable resources from context
 */
fun Context.getCompatColor(@ColorRes colorId: Int) = ResourcesCompat.getColor(resources, colorId, null)

fun Context.getCompatDrawable(@DrawableRes drawableId: Int) = AppCompatResources.getDrawable(this, drawableId)!!

/**
 * copy a text to clipboard
 */
fun Context.copyToClipboard(content: String) {
    val clipboardManager = ContextCompat.getSystemService(this, ClipboardManager::class.java)!!
    val clip = ClipData.newPlainText("clipboard", content)
    clipboardManager.setPrimaryClip(clip)
}
