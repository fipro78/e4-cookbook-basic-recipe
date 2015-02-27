package de.codecentric.eclipse.tutorial.service.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.FrameworkUtil;

import de.codecentric.eclipse.tutorial.service.preferences.impl.ScopedPreferenceStore;

/**
 * Specialization of PreferenceNode that overrides createPage() to support 
 * IPreferencePage creation for contributed pages from other bundles. 
 * Otherwise the page instance creation will fail because of ClassNotFoundExceptions.
 */
public class ContributedPreferenceNode extends PreferenceNode {

	private final String path;
	private final String nodeQualifier;
	private final Class<? extends IPreferencePage> pageClass;
	
	public ContributedPreferenceNode(
			String id, String label, 
			ImageDescriptor imageDescriptor, Class<? extends IPreferencePage> pageClass,
			String path, String nodeQualifier) {
		
		super(id, label, imageDescriptor, pageClass.getName());
		this.path = path;
		this.pageClass = pageClass;
		
		this.nodeQualifier = nodeQualifier != null ? nodeQualifier : FrameworkUtil.getBundle(pageClass).getSymbolicName();
	}

	@Override
	public void createPage() {
		try {
			setPage(this.pageClass.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if (getLabelImage() != null) {
			getPage().setImageDescriptor(getImageDescriptor());
		}
        getPage().setTitle(getLabelText());
        
        ((PreferencePage)getPage()).setPreferenceStore(
        		new ScopedPreferenceStore(InstanceScope.INSTANCE, this.nodeQualifier));
	}

	public String getPath() {
		return path;
	}
	
}
