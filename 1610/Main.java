public class Main {
    public static void main(String[] args) {
        // Создаем отдел IT
        Department itDepartment = new Department("IT");

        // Создаем сотрудников
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        Employee sidorov = new Employee("Сидоров");

        // Устанавливаем отдел для сотрудников
        petrov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);

        // Устанавливаем начальника отдела
        itDepartment.setManager(kozlov);

        // Выводим текстовое представление сотрудников
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
    }
}