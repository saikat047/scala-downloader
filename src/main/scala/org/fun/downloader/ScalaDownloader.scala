package org.fun.downloader

import java.net.URL

import scala.collection.immutable.Nil

import org.slf4j._
import org.apache.http.client._

object ScalaDownloader {
  
	def logger : Logger = LoggerFactory.getLogger(getClass())
  
	def main(argv: Array[String]) = {
	  if (argv.length == 0) {
	    logger.error("usage: program root-url")
	    exit(-1)
	  }
	  
	  val client : HttpClientHelper = new HttpClientHelper
	  val content = client.getContent(new URL(argv(0)))
	  
	  val extractor : LinkExtractor = new LinkExtractor
	  val links = extractor.getAvailableEpisodeLinks(content)
	  for (link <- links) {
	    println("Episode link: " + link)
	  }
	  
	  client.shutdown
	}
}

class ScalaDownloader(pRootURL: URL) {
  def rootURL = pRootURL
  
  def getProbableVideoURLs : List[URL] = {
    return Nil
  }
}
