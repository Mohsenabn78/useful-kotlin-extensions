


/**
 * Visibility modifiers and check functions
 */
fun View.isVisibile(): Boolean = visibility == View.VISIBLE

fun View.isGone(): Boolean = visibility == View.GONE

fun View.isInvisible(): Boolean = visibility == View.INVISIBLE

fun View.makeVisible() { visibility = View.VISIBLE }

fun View.makeGone() { visibility = View.GONE }

fun View.makeInvisible() { visibility = View.INVISIBLE }


/**
 * Button enabling/disabling modifiers
 */
fun Button.disableButton() {
    isEnabled = false
    alpha = 0.7f
}

fun Button.enableButton() {
    isEnabled = true
    alpha = 1.0f
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)


/**
 * Loads URL into an ImageView using Glide
 *
 * @param url URL to be loaded
 */
fun ImageView.loadFromUrl(url: String, context: Context) {
    Glide.with(context).load(url).into(this)
}


/**
 * Loads URL into an ImageView using Picasso
 *
 * @param url URL to be loaded
 */
fun ImageView.loadFromUrl(url: String) {
    Picasso.get().load(url).into(this)
}


/**
 * Hides the soft input keyboard from the screen
 */
fun View.hideKeyboard(context: Context?) {
    val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}


/**
 * Shows the Snackbar inside an Activity or Fragment
 * 
 * @param messageRes Text to be shown inside the Snackbar
 * @param length Duration of the Snackbar
 * @param f Action of the Snackbar
 */
fun View.showSnackbar(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
     val snackBar = Snackbar.make(this, resources.getString(messageRes), length)
     snackBar.f()
     snackBar.show()
}


/**
 * Adds action to the Snackbar
 * 
 * @param actionRes Action text to be shown inside the Snackbar
 * @param color Color of the action text
 * @param listener Onclick listener for the action
 */
fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    setAction(actionRes, listener)
    color?.let { setActionTextColor(color) }
}


/**
 * Adds TextWatcher to the EditText
 */
fun EditText.onTextChanged(listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

