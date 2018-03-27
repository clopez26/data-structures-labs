package menuClasses;

import dataManager.DMComponent;
import ioManagementClasses.IOComponent;

public class DeleteFromListAction implements Action {

	@Override
	public void execute(Object args) {
		DMComponent dm = (DMComponent) args; 
		IOComponent io = IOComponent.getComponent();
		io.output("\nRemoving a list of Integer values from the the system:\n");
		String listName = io.getInput("\nEnter the name of the list to remove: "); 
		dm.removeList(listName);

	}

}
