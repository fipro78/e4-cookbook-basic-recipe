package de.codecentric.eclipse.tutorial.service.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;

public class PreferenceNodeContribution {

	private final List<ContributedPreferenceNode> nodes = new ArrayList<>();

	public PreferenceNodeContribution(String id, String label, Class<? extends IPreferencePage> pageClass) {
		this(id, label, null, pageClass, null, null);
	}

	public PreferenceNodeContribution(String id, String label, Class<? extends IPreferencePage> pageClass, String path) {
		this(id, label, null, pageClass, path, null);
	}

	public PreferenceNodeContribution(String id, String label, Class<? extends IPreferencePage> pageClass, String path, String nodeQualifier) {
		this(id, label, null, pageClass, path, nodeQualifier);
	}

	public PreferenceNodeContribution(
			String id, 
			String label, 
			ImageDescriptor imageDescriptor,
			Class<? extends IPreferencePage> pageClass, 
			String path,
			String nodeQualifier) {
		
		this.nodes.add(new ContributedPreferenceNode(id, label, imageDescriptor, pageClass, path, nodeQualifier));
	}

	public List<ContributedPreferenceNode> getPreferenceNodes() {
		return this.nodes;
	}

	public void addPreferenceNode(String id, String label, Class<? extends IPreferencePage> pageClass) {
		addPreferenceNode(id, label, null, pageClass, null, null);
	}

	public void addPreferenceNode(String id, String label, Class<? extends IPreferencePage> pageClass, String path) {
		addPreferenceNode(id, label, null, pageClass, path, null);
	}

	public void addPreferenceNode(String id, String label, Class<? extends IPreferencePage> pageClass, String path, String nodeQualifier) {
		addPreferenceNode(id, label, null, pageClass, path, nodeQualifier);
	}
	
	public void addPreferenceNode(
			String id, 
			String label, 
			ImageDescriptor imageDescriptor,
			Class<? extends IPreferencePage> pageClass, 
			String path,
			String nodeQualifier) {
		
		this.nodes.add(new ContributedPreferenceNode(id, label, imageDescriptor, pageClass, path, nodeQualifier));
	}
}
