package br.com.praticsistemas.pratic.faturamento.cadastros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastro;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;

public class ValorContribuicaoParaCliente extends UnCadastro {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private JPanel panelCampos;
  private JPanel panelGrid;
  private UnJTablePratic tabelaRes;
  private UnJLabel lbCliCod;
  private EditPratic cliCod;
  private UnJLabel lbDescCliCod;
  private UnJLabel lbData;
  private editFormatado data;
  private UnJLabel lbValorCont;
  private editFormatado valContCli;

  public ValorContribuicaoParaCliente() {

	initialize();
  }

  private void initialize() {
	setCampoChaveTelaEstrangeiro(true);

	this.setMinimumSize(new Dimension(730, 330));
	this.setPreferredSize(new Dimension(730, 330));
	this.setSize(new Dimension(730, 327));
	this.setTitle("Valor Contribuição p/ Cliente");
	this.setCodigoTela("4309");
	this.setFocoAutomaticoGravaTela(false);
	this.setCampoTelaTrabalho(getCliCod());
	this.setCampoFocoAberturaTela(getCliCod());
	this.setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_CONTRIBUICAO_CLIENTE");
	getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.valorContribuicaoParaCliente = null; // Evento para não bloquear
																   // a tela
		// de abrir
	  }
	});
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 0;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);
	  GridBagConstraints gbc_panelGrid = new GridBagConstraints();
	  gbc_panelGrid.fill = GridBagConstraints.BOTH;
	  gbc_panelGrid.gridx = 0;
	  gbc_panelGrid.gridy = 1;
	  panelCentral.add(getPanelGrid(), gbc_panelGrid);
	}
	return panelCentral;
  }

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  panelCampos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbCliCod = new GridBagConstraints();
	  gbc_lbCliCod.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCod.gridx = 0;
	  gbc_lbCliCod.gridy = 0;
	  panelCampos.add(getLbCliCod(), gbc_lbCliCod);
	  GridBagConstraints gbc_cliCod = new GridBagConstraints();
	  gbc_cliCod.anchor = GridBagConstraints.WEST;
	  gbc_cliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_cliCod.gridx = 1;
	  gbc_cliCod.gridy = 0;
	  panelCampos.add(getCliCod(), gbc_cliCod);
	  GridBagConstraints gbc_lbDescCliCod = new GridBagConstraints();
	  gbc_lbDescCliCod.gridwidth = 4;
	  gbc_lbDescCliCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescCliCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescCliCod.gridx = 2;
	  gbc_lbDescCliCod.gridy = 0;
	  panelCampos.add(getLbDescCliCod(), gbc_lbDescCliCod);
	  GridBagConstraints gbc_lbData = new GridBagConstraints();
	  gbc_lbData.anchor = GridBagConstraints.WEST;
	  gbc_lbData.fill = GridBagConstraints.VERTICAL;
	  gbc_lbData.insets = new Insets(2, 3, 0, 0);
	  gbc_lbData.gridx = 0;
	  gbc_lbData.gridy = 1;
	  panelCampos.add(getLbData(), gbc_lbData);
	  GridBagConstraints gbc_data = new GridBagConstraints();
	  gbc_data.gridwidth = 2;
	  gbc_data.anchor = GridBagConstraints.WEST;
	  gbc_data.insets = new Insets(2, 3, 0, 0);
	  gbc_data.fill = GridBagConstraints.VERTICAL;
	  gbc_data.gridx = 1;
	  gbc_data.gridy = 1;
	  panelCampos.add(getData(), gbc_data);
	  GridBagConstraints gbc_lbValorCont = new GridBagConstraints();
	  gbc_lbValorCont.anchor = GridBagConstraints.EAST;
	  gbc_lbValorCont.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorCont.gridx = 0;
	  gbc_lbValorCont.gridy = 2;
	  panelCampos.add(getLbValorCont(), gbc_lbValorCont);
	  GridBagConstraints gbc_valContCli = new GridBagConstraints();
	  gbc_valContCli.gridwidth = 2;
	  gbc_valContCli.anchor = GridBagConstraints.WEST;
	  gbc_valContCli.insets = new Insets(2, 3, 0, 0);
	  gbc_valContCli.fill = GridBagConstraints.VERTICAL;
	  gbc_valContCli.gridx = 1;
	  gbc_valContCli.gridy = 2;
	  panelCampos.add(getValContCli(), gbc_valContCli);
	}
	return panelCampos;
  }

  private JPanel getPanelGrid() {
	if (panelGrid == null) {
	  panelGrid = new JPanel();
	  GridBagLayout gbl_panelGrid = new GridBagLayout();
	  gbl_panelGrid.columnWidths = new int[] { 531, 0 };
	  gbl_panelGrid.rowHeights = new int[] { 158, 0 };
	  gbl_panelGrid.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelGrid.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	  panelGrid.setLayout(gbl_panelGrid);
	  GridBagConstraints gbc_tabelaRes = new GridBagConstraints();
	  gbc_tabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_tabelaRes.gridx = 0;
	  gbc_tabelaRes.gridy = 0;
	  panelGrid.add(getTabelaRes(), gbc_tabelaRes);
	}
	return panelGrid;
  }

  public boolean gravaTela() {

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_CONTRIBUICAO_CLIENTE", 4, 2));

	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getCliCod(), stp);
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("CLICOD"));
	  }
	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setDate(param++, getData(), stp);
	  }
	  else {
		getProc().setDate(param++, getTabelaRes().getDadosExcluir("CONDTA"));
	  }
	  getProc().setDouble(param++, getValContCli(), stp);
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();
	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
		montaTela("");
		limpaTela();
		getCliCod().requestFocus();
	  }

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  getErro().setErro(ex);
	  return false;
	}

	return true;
  }

  public boolean montaTela(String codigo) {

	getTabelaRes().setCampoDadosTabelaWhere(
		(getCliCod().isVazio()) ? "" : " CLICOD = " + getCliCod().getText() + " ");

	getTabelaRes().montaTela("");

	return true;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela("Cod. Cliente, Cliente, Data, Valor");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_CONTRIBUICAO_CLIENTE");
	  tabelaRes.setCampoDadosTabela("CLICOD, CLICODDES, CONDTA, CONVAL");
	  tabelaRes.setCampoTitulosTabelaTamanhos("90, 200, 90, 120");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getCliCod());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getPanelCampos());
	  tabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	  tabelaRes.addUnJTablePraticListener(
		  new br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticListener() {
			public void acaoExcluirItemTabela(
				br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticEvent e) {
			  gravaTela();
			}
		  });
	}
	return tabelaRes;
  }

  private UnJLabel getLbCliCod() {
	if (lbCliCod == null) {
	  lbCliCod = new UnJLabel();
	  lbCliCod.setForeground(Color.BLUE);
	  lbCliCod.setText("Cliente:");
	  lbCliCod.setMinimumSize(new Dimension(50, 20));
	  lbCliCod.setPreferredSize(new Dimension(50, 20));
	}
	return lbCliCod;
  }

  private EditPratic getCliCod() {
	if (cliCod == null) {
	  cliCod = new EditPratic();
	  cliCod.setTipoValidacao("cli_geral");
	  cliCod.setName("CLICOD");
	  cliCod.setName2("Cliente");
	  cliCod.setLabelDescricao(getLbDescCliCod());
	  cliCod.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  if (cliCod.isVazio()) {
			montaTela("");
		  }
		}
	  });
	}
	return cliCod;
  }

  private UnJLabel getLbDescCliCod() {
	if (lbDescCliCod == null) {
	  lbDescCliCod = new UnJLabel();
	  lbDescCliCod.setText("lbDescCodCli");
	  lbDescCliCod.setName("CLICODDES");
	  lbDescCliCod.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDescCliCod;
  }

  private UnJLabel getLbData() {
	if (lbData == null) {
	  lbData = new UnJLabel();
	  lbData.setText("Data:");
	  lbData.setPreferredSize(new Dimension(50, 20));
	  lbData.setMinimumSize(new Dimension(50, 20));
	  lbData.setForeground(Color.BLACK);
	}
	return lbData;
  }

  private editFormatado getData() {
	if (data == null) {
	  data = new editFormatado();
	  data.setName("CONDTA");
	  data.setTipoFormatacao(4);
	  data.setPreferredSize(new Dimension(90, 20));
	  data.setMinimumSize(new Dimension(90, 20));
	}
	return data;
  }

  private UnJLabel getLbValorCont() {
	if (lbValorCont == null) {
	  lbValorCont = new UnJLabel();
	  lbValorCont.setText("Valor\u00A0da\u00A0Contribui\u00E7\u00E3o.:");
	  lbValorCont.setPreferredSize(new Dimension(120, 20));
	  lbValorCont.setMinimumSize(new Dimension(120, 20));
	  lbValorCont.setForeground(Color.BLACK);
	}
	return lbValorCont;
  }

  private editFormatado getValContCli() {
	if (valContCli == null) {
	  valContCli = new editFormatado();
	  valContCli.setName("CONVAL");
	  valContCli.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  getBtnAceitar().requestFocus();
		}
	  });
	  valContCli.setQuantidadeCasasDecimais(6);
	  valContCli.setEventosQuantidadesDigitos(4);
	  valContCli.setTipoFormatacao(7);
	  valContCli.setMinimumSize(new Dimension(120, 20));
	  valContCli.setMaximumSize(new Dimension(120, 20));
	}
	return valContCli;
  }
}
