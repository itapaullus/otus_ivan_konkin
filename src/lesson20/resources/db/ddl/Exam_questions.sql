create table if not exists Exam_questions (
    id serial primary key ,
    exam_id int,
    question_id int,
    is_correct bool,
    foreign key (question_id) references question(question_id),
    foreign key (exam_id) references exam(exam_id)
);
create index if not exists ix_ex_quest_id on Exam_questions (question_id);
create index if not exists ix_ex_exam_id on Exam_questions (exam_id);