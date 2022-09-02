package br.com.praticsistemas.pratic.faturamento.relatorio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnRelatorios;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJComboBox;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtlib.telas.CompTelas;

public class EmitirContratoDeTransporte extends UnRelatorios {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbEmpCod;
  private UnJLabel lbInfo;
  private UnJLabel lbIni;
  private UnJLabel lbFina;
  private EditPratic empCod;
  private UnJLabel lbDescEmpCod;
  private UnJLabel lbFilCod;
  private EditPratic filCod;
  private UnJLabel lbDescFilCod;
  private UnJLabel pedCte;
  private EditPratic cteI;
  private EditPratic cteF;
  private UnJLabel numCte;
  private EditPratic numI;
  private EditPratic numF;
  private UnJLabel emiCte;
  private editFormatado emiI;
  private editFormatado emiF;
  private UnJLabel lbOrd;
  private UnJComboBox ord;

  public EmitirContratoDeTransporte() {

	initialize();

  }

  private void initialize() {
	this.setTitle("Relatório de Contrato de Transporte");
	this.setCodigoTela("4312");
	this.setCampoFocoAberturaTela(getFilCod());
	this.setSize(new Dimension(511, 313));
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new InternalFrameAdapter() {
	  @Override
	  public void internalFrameClosed(InternalFrameEvent e) {
		DeskPratic.telasFinan.emitirContratoDeTransporte = null;
	  }
	});

  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_lbInfo = new GridBagConstraints();
	  gbc_lbInfo.fill = GridBagConstraints.BOTH;
	  gbc_lbInfo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbInfo.gridx = 0;
	  gbc_lbInfo.gridy = 0;
	  panelCentral.add(getLbInfo(), gbc_lbInfo);
	  GridBagConstraints gbc_lbIni = new GridBagConstraints();
	  gbc_lbIni.fill = GridBagConstraints.BOTH;
	  gbc_lbIni.insets = new Insets(2, 3, 0, 0);
	  gbc_lbIni.gridwidth = 2;
	  gbc_lbIni.gridx = 1;
	  gbc_lbIni.gridy = 0;
	  panelCentral.add(getLbIni(), gbc_lbIni);
	  GridBagConstraints gbc_lbFina = new GridBagConstraints();
	  gbc_lbFina.fill = GridBagConstraints.BOTH;
	  gbc_lbFina.insets = new Insets(2, 3, 0, 3);
	  gbc_lbFina.gridx = 3;
	  gbc_lbFina.gridy = 0;
	  panelCentral.add(getLbFina(), gbc_lbFina);
	  GridBagConstraints gbc_lbEmpCod = new GridBagConstraints();
	  gbc_lbEmpCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbEmpCod.fill = GridBagConstraints.BOTH;
	  gbc_lbEmpCod.gridx = 0;
	  gbc_lbEmpCod.gridy = 1;
	  panelCentral.add(getLbEmpCod(), gbc_lbEmpCod);
	  GridBagConstraints gbc_empCod = new GridBagConstraints();
	  gbc_empCod.insets = new Insets(2, 3, 0, 0);
	  gbc_empCod.fill = GridBagConstraints.BOTH;
	  gbc_empCod.gridx = 1;
	  gbc_empCod.gridy = 1;
	  panelCentral.add(getEmpCod(), gbc_empCod);
	  GridBagConstraints gbc_lbDescEmpCod = new GridBagConstraints();
	  gbc_lbDescEmpCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescEmpCod.gridwidth = 2;
	  gbc_lbDescEmpCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescEmpCod.gridx = 2;
	  gbc_lbDescEmpCod.gridy = 1;
	  panelCentral.add(getLbDescEmpCod(), gbc_lbDescEmpCod);
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbFilCod.gridx = 0;
	  gbc_lbFilCod.gridy = 2;
	  panelCentral.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 0, 0);
	  gbc_filCod.fill = GridBagConstraints.BOTH;
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 2;
	  panelCentral.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFilCod.gridwidth = 2;
	  gbc_lbDescFilCod.gridx = 2;
	  gbc_lbDescFilCod.gridy = 2;
	  panelCentral.add(getLbDescFilCod(), gbc_lbDescFilCod);
	  GridBagConstraints gbc_pedCte = new GridBagConstraints();
	  gbc_pedCte.insets = new Insets(2, 3, 0, 0);
	  gbc_pedCte.fill = GridBagConstraints.BOTH;
	  gbc_pedCte.gridx = 0;
	  gbc_pedCte.gridy = 3;
	  panelCentral.add(getPedCte(), gbc_pedCte);
	  GridBagConstraints gbc_cteI = new GridBagConstraints();
	  gbc_cteI.insets = new Insets(2, 3, 0, 0);
	  gbc_cteI.gridwidth = 2;
	  gbc_cteI.fill = GridBagConstraints.BOTH;
	  gbc_cteI.gridx = 1;
	  gbc_cteI.gridy = 3;
	  panelCentral.add(getCteI(), gbc_cteI);
	  GridBagConstraints gbc_cteF = new GridBagConstraints();
	  gbc_cteF.insets = new Insets(2, 3, 0, 3);
	  gbc_cteF.fill = GridBagConstraints.BOTH;
	  gbc_cteF.gridx = 3;
	  gbc_cteF.gridy = 3;
	  panelCentral.add(getCteF(), gbc_cteF);
	  GridBagConstraints gbc_numCte = new GridBagConstraints();
	  gbc_numCte.insets = new Insets(2, 3, 0, 0);
	  gbc_numCte.fill = GridBagConstraints.BOTH;
	  gbc_numCte.gridx = 0;
	  gbc_numCte.gridy = 4;
	  panelCentral.add(getNumCte(), gbc_numCte);
	  GridBagConstraints gbc_numI = new GridBagConstraints();
	  gbc_numI.insets = new Insets(2, 3, 0, 0);
	  gbc_numI.gridwidth = 2;
	  gbc_numI.fill = GridBagConstraints.HORIZONTAL;
	  gbc_numI.gridx = 1;
	  gbc_numI.gridy = 4;
	  panelCentral.add(getNumI(), gbc_numI);
	  GridBagConstraints gbc_numF = new GridBagConstraints();
	  gbc_numF.insets = new Insets(2, 3, 0, 3);
	  gbc_numF.fill = GridBagConstraints.HORIZONTAL;
	  gbc_numF.gridx = 3;
	  gbc_numF.gridy = 4;
	  panelCentral.add(getNumF(), gbc_numF);
	  GridBagConstraints gbc_emiCte = new GridBagConstraints();
	  gbc_emiCte.insets = new Insets(2, 3, 0, 0);
	  gbc_emiCte.fill = GridBagConstraints.BOTH;
	  gbc_emiCte.gridx = 0;
	  gbc_emiCte.gridy = 5;
	  panelCentral.add(getEmiCte(), gbc_emiCte);
	  GridBagConstraints gbc_emiI = new GridBagConstraints();
	  gbc_emiI.insets = new Insets(2, 3, 0, 0);
	  gbc_emiI.gridwidth = 2;
	  gbc_emiI.fill = GridBagConstraints.BOTH;
	  gbc_emiI.gridx = 1;
	  gbc_emiI.gridy = 5;
	  panelCentral.add(getEmiI(), gbc_emiI);
	  GridBagConstraints gbc_emiF = new GridBagConstraints();
	  gbc_emiF.insets = new Insets(2, 3, 0, 3);
	  gbc_emiF.fill = GridBagConstraints.BOTH;
	  gbc_emiF.gridx = 3;
	  gbc_emiF.gridy = 5;
	  panelCentral.add(getEmiF(), gbc_emiF);
	  GridBagConstraints gbc_lbOrd = new GridBagConstraints();
	  gbc_lbOrd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbOrd.fill = GridBagConstraints.BOTH;
	  gbc_lbOrd.gridx = 0;
	  gbc_lbOrd.gridy = 6;
	  panelCentral.add(getLbOrd(), gbc_lbOrd);
	  GridBagConstraints gbc_ord = new GridBagConstraints();
	  gbc_ord.insets = new Insets(2, 3, 0, 3);
	  gbc_ord.gridwidth = 3;
	  gbc_ord.fill = GridBagConstraints.BOTH;
	  gbc_ord.gridx = 1;
	  gbc_ord.gridy = 6;
	  panelCentral.add(getOrd(), gbc_ord);
	}
	return panelCentral;
  }

  private UnJLabel getLbEmpCod() {
	if (lbEmpCod == null) {
	  lbEmpCod = new UnJLabel();
	  lbEmpCod.setForeground(Color.BLUE);
	  lbEmpCod.setText("Empresa:");
	}
	return lbEmpCod;
  }

  private UnJLabel getLbInfo() {
	if (lbInfo == null) {
	  lbInfo = new UnJLabel();
	  lbInfo.setText("Informa\u00E7\u00E3o");
	  lbInfo.setPreferredSize(new Dimension(200, 20));
	  lbInfo.setMinimumSize(new Dimension(200, 20));
	  lbInfo.setMaximumSize(new Dimension(200, 20));
	  lbInfo.setHorizontalAlignment(SwingConstants.CENTER);
	  lbInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbInfo;
  }

  private UnJLabel getLbIni() {
	if (lbIni == null) {
	  lbIni = new UnJLabel();
	  lbIni.setText("Inicial");
	  lbIni.setPreferredSize(new Dimension(100, 20));
	  lbIni.setMinimumSize(new Dimension(100, 20));
	  lbIni.setMaximumSize(new Dimension(100, 20));
	  lbIni.setHorizontalAlignment(SwingConstants.CENTER);
	  lbIni.setForeground(Color.BLUE);
	  lbIni.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbIni;
  }

  private UnJLabel getLbFina() {
	if (lbFina == null) {
	  lbFina = new UnJLabel();
	  lbFina.setText("Final");
	  lbFina.setPreferredSize(new Dimension(100, 20));
	  lbFina.setMinimumSize(new Dimension(100, 20));
	  lbFina.setMaximumSize(new Dimension(100, 20));
	  lbFina.setHorizontalAlignment(SwingConstants.CENTER);
	  lbFina.setForeground(Color.BLUE);
	  lbFina.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	return lbFina;
  }

  private EditPratic getEmpCod() {
	if (empCod == null) {
	  empCod = new EditPratic();
	  empCod.setTipoValidacao("empresa");
	  empCod.setName2("Empresa");
	  empCod.setLabelDescricao(getLbDescEmpCod());
	}
	return empCod;
  }

  private UnJLabel getLbDescEmpCod() {
	if (lbDescEmpCod == null) {
	  lbDescEmpCod = new UnJLabel();
	  lbDescEmpCod.setText("lbEmpCod");
	  lbDescEmpCod.setPreferredSize(new Dimension(150, 0));
	  lbDescEmpCod.setMinimumSize(new Dimension(150, 0));
	  lbDescEmpCod.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescEmpCod;
  }

  private UnJLabel getLbFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("Filial:  ");
	  lbFilCod.setForeground(Color.BLUE);
	}
	return lbFilCod;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setTipoValidacao("filiais");
	  filCod.setName2("C\u00F3digo da Filial Inicial");
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setLabelDescricao(getLbDescFilCod());
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbDescFilCod == null) {
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setText("lbFilCod");
	  lbDescFilCod.setPreferredSize(new Dimension(100, 19));
	  lbDescFilCod.setMinimumSize(new Dimension(100, 19));
	  lbDescFilCod.setMaximumSize(new Dimension(100, 19));
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescFilCod;
  }

  private UnJLabel getPedCte() {
	if (pedCte == null) {
	  pedCte = new UnJLabel();
	  pedCte.setText("Pedido CTe:");
	  pedCte.setForeground(Color.BLACK);
	}
	return pedCte;
  }

  private EditPratic getCteI() {
	if (cteI == null) {
	  cteI = new EditPratic();
	  cteI.setName2("Codigo Cte Inicial");
	}
	return cteI;
  }

  private EditPratic getCteF() {
	if (cteF == null) {
	  cteF = new EditPratic();
	  cteF.setName2("Codigo Cte Final");
	}
	return cteF;
  }

  private UnJLabel getNumCte() {
	if (numCte == null) {
	  numCte = new UnJLabel();
	  numCte.setText("N\u00BA\u00A0CTe:");
	  numCte.setForeground(Color.BLACK);
	}
	return numCte;
  }

  private EditPratic getNumI() {
	if (numI == null) {
	  numI = new EditPratic();
	  numI.setName2("Numero Cte Inicial");
	}
	return numI;
  }

  private EditPratic getNumF() {
	if (numF == null) {
	  numF = new EditPratic();
	  numF.setName2("Numero Cte Final");
	}
	return numF;
  }

  private UnJLabel getEmiCte() {
	if (emiCte == null) {
	  emiCte = new UnJLabel();
	  emiCte.setText("Emiss\u00E3o CTe:");
	  emiCte.setForeground(Color.BLACK);
	}
	return emiCte;
  }

  private editFormatado getEmiI() {
	if (emiI == null) {
	  emiI = new editFormatado();
	  emiI.setTipoFormatacao(4);
	  emiI.setText("01011980");
	  emiI.setName2("Data Emiss\u00E3o Inical");
	}
	return emiI;
  }

  private editFormatado getEmiF() {
	if (emiF == null) {
	  emiF = new editFormatado();
	  emiF.setTipoFormatacao(4);
	  emiF.setText("31122099");
	  emiF.setName2("Data Emiss\u00E3o Inical");
	}
	return emiF;
  }

  private UnJLabel getLbOrd() {
	if (lbOrd == null) {
	  lbOrd = new UnJLabel();
	  lbOrd.setText("Ordena\u00E7\u00E3o:");
	  lbOrd.setPreferredSize(new Dimension(100, 19));
	  lbOrd.setMinimumSize(new Dimension(100, 19));
	}
	return lbOrd;
  }

  private UnJComboBox getOrd() {
	if (ord == null) {
	  ord = new UnJComboBox();
	  ord.montaItem("Data Emissão", -1, "E");
	  ord.montaItem("N° do CTe", -1, "N");
	  ord.montaItem("Pedido do CTe", -1, "P");
	}
	return ord;
  }

  @Override
  public void run() {

	relContratoDeTransporte();

  }

  @Override
  public boolean validaTela() {
	if (CompTelas.validaTelaAutomatico(panelCentral, false) == false) {
	  return false;
	}
	return true;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private void relContratoDeTransporte() {

	setNomeRelatorio("Relatório de Contrato de Transporte");
	setMensagemProgresso("Preparando -> " + getNomeRelatorio());

	try {
	  parameters = new HashMap();
	  parameters.put("WEMP", getEmpCod().getText());
	  parameters.put("WFIL", getFilCod().getValorShort());
	  parameters.put("CTEI", getCteI().getValorLong());
	  parameters.put("CTEF", getCteF().getValorLong());
	  parameters.put("NUMI", getNumI().getValorInteger());
	  parameters.put("NUMF", getNumF().getValorInteger());
	  parameters.put("EMII", getEmiI().getValorDate());
	  parameters.put("EMIF", getEmiF().getValorDate());
	  parameters.put("WORD", getOrd().getValor());
	  parameters.put("conexao", DeskPratic.getConexao_2());

	  mostrarRelatorioGraficoEmail(getEmpCod().getText(), parameters, null,
		  "ES_ContratoDeTransporte.jasper");

	} catch (Exception ex) {
	  getErro().setErro(ex);
	  finalizaProcesso();
	}
  }

  public void montarRelatorio(String empresa, String filial, String CteI, String CteF, String NumI,
	  String NumF) {
	getEmpCod().setText(empresa);
	getFilCod().setText(filial);
	getCteI().setText(CteI);
	getCteF().setText(CteF);
	getNumI().setText(NumI);
	getNumF().setText(NumF);
	getBtnAceitar().requestFocus();
  }
}
