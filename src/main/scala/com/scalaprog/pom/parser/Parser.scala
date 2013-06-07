package com.scalaprog.pom.parser

import scala.xml.XML

/**
 * User: soren
 */
class Parser {


  def parse(template: String, inputFile: String) {
    val data = XML.loadFile(inputFile)

    val deps = data \\ "dependency"
    val result = deps.map(dep => {
      val groupId = (dep \\ "groupId").text
      val artifactId = (dep \\ "artifactId").text
      val version = (dep \\ "version").text
      val filledOutTemplate = template.replace("{groupId}", groupId).replace("{artifactId}", artifactId).replace("{version}", version)
      filledOutTemplate
    })
    println(result.mkString("\n"))
  }

}

object Parser {
  def main(args: Array[String]) {
    require(args.size >= 1, "You need to specify a pom file to parse")
    val inputFile = args(0)
    val parser = new Parser
    if (args.size > 1) {
      val template = args(1)
      parser.parse(template, inputFile)
    } else {
      parser.parse("{groupId}:{artifactId}:jar:{version}", inputFile)
    }
    new Parser
  }
}

