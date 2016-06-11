// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: service_root.proto at 5:1
package com.squareup.wire.protos.roots;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class TheRequest extends Message<TheRequest, TheRequest.Builder> {
  public static final ProtoAdapter<TheRequest> ADAPTER = new ProtoAdapter_TheRequest();

  private static final long serialVersionUID = 0L;

  public TheRequest() {
    this(ByteString.EMPTY);
  }

  public TheRequest(ByteString unknownFields) {
    super(ADAPTER, unknownFields);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof TheRequest;
  }

  @Override
  public int hashCode() {
    return unknownFields().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    return builder.replace(0, 2, "TheRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<TheRequest, Builder> {
    public Builder() {
    }

    @Override
    public TheRequest build() {
      return new TheRequest(super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_TheRequest extends ProtoAdapter<TheRequest> {
    ProtoAdapter_TheRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, TheRequest.class);
    }

    @Override
    public int encodedSize(TheRequest value) {
      return value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, TheRequest value) throws IOException {
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public TheRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public TheRequest redact(TheRequest value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
