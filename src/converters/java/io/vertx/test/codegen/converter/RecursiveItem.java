package io.vertx.test.codegen.converter;

import io.vertx.codegen.annotations.DataObject;

// Temporary Test Object, maybe will switch to test with TestDataObject
@DataObject(generateConverter = true, protoConverter = true)
public class RecursiveItem {

  private RecursiveItem child;

  public RecursiveItem getChild() {
    return child;
  }

  public RecursiveItem setChild(RecursiveItem child) {
    this.child = child;
    return this;
  }
}
