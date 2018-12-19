package com.viewpagerindicator.sample

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.viewpagerindicator.PageIndicator
import java.util.*

/**
 * Created by Jan Tiedemann on 18.12.18.
 */
abstract class BaseSampleActivity : FragmentActivity() {

    protected lateinit var sampleFragmentAdapter: SampleFragmentAdapter
    protected lateinit var viewPager: ViewPager
    protected lateinit var indicator: PageIndicator

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.random -> {
                val page = RANDOM.nextInt(sampleFragmentAdapter.count)
                Toast.makeText(this, "Changing to page $page", Toast.LENGTH_SHORT)
                viewPager.currentItem = page
                true
            }

            R.id.add_page -> {
                if (sampleFragmentAdapter.count < 10) {
                    sampleFragmentAdapter.count += 1
                    indicator.notifyDataSetChanged()
                }
                true
            }

            R.id.remove_page -> {
                if (sampleFragmentAdapter.count > 1) {
                    sampleFragmentAdapter.count -= 1
                    indicator.notifyDataSetChanged()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    companion object {
        private val RANDOM = Random()
    }
}