package com.mayurkakade.moderncodingchamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mayurkakade.moderncodingchamp.recycler.Type
import com.mayurkakade.moderncodingchamp.ui.main.MainFragment
import com.mayurkakade.moderncodingchamp.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.init(this);

        if (savedInstanceState == null) {
            mainViewModel.setFragment(MainFragment.newInstance(0, Type.SUBJECTS))
        }
    }

    override fun onBackPressed()
    {
        if (mainViewModel.getFragmentManager().backStackEntryCount > 0) {
            mainViewModel.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    public fun getViewModel(): MainViewModel {
        return mainViewModel
    }

}