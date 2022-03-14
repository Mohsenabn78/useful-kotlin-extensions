/**
 * usage: Visibility modifiers and check functions
 *
 * -fun View.isVisibile
 * -fun View.isGone
 * -fun View.isInvisible
 * -fun View.makeVisible
 * -fun View.makeGone
 * -fun View.makeInvisible
 *
 */
imageView.isVisible() // Returns true if the Button is visible
imageView.isGone() // Returns true if the Button is gone
imageView.isInvisible() // Returns true if the Button is invisible
imageView.makeVisible() // Sets the button's visibility to visible
imageView.makeGone() // Sets the button's visibility to gone
imageView.makeInvisible() // Sets the button's visibility to invisible


/**
 * usage: Button enabling/disabling modifiers
 *
 * -fun Button.disableButton
 * -fun Button.enableButton
 *
 */
loginButton.disableButton()
loginButton.enableButton()


/**
 * usage: Loads URL into an ImageView using Glide and picasso
 *
 * -fun ImageView.loadFromUrl (Glide)
 * -fun ImageView.loadFromUrl (picasso)
 *
 */

 userProfileView.loadFromUrl("image_url", context)  //Glide
 userProfileView.loadFromUrl("image_url")  //picasso


 /**
 * usage: Hides the soft input keyboard from the screen
 *
 * -fun View.hideKeyboard
 */

 submitButton.setOnClickListener { it.hideKeyboard(context) }


 /**
 * usage: Shows the Snackbar inside an Activity or Fragment
 * 
 * -fun View.showSnackbar
 *
 */

 rootLayout.showSnackbar(R.string.my_string) {}
 constraintLayout.showSnackbar(R.string.my_string, Snackbar.LENGTH_SHORT) {}


 /**
 * usage: Adds action to the Snackbar
 * 
 * -fun Snackbar.action
 *
 */

 constraintLayout.showSnackbar(R.string.my_string) {
            action(R.string.open) { Log.e("TAG", "Action item clicked") }
        }


/**
 * usage: Adds TextWatcher to the EditText
 *
 * -fun EditText.onTextChanged
 *
 */
 editTextPhone.onTextChanged { s ->
            Log.e("TAG", "phone length: ${s.length}")
        }