package org.fun.downloader

import java.net.URL
import org.apache.http.impl.conn.PoolingClientConnectionManager
import org.apache.http.conn.ClientConnectionManager
import org.apache.http.client._
import org.apache.http.client.methods._
import org.apache.http._
import org.apache.http.impl.client.DefaultHttpClient

class HttpClientHelper {
  
	val httpClient : org.apache.http.client.HttpClient = 
			new DefaultHttpClient(new PoolingClientConnectionManager())
  
	def getContent(url: URL) : String = {
	  val getMethod : HttpGet = new HttpGet(url.toURI())
	  val response : HttpResponse = httpClient.execute(getMethod)
	  
	  null;
	}
	
	def shutdown() {
	  httpClient.getConnectionManager().shutdown()
	}
}
