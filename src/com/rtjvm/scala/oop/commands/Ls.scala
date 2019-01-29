package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.DirEntry
import com.rtjvm.scala.oop.filesystem.State

class Ls extends Command {
  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceOutput(contents)
    state.setMessage(niceOutput)
  }

  def createNiceOutput(entries: List[DirEntry]): String = {
    if (entries.isEmpty) ""
    else {
      val entry = entries.head
      entry.name + "[" + entry.getType + "]" + "\n" + createNiceOutput(entries.tail)
    }

  }
}
