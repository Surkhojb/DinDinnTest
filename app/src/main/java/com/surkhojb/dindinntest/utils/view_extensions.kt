package com.surkhojb.dindinntest.utils

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.surkhojb.dindinntest.R

fun ViewGroup.inflate(layout: Int): View {
    return LayoutInflater.from(this.context).inflate(layout,this,false)
}

fun ImageView.loadImage(imageResource: Int) =
    Glide.with(this).load(imageResource).into(this)

fun ImageView.loadUrl(imageUrl: String) =
    Glide.with(this).load(imageUrl).into(this)

fun View.visible(indicator: Boolean){
    this.visibility = if(indicator) View.VISIBLE else View.GONE
}

fun Activity.showError(targetView: View,messageResource: Int) {
    createSnackBar(targetView,messageResource).show()
}

fun Activity.showError(targetView: View,errorMessage: String) {
    createSnackBar(targetView,errorMessage).show()
}

fun Activity.showErrorWithAction(targetView: View, messageResource: Int,
                                 actionResource: Int,
                                 action: () -> Unit?){
    createSnackBar(targetView,messageResource).apply {
        this.setActionTextColor(Color.WHITE)
        this.setAction(context.getString(actionResource)){action()}
    }.show()
}

fun Activity.showSuccessWithAction(targetView: View,messageResource: Int,
                                   actionResource: Int,
                                   action: () -> Unit?){
    createSnackBar(targetView,messageResource, R.color.successColorBackground).apply {
        this.setActionTextColor(Color.WHITE)
        this.setAction(context.getString(actionResource)){action()}
    }.show()
}

private fun createSnackBar(targetView: View, messageResource: Int, color: Int = R.color.errorColorBackground): Snackbar {
    return Snackbar.make(targetView,
        targetView.context.getString(messageResource),
        Snackbar.LENGTH_INDEFINITE)
        .apply {
            this.view.setBackgroundColor(
                ContextCompat.getColor(context,color))
        }
}

private fun createSnackBar(targetView: View, errorMessage: String, color: Int = R.color.errorColorBackground): Snackbar {
    return Snackbar.make(targetView,
        errorMessage,
        Snackbar.LENGTH_INDEFINITE)
        .apply {
            this.view.setBackgroundColor(
                ContextCompat.getColor(context,color))
        }
}