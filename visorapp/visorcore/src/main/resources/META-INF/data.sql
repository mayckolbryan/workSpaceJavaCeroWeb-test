--PATIENTS
INSERT INTO public.patients(id, dni, firstname, lastname, numberclinicalhistory) VALUES (1, '6223215', 'juan', 'ramos', '123');

INSERT INTO public.patients(id, dni, firstname, lastname, numberclinicalhistory) VALUES (2, '84422554', 'carlos', 'laos', '654');

INSERT INTO public.patients(id, dni, firstname, lastname, numberclinicalhistory) VALUES (3, '6542254', 'gabriel', 'Bautista', '959');
	

--SPECIALTIES
INSERT INTO public.specialties(id, name) VALUES (1, 'Odontólogo');
	
INSERT INTO public.specialties(id, name) VALUES (2, 'Radiólogo');
	
INSERT INTO public.specialties(id, name) VALUES (3, 'Ginecólogo');
	
INSERT INTO public.specialties(id, name) VALUES (4, 'Anesteciólogo');
	
INSERT INTO public.specialties(id, name) VALUES (5, 'Cirujano');
	
INSERT INTO public.specialties(id, name) VALUES (6, 'Médico General');
	

--DOCTORS
INSERT INTO public.doctors(	id, cmp, dni, firstname, lastname, specialty_id) VALUES (1, '520', '75564821', 'Robert', 'Castillo', 1);
	
COMMIT;