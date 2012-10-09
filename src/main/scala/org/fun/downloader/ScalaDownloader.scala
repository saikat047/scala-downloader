package org.fun.downloader

import java.net.URL
import scala.collection.immutable

import org.slf4j._
import org.apache.http.client._

object ScalaDownloader {
  
	def logger : Logger = LoggerFactory.getLogger(getClass())
  
	def main(argv: Array[String]) = {
	  if (argv.length == 0) {
	    logger.error("usage: program root-url")
	    exit(-1)
	  }
	  
	}
}

class ScalaDownloader(pRootURL: URL) {
  def rootURL = pRootURL
  
  def getProbableVideoURLs : List[URL] = {
    return Nil;
  }
}
