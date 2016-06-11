// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: samebasename/single_level.proto at 24:1
package com.squareup.wire.protos.single_level;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class Bars extends Message<Bars, Bars.Builder> {
  public static final ProtoAdapter<Bars> ADAPTER = new ProtoAdapter_Bars();

  private static final long serialVersionUID = 0L;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.protos.single_level.Bar#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Bar> bars;

  public Bars(List<Bar> bars) {
    this(bars, ByteString.EMPTY);
  }

  public Bars(List<Bar> bars, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.bars = Internal.immutableCopyOf("bars", bars);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.bars = Internal.copyOf("bars", bars);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Bars)) return false;
    Bars o = (Bars) other;
    return unknownFields().equals(o.unknownFields())
        && bars.equals(o.bars);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + bars.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!bars.isEmpty()) builder.append(", bars=").append(bars);
    return builder.replace(0, 2, "Bars{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Bars, Builder> {
    public List<Bar> bars;

    public Builder() {
      bars = Internal.newMutableList();
    }

    public Builder bars(List<Bar> bars) {
      Internal.checkElementsNotNull(bars);
      this.bars = bars;
      return this;
    }

    @Override
    public Bars build() {
      return new Bars(bars, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Bars extends ProtoAdapter<Bars> {
    ProtoAdapter_Bars() {
      super(FieldEncoding.LENGTH_DELIMITED, Bars.class);
    }

    @Override
    public int encodedSize(Bars value) {
      return Bar.ADAPTER.asRepeated().encodedSizeWithTag(1, value.bars)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Bars value) throws IOException {
      Bar.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.bars);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Bars decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.bars.add(Bar.ADAPTER.decode(reader)); break;
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
    public Bars redact(Bars value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.bars, Bar.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
