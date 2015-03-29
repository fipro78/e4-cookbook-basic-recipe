package de.codecentric.eclipse.tutorial.inverter.part;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.codecentric.eclipse.tutorial.inverter.helper.StringInverter;

public class InverterPart {
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, true));
		
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText("String to revert:");
		GridDataFactory.fillDefaults().applyTo(inputLabel);
		
		final Text input = new Text(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Revert");
		GridDataFactory.defaultsFor(button).applyTo(button);
		
		Label outputLabel = new Label(parent, SWT.NONE);
		outputLabel.setText("Inverted String:");
		GridDataFactory.fillDefaults().applyTo(outputLabel);
		
		// add FXCanvas for adding JavaFX controls to the UI
		FXCanvas canvas = new FXCanvas(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).span(3, 1).applyTo(canvas);

		// create the root layout pane
		BorderPane layout = new BorderPane();
        
        // create a Scene instance
        // set the layout container as root
        // set the background fill to the background color of the shell
        Scene scene = new Scene(layout, Color.rgb(
                parent.getShell().getBackground().getRed(),
                parent.getShell().getBackground().getGreen(),
                parent.getShell().getBackground().getBlue()));
		
        // set the Scene to the FXCanvas
        canvas.setScene(scene);

        javafx.scene.control.Label output = new javafx.scene.control.Label();
        layout.setCenter(output);
        
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), output);
        rotateTransition.setByAngle(360);
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), output);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(4.0);
        scaleTransition.setToY(4.0);
        
        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, scaleTransition);
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				output.setText(StringInverter.invert(input.getText()));
				parallelTransition.play();
			}
		});

		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR
						|| e.keyCode == SWT.KEYPAD_CR) {
					output.setText(StringInverter.invert(input.getText()));
					parallelTransition.play();
				}
			}
		});
	}
}