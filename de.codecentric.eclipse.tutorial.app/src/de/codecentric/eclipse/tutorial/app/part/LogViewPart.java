 
package de.codecentric.eclipse.tutorial.app.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;

public class LogViewPart {

	ListViewer viewer;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		viewer = new ListViewer(parent);
	}
	
	@Inject
	@Optional
	void logging(@UIEventTopic("TOPIC_LOGGING") String message) {
		viewer.add(message);
	}
	
}