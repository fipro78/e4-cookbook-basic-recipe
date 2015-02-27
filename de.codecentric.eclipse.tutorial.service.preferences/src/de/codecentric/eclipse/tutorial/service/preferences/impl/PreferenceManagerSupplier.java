package de.codecentric.eclipse.tutorial.service.preferences.impl;

import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.jface.preference.PreferenceManager;

import de.codecentric.eclipse.tutorial.service.preferences.ContributedPreferenceNode;
import de.codecentric.eclipse.tutorial.service.preferences.PreferenceNodeContribution;

public class PreferenceManagerSupplier extends ExtendedObjectSupplier {

	PreferenceManager mgr;
	
	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		return getManager();
	}

	public synchronized void addPreferenceNode(PreferenceNodeContribution node) {
		for (ContributedPreferenceNode contribNode : node.getPreferenceNodes()) {
			if (contribNode.getPath() == null) {
				getManager().addToRoot(contribNode);
			}
			else {
				getManager().addTo(contribNode.getPath(), contribNode);
			}
		}
	}
	
	public synchronized void removePreferenceNode(PreferenceNodeContribution node) {
		for (ContributedPreferenceNode contribNode : node.getPreferenceNodes()) {
			getManager().remove(contribNode);
		}
	}
	
	protected PreferenceManager getManager() {
		if (this.mgr == null) {
			this.mgr = new PreferenceManager();
		}
		return mgr;
	}
}
