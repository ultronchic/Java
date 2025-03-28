package ru.Balakireva.geometry;
// Обобщенный класс Box
class Box<T> {
    private T item; // Храним объект типа T
    // Метод для добавления объекта в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Сначала извлеките объект.");
        }
        this.item = item; // Помещаем объект в коробку
    }
    // Метод для извлечения объекта из коробки
    public T get() {
        T tempItem = this.item; // Сохраняем ссылку на текущий объект
        this.item = null; // Обнуляем ссылку
        return tempItem; // Возвращаем объект
    }
    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.item == null; // Возвращаем true, если коробка пуста
    }
}

