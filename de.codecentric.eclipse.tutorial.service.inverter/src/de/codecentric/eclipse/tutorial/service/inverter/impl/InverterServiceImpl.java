package de.codecentric.eclipse.tutorial.service.inverter.impl;

import de.codecentric.eclipse.tutorial.service.inverter.InverterService;

public class InverterServiceImpl implements InverterService {

	@Override
	public String invert(String value) {
		return new StringBuilder(value).reverse().toString();
	}

}
