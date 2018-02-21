/*
Dada la estructura de datos Archivador, Caj�n, Documento, Anexo. Donde un Archivador
tiene uno o m�s Cajones, un Caj�n tiene de cero a muchos Documentos y un Documento
tiene de 0 a muchos Anexos, realizar las siguientes queries:
*/

-- Ejercicio 1: Obtener la posici�n de todos los documentos archivados durante 2014
SELECT numero as archivador,posicion FROM archivo INNER JOIN (SELECT archivo_id,posicion FROM cajon INNER JOIN (SELECT cajon_id FROM documento WHERE EXTRACT(year FROM "fecha_archivado")=2014 GROUP BY cajon_id) AS documento_2014 ON cajon.id=documento_2014.cajon_id) AS info_2014 ON archivo.id=info_2014.archivo_id


-- Ejercicio 2: Obtener la posici�n de todos los documentos archivados en 2014 a�adiendo
-- el t�tulo de sus anexos de tipo factura en caso de existir

SELECT numero as archivador,posicion,titulo from archivo RIGHT JOIN (SELECT archivo_id,posicion,titulo FROM cajon RIGHT JOIN ((select titulo,documento_id from anexo where tipo_anexo='factura') as facturas RIGHT JOIN (SELECT id,cajon_id FROM documento WHERE EXTRACT(year FROM "fecha_archivado")=2014 ) as documento_2014 ON facturas.documento_id=documento_2014.id) as facturas_2014 ON cajon.id=facturas_2014.cajon_id) as info_2014 ON archivo.id=info_2014.archivo_id



-- Ejercicio 3: Contar el n�mero de documentos que tiene al menos un anexo de tipo factura
SELECT COUNT(DISTINCT documento_id) from anexo WHERE tipo_anexo='factura'



-- Ejercicio 4: Obtener la posici�n de todos los documentos y su �ltimo anexo de tipo factura, si �ste existe.

SELECT archivo.numero AS archivador,posicion,id_anexo,titulo,anexo_fecha_archivado FROM archivo RIGHT JOIN
(SELECT cajon.archivo_id,cajon.posicion,info.titulo,id_anexo,anexo_fecha_archivado FROM cajon RIGHT JOIN(SELECT cajon_id, ax.id AS id_anexo, ax.titulo, ax.fecha_archivado as anexo_fecha_archivado
FROM documento doc LEFT JOIN ((SELECT    MAX(id) max_id, documento_id FROM anexo WHERE anexo.tipo_anexo='factura' GROUP BY  documento_id) AS ult_fact
JOIN anexo ax ON (ax.id = ult_fact.max_id)) ON (ult_fact.documento_id = doc.id)) AS info ON info.cajon_id=cajon.id) AS info_cajon ON info_cajon.archivo_id=archivo.id
