DROP TABLE IF EXISTS original_word_list CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS actual_answers CASCADE;
DROP TABLE IF EXISTS all_games CASCADE;

-- Create original word list table
CREATE TABLE original_word_list (
    id SERIAL PRIMARY KEY,
    word VARCHAR(5),
    probability NUMERIC,
    score NUMERIC
);

-- Insert data into original word list table
COPY original_word_list (word, probability, score) FROM
'/[insert file path here]/initialcalculations.txt' DELIMITER ',' CSV;

-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    username VARCHAR(50) UNIQUE
);

-- Create actual answers table--
CREATE TABLE actual_answers (
    id SERIAL PRIMARY KEY,
    date_of_given_answer DATE UNIQUE,
    actual_word VARCHAR(5),
    machine_guesses INT
);

-- Insert actual answers and respective dates data into actual answers table
COPY actual_answers (date_of_given_answer, actual_word) FROM
'/[insert file path here]/date-word-answer.txt' DELIMITER ',' CSV;

-- Create all games played table
CREATE TABLE all_games (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    actual_answers_id INT REFERENCES actual_answers(id),
    guesses_taken INT
);