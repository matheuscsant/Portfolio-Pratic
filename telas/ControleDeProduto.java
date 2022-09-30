package br.com.praticsistemas.pratic.faturamento.compras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastroEmpresa;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnEdit;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.UnJTextoLivre;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.TrataString;
import br.com.praticsistemas.unprtlib.numeros.Numeros;

public class ControleDeProduto extends UnCadastroEmpresa {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbFilCod;
  private JPanel panelFilial;
  private EditPratic filCod;
  private UnJLabel lbDescFilCod;
  private JPanel panelCampos;
  private UnJLabel lbProCod;
  private EditPratic proCod;
  private UnJLabel proCodDes;
  private UnJLabel lbConDat;
  private editFormatado conDat;
  private UnJLabel lbCliCod;
  private UnJLabel lbMsiAfi;
  private UnJLabel lbMotNom;
  private UnEdit motNom;
  private UnJLabel lbPlaFro;
  private UnEdit plaFro;
  private UnJLabel lbPesEnt;
  private editFormatado pesEnt;
  private UnJLabel lbPesSai;
  private editFormatado pesSai;
  private EditPratic cliCod;
  private EditPratic msiAfi;
  private UnJLabel lbPesLiq;
  private UnJLabel pesLiq;
  private UnJLabel lbQtdSac;
  private UnJLabel lbPerUmi;
  private editFormatado perUmi;
  private UnJLabel lbProSec;
  private EditPratic proSec;
  private UnJLabel lbValFre;
  private editFormatado valFre;
  private UnJLabel lbValArm;
  private editFormatado valArm;
  private UnJLabel lbValTot;
  private UnJLabel valTot;
  private UnJLabel lbPerRen;
  private editFormatado perRen;
  private UnJLabel lbIndAfl;
  private UnEdit indAfla;
  private UnJLabel lbPerQue;
  private editFormatado perQue;
  private editFormatado qtdSac;
  private UnJLabel lbQtdPer;
  private editFormatado qtdPer;
  private UnJLabel lbTotSac;
  private UnJLabel totSac;
  private UnJLabel lbLocDes;
  private EditPratic locDes;
  private UnJLabel lbFoment;
  private EditPratic foment;
  private UnJLabel lbConObs;
  private UnJTextoLivre conObs;
  private UnJTablePratic tabelaRes;
  private UnJLabel lbNumTic;
  private EditPratic numTic;
  private UnJLabel lbDesCliCod;
  private UnJLabel lbDesMsiAfi;
  private UnJLabel lbCliNom;
  private UnEdit cliNom;
  private UnJLabel lbDesProSec;
  private UnJLabel lbSecado;
  private UnJLabel secado;
  private UnJLabel lbMovIde;
  private UnJLabel movIde;

  public ControleDeProduto() {

	initialize();
	montaTela("");

  }

