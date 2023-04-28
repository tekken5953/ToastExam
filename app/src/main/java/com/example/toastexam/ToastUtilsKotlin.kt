package com.example.airsignal_app.view

import android.app.Activity
import android.widget.Toast

class ToastUtilsKotlin(private val mContext: Activity) {
    private var toast: Toast? = null

    /**
     * 토스트메시지를 2초간 비동기로 보여준다
     */
    fun showMessage(message: String?) {
        val r = Runnable {
            cancelToast()
            toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT)
            toast!!.show()
        }
        mContext.runOnUiThread(r)
    }

    /**
     * 토스트메시지가 보여지는 시간을 동적으로 설정한다
     */
    fun showMessage(message: String?, duration: Int) {
        val r = Runnable {
            cancelToast()
            toast = Toast.makeText(mContext, message, duration)
            toast!!.show()
        }
        mContext.runOnUiThread(r)
    }

    /**
     * 토스트메시지가 보여지고 있으면 취소시킨다
     */
    private fun cancelToast() {
        if (toast != null) {
            mContext.runOnUiThread { toast!!.cancel() }
        }
        toast = Toast(mContext)
    }
}