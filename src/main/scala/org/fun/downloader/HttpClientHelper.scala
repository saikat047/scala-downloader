package org.fun.downloader

import java.net.URL

import org.apache.http.impl.conn.PoolingClientConnectionManager
import org.apache.http.conn.ClientConnectionManager
import org.apache.http.client._
import org.apache.http.client.methods._
import org.apache.http._
import org.apache.http.impl.client.DefaultHttpClient

import org.apache.commons.io._

class HttpClientHelper {
  
	val RESPONSE_OK = 200;
  
	val httpClient : org.apache.http.client.HttpClient = 
			new DefaultHttpClient(new PoolingClientConnectionManager())
  
	def getContent(url: URL) : String = {
	  val getMethod : HttpGet = new HttpGet(url.toURI())
	  val response : HttpResponse = httpClient.execute(getMethod)
	  if (RESPONSE_OK != response.getStatusLine().getStatusCode())
	    return "";
	  else {
	    val encodingHeader = response.getEntity().getContentEncoding()
	    val encoding = 
	      if (encodingHeader != null) 
	        encodingHeader.getValue()
	      else
            "ISO-8859-1"
	    IOUtils.toString(response.getEntity().getContent(), encoding)
	  }
	}
	
	def shutdown() {
	  httpClient.getConnectionManager().shutdown()
	}
}
