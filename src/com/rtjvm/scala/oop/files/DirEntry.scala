package com.rtjvm.scala.oop.files

abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = parentPath + Directory.separator + name

  def asDirectory: Directory

  def getType: String
}
