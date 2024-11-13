INSERT INTO tb_connector_type (id, name) VALUES ('f7e68662-b83e-42e4-8aa3-b656dad50427', 'Type 1');

INSERT INTO tb_connector_type (id, name) VALUES ('9569448a-1a7b-4806-816b-c76a56ca6303', 'Type 2');

INSERT INTO tb_station (id, name, address, latitude, longitude, power, operator) VALUES ('e3bdf3f3-7f43-413d-945c-708a1e01371c', 'Station A', '123 Main St', 40.7128, -74.0060, 50, 'Company A');

INSERT INTO tb_station (id, name, address, latitude, longitude, power, operator) VALUES ('d5f64c7c-1e64-4883-b124-34bc8026af57', 'Station B', '456 Elm St', 34.0522, -118.2437, 100, 'Company B');

INSERT INTO tb_connector_type_station (connector_type_id, station_id) VALUES ('f7e68662-b83e-42e4-8aa3-b656dad50427', 'e3bdf3f3-7f43-413d-945c-708a1e01371c');

INSERT INTO tb_connector_type_station (connector_type_id, station_id) VALUES ('9569448a-1a7b-4806-816b-c76a56ca6303', 'd5f64c7c-1e64-4883-b124-34bc8026af57');

INSERT INTO tb_user_voltup (id, first_name, last_name, email, passwo d, created_at, updated_at) VALUES ('bf83a112-52e6-42c9-90f0-56af62293478', 'John', 'Doe', 'johndoe@example.com', 'password123', NOW(), NOW());

INSERT INTO tb_user_voltup (id, first_name, last_name, email, password, created_at, updated_at) VALUES ('2de1ee3f-dcae-4f7f-bed3-a3cde06e8705', 'Jane', 'Smith', 'janesmith@example.com', 'password456', NOW(), NOW());

INSERT INTO tb_vehicle (id, model, brand, km_range, connector_type_id, user_id) VALUES ('995497fd-4552-470d-a671-dc44686b6d2c', 'Model 3', 'Tesla', 400, 'f7e68662-b83e-42e4-8aa3-b656dad50427', 'bf83a112-52e6-42c9-90f0-56af62293478');

INSERT INTO tb_vehicle (id, model, brand, km_range, connector_type_id, user_id) VALUES ('60f9c0ca-c2d9-446f-9e74-4ad4fb6e0aad', 'Bolt EV', 'Chevrolet', 320, '9569448a-1a7b-4806-816b-c76a56ca6303', '2de1ee3f-dcae-4f7f-bed3-a3cde06e8705');