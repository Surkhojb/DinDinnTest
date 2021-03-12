package com.surkhojb.dindinntest.ui.common

sealed class UIResult {
    object Loading: UIResult()
    data class Error(val errorMessage: String): UIResult()
    data class Success<T>(val content: T): UIResult()
}