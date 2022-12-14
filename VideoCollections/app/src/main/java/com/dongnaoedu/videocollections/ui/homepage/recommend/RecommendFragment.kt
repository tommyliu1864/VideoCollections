package com.dongnaoedu.videocollections.ui.homepage.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.databinding.FragmentRefreshLayoutBinding
import com.dongnaoedu.videocollections.ui.common.ui.BaseFragment
import com.dongnaoedu.videocollections.util.GlobalUtil
import com.dongnaoedu.videocollections.util.ResponseHandler
import com.scwang.smart.refresh.layout.constant.RefreshState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * 首页-推荐列表界面。
 */
@AndroidEntryPoint
class RecommendFragment : BaseFragment() {

    private lateinit var binding: FragmentRefreshLayoutBinding

    private val viewModel:RecommendViewModel by viewModels()

    private lateinit var adapter: RecommendAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRefreshLayoutBinding.inflate(layoutInflater, container, false)
        return super.onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecommendAdapter(this)
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.refreshLayout.setOnRefreshListener { adapter.refresh() }
        addLoadStateListener()

        lifecycleScope.launchWhenCreated {
            viewModel.getPagingData().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun loadFinished() {
        super.loadFinished()
        binding.refreshLayout.finishRefresh()
    }

    @CallSuper
    override fun loadFailed(msg: String?) {
        super.loadFailed(msg)
        binding.refreshLayout.finishRefresh()
        showLoadErrorView(msg ?: GlobalUtil.getString(R.string.unknown_error)) {
            startLoading()
            adapter.refresh()
        }
    }

    private fun addLoadStateListener() {
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    loadFinished()
                    if (it.source.append.endOfPaginationReached) {
                        binding.refreshLayout.setEnableLoadMore(true)
                        binding.refreshLayout.finishLoadMoreWithNoMoreData()
                    } else {
                        binding.refreshLayout.setEnableLoadMore(false)
                    }
                }
                is LoadState.Loading -> {
                    if (binding.refreshLayout.state != RefreshState.Refreshing) {
                        startLoading()
                    }
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    loadFailed(ResponseHandler.getFailureTips(state.error))
                }
            }
        }
    }

    companion object {

        fun newInstance() = RecommendFragment()
    }

}
