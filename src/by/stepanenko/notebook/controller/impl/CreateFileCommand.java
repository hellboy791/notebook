package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;

public class CreateFileCommand implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(String request) {
        service.createNewFile();
        return "Блокнот создан";
    }
}
