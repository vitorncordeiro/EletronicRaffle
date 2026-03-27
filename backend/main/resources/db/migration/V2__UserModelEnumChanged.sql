ALTER TABLE user_model MODIFY role VARCHAR(20);

UPDATE user_model SET role = 'ADMIN' WHERE role = 0;
UPDATE user_model SET role = 'USER' WHERE role = 1;