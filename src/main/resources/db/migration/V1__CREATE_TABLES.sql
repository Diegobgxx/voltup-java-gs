CREATE TABLE tb_user_voltup
(
    id         VARCHAR(32) PRIMARY KEY NOT NULL,
    first_name VARCHAR(255)            NOT NULL,
    last_name  VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL UNIQUE,
    password   VARCHAR(255)            NOT NULL,
    created_at DATETIME                NOT NULL,
    updated_at DATETIME                NOT NULL,
    deleted_at DATETIME DEFAULT NULL
);

CREATE TABLE tb_connector_type
(
    id VARCHAR(32) PRIMARY KEY NOT NULL,
    name VARCHAR(55) NOT NULL
);

CREATE TABLE tb_station
(
    id       VARCHAR(32) PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    address  VARCHAR(255) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    power DOUBLE NOT NULL,
    operator VARCHAR(255) NOT NULL
);

CREATE TABLE tb_connector_type_station
(
    connector_type_id VARCHAR(32) NOT NULL,
    station_id        VARCHAR(32) NOT NULL,
    PRIMARY KEY (connector_type_id, station_id),
    FOREIGN KEY (connector_type_id) REFERENCES tb_connector_type (id),
    FOREIGN KEY (station_id) REFERENCES tb_station (id)
);

CREATE TABLE tb_vehicle
(
    id                VARCHAR(32) PRIMARY KEY NOT NULL,
    model             VARCHAR(255)            NOT NULL,
    brand             VARCHAR(255)            NOT NULL,
    km_range DOUBLE NOT NULL,
    connector_type_id VARCHAR(32) FOREIGN KEY REFERENCES tb_connector_type(id),
    user_id           VARCHAR(32) FOREIGN KEY REFERENCES tb_user_voltup(id)
);

