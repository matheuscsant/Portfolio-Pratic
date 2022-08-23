package br.com.praticsistemas.pratic.faturamento.processos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameEvent;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnProcessos;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.UnJTextoLivre;
import br.com.praticsistemas.unprtcomps.telas.JButton.UnJButton;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.TrataString;
import br.com.praticsistemas.unprtlib.telas.CompTelas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelarPedidosDeVendas extends UnProcessos {

  private static final long serialVersionUID = 1L;
  private static final String USUARIO_PERMITIDO_ALTERACAO = "1";

  private JPanel panelCentral;
  private JPanel panelCampos;
  private UnJLabel lbEmpCod;
  private EditPratic empCod;
  private UnJLabel lbDescEmpCod;
  private UnJLabel lbInfo;
  private UnJLabel lbInicial;
  private UnJLabel lbFinal;
  private UnJLabel lbFilCod;
  private EditPratic filCod;
  private UnJLabel lbDescFilCod;
  private UnJLabel lbDatPed;
  private editFormatado datI;
  private editFormatado datF;
  private UnJLabel lbMot;
  private UnJTextoLivre wMot;
  private UnJLabel lbOpeCod;
  private EditPratic opeCod;
  private UnJLabel lbDescOpeCod;
  private UnJTablePratic tabelaRes;
  private UnJButton btnLancar;

  public CancelarPedidosDeVendas() {

	initialize();
	limpaTela();

  }

  private void initialize() {

	this.setTitle("Cancelar Pedidos de Vendas");
	this.setCodigoTela("4310");
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.setCampoFocoAberturaTela(getEmpCod());
	this.setSize(560, 492);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cancelarPedidosDeVendas = null;
	  }

	  public void internalFrameOpened(InternalFrameEvent e) {
		if (getFctGeral().validarSenhaUsuario(USUARIO_PERMITIDO_ALTERACAO) == false) {
		  sairTela();
		}

	  }
	});

  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
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
	  gbc_tabelaRes.insets = new Insets(2, 0, 0, 0);
	  gbc_tabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_tabelaRes.gridx = 0;
	  gbc_tabelaRes.gridy = 1;
	  panelCentral.add(getTabelaRes(), gbc_tabelaRes);
	}
	return panelCentral;
  }

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 0, 0, 0, 187, 0, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbInfo = new GridBagConstraints();
	  gbc_lbInfo.fill = GridBagConstraints.BOTH;
	  gbc_lbInfo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbInfo.gridwidth = 4;
	  gbc_lbInfo.gridx = 0;
	  gbc_lbInfo.gridy = 0;
	  panelCampos.add(getLbInfo(), gbc_lbInfo);
	  GridBagConstraints gbc_lbInicial = new GridBagConstraints();
	  gbc_lbInicial.fill = GridBagConstraints.BOTH;
	  gbc_lbInicial.insets = new Insets(2, 3, 0, 0);
	  gbc_lbInicial.gridx = 4;
	  gbc_lbInicial.gridy = 0;
	  panelCampos.add(getLbInicial(), gbc_lbInicial);
	  GridBagConstraints gbc_lbFinal = new GridBagConstraints();
	  gbc_lbFinal.fill = GridBagConstraints.BOTH;
	  gbc_lbFinal.insets = new Insets(2, 3, 0, 3);
	  gbc_lbFinal.gridx = 5;
	  gbc_lbFinal.gridy = 0;
	  panelCampos.add(getLbFinal(), gbc_lbFinal);
	  GridBagConstraints gbc_lbEmpCod = new GridBagConstraints();
	  gbc_lbEmpCod.gridwidth = 4;
	  gbc_lbEmpCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbEmpCod.fill = GridBagConstraints.BOTH;
	  gbc_lbEmpCod.gridx = 0;
	  gbc_lbEmpCod.gridy = 1;
	  panelCampos.add(getLbEmpCod(), gbc_lbEmpCod);
	  GridBagConstraints gbc_empCod = new GridBagConstraints();
	  gbc_empCod.insets = new Insets(2, 3, 0, 0);
	  gbc_empCod.fill = GridBagConstraints.BOTH;
	  gbc_empCod.gridx = 4;
	  gbc_empCod.gridy = 1;
	  panelCampos.add(getEmpCod(), gbc_empCod);
	  GridBagConstraints gbc_lbDescEmpCod = new GridBagConstraints();
	  gbc_lbDescEmpCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescEmpCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescEmpCod.gridx = 5;
	  gbc_lbDescEmpCod.gridy = 1;
	  panelCampos.add(getLbDescEmpCod(), gbc_lbDescEmpCod);
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbFilCod.gridwidth = 4;
	  gbc_lbFilCod.gridx = 0;
	  gbc_lbFilCod.gridy = 2;
	  panelCampos.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 0, 0);
	  gbc_filCod.fill = GridBagConstraints.BOTH;
	  gbc_filCod.gridx = 4;
	  gbc_filCod.gridy = 2;
	  panelCampos.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescFilCod.gridx = 5;
	  gbc_lbDescFilCod.gridy = 2;
	  panelCampos.add(getLbDescFilCod(), gbc_lbDescFilCod);
	  GridBagConstraints gbc_lbDatPed = new GridBagConstraints();
	  gbc_lbDatPed.gridwidth = 4;
	  gbc_lbDatPed.fill = GridBagConstraints.BOTH;
	  gbc_lbDatPed.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDatPed.gridx = 0;
	  gbc_lbDatPed.gridy = 3;
	  panelCampos.add(getLbDatPed(), gbc_lbDatPed);
	  GridBagConstraints gbc_datI = new GridBagConstraints();
	  gbc_datI.insets = new Insets(2, 3, 0, 0);
	  gbc_datI.fill = GridBagConstraints.BOTH;
	  gbc_datI.gridx = 4;
	  gbc_datI.gridy = 3;
	  panelCampos.add(getDatI(), gbc_datI);
	  GridBagConstraints gbc_datF = new GridBagConstraints();
	  gbc_datF.insets = new Insets(2, 3, 0, 3);
	  gbc_datF.fill = GridBagConstraints.HORIZONTAL;
	  gbc_datF.gridx = 5;
	  gbc_datF.gridy = 3;
	  panelCampos.add(getDatF(), gbc_datF);
	  GridBagConstraints gbc_lbMot = new GridBagConstraints();
	  gbc_lbMot.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMot.fill = GridBagConstraints.BOTH;
	  gbc_lbMot.gridwidth = 4;
	  gbc_lbMot.gridx = 0;
	  gbc_lbMot.gridy = 4;
	  panelCampos.add(getLbMot(), gbc_lbMot);
	  GridBagConstraints gbc_wMot = new GridBagConstraints();
	  gbc_wMot.anchor = GridBagConstraints.WEST;
	  gbc_wMot.insets = new Insets(2, 3, 0, 0);
	  gbc_wMot.fill = GridBagConstraints.VERTICAL;
	  gbc_wMot.gridx = 4;
	  gbc_wMot.gridy = 4;
	  panelCampos.add(getWMot(), gbc_wMot);
	  GridBagConstraints gbc_lbOpeCod = new GridBagConstraints();
	  gbc_lbOpeCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbOpeCod.fill = GridBagConstraints.BOTH;
	  gbc_lbOpeCod.gridwidth = 4;
	  gbc_lbOpeCod.gridx = 0;
	  gbc_lbOpeCod.gridy = 5;
	  panelCampos.add(getLbOpeCod(), gbc_lbOpeCod);
	  GridBagConstraints gbc_opeCod = new GridBagConstraints();
	  gbc_opeCod.insets = new Insets(2, 3, 0, 0);
	  gbc_opeCod.fill = GridBagConstraints.BOTH;
	  gbc_opeCod.gridx = 4;
	  gbc_opeCod.gridy = 5;
	  panelCampos.add(getOpeCod(), gbc_opeCod);
	  GridBagConstraints gbc_lbDescOpeCod = new GridBagConstraints();
	  gbc_lbDescOpeCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescOpeCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescOpeCod.gridx = 5;
	  gbc_lbDescOpeCod.gridy = 5;
	  panelCampos.add(getLbDescOpeCod(), gbc_lbDescOpeCod);
	  GridBagConstraints gbc_btnLancar = new GridBagConstraints();
	  gbc_btnLancar.anchor = GridBagConstraints.EAST;
	  gbc_btnLancar.gridx = 5;
	  gbc_btnLancar.gridy = 6;
	  panelCampos.add(getBtnLancar(), gbc_btnLancar);
	}
	return panelCampos;
  }

  private UnJLabel getLbEmpCod() {
	if (lbEmpCod == null) {
	  lbEmpCod = new UnJLabel();
	  lbEmpCod.setForeground(Color.BLUE);
	  lbEmpCod.setText("Empresa:");
	}
	return lbEmpCod;
  }

  private EditPratic getEmpCod() {
	if (empCod == null) {
	  empCod = new EditPratic();
	  empCod.setTipoValidacao("empresa");
	  empCod.setAuxiliarDeTrabalho("empcod");
	  empCod.setName2("Código da Empresa Inicial");
	  empCod.setLabelDescricao(getLbDescEmpCod());
	  empCod.setPreferredSize(new Dimension(120, 20));
	  empCod.setMinimumSize(new Dimension(120, 20));
	}
	return empCod;
  }

  private UnJLabel getLbDescEmpCod() {
	if (lbDescEmpCod == null) {
	  lbDescEmpCod = new UnJLabel();
	  lbDescEmpCod.setText("lbDescEmpCod");
	  lbDescEmpCod.setFont(new Font("Arial", Font.BOLD, 12));
	  lbDescEmpCod.setPreferredSize(new Dimension(120, 20));
	  lbDescEmpCod.setMinimumSize(new Dimension(120, 20));
	}
	return lbDescEmpCod;
  }

  private UnJLabel getLbInfo() {
	if (lbInfo == null) {
	  lbInfo = new UnJLabel();
	  lbInfo.setText("Informa\u00E7\u00E3o");
	  lbInfo.setPreferredSize(new Dimension(230, 20));
	  lbInfo.setMinimumSize(new Dimension(230, 20));
	  lbInfo.setMaximumSize(new Dimension(230, 20));
	  lbInfo.setHorizontalAlignment(SwingConstants.CENTER);
	  lbInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbInfo;
  }

  private UnJLabel getLbInicial() {
	if (lbInicial == null) {
	  lbInicial = new UnJLabel();
	  lbInicial.setText("Inicial");
	  lbInicial.setPreferredSize(new Dimension(120, 20));
	  lbInicial.setMinimumSize(new Dimension(120, 20));
	  lbInicial.setMaximumSize(new Dimension(120, 20));
	  lbInicial.setHorizontalAlignment(SwingConstants.CENTER);
	  lbInicial.setForeground(Color.BLUE);
	  lbInicial.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbInicial;
  }

  private UnJLabel getLbFinal() {
	if (lbFinal == null) {
	  lbFinal = new UnJLabel();
	  lbFinal.setText("Final");
	  lbFinal.setPreferredSize(new Dimension(120, 20));
	  lbFinal.setMinimumSize(new Dimension(120, 20));
	  lbFinal.setMaximumSize(new Dimension(120, 20));
	  lbFinal.setHorizontalAlignment(SwingConstants.CENTER);
	  lbFinal.setForeground(Color.BLUE);
	  lbFinal.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbFinal;
  }

  private UnJLabel getLbFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("Filial:");
	  lbFilCod.setForeground(Color.BLUE);
	}
	return lbFilCod;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setTipoValidacao("filiais");
	  filCod.setName2("C\u00F3digo da Empresa Inicial");
	  filCod.setPreferredSize(new Dimension(120, 20));
	  filCod.setMinimumSize(new Dimension(120, 20));
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setCampoEmpresa(getEmpCod());
	  filCod.setName2("Código da Filial");
	  filCod.setLabelDescricao(getLbDescFilCod());
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbDescFilCod == null) {
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setText("lbDescFilCod");
	  lbDescFilCod.setPreferredSize(new Dimension(120, 20));
	  lbDescFilCod.setMinimumSize(new Dimension(120, 20));
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDescFilCod;
  }

  private UnJLabel getLbDatPed() {
	if (lbDatPed == null) {
	  lbDatPed = new UnJLabel();
	  lbDatPed.setText("Data\u00A0do\u00A0Pedido:");
	  lbDatPed.setPreferredSize(new Dimension(120, 20));
	  lbDatPed.setMinimumSize(new Dimension(120, 20));
	}
	return lbDatPed;
  }

  private editFormatado getDatI() {
	if (datI == null) {
	  datI = new editFormatado();
	  datI.setTipoFormatacao(4);
	  datI.setPreferredSize(new Dimension(120, 20));
	  datI.setMinimumSize(new Dimension(120, 20));
	  datI.setName2("Data Inicial");
	}
	return datI;
  }

  private editFormatado getDatF() {
	if (datF == null) {
	  datF = new editFormatado();
	  datF.setTipoFormatacao(4);
	  datF.setPreferredSize(new Dimension(120, 20));
	  datF.setMinimumSize(new Dimension(120, 20));
	  datF.setName2("Data Final");
	}
	return datF;
  }

  private UnJLabel getLbMot() {
	if (lbMot == null) {
	  lbMot = new UnJLabel();
	  lbMot.setText("Motivo\u00A0do\u00A0cancelamento\u00A0em\u00A0Grupo\u00A0dos\u00A0pedidos:");
	  lbMot.setPreferredSize(new Dimension(120, 20));
	  lbMot.setMinimumSize(new Dimension(120, 20));
	}
	return lbMot;
  }

  private UnJTextoLivre getWMot() {
	if (wMot == null) {
	  wMot = new UnJTextoLivre();
	  wMot.setCampoObrigatorio(true);
	  wMot.setToolTipText("Observa\u00E7\u00E3o da Carga");
	  wMot.setPreferredSize(new Dimension(80, 20));
	  wMot.setName("");
	  wMot.setMudarCorPreenchido(true);
	  wMot.setMinimumSize(new Dimension(80, 20));
	  wMot.setMaximumSize(new Dimension(80, 20));
	  wMot.setMaximoLength("2000");
	  wMot.setAutomaticoFuncoes(false);
	  wMot.setMudarCorPreenchido(true);
	  wMot.setDesk(DeskPratic.desktop);
	}
	return wMot;
  }

  private UnJLabel getLbOpeCod() {
	if (lbOpeCod == null) {
	  lbOpeCod = new UnJLabel();
	  lbOpeCod.setForeground(Color.BLUE);
	  lbOpeCod.setText("Tipo de Opera\u00E7\u00E3o:");
	  lbOpeCod.setMinimumSize(new Dimension(120, 20));
	  lbOpeCod.setPreferredSize(new Dimension(120, 20));
	  lbOpeCod.setMinimumSize(new Dimension(120, 20));
	}
	return lbOpeCod;
  }

  private EditPratic getOpeCod() {
	if (opeCod == null) {
	  opeCod = new EditPratic();
	  opeCod.setTipoValidacao("TIPO_OPERACAO_VENDAS");
	  opeCod.setCampoEmpresa(getEmpCod());
	  opeCod.setLabelDescricao(getLbDescOpeCod());
	}
	return opeCod;
  }

  private UnJLabel getLbDescOpeCod() {
	if (lbDescOpeCod == null) {
	  lbDescOpeCod = new UnJLabel();
	  lbDescOpeCod.setText("lbDescOpeCod");
	  lbDescOpeCod.setPreferredSize(new Dimension(120, 20));
	  lbDescOpeCod.setMinimumSize(new Dimension(120, 20));
	  lbDescOpeCod.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDescOpeCod;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela(
		  "Nº Pedido, Status, Tipo, Data do Pedido, Código, Nome do Cliente, Cidade, UF, Código, Nome do Vendedor");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_PEDVEN");
	  tabelaRes.setCampoDadosTabela(
		  "PEDCOD, PEDSTA, OPECOD || ' - ' || OPECODDES as OPECOD, PEDDAT, PEDCLI, PEDCLIDES, PEDCLICID, PEDCLIEST, VENCOD, VENCODDES");
	  tabelaRes.setCampoTitulosTabelaTamanhos("80, 100, 150, 100, 150, 300, 150, 80, 80, 300");
	  tabelaRes.setCampoDadosTabelaOrderBy("PEDCOD desc");
	  tabelaRes.getTabela().setColunasCentralizadas("1");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getFilCod());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getPanelCampos());
	  tabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	return tabelaRes;
  }

  private UnJButton getBtnLancar() {
	if (btnLancar == null) {
	  btnLancar = new UnJButton();
	  btnLancar.setTipoFormatacao("lancar");
	  btnLancar.setPreferredSize(new Dimension(80, 20));
	  btnLancar.setMinimumSize(new Dimension(80, 20));
	  btnLancar.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
		  if (CompTelas.validaTelaAutomatico(getPanelCampos(), false)) {
			montaTela("");
			getFilCod().requestFocus();
		  }
		}
	  });
	}
	return btnLancar;
  }

  public boolean montaTela(String codigo) {
	getTabelaRes().limpaTebela();

	getTabelaRes().setCampoDadosTabelaWhere("empcod = '" + getEmpCod().getText() + "' and filcod = "
		+ getFilCod().getText() + " and peddat >= '" + TrataString.dataBanco(getDatI().getValorDate())
		+ "' and peddat <= '" + TrataString.dataBanco(getDatF().getValorDate()) + "' and " + "opecod = "
		+ getOpeCod().getText() + " and pedsta in ('APROVADO','CADASTRADO')");

	getTabelaRes().montaTela("");

	return true;
  }

  public void gravaTela() {

	int param = 1;

	try {
	  Timestamp tempoRelatorio = null;
	  tempoRelatorio = associarPedidosCanceladosAnterior();

	  if (tempoRelatorio == null) {
		return;
	  }

	  getProc().setStp(stp);
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_CANCELA_PEDIDOS_VENDA", 4, 2));

	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setString(param++, getWMot(), stp);
	  stp.setTimestamp(param++, tempoRelatorio);

	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);

	  setMensagemProgresso(getProc().getProcedureMensagem());

	  montaTela("");

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	} catch (Exception ex) {
	  getErro().setErro(ex);
	}
  }

  public Timestamp associarPedidosCanceladosAnterior() throws Exception {
	Timestamp momentoAssociacao = null;

	mostraMensagem("Cancelando os Pedidos...");

	for (int i = 0; i < getTabelaRes().getTabela().getRowCount(); i++) {

	  String teste = getTabelaRes().getTabela().getValor(i, 0).toString();
	  if (teste.equalsIgnoreCase("true")) {
		String asside = getTabelaRes().getTabela().getValor(i, 1).toString();

		momentoAssociacao = gravarPedidosCancelados(asside, momentoAssociacao);
	  }
	}

	return momentoAssociacao;
  }

  public java.sql.Timestamp gravarPedidosCancelados(String asside, java.sql.Timestamp tempo) {

	int param = 1;

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("FAZ_ASSOCIACAO_PROCESSOS_5", 16, 1));
	  getProc().setStp(stp);

	  stp.registerOutParameter(param++, Types.TIMESTAMP);

	  getProc().setString(param++, "04", stp);
	  getProc().setLong(param++, asside);
	  stp.setTimestamp(param++, tempo);
	  stp.setString(param++, null);
	  stp.setInt(param++, 0);
	  stp.setDouble(param++, 0);
	  stp.setDouble(param++, 0);
	  stp.setDate(param++, null);
	  stp.setDate(param++, null);
	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  stp.setTimestamp(param++, null);
	  stp.setDouble(param++, 0);
	  stp.setDouble(param++, 0);
	  getProc().setInt(param++, 0);
	  getProc().setString(param++, null, stp);

	  stp.execute();

	  getProc().finalizarProcedure(stp, -1, -1, 1);
	  tempo = getProc().getProcedureTimestamp();

	} catch (SQLException e) {
	  getErro().setErro(e);
	  return null;
	}

	return tempo;
  }

  public void run() {

	gravaTela();

	finalizaProcesso();
  }

}
