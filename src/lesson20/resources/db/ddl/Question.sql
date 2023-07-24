create table if not exists question
(
    question_id
    serial
    primary
    key,
    question_text
    varchar
(
    1000
) not null
    );
comment
on table question is 'Список вопросов тестовой системы';
comment
on column question.question_id is 'Уникальный ID вопроса';
comment
on column question.question_text is 'Текст вопроса';
