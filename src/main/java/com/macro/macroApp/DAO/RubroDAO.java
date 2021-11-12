package com.macro.macroApp.DAO;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Rubro;

@Repository
public interface RubroDAO extends JpaRepository<Rubro, Integer>{
	

	
	
	
	// Obtener rubto por id del proyecto
	@Query("select r from Rubro r where r.proyecto_id = :id")
	public List<Rubro> findByProyecto_id(@Param("id") int proyecto_id);
	
	// Obtener cantidad de rubros de un proyecto
	@Query("select MAX(r.orden) from Rubro r where r.proyecto_id = :id")
	public Integer countByProyecto_id(@Param("id") int proyecto_id);
	
	
	
	
	// Obtener subtotal de cada rubrto (eq + mat + manoOb + transp)
	@Query(value = "select sum(sub) from\r\n"
			+ "(\r\n"
			+ "	SELECT sum(detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento) as sub \r\n"
			+ "	FROM rubro \r\n"
			+ "	JOIN detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id \r\n"
			+ "	where rubro.rubro_id = :id   \r\n"
			+ "\r\n"
			+ "	UNION all(\r\n"
			+ "		SELECT sum(detalle_material.cantidad * detalle_material.costo) as sub \r\n"
			+ "		from rubro \r\n"
			+ "		join detalle_material ON detalle_material.rubro_id = rubro.rubro_id \r\n"
			+ "		where rubro.rubro_id = :id   \r\n"
			+ "	)\r\n"
			+ "	UNION all(\r\n"
			+ "		select sum(detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento) as sub \r\n"
			+ "		from rubro \r\n"
			+ "		join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id \r\n"
			+ "		WHERE rubro.rubro_id = :id   \r\n"
			+ "	)\r\n"
			+ "	UNION all(\r\n"
			+ "		select sum(detalle_transporte.cantidad * detalle_transporte.costo) as sub \r\n"
			+ "		from rubro \r\n"
			+ "		join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id\r\n"
			+ "		WHERE rubro.rubro_id = :id   \r\n"
			+ "	) \r\n"
			+ ") subtotal" ,nativeQuery = true)
	public BigDecimal selectSubtotal(@Param("id") int rubro_id);
	
	
	
	// Obtener el agregado cuatoriano de cada rubro
	@Query(value = 
			"select sum(sub) from (  \r\n"
			+ "	SELECT  \r\n"
			+ "	(  \r\n"
			+ "		((((detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento)/  \r\n"
			+ "		(select sum(sub) from  \r\n"
			+ "		(  \r\n"
			+ "			SELECT sum(detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento) as sub  \r\n"
			+ "			FROM rubro  \r\n"
			+ "			JOIN detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id  \r\n"
			+ "			where rubro.rubro_id = :id  \r\n"
			+ "			UNION all(  \r\n"
			+ "				SELECT sum(detalle_material.cantidad * detalle_material.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_material ON detalle_material.rubro_id = rubro.rubro_id  \r\n"
			+ "				where rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_transporte.cantidad * detalle_transporte.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "		) subtotal)*100)*detalle_equipo.vae)/100)  \r\n"
			+ "	) as sub   \r\n"
			+ "	from rubro  \r\n"
			+ "	join detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id  \r\n"
			+ "	where rubro.rubro_id = :id  \r\n"
			+ "	union all( \r\n"
			+ "	SELECT   \r\n"
			+ "	(  \r\n"
			+ "		((((detalle_material.cantidad * detalle_material.costo)/  \r\n"
			+ "		(select sum(sub) from  \r\n"
			+ "		(  \r\n"
			+ "			SELECT sum(detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento) as sub  \r\n"
			+ "			FROM rubro  \r\n"
			+ "			JOIN detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id  \r\n"
			+ "			where rubro.rubro_id = :id  \r\n"
			+ "			UNION all(  \r\n"
			+ "				SELECT sum(detalle_material.cantidad * detalle_material.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_material ON detalle_material.rubro_id = rubro.rubro_id  \r\n"
			+ "				where rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_transporte.cantidad * detalle_transporte.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "		) subtotal)*100)*detalle_material.vae)/100)  \r\n"
			+ "	) as sub   \r\n"
			+ "	from rubro  \r\n"
			+ "	join detalle_material ON detalle_material.rubro_id = rubro.rubro_id  \r\n"
			+ "	where rubro.rubro_id = :id	 \r\n"
			+ "	)  \r\n"
			+ "	union all(  \r\n"
			+ "	SELECT   \r\n"
			+ "	(  \r\n"
			+ "		((((detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento)/  \r\n"
			+ "		(select sum(sub) from  \r\n"
			+ "		(  \r\n"
			+ "			SELECT sum(detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento) as sub  \r\n"
			+ "			FROM rubro  \r\n"
			+ "			JOIN detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id  \r\n"
			+ "			where rubro.rubro_id = :id  \r\n"
			+ "			UNION all(  \r\n"
			+ "				SELECT sum(detalle_material.cantidad * detalle_material.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_material ON detalle_material.rubro_id = rubro.rubro_id  \r\n"
			+ "				where rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_transporte.cantidad * detalle_transporte.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "		) subtotal)*100)*detalle_mano_obra.vae)/100)   \r\n"
			+ "	) as sub  \r\n"
			+ "	from rubro  \r\n"
			+ "	join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id  \r\n"
			+ "	where rubro.rubro_id = :id	\r\n"
			+ "	)  \r\n"
			+ "	union all(  \r\n"
			+ "	SELECT  \r\n"
			+ "	(  \r\n"
			+ "		((((detalle_transporte.cantidad * detalle_transporte.costo)/  \r\n"
			+ "		(select sum(sub) from  \r\n"
			+ "		(  \r\n"
			+ "			SELECT sum(detalle_equipo.cantidad * detalle_equipo.tarifa * rubro.rendimiento) as sub  \r\n"
			+ "			FROM rubro  \r\n"
			+ "			JOIN detalle_equipo ON detalle_equipo.rubro_id = rubro.rubro_id  \r\n"
			+ "			where rubro.rubro_id = :id  \r\n"
			+ "			UNION all(  \r\n"
			+ "				SELECT sum(detalle_material.cantidad * detalle_material.costo) as sub  \r\n"
			+ "				from rubro   \r\n"
			+ "				join detalle_material ON detalle_material.rubro_id = rubro.rubro_id  \r\n"
			+ "				where rubro.rubro_id = :id   \r\n"
			+ "			)  \r\n"
			+ "			UNION all(  \r\n"
			+ "				select sum(detalle_mano_obra.cantidad * detalle_mano_obra.costo_horario * rubro.rendimiento) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_mano_obra ON detalle_mano_obra.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "			UNION all(   \r\n"
			+ "				select sum(detalle_transporte.cantidad * detalle_transporte.costo) as sub  \r\n"
			+ "				from rubro  \r\n"
			+ "				join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id  \r\n"
			+ "				WHERE rubro.rubro_id = :id  \r\n"
			+ "			)  \r\n"
			+ "		) subtotal)*100)* detalle_transporte.vae)/100)  \r\n"
			+ "	) as sub   \r\n"
			+ "	from rubro  \r\n"
			+ "	join detalle_transporte ON detalle_transporte.rubro_id = rubro.rubro_id  \r\n"
			+ "	where rubro.rubro_id = :id	\r\n"
			+ "	)  \r\n"
			+ ")agregado_ecuatoriano"
			,nativeQuery = true)
	public BigDecimal selectAgregadoEc(@Param("id") int rubro_id);
	
	
	
}
