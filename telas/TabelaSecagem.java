package br.com.praticsistemas.pratic.faturamento.compras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastroEmpresa;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.JButton.UnJButton;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.telas.CompTelas;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TabelaSecagem extends UnCadastroEmpresa {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbFilCod;
  private EditPratic filCod;
  private UnJLabel lbDescFilCod;
  private UnJLabel lbProCod;
  private EditPratic proCod;
  private UnJLabel proCodDes;
  private JPanel panelFilialProduto;
  private JPanel panelVigencia;
  private UnJLabel lbSecDat;
  private editFormatado secDat;
  private UnJLabel lbPerIni;
  private UnJLabel lbPerFim;
  private editFormatado perIni;
  private editFormatado perFim;
  private UnJLabel lbSecVal;
  private editFormatado secVal;
  private UnJTablePratic tabelaRes;
  private UnJButton btnLancar;

  public TabelaSecagem() {

	initialize();
	montaTela();
  }

  private void initialize() {
	this.getBtnNovo().setEnabled(false);
	this.getBtnImprimir().setEnabled(false);
	this.setCampoChaveTelaEstrangeiro(true);
	this.setPreferredSize(new Dimension(735, 465));
	this.setMinimumSize(new Dimension(735, 465));
	this.setResizable(true);
	this.setCampoTelaTrabalho(getProCod());
	this.setCampoFocoAberturaTela(getProCod());
	this.setTitle("Controle de Safra");
	this.setCodigoTela("4314");
	this.setFocoAutomaticoGravaTela(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.tabelaSecagem = null; // Evento para não bloquear a tela
		// de abrir
	  }
	});
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 0, 0, 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelFilialProduto = new GridBagConstraints();
	  gbc_panelFilialProduto.gridwidth = 3;
	  gbc_panelFilialProduto.fill = GridBagConstraints.BOTH;
	  gbc_panelFilialProduto.gridx = 0;
	  gbc_panelFilialProduto.gridy = 0;
	  panelCentral.add(getPanelFilialProduto(), gbc_panelFilialProduto);
	  GridBagConstraints gbc_panelVigencia = new GridBagConstraints();
	  gbc_panelVigencia.gridwidth = 3;
	  gbc_panelVigencia.fill = GridBagConstraints.BOTH;
	  gbc_panelVigencia.gridx = 0;
	  gbc_panelVigencia.gridy = 1;
	  panelCentral.add(getPanelVigencia(), gbc_panelVigencia);
	  GridBagConstraints gbc_tabelaRes = new GridBagConstraints();
	  gbc_tabelaRes.gridwidth = 3;
	  gbc_tabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_tabelaRes.gridx = 0;
	  gbc_tabelaRes.gridy = 2;
	  panelCentral.add(getTabelaRes(), gbc_tabelaRes);
	}
	return panelCentral;
  }

  private UnJLabel getLbFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setForeground(Color.BLUE);
	  lbFilCod.setText("Filial:");
	}
	return lbFilCod;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setTipoValidacao("filiais");
	  filCod.setName("filcod");
	  filCod.setName2("Código da Filial Inicial");
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setCampoEmpresa(super.getEmpCod());
	  filCod.setCampoLimpaTelaAutomatico(false);
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setText("lbFilCod");
	  lbDescFilCod.setPreferredSize(new Dimension(100, 14));
	  lbDescFilCod.setMinimumSize(new Dimension(100, 14));
	  lbDescFilCod.setMaximumSize(new Dimension(100, 14));
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	  filCod.setLabelDescricao(getLbDescFilCod());
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbDescFilCod == null) {
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDescFilCod;
  }

  private UnJLabel getLbProCod() {
	if (lbProCod == null) {
	  lbProCod = new UnJLabel();
	  lbProCod.setText("Produto:");
	  lbProCod.setForeground(Color.BLUE);
	}
	return lbProCod;
  }

  private EditPratic getProCod() {
	if (proCod == null) {
	  proCod = new EditPratic();
	  proCod.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaTela();
		}
	  });
	  proCod.setCampoLimpaTelaAutomatico(false);
	  proCod.setTipoValidacao("produtos");
	  proCod.setName("PROCOD");
	  proCod.setAuxiliarDeTrabalho("procod");
	  proCod.setLabelDescricao(getProCodDes());
	}
	return proCod;
  }

  private UnJLabel getProCodDes() {
	if (proCodDes == null) {
	  proCodDes = new UnJLabel();
	  proCodDes.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return proCodDes;
  }

  private JPanel getPanelFilialProduto() {
	if (panelFilialProduto == null) {
	  panelFilialProduto = new JPanel();
	  panelFilialProduto
		  .setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	  GridBagLayout gbl_panelFilialProduto = new GridBagLayout();
	  gbl_panelFilialProduto.columnWidths = new int[] { 0, 0, 0, 0 };
	  gbl_panelFilialProduto.rowHeights = new int[] { 0, 0 };
	  gbl_panelFilialProduto.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelFilialProduto.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	  panelFilialProduto.setLayout(gbl_panelFilialProduto);
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilCod.gridx = 0;
	  gbc_lbFilCod.gridy = 0;
	  panelFilialProduto.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.fill = GridBagConstraints.BOTH;
	  gbc_filCod.insets = new Insets(2, 3, 0, 0);
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 0;
	  panelFilialProduto.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFilCod.gridx = 2;
	  gbc_lbDescFilCod.gridy = 0;
	  panelFilialProduto.add(getLbDescFilCod(), gbc_lbDescFilCod);
	}
	return panelFilialProduto;
  }

  private JPanel getPanelVigencia() {
	if (panelVigencia == null) {
	  panelVigencia = new JPanel();
	  GridBagLayout gbl_panelVigencia = new GridBagLayout();
	  gbl_panelVigencia.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelVigencia.rowHeights = new int[] { 0, 0, 0 };
	  gbl_panelVigencia.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
		  0.0, 0.0, Double.MIN_VALUE };
	  gbl_panelVigencia.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
	  panelVigencia.setLayout(gbl_panelVigencia);
	  GridBagConstraints gbc_lbProCod = new GridBagConstraints();
	  gbc_lbProCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbProCod.fill = GridBagConstraints.BOTH;
	  gbc_lbProCod.gridx = 0;
	  gbc_lbProCod.gridy = 0;
	  panelVigencia.add(getLbProCod(), gbc_lbProCod);
	  GridBagConstraints gbc_proCod = new GridBagConstraints();
	  gbc_proCod.anchor = GridBagConstraints.WEST;
	  gbc_proCod.gridwidth = 2;
	  gbc_proCod.insets = new Insets(2, 3, 0, 0);
	  gbc_proCod.fill = GridBagConstraints.VERTICAL;
	  gbc_proCod.gridx = 1;
	  gbc_proCod.gridy = 0;
	  panelVigencia.add(getProCod(), gbc_proCod);
	  GridBagConstraints gbc_proCodDes = new GridBagConstraints();
	  gbc_proCodDes.insets = new Insets(2, 3, 0, 3);
	  gbc_proCodDes.fill = GridBagConstraints.BOTH;
	  gbc_proCodDes.gridwidth = 9;
	  gbc_proCodDes.gridx = 3;
	  gbc_proCodDes.gridy = 0;
	  panelVigencia.add(getProCodDes(), gbc_proCodDes);
	  GridBagConstraints gbc_lbSecDat = new GridBagConstraints();
	  gbc_lbSecDat.fill = GridBagConstraints.BOTH;
	  gbc_lbSecDat.insets = new Insets(2, 3, 2, 0);
	  gbc_lbSecDat.gridx = 0;
	  gbc_lbSecDat.gridy = 1;
	  panelVigencia.add(getLbSecDat(), gbc_lbSecDat);
	  GridBagConstraints gbc_secDat = new GridBagConstraints();
	  gbc_secDat.gridwidth = 2;
	  gbc_secDat.insets = new Insets(2, 3, 2, 0);
	  gbc_secDat.fill = GridBagConstraints.BOTH;
	  gbc_secDat.gridx = 1;
	  gbc_secDat.gridy = 1;
	  panelVigencia.add(getSecDat(), gbc_secDat);
	  GridBagConstraints gbc_lbPerIni = new GridBagConstraints();
	  gbc_lbPerIni.insets = new Insets(2, 3, 2, 0);
	  gbc_lbPerIni.fill = GridBagConstraints.BOTH;
	  gbc_lbPerIni.gridx = 3;
	  gbc_lbPerIni.gridy = 1;
	  panelVigencia.add(getLbPerIni(), gbc_lbPerIni);
	  GridBagConstraints gbc_perIni = new GridBagConstraints();
	  gbc_perIni.insets = new Insets(2, 3, 2, 0);
	  gbc_perIni.fill = GridBagConstraints.BOTH;
	  gbc_perIni.gridx = 4;
	  gbc_perIni.gridy = 1;
	  panelVigencia.add(getPerIni(), gbc_perIni);
	  GridBagConstraints gbc_lbPerFim = new GridBagConstraints();
	  gbc_lbPerFim.insets = new Insets(2, 3, 2, 0);
	  gbc_lbPerFim.fill = GridBagConstraints.BOTH;
	  gbc_lbPerFim.gridx = 5;
	  gbc_lbPerFim.gridy = 1;
	  panelVigencia.add(getLbPerFim(), gbc_lbPerFim);
	  GridBagConstraints gbc_perFim = new GridBagConstraints();
	  gbc_perFim.insets = new Insets(2, 3, 2, 0);
	  gbc_perFim.fill = GridBagConstraints.BOTH;
	  gbc_perFim.gridx = 6;
	  gbc_perFim.gridy = 1;
	  panelVigencia.add(getPerFim(), gbc_perFim);
	  GridBagConstraints gbc_lbSecVal = new GridBagConstraints();
	  gbc_lbSecVal.insets = new Insets(2, 3, 2, 0);
	  gbc_lbSecVal.fill = GridBagConstraints.BOTH;
	  gbc_lbSecVal.gridx = 7;
	  gbc_lbSecVal.gridy = 1;
	  panelVigencia.add(getLbSecVal(), gbc_lbSecVal);
	  GridBagConstraints gbc_secVal = new GridBagConstraints();
	  gbc_secVal.insets = new Insets(2, 3, 2, 0);
	  gbc_secVal.fill = GridBagConstraints.BOTH;
	  gbc_secVal.gridx = 8;
	  gbc_secVal.gridy = 1;
	  panelVigencia.add(getSecVal(), gbc_secVal);
	  GridBagConstraints gbc_btnLancar = new GridBagConstraints();
	  gbc_btnLancar.anchor = GridBagConstraints.EAST;
	  gbc_btnLancar.insets = new Insets(2, 3, 2, 3);
	  gbc_btnLancar.fill = GridBagConstraints.VERTICAL;
	  gbc_btnLancar.gridwidth = 3;
	  gbc_btnLancar.gridx = 9;
	  gbc_btnLancar.gridy = 1;
	  panelVigencia.add(getBtnLancar(), gbc_btnLancar);
	}
	return panelVigencia;
  }

  private UnJLabel getLbSecDat() {
	if (lbSecDat == null) {
	  lbSecDat = new UnJLabel();
	  lbSecDat.setText("Data de Vig\u00EAncia:");
	}
	return lbSecDat;
  }

  private editFormatado getSecDat() {
	if (secDat == null) {
	  secDat = new editFormatado();
	  secDat.setCampoObrigatorio(false);
	  secDat.setCampoResultSetAutomatico(false);
	  secDat.setText("");
	  secDat.setPreferredSize(new Dimension(40, 19));
	  secDat.setMaximumSize(new Dimension(40, 19));
	  secDat.setMinimumSize(new Dimension(40, 19));
	  secDat.setTipoFormatacao(4);
	  secDat.setName("SECDAT");
	}
	return secDat;
  }

  private UnJLabel getLbPerIni() {
	if (lbPerIni == null) {
	  lbPerIni = new UnJLabel();
	  lbPerIni.setText("% Inicial:");
	}
	return lbPerIni;
  }

  private UnJLabel getLbPerFim() {
	if (lbPerFim == null) {
	  lbPerFim = new UnJLabel();
	  lbPerFim.setText("% Final:");
	}
	return lbPerFim;
  }

  private editFormatado getPerIni() {
	if (perIni == null) {
	  perIni = new editFormatado();
	  perIni.setCampoResultSetAutomatico(false);
	  perIni.setTipoFormatacao(7);
	  perIni.setName("PERINI");
	  perIni.setCampoObrigatorio(false);
	}
	return perIni;
  }

  private editFormatado getPerFim() {
	if (perFim == null) {
	  perFim = new editFormatado();
	  perFim.setCampoResultSetAutomatico(false);
	  perFim.setTipoFormatacao(7);
	  perFim.setName("PERFIM");
	  perFim.setCampoObrigatorio(false);
	}
	return perFim;
  }

  private UnJLabel getLbSecVal() {
	if (lbSecVal == null) {
	  lbSecVal = new UnJLabel();
	  lbSecVal.setText("Valor:");
	}
	return lbSecVal;
  }

  private editFormatado getSecVal() {
	if (secVal == null) {
	  secVal = new editFormatado();
	  secVal.setCampoResultSetAutomatico(false);
	  secVal.setTipoFormatacao(7);
	  secVal.setName("SECVAL");
	  secVal.setCampoObrigatorio(false);
	}
	return secVal;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes
		  .setCampoTitulosTabela("Cód. Produto, Produto, Data de Vigência, % Inicial, % Final, Valor");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_TABELA_SECAGEM2_ITENS");
	  tabelaRes.setCampoDadosTabela("PROCOD, PROCODDES, SECDAT, PERINI, PERFIM, SECVAL");
	  tabelaRes.setCampoTitulosTabelaTamanhos("60, 150, 100, 100, 100, 100");
	  tabelaRes.getTabela().setColunasCentralizadas("1");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getSecDat());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getPanelVigencia());
	  tabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	  tabelaRes.addUnJTablePraticListener(
		  new br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticListener() {
			public void acaoExcluirItemTabela(
				br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticEvent e) {
			  gravaTelaItens("E");
			}
		  });
	}
	return tabelaRes;
  }

  public boolean gravaTelaItens(String acao) {

	if (getSecDat().isVazio()) {
	  mostraMensagem("O Campo deve ser preenchido, verifique !");
	  getSecDat().requestFocus();
	  return false;
	}

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_TABELA_SECAGEM2_ITENS", 8, 2));
	  int param = 1;
	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, Types.INTEGER);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);

	  getProc().setInt(param++, getFilCod(), stp);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getProCod(), stp);
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("PROCOD"));
	  }

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setDate(param++, getSecDat(), stp);
	  }
	  else {
		getProc().setDate(param++, getTabelaRes().getDadosExcluir("SECDAT"));
	  }

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setDouble(param++, getPerIni(), stp);
	  }
	  else {
		getProc().setDouble(param++, getTabelaRes().getDadosExcluir("PERINI"));
	  }

	  getProc().setDouble(param++, getPerFim(), stp);
	  getProc().setDouble(param++, getSecVal(), stp);
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);

	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
		montaTela();
		limpaTela();
		getProCod().requestFocus();
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

  public boolean montaTela() {

	getTabelaRes().setCampoDadosTabelaWhere(
		" empcod = '" + getEmpCod().getText() + "' and filcod = " + DeskPratic.getPadraoFilial());

	if (!getProCod().isVazio()) {
	  getTabelaRes().setCampoDadosTabelaWhere(" empcod = '" + getEmpCod().getText() + "' and filcod = "
		  + getFilCod().getText() + " and proCod = " + getProCod().getText());
	}

	return getTabelaRes().montaTela("");
  }

  public boolean gravaTela() {

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_TABELA_SECAGEM2", 4, 2));

	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setInt(param++, getProCod(), stp);
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();
	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
		limpaTela();
		getProCod().requestFocus();
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

  private UnJButton getBtnLancar() {
	if (btnLancar == null) {
	  btnLancar = new UnJButton();
	  btnLancar.setTipoFormatacao("lancar");
	  btnLancar.setPreferredSize(new Dimension(60, 20));
	  btnLancar.setMinimumSize(new Dimension(60, 20));
	  btnLancar.setMaximumSize(new Dimension(60, 20));
	  btnLancar.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
		  if (validaTelaItens()) {
			gravaTelaItens("A");
		  }
		}
	  });
	}
	return btnLancar;
  }

  public boolean validaTelaItens() {
	return CompTelas.validaTelaAutomatico(getPanelVigencia(), false);
  }
}
