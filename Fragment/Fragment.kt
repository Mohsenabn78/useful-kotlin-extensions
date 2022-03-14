
// for see more extensions check https://github.com/Mohsenabn78/useful-kotlin-extensions

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
        beginTransaction().func().commit()


inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}


inline fun Fragment.supplyContext(block: Activity.() -> Unit) {
    activity?.run { block(this) }
}


fun Fragment.finish() {
    supplyContext { finish() }
}

/**
 *  Fragment related
 * 
 * val firstName by getValue<String>("firstName") // String?
 * val lastName by getValueNonNull<String>("lastName") // String
 */
inline fun <reified T: Any> Fragment.getValue(lable: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(lable)
    if (value is T) value else defaultvalue
}

inline fun <reified T: Any> Fragment.getValueNonNull(lable: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(lable)
    requireNotNull(if (value is T) value else defaultvalue) { lable }
}