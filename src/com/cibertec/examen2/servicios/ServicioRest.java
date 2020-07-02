package com.cibertec.examen2.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cibertec.examen2.dao.TipoReclamoModel;
import com.cibertec.examen2.entidades.TipoReclamo;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);

	private TipoReclamoModel daoTipoReclamo = new TipoReclamoModel();

	// Crud de Tipo Reclamo
	@GET
	@Path("/tiporeclamo")
	public Response listarTipoReclamoTodos() {
		log.info("listars TipoReclamo rest ");
		return Response.ok(daoTipoReclamo.listarTipoReclamoTodos()).build();
	}

	@POST
	@Path("/tiporeclamo")
	public Response registraTipoReclamo(TipoReclamo obj) {
		log.info("Registra TipoReclamo " + obj.getIdTipoReclamo());
		if (daoTipoReclamo.insertaTipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/tiporeclamo")
	public Response atualizaTipoReclamo(TipoReclamo obj) {
		log.info("Actualiza TipoReclamo " + obj.getIdTipoReclamo());
		if (daoTipoReclamo.actualizaTipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/tiporeclamo/{idTipoReclamo}")
	public Response eliminaTipoReclamo(@PathParam("idTipoReclamo") int id) {
		log.info("Elimina TipoReclamo " + id);
		if (daoTipoReclamo.eliminaTipoReclamo(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}