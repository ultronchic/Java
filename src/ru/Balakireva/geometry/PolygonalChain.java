package ru.Balakireva.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolygonalChain {

    public static Polyline combinePolylines(LengthMeasurable[] shapes) {
        List<Point> combinedPoints = new ArrayList<>();

        for (LengthMeasurable shape : shapes) {
            Polyline polyline = shape.getPolyline();

            // Добавляем все точки из текущего polyline в общий список
            for (Point point : polyline.getPoints()) {
                combinedPoints.add(point);
            }
        }

        // Создаем новую Polyline с объединенными точками
        return new Polyline(combinedPoints.toArray(new Point[0]));
    }
}