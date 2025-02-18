// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: com/squareup/wire/whiteboard/whiteboard.proto
package com.squareup.wire.whiteboard

import com.squareup.wire.Service
import com.squareup.wire.WireRpc
import kotlin.Pair
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

interface WhiteboardClient : Service {
  @WireRpc(
    path = "/com.squareup.wire.whiteboard.Whiteboard/Whiteboard",
    requestAdapter = "com.squareup.wire.whiteboard.WhiteboardCommand#ADAPTER",
    responseAdapter = "com.squareup.wire.whiteboard.WhiteboardUpdate#ADAPTER"
  )
  fun Whiteboard(): Pair<SendChannel<WhiteboardCommand>, ReceiveChannel<WhiteboardUpdate>>
}
