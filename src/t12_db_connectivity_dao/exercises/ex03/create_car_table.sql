-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE cars (
                      id INT NOT NULL AUTO_INCREMENT,
                      reg VARCHAR(20) NOT NULL,
                      make VARCHAR(40) NOT NULL,
                      model VARCHAR(40) NOT NULL,
                      daily_rate DECIMAL(8,2) NOT NULL,
                      status ENUM('AVAILABLE','RENTED','MAINTENANCE') NOT NULL DEFAULT 'AVAILABLE',
                      PRIMARY KEY (id),
                      UNIQUE KEY uk_cars_reg (reg)
);

CREATE INDEX idx_cars_status ON cars(status);

CREATE TABLE rentals (
                         id INT NOT NULL AUTO_INCREMENT,
                         car_id INT NOT NULL,
                         customer_name VARCHAR(80) NOT NULL,
                         start_date DATE NOT NULL,
                         end_date DATE NOT NULL,
                         status ENUM('OPEN','CLOSED') NOT NULL DEFAULT 'OPEN',
                         PRIMARY KEY (id),
                         CONSTRAINT fk_rentals_car
                             FOREIGN KEY (car_id) REFERENCES cars(id)
                                 ON DELETE RESTRICT
);

CREATE INDEX idx_rentals_status ON rentals(status);
CREATE INDEX idx_rentals_customer ON rentals(customer_name);