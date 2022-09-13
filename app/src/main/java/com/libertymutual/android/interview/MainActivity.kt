package com.libertymutual.android.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.libertymutual.android.interview.ui.datelist.DateListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DateListFragment.newInstance())
                    .commitNow()
        }
    }
}