  private void initialize() {
	this.getBtnExcluir().setEnabled(false);;
	this.getBtnNovo().setEnabled(false);
	this.setResizable(true);
	this.setCampoChaveTelaEstrangeiro(true);
	this.setCampoTelaTrabalho(getProCod());
	this.setCampoFocoAberturaTela(getProCod());
	this.setPreferredSize(new Dimension(864, 652));
	this.setMinimumSize(new Dimension(864, 652));
	this.setSize(new Dimension(958, 652));
	this.setTitle("Controle de Produto");
	this.setCodigoTela("4315");
	this.setFocoAutomaticoGravaTela(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.controleDeProduto = null; // Evento para não bloquear a tela
		// de abrir
	  }
	});
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0, 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelFilial = new GridBagConstraints();
	  gbc_panelFilial.fill = GridBagConstraints.BOTH;
	  gbc_panelFilial.gridx = 0;
	  gbc_panelFilial.gridy = 0;
	  panelCentral.add(getPanelFilial(), gbc_panelFilial);
	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 1;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);
	  GridBagConstraints gbc_tabelaRes = new GridBagConstraints();
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
	  lbFilCod.setPreferredSize(new Dimension(40, 19));
	  lbFilCod.setMinimumSize(new Dimension(40, 19));
	  lbFilCod.setForeground(Color.BLUE);
	  lbFilCod.setText("Filial:");
	}
	return lbFilCod;
  }

  private JPanel getPanelFilial() {
	if (panelFilial == null) {
	  panelFilial = new JPanel();
	  GridBagLayout gbl_panelFilial = new GridBagLayout();
	  gbl_panelFilial.columnWidths = new int[] { 0, 0, 0, 0 };
	  gbl_panelFilial.rowHeights = new int[] { 0, 0 };
	  gbl_panelFilial.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelFilial.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	  panelFilial.setLayout(gbl_panelFilial);
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbFilCod.insets = new Insets(2, 3, 2, 0);
	  gbc_lbFilCod.gridx = 0;
	  gbc_lbFilCod.gridy = 0;
	  panelFilial.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 2, 0);
	  gbc_filCod.fill = GridBagConstraints.BOTH;
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 0;
	  panelFilial.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescFilCod.gridx = 2;
	  gbc_lbDescFilCod.gridy = 0;
	  panelFilial.add(getLbDescFilCod(), gbc_lbDescFilCod);
	}
	return panelFilial;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setTipoValidacao("filiais");
	  filCod.setName2("C\u00F3digo da Filial Inicial");
	  filCod.setName("filcod");
	  filCod.setCampoLimpaTelaAutomatico(false);
	  filCod.setAuxiliarDeTrabalho("filcod");
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

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  panelCampos.setBorder(new TitledBorder(null, "Campos de Controle", TitledBorder.LEADING,
		  TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  1.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbProCod = new GridBagConstraints();
	  gbc_lbProCod.fill = GridBagConstraints.BOTH;
	  gbc_lbProCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbProCod.gridx = 0;
	  gbc_lbProCod.gridy = 0;
	  panelCampos.add(getLbProCod(), gbc_lbProCod);
	  GridBagConstraints gbc_proCod = new GridBagConstraints();
	  gbc_proCod.gridwidth = 2;
	  gbc_proCod.insets = new Insets(2, 3, 0, 0);
	  gbc_proCod.fill = GridBagConstraints.BOTH;
	  gbc_proCod.gridx = 1;
	  gbc_proCod.gridy = 0;
	  panelCampos.add(getProCod(), gbc_proCod);
	  GridBagConstraints gbc_proCodDes = new GridBagConstraints();
	  gbc_proCodDes.gridwidth = 8;
	  gbc_proCodDes.fill = GridBagConstraints.BOTH;
	  gbc_proCodDes.insets = new Insets(2, 3, 0, 3);
	  gbc_proCodDes.gridx = 3;
	  gbc_proCodDes.gridy = 0;
	  panelCampos.add(getProCodDes(), gbc_proCodDes);
	  GridBagConstraints gbc_lbConDat = new GridBagConstraints();
	  gbc_lbConDat.insets = new Insets(2, 3, 0, 0);
	  gbc_lbConDat.fill = GridBagConstraints.BOTH;
	  gbc_lbConDat.gridx = 0;
	  gbc_lbConDat.gridy = 1;
	  panelCampos.add(getLbConDat(), gbc_lbConDat);
	  GridBagConstraints gbc_conDat = new GridBagConstraints();
	  gbc_conDat.gridwidth = 2;
	  gbc_conDat.insets = new Insets(2, 3, 0, 0);
	  gbc_conDat.fill = GridBagConstraints.HORIZONTAL;
	  gbc_conDat.gridx = 1;
	  gbc_conDat.gridy = 1;
	  panelCampos.add(getConDat(), gbc_conDat);
	  GridBagConstraints gbc_lbNumTic = new GridBagConstraints();
	  gbc_lbNumTic.insets = new Insets(2, 3, 0, 0);
	  gbc_lbNumTic.fill = GridBagConstraints.BOTH;
	  gbc_lbNumTic.gridx = 0;
	  gbc_lbNumTic.gridy = 2;
	  panelCampos.add(getLbNumTic(), gbc_lbNumTic);
	  GridBagConstraints gbc_numTic = new GridBagConstraints();
	  gbc_numTic.insets = new Insets(2, 3, 0, 0);
	  gbc_numTic.gridwidth = 3;
	  gbc_numTic.fill = GridBagConstraints.BOTH;
	  gbc_numTic.gridx = 1;
	  gbc_numTic.gridy = 2;
	  panelCampos.add(getNumTic(), gbc_numTic);
	  GridBagConstraints gbc_lbCliCod = new GridBagConstraints();
	  gbc_lbCliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCod.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCod.gridx = 0;
	  gbc_lbCliCod.gridy = 3;
	  panelCampos.add(getLbCliCod(), gbc_lbCliCod);
	  GridBagConstraints gbc_cliCod = new GridBagConstraints();
	  gbc_cliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_cliCod.gridwidth = 2;
	  gbc_cliCod.fill = GridBagConstraints.BOTH;
	  gbc_cliCod.gridx = 1;
	  gbc_cliCod.gridy = 3;
	  panelCampos.add(getCliCod(), gbc_cliCod);
	  GridBagConstraints gbc_lbDesCliCod = new GridBagConstraints();
	  gbc_lbDesCliCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDesCliCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDesCliCod.gridwidth = 8;
	  gbc_lbDesCliCod.gridx = 3;
	  gbc_lbDesCliCod.gridy = 3;
	  panelCampos.add(getLbDesCliCod(), gbc_lbDesCliCod);
	  GridBagConstraints gbc_lbCliNom = new GridBagConstraints();
	  gbc_lbCliNom.insets = new Insets(2, 3, 0, 3);
	  gbc_lbCliNom.fill = GridBagConstraints.BOTH;
	  gbc_lbCliNom.gridx = 0;
	  gbc_lbCliNom.gridy = 4;
	  panelCampos.add(getLbCliNom(), gbc_lbCliNom);
	  GridBagConstraints gbc_cliNom = new GridBagConstraints();
	  gbc_cliNom.insets = new Insets(2, 3, 0, 3);
	  gbc_cliNom.gridwidth = 10;
	  gbc_cliNom.fill = GridBagConstraints.BOTH;
	  gbc_cliNom.gridx = 1;
	  gbc_cliNom.gridy = 4;
	  panelCampos.add(getCliNom(), gbc_cliNom);
	  GridBagConstraints gbc_lbMsiAfi = new GridBagConstraints();
	  gbc_lbMsiAfi.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMsiAfi.fill = GridBagConstraints.BOTH;
	  gbc_lbMsiAfi.gridx = 0;
	  gbc_lbMsiAfi.gridy = 5;
	  panelCampos.add(getLbMsiAfi(), gbc_lbMsiAfi);
	  GridBagConstraints gbc_msiAfi = new GridBagConstraints();
	  gbc_msiAfi.insets = new Insets(2, 3, 0, 0);
	  gbc_msiAfi.gridwidth = 2;
	  gbc_msiAfi.fill = GridBagConstraints.BOTH;
	  gbc_msiAfi.gridx = 1;
	  gbc_msiAfi.gridy = 5;
	  panelCampos.add(getMsiAfi(), gbc_msiAfi);
	  GridBagConstraints gbc_lbDesMsiAfi = new GridBagConstraints();
	  gbc_lbDesMsiAfi.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDesMsiAfi.fill = GridBagConstraints.BOTH;
	  gbc_lbDesMsiAfi.gridwidth = 8;
	  gbc_lbDesMsiAfi.gridx = 3;
	  gbc_lbDesMsiAfi.gridy = 5;
	  panelCampos.add(getLbDesMsiAfi(), gbc_lbDesMsiAfi);
	  GridBagConstraints gbc_lbMotNom = new GridBagConstraints();
	  gbc_lbMotNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMotNom.fill = GridBagConstraints.BOTH;
	  gbc_lbMotNom.gridx = 0;
	  gbc_lbMotNom.gridy = 6;
	  panelCampos.add(getLbMotNom(), gbc_lbMotNom);
	  GridBagConstraints gbc_motNom = new GridBagConstraints();
	  gbc_motNom.insets = new Insets(2, 3, 0, 3);
	  gbc_motNom.gridwidth = 10;
	  gbc_motNom.fill = GridBagConstraints.BOTH;
	  gbc_motNom.gridx = 1;
	  gbc_motNom.gridy = 6;
	  panelCampos.add(getMotNom(), gbc_motNom);
	  GridBagConstraints gbc_lbPlaFro = new GridBagConstraints();
	  gbc_lbPlaFro.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPlaFro.fill = GridBagConstraints.BOTH;
	  gbc_lbPlaFro.gridx = 0;
	  gbc_lbPlaFro.gridy = 7;
	  panelCampos.add(getLbPlaFro(), gbc_lbPlaFro);
	  GridBagConstraints gbc_plaFro = new GridBagConstraints();
	  gbc_plaFro.gridwidth = 3;
	  gbc_plaFro.insets = new Insets(2, 3, 0, 0);
	  gbc_plaFro.fill = GridBagConstraints.BOTH;
	  gbc_plaFro.gridx = 1;
	  gbc_plaFro.gridy = 7;
	  panelCampos.add(getPlaFro(), gbc_plaFro);
	  GridBagConstraints gbc_lbPesEnt = new GridBagConstraints();
	  gbc_lbPesEnt.fill = GridBagConstraints.BOTH;
	  gbc_lbPesEnt.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesEnt.gridx = 4;
	  gbc_lbPesEnt.gridy = 7;
	  panelCampos.add(getLbPesEnt(), gbc_lbPesEnt);
	  GridBagConstraints gbc_pesEnt = new GridBagConstraints();
	  gbc_pesEnt.insets = new Insets(2, 3, 0, 0);
	  gbc_pesEnt.fill = GridBagConstraints.BOTH;
	  gbc_pesEnt.gridx = 5;
	  gbc_pesEnt.gridy = 7;
	  panelCampos.add(getPesEnt(), gbc_pesEnt);
	  GridBagConstraints gbc_lbPesSai = new GridBagConstraints();
	  gbc_lbPesSai.fill = GridBagConstraints.BOTH;
	  gbc_lbPesSai.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesSai.gridx = 6;
	  gbc_lbPesSai.gridy = 7;
	  panelCampos.add(getLbPesSai(), gbc_lbPesSai);
	  GridBagConstraints gbc_pesSai = new GridBagConstraints();
	  gbc_pesSai.insets = new Insets(2, 3, 0, 0);
	  gbc_pesSai.fill = GridBagConstraints.HORIZONTAL;
	  gbc_pesSai.gridx = 7;
	  gbc_pesSai.gridy = 7;
	  panelCampos.add(getPesSai(), gbc_pesSai);
	  GridBagConstraints gbc_lbQtdSac = new GridBagConstraints();
	  gbc_lbQtdSac.insets = new Insets(2, 3, 0, 0);
	  gbc_lbQtdSac.fill = GridBagConstraints.BOTH;
	  gbc_lbQtdSac.gridx = 0;
	  gbc_lbQtdSac.gridy = 8;
	  panelCampos.add(getLbQtdSac(), gbc_lbQtdSac);
	  GridBagConstraints gbc_qtdSac = new GridBagConstraints();
	  gbc_qtdSac.insets = new Insets(2, 3, 0, 0);
	  gbc_qtdSac.gridwidth = 2;
	  gbc_qtdSac.fill = GridBagConstraints.HORIZONTAL;
	  gbc_qtdSac.gridx = 1;
	  gbc_qtdSac.gridy = 8;
	  panelCampos.add(getQtdSac(), gbc_qtdSac);
	  GridBagConstraints gbc_lbPesLiq = new GridBagConstraints();
	  gbc_lbPesLiq.fill = GridBagConstraints.BOTH;
	  gbc_lbPesLiq.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesLiq.gridx = 6;
	  gbc_lbPesLiq.gridy = 8;
	  panelCampos.add(getLbPesLiq(), gbc_lbPesLiq);
	  GridBagConstraints gbc_pesLiq = new GridBagConstraints();
	  gbc_pesLiq.fill = GridBagConstraints.BOTH;
	  gbc_pesLiq.insets = new Insets(2, 3, 0, 0);
	  gbc_pesLiq.gridx = 7;
	  gbc_pesLiq.gridy = 8;
	  panelCampos.add(getPesLiq(), gbc_pesLiq);
	  GridBagConstraints gbc_lbPerUmi = new GridBagConstraints();
	  gbc_lbPerUmi.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPerUmi.fill = GridBagConstraints.BOTH;
	  gbc_lbPerUmi.gridx = 0;
	  gbc_lbPerUmi.gridy = 9;
	  panelCampos.add(getLbPerUmi(), gbc_lbPerUmi);
	  GridBagConstraints gbc_perUmi = new GridBagConstraints();
	  gbc_perUmi.insets = new Insets(2, 3, 0, 0);
	  gbc_perUmi.gridwidth = 2;
	  gbc_perUmi.fill = GridBagConstraints.BOTH;
	  gbc_perUmi.gridx = 1;
	  gbc_perUmi.gridy = 9;
	  panelCampos.add(getPerUmi(), gbc_perUmi);
	  GridBagConstraints gbc_lbProSec = new GridBagConstraints();
	  gbc_lbProSec.insets = new Insets(2, 3, 0, 0);
	  gbc_lbProSec.fill = GridBagConstraints.BOTH;
	  gbc_lbProSec.gridx = 0;
	  gbc_lbProSec.gridy = 10;
	  panelCampos.add(getLbProSec(), gbc_lbProSec);
	  GridBagConstraints gbc_proSec = new GridBagConstraints();
	  gbc_proSec.gridwidth = 2;
	  gbc_proSec.insets = new Insets(2, 3, 0, 0);
	  gbc_proSec.fill = GridBagConstraints.BOTH;
	  gbc_proSec.gridx = 1;
	  gbc_proSec.gridy = 10;
	  panelCampos.add(getProSec(), gbc_proSec);
	  GridBagConstraints gbc_lbDesProSec = new GridBagConstraints();
	  gbc_lbDesProSec.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDesProSec.fill = GridBagConstraints.BOTH;
	  gbc_lbDesProSec.gridwidth = 8;
	  gbc_lbDesProSec.gridx = 3;
	  gbc_lbDesProSec.gridy = 10;
	  panelCampos.add(getLbDesProSec(), gbc_lbDesProSec);
	  GridBagConstraints gbc_lbPerRen = new GridBagConstraints();
	  gbc_lbPerRen.fill = GridBagConstraints.BOTH;
	  gbc_lbPerRen.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPerRen.gridx = 0;
	  gbc_lbPerRen.gridy = 11;
	  panelCampos.add(getLbPerRen(), gbc_lbPerRen);
	  GridBagConstraints gbc_perRen = new GridBagConstraints();
	  gbc_perRen.insets = new Insets(2, 3, 0, 0);
	  gbc_perRen.gridwidth = 2;
	  gbc_perRen.fill = GridBagConstraints.BOTH;
	  gbc_perRen.gridx = 1;
	  gbc_perRen.gridy = 11;
	  panelCampos.add(getPerRen(), gbc_perRen);
	  GridBagConstraints gbc_lbSecado = new GridBagConstraints();
	  gbc_lbSecado.anchor = GridBagConstraints.EAST;
	  gbc_lbSecado.gridwidth = 2;
	  gbc_lbSecado.insets = new Insets(2, 3, 0, 0);
	  gbc_lbSecado.fill = GridBagConstraints.VERTICAL;
	  gbc_lbSecado.gridx = 3;
	  gbc_lbSecado.gridy = 11;
	  panelCampos.add(getLbSecado(), gbc_lbSecado);
	  GridBagConstraints gbc_secado = new GridBagConstraints();
	  gbc_secado.fill = GridBagConstraints.BOTH;
	  gbc_secado.insets = new Insets(2, 3, 0, 3);
	  gbc_secado.gridx = 5;
	  gbc_secado.gridy = 11;
	  panelCampos.add(getSecado(), gbc_secado);
	  GridBagConstraints gbc_lbValFre = new GridBagConstraints();
	  gbc_lbValFre.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValFre.fill = GridBagConstraints.BOTH;
	  gbc_lbValFre.gridx = 6;
	  gbc_lbValFre.gridy = 11;
	  panelCampos.add(getLbValFre(), gbc_lbValFre);
	  GridBagConstraints gbc_valFre = new GridBagConstraints();
	  gbc_valFre.insets = new Insets(2, 3, 0, 0);
	  gbc_valFre.fill = GridBagConstraints.BOTH;
	  gbc_valFre.gridx = 7;
	  gbc_valFre.gridy = 11;
	  panelCampos.add(getValFre(), gbc_valFre);
	  GridBagConstraints gbc_lbValArm = new GridBagConstraints();
	  gbc_lbValArm.fill = GridBagConstraints.BOTH;
	  gbc_lbValArm.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValArm.gridx = 8;
	  gbc_lbValArm.gridy = 11;
	  panelCampos.add(getLbValArm(), gbc_lbValArm);
	  GridBagConstraints gbc_valArm = new GridBagConstraints();
	  gbc_valArm.insets = new Insets(2, 3, 0, 3);
	  gbc_valArm.fill = GridBagConstraints.BOTH;
	  gbc_valArm.gridx = 9;
	  gbc_valArm.gridy = 11;
	  panelCampos.add(getValArm(), gbc_valArm);
	  GridBagConstraints gbc_lbIndAfl = new GridBagConstraints();
	  gbc_lbIndAfl.insets = new Insets(2, 3, 0, 0);
	  gbc_lbIndAfl.fill = GridBagConstraints.BOTH;
	  gbc_lbIndAfl.gridx = 0;
	  gbc_lbIndAfl.gridy = 12;
	  panelCampos.add(getLbIndAfl(), gbc_lbIndAfl);
	  GridBagConstraints gbc_indAfla = new GridBagConstraints();
	  gbc_indAfla.insets = new Insets(2, 3, 0, 0);
	  gbc_indAfla.gridwidth = 3;
	  gbc_indAfla.fill = GridBagConstraints.BOTH;
	  gbc_indAfla.gridx = 1;
	  gbc_indAfla.gridy = 12;
	  panelCampos.add(getIndAfla(), gbc_indAfla);
	  GridBagConstraints gbc_lbValTot = new GridBagConstraints();
	  gbc_lbValTot.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValTot.fill = GridBagConstraints.BOTH;
	  gbc_lbValTot.gridx = 8;
	  gbc_lbValTot.gridy = 12;
	  panelCampos.add(getLbValTot(), gbc_lbValTot);
	  GridBagConstraints gbc_valTot = new GridBagConstraints();
	  gbc_valTot.insets = new Insets(2, 3, 0, 0);
	  gbc_valTot.gridx = 9;
	  gbc_valTot.gridy = 12;
	  panelCampos.add(getValTot(), gbc_valTot);
	  GridBagConstraints gbc_lbPerQue = new GridBagConstraints();
	  gbc_lbPerQue.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPerQue.fill = GridBagConstraints.BOTH;
	  gbc_lbPerQue.gridx = 0;
	  gbc_lbPerQue.gridy = 13;
	  panelCampos.add(getLbPerQue(), gbc_lbPerQue);
	  GridBagConstraints gbc_perQue = new GridBagConstraints();
	  gbc_perQue.insets = new Insets(2, 3, 0, 0);
	  gbc_perQue.gridwidth = 2;
	  gbc_perQue.fill = GridBagConstraints.BOTH;
	  gbc_perQue.gridx = 1;
	  gbc_perQue.gridy = 13;
	  panelCampos.add(getPerQue(), gbc_perQue);
	  GridBagConstraints gbc_lbQtdPer = new GridBagConstraints();
	  gbc_lbQtdPer.anchor = GridBagConstraints.EAST;
	  gbc_lbQtdPer.gridwidth = 2;
	  gbc_lbQtdPer.fill = GridBagConstraints.VERTICAL;
	  gbc_lbQtdPer.insets = new Insets(2, 3, 0, 0);
	  gbc_lbQtdPer.gridx = 3;
	  gbc_lbQtdPer.gridy = 13;
	  panelCampos.add(getLbQtdPer(), gbc_lbQtdPer);
	  GridBagConstraints gbc_qtdPer = new GridBagConstraints();
	  gbc_qtdPer.insets = new Insets(2, 3, 0, 0);
	  gbc_qtdPer.fill = GridBagConstraints.BOTH;
	  gbc_qtdPer.gridx = 5;
	  gbc_qtdPer.gridy = 13;
	  panelCampos.add(getQtdPer(), gbc_qtdPer);
	  GridBagConstraints gbc_lbTotSac = new GridBagConstraints();
	  gbc_lbTotSac.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotSac.fill = GridBagConstraints.BOTH;
	  gbc_lbTotSac.gridx = 6;
	  gbc_lbTotSac.gridy = 13;
	  panelCampos.add(getLbTotSac(), gbc_lbTotSac);
	  GridBagConstraints gbc_totSac = new GridBagConstraints();
	  gbc_totSac.insets = new Insets(2, 3, 0, 0);
	  gbc_totSac.fill = GridBagConstraints.BOTH;
	  gbc_totSac.gridx = 7;
	  gbc_totSac.gridy = 13;
	  panelCampos.add(getTotSac(), gbc_totSac);
	  GridBagConstraints gbc_lbLocDes = new GridBagConstraints();
	  gbc_lbLocDes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbLocDes.fill = GridBagConstraints.BOTH;
	  gbc_lbLocDes.gridx = 0;
	  gbc_lbLocDes.gridy = 14;
	  panelCampos.add(getLbLocDes(), gbc_lbLocDes);
	  GridBagConstraints gbc_locDes = new GridBagConstraints();
	  gbc_locDes.gridwidth = 10;
	  gbc_locDes.insets = new Insets(2, 3, 0, 3);
	  gbc_locDes.fill = GridBagConstraints.BOTH;
	  gbc_locDes.gridx = 1;
	  gbc_locDes.gridy = 14;
	  panelCampos.add(getLocDes(), gbc_locDes);
	  GridBagConstraints gbc_lbFoment = new GridBagConstraints();
	  gbc_lbFoment.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFoment.fill = GridBagConstraints.BOTH;
	  gbc_lbFoment.gridx = 0;
	  gbc_lbFoment.gridy = 15;
	  panelCampos.add(getLbFoment(), gbc_lbFoment);
	  GridBagConstraints gbc_foment = new GridBagConstraints();
	  gbc_foment.gridwidth = 10;
	  gbc_foment.insets = new Insets(2, 3, 0, 3);
	  gbc_foment.fill = GridBagConstraints.BOTH;
	  gbc_foment.gridx = 1;
	  gbc_foment.gridy = 15;
	  panelCampos.add(getFoment(), gbc_foment);
	  GridBagConstraints gbc_lbConObs = new GridBagConstraints();
	  gbc_lbConObs.insets = new Insets(2, 3, 0, 0);
	  gbc_lbConObs.fill = GridBagConstraints.BOTH;
	  gbc_lbConObs.gridx = 0;
	  gbc_lbConObs.gridy = 16;
	  panelCampos.add(getLbConObs(), gbc_lbConObs);
	  GridBagConstraints gbc_conObs = new GridBagConstraints();
	  gbc_conObs.fill = GridBagConstraints.BOTH;
	  gbc_conObs.insets = new Insets(2, 3, 0, 0);
	  gbc_conObs.gridx = 1;
	  gbc_conObs.gridy = 16;
	  panelCampos.add(getConObs(), gbc_conObs);
	  GridBagConstraints gbc_lbMovIde = new GridBagConstraints();
	  gbc_lbMovIde.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMovIde.fill = GridBagConstraints.BOTH;
	  gbc_lbMovIde.gridx = 8;
	  gbc_lbMovIde.gridy = 16;
	  panelCampos.add(getLbMovIde(), gbc_lbMovIde);
	  GridBagConstraints gbc_movIde = new GridBagConstraints();
	  gbc_movIde.anchor = GridBagConstraints.WEST;
	  gbc_movIde.fill = GridBagConstraints.VERTICAL;
	  gbc_movIde.gridwidth = 2;
	  gbc_movIde.insets = new Insets(2, 3, 0, 0);
	  gbc_movIde.gridx = 9;
	  gbc_movIde.gridy = 16;
	  panelCampos.add(getMovIde(), gbc_movIde);
	}
	return panelCampos;
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
		public void focusLost(FocusEvent e) {
		  montaTela("");
		}
	  });
	  proCod.setTipoValidacao("produtos");
	  proCod.setName("PROCOD");
	  proCod.setCampoLimpaTelaAutomatico(false);
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

  private UnJLabel getLbConDat() {
	if (lbConDat == null) {
	  lbConDat = new UnJLabel();
	  lbConDat.setText("Data da Movimenta\u00E7\u00E3o:");
	  lbConDat.setForeground(Color.BLACK);
	}
	return lbConDat;
  }

  private editFormatado getConDat() {
	if (conDat == null) {
	  conDat = new editFormatado();
	  conDat.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaTela("");
		}
	  });
	  conDat.setTipoFormatacao(4);
	  conDat.setText("");
	  conDat.setPreferredSize(new Dimension(40, 19));
	  conDat.setName("CONDAT");
	  conDat.setMinimumSize(new Dimension(40, 19));
	  conDat.setCampoResultSetAutomatico(false);
	}
	return conDat;
  }

  private UnJLabel getLbCliCod() {
	if (lbCliCod == null) {
	  lbCliCod = new UnJLabel();
	  lbCliCod.setText("Cliente:");
	  lbCliCod.setForeground(Color.BLUE);
	}
	return lbCliCod;
  }

  private UnJLabel getLbMsiAfi() {
	if (lbMsiAfi == null) {
	  lbMsiAfi = new UnJLabel();
	  lbMsiAfi.setText("Munic\u00EDpio:");
	  lbMsiAfi.setForeground(Color.BLUE);
	}
	return lbMsiAfi;
  }

  private UnJLabel getLbMotNom() {
	if (lbMotNom == null) {
	  lbMotNom = new UnJLabel();
	  lbMotNom.setText("Nome do Motorista:");
	  lbMotNom.setForeground(Color.BLACK);
	}
	return lbMotNom;
  }

  private UnEdit getMotNom() {
	if (motNom == null) {
	  motNom = new UnEdit();
	  motNom.setCampoObrigatorio(false);
	  motNom.setCampoResultSetAutomatico(false);
	  motNom.setText("");
	  motNom.setName2("Descri\u00E7\u00E3o C\u00F3digo");
	  motNom.setName("NOMMOT");
	}
	return motNom;
  }

  private UnJLabel getLbPlaFro() {
	if (lbPlaFro == null) {
	  lbPlaFro = new UnJLabel();
	  lbPlaFro.setText("Placa/N\u00FAmero da Frota:");
	  lbPlaFro.setForeground(Color.BLACK);
	}
	return lbPlaFro;
  }

  private UnEdit getPlaFro() {
	if (plaFro == null) {
	  plaFro = new UnEdit();
	  plaFro.setCampoResultSetAutomatico(false);
	  plaFro.setText("");
	  plaFro.setName2("Descri\u00E7\u00E3o C\u00F3digo");
	  plaFro.setName("PLAFRO");
	  plaFro.setMaxLength(15);
	  plaFro.setMinimumSize(new Dimension(60, 19));
	  plaFro.setPreferredSize(new Dimension(60, 19));
	}
	return plaFro;
  }

  private UnJLabel getLbPesEnt() {
	if (lbPesEnt == null) {
	  lbPesEnt = new UnJLabel();
	  lbPesEnt.setText("Peso de Entrada em Kg:");
	  lbPesEnt.setForeground(Color.BLACK);
	}
	return lbPesEnt;
  }

  private editFormatado getPesEnt() {
	if (pesEnt == null) {
	  pesEnt = new editFormatado();
	  pesEnt.setTipoFormatacao(7);
	  pesEnt.setName("PESENT");
	  pesEnt.setCampoResultSetAutomatico(false);
	}
	return pesEnt;
  }

  private UnJLabel getLbPesSai() {
	if (lbPesSai == null) {
	  lbPesSai = new UnJLabel();
	  lbPesSai.setText("Peso de Sa\u00EDda em Kg:");
	  lbPesSai.setForeground(Color.BLACK);
	}
	return lbPesSai;
  }

  private editFormatado getPesSai() {
	if (pesSai == null) {
	  pesSai = new editFormatado();
	  pesSai.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaPesoLiquido();
		}
	  });
	  pesSai.setTipoFormatacao(7);
	  pesSai.setName("PESSAI");
	  pesSai.setCampoResultSetAutomatico(false);
	}
	return pesSai;
  }

  private EditPratic getCliCod() {
	if (cliCod == null) {
	  cliCod = new EditPratic();
	  cliCod.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  habilitaDesabilitaCliMun();
		}
	  });
	  cliCod.setCampoResultSetAutomatico(false);
	  cliCod.setTipoValidacao("cli_geral");
	  cliCod.setName("CLICOD");
	  cliCod.setSoNumeros(true);
	  cliCod.setPreferredSize(new Dimension(60, 19));
	  cliCod.setName2("C\u00F3digo do Cliente");
	  cliCod.setMinimumSize(new Dimension(60, 19));
	  cliCod.setLabelDescricao(getLbDesCliCod());
	}
	return cliCod;
  }

  private EditPratic getMsiAfi() {
	if (msiAfi == null) {
	  msiAfi = new EditPratic();
	  msiAfi.setCampoObrigatorio(false);
	  msiAfi.setEnabled(false);
	  msiAfi.setCampoResultSetAutomatico(false);
	  msiAfi.setTipoValidacao("municipios");
	  msiAfi.setName("MSIAFI");
	  msiAfi.setLabelDescricao(getLbDesMsiAfi());
	}
	return msiAfi;
  }

  private void habilitaDesabilitaCliMun() {
	if (getCliCod().isVazio()) {
	  getMsiAfi().setEnabled(true);
	  getCliNom().setEnabled(true);
	  getCliNom().requestFocus();
	}
	else {
	  getMsiAfi().setEnabled(false);
	  getCliNom().setEnabled(false);
	}
  }

  private UnJLabel getLbPesLiq() {
	if (lbPesLiq == null) {
	  lbPesLiq = new UnJLabel();
	  lbPesLiq.setText("Peso L\u00EDquido:");
	  lbPesLiq.setForeground(Color.BLACK);
	}
	return lbPesLiq;
  }

  private UnJLabel getPesLiq() {
	if (pesLiq == null) {
	  pesLiq = new UnJLabel();
	  pesLiq.setCampoResultSetAutomatico(false);
	  pesLiq.setText(" 0,00 ");
	  pesLiq.setPreferredSize(new Dimension(100, 19));
	  pesLiq.setOpaque(true);
	  pesLiq.setName("PESLIQ");
	  pesLiq.setMinimumSize(new Dimension(100, 19));
	  pesLiq.setHorizontalAlignment(SwingConstants.CENTER);
	  pesLiq.setFont(new Font("Arial", Font.BOLD, 11));
	  pesLiq.setBackground(Color.LIGHT_GRAY);
	}
	return pesLiq;
  }

  private void montaPesoLiquido() {
	double total = getPesSai().getValorDecimal() - getPesEnt().getValorDecimal();
	getPesLiq().setText(Numeros.formatarDecimalVariavel(total, 2));
	getPesLiq().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private UnJLabel getLbQtdSac() {
	if (lbQtdSac == null) {
	  lbQtdSac = new UnJLabel();
	  lbQtdSac.setText("Quantidade de Sacas:");
	  lbQtdSac.setForeground(Color.BLACK);
	}
	return lbQtdSac;
  }

  private UnJLabel getLbPerUmi() {
	if (lbPerUmi == null) {
	  lbPerUmi = new UnJLabel();
	  lbPerUmi.setText("% de Umidade:");
	  lbPerUmi.setForeground(Color.BLACK);
	}
	return lbPerUmi;
  }

  private editFormatado getPerUmi() {
	if (perUmi == null) {
	  perUmi = new editFormatado();
	  perUmi.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaValorSecador();
		  obrigatorioProSec();
		}
	  });
	  perUmi.setTipoFormatacao(7);
	  perUmi.setName("PERUMI");
	  perUmi.setCampoResultSetAutomatico(false);
	}
	return perUmi;
  }

  private void obrigatorioProSec() {
	if (getPerUmi().isVazio()) {
	  getProSec().setCampoObrigatorio(true);
	}
	else {
	  getProSec().setCampoObrigatorio(false);
	}
  }

  private void montaValorSecador() {
	double total = getQtdSac().getValorDecimal() * (Numeros.formatarDecimalBanco(DeskPratic.fctGeral
		.selectStringBanco("select secval FROM ES_VIEW_TABELA_SECAGEM_ITENS WHERE empcod = '"
			+ getEmpCod().getText() + "' and filcod = " + getFilCod().getText() + " and secdat = '"
			+ getConDat().getValorDate() + "' and " + getPerUmi().getValorDecimal() + " >= perini and "
			+ getPerUmi().getValorDecimal() + " <= perfim "))
		/ 100);
	getSecado().setText(Numeros.formatarDecimal(total, 2));
	getSecado().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private UnJLabel getLbProSec() {
	if (lbProSec == null) {
	  lbProSec = new UnJLabel();
	  lbProSec.setText("C\u00F3digo de Servi\u00E7o:");
	  lbProSec.setForeground(Color.BLUE);
	}
	return lbProSec;
  }

  private EditPratic getProSec() {
	if (proSec == null) {
	  proSec = new EditPratic();
	  proSec.setCampoObrigatorio(false);
	  proSec.setCampoResultSetAutomatico(false);
	  proSec.setTipoValidacao("produtos/tabela_secagem_itens");
	  proSec.setCampoQuartaChave(getPerUmi());
	  proSec.setCampoQuintaChave(getConDat());
	  proSec.setName("PROSEC");
	  proSec.setLabelDescricao(getLbDesProSec());
	}
	return proSec;
  }

  private UnJLabel getLbValFre() {
	if (lbValFre == null) {
	  lbValFre = new UnJLabel();
	  lbValFre.setText("Valor do Frete Cliente:");
	  lbValFre.setForeground(Color.BLACK);
	}
	return lbValFre;
  }

  private editFormatado getValFre() {
	if (valFre == null) {
	  valFre = new editFormatado();
	  valFre.setTipoFormatacao(7);
	  valFre.setName("VALFRE");
	  valFre.setCampoResultSetAutomatico(false);
	  valFre.setCampoObrigatorio(false);
	}
	return valFre;
  }

  private UnJLabel getLbValArm() {
	if (lbValArm == null) {
	  lbValArm = new UnJLabel();
	  lbValArm.setText("Valor Armaz\u00E9m:");
	  lbValArm.setForeground(Color.BLACK);
	}
	return lbValArm;
  }

  private editFormatado getValArm() {
	if (valArm == null) {
	  valArm = new editFormatado();
	  valArm.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaValorTotal();
		}
	  });
	  valArm.setTipoFormatacao(7);
	  valArm.setName("VALARM");
	  valArm.setCampoResultSetAutomatico(false);
	  valArm.setCampoObrigatorio(false);
	}
	return valArm;
  }

  private void montaValorTotal() {
	double total = getValFre().getValorDecimal() + getValArm().getValorDecimal();
	getValTot().setText(Numeros.formatarDecimalVariavel(total, 2));
	getValTot().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private UnJLabel getLbValTot() {
	if (lbValTot == null) {
	  lbValTot = new UnJLabel();
	  lbValTot.setText("Valor Total:");
	  lbValTot.setForeground(Color.BLACK);
	}
	return lbValTot;
  }

  private UnJLabel getValTot() {
	if (valTot == null) {
	  valTot = new UnJLabel();
	  valTot.setCampoResultSetAutomatico(false);
	  valTot.setText(" 0,00 ");
	  valTot.setPreferredSize(new Dimension(100, 19));
	  valTot.setOpaque(true);
	  valTot.setName("VALTOT");
	  valTot.setMinimumSize(new Dimension(100, 19));
	  valTot.setHorizontalAlignment(SwingConstants.CENTER);
	  valTot.setFont(new Font("Arial", Font.BOLD, 11));
	  valTot.setBackground(Color.LIGHT_GRAY);
	}
	return valTot;
  }

  private UnJLabel getLbPerRen() {
	if (lbPerRen == null) {
	  lbPerRen = new UnJLabel();
	  lbPerRen.setText("% de Renda:");
	  lbPerRen.setForeground(Color.BLACK);
	}
	return lbPerRen;
  }

  private editFormatado getPerRen() {
	if (perRen == null) {
	  perRen = new editFormatado();
	  perRen.setTipoFormatacao(7);
	  perRen.setName("PERREN");
	  perRen.setCampoResultSetAutomatico(false);
	  perRen.setCampoObrigatorio(false);
	}
	return perRen;
  }

  private UnJLabel getLbIndAfl() {
	if (lbIndAfl == null) {
	  lbIndAfl = new UnJLabel();
	  lbIndAfl.setText("Indice Afla:");
	  lbIndAfl.setForeground(Color.BLACK);
	}
	return lbIndAfl;
  }

  private UnEdit getIndAfla() {
	if (indAfla == null) {
	  indAfla = new UnEdit();
	  indAfla.setCampoObrigatorio(false);
	  indAfla.setCampoResultSetAutomatico(false);
	  indAfla.setText("");
	  indAfla.setPreferredSize(new Dimension(60, 19));
	  indAfla.setName("INDAFL");
	  indAfla.setMinimumSize(new Dimension(60, 19));
	  indAfla.setMaxLength(15);
	}
	return indAfla;
  }

  private UnJLabel getLbPerQue() {
	if (lbPerQue == null) {
	  lbPerQue = new UnJLabel();
	  lbPerQue.setText("% de Quebra:");
	  lbPerQue.setForeground(Color.BLACK);
	}
	return lbPerQue;
  }

  private editFormatado getPerQue() {
	if (perQue == null) {
	  perQue = new editFormatado();
	  perQue.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montaQuantidadePerda();
		}
	  });
	  perQue.setTipoFormatacao(7);
	  perQue.setName("PERQUE");
	  perQue.setCampoResultSetAutomatico(false);
	  perQue.setCampoObrigatorio(false);
	}
	return perQue;
  }

  private void montaQuantidadePerda() {
	double total = (getQtdSac().getValorDecimal() * getPerQue().getValorDecimal()) / 100;
	getQtdPer().setText(Numeros.formatarDecimal(total, 2));
	getQtdPer().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private editFormatado getQtdSac() {
	if (qtdSac == null) {
	  qtdSac = new editFormatado();
	  qtdSac.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		  montaQuantidadeSacas();
		}
	  });
	  qtdSac.setTipoFormatacao(7);
	  qtdSac.setName("QTDSAC");
	  qtdSac.setCampoResultSetAutomatico(false);
	}
	return qtdSac;
  }

  private void montaQuantidadeSacas() {
	double total = (getPesSai().getValorDecimal() - getPesEnt().getValorDecimal()) / (Numeros
		.formatarDecimalBanco(DeskPratic.fctGeral.selectStringBanco(
			"select propel FROM ES_VIEW_PRODUTOS WHERE empcod = '" + getEmpCod().getText()
				+ "' and filcod = " + getFilCod().getText() + " and procod = " + getProCod().getText()))
		/ 10000);

	getQtdSac().setText(Numeros.formatarDecimal(total, 2));
	getQtdSac().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private UnJLabel getLbQtdPer() {
	if (lbQtdPer == null) {
	  lbQtdPer = new UnJLabel();
	  lbQtdPer.setText("Quantidade de Perda:");
	  lbQtdPer.setForeground(Color.BLACK);
	}
	return lbQtdPer;
  }

  private editFormatado getQtdPer() {
	if (qtdPer == null) {
	  qtdPer = new editFormatado();
	  qtdPer.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  montaQuantidadeSacaFinal();
		}
	  });
	  qtdPer.setTipoFormatacao(7);
	  qtdPer.setName("QTDPER");
	  qtdPer.setCampoResultSetAutomatico(false);
	  qtdPer.setCampoObrigatorio(false);
	}
	return qtdPer;
  }

  private void montaQuantidadeSacaFinal() {
	double total = getQtdSac().getValorDecimal() - getQtdPer().getValorDecimal();
	getTotSac().setText(Numeros.formatarDecimal(total, 2));
	getTotSac().setAuxiliarDeTrabalho(String.valueOf(total));
  }

  private UnJLabel getLbTotSac() {
	if (lbTotSac == null) {
	  lbTotSac = new UnJLabel();
	  lbTotSac.setText("Total de Sacas Final:");
	  lbTotSac.setForeground(Color.BLACK);
	}
	return lbTotSac;
  }

  private UnJLabel getTotSac() {
	if (totSac == null) {
	  totSac = new UnJLabel();
	  totSac.setCampoResultSetAutomatico(false);
	  totSac.setText(" 0,00 ");
	  totSac.setPreferredSize(new Dimension(100, 19));
	  totSac.setOpaque(true);
	  totSac.setName("TOTSAC");
	  totSac.setMinimumSize(new Dimension(100, 19));
	  totSac.setHorizontalAlignment(SwingConstants.CENTER);
	  totSac.setFont(new Font("Arial", Font.BOLD, 11));
	  totSac.setBackground(Color.LIGHT_GRAY);
	}
	return totSac;
  }

  private UnJLabel getLbLocDes() {
	if (lbLocDes == null) {
	  lbLocDes = new UnJLabel();
	  lbLocDes.setText("Local de Descarga:");
	  lbLocDes.setForeground(Color.BLACK);
	}
	return lbLocDes;
  }

  private EditPratic getLocDes() {
	if (locDes == null) {
	  locDes = new EditPratic();
	  locDes.setCampoResultSetAutomatico(false);
	  locDes.setName("LOCDES");
	  locDes.setMaxLength(60);
	}
	return locDes;
  }

  private UnJLabel getLbFoment() {
	if (lbFoment == null) {
	  lbFoment = new UnJLabel();
	  lbFoment.setText("Fomento:");
	  lbFoment.setForeground(Color.BLACK);
	}
	return lbFoment;
  }

  private EditPratic getFoment() {
	if (foment == null) {
	  foment = new EditPratic();
	  foment.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  getConObs().requestFocus();
		}
	  });
	  foment.setCampoObrigatorio(false);
	  foment.setCampoResultSetAutomatico(false);
	  foment.setName("FOMENT");
	  foment.setMaxLength(60);
	}
	return foment;
  }

  private UnJLabel getLbConObs() {
	if (lbConObs == null) {
	  lbConObs = new UnJLabel();
	  lbConObs.setText("Observa\u00E7\u00F5es:");
	  lbConObs.setForeground(Color.BLACK);
	}
	return lbConObs;
  }

  private UnJTextoLivre getConObs() {
	if (conObs == null) {
	  conObs = new UnJTextoLivre();
	  conObs.setCampoResultSetAutomatico(false);
	  conObs.setToolTipText("Observa\u00E7\u00F5es Gerais da Nota Fiscal");
	  conObs.setName("CONOBS");
	  conObs.setMnemonic(KeyEvent.VK_UNDEFINED);
	  conObs.setPreferredSize(new Dimension(60, 20));
	  conObs.setMinimumSize(new Dimension(60, 20));
	  conObs.setMaximoLength("900");
	  conObs.setDesk(DeskPratic.desktop);
	  conObs.setName2("Texto");
	}
	return conObs;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela(
		  "Seq, Data, Código Produto, Número de Ticket, Código Fornecedor, Fornecedor, Motorista, "
			  + "Placa, % Umidade, Código do Serviço, Descrição do Serviço, Peso Entrada, Peso Saída, Liquido (Kg), Sacas, Valor Secador, "
			  + "Frete Cliente, R$ Armazem, Total, Renda, Indice Afla, Quebra, "
			  + "Perda, Total de Sacas Final, Local Descarga, Fomento");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_CONTROLE_PRODUTOS");
	  tabelaRes.setCampoDadosTabela(
		  "MOVIDE, CONDAT, PROCOD || ' - ' || PROCODDES as PROCOD, NUMTIC, CLICOD, CLICODDES, NOMMOT, PLAFRO, PERUMI, PROSEC, PROSECDES, PESENT, "
			  + "PESSAI, PESLIQ, QTDSAC, VALFRE, SECADO, VALARM, VALTOT, PERREN, INDAFL, PERQUE, "
			  + "QTDPER, TOTSAC, LOCDES, FOMENT");
	  tabelaRes.setCampoTitulosTabelaTamanhos(
		  "50, 70, 130, 100, 50, 200, 200, 100, 100, 50, 130, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, "
			  + "100, 200, 200");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getProCod());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getPanelCampos());
	  tabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

  private UnJLabel getLbNumTic() {
	if (lbNumTic == null) {
	  lbNumTic = new UnJLabel();
	  lbNumTic.setText("N\u00FAmero do Ticket:");
	  lbNumTic.setForeground(Color.BLACK);
	}
	return lbNumTic;
  }

  private EditPratic getNumTic() {
	if (numTic == null) {
	  numTic = new EditPratic();
	  numTic.setSoNumerosLetras(true);
	  numTic.setCampoResultSetAutomatico(false);
	  numTic.setPreferredSize(new Dimension(60, 19));
	  numTic.setName("NUMTIC");
	  numTic.setMinimumSize(new Dimension(60, 19));
	}
	return numTic;
  }

  private UnJLabel getLbDesCliCod() {
	if (lbDesCliCod == null) {
	  lbDesCliCod = new UnJLabel();
	  lbDesCliCod.setCampoResultSetAutomatico(false);
	  lbDesCliCod.setName("CLICODDES");
	  lbDesCliCod.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDesCliCod;
  }

  private UnJLabel getLbDesMsiAfi() {
	if (lbDesMsiAfi == null) {
	  lbDesMsiAfi = new UnJLabel();
	  lbDesMsiAfi.setCampoResultSetAutomatico(false);
	  lbDesMsiAfi.setName("MSIAFIMUN");
	  lbDesMsiAfi.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDesMsiAfi;
  }

  private UnJLabel getLbCliNom() {
	if (lbCliNom == null) {
	  lbCliNom = new UnJLabel();
	  lbCliNom.setText("Nome do Cliente:");
	  lbCliNom.setForeground(Color.BLACK);
	}
	return lbCliNom;
  }

  private UnEdit getCliNom() {
	if (cliNom == null) {
	  cliNom = new UnEdit();
	  cliNom.setCampoObrigatorio(false);
	  cliNom.setEnabled(false);
	  cliNom.setText("");
	  cliNom.setName2("Descri\u00E7\u00E3o C\u00F3digo");
	  cliNom.setName("CLIRAZ");
	  cliNom.setCampoResultSetAutomatico(false);
	}
	return cliNom;
  }

  private UnJLabel getLbDesProSec() {
	if (lbDesProSec == null) {
	  lbDesProSec = new UnJLabel();
	  lbDesProSec.setCampoResultSetAutomatico(false);
	  lbDesProSec.setName("PROSECDES");
	  lbDesProSec.setFont(new Font("Arial", Font.BOLD, 12));
	}
	return lbDesProSec;
  }

  private UnJLabel getLbSecado() {
	if (lbSecado == null) {
	  lbSecado = new UnJLabel();
	  lbSecado.setText("Secador:");
	  lbSecado.setForeground(Color.BLACK);
	}
	return lbSecado;
  }

  private UnJLabel getSecado() {
	if (secado == null) {
	  secado = new UnJLabel();
	  secado.setText(" 0,00 ");
	  secado.setPreferredSize(new Dimension(100, 19));
	  secado.setOpaque(true);
	  secado.setName("SECADO");
	  secado.setMinimumSize(new Dimension(100, 19));
	  secado.setHorizontalAlignment(SwingConstants.CENTER);
	  secado.setFont(new Font("Arial", Font.BOLD, 11));
	  secado.setCampoResultSetAutomatico(false);
	  secado.setBackground(Color.LIGHT_GRAY);
	}
	return secado;
  }

  public boolean limpaTela() {

	getProCodDes().limpar();
	getMovIde().limpar();
	getPesLiq().limpar();
	getSecado().limpar();
	getValTot().limpar();
	getTotSac().limpar();

	return super.limpaTela();
  }

  public boolean montaTela(String codigo) {

	getTabelaRes().setCampoDadosTabelaWhere(
		" empcod = '" + getEmpCod().getText() + "' and filcod = " + DeskPratic.getPadraoFilial()
			+ (getProCod().isVazio() ? "" : " and procod = " + getProCod().getText())
			+ (getConDat().isVazio() ? ""
				: " and condat = '" + TrataString.dataBanco(getConDat().getText()) + "'"));

	getTabelaRes().montaTela("");

	return true;

  }

  private UnJLabel getLbMovIde() {
	if (lbMovIde == null) {
	  lbMovIde = new UnJLabel();
	  lbMovIde.setText("Sequ\u00EAncia:");
	  lbMovIde.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	return lbMovIde;
  }

  private UnJLabel getMovIde() {
	if (movIde == null) {
	  movIde = new UnJLabel();
	  movIde.setText("0000");
	  movIde.setPreferredSize(new Dimension(85, 19));
	  movIde.setName("MOVIDE");
	  movIde.setMinimumSize(new Dimension(85, 19));
	  movIde.setMaximumSize(new Dimension(85, 19));
	  movIde.setHorizontalAlignment(SwingConstants.CENTER);
	  movIde.setBorder(new LineBorder(Color.GRAY));
	}
	return movIde;
  }

  public boolean gravaTela() {

	// if (validaTela()) {
	// return false;
	// }

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_CONTROLE_PRODUTOS", 30, 2));

	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getMovIde().getText());
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("MOVIDE"));
	  }
	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setInt(param++, getProCod(), stp);
	  getProc().setDate(param++, getConDat(), stp);
	  getProc().setString(param++, getNumTic(), stp);
	  getProc().setInt(param++, getCliCod(), stp);
	  getProc().setString(param++, getCliNom(), stp);
	  getProc().setString(param++, getMsiAfi(), stp);
	  getProc().setString(param++, getMotNom(), stp);
	  getProc().setString(param++, getPlaFro(), stp);
	  getProc().setDouble(param++, getPesEnt(), stp);
	  getProc().setDouble(param++, getPesSai(), stp);
	  getProc().setDouble(param++, getPesLiq().getText());
	  getProc().setDouble(param++, getQtdSac(), stp);
	  getProc().setDouble(param++, getPerUmi(), stp);
	  getProc().setInt(param++, getProSec(), stp);
	  getProc().setDouble(param++, getValFre(), stp);
	  getProc().setDouble(param++, getValArm(), stp);
	  getProc().setDouble(param++, getValTot().getText());
	  getProc().setDouble(param++, getPerRen(), stp);
	  getProc().setString(param++, getIndAfla(), stp);
	  getProc().setDouble(param++, getPerQue(), stp);
	  getProc().setDouble(param++, getQtdPer(), stp);
	  getProc().setDouble(param++, getTotSac().getText());
	  getProc().setString(param++, getLocDes(), stp);
	  getProc().setString(param++, getFoment(), stp);
	  getProc().setString(param++, getConObs(), stp);
	  getProc().setDouble(param++, getSecado().getText());
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();
	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (getAcaoTela().equalsIgnoreCase("E")) {
		limpaTela();
		getTabelaRes().limpaTebela();
		getProCod().requestFocus();
	  }
	  else {
		limpaTela();
		montaTela("");
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
}
