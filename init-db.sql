-- Create schemas for microservices
CREATE SCHEMA IF NOT EXISTS book;
CREATE SCHEMA IF NOT EXISTS "order";

-- Grant permissions
GRANT ALL PRIVILEGES ON SCHEMA book TO postgres;
GRANT ALL PRIVILEGES ON SCHEMA "order" TO postgres; 