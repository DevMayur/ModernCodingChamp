package com.mayurkakade.moderncodingchamp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.mayurkakade.moderncodingchamp.MainActivity
import com.mayurkakade.moderncodingchamp.R
import com.mayurkakade.moderncodingchamp.api.subjects.SubjectPojo
import com.mayurkakade.moderncodingchamp.api.subtitles.SubtitlePojo
import com.mayurkakade.moderncodingchamp.api.titles.TitlesPojo
import com.mayurkakade.moderncodingchamp.recycler.Type

class MainViewModel : ViewModel() {

    //subjects
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    private lateinit var fragmentManager: FragmentManager


    fun setFragment(fragment: Fragment)
    {
        fragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
        fragmentManager.executePendingTransactions()
    }

    fun popBackStack()
    {
        fragmentManager.popBackStackImmediate()
    }

    fun getFragmentManager(): FragmentManager {
        return fragmentManager
    }


    fun init(mainActivity: Context) {
        context = mainActivity
        fragmentManager = (context as MainActivity).supportFragmentManager
    }


    fun openTitle(titlesPojo: TitlesPojo) {
        setFragment(MainFragment.newInstance(titlesPojo.id.toInt(), Type.SUBTITLE))
    }

    fun openSubject(subjectPojo: SubjectPojo) {
        setFragment(MainFragment.newInstance(subjectPojo.id.toInt(), Type.TITLES))
    }

    fun openSubtitle(subtitlePojo: SubtitlePojo) {
        setFragment(MainFragment.newInstance(subtitlePojo.id.toInt(), Type.CONTENT))
    }


}