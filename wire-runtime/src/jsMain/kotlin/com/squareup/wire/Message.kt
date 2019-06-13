package com.squareup.wire

import okio.BufferedSink
import okio.ByteString

/** A protocol buffer message. */
actual abstract class Message<M : Message<M, B>, B : Message.Builder<M, B>> protected constructor(
  private val adapter: ProtoAdapter<M>,
  /** Unknown fields, proto-encoded. We permit null to support magic deserialization. */
  private val unknownFields: ByteString?
) {
  /** If non-zero, the hash code of this message. Accessed by generated code. */
  protected actual var hashCode = 0

  init {
    if (unknownFields == null) throw NullPointerException("unknownFields == null")
  }

  /**
   * Returns a byte string containing the proto encoding of this message's unknown fields. Returns
   * an empty byte string if this message has no unknown fields.
   */
  actual fun unknownFields(): ByteString = unknownFields ?: ByteString.EMPTY

  /**
   * Returns a new builder initialized with the data in this message.
   */
  actual abstract fun newBuilder(): B

  /** Returns this message with any unknown fields removed. */
  actual fun withoutUnknownFields(): M = TODO()

  /** The [ProtoAdapter] for encoding and decoding messages of this type. */
  actual fun adapter(): ProtoAdapter<M> = adapter

  /** Encode this message and write it to `stream`. */
  actual fun encode(sink: BufferedSink) {
    adapter.encode(sink, this as M)
  }

  /** Encode this message as a `byte[]`. */
  actual fun encode(): ByteArray = adapter.encode(this as M)

  /**
   * Superclass for protocol buffer message builders.
   */
  actual abstract class Builder<M : Message<M, B>, B : Builder<M, B>>
}
