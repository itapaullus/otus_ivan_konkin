truncate question cascade;
with new_question as
             (
insert
into question (question_text)
values ('What is the biggest planet of solar system?') returning question_id)
insert
into answer (question_id, answer_text, is_correct)
select question_id, 'Mars', false
from new_question
union all
select question_id, 'Jupiter', true
from new_question
union all
select question_id, 'Earth', false
from new_question
union all
select question_id, 'Pluto', false
from new_question
union all
select question_id, 'Venus', false
from new_question;

with new_question as
             (
insert
into question (question_text)
values ('Who was the last Formula1 season winner?') returning question_id)
insert
into answer (question_id, answer_text, is_correct)
select question_id, 'Bottas', false
from new_question
union all
select question_id, 'Leclerc', false
from new_question
union all
select question_id, 'Hamilton', false
from new_question
union all
select question_id, 'Verstappen', true
from new_question;

with new_question as
             (
insert
into question (question_text)
values ('Which sql operator helps to filter results of aggregate function?') returning question_id)
insert
into answer (question_id, answer_text, is_correct)
select question_id, 'distinct', false
from new_question
union all
select question_id, 'where', false
from new_question
union all
select question_id, 'having', true
from new_question
union all
select question_id, 'grouping', false
from new_question
union all
select question_id, 'with', false
from new_question;
