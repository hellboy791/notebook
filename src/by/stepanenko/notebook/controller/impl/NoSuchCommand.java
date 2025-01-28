package by.stepanenko.notebook.controller.impl;

import by.stepanenko.notebook.controller.Command;

public class NoSuchCommand implements Command {

	@Override
	public String execute(String request) {
		return "Ошибка запроса";
	}

}
