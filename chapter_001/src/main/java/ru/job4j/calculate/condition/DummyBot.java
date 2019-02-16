package ru.job4j.calculate.condition;

/**
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 * @version $Id$
 *  @since 0.1
 */

public class DummyBot {

/**
 * Отвечает на вопросы
 * @param question - вопрос от клиента
 * @return ответ
 */

  public String answer(String question) {

      String result = "Это ставит меня в тупик. Задайте другой ввопрос.";
      if ("Привет Боб".equals(question)) {
          result = "Привет умник";
      } else if ("Пока".equals(question)) {
          result = "До скорой встречи";
      }
      return result;
  }

}
