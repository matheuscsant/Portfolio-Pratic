package br.com.praticsistemas.pratic.faturamento.vendas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastro;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;

public class CadasGEB10 extends UnCadastro {

  private static final long serialVersionUID = 1L;

  private JPanel panelCentral;
  private JPanel panelCampos;
  private JPanel panelTabela;
  private UnJLabel lbData;
  private editFormatado dataGEB;
  private UnJLabel lbValor;
  private editFormatado valorGEB10;
  private UnJLabel lbPerPar;
  private editFormatado perParGEB10;
  private UnJLabel lbValorPar;
  private editFormatado valorParGEB10;
  private UnJTablePratic tabelaRes;

  public CadasGEB10() {
	initialize();

  }

  private void initialize() {
	this.setTitle("Cadastro GEB-10");
	this.setCodigoTela("4304");
	this.setSize(new Dimension(730, 415));
	this.setFocoAutomaticoGravaTela(false);
	this.getContentPane().add(getpanelCentral(), BorderLayout.CENTER);
	this.setCampoTelaTrabalho(getDataGEB());
	this.setCampoFocoAberturaTela(getDataGEB());
	this.setFocoAutomaticoGravaTela(false);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasGEB10 = null;
	  }
	});
  }

  public boolean montaTela(String codigo) {

	return getTabelaRes().montaTela("");

	// if (getdataGEB().isVazio() || getvalorGEB10().isVazio() || getvalorParGEB10().isVazio()) {
	// gettabelaRes().limpaTebela();
	// return false;
	// }

	// String dataTambem = " data = '" + TrataString.dataBanco(getdataGEB().getValorDate()) + "' ";

	// gettabelaRes().setCampoDadosTabelaWhere(" movdat = '" + getEmpCod().getText() + "' and filcod
	// = "
	// + getFilCod().getText() + " and vencod = " + getVenCod().getText()
	// + " order by empcod, filcod, vencod, movdat, movope ");

  }

  public boolean gravaTela() {

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_GEB10", 5, 2));

	  getProc().setStp(stp);
	  int param = 1;
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  // if (getProc().setDate(param++, getdataGEB(), stp);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setDate(param++, getDataGEB(), stp);
	  }
	  else {
		getProc().setDate(param++, getTabelaRes().getDadosExcluir("geb_data"));
	  }

	  getProc().setDouble(param++, getValorGEB10(), stp);
	  getProc().setDouble(param++, getPerParGEB10(), stp);
	  getProc().setDouble(param++, getValorParGEB10(), stp);

	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));
	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		return false;
	  }

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  getErro().setErro(ex);
	  return false;
	}

	if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
	  montaTela("");
	  getDataGEB().requestFocus();
	}

	return true;
  }

  private JPanel getpanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 23, 133, 122, 335, 94, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 59, 0, 0, 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);

	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.insets = new Insets(2, 3, 2, 3);
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridwidth = 5;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 0;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);

	  GridBagConstraints gbc_panelTabela = new GridBagConstraints();
	  gbc_panelTabela.gridheight = 4;
	  gbc_panelTabela.gridwidth = 5;
	  gbc_panelTabela.fill = GridBagConstraints.BOTH;
	  gbc_panelTabela.gridx = 0;
	  gbc_panelTabela.gridy = 1;
	  panelCentral.add(getpanelTabela(), gbc_panelTabela);

	}
	return panelCentral;
  }

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  panelCampos.setBorder(
		  new TitledBorder(null, "Cadastro GEB-10", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 47, 88, 0, 93, 0, 95, 110, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 0, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
		  Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);

	  GridBagConstraints gbc_lbData = new GridBagConstraints();
	  gbc_lbData.anchor = GridBagConstraints.EAST;
	  gbc_lbData.fill = GridBagConstraints.VERTICAL;
	  gbc_lbData.insets = new Insets(2, 3, 2, 3);
	  gbc_lbData.gridx = 0;
	  gbc_lbData.gridy = 0;
	  panelCampos.add(getlbData(), gbc_lbData);

	  GridBagConstraints gbc_dataGEB = new GridBagConstraints();
	  gbc_dataGEB.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataGEB.gridx = 1;
	  gbc_dataGEB.gridy = 0;
	  panelCampos.add(getDataGEB(), gbc_dataGEB);

	  GridBagConstraints gbc_lbValor = new GridBagConstraints();
	  gbc_lbValor.anchor = GridBagConstraints.EAST;
	  gbc_lbValor.insets = new Insets(2, 3, 2, 3);
	  gbc_lbValor.gridx = 2;
	  gbc_lbValor.gridy = 0;
	  panelCampos.add(getlbValor(), gbc_lbValor);

	  GridBagConstraints gbc_valorGEB10 = new GridBagConstraints();
	  gbc_valorGEB10.insets = new Insets(2, 3, 2, 3);
	  gbc_valorGEB10.anchor = GridBagConstraints.WEST;
	  gbc_valorGEB10.gridx = 3;
	  gbc_valorGEB10.gridy = 0;
	  panelCampos.add(getValorGEB10(), gbc_valorGEB10);

	  GridBagConstraints gbc_lbPerPar = new GridBagConstraints();
	  gbc_lbPerPar.anchor = GridBagConstraints.EAST;
	  gbc_lbPerPar.gridx = 4;
	  gbc_lbPerPar.gridy = 0;
	  panelCampos.add(getlbPerPar(), gbc_lbPerPar);

	  GridBagConstraints gbc_perParGEB10 = new GridBagConstraints();
	  gbc_perParGEB10.anchor = GridBagConstraints.WEST;
	  gbc_perParGEB10.insets = new Insets(2, 3, 2, 3);
	  gbc_perParGEB10.gridx = 5;
	  gbc_perParGEB10.gridy = 0;
	  panelCampos.add(getPerParGEB10(), gbc_perParGEB10);

	  GridBagConstraints gbc_lbValorPar = new GridBagConstraints();
	  gbc_lbValorPar.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbValorPar.gridx = 6;
	  gbc_lbValorPar.gridy = 0;
	  panelCampos.add(getlbValorPar(), gbc_lbValorPar);

	  GridBagConstraints gbc_valorParGEB10 = new GridBagConstraints();
	  gbc_valorParGEB10.insets = new Insets(2, 3, 2, 3);
	  gbc_valorParGEB10.fill = GridBagConstraints.HORIZONTAL;
	  gbc_valorParGEB10.gridx = 7;
	  gbc_valorParGEB10.gridy = 0;
	  panelCampos.add(getValorParGEB10(), gbc_valorParGEB10);

	}
	return panelCampos;
  }

  private JPanel getpanelTabela() {
	if (panelTabela == null) {
	  panelTabela = new JPanel();

	  GridBagLayout gbl_panelTabela = new GridBagLayout();
	  gbl_panelTabela.columnWidths = new int[] { 68, 229, 0, 0, 100, 0, 0 };
	  gbl_panelTabela.rowHeights = new int[] { 189, 0 };
	  gbl_panelTabela.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  gbl_panelTabela.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	  panelTabela.setLayout(gbl_panelTabela);

	  GridBagConstraints gbc_tabelaRes = new GridBagConstraints();
	  gbc_tabelaRes.gridwidth = 6;
	  gbc_tabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_tabelaRes.gridx = 0;
	  gbc_tabelaRes.gridy = 0;
	  panelTabela.add(getTabelaRes(), gbc_tabelaRes);

	}
	return panelTabela;
  }

  private UnJLabel getlbData() {
	if (lbData == null) {
	  lbData = new UnJLabel();
	  lbData.setHorizontalAlignment(SwingConstants.LEFT);
	  lbData.setText("Data:");
	  lbData.setPreferredSize(new Dimension(25, 14));
	  lbData.setMinimumSize(new Dimension(15, 14));
	  lbData.setMaximumSize(new Dimension(15, 14));
	}
	return lbData;
  }

  private editFormatado getDataGEB() {
	if (dataGEB == null) {
	  dataGEB = new editFormatado();
	  dataGEB.setCampoObrigatorio(false);
	  dataGEB.setTipoFormatacao(4);
	  dataGEB.setPreferredSize(new Dimension(40, 19));
	  dataGEB.setName2("%\u00A0Comiss\u00E3o");
	  dataGEB.setName("geb_data");
	  dataGEB.setMinimumSize(new Dimension(120, 19));
	  dataGEB.setCampoResultSetAutomatico(false);
	}

	return dataGEB;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela("Data, Valor , % Participação, Valor da Participação");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_GEB10");
	  tabelaRes.setCampoDadosTabela("geb_data, valor, perc_part, valor_part");
	  tabelaRes.setCampoTitulosTabelaTamanhos("110, 150, 400, 400");
	  tabelaRes.setCampoDadosTabelaOrderBy("geb_data desc");
	  tabelaRes.getTabela().setBackground(Color.white);
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getDataGEB());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getpanelCentral());
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

  private UnJLabel getlbValor() {
	if (lbValor == null) {
	  lbValor = new UnJLabel();
	  lbValor.setText("Valor:");
	}
	return lbValor;
  }

  private editFormatado getValorGEB10() {
	if (valorGEB10 == null) {
	  valorGEB10 = new editFormatado();
	  valorGEB10.setQuantidadeCasasDecimais(4);
	  valorGEB10.setName("valor");
	  valorGEB10.setToolTipText("");
	  valorGEB10.setTipoFormatacao(7);
	  valorGEB10.getQuantidadeCasasDecimais();
	  valorGEB10.setCampoObrigatorio(false);
	}
	return valorGEB10;
  }

  private UnJLabel getlbPerPar() {
	if (lbPerPar == null) {
	  lbPerPar = new UnJLabel();
	  lbPerPar.setText("%\u00A0Participa\u00E7\u00E3o:");
	}
	return lbPerPar;
  }

  private editFormatado getPerParGEB10() {
	if (perParGEB10 == null) {
	  perParGEB10 = new editFormatado();
	  perParGEB10.setQuantidadeCasasDecimais(4);
	  perParGEB10.setName("perc_part");
	  perParGEB10.setToolTipText("");
	  perParGEB10.setTipoFormatacao(7);
	  perParGEB10.getQuantidadeCasasDecimais();
	  perParGEB10.setCampoObrigatorio(false);
	}
	return perParGEB10;
  }

  private UnJLabel getlbValorPar() {
	if (lbValorPar == null) {
	  lbValorPar = new UnJLabel();
	  lbValorPar.setText("Valor\u00A0da\u00A0Participa\u00E7\u00E3o:");
	  lbValorPar.setPreferredSize(new Dimension(15, 14));
	  lbValorPar.setMinimumSize(new Dimension(15, 14));
	  lbValorPar.setMaximumSize(new Dimension(15, 14));
	}
	return lbValorPar;
  }

  private editFormatado getValorParGEB10() {
	if (valorParGEB10 == null) {
	  valorParGEB10 = new editFormatado();
	  valorParGEB10.setQuantidadeCasasDecimais(4);
	  valorParGEB10.setName("valor_part");
	  valorParGEB10.setToolTipText("");
	  valorParGEB10.setTipoFormatacao(7);
	  valorParGEB10.getQuantidadeCasasDecimais();
	  valorParGEB10.setCampoObrigatorio(false);
	}
	return valorParGEB10;
  }
}
