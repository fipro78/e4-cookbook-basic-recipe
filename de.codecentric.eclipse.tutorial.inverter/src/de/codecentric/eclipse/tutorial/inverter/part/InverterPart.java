package de.codecentric.eclipse.tutorial.inverter.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.codecentric.eclipse.tutorial.inverter.helper.StringInverter;

public class InverterPart {
	
	Text input;
	Text output;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, true));
		
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText("String to revert:");
		GridDataFactory.fillDefaults().applyTo(inputLabel);
		
		input = new Text(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Revert");
		GridDataFactory.defaultsFor(button).applyTo(button);
		
		Label outputLabel = new Label(parent, SWT.NONE);
		outputLabel.setText("Inverted String:");
		GridDataFactory.fillDefaults().applyTo(outputLabel);
		
		output = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(output);
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				output.setText(StringInverter.invert(input.getText()));
			}
		});

		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR
						|| e.keyCode == SWT.KEYPAD_CR) {
					output.setText(StringInverter.invert(input.getText()));
				}
			}
		});
	}
	
	@Inject
	@Optional
	public void setTextColor(
			@Preference(nodePath = "de.codecentric.eclipse.tutorial.inverter", value = "inverter_color") String color) {
		
		Color toUse = "blue".equals(color) ? 
				Display.getDefault().getSystemColor(SWT.COLOR_BLUE) : Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		
		if (input != null && !input.isDisposed()) {
			input.setForeground(toUse);
		}
		
		if (output != null && !output.isDisposed()) {
			output.setForeground(toUse);
		}
	}

}