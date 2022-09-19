package br.com.praticsistemas.pratic.faturamento.vendas;

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
import javax.swing.border.TitledBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastro;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.telas.CompTelas;

public class CondicaoFormaRecebimento extends UnCadastro {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbCliCod;
  private UnJLabel cliCodDes;
  private UnJLabel lbCliCid;
  private UnJLabel cliCid;
  private UnJLabel lbCliUF;
  private UnJLabel cliUF;
  private JPanel panelCampos;
  private UnJLabel lbParCod;
  private UnJLabel lbDescParCod;
  private UnJLabel lbRecDod;
  private EditPratic cliCod;
  private EditPratic parCod;
  private EditPratic recDod;
  private UnJLabel lbDescRecDod;
  private UnJTablePratic tabelaRes;

  public CondicaoFormaRecebimento() {

	initialize();

  }

  private void initialize() {
	this.getBtnImprimir().setEnabled(false);
	this.getBtnNovo().setEnabled(false);
	this.setCampoChaveTelaEstrangeiro(true);
	this.setFocoAutomaticoGravaTela(false);
	this.setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_CLI_GERAL_CONDICOES_REC");
	this.setTitle("Cadastro de Condição e Forma de Recebimento");
	this.setResizable(true);
	this.setCodigoTela("4313");
	this.setCampoTelaTrabalho(getCliCod());
	this.setCampoFocoAberturaTela(getCliCod());
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.condicaoFormaRecebimento = null;
	  }
	});
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 0;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);
	  GridBagConstraints gbc_tabelaRes = new GridBagConstraints();
	  gbc_tabelaRes.insets = new Insets(2, 3, 0, 3);
	  gbc_tabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_tabelaRes.gridx = 0;
	  gbc_tabelaRes.gridy = 1;
	  panelCentral.add(getTabelaRes(), gbc_tabelaRes);
	}
	return panelCentral;
  }

  private UnJLabel getLbCliCod() {
	if (lbCliCod == null) {
	  lbCliCod = new UnJLabel();
	  lbCliCod.setForeground(Color.BLUE);
	  lbCliCod.setText("C\u00F3digo do Cliente:");
	}
	return lbCliCod;
  }

  private UnJLabel getCliCodDes() {
	if (cliCodDes == null) {
	  cliCodDes = new UnJLabel();
	  cliCodDes.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return cliCodDes;
  }

  private UnJLabel getLbCliCid() {
	if (lbCliCid == null) {
	  lbCliCid = new UnJLabel();
	  lbCliCid.setText("Cidade:");
	}
	return lbCliCid;
  }

  private UnJLabel getCliCid() {
	if (cliCid == null) {
	  cliCid = new UnJLabel();
	  cliCid.setFont(new Font("Arial", Font.BOLD, 12));
	  cliCid.setPreferredSize(new Dimension(230, 19));
	  cliCid.setMinimumSize(new Dimension(230, 19));

	}
	return cliCid;
  }

  private UnJLabel getLbCliUF() {
	if (lbCliUF == null) {
	  lbCliUF = new UnJLabel();
	  lbCliUF.setText("UF:");
	}
	return lbCliUF;
  }

  private UnJLabel getCliUF() {
	if (cliUF == null) {
	  cliUF = new UnJLabel();
	  cliUF.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return cliUF;
  }

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  panelCampos.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es do Cliente",
		  TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbCliCod = new GridBagConstraints();
	  gbc_lbCliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCod.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCod.gridx = 0;
	  gbc_lbCliCod.gridy = 0;
	  panelCampos.add(getLbCliCod(), gbc_lbCliCod);
	  GridBagConstraints gbc_cliCod = new GridBagConstraints();
	  gbc_cliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_cliCod.fill = GridBagConstraints.BOTH;
	  gbc_cliCod.gridx = 1;
	  gbc_cliCod.gridy = 0;
	  panelCampos.add(getCliCod(), gbc_cliCod);
	  GridBagConstraints gbc_cliCodDes = new GridBagConstraints();
	  gbc_cliCodDes.gridwidth = 3;
	  gbc_cliCodDes.insets = new Insets(2, 3, 0, 3);
	  gbc_cliCodDes.fill = GridBagConstraints.BOTH;
	  gbc_cliCodDes.gridx = 2;
	  gbc_cliCodDes.gridy = 0;
	  panelCampos.add(getCliCodDes(), gbc_cliCodDes);
	  GridBagConstraints gbc_lbCliCid = new GridBagConstraints();
	  gbc_lbCliCid.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCid.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCid.gridx = 0;
	  gbc_lbCliCid.gridy = 1;
	  panelCampos.add(getLbCliCid(), gbc_lbCliCid);
	  GridBagConstraints gbc_cliCid = new GridBagConstraints();
	  gbc_cliCid.insets = new Insets(2, 3, 0, 0);
	  gbc_cliCid.gridwidth = 2;
	  gbc_cliCid.fill = GridBagConstraints.BOTH;
	  gbc_cliCid.gridx = 1;
	  gbc_cliCid.gridy = 1;
	  panelCampos.add(getCliCid(), gbc_cliCid);
	  GridBagConstraints gbc_lbCliUF = new GridBagConstraints();
	  gbc_lbCliUF.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliUF.fill = GridBagConstraints.BOTH;
	  gbc_lbCliUF.gridx = 3;
	  gbc_lbCliUF.gridy = 1;
	  panelCampos.add(getLbCliUF(), gbc_lbCliUF);
	  GridBagConstraints gbc_cliUF = new GridBagConstraints();
	  gbc_cliUF.fill = GridBagConstraints.BOTH;
	  gbc_cliUF.insets = new Insets(2, 3, 0, 3);
	  gbc_cliUF.gridx = 4;
	  gbc_cliUF.gridy = 1;
	  panelCampos.add(getCliUF(), gbc_cliUF);
	  GridBagConstraints gbc_lbParCod = new GridBagConstraints();
	  gbc_lbParCod.anchor = GridBagConstraints.EAST;
	  gbc_lbParCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbParCod.fill = GridBagConstraints.VERTICAL;
	  gbc_lbParCod.gridx = 0;
	  gbc_lbParCod.gridy = 2;
	  panelCampos.add(getLbParCod(), gbc_lbParCod);
	  GridBagConstraints gbc_parCod = new GridBagConstraints();
	  gbc_parCod.insets = new Insets(2, 3, 0, 0);
	  gbc_parCod.fill = GridBagConstraints.BOTH;
	  gbc_parCod.gridx = 1;
	  gbc_parCod.gridy = 2;
	  panelCampos.add(getParCod(), gbc_parCod);
	  GridBagConstraints gbc_lbDescParCod = new GridBagConstraints();
	  gbc_lbDescParCod.gridwidth = 2;
	  gbc_lbDescParCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescParCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescParCod.gridx = 2;
	  gbc_lbDescParCod.gridy = 2;
	  panelCampos.add(getLbDescParCod(), gbc_lbDescParCod);
	  GridBagConstraints gbc_lbRecDod = new GridBagConstraints();
	  gbc_lbRecDod.fill = GridBagConstraints.BOTH;
	  gbc_lbRecDod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecDod.gridx = 0;
	  gbc_lbRecDod.gridy = 3;
	  panelCampos.add(getLbRecDod(), gbc_lbRecDod);
	  GridBagConstraints gbc_recDod = new GridBagConstraints();
	  gbc_recDod.insets = new Insets(2, 3, 0, 0);
	  gbc_recDod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_recDod.gridx = 1;
	  gbc_recDod.gridy = 3;
	  panelCampos.add(getRecDod(), gbc_recDod);
	  GridBagConstraints gbc_lbDescRecDod = new GridBagConstraints();
	  gbc_lbDescRecDod.gridwidth = 2;
	  gbc_lbDescRecDod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescRecDod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescRecDod.gridx = 2;
	  gbc_lbDescRecDod.gridy = 3;
	  panelCampos.add(getLbDescRecDod(), gbc_lbDescRecDod);
	}
	return panelCampos;
  }

  private UnJLabel getLbParCod() {
	if (lbParCod == null) {
	  lbParCod = new UnJLabel();
	  lbParCod.setForeground(Color.BLUE);
	  lbParCod.setText("Condi\u00E7\u00E3o de Recebimento:");
	}
	return lbParCod;
  }

  private UnJLabel getLbDescParCod() {
	if (lbDescParCod == null) {
	  lbDescParCod = new UnJLabel();
	  lbDescParCod.setPreferredSize(new Dimension(100, 19));
	  lbDescParCod.setName("PARCODDES");
	  lbDescParCod.setMinimumSize(new Dimension(100, 19));
	  lbDescParCod.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescParCod;
  }

  private UnJLabel getLbRecDod() {
	if (lbRecDod == null) {
	  lbRecDod = new UnJLabel();
	  lbRecDod.setForeground(Color.BLUE);
	  lbRecDod.setText("Forma de Recebimento:");
	}
	return lbRecDod;
  }

  private EditPratic getCliCod() {
	if (cliCod == null) {
	  cliCod = new EditPratic();
	  cliCod.setCampoLimpaTelaAutomatico(false);
	  cliCod.setTipoValidacao("cli_geral");
	  cliCod.setSoNumeros(true);
	  cliCod.setLabelDescricao(getCliCodDes());
	}
	return cliCod;
  }

  private EditPratic getParCod() {
	if (parCod == null) {
	  parCod = new EditPratic();
	  parCod.setTipoValidacao("parcob");
	  parCod.setName("PARCOD");
	  parCod.setText("");
	  parCod.setSoNumeros(true);
	  parCod.setLabelDescricao(getLbDescParCod());
	}
	return parCod;
  }

  private EditPratic getRecDod() {
	if (recDod == null) {
	  recDod = new EditPratic();
	  recDod.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  getBtnAceitar().requestFocus();
		}
	  });
	  recDod.setTipoValidacao("FORMA_RECEBIMENTO");
	  recDod.setName("RECDOD");
	  recDod.setText("");
	  recDod.setSoNumeros(true);
	  recDod.setLabelDescricao(getLbDescRecDod());
	}
	return recDod;
  }

  private UnJLabel getLbDescRecDod() {
	if (lbDescRecDod == null) {
	  lbDescRecDod = new UnJLabel();
	  lbDescRecDod.setPreferredSize(new Dimension(100, 19));
	  lbDescRecDod.setName("recdoddes");
	  lbDescRecDod.setMinimumSize(new Dimension(100, 19));
	  lbDescRecDod.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescRecDod;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela("Cód., Condição de Recebimento, Cód, Forma de Recebimento");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_CLI_GERAL_CONDICOES_REC");
	  tabelaRes.setCampoDadosTabela("PARCOD, PARCODDES, RECDOD, RECDODDES");
	  tabelaRes.setCampoTitulosTabelaTamanhos("30, 120, 30, 120");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getParCod());
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

  public boolean montaTela(String codigo) {

	if (!getCliCod().isVazio()) {
	  getCliCid().setText(DeskPratic.fctGeral.selectStringBanco(
		  "select MUNNOM from ES_VIEW_CLI_GERAL where CLICOD = " + getCliCod().getText()));
	  getCliUF().setText(DeskPratic.fctGeral.selectStringBanco(
		  "select CLIEST from ES_VIEW_CLI_GERAL where CLICOD = " + getCliCod().getText()));

	  getTabelaRes().setCampoDadosTabelaWhere("empcod = '" + DeskPratic.getPadraoEmpresa() + "'"
		  + (getCliCod().isVazio() ? "" : " and CLICOD = " + getCliCod().getText())
		  + (getParCod().isVazio() ? "" : " and PARCOD = " + getParCod().getText())
		  + (getRecDod().isVazio() ? "" : " and RECDOD = " + getRecDod().getText()));
	}
	else {
	  getTabelaRes().setCampoDadosTabelaWhere("empcod = '" + DeskPratic.getPadraoEmpresa() + "'");
	}

	getTabelaRes().montaTela("");

	return true;
  }

  public boolean gravaTela() {

	try {
	  int param = 1;
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_CLI_GERAL_CONDICOES_RECB", 5, 2));

	  getProc().setStp(stp);

	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, DeskPratic.getPadraoEmpresa(), stp);
	  getProc().setShort(param++, getCliCod(), stp);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getParCod(), stp);
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("PARCOD"));
	  }

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getRecDod(), stp);
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("RECDOD"));
	  }

	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));
	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		return false;
	  }

	  if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
		limpaTela();
		montaTela("");
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

  public boolean limpaTela() {

	CompTelas.limparCampos(getPanelCampos(), false);
	getTabelaRes().limpaTebela();
	getCliCid().limpar();
	getCliUF().limpar();

	return true;
  }
}
