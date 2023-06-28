create table if not exists Exam (
    exam_id serial primary key ,
    username    varchar(50),
    correct_answers int,
    total_answers int
);
comment on table Exam is 'Таблица сеансов тестирования и результатов';
comment on column Exam.exam_id is 'Уникальный ID сеанса';
comment on column Exam.username is 'Имя пользователя';
comment on column Exam.correct_answers is 'Кол-во верных ответов';
comment on column Exam.total_answers is 'Общее кол-во вопросов';