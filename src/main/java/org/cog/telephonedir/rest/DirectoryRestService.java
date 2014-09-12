package org.cog.telephonedir.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("dir")
public class DirectoryRestService {
	@Path("find")
	@GET
	public Response getQuestions() {
		Map<String, Object> questionsMap = new HashMap<String, Object>();
		questionsMap.put("name", "vishal");

		List<Integer> phoneNumbers = new ArrayList<Integer>() {
			{
				add(1234567890);
				add(1235454544);
				add(1234767675);
				add(1234523213);
			}
		};
		questionsMap.put("choice", phoneNumbers);
		return Response.ok().entity(questionsMap).build();

	}
	@Path("checkAns/{name}/{phoneNumber}")
	@GET
	public Response checkAnswer(@PathParam("phoneNumber") Integer phoneNumber,@PathParam("name") String name ) {
		
		System.out.println(phoneNumber);
		if(phoneNumber.equals(1234567890)){
			return Response.ok().entity(true).build();
		}
		return Response.ok().entity(false).build();
	}

}
