# Условие задачи

## Задание:

1. Написать Rest-контроллеры для вашего приложения.
2. Переписать вывод (заполнение) таблицы, модальных окон и т.д. на JS c помощью Fetch API, допускается использование JQuery.
3. При любых изменениях данных страница приложения не должна перезагружаться!

## Функциональность

- После аутентификации админ попадает на страницу /admin, а юзер на его страницу /user.
- Все действия админа доступны по адресу /admin/**
- Пользователь может видеть только свою страничку по ссылке /user

## Инструкция по установке и запуску

1. Склонируйте репозиторий
2. В файле main -> resources -> application.properties укажите свои данные БД
3. В БД должно быть 3 таблицы, Person(поля: name, lastname, age, password), Role (поля: ADMIN, USER), USER_ROLE (поля: user_id, role_id)
4. Запустите SpringBootAppApplication
5. Перейдите по ссылке http://localhost:8080