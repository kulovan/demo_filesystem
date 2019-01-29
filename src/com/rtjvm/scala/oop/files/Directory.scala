package com.rtjvm.scala.oop.files

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry]) extends DirEntry(parentPath, name) {
  def replaceEntry(entryName: String, newEntry: DirEntry): Directory = ???


  def findEntry(entryName: String): DirEntry = ???

  def addEntry(newEntry: DirEntry): Directory = ???

  def findDescendant(path: List[String]): Directory = ???

  def getAllFoldersInPath: List[String] =
    path.substring(1).split(Directory.separator).toList

  def hasEntry(name: String): Boolean = ???

  override def asDirectory: Directory = this

}

object Directory {
  val separator = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "")

  def empty(parentPath: String, name: String): Directory = {
    new Directory(parentPath, name, List())
  }
}
