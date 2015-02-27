package de.codecentric.eclipse.tutorial.app.preferences;

import de.codecentric.eclipse.tutorial.service.preferences.PreferenceNodeContribution;

public class ApplicationPreferencesContribution extends PreferenceNodeContribution {

	public ApplicationPreferencesContribution() {
		super("general", "General", GeneralPreferencePage.class);
		
		addPreferenceNode("parts", "Parts", PartPreferencePage.class);
	}

}
