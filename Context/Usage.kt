/**
 * usage: Check if the Internet connectivity is available
 *
 * -fun Context.isInternetAvailable
 *
 */
 if (isInternetAvailable()) { }


 /**
 * usage: get color & drawable resources from context
 *
 * -fun Context.getCompatColor
 * -fun Context.getCompatDrawable
 *
 */
getCompatColor(R.color.white) // Activity

requireContext().getCompatColor(R.color.white) // Fragment


/**
 * usage copy a text to clipboard
 *
 * -fun Context.copyToClipboard
 *
 */
 requireContext().copyToClipboard("my text")
 