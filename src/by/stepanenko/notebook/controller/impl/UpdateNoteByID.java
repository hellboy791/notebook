package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.service.NotebookService;
import by.stepanenko.notebook.service.ServiceProvider;

public class UpdateNoteByID implements Command {

    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(String request) {
        String[] params;
        params = request.split("\n");

        service.updateNoteByID(Integer.parseInt(params[1]), params[2]);
        return "Запись обновлена";
    }
}