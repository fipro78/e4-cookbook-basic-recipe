package de.codecentric.eclipse.tutorial.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler {

	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}

}