 
package org.fipro.eclipse.tutorial.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.fipro.e4.service.preferences.ContributedPreferenceNode;
import org.fipro.e4.service.preferences.PrefMgr;

public class PreferenceHandler {
	
	@Execute
	public void execute(Shell shell, @PrefMgr PreferenceManager manager) {
		
		PreferenceDialog dialog = new PreferenceDialog(shell, manager) {
			@Override
			protected TreeViewer createTreeViewer(Composite parent) {
				TreeViewer viewer = super.createTreeViewer(parent);
				
				viewer.setComparator(new ViewerComparator() {
					
					public int category(Object element) {
						// this ensures that the General preferences page is always on top
						// while the other pages are ordered alphabetical
						if (element instanceof ContributedPreferenceNode
								&& ("general".equals(((ContributedPreferenceNode) element).getId()))) {
							return -1;
						}
				        return 0;
				    }
					
				});
				
				return viewer;
			}
		};
		
		dialog.open();
	}
		
}