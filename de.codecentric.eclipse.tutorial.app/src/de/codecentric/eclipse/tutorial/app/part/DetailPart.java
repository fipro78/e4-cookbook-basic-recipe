package de.codecentric.eclipse.tutorial.app.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DetailPart {

	Label detailLabel;

	@PostConstruct
	public void postConstruct(Composite parent,
			@Preference(nodePath = "de.codecentric.eclipse.tutorial.app", value = "detail") String detail) {
		detailLabel = new Label(parent, SWT.NONE);
		detailLabel.setText(detail);
	}

	@Inject
	@Optional
	public void setDetailMessage(
			@Preference(nodePath = "de.codecentric.eclipse.tutorial.app", value = "detail") String detail) {
		if (detailLabel != null && !detailLabel.isDisposed()) {
			detailLabel.setText(detail);
		}
	}

	@Inject
	@Optional
	public void setDetailPartTitle(MPart part,
			@Preference(nodePath = "de.codecentric.eclipse.tutorial.app", value = "detailpart_title") String detailTitle) {
		if (part != null) {
			part.setLabel(detailTitle);
		}
	}
}