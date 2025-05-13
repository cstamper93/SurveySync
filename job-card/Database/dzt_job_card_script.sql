BEGIN TRANSACTION;

DROP TABLE IF EXISTS job_card, field_entry;

CREATE TABLE job_card(
    id SERIAL,
    job_number INTEGER, --maybe serial?? Probs not but maybe they want to give it the next available job number...
    intake_date DATE,
    client_name VARCHAR(100),
    phone_number VARCHAR(20),
    alt_phone_number VARCHAR(20),
    billing_address VARCHAR(200),
    billing_town VARCHAR(100),
    billing_state VARCHAR(50),
    billing_zip VARCHAR(20),
    client_email VARCHAR(150),
    alt_email VARCHAR(150),
    property_owner_first VARCHAR(100),
    property_owner_last VARCHAR(100),
    job_address VARCHAR(200),
    job_town VARCHAR(100),
    job_state VARCHAR(50),
    job_zip VARCHAR(20),
    deed_book VARCHAR(10),
    deed_page VARCHAR(10),
    map_book VARCHAR(10),
    map_page VARCHAR(10),
    parcel_perimeter INTEGER,
    new_lines_length INTEGER,
    acreage INTEGER,
    job_type VARCHAR(50),
    job_description VARCHAR(7000),
    job_status VARCHAR(50),
    complete_by DATE,
    CONSTRAINT PK_job_card PRIMARY KEY(id)
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