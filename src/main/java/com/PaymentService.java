package com;

import model.Payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*; 

import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Payment")
public class PaymentService {
	Payment Obj = new Payment(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readPayments() 
	 { 
		return Obj.readPayments(); 
	 }
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertPayment(@FormParam("billno") String billno, 
	 @FormParam("name") String name, 
	 @FormParam("amount") String amount, 
	 @FormParam("contact") String contact) 
	{ 
	 String output = Obj.insertPayment(billno, name, amount, contact); 
	return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatePayment(String paymentData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String Id = paymentObject.get("Id").getAsString(); 
	 String billno = paymentObject.get("billno").getAsString(); 
	 String name = paymentObject.get("name").getAsString(); 
	 String amount = paymentObject.get("amount").getAsString(); 
	 String contact = paymentObject.get("contact").getAsString(); 
	 String output = Obj.updatePayment(Id, billno,name , amount, contact); 
	return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletePayment(String paymentData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser()); 
	 
	//Read the value from the element 
	 String Id = doc.select("Id").text(); 
	 String output = Obj.deletePayment(Id); 
	return output; 
	}

}
