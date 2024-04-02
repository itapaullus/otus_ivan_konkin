create table if not exists answer
(
    answer_id
    serial
    primary
    key,
    question_id
    integer
    not
    null,
    answer_text
    varchar
(
    1000
) not null,
    is_correct bool,
    foreign key
(
    question_id
) references question
(
    question_id
)
    );
create index if not exists ix_answer_question on answer (question_id);
comment
on table answer is 'Наборы ответов на вопросы';
comment
on column answer.answer_id is 'Уникальный ID ответа';
comment
on column answer.question_id is 'Ссылка на Question.question_id';
comment
on column answer.answer_text is 'Текст ответа';
comment
on column answer.is_correct is 'Признак верного ответа';
