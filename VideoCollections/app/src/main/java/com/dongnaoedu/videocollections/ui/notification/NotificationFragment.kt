package com.dongnaoedu.videocollections.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.ui.common.ui.BaseViewPagerFragment
import com.dongnaoedu.videocollections.ui.notification.inbox.InboxFragment
import com.dongnaoedu.videocollections.ui.notification.interaction.InteractionFragment
import com.dongnaoedu.videocollections.ui.notification.push.PushFragment
import com.dongnaoedu.videocollections.util.GlobalUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseViewPagerFragment() {

    override val createTitles = ArrayList<String>().apply {
        add(GlobalUtil.getString(R.string.push))
        add(GlobalUtil.getString(R.string.interaction))
        add(GlobalUtil.getString(R.string.inbox))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        PushFragment.newInstance(),
        InteractionFragment.newInstance(),
        InboxFragment.newInstance()
    )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_main_container, container, false))
    }

    companion object {

        fun newInstance() = NotificationFragment()
    }
}