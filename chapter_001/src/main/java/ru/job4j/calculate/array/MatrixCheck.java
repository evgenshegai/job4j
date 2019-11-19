package ru.job4j.calculate.array;

/**
 * Квадратный массив заполнен true or false по диагоналям 1 решение
 * Квадратный массив заполнен крестиками правильно или нет 2 решение
 * @author Evgenii Shegay(evgeniishegai@yandex.ru)
 *  @version $Id$
 *  @since 0.1
 */

public class MatrixCheck {


   /* public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
                if ((data[i][i] != data[i + 1][i + 1]) || (data[i][data.length - i - 1] != (data[i + 1][data.length - i - 2])))  {
                    result = false;
                    break;
                }
        }
        return result;
    }*/

    /**
     * метод определяет выиграл пользователь или нет
     * @param board массив символов
     * @return true or false смотря какой результат
     */
    public  static boolean isWin(char[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char sign = board[i][j];
                int count = 0;
                  if (sign == 'X' && i == 0) {
                      while (i < board.length - 1) {

                          if (sign == board[i++][j]) {
                              count++;
                          }
                          if (count == 4) {
                              result = true;
                          }
                      }
                      } else if (sign == 'X' && j == 0) {
                      while (j < board.length - 1) {
                          if (sign == board[i][j++]) {
                              count++;
                          }
                          if (count == 4) {
                              result = true;
                          }
                      }
                  }
                  }
                }
            return result;
        }
    }

