package org.cog.telephonedir.rest;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class DirectoryRestServiceSpec {
	 static final URI BASE_URI = getBaseURI();

	    private static URI getBaseURI() {
	        return UriBuilder.fromUri("http://localhost/").port(8888).build();
	    }
	@Test
	public void getQuestionsTest() {
		//Given
		Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());
       
		//When
        String resp = service.path("TelephoneDirectory").path("rest").path("dir").path("find")
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        
		//Then
        String s = "{\"choice\":[1234567890,1235454544,1234767675,1234523213],\"name\":\"vishal\"}";
        Assert.assertEquals(s, resp);
	}
	
	@Test
	public void checkAnswerTest() {
		//Given
		Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());
       
		//When
        boolean resp = service.path("TelephoneDirectory").path("rest").path("dir").path("checkAns").path("vishal").path("1234567890")
                .accept(MediaType.APPLICATION_JSON)
                .get(Boolean.class);
        System.out.println(resp);
		//Then
        Assert.assertTrue(resp);
	}
}
