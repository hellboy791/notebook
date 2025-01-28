package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.service.ServiceProvider;
import by.stepanenko.notebook.service.NotebookService;
import java.util.List;

public class GetNotesByContent implements Command {
    private final ServiceProvider serviceProvider = ServiceProvider.getInstance();
    private final NotebookService service = serviceProvider.getNotebookService();

    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();
        String[] params;
        List<Note> notes;

        params = request.split("\n");
        notes = service.find(params[1]);

        if (notes != null){
            for (Note n: notes){
                response.append(n.toString()).append("\n");
            }
        }

        if (response.isEmpty()){
            return "Записей не найдено";
        }
        return response.toString();
    }
}
