package com.dontsu.viewpager2fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dontsu.viewpager2fragment.fragments.FragmentA
import com.dontsu.viewpager2fragment.fragments.FragmentB
import com.dontsu.viewpager2fragment.fragments.FragmentC
import com.dontsu.viewpager2fragment.fragments.FragmentD
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    init {
        //Timber initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        adapter.fragmentList = fragmentList
        viewPager2.adapter = adapter

        val tabTitles = listOf<String>("A" , "B", "C", "D")
        //TabLayoutMediator 는 ViewPager2와 연결 시키기 위한 클래스 이다.
        //정확하게 얘기하면 ViewPager2의 position과 연결 된다.
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }

}
