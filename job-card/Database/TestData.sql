BEGIN TRANSACTION;

INSERT INTO job_card (intake_date, intake_time, marked_lines_length,
job_description, job_status, complete_by_date) VALUES ('2025-07-23', '12:00:00', 500, 'Mark boundary for fence',
'needs research', '2025-08-15');
INSERT INTO client (first_name, last_name, cell_phone, email, client_notes) VALUES ('Kelly',
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

INSERT INTO job_card (intake_date, intake_time, marked_lines_length,
job_description, job_status, complete_by_date) VALUES ('2025-09-20', '12:00:00', 500, 'Mark boundary for fence',
'needs quote', '2025-10-15');
INSERT INTO client (first_name, last_name, cell_phone, email, client_notes) VALUES ('Ibrahim',
'Moizoos', '111-222-3333', 'moizoosy@url.com', 'East west bowl competitor');
INSERT INTO job_card_client (job_id, client_id) VALUES (2, 2);
INSERT INTO property (owner_first_name, owner_last_name, address, town, state, zip, county, deed_1, map_1, perimeter,
acreage, drive_time, subdivision, pid, pin, prop_notes) VALUES ('Jane', 'Doe', '176 Golfball St', 'Vass', 'NC',
'00000', 'Moore', '1111/2222', '1/100', 500, 0.5, '00:15:00', 'Badgers Ct', '0001111', '987654321', 'house');
INSERT INTO job_card_property (job_id, prop_id) VALUES (2, 2);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (2, 'Division', 10);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (2, 'Recombination', 10);

INSERT INTO job_card (intake_date, intake_time, marked_lines_length,
job_description, job_status, complete_by_date) VALUES ('2025-09-20', '12:00:00', 500, 'Mark boundary for fence',
'ready to call', '2025-10-20');
INSERT INTO client (first_name, last_name, cell_phone, email, client_notes) VALUES ('TJ',
'Juckson', '123-456-7890', 'juckson@moogle.com', 'East west bowl competitor');
INSERT INTO job_card_client (job_id, client_id) VALUES (3, 3);
INSERT INTO property (owner_first_name, owner_last_name, address, town, state, zip, county, deed_1, map_1, perimeter,
acreage, drive_time, pin, prop_notes) VALUES ('TJ', 'Juckson', '1111 Hooplah Lane', 'Raeford', 'NC',
'00000', 'Hoke', '250/17', '21/7', 1000, 2.2, '00:45:00', '210321432', 'briars');
INSERT INTO job_card_property (job_id, prop_id) VALUES (3, 3);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (3, 'EPS', 17);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (3, 'Site Plan', 0);

INSERT INTO job_card (intake_date, intake_time, marked_lines_length,
job_description, job_status, complete_by_date) VALUES ('2025-09-20', '12:00:00', 500, 'Mark boundary for fence',
'ready to send', '2025-10-15');
INSERT INTO client (first_name, last_name, cell_phone, email, client_notes) VALUES ('Dmarcus',
'Jilliums', '311-511-6111', 'dmarc@gahoo.com', 'East west bowl competitor');
INSERT INTO job_card_client (job_id, client_id) VALUES (4, 4);
INSERT INTO property (owner_first_name, owner_last_name, address, town, state, zip, county, deed_1, map_1, perimeter,
acreage, drive_time, pin, prop_notes) VALUES ('Slim', 'Jim', '502 Deer Trail', 'Lillington', 'NC',
'00000', 'Harnett', '2121/43', '20/713', 607, 1.3, '00:51:00', '787878788', 'Swampy');
INSERT INTO job_card_property (job_id, prop_id) VALUES (4, 4);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (4, 'Recombination', 12);
INSERT INTO job_type (job_id, job_type, estimated_field_hours) VALUES (4, 'FS', 8);

COMMIT TRANSACTION;