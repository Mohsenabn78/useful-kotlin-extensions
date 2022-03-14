
// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

val Int.DP
get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    toFloat(),
    Resources.getSystem().displayMetrics
).toInt()

val Float.DP
get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    Resources.getSystem().displayMetrics
)

val Int.SP
get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    toFloat(),
    Resources.getSystem().displayMetrics
)

val Float.SP
get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    this,
    Resources.getSystem().displayMetrics
)