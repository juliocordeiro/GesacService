package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidade.Servico;
import java.io.IOException;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import persistencia.ServicoDao;
import persistencia.UsuarioDAO;

/**
 *
 * @author Edilson Jr
 */
@WebServlet(urlPatterns = {"/ServicoSrv"})
public class ServicoSrv extends HttpServlet {

    //Initialize global variables
    public void init() throws ServletException {

    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

//Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isMultiPart = FileUpload.isMultipartContent(request);
        String manifestacoes = null;

        if (isMultiPart) {

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            String formulario = "";
            UsuarioDAO usudao = new UsuarioDAO();
            ServicoDao servicoDao = new ServicoDao();
            Servico servico = new Servico();
            List listaPerguntas = new ArrayList();

            try {

                List items = upload.parseRequest(request);

                Iterator iter = items.iterator();

                while (iter.hasNext()) {

                    FileItem item = (FileItem) iter.next();

                    if (!item.isFormField()) {

                        if (item.getName().length() > 0) {

                            if (item.getFieldName().equals("planilha")) {
                                String usuario = null;
                                /* Verifica se item é igual a imagem   se for pega a imagem e o usuario logado.                    
                                 */

                                ServicoDao.atualizarplanilha(usuario, item);

                            }
                            if (item.getFieldName().equals("descricao")) {
                                servico.setDescricao(item.getString());
                            }
                            if (item.getFieldName().equals("intervalo")) {
                                servico.setIntervalo(Integer.parseInt(item.getString()));
                            }

                        }

                    }/* Verifica se item é igual a manifestacao de interesse ou termo                     
                     */

                    if (item.getFieldName().contains("pergunta")) {
                        String pergunta = item.getString();

                        String campo = item.getFieldName();
                        listaPerguntas.add(pergunta);

                    }

                }Calendar calendar = Calendar.getInstance();

                int dia = Calendar.DATE;
                int mes;
                int ano;
                mes = Calendar.MONTH;
                ano = Calendar.YEAR;
                calendar.set(ano, mes, dia);
                servico.setCriacao(calendar);
                HttpServletRequest reqt = (HttpServletRequest) request;
                HttpServletResponse resp = (HttpServletResponse) response;

                HttpSession ses = reqt.getSession(false);
//                String usuario = (String) ses.getAttribute("userid");
                String usuario = "1";
                servicoDao.adicionarServico(servico, usuario);
                Date date = new Date();
                

                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");

                dispatcher.forward(request, response);
                return;
            } catch (FileUploadException ex) {

                System.out.println("Não foi possível fazer o Upload do arquivo! Tente Novamente");

            } catch (Exception ex) {

                ex.printStackTrace();
                System.out.println("Erro na Solicitação. Tente de novo ou entre em contato do Administrador do Banco de Dados");
            }

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/errorpage.html");
        dispatcher.forward(request, response);
    }

}
