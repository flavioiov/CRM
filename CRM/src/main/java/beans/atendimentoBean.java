/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import geral.Classe_Geral;
import geral.CustomDataSource;
import java.io.IOException;

import java.util.List;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Arrays;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Flavio
 */
import modelos.Atendimento;
import modelos.Agenda;
import modelos.Acoes;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped

public class atendimentoBean {

    public List<Atendimento> getListaAtendimentos() {
        return listaAtendimentos;
    }

    public void setListaAtendimentos(List<Atendimento> listaAtendimentos) {
        this.listaAtendimentos = listaAtendimentos;
    }

    public List<Atendimento> listaMeusAtendimentos;

    public List<Atendimento> listaAtendimentoSelecionado;

    public List<Atendimento> getListaAtendimentoSelecionado() {
        return listaAtendimentoSelecionado;
    }

    public void setListaAtendimentoSelecionado(List<Atendimento> listaAtendimentoSelecionado) {
        this.listaAtendimentoSelecionado = listaAtendimentoSelecionado;
    }

    public List<Atendimento> listaAtendimentos;

    public List<Atendimento> listaAtendimentoDetalhe;
    public List<Atendimento> listarminhasligacoes;
    
   public List<Atendimento> listaatendimentosrevisar;
    public List<Atendimento> listaAbertos;
    public List<Atendimento> qtdatendimentoscorretor;
    public List<Agenda> listaAtividades;
    public List<Atendimento> listameusclientes;
     public List<Agenda> listatodasatividades;
    
    public List<Acoes> listaacoes;

    public List<Agenda> getListatodasatividades() {
        return listatodasatividades;
    }

    public void setListatodasatividades(List<Agenda> listatodasatividades) {
        this.listatodasatividades = listatodasatividades;
    }

    
    
    
    public List<Acoes> getListaacoes() {
        return listaacoes;
    }

    public void setListaacoes(List<Acoes> listaacoes) {
        this.listaacoes = listaacoes;
    }

    public List<Atendimento> getListaatendimentosrevisar() {
        return listaatendimentosrevisar;
    }

    public void setListaatendimentosrevisar(List<Atendimento> listaatendimentosrevisar) {
        this.listaatendimentosrevisar = listaatendimentosrevisar;
    }
    
    

    public List<Atendimento> getListaAbertos() {
        return listaAbertos;
    }

    public List<Atendimento> getListameusclientes() {
        return listameusclientes;
    }

    public void setListameusclientes(List<Atendimento> listameusclientes) {
        this.listameusclientes = listameusclientes;
    }

    
    
    
    public void setListaAbertos(List<Atendimento> listaAbertos) {
        this.listaAbertos = listaAbertos;
    }

    public List<Atendimento> getQtdatendimentoscorretor() {
        return qtdatendimentoscorretor;
    }

    public void setQtdatendimentoscorretor(List<Atendimento> qtdatendimentoscorretor) {
        this.qtdatendimentoscorretor = qtdatendimentoscorretor;
    }
    
    
    
    
    private String[] strArray;

    public List<Agenda> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(List<Agenda> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

    
    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }

    public List<Atendimento> getListaMeusAtendimentos() {
        return listaMeusAtendimentos;
    }

    public void setListaMeusAtendimentos(List<Atendimento> listaMeusAtendimentos) {
        this.listaMeusAtendimentos = listaMeusAtendimentos;
    }

    public List<Atendimento> getListarminhasligacoes() {
        return listarminhasligacoes;
    }

    public void setListarminhasligacoes(List<Atendimento> listarminhasligacoes) {
        this.listarminhasligacoes = listarminhasligacoes;
    }

    public List<Atendimento> listaAtendimentosMesmoCliente;

    public List<Atendimento> getListaAtendimentosMesmoCliente() {
        return listaAtendimentosMesmoCliente;
    }

    public void setListaAtendimentosMesmoCliente(List<Atendimento> listaAtendimentosMesmoCliente) {
        this.listaAtendimentosMesmoCliente = listaAtendimentosMesmoCliente;
    }

    public List<Atendimento> getListaAtendimentoDetalhe() {
        return listaAtendimentoDetalhe;
    }

    public void setListaAtendimentoDetalhe(List<Atendimento> listaAtendimentoDetalhe) {
        this.listaAtendimentoDetalhe = listaAtendimentoDetalhe;
    }

