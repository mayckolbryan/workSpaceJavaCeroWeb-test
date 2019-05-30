DROP FUNCTION fn_QuantityDoctorBySpecialty();

CREATE OR REPLACE FUNCTION fn_QuantityDoctorBySpecialty() 
 RETURNS TABLE (
 idSpecialty INT,
 nameSpecialty TEXT,
 cantidadDoctors INT
) 
AS $$
DECLARE 
    var_r record;
BEGIN
FOR var_r IN(
	SELECT s.id as id, s.name as specialty, (COUNT(d.id)::int) as quantity FROM specialties s
	LEFT JOIN doctors d ON d.specialty_id = s.id
	GROUP BY s.id, s.name ORDER BY s.id
	)  
 LOOP
        idSpecialty := var_r.id; 
 		nameSpecialty := var_r.specialty;
 		cantidadDoctors := var_r.quantity;
        RETURN NEXT;
 END LOOP;
END; $$ 
LANGUAGE 'plpgsql';

SELECT * FROM fn_QuantityDoctorBySpecialty();