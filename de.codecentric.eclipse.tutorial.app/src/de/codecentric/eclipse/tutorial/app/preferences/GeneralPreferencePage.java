package de.codecentric.eclipse.tutorial.app.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GeneralPreferencePage extends PreferencePage {

	// Names for preferences
	private static final String DETAIL = "detail";

	// Text fields for user to enter preferences
	private Text fieldOne;

	public GeneralPreferencePage() {
		super("General");
		setDescription("The general preferences");
	}
	
	/**
	 * Creates the controls for this page
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();

		// Create three text fields.
		// Set the text in each from the preference store
		new Label(composite, SWT.LEFT).setText("Detail message:");
		fieldOne = new Text(composite, SWT.BORDER);
		fieldOne.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fieldOne.setText(preferenceStore.getString(DETAIL));

		return composite;
	}

	/**
	 * Called when user clicks Restore Defaults
	 */
	@Override
	protected void performDefaults() {
		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();

		// Reset the fields to the defaults
		fieldOne.setText(preferenceStore.getDefaultString(DETAIL));
	}

	/**
	 * Called when user clicks Apply or OK
	 * 
	 * @return boolean
	 */
	@Override
	public boolean performOk() {
		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();

		// Set the values from the fields
		if (fieldOne != null)
			preferenceStore.setValue(DETAIL, fieldOne.getText());

		// Return true to allow dialog to close
		return true;
	}
}
