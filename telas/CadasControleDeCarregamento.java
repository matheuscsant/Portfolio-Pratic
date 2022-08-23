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
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastroEmpresa;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnEdit;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.UnJTextoLivre;
import br.com.praticsistemas.unprtcomps.telas.JButton.UnJButton;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.TrataString;
import br.com.praticsistemas.unprtlib.numeros.Numeros;
import br.com.praticsistemas.unprtlib.telas.CompTelas;

public class CadasControleDeCarregamento extends UnCadastroEmpresa {

  private static final long serialVersionUID = 1L;

  private JPanel panelCentral;
  private UnJTablePratic tabelaRes;
  private JPanel panelCampos;
  private UnJLabel lbFilial;
  private EditPratic filCod;
  private UnJLabel lbVeiPla;
  private UnJLabel lbFunCod;
  private editFormatado veiPla;
  private EditPratic funCod;
  private UnJLabel lbFunNom;
  private UnEdit funNom;
  private UnJLabel lbPeriodoViagem;
  private editFormatado mveDat;
  private UnJLabel lbA;
  private editFormatado mveDaf;
  private UnJLabel lbOriPre;
  private UnJLabel lbDesPre;
  private UnJLabel lbKmInic;
  private editFormatado kmInic;
  private UnJLabel lbKmFina;
  private editFormatado kmFina;
  private UnJLabel lbKmRodado;
  private UnJLabel lbMvePes;
  private editFormatado mvePes;
  private UnJLabel lbMveVal;
  private editFormatado mveVal;
  private UnJLabel lbValTot;
  private UnJLabel lbMveObs;
  private UnEdit mveObs;
  private UnJLabel lbDescFilCod;
  private UnJLabel lbDescFunCod;
  private UnJLabel valTot;
  private UnJLabel lbDescVeiPla;
  private UnJLabel lbDescOriPre;
  private EditPratic oriPre;
  private UnJLabel lbDescDesPre;
  private EditPratic desPre;
  private JPanel lbCdcQtd;
  private UnJLabel lbCdcDat;
  private UnJLabel lbDepCod;
  private editFormatado cdcDat;
  private EditPratic depCod;
  private UnJLabel lbGruCod;
  private UnJLabel lbSucCod;
  private EditPratic gruCod;
  private EditPratic subCod;
  private UnJLabel lbQtdItem;
  private UnJLabel lbCdcVal;
  private editFormatado cdcQtd;
  private editFormatado cdcVal;
  private UnJLabel lbDescGrupoItem;
  private UnJLabel lbDescSubGrupoItem;
  private UnJLabel lbDescDepto;
  private UnJButton btnLancar;
  private UnJTextoLivre ipvObs;
  private UnJLabel lbMveIde;
  private EditPratic mveIde;
  private UnJLabel lbCdcSeq;
  private UnJLabel cdcSeq;

  public CadasControleDeCarregamento() {
	initialize();
	limpaTela();
	limparItens();
	setCampoPreferredSizeEmpresa(new Dimension(108, 19));
  }

