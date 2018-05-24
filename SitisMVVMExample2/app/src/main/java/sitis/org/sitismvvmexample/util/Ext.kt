package sitis.org.sitismvvmexample.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity

inline fun <reified T : ViewModel?> AppCompatActivity.getViewModel() : T = ViewModelProviders.of(this).get(T::class.java)
