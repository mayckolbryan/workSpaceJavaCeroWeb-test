DROP FUNCTION fn_QuantityProductByCategory();

CREATE OR REPLACE FUNCTION fn_QuantityProductByCategory(idSpecialty INT) 
 RETURNS TABLE (
 doctor TEXT
) 
AS $$
DECLARE 
    var_r record;
BEGIN
FOR var_r IN(
	SELECT (firstname || ' ' || lastname) as name 
	FROM doctors 
	WHERE specialty_id = idSpecialty ORDER BY id
	)
 LOOP
        doctor := var_r.name; 
        RETURN NEXT;
 END LOOP;
END; $$ 
LANGUAGE 'plpgsql';

SELECT * FROM fn_QuantityProductByCategory(1);