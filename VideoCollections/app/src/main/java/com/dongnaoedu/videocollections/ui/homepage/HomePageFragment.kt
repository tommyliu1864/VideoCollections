package com.dongnaoedu.videocollections.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.databinding.FragmentHomePageBinding
import com.dongnaoedu.videocollections.ui.common.ui.BaseViewPagerFragment
import com.dongnaoedu.videocollections.ui.homepage.recommend.RecommendFragment
import com.dongnaoedu.videocollections.ui.homepage.daily.DailyFragment
import com.dongnaoedu.videocollections.ui.homepage.discovery.DiscoveryFragment
import com.dongnaoedu.videocollections.ui.search.SearchActivity
import com.dongnaoedu.videocollections.util.GlobalUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : BaseViewPagerFragment() {

    private lateinit var binding: FragmentHomePageBinding
    private lateinit var ivSearch: ImageView

    override val createTitles = ArrayList<String>().apply {
        add(GlobalUtil.getString(R.string.discovery))
        add(GlobalUtil.getString(R.string.recommend))
        add(GlobalUtil.getString(R.string.daily))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        DiscoveryFragment.newInstance(),
        RecommendFragment.newInstance(),
        DailyFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(layoutInflater, container, false)
        return super.onCreateView(binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 搜索
        ivSearch = binding.titleBar.ivSearch
        ivSearch.setOnClickListener {
            activity.startActivity(Intent(activity, SearchActivity::class.java))
            activity.overridePendingTransition(R.anim.anl_push_up_in, 0)
        }
    }

}