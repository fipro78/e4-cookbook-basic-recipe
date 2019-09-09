package org.fipro.eclipse.tutorial.app.preferences;

import org.fipro.e4.service.preferences.PreferenceNodeContribution;
import org.osgi.service.component.annotations.Component;

@Component(service = PreferenceNodeContribution.class)
public class ApplicationPreferencesContribution extends PreferenceNodeContribution {

	public ApplicationPreferencesContribution() {
		super("general", "General", GeneralPreferencePage.class);
		
		addPreferenceNode("parts", "Parts", PartPreferencePage.class);
	}

}
