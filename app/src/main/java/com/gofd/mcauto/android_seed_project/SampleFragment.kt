package com.gofd.mcauto.android_seed_project


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import kotlinx.android.synthetic.main.fragment_sample.*
import kotlinx.android.synthetic.main.fragment_sample.view.*
import kotlinx.android.synthetic.main.toolbar.view.*

class SampleFragment : Fragment(){
    fun newInstance(): SampleFragment {
        return SampleFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_sample, container, false)
        if(Build.VERSION.SDK_INT >=21)
            activity.window.statusBarColor = Color.BLACK
        view.toolbar.title.text="hi"
        activity.setActionBar(toolbar as Toolbar?)
        return view
    }
}