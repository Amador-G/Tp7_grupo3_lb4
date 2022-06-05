CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Sagregar`(in descripcion varchar(500),in idTipo int,in costoContratacion float,in costoAsegurado float)
BEGIN
insert into seguros(descripcion,idTipo,costoContratacion,costoAsegurado)
			 values(descripcion,idTipo,costoContratacion,costoAsegurado);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Seliminar`(in delete_idSeguro int)
BEGIN
delete from seguros where idSeguro = delete_idSeguro;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Smodificar`(in m_idSeguro int,in m_descripcion varchar(500),in m_idTipo int,in m_costoContratacion float,in m_costoAsegurado float)
BEGIN
update seguros
set
 descripcion = m_descripcion,
 idTipo = m_idTipo,
 costoContratacion = m_costoContratacion,
 costoAsegurado = m_costoAsegurado
 where idSeguro = m_idSeguro;
END