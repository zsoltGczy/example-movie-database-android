package com.gzslt.examplemoviedatabase.main.ui

import androidx.fragment.app.Fragment
import com.gzslt.examplemoviedatabase.main.MainActivity

abstract class BaseFragment : Fragment() {

    protected fun getMainActivity() = activity as MainActivity
}
