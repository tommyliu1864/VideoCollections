package com.dongnaoedu.videocollections.util

import android.app.Activity
import android.content.Intent
import com.dongnaoedu.videocollections.R
import com.dongnaoedu.videocollections.extension.showToast

const val SHARE_MORE = 0
const val SHARE_QQ = 1
const val SHARE_WECHAT = 2
const val SHARE_WEIBO = 3
const val SHARE_QQZONE = 4
const val SHARE_WECHAT_MEMORIES = 5

/**
 * 调用系统原生分享工具类。
 */
object ShareUtil {

    private fun processShare(activity: Activity, shareContent: String, shareType: Int) {
        when (shareType) {
            SHARE_QQ -> {
                if (!GlobalUtil.isQQInstalled()) {
                    GlobalUtil.getString(R.string.your_phone_does_not_install_qq).showToast()
                    return
                }
                share(activity, shareContent, "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity")
            }
            SHARE_WECHAT -> {
                if (!GlobalUtil.isWechatInstalled()) {
                    GlobalUtil.getString(R.string.your_phone_does_not_install_wechat).showToast()
                    return
                }
                share(activity, shareContent, "com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI")
            }
            /*SHARE_WECHAT_MEMORIES -> {
                if (!GlobalUtil.isWechatInstalled()) {
                    GlobalUtil.getString(R.string.your_phone_does_not_install_wechat).showToast()
                    return
                }
                share(activity, shareContent, "com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI")
            }*/
            SHARE_WEIBO -> {
                if (!GlobalUtil.isWeiboInstalled()) {
                    GlobalUtil.getString(R.string.your_phone_does_not_install_weibo).showToast()
                    return
                }
                share(activity, shareContent, "com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity")
            }
            SHARE_QQZONE -> {
                if (!GlobalUtil.isWeiboInstalled()) {
                    GlobalUtil.getString(R.string.your_phone_does_not_install_qq_zone).showToast()
                    return
                }
                share(activity, shareContent, "com.qzone", "com.qzonex.module.operation.ui.QZonePublishMoodActivity")
            }
            SHARE_MORE -> {
                share(activity, shareContent)
            }
        }
    }

    private fun share(activity: Activity, shareContent: String, packageName: String, className: String) {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareContent)
                setClassName(packageName, className)
            }
            activity.startActivity(shareIntent)
        } catch (e: Exception) {
            GlobalUtil.getString(R.string.share_unknown_error).showToast()
        }
    }

    private fun share(activity: Activity, shareContent: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareContent)
        }
        activity.startActivity(Intent.createChooser(shareIntent, GlobalUtil.getString(R.string.share_to)))
    }

    /**
     * 调用系统原生分享
     *
     * @param shareContent 分享内容
     * @param shareType SHARE_MORE=0，SHARE_QQ=1，SHARE_WECHAT=2，SHARE_WEIBO=3，SHARE_QQZONE=4
     */
    fun share(activity: Activity, shareContent: String, shareType: Int) {
        processShare(activity, shareContent, shareType)
    }

}