DROP FUNCTION fn_QuantityDoctorBySpecialty();

CREATE OR REPLACE FUNCTION fn_QuantityDoctorBySpecialty() 
 RETURNS TABLE (
 nameSpecialty TEXT,
 cantidadDoctors INT,
 doctors TEXT
) 
AS $$
DECLARE 
    var_r record;
BEGIN
FOR var_r IN(
	SELECT s.id as id, s.name as specialty, (COUNT(d.id)::int) as quantity,
	(CASE WHEN string_agg(d.firstname || ' ' || d.lastname, ',') IS NULL THEN '-' ELSE string_agg(d.firstname || ' ' || d.lastname, ',') END) as doctors 
	FROM specialties s
	LEFT JOIN doctors d ON d.specialty_id = s.id
	GROUP BY s.id, s.name ORDER BY s.id
	)  
 LOOP
 		nameSpecialty := var_r.specialty;
 		cantidadDoctors := var_r.quantity;
		doctors := var_r.doctors;
        RETURN NEXT;
 END LOOP;
END; $$ 
LANGUAGE 'plpgsql';

SELECT * FROM fn_QuantityDoctorBySpecialty();