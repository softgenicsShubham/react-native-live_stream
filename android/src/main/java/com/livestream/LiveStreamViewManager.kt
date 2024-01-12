package com.livestream

import android.content.res.Resources.Theme
import android.graphics.Camera
import android.graphics.Color
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.haishinkit.media.AudioRecordSource
import com.haishinkit.media.Camera2Source
import com.haishinkit.rtmp.RtmpConnection
import com.haishinkit.rtmp.RtmpStream
import com.haishinkit.view.HkSurfaceView
import com.haishinkit.view.NetStreamDrawable

class LiveStreamViewManager<Context> : SimpleViewManager<HkSurfaceView>() {
  override fun getName() = "LiveStreamView"


  private lateinit var connection: RtmpConnection
  private lateinit var stream: RtmpStream
  private lateinit var cameraView: NetStreamDrawable
  private lateinit var cameraSource: Camera2Source




  override fun createViewInstance(reactContext: ThemedReactContext): HkSurfaceView {
      connection  =  RtmpConnection()
      stream = RtmpStream(connection)
      stream.attachAudio(AudioRecordSource(reactContext))
      cameraSource = Camera2Source(reactContext);
      stream.attachVideo(cameraSource)

    val hkSurfaceView: HkSurfaceView = HkSurfaceView(reactContext)
      cameraView = hkSurfaceView
      cameraView.attachStream(stream)

    return hkSurfaceView
  }



//  @ReactProp(name = "color")
//  fun setColor(view: View, color: String) {
//    view.setBackgroundColor(Color.parseColor(color))
//  }
}
