package org.fipro.eclipse.tutorial.inverter.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class InverterPreferencePage extends PreferencePage {

	// Names for preferences
	private static final String INVERTER_COLOR = "inverter_color";

	// The checkboxes
	private Button checkOne;
	private Button checkTwo;

	public InverterPreferencePage() {
		super("Inverter");
		setDescription("The inverter preferences page");
	}

	/**
	 * Creates the controls for this page
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();
		
		String color = preferenceStore.getString(INVERTER_COLOR);
		boolean isBlack = (color != null && !color.isEmpty()) ? "black".equals(color) : true;

		// Create the checkboxes
		checkOne = new Button(composite, SWT.RADIO);
		checkOne.setText("Text Color Black");
		checkOne.setSelection(isBlack);

		checkTwo = new Button(composite, SWT.RADIO);
		checkTwo.setText("Text Color Blue");
		checkTwo.setSelection(!isBlack);

		checkOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkOne.setSelection(true);
				checkTwo.setSelection(false);
			}
		});
		
		checkTwo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkOne.setSelection(false);
				checkTwo.setSelection(true);
			}
		});
		
		return composite;
	}

	/**
	 * Called when user clicks Restore Defaults
	 */
	protected void performDefaults() {
		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();

		String color = preferenceStore.getString(INVERTER_COLOR);
		boolean isBlack = (color != null && !color.isEmpty()) ? "black".equals(color) : true;

		// Reset the fields to the defaults
		checkOne.setSelection(isBlack);
		checkTwo.setSelection(!isBlack);
	}

	/**
	 * Called when user clicks Apply or OK
	 * 
	 * @return boolean
	 */
	public boolean performOk() {
		// Get the preference store
		IPreferenceStore preferenceStore = getPreferenceStore();

		// Set the values from the fields
		if (checkOne != null && checkOne.getSelection()) {
			preferenceStore.setValue(INVERTER_COLOR, "black");
		}
		else if (checkTwo != null && checkTwo.getSelection()) {
			preferenceStore.setValue(INVERTER_COLOR, "blue");
		}

		// Return true to allow dialog to close
		return true;
	}

}