  private void initialize() {
	this.setMinimumSize(new Dimension(900, 690));
	this.setPreferredSize(new Dimension(900, 690));
	this.setSize(new Dimension(900, 623));
	this.setCampoTelaTrabalho(getMveIde());
	this.setCampoFocoAberturaTela(getMveIde());
	this.setTitle("Cadastro de Controle de Viagem");
	this.setCodigoTela("4305");
	this.setFocoAutomaticoGravaTela(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasControleDeCarregamento = null; // Evento para não bloquear a tela
		// de abrir
	  }
	});

  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 884, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 212, 105, 142, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 0;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);
	  GridBagConstraints gbc_lbCdcQtd = new GridBagConstraints();
	  gbc_lbCdcQtd.fill = GridBagConstraints.BOTH;
	  gbc_lbCdcQtd.gridx = 0;
	  gbc_lbCdcQtd.gridy = 1;
	  panelCentral.add(getLbCdcQtd(), gbc_lbCdcQtd);
	  GridBagConstraints gbc_TabelaRes = new GridBagConstraints();
	  gbc_TabelaRes.fill = GridBagConstraints.BOTH;
	  gbc_TabelaRes.gridx = 0;
	  gbc_TabelaRes.gridy = 2;
	  panelCentral.add(getTabelaRes(), gbc_TabelaRes);
	}
	return panelCentral;
  }

  private JPanel getPanelCampos() {
	if (panelCampos == null) {
	  panelCampos = new JPanel();
	  panelCampos.setPreferredSize(new Dimension(531, 225));
	  panelCampos.setMinimumSize(new Dimension(531, 225));
	  panelCampos.setMaximumSize(new Dimension(531, 225));
	  panelCampos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 106, 0, 0, 15, 22, 115, 0, 0, 0, 0, 22, 68, 0, 0 };
	  gbl_panelCampos.rowHeights = new int[] { 25, 0, 25, 25, 25, 25, 25, 25, 25, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 1.0, 0.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbFilial = new GridBagConstraints();
	  gbc_lbFilial.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilial.anchor = GridBagConstraints.WEST;
	  gbc_lbFilial.gridx = 0;
	  gbc_lbFilial.gridy = 0;
	  panelCampos.add(getLbFilCod(), gbc_lbFilial);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 0, 0);
	  gbc_filCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 0;
	  panelCampos.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescFilCod.gridwidth = 11;
	  gbc_lbDescFilCod.gridx = 2;
	  gbc_lbDescFilCod.gridy = 0;
	  panelCampos.add(getLbDescFilCod(), gbc_lbDescFilCod);
	  GridBagConstraints gbc_menuItem = new GridBagConstraints();
	  gbc_menuItem.gridx = 10;
	  gbc_menuItem.gridy = 0;
	  GridBagConstraints gbc_lbMveIde = new GridBagConstraints();
	  gbc_lbMveIde.anchor = GridBagConstraints.WEST;
	  gbc_lbMveIde.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMveIde.gridx = 0;
	  gbc_lbMveIde.gridy = 1;
	  panelCampos.add(getLbMveIde(), gbc_lbMveIde);
	  GridBagConstraints gbc_mveIde = new GridBagConstraints();
	  gbc_mveIde.gridwidth = 2;
	  gbc_mveIde.insets = new Insets(2, 3, 0, 0);
	  gbc_mveIde.fill = GridBagConstraints.HORIZONTAL;
	  gbc_mveIde.gridx = 1;
	  gbc_mveIde.gridy = 1;
	  panelCampos.add(getMveIde(), gbc_mveIde);

	  GridBagConstraints gbc_lbPlacaVeiculo = new GridBagConstraints();
	  gbc_lbPlacaVeiculo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPlacaVeiculo.anchor = GridBagConstraints.WEST;
	  gbc_lbPlacaVeiculo.gridx = 0;
	  gbc_lbPlacaVeiculo.gridy = 2;
	  panelCampos.add(getLbVeiPla(), gbc_lbPlacaVeiculo);
	  GridBagConstraints gbc_placaCod = new GridBagConstraints();
	  gbc_placaCod.gridwidth = 2;
	  gbc_placaCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_placaCod.insets = new Insets(2, 3, 0, 0);
	  gbc_placaCod.gridx = 1;
	  gbc_placaCod.gridy = 2;
	  panelCampos.add(getVeiPla(), gbc_placaCod);
	  GridBagConstraints gbc_lbDescVeiPla = new GridBagConstraints();
	  gbc_lbDescVeiPla.fill = GridBagConstraints.BOTH;
	  gbc_lbDescVeiPla.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescVeiPla.gridwidth = 4;
	  gbc_lbDescVeiPla.gridx = 3;
	  gbc_lbDescVeiPla.gridy = 2;
	  panelCampos.add(getLbDescVeiPla(), gbc_lbDescVeiPla);
	  GridBagConstraints gbc_lbCodMot = new GridBagConstraints();
	  gbc_lbCodMot.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCodMot.anchor = GridBagConstraints.WEST;
	  gbc_lbCodMot.gridx = 7;
	  gbc_lbCodMot.gridy = 2;
	  panelCampos.add(getLbFunCod(), gbc_lbCodMot);
	  GridBagConstraints gbc_codMot = new GridBagConstraints();
	  gbc_codMot.insets = new Insets(2, 3, 0, 0);
	  gbc_codMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_codMot.gridx = 8;
	  gbc_codMot.gridy = 2;
	  panelCampos.add(getFunCod(), gbc_codMot);
	  GridBagConstraints gbc_lbDescFunCod = new GridBagConstraints();
	  gbc_lbDescFunCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDescFunCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescFunCod.gridwidth = 4;
	  gbc_lbDescFunCod.gridx = 9;
	  gbc_lbDescFunCod.gridy = 2;
	  panelCampos.add(getLbDescFunCod(), gbc_lbDescFunCod);
	  GridBagConstraints gbc_lbFunNom = new GridBagConstraints();
	  gbc_lbFunNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFunNom.anchor = GridBagConstraints.WEST;
	  gbc_lbFunNom.gridx = 0;
	  gbc_lbFunNom.gridy = 3;
	  panelCampos.add(getlbNomeMot(), gbc_lbFunNom);
	  GridBagConstraints gbc_nomeMot = new GridBagConstraints();
	  gbc_nomeMot.gridwidth = 12;
	  gbc_nomeMot.insets = new Insets(2, 3, 0, 3);
	  gbc_nomeMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_nomeMot.gridx = 1;
	  gbc_nomeMot.gridy = 3;
	  panelCampos.add(getFunNom(), gbc_nomeMot);
	  GridBagConstraints gbc_lbPeriodoViagem = new GridBagConstraints();
	  gbc_lbPeriodoViagem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPeriodoViagem.anchor = GridBagConstraints.WEST;
	  gbc_lbPeriodoViagem.gridx = 0;
	  gbc_lbPeriodoViagem.gridy = 4;
	  panelCampos.add(getlbPeriodoViagem(), gbc_lbPeriodoViagem);
	  GridBagConstraints gbc_dataInic = new GridBagConstraints();
	  gbc_dataInic.gridwidth = 2;
	  gbc_dataInic.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataInic.insets = new Insets(2, 3, 0, 0);
	  gbc_dataInic.gridx = 1;
	  gbc_dataInic.gridy = 4;
	  panelCampos.add(getMveDat(), gbc_dataInic);
	  GridBagConstraints gbc_lbA = new GridBagConstraints();
	  gbc_lbA.insets = new Insets(2, 3, 0, 0);
	  gbc_lbA.gridx = 3;
	  gbc_lbA.gridy = 4;
	  panelCampos.add(getlbA(), gbc_lbA);
	  GridBagConstraints gbc_dataFim = new GridBagConstraints();
	  gbc_dataFim.insets = new Insets(2, 3, 0, 0);
	  gbc_dataFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataFim.gridx = 4;
	  gbc_dataFim.gridy = 4;
	  panelCampos.add(getMveDtf(), gbc_dataFim);
	  GridBagConstraints gbc_lbCidOrigem = new GridBagConstraints();
	  gbc_lbCidOrigem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCidOrigem.anchor = GridBagConstraints.WEST;
	  gbc_lbCidOrigem.gridx = 0;
	  gbc_lbCidOrigem.gridy = 5;
	  panelCampos.add(getLbOriPre(), gbc_lbCidOrigem);
	  GridBagConstraints gbc_cidOrigem = new GridBagConstraints();
	  gbc_cidOrigem.insets = new Insets(2, 3, 0, 0);
	  gbc_cidOrigem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cidOrigem.gridx = 1;
	  gbc_cidOrigem.gridy = 5;
	  panelCampos.add(getOriPre(), gbc_cidOrigem);
	  GridBagConstraints gbc_lbDescOriPre = new GridBagConstraints();
	  gbc_lbDescOriPre.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescOriPre.fill = GridBagConstraints.BOTH;
	  gbc_lbDescOriPre.gridwidth = 5;
	  gbc_lbDescOriPre.gridx = 2;
	  gbc_lbDescOriPre.gridy = 5;
	  panelCampos.add(getLbDescOriPre(), gbc_lbDescOriPre);
	  GridBagConstraints gbc_lbCidDestino = new GridBagConstraints();
	  gbc_lbCidDestino.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCidDestino.anchor = GridBagConstraints.EAST;
	  gbc_lbCidDestino.gridx = 7;
	  gbc_lbCidDestino.gridy = 5;
	  panelCampos.add(getLbDesPre(), gbc_lbCidDestino);
	  GridBagConstraints gbc_cidFim = new GridBagConstraints();
	  gbc_cidFim.insets = new Insets(2, 3, 0, 0);
	  gbc_cidFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cidFim.gridx = 8;
	  gbc_cidFim.gridy = 5;
	  panelCampos.add(getDesPre(), gbc_cidFim);
	  GridBagConstraints gbc_lbDescDesPre = new GridBagConstraints();
	  gbc_lbDescDesPre.fill = GridBagConstraints.BOTH;
	  gbc_lbDescDesPre.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescDesPre.gridwidth = 4;
	  gbc_lbDescDesPre.gridx = 9;
	  gbc_lbDescDesPre.gridy = 5;
	  panelCampos.add(getLbDescDesPre(), gbc_lbDescDesPre);
	  GridBagConstraints gbc_lbKmSaida = new GridBagConstraints();
	  gbc_lbKmSaida.insets = new Insets(2, 3, 0, 0);
	  gbc_lbKmSaida.anchor = GridBagConstraints.WEST;
	  gbc_lbKmSaida.gridx = 0;
	  gbc_lbKmSaida.gridy = 6;
	  panelCampos.add(getLbKmInic(), gbc_lbKmSaida);
	  GridBagConstraints gbc_kmSaida = new GridBagConstraints();
	  gbc_kmSaida.gridwidth = 3;
	  gbc_kmSaida.insets = new Insets(2, 3, 0, 0);
	  gbc_kmSaida.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmSaida.gridx = 1;
	  gbc_kmSaida.gridy = 6;
	  panelCampos.add(getKmInic(), gbc_kmSaida);
	  GridBagConstraints gbc_lbKmChegada = new GridBagConstraints();
	  gbc_lbKmChegada.insets = new Insets(2, 3, 0, 0);
	  gbc_lbKmChegada.anchor = GridBagConstraints.EAST;
	  gbc_lbKmChegada.gridx = 5;
	  gbc_lbKmChegada.gridy = 6;
	  panelCampos.add(getLbKmFina(), gbc_lbKmChegada);
	  GridBagConstraints gbc_kmChegada = new GridBagConstraints();
	  gbc_kmChegada.gridwidth = 2;
	  gbc_kmChegada.insets = new Insets(2, 3, 0, 0);
	  gbc_kmChegada.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmChegada.gridx = 6;
	  gbc_kmChegada.gridy = 6;
	  panelCampos.add(getKmFina(), gbc_kmChegada);
	  GridBagConstraints gbc_lbKmRodado = new GridBagConstraints();
	  gbc_lbKmRodado.fill = GridBagConstraints.BOTH;
	  gbc_lbKmRodado.gridwidth = 2;
	  gbc_lbKmRodado.insets = new Insets(2, 3, 0, 3);
	  gbc_lbKmRodado.gridx = 8;
	  gbc_lbKmRodado.gridy = 6;
	  panelCampos.add(getLbKmRoda(), gbc_lbKmRodado);
	  GridBagConstraints gbc_lbPesPorTon = new GridBagConstraints();
	  gbc_lbPesPorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesPorTon.anchor = GridBagConstraints.WEST;
	  gbc_lbPesPorTon.gridx = 0;
	  gbc_lbPesPorTon.gridy = 7;
	  panelCampos.add(getLbMvePes(), gbc_lbPesPorTon);
	  GridBagConstraints gbc_pesPorTon = new GridBagConstraints();
	  gbc_pesPorTon.gridwidth = 3;
	  gbc_pesPorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_pesPorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_pesPorTon.gridx = 1;
	  gbc_pesPorTon.gridy = 7;
	  panelCampos.add(getMvePes(), gbc_pesPorTon);
	  GridBagConstraints gbc_lbValorTon = new GridBagConstraints();
	  gbc_lbValorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorTon.anchor = GridBagConstraints.EAST;
	  gbc_lbValorTon.gridx = 5;
	  gbc_lbValorTon.gridy = 7;
	  panelCampos.add(getLbMveVal(), gbc_lbValorTon);
	  GridBagConstraints gbc_valorTon = new GridBagConstraints();
	  gbc_valorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_valorTon.gridwidth = 2;
	  gbc_valorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_valorTon.gridx = 6;
	  gbc_valorTon.gridy = 7;
	  panelCampos.add(getMveVal(), gbc_valorTon);
	  GridBagConstraints gbc_lbValorFrete = new GridBagConstraints();
	  gbc_lbValorFrete.anchor = GridBagConstraints.EAST;
	  gbc_lbValorFrete.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorFrete.gridwidth = 2;
	  gbc_lbValorFrete.gridx = 8;
	  gbc_lbValorFrete.gridy = 7;
	  panelCampos.add(getLbValTot(), gbc_lbValorFrete);
	  GridBagConstraints gbc_valTot = new GridBagConstraints();
	  gbc_valTot.insets = new Insets(2, 3, 0, 3);
	  gbc_valTot.fill = GridBagConstraints.BOTH;
	  gbc_valTot.gridwidth = 3;
	  gbc_valTot.gridx = 10;
	  gbc_valTot.gridy = 7;
	  panelCampos.add(getValTot(), gbc_valTot);
	  GridBagConstraints gbc_lbObservacoes = new GridBagConstraints();
	  gbc_lbObservacoes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbObservacoes.anchor = GridBagConstraints.WEST;
	  gbc_lbObservacoes.gridx = 0;
	  gbc_lbObservacoes.gridy = 8;
	  panelCampos.add(getLbObservacoes(), gbc_lbObservacoes);
	  GridBagConstraints gbc_observacoes = new GridBagConstraints();
	  gbc_observacoes.gridwidth = 12;
	  gbc_observacoes.insets = new Insets(2, 3, 0, 3);
	  gbc_observacoes.fill = GridBagConstraints.HORIZONTAL;
	  gbc_observacoes.gridx = 1;
	  gbc_observacoes.gridy = 8;
	  panelCampos.add(getMveObs(), gbc_observacoes);
	}
	return panelCampos;
  }

  private JPanel getLbCdcQtd() {
	if (lbCdcQtd == null) {
	  lbCdcQtd = new JPanel();
	  lbCdcQtd.setMinimumSize(new Dimension(100, 60));
	  lbCdcQtd.setPreferredSize(new Dimension(100, 60));
	  lbCdcQtd.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_lbCdcQtd = new GridBagLayout();
	  gbl_lbCdcQtd.columnWidths = new int[] { 100, 0, 0, 72, 117, 80, 76, 23, 44, 0, 0, 0, 40, 83, 0 };
	  gbl_lbCdcQtd.rowHeights = new int[] { 25, 25, 25, 25, 0 };
	  gbl_lbCdcQtd.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_lbCdcQtd.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  lbCdcQtd.setLayout(gbl_lbCdcQtd);
	  GridBagConstraints gbc_lbCdcDat = new GridBagConstraints();
	  gbc_lbCdcDat.fill = GridBagConstraints.BOTH;
	  gbc_lbCdcDat.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCdcDat.gridx = 0;
	  gbc_lbCdcDat.gridy = 0;
	  lbCdcQtd.add(getLbCdcDat(), gbc_lbCdcDat);
	  GridBagConstraints gbc_cdcDat = new GridBagConstraints();
	  gbc_cdcDat.gridwidth = 2;
	  gbc_cdcDat.insets = new Insets(2, 3, 0, 0);
	  gbc_cdcDat.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cdcDat.gridx = 1;
	  gbc_cdcDat.gridy = 0;
	  lbCdcQtd.add(getCdcDat(), gbc_cdcDat);
	  GridBagConstraints gbc_lbQtdItem = new GridBagConstraints();
	  gbc_lbQtdItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbQtdItem.gridx = 8;
	  gbc_lbQtdItem.gridy = 0;
	  lbCdcQtd.add(getLbQtdItem(), gbc_lbQtdItem);
	  GridBagConstraints gbc_cdcQtd = new GridBagConstraints();
	  gbc_cdcQtd.gridwidth = 2;
	  gbc_cdcQtd.insets = new Insets(2, 3, 0, 0);
	  gbc_cdcQtd.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cdcQtd.gridx = 9;
	  gbc_cdcQtd.gridy = 0;
	  lbCdcQtd.add(getCdcQtd(), gbc_cdcQtd);
	  GridBagConstraints gbc_lbDepCod = new GridBagConstraints();
	  gbc_lbDepCod.fill = GridBagConstraints.BOTH;
	  gbc_lbDepCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDepCod.gridx = 0;
	  gbc_lbDepCod.gridy = 1;
	  lbCdcQtd.add(getLbDepCod(), gbc_lbDepCod);
	  GridBagConstraints gbc_depCod = new GridBagConstraints();
	  gbc_depCod.insets = new Insets(2, 3, 0, 0);
	  gbc_depCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_depCod.gridx = 1;
	  gbc_depCod.gridy = 1;
	  lbCdcQtd.add(getDepCod(), gbc_depCod);
	  GridBagConstraints gbc_lbDescDepto = new GridBagConstraints();
	  gbc_lbDescDepto.fill = GridBagConstraints.BOTH;
	  gbc_lbDescDepto.gridwidth = 5;
	  gbc_lbDescDepto.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescDepto.gridx = 2;
	  gbc_lbDescDepto.gridy = 1;
	  lbCdcQtd.add(getLbDescDepto(), gbc_lbDescDepto);
	  GridBagConstraints gbc_lbCdcVal = new GridBagConstraints();
	  gbc_lbCdcVal.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCdcVal.gridx = 8;
	  gbc_lbCdcVal.gridy = 1;
	  lbCdcQtd.add(getLbCdcVal(), gbc_lbCdcVal);
	  GridBagConstraints gbc_cdcVal = new GridBagConstraints();
	  gbc_cdcVal.gridwidth = 2;
	  gbc_cdcVal.insets = new Insets(2, 3, 0, 0);
	  gbc_cdcVal.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cdcVal.gridx = 9;
	  gbc_cdcVal.gridy = 1;
	  lbCdcQtd.add(getCdcVal(), gbc_cdcVal);
	  GridBagConstraints gbc_lbGruCod = new GridBagConstraints();
	  gbc_lbGruCod.fill = GridBagConstraints.BOTH;
	  gbc_lbGruCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbGruCod.gridx = 0;
	  gbc_lbGruCod.gridy = 2;
	  lbCdcQtd.add(getLbGruCod(), gbc_lbGruCod);
	  GridBagConstraints gbc_gruCod = new GridBagConstraints();
	  gbc_gruCod.insets = new Insets(2, 3, 0, 0);
	  gbc_gruCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_gruCod.gridx = 1;
	  gbc_gruCod.gridy = 2;
	  lbCdcQtd.add(getGruCod(), gbc_gruCod);
	  GridBagConstraints gbc_lbDescGrupoItem = new GridBagConstraints();
	  gbc_lbDescGrupoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescGrupoItem.gridwidth = 6;
	  gbc_lbDescGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescGrupoItem.gridx = 2;
	  gbc_lbDescGrupoItem.gridy = 2;
	  lbCdcQtd.add(getLbDescGrupoItem(), gbc_lbDescGrupoItem);
	  GridBagConstraints gbc_lbCdcSeq = new GridBagConstraints();
	  gbc_lbCdcSeq.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCdcSeq.fill = GridBagConstraints.BOTH;
	  gbc_lbCdcSeq.gridx = 8;
	  gbc_lbCdcSeq.gridy = 2;
	  lbCdcQtd.add(getLbCdcSeq(), gbc_lbCdcSeq);
	  GridBagConstraints gbc_cdcSeq = new GridBagConstraints();
	  gbc_cdcSeq.gridwidth = 2;
	  gbc_cdcSeq.insets = new Insets(2, 3, 0, 0);
	  gbc_cdcSeq.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cdcSeq.gridx = 9;
	  gbc_cdcSeq.gridy = 2;
	  lbCdcQtd.add(getCdcSeq(), gbc_cdcSeq);
	  GridBagConstraints gbc_ipvObs = new GridBagConstraints();
	  gbc_ipvObs.fill = GridBagConstraints.BOTH;
	  gbc_ipvObs.insets = new Insets(2, 3, 0, 3);
	  gbc_ipvObs.gridx = 13;
	  gbc_ipvObs.gridy = 2;
	  lbCdcQtd.add(getIpvObs(), gbc_ipvObs);
	  GridBagConstraints gbc_lbSucCod = new GridBagConstraints();
	  gbc_lbSucCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbSucCod.anchor = GridBagConstraints.WEST;
	  gbc_lbSucCod.gridx = 0;
	  gbc_lbSucCod.gridy = 3;
	  lbCdcQtd.add(getLbSucCod(), gbc_lbSucCod);
	  GridBagConstraints gbc_subCod = new GridBagConstraints();
	  gbc_subCod.insets = new Insets(2, 3, 0, 0);
	  gbc_subCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_subCod.gridx = 1;
	  gbc_subCod.gridy = 3;
	  lbCdcQtd.add(getSubCod(), gbc_subCod);
	  GridBagConstraints gbc_lbDescSubGrupoItem = new GridBagConstraints();
	  gbc_lbDescSubGrupoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescSubGrupoItem.gridwidth = 6;
	  gbc_lbDescSubGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescSubGrupoItem.gridx = 2;
	  gbc_lbDescSubGrupoItem.gridy = 3;
	  lbCdcQtd.add(getLbDescSubGrupoItem(), gbc_lbDescSubGrupoItem);
	  GridBagConstraints gbc_btnLancar = new GridBagConstraints();
	  gbc_btnLancar.insets = new Insets(2, 3, 0, 3);
	  gbc_btnLancar.fill = GridBagConstraints.BOTH;
	  gbc_btnLancar.gridx = 13;
	  gbc_btnLancar.gridy = 3;
	  lbCdcQtd.add(getBtnLancar(), gbc_btnLancar);
	}
	return lbCdcQtd;
  }

  public boolean gravaTela() {

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_MOVIMENTACAO_VEICULO_2", 19, 2));

	  String tipoMov = "C";
	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setLong(param++, getMveIde(), stp);
	  getProc().setString(param++, getVeiPla(), stp);
	  getProc().setInt(param++, getFunCod(), stp);

	  if (getFunCod().isVazio()) {
		getProc().setString(param++, getFunNom(), stp);
	  }
	  else {
		getProc().setString(param++, getlbNomeMot(), stp);
	  }

	  getProc().setDate(param++, getMveDat(), stp);
	  getProc().setDouble(param++, getMvePes(), stp);
	  getProc().setDouble(param++, getKmInic(), stp);
	  getProc().setDouble(param++, getKmFina(), stp);
	  getProc().setString(param++, getMveObs(), stp);
	  getProc().setTimestamp(param++, new Timestamp(new Date().getTime()));
	  getProc().setInt(param++, DeskPratic.getUsuarioSistema().getUsuCod());
	  getProc().setDouble(param++, getMveVal(), stp);
	  getProc().setString(param++, getOriPre(), stp);
	  getProc().setString(param++, getDesPre(), stp);
	  getProc().setDate(param++, getMveDtf(), stp);
	  getProc().setString(param++, tipoMov, stp); // Definido manualmente a pedido do Silveira
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
		limparItens();
		getTabelaRes().limpaTebela();
		getMveIde().requestFocus();
	  }
	  else if (getAcaoTela().equalsIgnoreCase("I")) {
		getMveIde().setEnabled(true);
		getMveIde().setText(String.valueOf(getProc().getProcedureProcesso()));
		getMveIde().requestFocus();
	  }
	  else {
		getMveIde().requestFocus();
	  }

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  getErro().setErro(ex);
	  return false;
	}

	montaTela(getMveIde().getText());
	getMveIde().requestFocus();

	return true;
  }

  public boolean montaTela(String codigo) {
	limpaTela();
	getMveIde().setEnabled(true);

	if (getEmpCod().isVazio() || getFilCod().isVazio() || getMveIde().isVazio()
		|| !getMveIde().isVazio() && TrataString.isNullOrVazia(codigo)) {
	  limpaTela();
	  limparItens();
	  return false;
	}

	try {

	  String query = "select EMPCOD, FILCOD, FILFAN, MVEIDE, VEIPLA, VEIPLADES, FUNCOD, FUNNOM, FUNNOMORI, MVEDAT, MVEPES, KMINIC, KMFINA, "
		  + "MVEOBS, KMRODA, ORIPRE, ORIPREDES, DESPRE, DESPREDES, MVEVAL, OBRCOD, OBRCODDES, MVEDTF, VALTOT "
		  + "FROM ES_VIEW_MOVIMENTACAO_VEICULO_2 " + "where empcod = '" + getEmpCod().getText()
		  + "' and filcod = " + getFilCod().getText() + " and mveide = " + codigo;
	  res = getSelecao().executeQuery(query);

	  if (res.next()) {
		setAcaoTela("A");
		CompTelas.habilitaDesabilitaCamposPanel(true, getLbCdcQtd());
		limpaTela();
		getMveIde().setEnabled(true);
		CompTelas.montaCamposResultSet(res, getPanelCampos(), false);
		getMveIde().setText(TrataString.insereQuebraLinha(res.getString("mveide")));
		setMensagemExclusao("Tem certeza que deseja excluir O PEDIDO DE SERVIÇO: \n ->> "
			+ getMveIde().getText() + " ?");

		montaTelaItens();
	  }
	  else {
		setAcaoTela("I");
		limpaTela();
		getTabelaRes().limpaTebela();
		return false;
	  }

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  System.out.println(ex.getMessage());
	  ex.printStackTrace();
	  getErro().setErro(ex);
	  return false;
	} finally {
	  close(res);
	}

	return true;
  }

  private void montarValorKm() {
	double total = getKmFina().getValorDecimal() - getKmInic().getValorDecimal();
	getLbKmRoda().setText(Numeros.formatarDecimalVariavel(total, 2) + " Km rodados");
	getLbKmRoda().setAuxiliarDeTrabalho(String.valueOf(total));

  }

  private void montarValorFrete() {
	double totalFrete = getMveVal().getValorDecimal() * getMvePes().getValorDecimal();
	getValTot().setText("R$ " + Numeros.formatarDecimalVariavel(totalFrete, 2));
	getValTot().setAuxiliarDeTrabalho(String.valueOf(totalFrete));

  }

  public void limparItens() {

	CompTelas.limparCampos(getLbCdcQtd(), false);
	getIpvObs().limpar();
	getCdcSeq().limpar();
  }

  public boolean gravaTelaItens(String acao) {

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_MOVIMENTACAO_VEICULO_CA", 11, 2));
	  int param = 1;
	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, Types.INTEGER);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setLong(param++, getMveIde(), stp);

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getCdcSeq().getText());
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("CDCSEQ"));
	  }

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setInt(param++, getFilCod(), stp);
	  getProc().setDate(param++, getCdcDat(), stp);
	  getProc().setInt(param++, getDepCod(), stp);
	  getProc().setInt(param++, getGruCod(), stp);
	  getProc().setInt(param++, getSubCod(), stp);

	  getProc().setDouble(param++, getCdcQtd(), stp);

	  getProc().setDouble(param++, getCdcVal(), stp);
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);

	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (!getAcaoTela(getTabelaRes().getAcaoTela()).equalsIgnoreCase("E")) {
		montaTelaItens();
		limparItens();
		getCdcDat().requestFocus();
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

  public boolean montaTelaItens() {

	getTabelaRes().limpaTebela();

	if (getEmpCod().isVazio() || getFilCod().isVazio() || getMveIde().isVazio()) {
	  limpaTela();
	  return false;
	}

	getTabelaRes().setCampoDadosTabelaWhere(" empcod = '" + getEmpCod().getText() + "' and filcod = "
		+ getFilCod().getText() + " and cdcide = " + getMveIde().getText());

	return getTabelaRes().montaTela("");
  }

  public boolean validaTelaItens() {
	return CompTelas.validaTelaAutomatico(getLbCdcQtd(), false);
  }

  public boolean limpaTela() {
	getLbKmRoda().setText(" 0 KM rodados");
	getLbKmRoda().setAuxiliarDeTrabalho("0");
	return super.limpaTela();
  }

  public boolean buscarNome() {

	if (getFunCod().isVazio()) {
	  getFunNom().setEnabled(true);
	  return false;
	}

	try {
	  res = getSelecao().executeQuery(
		  "select funnom from es_funcionarios where funcod = " + getFunCod().getText() + "");
	  if (res.next()) {
		getFunNom().setText(res.getString("funnom"));
		getFunNom().limpar();
		getFunNom().setEnabled(false);
		getMveDat().requestFocus();
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

  public boolean novaTela() {

	getMveIde().transferFocus();
	super.novaTela();
	CompTelas.habilitaDesabilitaCamposPanel(false, getLbCdcQtd());
	getMveIde().limpar();
	getMveIde().setEnabled(false);
	setAcaoTela("I");
	limparItens();
	limpaTela();

	if (getFilCod().isVazio()) {
	  getFilCod().requestFocus();
	}
	else {
	  getVeiPla().requestFocus();
	}

	return true;
  }

  private UnJTablePratic getTabelaRes() {
	if (tabelaRes == null) {
	  tabelaRes = new UnJTablePratic();
	  tabelaRes.setCampoTitulosTabela("Seq, Data, Departamento, Grupo, Subgrupo, Quantidade, Valor");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_MOVIMENTACAO_VEICULO_CA");
	  tabelaRes.setCampoDadosTabela(
		  "CDCSEQ, CDCDAT, DEPCOD || ' - ' || DEPCODDES as DEPCOD, GRUCOD || ' - ' ||  GRUCODDES as GRUCOD, SUBCOD || ' - ' || SUBCODDES as SUBCOD, CDCQTD, CDCVAL ");
	  tabelaRes.setCampoTitulosTabelaTamanhos("40, 90, 200, 200, 200, 120, 120");
	  tabelaRes.getTabela().setColunasCentralizadas("1");
	  tabelaRes.setCampoDadosTabelaOrderBy("CDCSEQ");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getCdcDat());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getLbCdcQtd());
	  // tabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

  private UnJLabel getLbFilCod() {
	if (lbFilial == null) {
	  lbFilial = new UnJLabel();
	  lbFilial.setMinimumSize(new Dimension(110, 19));
	  lbFilial.setPreferredSize(new Dimension(110, 19));
	  lbFilial.setForeground(Color.BLUE);
	  lbFilial.setText("Filial: ");
	}
	return lbFilial;
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
	  filCod.setLabelDescricao(lbDescFilCod);
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbDescFilCod == null) {
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescFilCod.setText("lbFilCod");
	  lbDescFilCod.limpar();

	}
	return lbDescFilCod;
  }

  private UnJLabel getLbVeiPla() {
	if (lbVeiPla == null) {
	  lbVeiPla = new UnJLabel();
	  lbVeiPla.setMinimumSize(new Dimension(110, 19));
	  lbVeiPla.setPreferredSize(new Dimension(110, 19));
	  lbVeiPla.setForeground(Color.BLUE);
	  lbVeiPla.setText("Placa\u00A0do\u00A0Ve\u00EDculo: ");
	}
	return lbVeiPla;
  }

  private UnJLabel getLbFunCod() {
	if (lbFunCod == null) {
	  lbFunCod = new UnJLabel();
	  lbFunCod.setPreferredSize(new Dimension(80, 19));
	  lbFunCod.setMinimumSize(new Dimension(80, 19));
	  lbFunCod.setMaximumSize(new Dimension(80, 19));
	  lbFunCod.setForeground(Color.BLUE);
	  lbFunCod.setText("C\u00F3d.\u00A0Motorista:");
	}
	return lbFunCod;
  }

  private editFormatado getVeiPla() {
	if (veiPla == null) {
	  veiPla = new editFormatado();
	  veiPla.setMaximumSize(new Dimension(40, 19));
	  veiPla.setMinimumSize(new Dimension(40, 19));
	  veiPla.setPreferredSize(new Dimension(40, 19));
	  veiPla.setLabelDescricao(getLbDescVeiPla());
	  veiPla.setName("veipla");
	  veiPla.setName2("Placa V\u00E9iculo do Ve\u00EDculo");
	  veiPla.setTipoValidacao("veiculo");
	  veiPla.setAuxiliarDeTrabalho("placa");
	  veiPla.setTipoFormatacao(16);
	  veiPla.setSoNumeros(false);
	  veiPla.setInputVerifier(DeskPratic.fctGeral.VALIDA_CAMPO);
	  lbDescVeiPla = new UnJLabel();
	  lbDescVeiPla.setName("VEIPLADES");
	  lbDescVeiPla.setText("lbDescPlaca");
	  lbDescVeiPla.setMinimumSize(new Dimension(80, 19));
	  lbDescVeiPla.setPreferredSize(new Dimension(80, 19));
	  lbDescVeiPla.setFont(new Font("Arial", Font.BOLD, 11));
	  veiPla.setLabelDescricao(lbDescVeiPla);
	  veiPla.addUnEditListener(new br.com.praticsistemas.unprtcomps.editFormatadoListener() {
		public void mostraPesquisa(br.com.praticsistemas.unprtcomps.editFormatadoEvent e) {
		  pesquisar(veiPla);
		}
	  });
	}
	return veiPla;

  }

  private EditPratic getFunCod() {
	if (funCod == null) {
	  funCod = new EditPratic();
	  funCod.setTipoValidacao("es_funcionarios");
	  funCod.setLabelDescricao(getLbDescFunCod());
	  funCod.setName("funcod");
	  funCod.setCampoObrigatorio(false);
	  funCod.setAuxiliarDeTrabalho("funcod");
	  funCod.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
		  if (buscarNome() == false) {
			if (e.getOppositeComponent() != null && e.getOppositeComponent().equals(getMveDat())) {
			  getFunNom().requestFocus();
			}
		  }
		}
	  });
	}
	return funCod;
  }

  private UnJLabel getlbNomeMot() {
	if (lbFunNom == null) {
	  lbFunNom = new UnJLabel();
	  lbFunNom.setMinimumSize(new Dimension(110, 19));
	  lbFunNom.setPreferredSize(new Dimension(110, 19));
	  lbFunNom.setText("Nome\u00A0do\u00A0motorista:");
	}
	return lbFunNom;
  }

  private UnEdit getFunNom() {
	if (funNom == null) {
	  funNom = new UnEdit();
	  funNom.setName("funnom");
	  funNom.setCampoObrigatorio(false);
	  funNom.setName2("Nome funcionário");
	  funNom.setMaxLength(73);
	}
	return funNom;
  }

  private UnJLabel getlbPeriodoViagem() {
	if (lbPeriodoViagem == null) {
	  lbPeriodoViagem = new UnJLabel();
	  lbPeriodoViagem.setMinimumSize(new Dimension(110, 19));
	  lbPeriodoViagem.setPreferredSize(new Dimension(110, 19));
	  lbPeriodoViagem.setText("Per\u00EDodo\u00A0da\u00A0viagem:");
	}
	return lbPeriodoViagem;
  }

  private editFormatado getMveDat() {
	if (mveDat == null) {
	  mveDat = new editFormatado();
	  mveDat.setPreferredSize(new Dimension(40, 19));
	  mveDat.setMaximumSize(new Dimension(40, 19));
	  mveDat.setMinimumSize(new Dimension(40, 19));
	  mveDat.setCampoObrigatorio(true);
	  mveDat.setTipoFormatacao(4);
	  mveDat.setName("MVEDAT");
	}
	return mveDat;
  }

  private UnJLabel getlbA() {
	if (lbA == null) {
	  lbA = new UnJLabel();
	  lbA.setHorizontalAlignment(SwingConstants.CENTER);
	  lbA.setMaximumSize(new Dimension(15, 20));
	  lbA.setPreferredSize(new Dimension(15, 20));
	  lbA.setMinimumSize(new Dimension(15, 20));
	  lbA.setText("a");
	}
	return lbA;
  }

  private editFormatado getMveDtf() {
	if (mveDaf == null) {
	  mveDaf = new editFormatado();
	  mveDaf.setPreferredSize(new Dimension(40, 19));
	  mveDaf.setMaximumSize(new Dimension(40, 19));
	  mveDaf.setMinimumSize(new Dimension(40, 19));
	  mveDaf.setCampoObrigatorio(true);
	  mveDaf.setTipoFormatacao(4);
	  mveDaf.setName("MVEDTF");
	}
	return mveDaf;
  }

  private UnJLabel getLbOriPre() {
	if (lbOriPre == null) {
	  lbOriPre = new UnJLabel();
	  lbOriPre.setMinimumSize(new Dimension(110, 19));
	  lbOriPre.setPreferredSize(new Dimension(110, 19));
	  lbOriPre.setForeground(Color.BLUE);
	  lbOriPre.setText("Cidade\u00A0Origem:");
	}
	return lbOriPre;
  }

  private UnJLabel getLbDesPre() {
	if (lbDesPre == null) {
	  lbDesPre = new UnJLabel();
	  lbDesPre.setPreferredSize(new Dimension(80, 19));
	  lbDesPre.setMinimumSize(new Dimension(80, 19));
	  lbDesPre.setMaximumSize(new Dimension(80, 19));
	  lbDesPre.setForeground(Color.BLUE);
	  lbDesPre.setText("Cidade Destino:");
	}
	return lbDesPre;
  }

  private UnJLabel getLbKmInic() {
	if (lbKmInic == null) {
	  lbKmInic = new UnJLabel();
	  lbKmInic.setMinimumSize(new Dimension(110, 19));
	  lbKmInic.setPreferredSize(new Dimension(110, 19));
	  lbKmInic.setText("Km\u00A0Sa\u00EDda:");
	}
	return lbKmInic;
  }

  private editFormatado getKmInic() {
	if (kmInic == null) {
	  kmInic = new editFormatado();
	  kmInic.setPreferredSize(new Dimension(40, 19));
	  kmInic.setMaximumSize(new Dimension(40, 19));
	  kmInic.setMinimumSize(new Dimension(40, 19));
	  kmInic.setQuantidadeCasasDecimais(2);
	  kmInic.setTipoFormatacao(7);
	  kmInic.setName2("Km Saida");
	  kmInic.setCampoObrigatorio(false);
	  kmInic.setName("KMINIC");
	}
	return kmInic;
  }

  private UnJLabel getLbKmFina() {
	if (lbKmFina == null) {
	  lbKmFina = new UnJLabel();
	  lbKmFina.setText("Km\u00A0Chegada:");
	}
	return lbKmFina;
  }

  private editFormatado getKmFina() {
	if (kmFina == null) {
	  kmFina = new editFormatado();
	  kmFina.setMaximumSize(new Dimension(85, 19));
	  kmFina.setMinimumSize(new Dimension(85, 19));
	  kmFina.setCampoObrigatorio(false);
	  kmFina.setQuantidadeCasasDecimais(2);
	  kmFina.setTipoFormatacao(7);
	  kmFina.setName2("Km Inicial");
	  kmFina.setName("KMFINA");
	  kmFina.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montarValorKm();
		}
	  });
	}
	return kmFina;
  }

  private UnJLabel getLbKmRoda() {
	if (lbKmRodado == null) {
	  lbKmRodado = new UnJLabel();
	  lbKmRodado.setPreferredSize(new Dimension(100, 19));
	  lbKmRodado.setMinimumSize(new Dimension(100, 19));
	  lbKmRodado.setMaximumSize(new Dimension(100, 19));
	  lbKmRodado.setFont(new Font("Arial", Font.BOLD, 11));
	  lbKmRodado.setBackground(Color.LIGHT_GRAY);
	  lbKmRodado.setText(" 0 KM rodados ");
	  lbKmRodado.setName("KMRODA");
	  lbKmRodado.setHorizontalAlignment(SwingConstants.CENTER);
	  lbKmRodado.setOpaque(true);
	  lbKmRodado.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montarValorKm();
		}
	  });

	}
	return lbKmRodado;
  }

  private UnJLabel getLbMvePes() {
	if (lbMvePes == null) {
	  lbMvePes = new UnJLabel();
	  lbMvePes.setMinimumSize(new Dimension(110, 19));
	  lbMvePes.setPreferredSize(new Dimension(110, 19));
	  lbMvePes.setText("Peso por Tonelada:");
	}
	return lbMvePes;
  }

  private editFormatado getMvePes() {
	if (mvePes == null) {
	  mvePes = new editFormatado();
	  mvePes.setMaximumSize(new Dimension(40, 19));
	  mvePes.setPreferredSize(new Dimension(40, 19));
	  mvePes.setMinimumSize(new Dimension(40, 19));
	  mvePes.setQuantidadeCasasDecimais(2);
	  mvePes.setTipoFormatacao(7);
	  mvePes.setCampoObrigatorio(true);
	  mvePes.setName("MVEPES");
	}
	return mvePes;
  }

  private UnJLabel getLbMveVal() {
	if (lbMveVal == null) {
	  lbMveVal = new UnJLabel();
	  lbMveVal.setText("Valor por Tonelada:");
	}
	return lbMveVal;
  }

  private editFormatado getMveVal() {
	if (mveVal == null) {
	  mveVal = new editFormatado();
	  mveVal.setMaximumSize(new Dimension(85, 19));
	  mveVal.setMinimumSize(new Dimension(85, 19));
	  mveVal.setCampoObrigatorio(true);
	  mveVal.setName("MVEVAL");
	  mveVal.setQuantidadeCasasDecimais(2);
	  mveVal.setTipoFormatacao(7);
	  mveVal.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montarValorFrete();
		}
	  });
	}
	return mveVal;
  }

  private UnJLabel getLbValTot() {
	if (lbValTot == null) {
	  lbValTot = new UnJLabel();
	  lbValTot.setMaximumSize(new Dimension(100, 19));
	  lbValTot.setMinimumSize(new Dimension(100, 19));
	  lbValTot.setPreferredSize(new Dimension(100, 19));
	  lbValTot.setText("Valor\u00A0total\u00A0do\u00A0Frete:");
	}
	return lbValTot;
  }

  private UnJLabel getLbObservacoes() {
	if (lbMveObs == null) {
	  lbMveObs = new UnJLabel();
	  lbMveObs.setMinimumSize(new Dimension(110, 19));
	  lbMveObs.setPreferredSize(new Dimension(110, 19));
	  lbMveObs.setText("Observa\u00E7\u00F5es:");
	}
	return lbMveObs;
  }

  private UnEdit getMveObs() {
	if (mveObs == null) {
	  mveObs = new UnEdit();
	  mveObs.setCampoObrigatorio(false);
	  mveObs.setName("MVEOBS");
	}
	return mveObs;
  }

  private UnJLabel getLbDescFunCod() {
	if (lbDescFunCod == null) {
	  lbDescFunCod = new UnJLabel();
	  lbDescFunCod.setName("FUNNOM");
	  lbDescFunCod.setText("lbDescMot");
	  lbDescFunCod.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescFunCod;
  }

  private UnJLabel getValTot() {
	if (valTot == null) {
	  valTot = new UnJLabel();
	  valTot.setName("valtot");
	  valTot.setPreferredSize(new Dimension(100, 19));
	  valTot.setMinimumSize(new Dimension(100, 19));
	  valTot.setMaximumSize(new Dimension(100, 19));
	  valTot.setText(" R$ 0,00 ");
	  valTot.setOpaque(true);
	  valTot.setHorizontalAlignment(SwingConstants.CENTER);
	  valTot.setBackground(Color.LIGHT_GRAY);
	  valTot.setFont(new Font("Arial", Font.BOLD, 11));

	}
	return valTot;
  }

  private UnJLabel getLbDescVeiPla() {
	if (lbDescVeiPla == null) {
	  lbDescVeiPla = new UnJLabel();
	}
	return lbDescVeiPla;
  }

  private UnJLabel getLbDescOriPre() {
	if (lbDescOriPre == null) {
	  lbDescOriPre = new UnJLabel();
	  lbDescOriPre.setName("ORIPREDES");
	  lbDescOriPre.setMaximumSize(new Dimension(33333, 19));
	  lbDescOriPre.setMinimumSize(new Dimension(100, 19));
	  lbDescOriPre.setPreferredSize(new Dimension(100, 19));
	  lbDescOriPre.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescOriPre.setText("lbDescCidOrigem");

	}
	return lbDescOriPre;
  }

  private EditPratic getOriPre() {
	if (oriPre == null) {
	  oriPre = new EditPratic();
	  oriPre.setMaximumSize(new Dimension(40, 19));
	  oriPre.setMinimumSize(new Dimension(40, 19));
	  oriPre.setLabelDescricao(getLbDescOriPre());
	  oriPre.setCampoObrigatorio(false);
	  oriPre.setTipoValidacao("MUNICIPIOS");
	  oriPre.setName("ORIPRE");

	}
	return oriPre;
  }

  private UnJLabel getLbDescDesPre() {
	if (lbDescDesPre == null) {
	  lbDescDesPre = new UnJLabel();
	  lbDescDesPre.setName("DESPREDES");
	  lbDescDesPre.setPreferredSize(new Dimension(90, 19));
	  lbDescDesPre.setMaximumSize(new Dimension(333333, 19));
	  lbDescDesPre.setMinimumSize(new Dimension(90, 19));
	  lbDescDesPre.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescDesPre.setText("lbDescCidDestino");

	}
	return lbDescDesPre;
  }

  private EditPratic getDesPre() {
	if (desPre == null) {
	  desPre = new EditPratic();
	  desPre.setTipoValidacao("MUNICIPIOS");
	  desPre.setLabelDescricao(getLbDescDesPre());
	  desPre.setName("despre");
	  desPre.setCampoObrigatorio(false);
	}
	return desPre;
  }

  private UnJLabel getLbCdcDat() {
	if (lbCdcDat == null) {
	  lbCdcDat = new UnJLabel();
	  lbCdcDat.setMaximumSize(new Dimension(110, 20));
	  lbCdcDat.setPreferredSize(new Dimension(110, 20));
	  lbCdcDat.setMinimumSize(new Dimension(110, 20));
	  lbCdcDat.setText("Data:");
	}
	return lbCdcDat;
  }

  private UnJLabel getLbDepCod() {
	if (lbDepCod == null) {
	  lbDepCod = new UnJLabel();
	  lbDepCod.setPreferredSize(new Dimension(90, 20));
	  lbDepCod.setMaximumSize(new Dimension(90, 20));
	  lbDepCod.setMinimumSize(new Dimension(110, 20));
	  lbDepCod.setForeground(Color.BLUE);
	  lbDepCod.setText("Departamento:");
	}
	return lbDepCod;
  }

  private editFormatado getCdcDat() {
	if (cdcDat == null) {
	  cdcDat = new editFormatado();
	  cdcDat.setTipoFormatacao(4);
	  cdcDat.setName("CDCDAT");
	}
	return cdcDat;
  }

  private EditPratic getDepCod() {
	if (depCod == null) {
	  depCod = new EditPratic();
	  depCod.setTipoValidacao("DEPARTAMENTOS");
	  depCod.setCampoEmpresa(empCod);
	  depCod.setLabelDescricao(getLbDescDepto());
	  depCod.setName("DEPCOD");
	}
	return depCod;
  }

  private UnJLabel getLbGruCod() {
	if (lbGruCod == null) {
	  lbGruCod = new UnJLabel();
	  lbGruCod.setMaximumSize(new Dimension(110, 20));
	  lbGruCod.setPreferredSize(new Dimension(110, 20));
	  lbGruCod.setMinimumSize(new Dimension(110, 20));
	  lbGruCod.setForeground(Color.BLUE);
	  lbGruCod.setText("Grupo:");
	}
	return lbGruCod;
  }

  private UnJLabel getLbSucCod() {
	if (lbSucCod == null) {
	  lbSucCod = new UnJLabel();
	  lbSucCod.setMaximumSize(new Dimension(110, 20));
	  lbSucCod.setPreferredSize(new Dimension(110, 20));
	  lbSucCod.setMinimumSize(new Dimension(110, 20));
	  lbSucCod.setForeground(Color.BLUE);
	  lbSucCod.setText("Sub-Grupo:");
	}
	return lbSucCod;
  }

  private EditPratic getGruCod() {
	if (gruCod == null) {
	  gruCod = new EditPratic();
	  gruCod.setTipoValidacao("grupos_despesas");
	  gruCod.setCampoEmpresa(empCod);
	  gruCod.setLabelDescricao(getLbDescGrupoItem());
	  gruCod.setName("GRUCOD");
	}
	return gruCod;
  }

  private EditPratic getSubCod() {
	if (subCod == null) {
	  subCod = new EditPratic();
	  subCod.setTipoValidacao("ES_SUB_GRUPO_DEPESAS/GRUPOS_DEPESAS");
	  subCod.setCampoEmpresa(empCod);
	  subCod.setLabelDescricao(getLbDescSubGrupoItem());
	  subCod.setName("SUBCOD");
	}
	return subCod;
  }

  private UnJLabel getLbQtdItem() {
	if (lbQtdItem == null) {
	  lbQtdItem = new UnJLabel();
	  lbQtdItem.setText("Quantidade:");
	}
	return lbQtdItem;
  }

  private UnJLabel getLbCdcVal() {
	if (lbCdcVal == null) {
	  lbCdcVal = new UnJLabel();
	  lbCdcVal.setText("Valor:");
	}
	return lbCdcVal;
  }

  private editFormatado getCdcQtd() {
	if (cdcQtd == null) {
	  cdcQtd = new editFormatado();
	  cdcQtd.setTipoFormatacao(7);
	  cdcQtd.setQuantidadeCasasDecimais(6);
	  cdcQtd.setName("CDCQTD");
	}
	return cdcQtd;
  }

  private editFormatado getCdcVal() {
	if (cdcVal == null) {
	  cdcVal = new editFormatado();
	  cdcVal.setTipoFormatacao(7);
	  cdcVal.setName("CDCVAL");
	}
	return cdcVal;
  }

  private UnJLabel getLbDescGrupoItem() {
	if (lbDescGrupoItem == null) {
	  lbDescGrupoItem = new UnJLabel();
	  lbDescGrupoItem.setMinimumSize(new Dimension(100, 19));
	  lbDescGrupoItem.setMaximumSize(new Dimension(100, 19));
	  lbDescGrupoItem.setPreferredSize(new Dimension(100, 19));
	  lbDescGrupoItem.setName("GRUCODDES");
	  lbDescGrupoItem.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescGrupoItem.setText("lbDescGrupo");
	}
	return lbDescGrupoItem;
  }

  private UnJLabel getLbDescSubGrupoItem() {
	if (lbDescSubGrupoItem == null) {
	  lbDescSubGrupoItem = new UnJLabel();
	  lbDescSubGrupoItem.setMaximumSize(new Dimension(100, 19));
	  lbDescSubGrupoItem.setPreferredSize(new Dimension(100, 19));
	  lbDescSubGrupoItem.setMinimumSize(new Dimension(100, 19));
	  lbDescSubGrupoItem.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescSubGrupoItem.setText("lbDescSubGrupo");
	  lbDescSubGrupoItem.setName("SUBCODDES");
	}
	return lbDescSubGrupoItem;
  }

  private UnJLabel getLbDescDepto() {
	if (lbDescDepto == null) {
	  lbDescDepto = new UnJLabel();
	  lbDescDepto.setName("DEPCODDES");
	  lbDescDepto.setMinimumSize(new Dimension(100, 19));
	  lbDescDepto.setMaximumSize(new Dimension(100, 19));
	  lbDescDepto.setPreferredSize(new Dimension(100, 19));
	  lbDescDepto.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescDepto.setText("lbDescDepto");
	}
	return lbDescDepto;
  }

  private UnJButton getBtnLancar() {
	if (btnLancar == null) {
	  btnLancar = new UnJButton();
	  btnLancar.setMaximumSize(new Dimension(60, 20));
	  btnLancar.setMinimumSize(new Dimension(60, 20));
	  btnLancar.setTipoFormatacao("lancar");
	  btnLancar.setPreferredSize(new Dimension(60, 20));
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

  private UnJTextoLivre getIpvObs() {
	if (ipvObs == null) {
	  ipvObs = new UnJTextoLivre();
	  ipvObs.setToolTipText("Observa\u00E7\u00F5es Gerais da Nota Fiscal");
	  ipvObs.setPreferredSize(new Dimension(60, 20));
	  ipvObs.setName("IPVOBS");
	  ipvObs.setMnemonic(KeyEvent.VK_UNDEFINED);
	  ipvObs.setMinimumSize(new Dimension(60, 20));
	  ipvObs.setMaximumSize(new Dimension(60, 20));
	  ipvObs.setMaximoLength("900");
	}
	return ipvObs;
  }

  private UnJLabel getLbMveIde() {
	if (lbMveIde == null) {
	  lbMveIde = new UnJLabel();
	  lbMveIde.setMinimumSize(new Dimension(110, 19));
	  lbMveIde.setPreferredSize(new Dimension(110, 19));
	  lbMveIde.setForeground(Color.BLUE);
	  lbMveIde.setText("C\u00F3d. de Lan\u00E7amento:");
	}
	return lbMveIde;
  }

  private EditPratic getMveIde() {
	if (mveIde == null) {
	  mveIde = new EditPratic();
	  mveIde.setMaximumSize(new Dimension(40, 19));
	  mveIde.setMinimumSize(new Dimension(40, 19));
	  mveIde.setCampoEmpresa(super.getEmpCod());
	  mveIde.setHorizontalAlignment(JTextField.CENTER);
	  mveIde.setFont(new Font("Arial", Font.BOLD, 12));
	  mveIde.setCampoSegundaChave(getFilCod());
	  mveIde.setTipoValidacao("MOVIMENTACAO_VEICULO");
	  mveIde.setName("MVEIDE");
	  mveIde.setCampoLimpaTelaAutomatico(false);
	}
	return mveIde;
  }

  private UnJLabel getLbCdcSeq() {
	if (lbCdcSeq == null) {
	  lbCdcSeq = new UnJLabel();
	  lbCdcSeq.setHorizontalAlignment(SwingConstants.RIGHT);
	  lbCdcSeq.setText("Sequ\u00EAncia:");
	}
	return lbCdcSeq;
  }

  private UnJLabel getCdcSeq() {
	if (cdcSeq == null) {
	  cdcSeq = new UnJLabel();
	  cdcSeq.setName("CDCSEQ");
	  cdcSeq.setText("0000");
	  cdcSeq.setMaximumSize(new Dimension(85, 19));
	  cdcSeq.setMinimumSize(new Dimension(85, 19));
	  cdcSeq.setPreferredSize(new Dimension(85, 19));
	  cdcSeq.setBorder(new LineBorder(Color.GRAY));
	  cdcSeq.setHorizontalAlignment(SwingConstants.CENTER);
	}
	return cdcSeq;
  }

  @Override
  public boolean validaTela() {
	return CompTelas.validaTelaAutomatico(getPanelCampos(), true);
  }
}
