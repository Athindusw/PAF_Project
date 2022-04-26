package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
import model.Consumption;

@Path("/Consumption")

public class ConsumptionService {
Consumption ConsumptionObj = new Consumption();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readConsumption() {
		return ConsumptionObj.readConsumption();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertConsumption(
	 @FormParam("AccNo") String AccNo,			
	 @FormParam("Address") String Address,
	 @FormParam("PreviousUnits") String PreviousUnits,
	 @FormParam("CurentUnits") String CurentUnits,
	 @FormParam("ConsumedUnits") String ConsumedUnits)
	{
	 String output = ConsumptionObj.insertConsumption(AccNo, Address, PreviousUnits, CurentUnits, ConsumedUnits);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateConsumption(String consumptionData)
	{
	//Convert the input string to a JSON object
	 JsonObject ConsumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();
	//Read the values from the JSON object
	 String cID = ConsumptionObject.get("cID").getAsString();
	 String AccNo = ConsumptionObject.get("AccNo").getAsString();
	 String Address = ConsumptionObject.get("Address").getAsString();
	 String PreviousUnits = ConsumptionObject.get("PreviousUnits").getAsString();
	 String CurentUnits = ConsumptionObject.get("CurentUnits").getAsString();
	 String ConsumedUnits = ConsumptionObject.get("ConsumedUnits").getAsString();
	 String output = ConsumptionObj.updateConsumption(cID, AccNo, Address, PreviousUnits, CurentUnits, ConsumedUnits);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteConsumption(String consumptionData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(consumptionData, "", Parser.xmlParser());

	//Read the value from the element <ID>
	 String cID = doc.select("cID").text();
	 String output = ConsumptionObj.deleteConsumption(cID);
	return output;
	}
}

