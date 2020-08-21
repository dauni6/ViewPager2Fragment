package com.dontsu.viewpager2fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import timber.log.Timber

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    //mutableListOf를 사용할 필요가 없는게 프래그먼트는 A B C D로 고정되어 있기 때문이다.
    var fragmentList = listOf<Fragment>()

    //모든 아이템의 갯수를 리턴함, 여러번 호출 된다.
    override fun getItemCount(): Int {
        Timber.d("---FragmentAdapter : getItemCount()")
       return fragmentList.size
    }

    //해당 포지션의 프래그먼트를 리턴, 각 프래그먼트들은 한 번씩 만들어지고 이후에는 재사용 된다. 아마도 fragment Pool 같은 곳에 들어가는 것 같다.
    override fun createFragment(position: Int): Fragment {
        Timber.d("---FragmentAdapter : createFragment()")
        return fragmentList[position]
    }

}
