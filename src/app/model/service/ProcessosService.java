package app.model.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import app.model.entity.Processos;
import app.model.repository.ProcessosRepository;

public class ProcessosService {

	private ProcessosRepository processosRepository;

	public boolean salvar(HttpServletRequest request) {

		try {
			processosRepository = new ProcessosRepository();

			String dtPublic = request.getParameter("dtPublic");

			Processos processo = new Processos();
			processo.setNuPub(request.getParameter("nuPub"));
			processo.setNuPedido(request.getParameter("nuPedido"));
			processo.setDtPublic(new Date());
			processo.setRequerentes(request.getParameter("requerentes"));
			processo.setTitulo(request.getParameter("titulo"));
			processo.setNuProcesso(request.getParameter("nuProcesso"));

			processosRepository.salvar(processo);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Processos> buscar(HttpServletRequest request) {

		try {
			processosRepository = new ProcessosRepository();

			String requerente = request.getParameter("requerente");
			String nuProcesso = request.getParameter("nuProcesso");

			return processosRepository.buscar(nuProcesso, requerente);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
