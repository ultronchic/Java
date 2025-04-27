package ru.Balakireva.others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class AnnotationUtilsTest {

    private AnnotationUtils annotationUtils;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        annotationUtils = new AnnotationUtils();
        applicationContext = Mockito.mock(ApplicationContext.class);
        // Внедряем мок ApplicationContext в AnnotationUtils
        ReflectionTestUtils.setField(annotationUtils, "applicationContext", applicationContext);
    }

    @Test
    public void testResetWithClassAnnotation() {
        // Создаем объект с аннотацией Default
        MyService myService = new MyService();

        // Мок бина, который будет возвращен из контекста
        MyDependency myDependencyMock = new MyDependency();
        when(applicationContext.getBean("myBean")).thenReturn(myDependencyMock);

        // Вызываем метод reset
        annotationUtils.reset(myService);

        // Проверяем, что поле myDependency было установлено
        assertNotNull(myService.getMyDependency());
        assertEquals(myDependencyMock, myService.getMyDependency());
    }

    @Test
    public void testResetWithFieldAnnotation() {
        // Создаем объект с аннотацией Default на поле
        AnotherService anotherService = new AnotherService();

        // Мок бина, который будет возвращен из контекста
        MyDependency myDependencyMock = new MyDependency();
        when(applicationContext.getBean("anotherBean")).thenReturn(myDependencyMock);

        // Вызываем метод reset
        annotationUtils.reset(anotherService);

        // Проверяем, что поле myField было установлено
        assertNotNull(anotherService.getMyField());
        assertEquals(myDependencyMock, anotherService.getMyField());
    }
}