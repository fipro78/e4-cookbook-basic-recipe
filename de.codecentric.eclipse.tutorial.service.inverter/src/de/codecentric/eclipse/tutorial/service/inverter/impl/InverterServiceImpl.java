package de.codecentric.eclipse.tutorial.service.inverter.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;

import de.codecentric.eclipse.tutorial.service.inverter.InverterService;

public class InverterServiceImpl implements InverterService {

	EventAdmin eventAdmin;
	
	@Override
	public String invert(String value) {
		String result = new StringBuilder(value).reverse().toString();
		
		String topic = "TOPIC_LOGGING";
		Dictionary<String, Object> data = new Hashtable<String, Object>(2);
		data.put(EventConstants.EVENT_TOPIC, topic);
		data.put(IEventBroker.DATA, "Inverted " + value + " to " + result);
		Event event = new Event(topic, data);
		
		eventAdmin.postEvent(event);
		
		return result;
	}

	 void registerEventAdmin(EventAdmin admin) {
		 this.eventAdmin = admin;
	 }
	 
	 void unregisterEventAdmin(EventAdmin admin) {
		 this.eventAdmin = null;
	 }
}
