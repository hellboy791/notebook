package by.stepanenko.notebook.entity;

import by.stepanenko.notebook.controller.Command;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ControllerParams implements Serializable {

    private Command command;
    private LocalDate date;
    private String content;
    private int id;

    public ControllerParams(Command command, LocalDate date, String content, int id) {
        this.command = command;
        this.date = date;
        this.content = content;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllerParams that = (ControllerParams) o;
        return id == that.id && Objects.equals(command, that.command) && Objects.equals(date, that.date) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, date, content, id);
    }

    @Override
    public String toString() {
        return "ControllerParams{" +
                "command=" + command +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
