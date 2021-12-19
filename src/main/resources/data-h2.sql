INSERT INTO roles(ROLE_ID, name) VALUES (1, 'USER');
INSERT INTO roles(ROLE_ID, name) VALUES (2, 'ADMIN');

INSERT INTO APPUSER(USER_ID, username, password, enabled) VALUES (1, 'patrick', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', '1');
INSERT INTO APPUSER(USER_ID, username, password, enabled) VALUES (2, 'alex', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', '1');
INSERT INTO APPUSER(USER_ID, username, password, enabled) VALUES (3, 'john', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', '1');
INSERT INTO APPUSER(USER_ID, username, password, enabled) VALUES (4, 'namhm', '$2a$10$GQT8bfLMaLYwlyUysnGwDu6HMB5G.tin5MKT/uduv2Nez0.DmhnOq', '1');
INSERT INTO APPUSER(USER_ID, username, password, enabled) VALUES (5, 'admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1); -- user patrick has role USER
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2); -- user alex has role ADMIN
INSERT INTO users_roles (user_id, role_id) VALUES (3, 1); -- user john has role USER
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2); -- user namhm has role ADMIN
INSERT INTO users_roles (user_id, role_id) VALUES (4, 1); -- user namhm has role USER
INSERT INTO users_roles (user_id, role_id) VALUES (5, 2); -- user admin has role ADMIN