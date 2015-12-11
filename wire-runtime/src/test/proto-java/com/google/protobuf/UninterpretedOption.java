// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto at 610:1
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

/**
 * A message representing a option the parser does not recognize. This only
 * appears in options protos created by the compiler::Parser class.
 * DescriptorPool resolves these when building Descriptor objects. Therefore,
 * options protos in descriptor objects (e.g. returned by Descriptor::options(),
 * or produced by Descriptor::CopyTo()) will never have UninterpretedOptions
 * in them.
 */
public final class UninterpretedOption extends Message<UninterpretedOption, UninterpretedOption.Builder> {
  public static final ProtoAdapter<UninterpretedOption> ADAPTER = new ProtoAdapter<UninterpretedOption>(FieldEncoding.LENGTH_DELIMITED, UninterpretedOption.class) {
    @Override
    public int encodedSize(UninterpretedOption value) {
      return NamePart.ADAPTER.asRepeated().encodedSizeWithTag(2, value.name)
          + (value.identifier_value != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.identifier_value) : 0)
          + (value.positive_int_value != null ? ProtoAdapter.UINT64.encodedSizeWithTag(4, value.positive_int_value) : 0)
          + (value.negative_int_value != null ? ProtoAdapter.INT64.encodedSizeWithTag(5, value.negative_int_value) : 0)
          + (value.double_value != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(6, value.double_value) : 0)
          + (value.string_value != null ? ProtoAdapter.BYTES.encodedSizeWithTag(7, value.string_value) : 0)
          + (value.aggregate_value != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, value.aggregate_value) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, UninterpretedOption value) throws IOException {
      if (value.name != null) NamePart.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.name);
      if (value.identifier_value != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.identifier_value);
      if (value.positive_int_value != null) ProtoAdapter.UINT64.encodeWithTag(writer, 4, value.positive_int_value);
      if (value.negative_int_value != null) ProtoAdapter.INT64.encodeWithTag(writer, 5, value.negative_int_value);
      if (value.double_value != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 6, value.double_value);
      if (value.string_value != null) ProtoAdapter.BYTES.encodeWithTag(writer, 7, value.string_value);
      if (value.aggregate_value != null) ProtoAdapter.STRING.encodeWithTag(writer, 8, value.aggregate_value);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public UninterpretedOption decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 2: builder.name.add(NamePart.ADAPTER.decode(reader)); break;
          case 3: builder.identifier_value(ProtoAdapter.STRING.decode(reader)); break;
          case 4: builder.positive_int_value(ProtoAdapter.UINT64.decode(reader)); break;
          case 5: builder.negative_int_value(ProtoAdapter.INT64.decode(reader)); break;
          case 6: builder.double_value(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 7: builder.string_value(ProtoAdapter.BYTES.decode(reader)); break;
          case 8: builder.aggregate_value(ProtoAdapter.STRING.decode(reader)); break;
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
    public UninterpretedOption redact(UninterpretedOption value) {
      Builder builder = value.newBuilder();
      redactElements(builder.name, NamePart.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_IDENTIFIER_VALUE = "";

  public static final Long DEFAULT_POSITIVE_INT_VALUE = 0L;

  public static final Long DEFAULT_NEGATIVE_INT_VALUE = 0L;

  public static final Double DEFAULT_DOUBLE_VALUE = 0.0d;

  public static final ByteString DEFAULT_STRING_VALUE = ByteString.EMPTY;

  public static final String DEFAULT_AGGREGATE_VALUE = "";

  @WireField(
      tag = 2,
      adapter = "com.google.protobuf.UninterpretedOption$NamePart#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<NamePart> name;

  /**
   * The value of the uninterpreted option, in whatever type the tokenizer
   * identified it as during parsing. Exactly one of these should be set.
   */
  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String identifier_value;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#UINT64"
  )
  public final Long positive_int_value;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#INT64"
  )
  public final Long negative_int_value;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  public final Double double_value;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  public final ByteString string_value;

  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String aggregate_value;

  public UninterpretedOption(List<NamePart> name, String identifier_value, Long positive_int_value, Long negative_int_value, Double double_value, ByteString string_value, String aggregate_value) {
    this(name, identifier_value, positive_int_value, negative_int_value, double_value, string_value, aggregate_value, ByteString.EMPTY);
  }

  public UninterpretedOption(List<NamePart> name, String identifier_value, Long positive_int_value, Long negative_int_value, Double double_value, ByteString string_value, String aggregate_value, ByteString unknownFields) {
    super(unknownFields);
    this.name = immutableCopyOf("name", name);
    this.identifier_value = identifier_value;
    this.positive_int_value = positive_int_value;
    this.negative_int_value = negative_int_value;
    this.double_value = double_value;
    this.string_value = string_value;
    this.aggregate_value = aggregate_value;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = copyOf("name", name);
    builder.identifier_value = identifier_value;
    builder.positive_int_value = positive_int_value;
    builder.negative_int_value = negative_int_value;
    builder.double_value = double_value;
    builder.string_value = string_value;
    builder.aggregate_value = aggregate_value;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof UninterpretedOption)) return false;
    UninterpretedOption o = (UninterpretedOption) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(name, o.name)
        && equals(identifier_value, o.identifier_value)
        && equals(positive_int_value, o.positive_int_value)
        && equals(negative_int_value, o.negative_int_value)
        && equals(double_value, o.double_value)
        && equals(string_value, o.string_value)
        && equals(aggregate_value, o.aggregate_value);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 1);
      result = result * 37 + (identifier_value != null ? identifier_value.hashCode() : 0);
      result = result * 37 + (positive_int_value != null ? positive_int_value.hashCode() : 0);
      result = result * 37 + (negative_int_value != null ? negative_int_value.hashCode() : 0);
      result = result * 37 + (double_value != null ? double_value.hashCode() : 0);
      result = result * 37 + (string_value != null ? string_value.hashCode() : 0);
      result = result * 37 + (aggregate_value != null ? aggregate_value.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(name);
    if (identifier_value != null) builder.append(", identifier_value=").append(identifier_value);
    if (positive_int_value != null) builder.append(", positive_int_value=").append(positive_int_value);
    if (negative_int_value != null) builder.append(", negative_int_value=").append(negative_int_value);
    if (double_value != null) builder.append(", double_value=").append(double_value);
    if (string_value != null) builder.append(", string_value=").append(string_value);
    if (aggregate_value != null) builder.append(", aggregate_value=").append(aggregate_value);
    return builder.replace(0, 2, "UninterpretedOption{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<UninterpretedOption, Builder> {
    public List<NamePart> name;

    public String identifier_value;

    public Long positive_int_value;

    public Long negative_int_value;

    public Double double_value;

    public ByteString string_value;

    public String aggregate_value;

    public Builder() {
      name = newMutableList();
    }

    public Builder name(List<NamePart> name) {
      checkElementsNotNull(name);
      this.name = name;
      return this;
    }

    /**
     * The value of the uninterpreted option, in whatever type the tokenizer
     * identified it as during parsing. Exactly one of these should be set.
     */
    public Builder identifier_value(String identifier_value) {
      this.identifier_value = identifier_value;
      return this;
    }

    public Builder positive_int_value(Long positive_int_value) {
      this.positive_int_value = positive_int_value;
      return this;
    }

    public Builder negative_int_value(Long negative_int_value) {
      this.negative_int_value = negative_int_value;
      return this;
    }

    public Builder double_value(Double double_value) {
      this.double_value = double_value;
      return this;
    }

    public Builder string_value(ByteString string_value) {
      this.string_value = string_value;
      return this;
    }

    public Builder aggregate_value(String aggregate_value) {
      this.aggregate_value = aggregate_value;
      return this;
    }

    @Override
    public UninterpretedOption build() {
      return new UninterpretedOption(name, identifier_value, positive_int_value, negative_int_value, double_value, string_value, aggregate_value, buildUnknownFields());
    }
  }

  /**
   * The name of the uninterpreted option.  Each string represents a segment in
   * a dot-separated name.  is_extension is true iff a segment represents an
   * extension (denoted with parentheses in options specs in .proto files).
   * E.g.,{ ["foo", false], ["bar.baz", true], ["qux", false] } represents
   * "foo.(bar.baz).qux".
   */
  public static final class NamePart extends Message<NamePart, NamePart.Builder> {
    public static final ProtoAdapter<NamePart> ADAPTER = new ProtoAdapter<NamePart>(FieldEncoding.LENGTH_DELIMITED, NamePart.class) {
      @Override
      public int encodedSize(NamePart value) {
        return ProtoAdapter.STRING.encodedSizeWithTag(1, value.name_part)
            + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.is_extension)
            + value.unknownFields().size();
      }

      @Override
      public void encode(ProtoWriter writer, NamePart value) throws IOException {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name_part);
        ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.is_extension);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public NamePart decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.name_part(ProtoAdapter.STRING.decode(reader)); break;
            case 2: builder.is_extension(ProtoAdapter.BOOL.decode(reader)); break;
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
      public NamePart redact(NamePart value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    };

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_NAME_PART = "";

    public static final Boolean DEFAULT_IS_EXTENSION = false;

    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#STRING",
        label = WireField.Label.REQUIRED
    )
    public final String name_part;

