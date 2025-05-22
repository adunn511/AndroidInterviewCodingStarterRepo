package com.libertymutual.android.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.libertymutual.android.interview.ui.datelist.DateListFragment
import com.libertymutual.android.interview.ui.datelist.composables.DateListComposeFragment

class MainActivity : AppCompatActivity() {

    private val useCompose = true
    private val fragmentToLoad = if (useCompose) DateListComposeFragment.newInstance() else DateListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragmentToLoad)
                    .commitNow()
        }
    }
}