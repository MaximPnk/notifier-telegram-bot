DROP TABLE IF EXISTS chat_session;

CREATE TABLE chat_session (
    chat_id bigint primary key,
    user_session_stage_id int NOT NULL
);