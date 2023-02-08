
// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

/**
 * Visibility modifiers and check functions
 */
fun View.isVisibile(): Boolean = visibility == View.VISIBLE

fun View.isGone(): Boolean = visibility == View.GONE

fun View.isInvisible(): Boolean = visibility == View.INVISIBLE

fun View.makeVisible() { visibility = View.VISIBLE }

fun View.makeGone() { visibility = View.GONE }

fun View.makeInvisible() { visibility = View.INVISIBLE }

inline fun View.visiableIf(block: () -> Boolean) {
    if (visibility != View.VISIBLE && block()) {
        visibility = View.VISIBLE
    }
}

inline fun View.invisiableIf(block: () -> Boolean) {
    if (visibility != View.INVISIBLE && block()) {
        visibility = View.INVISIBLE
    }
}

/**
 * text view tools
 */
fun TextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.deleteLine() {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.bold(isBold: Boolean = true) {
    paint.isFakeBoldText = isBold
    paint.isAntiAlias = true
}


/**
 * get string from view
 */
fun View.getString(@StringRes resId: Int): String = resources.getString(resId)

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

/**
 * inflate a layout
 */
fun ViewGroups.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)


/**
 * binding layout with dataBinding
 */
fun <T : ViewDataBinding> ViewGroup.bind(layoutId: Int): T {
    return DataBindingUtil.inflate(getLayoutInflater(), layoutId, this, true)
}


/**
 * Loads URL into an ImageView using Glide
 *
 * @param url URL to be loaded
 */
fun ImageView.loadFromUrlByGlide(url: String) {
    Glide.with(this.context.applicationContext)
    .load(url)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(this)
}


/**
 * Loads URL into an ImageView using Picasso
 *
 * @param url URL to be loaded
 */
fun ImageView.loadFromUrlByPicasso(url: String) {
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


/**
 * start activity by intent
 */
inline fun <reified T : Activity> Activity.startActivity() {
    val intent = Intent()
    intent.setClass(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.startActivity(options: Bundle?) {
    val intent = Intent()
    intent.setClass(this, T::class.java)
    startActivity(intent, options)
}


/**
 * set and clear margin on a view
 */
fun View.setMargins(
    leftMarginDp: Int? = null,
    topMarginDp: Int? = null,
    rightMarginDp: Int? = null,
    bottomMarginDp: Int? = null
) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val params = layoutParams as ViewGroup.MarginLayoutParams
        leftMarginDp?.run { params.leftMargin = this.dp }
        topMarginDp?.run { params.topMargin = this.dp }
        rightMarginDp?.run { params.rightMargin = this.dp }
        bottomMarginDp?.run { params.bottomMargin = this.dp }
        requestLayout()
    }
}

fun View.clearMargins() {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val params = layoutParams as ViewGroup.MarginLayoutParams
        params.leftMargin = 0.dp
        params.topMargin = 0.dp
         params.rightMargin = 0.dp
         params.bottomMargin = 0.dp
        requestLayout()
    }
}


/**
 * make a screenshots!!
 */
 fun View.takeScreenshot(): Bitmap {
    val bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    val bgDrawable = this.background
    if (bgDrawable != null) {
        bgDrawable.draw(canvas)
    } else {
        canvas.drawColor(Color.WHITE)
    }
    this.draw(canvas)
    return bitmap
}
 

/**
 * add custom divider to recycler view
 */
 fun RecyclerView.setDivider(
    @DrawableRes drawableRes: Int,
    orientation: Int = DividerItemDecoration.VERTICAL
) {
    val divider = DividerItemDecoration(
        this.context,
        orientation
    )
    val drawable = ContextCompat.getDrawable(
        this.context,
        drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}
 
