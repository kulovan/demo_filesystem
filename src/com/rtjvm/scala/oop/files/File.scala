package com.rtjvm.scala.oop.files


class File(override val parentPath: String, override val name: String, contents: String) extends DirEntry(parentPath, name) {
  override def asDirectory: Directory =
    throw new FileSystemException("File cannot be converted into directory!")

  override def getType: String = "File"
}
