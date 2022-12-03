package com.dongnaoedu.videocollections.ui.notification.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dongnaoedu.videocollections.databinding.FragmentNotificationLoginTipsBinding
import com.dongnaoedu.videocollections.ui.common.ui.BaseFragment
import com.dongnaoedu.videocollections.ui.login.LoginActivity

class InboxFragment : BaseFragment() {

    lateinit var binding: FragmentNotificationLoginTipsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationLoginTipsBinding.inflate(inflater, container, false)
        return super.onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLogin.setOnClickListener { LoginActivity.start(activity) }
    }

    companion object {
        fun newInstance() = InboxFragment()
    }
}