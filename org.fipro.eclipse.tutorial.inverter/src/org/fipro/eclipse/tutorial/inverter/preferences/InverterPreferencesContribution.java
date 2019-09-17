package org.fipro.eclipse.tutorial.inverter.preferences;

import org.fipro.e4.service.preferences.PreferenceNodeContribution;
import org.osgi.service.component.annotations.Component;

@Component(service = PreferenceNodeContribution.class)
public class InverterPreferencesContribution extends PreferenceNodeContribution {

	public InverterPreferencesContribution() {
		super("inverter", "Inverter", InverterPreferencePage.class);
	}

}
