package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {

  val MKDIR = "mkdir"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

  def inCompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(name + " incomplete command")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) inCompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    }
    else new UnknownCommand
  }
}
