public class Main {
    public static void main(String[] args) {
        // Создаем отдел IT
        Employee kozlov = new Employee("Козлов", null); // Сначала без отдела
        Department itDepartment = new Department("IT", kozlov);

        // Создаем сотрудников
        Employee petrov = new Employee("Петров", itDepartment);
        Employee sidorov = new Employee("Сидоров", itDepartment);

        // Привязываем отдел ко всем сотрудникам
        kozlov = new Employee("Козлов", itDepartment); // Обновляем козлова с отделом (он главный)

        // Выводим текстовое представление сотрудников
        System.out.println(petrov);
        System.out.println(sidorov);
        System.out.println(kozlov);
    }
}