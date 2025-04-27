package ru.Balakireva.others;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DefaultValuesPostProcessor implements BeanPostProcessor {

    private final AnnotationUtils annotationUtils;

    public DefaultValuesPostProcessor(AnnotationUtils annotationUtils) {
        this.annotationUtils = annotationUtils;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        annotationUtils.reset(bean); // Вызываем reset для каждого бина
        return bean; // Возвращаем измененный или неизмененный бин
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean; // Не изменяем бин после инициализации
    }
}