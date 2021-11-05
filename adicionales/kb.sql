-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla klaus2.acta_contable
CREATE TABLE IF NOT EXISTS `acta_contable` (
  `idacta_contable` int(11) NOT NULL AUTO_INCREMENT,
  `mes_registro` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`idacta_contable`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.acta_contable: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `acta_contable` DISABLE KEYS */;
INSERT INTO `acta_contable` (`idacta_contable`, `mes_registro`, `estado`, `saldo`) VALUES
	(1, 'Agosto', 'realizado', 6300),
	(2, 'Octubre', 'pendiente', 10000),
	(3, 'Setiembre', 'realizado', 1000);
/*!40000 ALTER TABLE `acta_contable` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.categoria: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`idCategoria`, `nombreCategoria`) VALUES
	(1, 'productos ferreteria'),
	(2, 'armado de piezas'),
	(3, 'soluciones metal mecanicas'),
	(4, 'elementos contundentes');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.cotdemandada
CREATE TABLE IF NOT EXISTS `cotdemandada` (
  `idcotDemandada` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDemanda` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `productobuscado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `cantidades` double NOT NULL,
  `detalles` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcotDemandada`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.cotdemandada: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cotdemandada` DISABLE KEYS */;
INSERT INTO `cotdemandada` (`idcotDemandada`, `nombreDemanda`, `productobuscado`, `cantidades`, `detalles`) VALUES
	(1, 'dem-Zinc', 'zinc', 20, 'Zinc (Zn)'),
	(2, 'dem-Cu', 'cobre', 30, 'Cobre (Cu)'),
	(3, 'dem-Bal', 'Balanza', 1, 'Acero inoxidable'),
	(4, 'dem-Ciz', 'Cizalla', 5, 'Hierro fundido'),
	(5, 'dem-selladora', 'Máquina Selladora', 3, 'Modelo: DZ-300');
/*!40000 ALTER TABLE `cotdemandada` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.cotofertada
CREATE TABLE IF NOT EXISTS `cotofertada` (
  `idcotOfertada` int(11) NOT NULL AUTO_INCREMENT,
  `cotDemandada` int(11) NOT NULL,
  `prov_empresa_RUC` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcotOfertada`),
  KEY `fk_cotOfertada_cotDemandada1` (`cotDemandada`),
  KEY `fk_cotOfertada_prov_empresa1` (`prov_empresa_RUC`),
  CONSTRAINT `fk_cotOfertada_cotDemandada1` FOREIGN KEY (`cotDemandada`) REFERENCES `cotdemandada` (`idcotDemandada`),
  CONSTRAINT `fk_cotOfertada_prov_empresa1` FOREIGN KEY (`prov_empresa_RUC`) REFERENCES `prov_empresa` (`RUC`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.cotofertada: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cotofertada` DISABLE KEYS */;
INSERT INTO `cotofertada` (`idcotOfertada`, `cotDemandada`, `prov_empresa_RUC`) VALUES
	(1, 1, '20600695691'),
	(2, 2, '20600695691'),
	(3, 4, '20100147514'),
	(4, 5, '20100147514');
/*!40000 ALTER TABLE `cotofertada` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.criteriocalidad
CREATE TABLE IF NOT EXISTS `criteriocalidad` (
  `idcriterioCalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCrit` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `esAceptable` tinyint(4) NOT NULL,
  `idProduccion` int(11) NOT NULL,
  `IDInspector` int(11) DEFAULT NULL,
  `estadoCriterio` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `observacion` varchar(70) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcriterioCalidad`),
  KEY `fk_criterioCalidad_Produccion1` (`idProduccion`),
  KEY `fk_inspector_cc` (`IDInspector`),
  CONSTRAINT `fk_criterioCalidad_Produccion1` FOREIGN KEY (`idProduccion`) REFERENCES `produccion` (`idProduccion`),
  CONSTRAINT `fk_inspector_cc` FOREIGN KEY (`IDInspector`) REFERENCES `usuario` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.criteriocalidad: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `criteriocalidad` DISABLE KEYS */;
INSERT INTO `criteriocalidad` (`idcriterioCalidad`, `nombreCrit`, `esAceptable`, `idProduccion`, `IDInspector`, `estadoCriterio`, `observacion`) VALUES
	(1, 'la base debe estar lisa', 0, 1, NULL, 'sin asignar', 'aun no es revizada por algun inspector'),
	(2, 'la goma debe ser de alta calidad', 0, 1, NULL, 'sin asignar', 'aun no es revizada por algun inspector'),
	(7, 'Alto grado de pureza 99,99%', 1, 5, 7, 'aprobado', 'prueba 1'),
	(8, 'crit 8', 0, 5, 7, 'rechazado', 'prueba 1'),
	(9, 'crit 9', 0, 5, 7, 'rechazado', 'prueba 1'),
	(10, 'crit 10', 1, 5, 7, 'aprobado', 'prueba 1'),
	(11, 'cri 200', 1, 6, 16, 'aprobado', 'prueba 3. todos aprobados'),
	(12, 'crit 201', 1, 6, 16, 'aprobado', 'prueba 3. todos aprobados'),
	(13, 'crit 300', 0, 4, 15, 'rechazado', 'prueba 2'),
	(14, 'crit 301', 1, 4, 15, 'aprobado', 'prueba 2'),
	(15, 'crit 302', 1, 4, 15, 'aprobado', 'prueba 2');
/*!40000 ALTER TABLE `criteriocalidad` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `costoUnit` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `unidades` double DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RUC` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `monto_total` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `registro_pagos_idregistro_pagos` int(11) NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_Factura_registro_pagos1` (`registro_pagos_idregistro_pagos`),
  CONSTRAINT `fk_Factura_registro_pagos1` FOREIGN KEY (`registro_pagos_idregistro_pagos`) REFERENCES `registro_pagos` (`idregistro_pagos`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` (`idFactura`, `costoUnit`, `unidades`, `descripcion`, `RUC`, `monto_total`, `registro_pagos_idregistro_pagos`) VALUES
	(1, '200', 5, NULL, NULL, '10000', 2);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.ganancia
CREATE TABLE IF NOT EXISTS `ganancia` (
  `idGanancia` int(11) NOT NULL AUTO_INCREMENT,
  `idProduccion` int(11) NOT NULL,
  `RUC_emp_pagadora` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `monto_final` double NOT NULL,
  `fecha_pago` date DEFAULT NULL,
  `detalles` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `registro_pagos_idregistro_pagos` int(11) DEFAULT NULL,
  `codOperacion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idGanancia`),
  KEY `fk_Ganancia_Produccion1` (`idProduccion`),
  KEY `fk_Ganancia_registro_pagos1` (`registro_pagos_idregistro_pagos`),
  CONSTRAINT `fk_Ganancia_Produccion1` FOREIGN KEY (`idProduccion`) REFERENCES `produccion` (`idProduccion`),
  CONSTRAINT `fk_Ganancia_registro_pagos1` FOREIGN KEY (`registro_pagos_idregistro_pagos`) REFERENCES `registro_pagos` (`idregistro_pagos`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.ganancia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ganancia` DISABLE KEYS */;
INSERT INTO `ganancia` (`idGanancia`, `idProduccion`, `RUC_emp_pagadora`, `monto_final`, `fecha_pago`, `detalles`, `registro_pagos_idregistro_pagos`, `codOperacion`) VALUES
	(1, 1, '', 56633, '2021-02-03', 'pago hecho por atencion al cliente. no hay observaciones', NULL, 'Scotiabank');
/*!40000 ALTER TABLE `ganancia` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.gastosfijos
CREATE TABLE IF NOT EXISTS `gastosfijos` (
  `idgastosFijos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `monto` double NOT NULL,
  `ruc_gf` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_gf` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `raz_social_gf` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `registro_pagos_idregistro_pagos` int(11) NOT NULL,
  PRIMARY KEY (`idgastosFijos`),
  KEY `fk_gastosFijos_registro_pagos1` (`registro_pagos_idregistro_pagos`),
  CONSTRAINT `fk_gastosFijos_registro_pagos1` FOREIGN KEY (`registro_pagos_idregistro_pagos`) REFERENCES `registro_pagos` (`idregistro_pagos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.gastosfijos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `gastosfijos` DISABLE KEYS */;
/*!40000 ALTER TABLE `gastosfijos` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.guiaremision
CREATE TABLE IF NOT EXISTS `guiaremision` (
  `idGuiaRemision` int(11) NOT NULL AUTO_INCREMENT,
  `tipoProducto` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `DescripcionProducto` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Cantidad` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Peso` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `prov_empresa_RUC` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idGuiaRemision`),
  KEY `fk_GuiaRemision_prov_empresa1` (`prov_empresa_RUC`),
  CONSTRAINT `fk_GuiaRemision_prov_empresa1` FOREIGN KEY (`prov_empresa_RUC`) REFERENCES `prov_empresa` (`RUC`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.guiaremision: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guiaremision` DISABLE KEYS */;
INSERT INTO `guiaremision` (`idGuiaRemision`, `tipoProducto`, `DescripcionProducto`, `Cantidad`, `Peso`, `prov_empresa_RUC`) VALUES
	(1, 'Maquinaria', 'cizalla ', '1', '20', '20600695691');
/*!40000 ALTER TABLE `guiaremision` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.guiaremision_has_producto
CREATE TABLE IF NOT EXISTS `guiaremision_has_producto` (
  `id_gr_r` int(11) NOT NULL AUTO_INCREMENT,
  `GuiaRemision_idGuiaRemision` int(11) NOT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  PRIMARY KEY (`id_gr_r`),
  KEY `fk_GuiaRemision_has_Producto_GuiaRemision1` (`GuiaRemision_idGuiaRemision`),
  KEY `fk_GuiaRemision_has_Producto_Producto1` (`Producto_idProducto`),
  CONSTRAINT `fk_GuiaRemision_has_Producto_GuiaRemision1` FOREIGN KEY (`GuiaRemision_idGuiaRemision`) REFERENCES `guiaremision` (`idGuiaRemision`),
  CONSTRAINT `fk_GuiaRemision_has_Producto_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.guiaremision_has_producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guiaremision_has_producto` DISABLE KEYS */;
INSERT INTO `guiaremision_has_producto` (`id_gr_r`, `GuiaRemision_idGuiaRemision`, `Producto_idProducto`) VALUES
	(1, 1, 3);
/*!40000 ALTER TABLE `guiaremision_has_producto` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.kardex
CREATE TABLE IF NOT EXISTS `kardex` (
  `idkardex` int(11) NOT NULL AUTO_INCREMENT,
  `elem_totales` int(11) NOT NULL,
  PRIMARY KEY (`idkardex`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.kardex: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `kardex` DISABLE KEYS */;
INSERT INTO `kardex` (`idkardex`, `elem_totales`) VALUES
	(1, 10),
	(2, 15),
	(3, 25),
	(4, 30);
/*!40000 ALTER TABLE `kardex` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.operarioproduccion
CREATE TABLE IF NOT EXISTS `operarioproduccion` (
  `idOP` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idProduccion` int(11) NOT NULL,
  `rol` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idOP`),
  KEY `fk_operarioProduccion_usuario` (`iduser`),
  KEY `fk_operarioProduccion_produccion` (`idProduccion`),
  CONSTRAINT `fk_operarioProduccion_produccion` FOREIGN KEY (`idProduccion`) REFERENCES `produccion` (`idProduccion`),
  CONSTRAINT `fk_operarioProduccion_usuario` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.operarioproduccion: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `operarioproduccion` DISABLE KEYS */;
INSERT INTO `operarioproduccion` (`idOP`, `iduser`, `idProduccion`, `rol`) VALUES
	(1, 1, 1, 'branding de marca'),
	(2, 4, 1, 'gestion de aleatoriedad'),
	(3, 5, 1, 'esculpir'),
	(8, 2, 4, 'rol 1'),
	(9, 5, 5, 'rol 12'),
	(10, 1, 5, 'rol 15'),
	(11, 3, 6, 'rol 100'),
	(12, 4, 6, '');
/*!40000 ALTER TABLE `operarioproduccion` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.produccion
CREATE TABLE IF NOT EXISTS `produccion` (
  `idProduccion` int(11) NOT NULL AUTO_INCREMENT,
  `idCategoria` int(11) NOT NULL,
  `idrequerimiento` int(11) NOT NULL,
  `fechaProduccion` date NOT NULL,
  `urgencia` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estadoProduccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProduccion`),
  KEY `fk_Produccion_Categoria1` (`idCategoria`),
  KEY `fk_Produccion_requerimiento1` (`idrequerimiento`),
  CONSTRAINT `fk_Produccion_Categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `fk_Produccion_requerimiento1` FOREIGN KEY (`idrequerimiento`) REFERENCES `requerimiento` (`idrequerimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.produccion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `produccion` DISABLE KEYS */;
INSERT INTO `produccion` (`idProduccion`, `idCategoria`, `idrequerimiento`, `fechaProduccion`, `urgencia`, `estadoProduccion`) VALUES
	(1, 4, 3, '2021-02-20', 'urgente', 'Pagado'),
	(4, 4, 8, '2021-12-07', 'urgente', 'en Produccion'),
	(5, 4, 1, '2021-12-12', 'urgente', 'en Produccion'),
	(6, 3, 4, '2021-10-31', 'Muy urgente', 'en Produccion');
/*!40000 ALTER TABLE `produccion` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `tipoProducto` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `esAceptado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `kardex` int(11) NOT NULL,
  `cotOfertada` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_kardex1` (`kardex`),
  KEY `fk_Producto_cotOfertada1` (`cotOfertada`),
  CONSTRAINT `fk_Producto_cotOfertada1` FOREIGN KEY (`cotOfertada`) REFERENCES `cotofertada` (`idcotOfertada`),
  CONSTRAINT `fk_Producto_kardex1` FOREIGN KEY (`kardex`) REFERENCES `kardex` (`idkardex`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`idProducto`, `tipoProducto`, `nombre`, `descripcion`, `esAceptado`, `kardex`, `cotOfertada`) VALUES
	(1, 'Metal', 'Cobre', 'maleable', '', 1, 2),
	(2, 'Metal', 'Zinc', '', '', 2, 1),
	(3, 'Maquinaria', 'cizalla', '', '', 3, 2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.producto_has_produccion
CREATE TABLE IF NOT EXISTS `producto_has_produccion` (
  `id_pp` int(11) NOT NULL AUTO_INCREMENT,
  `Producto_idProducto` int(11) NOT NULL,
  `Produccion_idProduccion` int(11) NOT NULL,
  PRIMARY KEY (`id_pp`),
  KEY `fk_Producto_has_Produccion_Producto1` (`Producto_idProducto`),
  KEY `fk_Producto_has_Produccion_Produccion1` (`Produccion_idProduccion`),
  CONSTRAINT `fk_Producto_has_Produccion_Produccion1` FOREIGN KEY (`Produccion_idProduccion`) REFERENCES `produccion` (`idProduccion`),
  CONSTRAINT `fk_Producto_has_Produccion_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.producto_has_produccion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `producto_has_produccion` DISABLE KEYS */;
INSERT INTO `producto_has_produccion` (`id_pp`, `Producto_idProducto`, `Produccion_idProduccion`) VALUES
	(1, 1, 1),
	(2, 2, 6);
/*!40000 ALTER TABLE `producto_has_produccion` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.prov_empresa
CREATE TABLE IF NOT EXISTS `prov_empresa` (
  `RUC` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `idUser` int(11) NOT NULL,
  `Rubro` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Razon_Social` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` int(11) NOT NULL,
  PRIMARY KEY (`RUC`),
  KEY `prov_empresa_ibfk_1` (`idUser`),
  CONSTRAINT `prov_empresa_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `usuario` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.prov_empresa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `prov_empresa` DISABLE KEYS */;
INSERT INTO `prov_empresa` (`RUC`, `idUser`, `Rubro`, `Razon_Social`, `Telefono`) VALUES
	('20100147514', 18, 'southern peru copper corporation', 'Razón Social: SOUTHERN PERU COPPER CORPO', 963548124),
	('20600695691', 4, 'refinería Cajamarquilla', 'Acero S.R.L', 923684127);
/*!40000 ALTER TABLE `prov_empresa` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.registro_pagos
CREATE TABLE IF NOT EXISTS `registro_pagos` (
  `idregistro_pagos` int(11) NOT NULL AUTO_INCREMENT,
  `dia` date NOT NULL,
  `tipo_reg_pago` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `idacta_contable` int(11) NOT NULL,
  PRIMARY KEY (`idregistro_pagos`),
  KEY `fk_registro_pagos_acta_contable1` (`idacta_contable`),
  CONSTRAINT `fk_registro_pagos_acta_contable1` FOREIGN KEY (`idacta_contable`) REFERENCES `acta_contable` (`idacta_contable`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.registro_pagos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `registro_pagos` DISABLE KEYS */;
INSERT INTO `registro_pagos` (`idregistro_pagos`, `dia`, `tipo_reg_pago`, `idacta_contable`) VALUES
	(1, '2021-11-01', '', 1),
	(2, '2021-10-22', '', 3);
/*!40000 ALTER TABLE `registro_pagos` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.requerimiento
CREATE TABLE IF NOT EXISTS `requerimiento` (
  `idrequerimiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreReq` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fechaEntrega` date NOT NULL,
  `pagoEstimado` double NOT NULL,
  `RUCempresa` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_emp` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `calidadReq` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `compromisoPago` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_registro` date NOT NULL,
  `cantidad_productos` double NOT NULL,
  PRIMARY KEY (`idrequerimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.requerimiento: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `requerimiento` DISABLE KEYS */;
INSERT INTO `requerimiento` (`idrequerimiento`, `nombreReq`, `descripcion`, `fechaEntrega`, `pagoEstimado`, `RUCempresa`, `nombre_emp`, `calidadReq`, `compromisoPago`, `fecha_registro`, `cantidad_productos`) VALUES
	(1, 'cerraduras ultra', 'de tres cierres electrico', '2021-02-19', 5000, '390444', 'emp1', 'Regular', '20% pago adelantado', '2021-02-02', 100),
	(2, 'tornillos', '5 hilos x mil', '2021-02-13', 4000, '9511ff33', 'emp2', 'Buena', '5% de defectos se rechaza', '2021-02-02', 1000),
	(3, 'llaves para moto', 'llaves con seguro reforzado', '2021-04-02', 7000, '9974722', 'motos ronco', 'Alta', 'pago contra entrega', '2021-02-02', 14000),
	(4, 'brazos para freno v-brake', 'frenos de laton plateado', '2021-02-27', 8000, '822441', 'monark del peru', 'Alta', '1% se procede a devolucion', '2021-02-02', 8000),
	(5, 'carcasa para grupo electrÃ³geno', 'pintura aislante de calor', '2021-04-10', 50000, '542233', 'modasa', 'Buena', 'pago por deuda', '2021-02-02', 1000),
	(6, 'vallas separadoras', 'debe contener marca de la MML', '2021-05-16', 70000, '80854', 'municipalidad de lima', 'Media', '10% adelanto', '2021-02-02', 1500),
	(7, 'casilleros de metal 6x10', 'tamaÃ±o 40x40', '2021-03-17', 20000, '902993', 'maletek', 'Media', 'incluyen cerraduras', '2021-02-02', 20),
	(8, 'lavaderos provisionales', 'portatiles para poner rotoplas', '2021-02-26', 500, '876542', 'cc arenales', 'Baja', 'pago por adelantado', '2021-02-03', 5);
/*!40000 ALTER TABLE `requerimiento` ENABLE KEYS */;

-- Volcando estructura para tabla klaus2.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre1` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre2` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ApellidoP` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `ApellidoM` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `ContraseÃ±a` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Sueldo` float NOT NULL,
  `TipoContrato` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Email` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `tipoUsuario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla klaus2.usuario: ~17 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUser`, `Nombre1`, `Nombre2`, `ApellidoP`, `ApellidoM`, `ContraseÃ±a`, `Sueldo`, `TipoContrato`, `Email`, `tipoUsuario`) VALUES
	(1, 'Juan', 'Lorenzo', 'Gutierrez', 'Jorgechagua', '1234', 5000, 'Estable 5 aÃ±os', 'juan@aea.com', 'Jefe Produccion'),
	(2, 'Alex', 'Rommel', 'Rojas', 'Coaquira', '1234', 4000, 'Estable 4 aÃ±os', 'rommel@aea.com', 'Atencion al Cliente'),
	(3, 'Argenis', NULL, 'Uceda', 'Malca', '1234', 3000, 'Temporal 12 meses', 'argenis@aea.com', 'Asistente Compras'),
	(4, 'Jesus', 'Sebastian', 'Huamanculi', 'Casavilca', '1234', 4000, 'Estable 3 aÃ±os', 'sebas@aea.com', 'Proveedor'),
	(5, 'Jose', 'Miguel', 'Vilca', 'Huillcaya', '1234', 4000, 'Temporal 6 meses', 'jose@aea.com', 'Operario Almacen'),
	(6, 'Angie', 'Alessandra', 'Olaya', 'Silipu', '1234', 5000, 'Estable 4 aÃ±oss', 'angie@aea.com', 'Jefe Compras'),
	(7, 'Angelo', 'Jesus', 'Davalos', 'Salvador', '1234', 3000, 'Temporal 12 meses', 'angelo@aea.com', 'Inspector Calidad'),
	(8, 'Enrique', 'Miguel', 'Chalco', 'Vila', '1234', 4000, 'Temporal 12 meses', 'chalco@aea.com', 'Jefe Calidad'),
	(9, 'Natalie', NULL, 'Paulett', 'Ramirez', '1234', 5000, 'Estable 3 aÃ±os', 'natalie@aea.com', 'Jefe Area Contable'),
	(10, 'Martin', NULL, 'Barueto', 'Suarez', '1234', 2500, 'Temporal 12 meses', 'barueto@aea.com', 'Operario Produccion'),
	(11, 'Sandra', 'Briggite', 'Chavarry', 'Alvarez', '1234', 2500, 'Temporal 12 meses', 'sandra@aea.com', 'Operario Produccion'),
	(12, 'Abigail', 'Marife', 'Montes', 'Yngar', '1234', 2500, 'Temporal 12 meses', 'abigail@aea.com', 'Operario Produccion'),
	(13, 'alma', NULL, 'molina', 'reyes', '1234', 2500, 'Temporal 12 meses', 'alma@aea.com', 'Operario Produccion'),
	(14, 'Alvaro', NULL, 'Espiritu', 'Inga', '1234', 2500, 'Temporal 12 meses', 'alvaro@aea.com', 'Operario Produccion'),
	(15, 'cecilia', NULL, 'cilloniz', 'valenzuela', '1234', 4000, 'Temporal 6 meses', 'cecilia@aea.com', 'Inspector Calidad'),
	(16, 'melissa', NULL, 'pradell', 'lartiga', '1234', 4000, 'Temporal 6 meses', 'mels@aea.com', 'Inspector Calidad'),
	(17, 'hugo', NULL, 'jaramillo', 'ruiz', '1234', 4000, 'Temporal 6 meses', 'hugo@aea.com', 'Inspector Calidad'),
	(18, 'Jesus', 'Angel', 'Lopez', 'Chavez', '1234', 2000, 'Temporal 10 meses', 'jesus@aea.com', 'Proveedor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
