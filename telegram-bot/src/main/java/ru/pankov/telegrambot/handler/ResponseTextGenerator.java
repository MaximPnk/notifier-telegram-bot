package ru.pankov.telegrambot.handler;

import ru.pankov.common.NotificationDTO;
import ru.pankov.common.NotificationType;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseTextGenerator {

    static String getAddText() {
        return "Приступим к созданию нового уведомления." + System.lineSeparator() + System.lineSeparator() +
                "Выбери из списка интересующую категорию.";
    }

    static String getAddBirthdayNameText() {
        return "Введи имя человека, день рождения которого ты хотел бы добавить";
    }

    static String getAddBirthdayDateText(String name) {
        return "Отлично, давай выберем дату дня рождения для " + name;
    }

    static String getAddEventNameText() {
        return "Введи название события";
    }

    static String getAddEventDateText(String name) {
        return "Отлично, давай выберем дату для события: " + name;
    }

    static String getAddEventHoursText() {
        return "Выбери час уведомления";
    }

    static String getAddEventMinutesText() {
        return "Выбери время уведомления";
    }

    static String getDeleteText(List<NotificationDTO> notifications) {
        if (!notifications.isEmpty()) {
            return ("Дни рождения \uD83E\uDD73" + System.lineSeparator() +
                    notifications.stream().filter(n -> n.getType() == NotificationType.BIRTHDAY).sorted(Comparator.comparing(NotificationDTO::getDate))
                            .map(n ->   "(#" + n.getId() + ") " +
                                        n.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - " +
                                        n.getText())
                            .collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator() + System.lineSeparator() +
                    "События ✅" + System.lineSeparator() +
                    notifications.stream().filter(n -> n.getType() == NotificationType.EVENT).sorted(Comparator.comparing(NotificationDTO::getDate))
                            .map(n ->   "(#" + n.getId() + ") " +
                                        n.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + " - " +
                                        n.getText())
                            .collect(Collectors.joining(System.lineSeparator())));
        } else {
            return "Список уведомлений пуст";
        }
    }

    static String getGetText(List<NotificationDTO> notifications) {
        if (!notifications.isEmpty()) {
            return ("Дни рождения \uD83E\uDD73" + System.lineSeparator() +
                    notifications.stream().filter(n -> n.getType() == NotificationType.BIRTHDAY).sorted(Comparator.comparing(NotificationDTO::getDate))
                            .map(n ->   n.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - " +
                                        n.getText())
                            .collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator() + System.lineSeparator() +
                    "События ✅" + System.lineSeparator() +
                    notifications.stream().filter(n -> n.getType() == NotificationType.EVENT).sorted(Comparator.comparing(NotificationDTO::getDate))
                            .map(n ->   n.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + " - " +
                                        n.getText())
                            .collect(Collectors.joining(System.lineSeparator())));
        } else {
            return "Список уведомлений пуст";
        }
    }

    static String getDeleteSuccessText() {
        return "Уведомление успешно удалено";
    }

    static String getCreateText() {
        return "Уведомление успешно добавлено";
    }

    static String getStartText(String userName) {
        return "Привет, " + userName + "!\uD83D\uDC4B\uD83C\uDFFC" + System.lineSeparator() + System.lineSeparator() +
                "Я твой бот, который поможет тебе никогда не забывать о дне рождения, списке дел или предстоящем мероприятии❗️" + System.lineSeparator() + System.lineSeparator() +
                "Я умею не только запоминать твои важные события, но и напоминать о них заранее✅";
    }

    static String getHelpText() {
        return "Для управления ботом необходимо использовать кнопки, которые заменяют клавиатуру." + System.lineSeparator() + System.lineSeparator() +
                "/return - возврат в главное меню" + System.lineSeparator() + System.lineSeparator() +
                "Вопросы: @your_notify_bot";
    }

    static String getUnsupportedText() {
        return "Пожалуйста, выбери команду из списка" + System.lineSeparator() + System.lineSeparator() +
                "/help - справочная информация";
    }

    static String getReturnText() {
        return "Возврат в главное меню";
    }
}
