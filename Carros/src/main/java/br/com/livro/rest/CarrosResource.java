package br.com.livro.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import br.com.livro.domain.Response;

@Path("/carros")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class CarrosResource {

	@Autowired
	private CarroService carroService;

	@GET
	public List<Carro> get() {
		return carroService.getCarros();
	}

	@GET
	@Path("{id}")
	public Carro get(@PathParam("id") long id) {
		return carroService.getCarro(id);
	}

	@GET
	@Path("/tipo/{tipo}")
	public List<Carro> getByTipo(@PathParam("tipo") String tipo) {
		return carroService.findByTipo(tipo);
	}

	@GET
	@Path("/nome/{nome}")
	public List<Carro> getByNome(@PathParam("nome") String nome) {
		return carroService.findByName(nome);
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		carroService.delete(id);
		return Response.Ok("Carro excluido com sucesso!");
	}

	@POST
	public Response post(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro salvo com sucesso!");
	}

	@PUT
	public Response put(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro atualizado com sucesso!");
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postFoto(final FormDataMultiPart multiPart) {
		if (multiPart != null && multiPart.getFields() != null) {
			Set<String> keys = multiPart.getFields().keySet();
			for (String key : keys) {
				// Obtem a InputStream para ler o arquivo
				FormDataBodyPart field = multiPart.getField(key);
				InputStream in = field.getValueAs(InputStream.class);
				try {
					// Salva o arquivo
					String fileName = field.getFormDataContentDisposition().getFileName();

					// Pasta Temporária da JVM
					File tmpDir = new File(System.getProperty("java.io.tmpDir"),"carros");

					if(!tmpDir.exists()) {
						// Cria a pasta carros se não existe
						tmpDir.mkdir();
					}

					// Cria o arquivo
					File file = new File(tmpDir, fileName);
					FileOutputStream out = new FileOutputStream(file);
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(out);

					System.out.println("Arquivo: " + file);

					return Response.Ok("Arquivo recebido com sucesso");
				} catch (IOException e) {
					e.printStackTrace();
					return Response.Error("Erro ao enviar o arquivo.");
				}
			}
		}
		return Response.Ok("Requisição inválida.");
	}
}
