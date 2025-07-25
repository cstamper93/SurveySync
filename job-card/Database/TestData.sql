BEGIN TRANSACTION;

INSERT INTO job_card (intake_date, intake_time, marked_lines_length,
job_description, job_status, complete_by_date) VALUES ('2025-07-23', '12:00:00', 500, 'Mark boundary for fence',
'ready for quote', '2025-08-15');

INSERT INTO client (first_name, last_name, cell_phone_number, client_email, client_notes) VALUES ('Kelly',
'Mooris', '910-111-2222', 'nobody@url.com', 'Client is smelly');

INSERT INTO job_card_client (job_id, client_id) VALUES (1, 1);

INSERT INTO property (owner_first_name, owner_last_name, address, town, state, zip, county, deed_1, map_1, perimeter,
acreage, drive_time, subdivision, pid, pin, prop_notes) VALUES ('John', 'Doe', '123 Street Ave', 'Pinehurst', 'NC',
'00000', 'Moore', '1111/2222', '1/100', 500, 0.5, '00:15:00', 'Number 7', '0001111', '987654321', 'vacant');

INSERT INTO job_card_property (job_id, prop_id) VALUES (1, 1);

INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (1, 'FS', 4);

INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (1, 'EPS', 6);

INSERT INTO job_note (note_content, date_created, time_created, job_id) VALUES ('Do this job well...', '2025-07-24',
'12:30:30', 1);

INSERT INTO contact (date, time, job_id, client_id, method, description) VALUES ('2025-07-24', '02:46:55', 1,
1, 'phone', 'Asked why we havent finished the job yet');

COMMIT TRANSACTION;