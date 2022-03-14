
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

/**
 * show alert dialog
 */
fun Context.showAlertDialog(
    positiveButtonLabel: String = getString(R.string.default_str),
    title: String = getString(R.string.defualt_str), message: String,
    actionOnPositiveButton: () -> Unit
) {
    val builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton(positiveButtonLabel) { dialog, id ->
            dialog.cancel()
            actionOnPositiveButton()
        }
    val alert = builder.create()
    alert?.show()
}


/**
 * chack activity lifecycle
 */
fun Context.isActivityFinishing(): Boolean {
    return this is Activity && isFinishing
}

fun Context.isActivityDestroyed(): Boolean {
    return this is Activity && isDestroyed
}

/**
 * browse a url with context
 */
fun Context.browse(url: String, newTask: Boolean = false): Boolean {
    try {
        val intent = intent(ACTION_VIEW) {
            data = Uri.parse(url)
            if (newTask) addFlags(FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        return true
    } catch (e: Exception) {
        return false
    }
}

/**
 * send email with context 
 */
fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    val intent = intent(ACTION_SENDTO) {
        data = Uri.parse("mailto:")
        putExtra(EXTRA_EMAIL, arrayOf(email))
        if (subject.isNotBlank()) putExtra(EXTRA_SUBJECT, subject)
        if (text.isNotBlank()) putExtra(EXTRA_TEXT, text)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }
    return false
}


/**
 * make call with context
 */
fun Context.makeCall(number: String): Boolean {
    try {
        val intent = Intent(ACTION_CALL, Uri.parse("tel:$number"))
        startActivity(intent)
        return true
    } catch (e: Exception) {
        return false
    }
}

/**
 * send sms with context 
 */
fun Context.sendSms(number: String, text: String = ""): Boolean {
    try {
        val intent = intent(ACTION_VIEW, Uri.parse("sms:$number")) {
            putExtra("sms_body", text)
        }
        startActivity(intent)
        return true
    } catch (e: Exception) {
        return false
    }
}


/**
 * make device vibrate by duration
 */
fun Context.vibrate(duration: Long) {
    val vib = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      vib.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
      @Suppress("DEPRECATION")
      vib.vibrate(duration)
    }
  }


  /**
   * get versionCode and versionName
   */
  val Context.versionName: String?
get() = try {
  val pInfo = packageManager.getPackageInfo(packageName, 0);
  pInfo?.versionName
} catch (e: PackageManager.NameNotFoundException) {
  e.printStackTrace()
  null
}

val Context.versionCode: Long?
get() = try {
  val pInfo = packageManager.getPackageInfo(packageName, 0)
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
    pInfo?.longVersionCode
  } else {
    @Suppress("DEPRECATION")
    pInfo?.versionCode?.toLong()
  }
} catch (e: PackageManager.NameNotFoundException) {
  e.printStackTrace()
  null
}