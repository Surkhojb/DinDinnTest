package com.surkhojb.dindinntest.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlin.reflect.KClass

fun Activity.navigateTo(destination: KClass<*>, withExtras: Bundle? = null){
    val intent = Intent(this,destination.java)
    withExtras?.apply {
        intent.putExtras(this)
    }

    startActivity(intent)
}