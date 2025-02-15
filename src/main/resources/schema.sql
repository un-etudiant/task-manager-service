-- Create the database
CREATE DATABASE task_manager_db;

-- Connect to the newly created database
\c task_manager_db;

-- Create a new user with a password
CREATE USER task_manager_user WITH PASSWORD 'Rushita01';

-- Grant all privileges on the database to the new user
GRANT ALL PRIVILEGES ON DATABASE task_manager_db TO task_manager_user;

-- Set the new user as the owner of the database
ALTER DATABASE task_manager_db OWNER TO task_manager_user;

-- Create the task table
CREATE TABLE task (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);