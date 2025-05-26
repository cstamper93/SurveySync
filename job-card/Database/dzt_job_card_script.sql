BEGIN TRANSACTION;

DROP TABLE IF EXISTS job_card, field_entry;

CREATE TABLE job_card(
    job_id SERIAL,
    prospect_id VARCHAR(100)
    active_job_id INTEGER,
    intake_date DATE,
    intake_time TIMESTAMP,
    marked_lines_length INTEGER,
    job_description VARCHAR(7000),
    house_plan_name VARCHAR(100),
    job_status VARCHAR(50),
    complete_by DATE,
    CONSTRAINT PK_job_card PRIMARY KEY(job_id)
);

CREATE TABLE client(
    client_id SERIAL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    company VARCHAR(100),
    cell_phone_number VARCHAR(25),
    home_phone_number VARCHAR(25),
    work_phone_number VARCHAR(25),
    billing_address VARCHAR(250),
    billing_town VARCHAR(50),
    billing_state VARCHAR(15),
    billing_zip VARCHAR(15),
    client_email VARCHAR(100),
    alt_email VARCHAR(100),
    client_notes VARCHAR(7000),
    CONSTRAINT PK_client PRIMARY KEY(client_id)
);

CREATE TABLE field_entry(
    job_id INTEGER,
    job_number INTEGER,
    crew_name_1 VARCHAR(100),
    crew_name_2 VARCHAR(100),
    crew_name_3 VARCHAR(100),
    entry_date DATE,
    hours_worked INTEGER,
    minutes_worked INTEGER,
    CONSTRAINT PK_field_entry PRIMARY KEY(job_id, entry_date, crew_name_1),
    CONSTRAINT FK_id_field_entry_job_card FOREIGN KEY (job_id) REFERENCES job_card(id)
);

COMMIT;