    //abre um objeto com um novo atendimento
    private Atendimento atd = new Atendimento();
    
    private Agenda agenda = new Agenda();

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Atendimento getAtd() {
        return atd;
    }

    public void setAtd(Atendimento atd) {
        this.atd = atd;

    }
    
    private Atendimento atdEscolhido = new Atendimento();

    public Atendimento getAtdEscolhido() {
        return atdEscolhido;
    }

    public void setAtdEscolhido(Atendimento atdEscolhido) {
        this.atdEscolhido = atdEscolhido;
    }
    

    private String usuarioLogado;

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    private String permissao;

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
    

    private String[] myArray;

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    /*inserir os arrays no modelo detalheAtendimento
    
    
     private String[] bairrosArray;
     private String[] imovelArray;
     private String[] caracteristicasArray;
     private String[] negocioArray;

    public String[] getBairrosArray() {
        return bairrosArray;
    }

    public void setBairrosArray(String[] bairrosArray) {
        this.bairrosArray = bairrosArray;
    }

    public String[] getImovelArray() {
        return imovelArray;
    }

    public void setImovelArray(String[] imovelArray) {
        this.imovelArray = imovelArray;
    }

    public String[] getCaracteristicasArray() {
        return caracteristicasArray;
    }

    public void setCaracteristicasArray(String[] caracteristicasArray) {
        this.caracteristicasArray = caracteristicasArray;
    }

    public String[] getNegocioArray() {
        return negocioArray;
    }

    public void setNegocioArray(String[] negocioArray) {
        this.negocioArray = negocioArray;
    }

     */
    
    
    public void carregaSistema(){
        
        
            FacesContext context2 = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
            session.setAttribute("user",null);
            session.setAttribute("mostralogin","true");
        
    }
    
    
    public void cadastrarAtendimento() throws SQLException, IOException, NoSuchFieldException { //Metodo utilizado na tela abrir_atendimento.jsf

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String remoteIp = request.getRemoteAddr(); //pega o ip remoto

        java.util.Date d = new java.util.Date(); //quando trabalhar com data é necessário coverter de UTIL PARA SQL
        java.sql.Date dt = new java.sql.Date(d.getTime()); // quando trabalhar com DATA é necessário converter

        LocalTime tempo = java.time.LocalTime.now();   //pega a hora local
        atd.setHoraatendimento(tempo.toString()); //converte a hora local  e guarda no objeto a ser inserido

        atd.setDataatendimento(dt); //seta data do atendimento no objeto

        atd.setIp(remoteIp); //seta ip do cliente no objeto

        usuarioLogado="null";
        permissao="vazia";
        
         permissao=(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("permission");
         
         usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
         
         if(permissao.equals("CORRETOR")){
              atd.setCorretor(usuarioLogado);
         }
         
        
         
         String volta="nao";
        
        if (atd.getEuquero().equals("Falar com a Mariana")) {

            atd.setCorretor("Mariana");
            volta="sim";

        }
        if (atd.getEuquero().equals("Falar com a Sheyla")) {

            atd.setCorretor("Sheyla");
            volta="sim";
        }
        if (atd.getEuquero().equals("Falar com a Andrea")) {

            atd.setCorretor("Andrea");
            volta="sim";
        }
        if (atd.getEuquero().equals("Falar com a Administração")) {

            atd.setCorretor("gi");
            volta="sim";
        }
        if (atd.getEuquero().equals("Falar com o Flávio")) {

            atd.setCorretor("Flávio");
            volta="sim";
        }

        
        
        
        atd.setStatus("ABERTO");
        
        
        //Foi necessário setar o 4 campos abaixo com o valor de chaves sem nada pois 
        //caso o usuário abandonasse o atendimento sem preencher o atendimento, quando o corretor fosse pegar para atender
        //o sistema estava dando pau de
        atd.setCaracteristicas("[]");
        atd.setBairros("[]");
        atd.setTipoimovel("[]");
        atd.setNegocio("[]");
       
        
        Classe_Geral cg = new Classe_Geral("atendimento");

        int inserido = cg.inserirDadosTabela("atendimento", atd); //PEGA VALOR CHAVE INSERIDO NA TABELA ATENDIMENTO

        //Teste de inserção de um campo em branco na tabela detalhe atendimento
        // dtla.setOrigematendimento(inserido);
        //Classe_Geral cg2= new Classe_Geral("detalheatendimento");
        ///int inser=cg2.inserirDadosTabela("detalheatendimento",dtla); NAO RESOLVEU QUANDO O USUARIO NAO TERMINA O REGISTRO
       

        this.atdEscolhido=buscaAtendimento(inserido);
         
        if ( (atd.getCorretor())==null) {
        
            
                FacesContext.getCurrentInstance().getExternalContext().redirect("detalhar_atendimento.jsf");
             
            
        } else {
            
             if (volta=="sim"){
                FacesContext.getCurrentInstance().getExternalContext().redirect("abrir_atendimento.jsf");
            } else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("triar_atendimento.jsf");
            }
             
           
            
        }

         atd = new Atendimento(); //limpaAtendimentos
        
        
        
        
    }
   
    
    //Método utilizado no Botao ATENDER do DashBoard
    public void listaDetalheAtendimento(int cadastro) throws SQLException, IOException {

        //  arrumar isso.....
        
        System.out.println("Id do contrato :"+cadastro);
        atdEscolhido = buscaAtendimento(cadastro); //esse metodo retornar o atendimento selecionado.

        
         System.out.println("Id do contrato :"+atdEscolhido.getNome());
                 
         System.out.println("Status Atendimento :"+atdEscolhido.getStatus());
         
        // metodo Flávio Ventureli converter String em String[] 
        // Ao trazer o Array gravado no banco de dados [Piscina, Churrasqueira] estes dados estao armazenados
        //em uma variavel varchar e precisam ser convertidas em array, porém para que fiquem compatíveis com
        // os componentes do primefaces é necessário limpar espaços e caracteres.
        System.out.println(" [] valor" + atdEscolhido.getCaracteristicas());

        if (atdEscolhido.getCaracteristicas().equals("[]")) {

        } else {

            String caracstring = atdEscolhido.getCaracteristicas().replace("[", ""); //substitui [ do valor trazido do banco.
            caracstring = caracstring.replace("]", "");//substitui [ do valor trazido do banco.
            caracstring = caracstring.replace(", ", ","); //substitui espaços do inicio de cada valor
            atdEscolhido.setCaracteristicasArray(caracstring.split(",")); //transforma a String em Array usando sepador dos campos a Virgula
        }

        if (atdEscolhido.getNegocio().equals("[]")) {

        } else {
            String negociostring = atdEscolhido.getNegocio().replace("[", ""); //substitui [ do valor trazido do banco.
            negociostring = negociostring.replace("]", "");//substitui [ do valor trazido do banco.
            negociostring = negociostring.replace(", ", ","); //substitui espaços.
            atdEscolhido.setNegocioArray(negociostring.split(","));

        }

        if (atdEscolhido.getBairros().equals("[]")) {

        } else {
            String bairrostring = atdEscolhido.getBairros().replace("[", ""); //substitui [ do valor trazido do banco.
            bairrostring = bairrostring.replace("]", "");//substitui [ do valor trazido do banco.
            bairrostring = bairrostring.replace(", ", ","); //substitui espaços.
            atdEscolhido.setBairrosArray(bairrostring.split(","));
        }

        if (atdEscolhido.getTipoimovel().equals("[]")) {

        } else {
            String tipoimovelstring = atdEscolhido.getTipoimovel().replace("[", ""); //substitui [ do valor trazido do banco.
            tipoimovelstring = tipoimovelstring.replace("]", "");//substitui [ do valor trazido do banco.
            tipoimovelstring = tipoimovelstring.replace(", ", ","); //substitui espaços.
            atdEscolhido.setImovelArray(tipoimovelstring.split(","));

        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("triar_atendimento.jsf");

        this.buscaAgenda(atdEscolhido.getId());
        
       
         Classe_Geral cg = new Classe_Geral("atendimento");
         
         if(atdEscolhido.getStatus().equals("Finalizado")){
             System.out.println("atendimento já finalizado, não pode ser Reatendido");
         }else{
              cg.pegaAtendimento(usuarioLogado, atdEscolhido.getId()); //nesse metodo seta o corretor logo que ele clica em Atender.
         }
         
        
        
        
    }

    
    
    public void gravadetalheAtendimento() throws SQLException, IOException { //metodo utilizado para gravar detalhe atendimento quando o usuário não esta logado.

        atdEscolhido.setNegocio(Arrays.toString(atdEscolhido.getNegocioArray()));
        atdEscolhido.setBairros(Arrays.toString(atdEscolhido.getBairrosArray()));
        atdEscolhido.setCaracteristicas(Arrays.toString(atdEscolhido.getCaracteristicasArray()));
        atdEscolhido.setTipoimovel(Arrays.toString(atdEscolhido.getImovelArray()));

        Classe_Geral alt = new Classe_Geral("atendimento");
        alt.alteraDadosTabela("atendimento", atdEscolhido, atdEscolhido.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("abrir_atendimento.jsf");

    }
      

    public void atualizarDadosAtendimento() throws SQLException, IOException { //metodo utilizado no botão pagina triar_atendimento.jsr botao Atualizar dados aTendimento

        java.util.Date d = new java.util.Date(); //quando trabalhar com data é necessário coverter de UTIL PARA SQL
        java.sql.Date dt = new java.sql.Date(d.getTime()); // quando trabalhar com DATA é necessário converter

        // LocalTime tempo = java.time.LocalTime.now();   //pega a hora local
        //atd.setHoraatendimento(tempo.toString()); //converte a hora local  e guarda no objeto a ser inserido
        //seta data do atendimento no objeto   
        usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        permissao=(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("permission");
 
        atdEscolhido.setNegocio(Arrays.toString(atdEscolhido.getNegocioArray()));
        atdEscolhido.setBairros(Arrays.toString(atdEscolhido.getBairrosArray()));
        atdEscolhido.setCaracteristicas(Arrays.toString(atdEscolhido.getCaracteristicasArray()));
        atdEscolhido.setTipoimovel(Arrays.toString(atdEscolhido.getImovelArray()));

        if (atdEscolhido.getEuquero().contains("Falar")) {
            atdEscolhido.setEuquero("Comprar ou Alugar");

        }

        
        if(permissao.equals("CORRETOR")){
            atdEscolhido.setCorretor(usuarioLogado); //setar Corretor
             atdEscolhido.setStatus("EM ATENDIMENTO");
            
        }
      
        //Setar Status novamente
        atdEscolhido.setDatainicioatendimento(dt);                     //Atualizar objeto

        Classe_Geral alt = new Classe_Geral("atendimento");
        alt.alteraDadosTabela("atendimento", atdEscolhido, atdEscolhido.getId());

        //FacesContext.getCurrentInstance().getExternalContext().redirect("triar_atendimento.jsf");
        
        // RequestContext.getCurrentInstance().update("atividade");
        
        alt.alteraCorretorAgenda(usuarioLogado,atdEscolhido.getId());
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Obrigado :-)", "Seu Atendimento Foi Gravado com Sucesso !"));
        RequestContext.getCurrentInstance().update("msg");
        
        this.atividadesRevisar();

    }
   
    
    public void finalizarAtendimento() throws SQLException, IOException, NoSuchFieldException {

        
          RequestContext.getCurrentInstance().execute("PF('dlg5').show();");
       
          

    }
    
    public void confirmafinalizarAtendimento() throws SQLException, IOException {
        
        
         
        
        System.out.println("Motivo Finalinzou :"+atdEscolhido.getMotivofinalizou());
        
        atdEscolhido.setNegocio(Arrays.toString(atdEscolhido.getNegocioArray()));
        atdEscolhido.setBairros(Arrays.toString(atdEscolhido.getBairrosArray()));
        atdEscolhido.setCaracteristicas(Arrays.toString(atdEscolhido.getCaracteristicasArray()));
        atdEscolhido.setTipoimovel(Arrays.toString(atdEscolhido.getImovelArray()));
        atdEscolhido.setStatus("Finalizado");
   
        Classe_Geral alt = new Classe_Geral("atendimento");
        alt.alteraDadosTabela("atendimento", atdEscolhido, atdEscolhido.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardcrm.jsf");
        
        RequestContext.getCurrentInstance().execute("PF('dlg5').hide();");
      
    }
    
    
    public void apagarAtendimento(Integer cod) throws SQLException, IOException {

        Classe_Geral deleta = new Classe_Geral("atendimento");

        deleta.excluir("id", cod);
        
        Classe_Geral delagenda=new Classe_Geral("agenda");
        delagenda.excluir("idatendimento",cod);

        FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardadm.jsf");

    }

    
     public void devolverAtendimento(Integer cod) throws SQLException, IOException {

        
        atdEscolhido = buscaAtendimento(cod);
         
        Classe_Geral alt = new Classe_Geral("atendimento");
        atdEscolhido.setCorretor("");
        atdEscolhido.setStatus("ABERTO");
        alt.alteraDadosTabela("atendimento", atdEscolhido, atdEscolhido.getId());
        
        
        alt.alteraCorretorAgenda("", atdEscolhido.getId()); //usa metodo especifico criado para mudar o corretor para null;
        
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("dashboardcrm.jsf");
        
        
        
        

    }


    public Atendimento buscaAtendimento(int cadastro) throws SQLException, IOException {

        ResultSetHandler<Atendimento> h = new BeanHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        Atendimento atendimentoSelecionado = run.query("SELECT * FROM crm.atendimento where id=?", h, cadastro);

        return atendimentoSelecionado;
    }
     
    

    public void listar_meusAtendimentos() throws SQLException {

        usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        String sql = "SELECT * FROM crm.atendimento where (corretor='" + usuarioLogado + "' OR corretor is null OR status='ABERTO') AND (euquero NOT LIKE '%falar%') order by id desc";

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        listaMeusAtendimentos = run.query(sql, h);
        
        
        this.loadStatisticsDashboard();
        this.atividadesRevisar();
        
        
        
    }

    
    public void listar_minhasLigacoes() throws SQLException {
            
         usuarioLogado = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
         String sql = "SELECT * FROM crm.atendimento where corretor='" + usuarioLogado + "' AND euquero like '%falar%' AND status='ABERTO' order by id desc";
       
         ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
         QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
         listarminhasligacoes = run.query(sql, h);
    
         
        
    }
        
        
    
    public void listaAtendimentosMesmoCliente() throws SQLException {
        String sql = "SELECT * FROM crm.atendimento where telefone like '%" +atdEscolhido.getTelefone() + "%'";
        ResultSetHandler<List<Atendimento>> h2 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR2 = new QueryRunner(CustomDataSource.getInstance());
        listaAtendimentosMesmoCliente = QR2.query(sql, h2);
        
        System.out.println(sql);
    }
    
    
    public void loadStatisticsDashboard() throws SQLException{
        
        String sql7 = "SELECT * FROM crm.atendimento where status='ABERTO' AND euquero not like '%falar%'";
        ResultSetHandler<List<Atendimento>> h7 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listaAbertos = QR7.query(sql7, h7);
        
        
        String sqlqtda = "SELECT * FROM crm.atendimento where (corretor='" + usuarioLogado + "' AND status!='ABERTO') AND (euquero NOT LIKE '%falar%') order by id desc";

        ResultSetHandler<List<Atendimento>> h = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        qtdatendimentoscorretor = run.query(sqlqtda, h);
        
    }
   
    
    public void buscaAgenda(int Cadastro) throws SQLException{ //busca atividades relacionadas ao atendimento utilizado no triarAtendimento
        String sql7 = "SELECT * FROM crm.agenda where idatendimento='"+atdEscolhido.getId()+"'";
        ResultSetHandler<List<Agenda>> h7 = new BeanListHandler<Agenda>(Agenda.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listaAtividades = QR7.query(sql7, h7);
           
    }
   
    
    public void listarMeusClientes() throws SQLException{ //busca clientes do corretor agrupados
        String sql77 = "SELECT nome,ddd,telefone,email FROM crm.atendimento where corretor='"+usuarioLogado+"'";
        ResultSetHandler<List<Atendimento>> h7 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listameusclientes = QR7.query(sql77, h7);
        
        System.out.println(sql77);
           
    }
    
    public void carregaCombobox() throws SQLException{ //busca clientes do corretor agrupados
        String sql177 = "SELECT acao from crm.acoes";
        ResultSetHandler<List<Acoes>> h7 = new BeanListHandler<Acoes>(Acoes.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listaacoes = QR7.query(sql177, h7);
            
    }
    
   
    public Agenda buscaAtividade(int cadastro) throws SQLException, IOException {

        ResultSetHandler<Agenda> h = new BeanHandler<Agenda>(Agenda.class);
        QueryRunner run = new QueryRunner(CustomDataSource.getInstance());
        Agenda agendaselecionada = run.query("SELECT * FROM crm.agenda where id=?", h, cadastro);

        return agendaselecionada;
    }


    public java.sql.Date sqlDate(java.util.Date calendarDate) {
        return new java.sql.Date(calendarDate.getTime());
    }
     
    public java.sql.Timestamp testaTMS(java.util.Date calendarDate) {//conversores de datatimestamp
        return new java.sql.Timestamp(calendarDate.getTime());
    }
    
    
    public void gravarAtividades() throws IOException, SQLException, ParseException{
         
        if(agenda.getData()!=null){
           
           Timestamp a=testaTMS(agenda.getData());

        
         agenda.setIdatendimento(atdEscolhido.getId());
         agenda.setData(a);
         agenda.setCorretor(atdEscolhido.getCorretor());
         
         Classe_Geral cg = new Classe_Geral("agenda");
         int inserido = cg.inserirDadosTabela("agenda", agenda); //PEGA VALOR CHAVE INSERIDO NA TABELA AGENDA
         
         
         
         this.buscaAgenda(atdEscolhido.getId());
        
        
        RequestContext context2 = RequestContext.getCurrentInstance();
        context2.execute("PF('dlg3').hide();");
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("triar_atendimento.jsf");
         
        RequestContext.getCurrentInstance().update("formabriratividade");
            
            
        }else{
           FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage("DATA :-)", "SELECIONE UMA DATA POR FAVOR !"));
          RequestContext.getCurrentInstance().update("form_atividade2");
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "OPS!", "SELECIONE UMA DATA POR FAVOR !! ;-("));  
        
        }
        
    
    }
   
    
    
      public void listarMinhaAgenda() throws SQLException { //busca atividades relacionadas ao atendimento utilizado no triarAtendimento

        String sql7 = "SELECT atendimento.nome as cliente,concat(atendimento.ddd,'-',atendimento.telefone) as telefone,agenda.id,agenda.idatendimento,agenda.evento,agenda.data,agenda.obs,agenda.corretor,agenda.status FROM crm.agenda,crm.atendimento where atendimento.id=agenda.idatendimento and atendimento.corretor='" + usuarioLogado + "' and agenda.status='ABERTO'";

        //  String sql7 = "SELECT * FROM crm.agenda where corretor='" + usuarioLogado + "' AND status ='Aberto'";
        ResultSetHandler<List<Agenda>> h7 = new BeanListHandler<Agenda>(Agenda.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listatodasatividades = QR7.query(sql7, h7);

        System.out.println(sql7);
    }

        
    public void abrirAtividade(int reg) throws SQLException, IOException {

        agenda = this.buscaAtividade(reg);

        RequestContext.getCurrentInstance().update("form_atividade2");

        RequestContext.getCurrentInstance().execute("PF('dlg4').show();");

    }

    
    public void novaAtividade() throws SQLException, IOException {

        this.atualizarDadosAtendimento();

        agenda = new Agenda();
        RequestContext.getCurrentInstance().update("form_atividade");
        RequestContext.getCurrentInstance().execute("PF('dlg3').show();");

    }

    
    
    public void novaAtividade2() throws SQLException, IOException {

        if (agenda.getData() != null) {

            Timestamp a = testaTMS(agenda.getData());

            agenda.setData(a);

            Classe_Geral cg = new Classe_Geral("agenda");

            cg.alteraDadosTabela("agenda", agenda, agenda.getId());

            this.buscaAgenda(atdEscolhido.getId());
            
            RequestContext.getCurrentInstance().execute("PF('dlg4').hide();");

          
        
            
            RequestContext.getCurrentInstance().update("formabriratividade");

        }else{
           FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage("DATA :-)", "SELECIONE UMA DATA POR FAVOR !"));
          RequestContext.getCurrentInstance().update("form_atividade2");
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "OPS!", "SELECIONE UMA DATA POR FAVOR !! ;-("));  
        
        }


    }

public void atividadesRevisar() throws SQLException {

String sql7 = "SELECT id,nome,dataatendimento,status,corretor FROM crm.atendimento where "
        + "(id not in ( select idatendimento from crm.agenda ) and euquero not like 'Falar%' and corretor='"+ usuarioLogado+"')";
      
        ResultSetHandler<List<Atendimento>> h7 = new BeanListHandler<Atendimento>(Atendimento.class);
        QueryRunner QR7 = new QueryRunner(CustomDataSource.getInstance());
        listaatendimentosrevisar = QR7.query(sql7, h7);

        System.out.println(sql7);
    }



}
    

