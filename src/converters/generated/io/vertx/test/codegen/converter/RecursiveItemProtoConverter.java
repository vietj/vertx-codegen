package io.vertx.test.codegen.converter;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class RecursiveItemProtoConverter {

  public static void fromProto(CodedInputStream input, RecursiveItem obj) throws IOException {
    int tag;
    while ((tag = input.readTag()) != 0) {
      switch (tag) {
        case 10: {
          int length = input.readUInt32();
          int oldLimit = input.pushLimit(length);
          RecursiveItem tmp_ = new RecursiveItem();
          RecursiveItemProtoConverter.fromProto(input, tmp_);
          obj.setChild(tmp_);
          input.popLimit(oldLimit);
          break;
        }
      }
    }
  }

  public static void toProto(RecursiveItem obj, CodedOutputStream output) throws IOException {
    if (obj.getChild() != null) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(RecursiveItemProtoConverter.computeSize(obj.getChild()));
      RecursiveItemProtoConverter.toProto(obj.getChild(), output);
    }
  }

  public static int computeSize(RecursiveItem obj) {
    int size = 0;
    if (obj.getChild() != null) {
      size += CodedOutputStream.computeUInt32SizeNoTag(10);
      int dataSize = RecursiveItemProtoConverter.computeSize(obj.getChild());
      size += CodedOutputStream.computeUInt32SizeNoTag(dataSize);
      size += dataSize;
    }
    return size;
  }

  public static int computeSize2(RecursiveItem obj) {
    int size = 0;
    if (obj.getChild() != null) {
      size += CodedOutputStream.computeUInt32SizeNoTag(10);
      int dataSize = RecursiveItemProtoConverter.computeSize(obj.getChild());
      size += CodedOutputStream.computeUInt32SizeNoTag(dataSize);
      size += dataSize;
    }
    return size;
  }

}
