--ROLES
INSERT INTO roles (type) VALUES ('ADMIN');
INSERT INTO roles (type) VALUES ('USER');

--PATIENTS
INSERT INTO public.patients(dni, firstname, lastname, numberclinicalhistory) VALUES ('6223215', 'juan', 'ramos', '123');

INSERT INTO public.patients(dni, firstname, lastname, numberclinicalhistory) VALUES ('84422554', 'carlos', 'laos', '654');

INSERT INTO public.patients(dni, firstname, lastname, numberclinicalhistory) VALUES ('6542254', 'gabriel', 'Bautista', '959');
	

--SPECIALTIES
INSERT INTO public.specialties(name) VALUES ('Administrador');

INSERT INTO public.specialties(name) VALUES ('Odontólogo');
	
INSERT INTO public.specialties(name) VALUES ('Radiólogo');
	
INSERT INTO public.specialties(name) VALUES ('Ginecólogo');
	
INSERT INTO public.specialties(name) VALUES ('Anesteciólogo');
	
INSERT INTO public.specialties(name) VALUES ('Cirujano');
	
INSERT INTO public.specialties(name) VALUES ('Médico General');
	

--DOCTORS
INSERT INTO public.doctors( cmp, dni, firstname, lastname, specialty_id) VALUES ('000', '00000000', 'admin', 'admin', 1);
INSERT INTO public.users(id, password, state, username)	VALUES ('1', '$2a$10$tHDids9BodGtc9sXkD8LxOvFH5Vad5qMo7yfl.DU8Oz4Jvh1qBUVa', 'A', 'admin');
INSERT INTO public.user_roles(rol_id, user_id) VALUES ('1', '1');

INSERT INTO public.doctors( cmp, dni, firstname, lastname, specialty_id) VALUES ('520', '75564821', 'Robert', 'Castillo', 2);
INSERT INTO public.users(id, password, state, username)	VALUES ('2', '$2a$10$tHDids9BodGtc9sXkD8LxOvFH5Vad5qMo7yfl.DU8Oz4Jvh1qBUVa', 'A', 'robert');
INSERT INTO public.user_roles(rol_id, user_id) VALUES ('2', '2');

INSERT INTO public.doctors( cmp, dni, firstname, lastname, specialty_id) VALUES ('111', '51651317', 'frank', 'menendez', 2);
INSERT INTO public.users(id, password, state, username)	VALUES ('3', '$2a$10$tHDids9BodGtc9sXkD8LxOvFH5Vad5qMo7yfl.DU8Oz4Jvh1qBUVa', 'A', 'frank');
INSERT INTO public.user_roles(rol_id, user_id) VALUES ('2', '3');

INSERT INTO public.doctors( cmp, dni, firstname, lastname, specialty_id) VALUES ('203', '84255478', 'Luis', 'Andoval', 3);
INSERT INTO public.users(id, password, state, username)	VALUES ('4', '$2a$10$tHDids9BodGtc9sXkD8LxOvFH5Vad5qMo7yfl.DU8Oz4Jvh1qBUVa', 'A', 'luis');
INSERT INTO public.user_roles(rol_id, user_id) VALUES ('2', '4');

INSERT INTO public.doctors( cmp, dni, firstname, lastname, specialty_id) VALUES ('458', '45655263', 'Angel', 'Fernandez', 4);
INSERT INTO public.users(id, password, state, username)	VALUES ('5', '$2a$10$tHDids9BodGtc9sXkD8LxOvFH5Vad5qMo7yfl.DU8Oz4Jvh1qBUVa', 'A', 'angel');
INSERT INTO public.user_roles(rol_id, user_id) VALUES ('2', '5');
	
COMMIT;