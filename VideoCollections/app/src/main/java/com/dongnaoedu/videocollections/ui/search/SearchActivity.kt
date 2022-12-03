package com.dongnaoedu.videocollections.ui.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.databinding.ActivitySearchBinding
import com.dongnaoedu.videocollections.extension.logW
import com.dongnaoedu.videocollections.extension.setOnClickListener
import com.dongnaoedu.videocollections.extension.showToast
import com.dongnaoedu.videocollections.extension.visibleAlphaAnimation
import com.dongnaoedu.videocollections.ui.common.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchActivity : BaseActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var adapter: HotSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llSearch.visibleAlphaAnimation(500)
        binding.etQuery.setOnEditorActionListener(EditorActionListener())
        setOnClickListener(binding.tvCancel) {
            finish()
            overridePendingTransition(0, R.anim.anl_push_top_out)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = HotSearchAdapter(viewModel.dataList)
        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.data
                .catch { ex ->
                    ex.printStackTrace()
                    Log.d(TAG, "Exception catch.")
                }
                .collectLatest {
                    // 显示列表
                    viewModel.dataList.clear()
                    viewModel.dataList.addAll(it)
                    adapter.notifyDataSetChanged()
                    // 弹出软键盘
                    binding.etQuery.showSoftKeyboard()
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        hideSoftKeyboard()
    }

    /**
     * 隐藏软键盘
     */
    private fun hideSoftKeyboard() {
        try {
            currentFocus?.run {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        } catch (e: Exception) {
            logW(TAG, e.message, e)
        }
    }

    /**
     * 拉起软键盘
     */
    private fun View.showSoftKeyboard() {
        try {
            this.isFocusable = true
            this.isFocusableInTouchMode = true
            this.requestFocus()
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.showSoftInput(this, 0)
        } catch (e: Exception) {
            logW(TAG, e.message, e)
        }
    }


    inner class EditorActionListener : TextView.OnEditorActionListener {
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (binding.etQuery.text.toString().isEmpty()) {
                    R.string.input_keywords_tips.showToast()
                    return false
                }
                R.string.currently_not_supported.showToast()
                return true
            }
            return true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.anl_push_top_out)
    }
}