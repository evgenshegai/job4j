package ru.job4j.calculate.condition;

/** Test.
 *
 * @author EvgeniiShegai (evgeniishegai@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DummyBotTest {

    @Test
    public void whenBotSayHi() {
        DummyBot dummyBot = new DummyBot();
        String answer = dummyBot.answer("Привет Боб");
        assertThat(answer, is("Привет умник"));
    }

    @Test
    public void whenBotSayBye() {
        DummyBot dummyBot = new DummyBot();
        String answer = dummyBot.answer("Пока");
        assertThat(answer, is("До скорой встречи"));
    }

    @Test
    public void whenBotDontKnow() {
        DummyBot dummyBot = new DummyBot();
        String answer = dummyBot.answer("Как тебя звать ?");
        assertThat(answer, is("Это ставит меня в тупик. Задайте другой ввопрос."));
    }
}