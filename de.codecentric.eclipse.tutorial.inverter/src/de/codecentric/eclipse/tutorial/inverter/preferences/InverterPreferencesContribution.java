package de.codecentric.eclipse.tutorial.inverter.preferences;

import de.codecentric.eclipse.tutorial.service.preferences.PreferenceNodeContribution;

public class InverterPreferencesContribution extends PreferenceNodeContribution {

	public InverterPreferencesContribution() {
		super("inverter", "Inverter", InverterPreferencePage.class);
	}

}
