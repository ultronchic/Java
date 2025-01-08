public class Main {
    public static void main(String[] args) {
        // Создание отдела IT
        Department itDepartment = new Department("IT", null);

        // Создание сотрудников
        Employee petrov = new Employee("Петров", itDepartment);
        Employee kozlov = new Employee("Козлов", itDepartment);
        Employee sidorov = new Employee("Сидоров", itDepartment);

        // Установка Козлова начальником IT отдела
        itDepartment = new Department("IT", kozlov);
        petrov = new Employee("Петров", itDepartment);
        kozlov = new Employee("Козлов", itDepartment);
        sidorov = new Employee("Сидоров", itDepartment);

        // Вывод информации о сотрудниках
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
    }
}