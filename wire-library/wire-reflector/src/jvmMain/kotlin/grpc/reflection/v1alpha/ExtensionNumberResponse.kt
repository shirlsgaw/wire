// Code generated by Wire protocol buffer compiler, do not edit.
// Source: grpc.reflection.v1alpha.ExtensionNumberResponse in grpc/reflection/v1alpha/reflection.proto
package grpc.reflection.v1alpha

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.checkElementsNotNull
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.sanitize
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * A list of extension numbers sent by the server answering
 * all_extension_numbers_of_type request.
 */
public class ExtensionNumberResponse(
  /**
   * Full name of the base type, including the package name. The format
   * is <package>.<type>
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "baseTypeName"
  )
  @JvmField
  public val base_type_name: String = "",
  extension_number: List<Int> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ExtensionNumberResponse, ExtensionNumberResponse.Builder>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT32",
    label = WireField.Label.PACKED,
    jsonName = "extensionNumber"
  )
  @JvmField
  public val extension_number: List<Int> = immutableCopyOf("extension_number", extension_number)

  public override fun newBuilder(): Builder {
    val builder = Builder()
    builder.base_type_name = base_type_name
    builder.extension_number = extension_number
    builder.addUnknownFields(unknownFields)
    return builder
  }

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ExtensionNumberResponse) return false
    if (unknownFields != other.unknownFields) return false
    if (base_type_name != other.base_type_name) return false
    if (extension_number != other.extension_number) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + base_type_name.hashCode()
      result = result * 37 + extension_number.hashCode()
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    result += """base_type_name=${sanitize(base_type_name)}"""
    if (extension_number.isNotEmpty()) result += """extension_number=$extension_number"""
    return result.joinToString(prefix = "ExtensionNumberResponse{", separator = ", ", postfix = "}")
  }

  public fun copy(
    base_type_name: String = this.base_type_name,
    extension_number: List<Int> = this.extension_number,
    unknownFields: ByteString = this.unknownFields
  ): ExtensionNumberResponse = ExtensionNumberResponse(base_type_name, extension_number,
      unknownFields)

  public class Builder : Message.Builder<ExtensionNumberResponse, Builder>() {
    @JvmField
    public var base_type_name: String = ""

    @JvmField
    public var extension_number: List<Int> = emptyList()

    /**
     * Full name of the base type, including the package name. The format
     * is <package>.<type>
     */
    public fun base_type_name(base_type_name: String): Builder {
      this.base_type_name = base_type_name
      return this
    }

    public fun extension_number(extension_number: List<Int>): Builder {
      checkElementsNotNull(extension_number)
      this.extension_number = extension_number
      return this
    }

    public override fun build(): ExtensionNumberResponse = ExtensionNumberResponse(
      base_type_name = base_type_name,
      extension_number = extension_number,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<ExtensionNumberResponse> = object :
        ProtoAdapter<ExtensionNumberResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      ExtensionNumberResponse::class, 
      "type.googleapis.com/grpc.reflection.v1alpha.ExtensionNumberResponse", 
      PROTO_3, 
      null
    ) {
      public override fun encodedSize(value: ExtensionNumberResponse): Int {
        var size = value.unknownFields.size
        if (value.base_type_name != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1,
            value.base_type_name)
        size += ProtoAdapter.INT32.asPacked().encodedSizeWithTag(2, value.extension_number)
        return size
      }

      public override fun encode(writer: ProtoWriter, value: ExtensionNumberResponse): Unit {
        if (value.base_type_name != "") ProtoAdapter.STRING.encodeWithTag(writer, 1,
            value.base_type_name)
        ProtoAdapter.INT32.asPacked().encodeWithTag(writer, 2, value.extension_number)
        writer.writeBytes(value.unknownFields)
      }

      public override fun decode(reader: ProtoReader): ExtensionNumberResponse {
        var base_type_name: String = ""
        val extension_number = mutableListOf<Int>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> base_type_name = ProtoAdapter.STRING.decode(reader)
            2 -> extension_number.add(ProtoAdapter.INT32.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return ExtensionNumberResponse(
          base_type_name = base_type_name,
          extension_number = extension_number,
          unknownFields = unknownFields
        )
      }

      public override fun redact(value: ExtensionNumberResponse): ExtensionNumberResponse =
          value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
