package by.stepanenko.notebook.dao.impl;

import by.stepanenko.notebook.dao.DAOException;
import by.stepanenko.notebook.entity.Note;
import by.stepanenko.notebook.utils.IDGenerator;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockSource {

    private static MockSource instance;
    public MockSource(){}

    public static MockSource getInstance() {
        if (instance == null){
            instance = new MockSource();
        }
        instance.getAllNotes(); //получаем список всех записей при инициализации ??????????
        return instance;
    }

    private static List<Note> notes;// = new ArrayList<>();

    private final String filePath = System.getProperty("user.home") + "/NoteBook.txt"; //"D:/NoteBook.txt";
    private final String sep = ";"; //разделитель между колонками
    private final String sepForNotes = "\n"; //разделитель между записями

    public void createNewFile(){
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNote(Note note) {
        notes.add(note);
        //return "Запись успешно добавлена";
    }

    public void save() {
        FileWriter writer = null;
        File file = new File(filePath);

        //если файла нет, то создаем чтоб не потерять при выходе все записи что добавили
        if (!file.exists()){
            createNewFile();
        }

        if (file.exists()){
            try {
                writer = new FileWriter(filePath, false);
                for (Note note: notes){
                    writer.write(note.getDate().toString() + sep + note.getContent() + sepForNotes);
                }
                writer.close();

                //return "Все изменения успешно обновлены";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }// else return "Блокнот не существует. Для добавления записей создайте новый блокнот";
    }

    public List<Note> getAllNotes(){
        String[] ts;
        File file = new File(filePath);
        if (file.exists()){
            if (notes == null){
                notes = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String strCurrentLine;
                    while ((strCurrentLine = reader.readLine()) != null){
                        ts = strCurrentLine.split(sep);
                        notes.add(new Note(IDGenerator.getNextId(), LocalDate.parse(ts[0]), ts[1]));
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return notes;
    }

    public void updateNoteByID(int id, String newValue){
        if (id > notes.size()){
            throw new RuntimeException("Cannot find note with id " + id);
        }
        Note note = notes.get(id);
        if (note != null){
            note.setContent(newValue);
        } else {
            throw new RuntimeException("Cannot find note with id " + id);
        }
    }

}
