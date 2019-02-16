package ru.job4j.calculate.condition;


public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    /**
     * Метод вычисления полупериметра по длинам сторон.
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Периметр.
     */

    public double period(double ab, double ac, double bc) {

        return (ab + ac + bc) / 2;
    }

    /**
     * Вычисление площади треугольника
     * @return площадь треугольника
     */

    public double area() {
        double result = -1.0;
       double ab = a.distanceTo(b);
       double ac = a.distanceTo(c);
       double bc = b.distanceTo(c);
       double perimetr = this.period(ab, ac, bc);
       if (this.exist(ab, ac, bc)) {
          result = Math.sqrt(perimetr * (perimetr - ab) * (perimetr - ac) * (perimetr - bc));
       }
       return result;
    }

    private boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if ((ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab) {
          result = true;
        }
        return result;
    }

}
