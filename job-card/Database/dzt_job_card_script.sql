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

CREATE TABLE job_card_client(
    job_id INTEGER NOT NULL,
    client_id INTEGER NOT NULL,
    CONSTRAINT PK_job_card_client PRIMARY KEY(job_id, client_id),
    CONSTRAINT FK_job_id FOREIGN KEY(job_id) REFERENCES job_card(job_id),
    CONSTRAINT FK_client_id FOREIGN KEY(client_id) REFERENCES client(client_id)
);

CREATE TABLE property(
    prop_id SERIAL,
    owner_first_name VARCHAR(100),
    owner_last_name VARCHAR(100),
    address VARCHAR(250),
    town VARCHAR(50),
    state VARCHAR(15),
    zip VARCHAR(15),
    county VARCHAR(100),
    deed_1 VARCHAR(25),
    deed_2 VARCHAR(25),
    deed_3 VARCHAR(25),
    map_1 VARCHAR(25),
    map_2 VARCHAR(25),
    map_3 VARCHAR(25),
    perimeter INTEGER,
    acreage NUMERIC(5,2),
    drive_time TIME,
    subdivision VARCHAR(50),
    pid VARCHAR(50),
    pin VARCHAR(50),
    township VARCHAR(100),
    lot_num VARCHAR(15),
    prop_notes VARCHAR(7000),
    CONSTRAINT PK_property PRIMARY KEY(prop_id)
);

CREATE TABLE job_card_property(
    job_id INTEGER NOT NULL,
    prop_id INTEGER NOT NULL,
    CONSTRAINT PK_job_card_property PRIMARY KEY(job_id, prop_id),
    CONSTRAINT FK_job_id FOREIGN KEY(job_id) REFERENCES job_card(job_id),
    CONSTRAINT FK_prop_id FOREIGN KEY(prop_id) REFERENCES property(prop_id)
);

CREATE TABLE job_note(
    job_note_id SERIAL,
    note_content VARCHAR(7000),
    user_id INTEGER,
    date_created DATE,
    time_created TIME,
    job_id INTEGER,
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