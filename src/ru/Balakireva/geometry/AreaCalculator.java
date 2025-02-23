package ru.Balakireva.geometry;

import java.util.ArrayList;
import java.util.List;

// Абстрактный класс для базовых фигур
abstract class Shape {
    // Метод для расчета площади фигуры
    public abstract double calculateArea();
}

// Класс Круг
class Circle extends Shape {
    private double radius; // Радиус круга

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Площадь круга
    }
}

// Класс Квадрат
class Square extends Shape {
    private double side; // Сторона квадрата

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side; // Площадь квадрата
    }
}

// Класс Прямоугольник
class Rectangle extends Shape {
    private double width;  // Ширина прямоугольника
    private double height; // Высота прямоугольника

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height; // Площадь прямоугольника
    }
}

// Класс Треугольник
class Triangle extends Shape {
    private double base;   // Основание треугольника
    private double height; // Высота треугольника

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // Площадь треугольника
    }
}

// Класс для расчета общей площади
public class AreaCalculator {

    // Метод для вычисления общей площади
    public static double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0.0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea(); // Вычисляем площадь каждой фигуры и суммируем
        }
        return totalArea;
    }

    /* // Основной метод для тестирования
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        // Добавление нескольких кругов и квадратов
        shapes.add(new Circle(5)); // Круг с радиусом 5
        shapes.add(new Circle(3)); // Круг с радиусом 3
        shapes.add(new Square(4));  // Квадрат со стороной 4
        shapes.add(new Square(2));  // Квадрат со стороной 2

        // Вычисляем общую площадь
        double totalArea = calculateTotalArea(shapes);
        System.out.printf("Общая площадь фигур: %.2f\n", totalArea);
    }
}
*/