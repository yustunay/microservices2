-- Create the database
CREATE DATABASE customer;
CREATE DATABASE fraud;
CREATE DATABASE notification;

-- Create the role
-- CREATE ROLE yustunay WITH LOGIN PASSWORD 'password';

-- Grant privileges to the role
GRANT ALL PRIVILEGES ON DATABASE customer TO yustunay;
GRANT ALL PRIVILEGES ON DATABASE fraud TO yustunay;
GRANT ALL PRIVILEGES ON DATABASE notification TO yustunay;
