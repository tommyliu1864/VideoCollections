package com.dongnaoedu.videocollections.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.ui.common.ui.BaseViewPagerFragment
import com.dongnaoedu.videocollections.ui.community.follow.FollowFragment
import com.dongnaoedu.videocollections.ui.community.recommend.RecommendFragment
import com.dongnaoedu.videocollections.util.GlobalUtil

class CommunityFragment : BaseViewPagerFragment() {


    override val createTitles = ArrayList<String>().apply {
        add(GlobalUtil.getString(R.string.recommend))
        add(GlobalUtil.getString(R.string.follow))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        RecommendFragment.newInstance(),
        FollowFragment.newInstance()
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_main_container, container, false))
    }

}