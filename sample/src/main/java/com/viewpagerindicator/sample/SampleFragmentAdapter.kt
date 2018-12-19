package com.viewpagerindicator.sample

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.viewpagerindicator.IconPagerAdapter

/**
 * Created by Jan Tiedemann on 18.12.18.
 */
class SampleFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm), IconPagerAdapter {

    private var mCount = CONTENT.size

    override fun getItem(position: Int) = TestFragment.newInstance(CONTENT[position % CONTENT.size])

    override fun getCount() = mCount

    override fun getPageTitle(position: Int) = CONTENT[position % CONTENT.size]

    override fun getIconResId(index: Int) = ICONS[index % ICONS.size]

    fun setCount(count: Int) {
        if (count in 1..10) {
            mCount = count
            notifyDataSetChanged()
        }
    }

    companion object {
        protected val CONTENT = arrayOf("This", "Is", "A", "Test")
        protected val ICONS = intArrayOf(
            R.drawable.perm_group_calendar,
            R.drawable.perm_group_camera,
            R.drawable.perm_group_device_alarms,
            R.drawable.perm_group_location
        )
    }
}