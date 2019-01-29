package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FileSystemException


class File(override val parentPath: String, override val name: String, contents: String) extends DirEntry(parentPath, name) {
  override def asDirectory: Directory =
    throw new FileSystemException("File cannot be converted into directory!")

  override def getType: String = "File"

  override def asFile: File = this
}

object File {

  def empty(parentPath: String, name: String): File = {
    new File(parentPath, name, "")
  }

}