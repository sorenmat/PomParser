# Generated by Buildr 1.4.12, change to your liking
require 'buildr/scala'


# Version number for this release
VERSION_NUMBER = "1.0.0"
# Group identifier for your projects
GROUP = "PomParser"
COPYRIGHT = ""

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://repo1.maven.org/maven2"

desc "The Pomparser project"
define "PomParser" do

  project.version = VERSION_NUMBER
  project.group = GROUP

  manifest["Class-Path"] = 'scala-library.jar'
  manifest["Main-Class"] = 'com.scalaprog.pom.parser.Parser'
  package :jar, :id=>'pomparser'
end
