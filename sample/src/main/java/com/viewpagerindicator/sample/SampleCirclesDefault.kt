package com.viewpagerindicator.sample

import android.os.Bundle
import com.viewpagerindicator.CirclePageIndicator

/**
 * Created by Jan Tiedemann on 18.12.18.
 */
class SampleCirclesDefault : BaseSampleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple_circles)

        sampleFragmentAdapter = SampleFragmentAdapter(supportFragmentManager)

        viewPager = findViewById(R.id.pager)
        viewPager.adapter = sampleFragmentAdapter

        indicator = findViewById<CirclePageIndicator>(R.id.indicator)
        indicator.setViewPager(viewPager)
    }
}