CREATE DATABASE IF NOT EXISTS TRANSPORTAPP;
	
	CREATE TABLE IF NOT EXISTS TRANSPORTAPP.ADDRESS (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  address_line_1 VARCHAR(100) NOT NULL ,
	  address_line_2 VARCHAR(100) ,
	  address_line_3 VARCHAR(100) ,
	  city VARCHAR(50) ,
	  district VARCHAR(100) ,
	  postal_code VARCHAR(8) ,
	  state VARCHAR(100) ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP);
	  
	  
	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.TRANSPORTER (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  full_name VARCHAR(150) NOT NULL ,
	  address_id INT,
	  country_code VARCHAR(5) ,
	  land_line_phone_no VARCHAR(15) ,
	  mobile_no VARCHAR(10) ,
	  email VARCHAR(100) ,
	  tin_no VARCHAR(11) ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP,
	  FOREIGN KEY (address_id) REFERENCES ADDRESS(id) );
	  
	  
	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.VEHICLE_OWNER (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  full_name VARCHAR(150) NOT NULL ,
	  address_id INT ,
	  country_code VARCHAR(5) ,
	  land_line_phone_no VARCHAR(10) ,
	  mobile_no VARCHAR(10) ,
	  email VARCHAR(100) ,
	  pan_no VARCHAR(10) ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP,
	  FOREIGN KEY (address_id) REFERENCES ADDRESS(id));
	  
	  
	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.JOB_DETAILS (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  transporter_id INT NOT NULL ,
	  consignment_to_location VARCHAR(100) ,
	  consignment_from_location VARCHAR(100) ,
	  vehicle_types_required VARCHAR(500) ,
	  consignment_size VARCHAR(10) ,
	  rate_per_km VARCHAR(100) ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP,
	  FOREIGN KEY (transporter_id) REFERENCES TRANSPORTER(id));
	  

	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.VEHICLE (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  type VARCHAR(50) ,
	  capacity VARCHAR(10) ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP);
	  
	  
	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.OWNER_VEHICLE_MAPPING (
	  vehicle_owner_id INT NOT NULL ,
	  vehicle_id INT NOT NULL ,
	  license_plate_no VARCHAR(15) PRIMARY KEY,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP,
	  FOREIGN KEY (vehicle_owner_id) REFERENCES VEHICLE_OWNER(id),
	  FOREIGN KEY (vehicle_id) REFERENCES VEHICLE(id));
	  
	  
	CREATE  TABLE IF NOT EXISTS TRANSPORTAPP.TRANSACTIONS (
	  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	  job_id INT NOT NULL ,
	  vehicle_owner_id INT ,
	  consignment_size_accepted VARCHAR(10) ,
	  transporter_commission DOUBLE ,
	  owner_commission DOUBLE ,
	  total_value DOUBLE ,
	  created_on TIMESTAMP,
	  last_modified_by VARCHAR(100) ,
	  last_modified_on TIMESTAMP,
	  FOREIGN KEY (job_id) REFERENCES JOB_DETAILS(id),
	  FOREIGN KEY (vehicle_owner_id) REFERENCES VEHICLE_OWNER(id));