    @WireField(
        tag = 2,
        adapter = "com.squareup.wire.ProtoAdapter#BOOL",
        label = WireField.Label.REQUIRED
    )
    public final Boolean is_extension;

    public NamePart(String name_part, Boolean is_extension) {
      this(name_part, is_extension, ByteString.EMPTY);
    }

    public NamePart(String name_part, Boolean is_extension, ByteString unknownFields) {
      super(unknownFields);
      this.name_part = name_part;
      this.is_extension = is_extension;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.name_part = name_part;
      builder.is_extension = is_extension;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof NamePart)) return false;
      NamePart o = (NamePart) other;
      return equals(unknownFields(), o.unknownFields())
          && equals(name_part, o.name_part)
          && equals(is_extension, o.is_extension);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + (name_part != null ? name_part.hashCode() : 0);
        result = result * 37 + (is_extension != null ? is_extension.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (name_part != null) builder.append(", name_part=").append(name_part);
      if (is_extension != null) builder.append(", is_extension=").append(is_extension);
      return builder.replace(0, 2, "NamePart{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<NamePart, Builder> {
      public String name_part;

      public Boolean is_extension;

      public Builder() {
      }

      public Builder name_part(String name_part) {
        this.name_part = name_part;
        return this;
      }

      public Builder is_extension(Boolean is_extension) {
        this.is_extension = is_extension;
        return this;
      }

      @Override
      public NamePart build() {
        if (name_part == null
            || is_extension == null) {
          throw missingRequiredFields(name_part, "name_part",
              is_extension, "is_extension");
        }
        return new NamePart(name_part, is_extension, buildUnknownFields());
      }
    }
  }
}
