package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;
import by.stepanenko.notebook.utils.SymbolsValidator;

public class AddNoteCommand implements Command {
	
	private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private final NotebookService service = serviceProvider.getNotebookService();

	@Override
	public String execute(String request) {

		String[] params;
		Note newNote;
		SymbolsValidator symbolsValidator = new SymbolsValidator();

		// validate request
		params = request.split("\n");
		if (symbolsValidator.match(params[1])){
			return "Unsupported symbol";
		}
		newNote = new Note(params[1]);
		service.add(newNote);

		return "Запись добавлена.";
	}

}
