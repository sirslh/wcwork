package com.liuhao.wcwork.common

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager


inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) =
        activity?.let {
            Internals.internalStartActivity(it, T::class.java, params)
        }

inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
    Internals.internalStartActivity(this, T::class.java, params)

inline fun <reified T : Activity> Activity.startActivity(vararg params: Pair<String, Any?>) =
    Internals.internalStartActivity(this, T::class.java, params)

inline fun <reified T : Activity> Fragment.startActivityForRes(requestCode: Int, vararg params: Pair<String, Any?>) =
        activity?.let {
            startActivityForResult(Internals.createIntent(it, T::class.java, params), requestCode)
        }

inline fun <reified T : Activity> Activity.startActivityForRes(requestCode: Int, vararg params: Pair<String, Any?>) =
        startActivityForResult(Internals.createIntent(this, T::class.java, params), requestCode)

fun Context.getDrawableByAttr(@AttrRes attr: Int): Drawable? {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val drawable = ta.getDrawable(0)
    ta.recycle()
    return drawable
}

fun Context.getThemeByAttr(@AttrRes attr: Int): Int {
    val ta = obtainStyledAttributes(intArrayOf(attr))
    val theme = ta.getResourceId(0, 0)
    ta.recycle()
    return theme
}



fun Context.getString(@StringRes id: Int): String = getString(id)

fun Fragment.inflate(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(id, root, attachToRoot)

fun Activity.inflate(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View = LayoutInflater.from(this).inflate(id, root, attachToRoot)

fun View.inflate(@LayoutRes id: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View = LayoutInflater.from(this.context).inflate(id, root, attachToRoot)

fun Fragment.horizontalLinearLayoutManager() = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
fun Fragment.verticalLinearLayoutManager() = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
fun Fragment.gridLayoutManager(spanCount: Int) = GridLayoutManager(context, spanCount)
fun Fragment.verticalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.VERTICAL)
fun Fragment.horizontalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.HORIZONTAL)


fun Activity.horizontalLinearLayoutManager() = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
fun Activity.verticalLinearLayoutManager() = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
fun Activity.gridLayoutManager(spanCount: Int) = GridLayoutManager(this, spanCount)
fun Activity.verticalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.VERTICAL)
fun Activity.horizontalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.HORIZONTAL)


fun Context.horizontalLinearLayoutManager() = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
fun Context.verticalLinearLayoutManager() = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
fun Context.gridLayoutManager(spanCount: Int) = GridLayoutManager(this, spanCount)
fun Context.verticalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.VERTICAL)
fun Context.horizontalStaggeredManager(spanCount: Int) = StaggeredGridLayoutManager(spanCount,LinearLayoutManager.HORIZONTAL)


fun View.findColor(@ColorRes corRes: Int): Int = ContextCompat.getColor(context, corRes)
fun Fragment.findColor(@ColorRes corRes: Int): Int = ContextCompat.getColor(context!!, corRes)
fun Context.findColor(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)
fun Activity.findColor(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

