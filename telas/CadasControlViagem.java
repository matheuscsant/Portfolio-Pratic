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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

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
import java.awt.Component;
import java.awt.ComponentOrientation;

public class CadasControlViagem extends UnCadastroEmpresa {

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
  private UnJLabel lbDescFunCod;
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
  private UnJLabel lbFilCod;
  private String identificador = null;
  private UnJLabel lbDescMot;
  private UnJLabel lbCalcValorFrete;
  private UnJLabel descVeiPla;
  private UnJLabel lbDescCidOrigem;
  private EditPratic oriPre;
  private UnJLabel lbDescCidDestino;
  private EditPratic desPre;
  private JPanel panelItems;
  private UnJLabel lbDataItem;
  private UnJLabel lbDeptoItem;
  private editFormatado dataItem;
  private EditPratic deptoItem;
  private UnJLabel lbGrupoItem;
  private UnJLabel lbSubGrupoItem;
  private EditPratic grupoItem;
  private EditPratic subGrupoItem;
  private UnJLabel lbQtdItem;
  private UnJLabel lbValorItem;
  private editFormatado quantItem;
  private editFormatado valorItem;
  private UnJLabel lbDescGrupoItem;
  private UnJLabel lbDescSubGrupoItem;
  private UnJLabel lbDescDepto;
  private UnJButton btnLancar;
  private UnJTextoLivre ipvObs;
  private UnJLabel lbCodLancamento;
  private EditPratic codLan;
  private UnJLabel njlblSequncia;
  private UnJLabel labelSequencia;

  public CadasControlViagem() {
	initialize();
	limpaTela();
	limparItens();
	setCampoPreferredSizeEmpresa(new Dimension(108, 19));
	setCampoTelaTrabalho(getCodLan());
	setCampoFocoAberturaTela(getCodLan());
  }

  private void initialize() {
	this.setMinimumSize(new Dimension(900, 690));
	this.setPreferredSize(new Dimension(900, 690));
	this.setSize(new Dimension(900, 623));
	this.setTitle("Controle�de�Viagem");
	this.setCodigoTela("4305");
	this.setFocoAutomaticoGravaTela(false);
	getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasControlViagem = null; // Evento para n�o bloquear a tela
														 // de abrir
	  }
	});

  }

  public void abrirPedido(String pedCod) {
	getCodLan().setText(pedCod);
	montaTela(getCodLan().getText());
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 884, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 212, 105, 142, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_panelCampos = new GridBagConstraints();
	  gbc_panelCampos.fill = GridBagConstraints.BOTH;
	  gbc_panelCampos.gridx = 0;
	  gbc_panelCampos.gridy = 0;
	  panelCentral.add(getPanelCampos(), gbc_panelCampos);
	  GridBagConstraints gbc_panelItems = new GridBagConstraints();
	  gbc_panelItems.fill = GridBagConstraints.BOTH;
	  gbc_panelItems.gridx = 0;
	  gbc_panelItems.gridy = 1;
	  panelCentral.add(getPanelItems(), gbc_panelItems);
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
	  gbl_panelCampos.columnWidths = new int[] { 106, 76, 15, 22, 115, 0, 0, 80, 0, 22, 68, 0, 0, 0, 0,
		  0 };
	  gbl_panelCampos.rowHeights = new int[] { 25, 0, 25, 25, 25, 25, 25, 25, 25, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
		  1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.fill = GridBagConstraints.BOTH;
	  gbc_lbFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilCod.gridwidth = 4;
	  gbc_lbFilCod.gridx = 2;
	  gbc_lbFilCod.gridy = 0;
	  panelCampos.add(getLbDescFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_menuItem = new GridBagConstraints();
	  gbc_menuItem.gridx = 10;
	  gbc_menuItem.gridy = 0;
	  GridBagConstraints gbc_lbCodLancamento = new GridBagConstraints();
	  gbc_lbCodLancamento.anchor = GridBagConstraints.WEST;
	  gbc_lbCodLancamento.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCodLancamento.gridx = 0;
	  gbc_lbCodLancamento.gridy = 1;
	  panelCampos.add(getLbCodLancamento(), gbc_lbCodLancamento);
	  GridBagConstraints gbc_codLan = new GridBagConstraints();
	  gbc_codLan.insets = new Insets(2, 3, 0, 0);
	  gbc_codLan.fill = GridBagConstraints.HORIZONTAL;
	  gbc_codLan.gridx = 1;
	  gbc_codLan.gridy = 1;
	  panelCampos.add(getCodLan(), gbc_codLan);

	  GridBagConstraints gbc_lbPlacaVeiculo = new GridBagConstraints();
	  gbc_lbPlacaVeiculo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPlacaVeiculo.anchor = GridBagConstraints.WEST;
	  gbc_lbPlacaVeiculo.gridx = 0;
	  gbc_lbPlacaVeiculo.gridy = 2;
	  panelCampos.add(getLbVeiPla(), gbc_lbPlacaVeiculo);
	  GridBagConstraints gbc_placaCod = new GridBagConstraints();
	  gbc_placaCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_placaCod.insets = new Insets(2, 3, 0, 0);
	  gbc_placaCod.gridx = 1;
	  gbc_placaCod.gridy = 2;
	  panelCampos.add(getVeiPla(), gbc_placaCod);
	  GridBagConstraints gbc_descPlaca = new GridBagConstraints();
	  gbc_descPlaca.fill = GridBagConstraints.BOTH;
	  gbc_descPlaca.insets = new Insets(2, 3, 2, 3);
	  gbc_descPlaca.gridwidth = 4;
	  gbc_descPlaca.gridx = 2;
	  gbc_descPlaca.gridy = 2;
	  panelCampos.add(getDescVeiPla(), gbc_descPlaca);
	  GridBagConstraints gbc_lbCodMot = new GridBagConstraints();
	  gbc_lbCodMot.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCodMot.anchor = GridBagConstraints.WEST;
	  gbc_lbCodMot.gridx = 6;
	  gbc_lbCodMot.gridy = 2;
	  panelCampos.add(getLbFunCod(), gbc_lbCodMot);
	  GridBagConstraints gbc_codMot = new GridBagConstraints();
	  gbc_codMot.insets = new Insets(2, 3, 0, 0);
	  gbc_codMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_codMot.gridx = 7;
	  gbc_codMot.gridy = 2;
	  panelCampos.add(getFunCod(), gbc_codMot);
	  GridBagConstraints gbc_lbDescMot = new GridBagConstraints();
	  gbc_lbDescMot.fill = GridBagConstraints.BOTH;
	  gbc_lbDescMot.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescMot.gridwidth = 7;
	  gbc_lbDescMot.gridx = 8;
	  gbc_lbDescMot.gridy = 2;
	  panelCampos.add(getLbDescMot(), gbc_lbDescMot);
	  GridBagConstraints gbc_lbNomeMot = new GridBagConstraints();
	  gbc_lbNomeMot.insets = new Insets(2, 3, 0, 0);
	  gbc_lbNomeMot.anchor = GridBagConstraints.WEST;
	  gbc_lbNomeMot.gridx = 0;
	  gbc_lbNomeMot.gridy = 3;
	  panelCampos.add(getlbNomeMot(), gbc_lbNomeMot);
	  GridBagConstraints gbc_nomeMot = new GridBagConstraints();
	  gbc_nomeMot.gridwidth = 14;
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
	  gbc_dataInic.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataInic.insets = new Insets(2, 3, 0, 0);
	  gbc_dataInic.gridx = 1;
	  gbc_dataInic.gridy = 4;
	  panelCampos.add(getMveDat(), gbc_dataInic);
	  GridBagConstraints gbc_lbA = new GridBagConstraints();
	  gbc_lbA.insets = new Insets(2, 3, 0, 0);
	  gbc_lbA.gridx = 2;
	  gbc_lbA.gridy = 4;
	  panelCampos.add(getlbA(), gbc_lbA);
	  GridBagConstraints gbc_dataFim = new GridBagConstraints();
	  gbc_dataFim.insets = new Insets(2, 3, 0, 0);
	  gbc_dataFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataFim.gridx = 3;
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
	  GridBagConstraints gbc_lbDescCidOrigem = new GridBagConstraints();
	  gbc_lbDescCidOrigem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescCidOrigem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescCidOrigem.gridwidth = 4;
	  gbc_lbDescCidOrigem.gridx = 2;
	  gbc_lbDescCidOrigem.gridy = 5;
	  panelCampos.add(getLbDescCidOrigem(), gbc_lbDescCidOrigem);
	  GridBagConstraints gbc_lbCidDestino = new GridBagConstraints();
	  gbc_lbCidDestino.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCidDestino.anchor = GridBagConstraints.EAST;
	  gbc_lbCidDestino.gridx = 6;
	  gbc_lbCidDestino.gridy = 5;
	  panelCampos.add(getLbDesPre(), gbc_lbCidDestino);
	  GridBagConstraints gbc_cidFim = new GridBagConstraints();
	  gbc_cidFim.insets = new Insets(2, 3, 0, 0);
	  gbc_cidFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cidFim.gridx = 7;
	  gbc_cidFim.gridy = 5;
	  panelCampos.add(getDesPre(), gbc_cidFim);
	  GridBagConstraints gbc_lbDescCidDestino = new GridBagConstraints();
	  gbc_lbDescCidDestino.fill = GridBagConstraints.BOTH;
	  gbc_lbDescCidDestino.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescCidDestino.gridwidth = 7;
	  gbc_lbDescCidDestino.gridx = 8;
	  gbc_lbDescCidDestino.gridy = 5;
	  panelCampos.add(getLbDescCidDestino(), gbc_lbDescCidDestino);
	  GridBagConstraints gbc_lbKmSaida = new GridBagConstraints();
	  gbc_lbKmSaida.insets = new Insets(2, 3, 0, 0);
	  gbc_lbKmSaida.anchor = GridBagConstraints.WEST;
	  gbc_lbKmSaida.gridx = 0;
	  gbc_lbKmSaida.gridy = 6;
	  panelCampos.add(getLbKmInic(), gbc_lbKmSaida);
	  GridBagConstraints gbc_kmSaida = new GridBagConstraints();
	  gbc_kmSaida.insets = new Insets(2, 3, 0, 0);
	  gbc_kmSaida.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmSaida.gridx = 1;
	  gbc_kmSaida.gridy = 6;
	  panelCampos.add(getKmInic(), gbc_kmSaida);
	  GridBagConstraints gbc_lbKmChegada = new GridBagConstraints();
	  gbc_lbKmChegada.insets = new Insets(2, 3, 0, 0);
	  gbc_lbKmChegada.anchor = GridBagConstraints.EAST;
	  gbc_lbKmChegada.gridx = 4;
	  gbc_lbKmChegada.gridy = 6;
	  panelCampos.add(getLbKmFina(), gbc_lbKmChegada);
	  GridBagConstraints gbc_kmChegada = new GridBagConstraints();
	  gbc_kmChegada.gridwidth = 2;
	  gbc_kmChegada.insets = new Insets(2, 3, 0, 0);
	  gbc_kmChegada.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmChegada.gridx = 5;
	  gbc_kmChegada.gridy = 6;
	  panelCampos.add(getKmFina(), gbc_kmChegada);
	  GridBagConstraints gbc_lbKmRodado = new GridBagConstraints();
	  gbc_lbKmRodado.fill = GridBagConstraints.BOTH;
	  gbc_lbKmRodado.gridwidth = 2;
	  gbc_lbKmRodado.insets = new Insets(2, 3, 0, 0);
	  gbc_lbKmRodado.gridx = 7;
	  gbc_lbKmRodado.gridy = 6;
	  panelCampos.add(getLbKmRoda(), gbc_lbKmRodado);
	  GridBagConstraints gbc_lbPesPorTon = new GridBagConstraints();
	  gbc_lbPesPorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesPorTon.anchor = GridBagConstraints.WEST;
	  gbc_lbPesPorTon.gridx = 0;
	  gbc_lbPesPorTon.gridy = 7;
	  panelCampos.add(getLbMvePes(), gbc_lbPesPorTon);
	  GridBagConstraints gbc_pesPorTon = new GridBagConstraints();
	  gbc_pesPorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_pesPorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_pesPorTon.gridx = 1;
	  gbc_pesPorTon.gridy = 7;
	  panelCampos.add(getMvePes(), gbc_pesPorTon);
	  GridBagConstraints gbc_lbValorTon = new GridBagConstraints();
	  gbc_lbValorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorTon.anchor = GridBagConstraints.EAST;
	  gbc_lbValorTon.gridx = 4;
	  gbc_lbValorTon.gridy = 7;
	  panelCampos.add(getLbMveVal(), gbc_lbValorTon);
	  GridBagConstraints gbc_valorTon = new GridBagConstraints();
	  gbc_valorTon.insets = new Insets(2, 3, 0, 0);
	  gbc_valorTon.gridwidth = 2;
	  gbc_valorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_valorTon.gridx = 5;
	  gbc_valorTon.gridy = 7;
	  panelCampos.add(getMveVal(), gbc_valorTon);
	  GridBagConstraints gbc_lbValorFrete = new GridBagConstraints();
	  gbc_lbValorFrete.anchor = GridBagConstraints.EAST;
	  gbc_lbValorFrete.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorFrete.gridwidth = 2;
	  gbc_lbValorFrete.gridx = 7;
	  gbc_lbValorFrete.gridy = 7;
	  panelCampos.add(getLbValTot(), gbc_lbValorFrete);
	  GridBagConstraints gbc_lbCalcValorFrete = new GridBagConstraints();
	  gbc_lbCalcValorFrete.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCalcValorFrete.fill = GridBagConstraints.BOTH;
	  gbc_lbCalcValorFrete.gridwidth = 3;
	  gbc_lbCalcValorFrete.gridx = 9;
	  gbc_lbCalcValorFrete.gridy = 7;
	  panelCampos.add(getLbCalcValorFrete(), gbc_lbCalcValorFrete);
	  GridBagConstraints gbc_lbObservacoes = new GridBagConstraints();
	  gbc_lbObservacoes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbObservacoes.anchor = GridBagConstraints.WEST;
	  gbc_lbObservacoes.gridx = 0;
	  gbc_lbObservacoes.gridy = 8;
	  panelCampos.add(getLbObservacoes(), gbc_lbObservacoes);
	  GridBagConstraints gbc_observacoes = new GridBagConstraints();
	  gbc_observacoes.gridwidth = 14;
	  gbc_observacoes.insets = new Insets(2, 3, 0, 3);
	  gbc_observacoes.fill = GridBagConstraints.HORIZONTAL;
	  gbc_observacoes.gridx = 1;
	  gbc_observacoes.gridy = 8;
	  panelCampos.add(getMveObs(), gbc_observacoes);
	}
	return panelCampos;
  }

  private JPanel getPanelItems() {
	if (panelItems == null) {
	  panelItems = new JPanel();
	  panelItems.setMinimumSize(new Dimension(100, 60));
	  panelItems.setPreferredSize(new Dimension(100, 60));
	  panelItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelItems = new GridBagLayout();
	  gbl_panelItems.columnWidths = new int[] { 110, 0, 72, 117, 80, 76, 23, 44, 0, 0, 0, 40, 0 };
	  gbl_panelItems.rowHeights = new int[] { 25, 25, 25, 25, 0 };
	  gbl_panelItems.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelItems.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelItems.setLayout(gbl_panelItems);
	  GridBagConstraints gbc_lbDataItem = new GridBagConstraints();
	  gbc_lbDataItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDataItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDataItem.gridx = 0;
	  gbc_lbDataItem.gridy = 0;
	  panelItems.add(getLbDataItem(), gbc_lbDataItem);
	  GridBagConstraints gbc_dataItem = new GridBagConstraints();
	  gbc_dataItem.insets = new Insets(2, 3, 0, 0);
	  gbc_dataItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataItem.gridx = 1;
	  gbc_dataItem.gridy = 0;
	  panelItems.add(getDataItem(), gbc_dataItem);
	  GridBagConstraints gbc_lbQtdItem = new GridBagConstraints();
	  gbc_lbQtdItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbQtdItem.gridx = 7;
	  gbc_lbQtdItem.gridy = 0;
	  panelItems.add(getLbQtdItem(), gbc_lbQtdItem);
	  GridBagConstraints gbc_QuantItem = new GridBagConstraints();
	  gbc_QuantItem.insets = new Insets(2, 3, 0, 0);
	  gbc_QuantItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_QuantItem.gridx = 8;
	  gbc_QuantItem.gridy = 0;
	  panelItems.add(getQuantItem(), gbc_QuantItem);
	  GridBagConstraints gbc_lbDeptoItem = new GridBagConstraints();
	  gbc_lbDeptoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDeptoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDeptoItem.gridx = 0;
	  gbc_lbDeptoItem.gridy = 1;
	  panelItems.add(getLbDeptoItem(), gbc_lbDeptoItem);
	  GridBagConstraints gbc_DeptoItem = new GridBagConstraints();
	  gbc_DeptoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_DeptoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_DeptoItem.gridx = 1;
	  gbc_DeptoItem.gridy = 1;
	  panelItems.add(getDeptoItem(), gbc_DeptoItem);
	  GridBagConstraints gbc_lbDescDepto = new GridBagConstraints();
	  gbc_lbDescDepto.fill = GridBagConstraints.BOTH;
	  gbc_lbDescDepto.gridwidth = 4;
	  gbc_lbDescDepto.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescDepto.gridx = 2;
	  gbc_lbDescDepto.gridy = 1;
	  panelItems.add(getLbDescDepto(), gbc_lbDescDepto);
	  GridBagConstraints gbc_lbValorItem = new GridBagConstraints();
	  gbc_lbValorItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValorItem.gridx = 7;
	  gbc_lbValorItem.gridy = 1;
	  panelItems.add(getLbValorItem(), gbc_lbValorItem);
	  GridBagConstraints gbc_ValorItem = new GridBagConstraints();
	  gbc_ValorItem.insets = new Insets(2, 3, 0, 0);
	  gbc_ValorItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_ValorItem.gridx = 8;
	  gbc_ValorItem.gridy = 1;
	  panelItems.add(getValorItem(), gbc_ValorItem);
	  GridBagConstraints gbc_lbGrupoItem = new GridBagConstraints();
	  gbc_lbGrupoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbGrupoItem.gridx = 0;
	  gbc_lbGrupoItem.gridy = 2;
	  panelItems.add(getLbGrupoItem(), gbc_lbGrupoItem);
	  GridBagConstraints gbc_GrupoItem = new GridBagConstraints();
	  gbc_GrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_GrupoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_GrupoItem.gridx = 1;
	  gbc_GrupoItem.gridy = 2;
	  panelItems.add(getGrupoItem(), gbc_GrupoItem);
	  GridBagConstraints gbc_lbDescGrupoItem = new GridBagConstraints();
	  gbc_lbDescGrupoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescGrupoItem.gridwidth = 5;
	  gbc_lbDescGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescGrupoItem.gridx = 2;
	  gbc_lbDescGrupoItem.gridy = 2;
	  panelItems.add(getLbDescGrupoItem(), gbc_lbDescGrupoItem);
	  GridBagConstraints gbc_njlblSequncia = new GridBagConstraints();
	  gbc_njlblSequncia.insets = new Insets(2, 3, 0, 0);
	  gbc_njlblSequncia.fill = GridBagConstraints.BOTH;
	  gbc_njlblSequncia.gridx = 7;
	  gbc_njlblSequncia.gridy = 2;
	  panelItems.add(getNjlblSequncia(), gbc_njlblSequncia);
	  GridBagConstraints gbc_labelSequencia = new GridBagConstraints();
	  gbc_labelSequencia.insets = new Insets(2, 3, 0, 0);
	  gbc_labelSequencia.fill = GridBagConstraints.HORIZONTAL;
	  gbc_labelSequencia.gridx = 8;
	  gbc_labelSequencia.gridy = 2;
	  panelItems.add(getLabelSequencia(), gbc_labelSequencia);
	  GridBagConstraints gbc_ipvObs = new GridBagConstraints();
	  gbc_ipvObs.fill = GridBagConstraints.BOTH;
	  gbc_ipvObs.insets = new Insets(2, 3, 0, 3);
	  gbc_ipvObs.gridx = 11;
	  gbc_ipvObs.gridy = 2;
	  panelItems.add(getIpvObs(), gbc_ipvObs);
	  GridBagConstraints gbc_lbSubGrupoItem = new GridBagConstraints();
	  gbc_lbSubGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbSubGrupoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbSubGrupoItem.gridx = 0;
	  gbc_lbSubGrupoItem.gridy = 3;
	  panelItems.add(getLbSubGrupoItem(), gbc_lbSubGrupoItem);
	  GridBagConstraints gbc_SubGrupoItem = new GridBagConstraints();
	  gbc_SubGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_SubGrupoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_SubGrupoItem.gridx = 1;
	  gbc_SubGrupoItem.gridy = 3;
	  panelItems.add(getSubGrupoItem(), gbc_SubGrupoItem);
	  GridBagConstraints gbc_lbDescSubGrupoItem = new GridBagConstraints();
	  gbc_lbDescSubGrupoItem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescSubGrupoItem.gridwidth = 5;
	  gbc_lbDescSubGrupoItem.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDescSubGrupoItem.gridx = 2;
	  gbc_lbDescSubGrupoItem.gridy = 3;
	  panelItems.add(getLbDescSubGrupoItem(), gbc_lbDescSubGrupoItem);
	  GridBagConstraints gbc_btnLancar = new GridBagConstraints();
	  gbc_btnLancar.insets = new Insets(2, 3, 0, 3);
	  gbc_btnLancar.fill = GridBagConstraints.BOTH;
	  gbc_btnLancar.gridx = 11;
	  gbc_btnLancar.gridy = 3;
	  panelItems.add(getBtnLancar(), gbc_btnLancar);
	}
	return panelItems;
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
	  getProc().setLong(param++, getIdentificador());
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
		getCodLan().requestFocus();
	  }
	  else if (getAcaoTela().equalsIgnoreCase("I")) {
		getCodLan().setEnabled(true);
		getCodLan().setText(String.valueOf(getProc().getProcedureProcesso()));
		getCodLan().requestFocus();
	  }
	  else {
		getCodLan().requestFocus();
	  }

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  getErro().setErro(ex);
	  return false;
	}

	montaTela(getCodLan().getText());
	getCodLan().requestFocus();

	return true;
  }

  public boolean montaTela(String codigo) {
	limpaTela();
	getCodLan().setEnabled(true);

	if (getEmpCod().isVazio() || getFilCod().isVazio() || getCodLan().isVazio()
		|| !getCodLan().isVazio() && TrataString.isNullOrVazia(codigo)) {
	  limpaTela();
	  limparItens();
	  return false;
	}

	try {

	  String query = "select EMPCOD, FILCOD, FILFAN, MVEIDE, VEIPLA, VEIPLADES, FUNCOD, FUNNOM, FUNNOMORI, MVEDAT, MVEPES, KMINIC, KMFINA, "
		  + "MVEOBS, KMRODA, ORIPRE, ORIPREDES, DESPRE, DESPREDES, MVEVAL, OBRCOD, OBRCODDES, MVEDTF "
		  + "FROM ES_VIEW_MOVIMENTACAO_VEICULO_2 " + "where empcod = '" + getEmpCod().getText()
		  + "' and filcod = " + getFilCod().getText() + " and mveide = " + codigo;
	  res = getSelecao().executeQuery(query);

	  if (res.next()) {
		setAcaoTela("A");
		CompTelas.habilitaDesabilitaCamposPanel(true, getPanelItems());
		limpaTela();
		getCodLan().setEnabled(true);
		CompTelas.montaCamposResultSet(res, getPanelCampos(), false);
		getCodLan().setText(TrataString.insereQuebraLinha(res.getString("mveide")));
		setMensagemExclusao("Tem certeza que deseja excluir O PEDIDO DE SERVI�O: \n ->> "
			+ getCodLan().getText() + " ?");

	  }
	  else {
		setAcaoTela("I");
		limpaTela();
		getTabelaRes().limpaTebela();
		return false;
	  }

	  montaTelaItens();
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
	getLbCalcValorFrete().setText("R$ " + Numeros.formatarDecimalVariavel(totalFrete, 2));
	getLbCalcValorFrete().setAuxiliarDeTrabalho(String.valueOf(totalFrete));

  }

  public void limparItens() {

	CompTelas.limparCampos(getPanelItems(), false);
	getIpvObs().limpar();
	getLabelSequencia().limpar();
  }

  public boolean gravaTelaItens(String acao) {

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_MOVIMENTACAO_VEICULO_CA", 11, 2));
	  int param = 1;
	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, Types.INTEGER);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setLong(param++, getCodLan().getText());

	  if (getTabelaRes().isPegarDoGrid() == false) {
		getProc().setInt(param++, getLabelSequencia().getText());
	  }
	  else {
		getProc().setInt(param++, getTabelaRes().getDadosExcluir("CDCSEQ"));
	  }

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setInt(param++, getFilCod(), stp);
	  getProc().setDate(param++, getDataItem(), stp);
	  getProc().setInt(param++, getDeptoItem(), stp);
	  getProc().setInt(param++, getGrupoItem(), stp);
	  getProc().setInt(param++, getSubGrupoItem(), stp);

	  getProc().setDouble(param++, getQuantItem(), stp);

	  getProc().setDouble(param++, getValorItem(), stp);
	  getProc().setString(param++, getAcaoTela(getTabelaRes().getAcaoTela()));

	  stp.execute();

	  getProc().finalizarProcedure(stp, 1, 2);

	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
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
	  montaTelaItens();
	  limparItens();
	  getDataItem().requestFocus();
	}

	return true;
  }

  public boolean montaTelaItens() {

	getTabelaRes().limpaTebela();

	if (getEmpCod().isVazio() || getFilCod().isVazio() || getCodLan().isVazio()) {
	  limpaTela();
	  return false;
	}

	getTabelaRes().setCampoDadosTabelaWhere(" empcod = '" + getEmpCod().getText() + "' and filcod = "
		+ getFilCod().getText() + " and cdcide = " + getCodLan().getText());

	return getTabelaRes().montaTela("");
  }

  public boolean validaTelaItens() {

	JTextComponent campo = null;
	String erro = "";

	if (getDataItem().isVazio()) {
	  erro = "A DATA deve ser preenchida !";
	  campo = dataItem;
	}
	else if (deptoItem.isVazio()) {
	  erro = "O DEPARTAMENTO deve ser preenchido !";
	  campo = deptoItem;
	}
	else if (grupoItem.isVazio()) {
	  erro = "O GRUPO deve ser preenchido !";
	  campo = grupoItem;
	}
	else if (subGrupoItem.isVazio()) {
	  erro = "O SUB-GRUPO deve ser preenchido !";
	  campo = subGrupoItem;
	}
	else if (quantItem.isVazio()) {
	  erro = "A QUANTIDADE deve ser preenchida !";
	  campo = quantItem;
	}
	else if (valorItem.isVazio()) {
	  erro = "O VALOR deve ser preenchido !";
	  campo = valorItem;
	}

	if (!erro.equalsIgnoreCase("")) {
	  mostraMensagem(erro);
	  campo.requestFocus();

	  return false;
	}

	return true;

  }

  public String getIdentificador() {
	return identificador;
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

	getCodLan().transferFocus();
	super.novaTela();
	CompTelas.habilitaDesabilitaCamposPanel(false, getPanelItems());
	getCodLan().limpar();
	getCodLan().setEnabled(false);
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
	  tabelaRes.setSize(new Dimension(531, 100));
	  tabelaRes.setMaximumSize(new Dimension(531, 100));
	  tabelaRes.setMinimumSize(new Dimension(531, 100));
	  tabelaRes.setPreferredSize(new Dimension(531, 100));
	  tabelaRes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  tabelaRes.setCampoTitulosTabela(
		  "Seq, Data, Depto., Depto. Desc., Grupo, Grupo Desc., Subgrupo, SubGrupo Desc., Quantidade, Valor");
	  tabelaRes.setCampoDadosTabelaView("ES_VIEW_MOVIMENTACAO_VEICULO_CA");
	  tabelaRes.setCampoDadosTabela(
		  "CDCSEQ, CDCDAT, DEPCOD, DEPCODDES, GRUCOD, GRUCODDES, SUBCOD, SUBCODDES, CDCQTD, CDCVAL ");
	  tabelaRes.setCampoTitulosTabelaTamanhos("20, 20, 20, 50, 20, 100, 20, 100, 20, 20");
	  tabelaRes.getTabela().setBackground(Color.white);
	  tabelaRes.setCampoDadosTabelaOrderBy("CDCSEQ");
	  tabelaRes.setConexao(DeskPratic.getConexao());
	  tabelaRes.setCampoFocoAlterarItens(getDataItem());
	  tabelaRes.setFocusable(false);
	  tabelaRes.setPanelCampos(getPanelItems());
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
	  filCod.setMaximumSize(new Dimension(40, 19));
	  filCod.setMinimumSize(new Dimension(40, 19));
	  filCod.setName("filcod");
	  filCod.setName2("C�digo da Filial Inicial");
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setTipoValidacao("filiais");
	  filCod.setCampoEmpresa(super.getEmpCod());
	  filCod.setCampoLimpaTelaAutomatico(false);
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("lbFilCod");
	  lbFilCod.setPreferredSize(new Dimension(100, 14));
	  lbFilCod.setMinimumSize(new Dimension(100, 14));
	  lbFilCod.setMaximumSize(new Dimension(100, 14));
	  lbFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	  filCod.setLabelDescricao(lbFilCod);
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	  lbFilCod.setText("lbFilCod");
	  lbFilCod.limpar();

	}
	return lbFilCod;
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
	  veiPla.setLabelDescricao(getDescVeiPla());
	  veiPla.setName("veipla");
	  veiPla.setName2("Placa V\u00E9iculo do Ve\u00EDculo");
	  veiPla.setTipoValidacao("veiculo");
	  veiPla.setAuxiliarDeTrabalho("placa");
	  veiPla.setTipoFormatacao(16);
	  veiPla.setSoNumeros(false);
	  veiPla.setInputVerifier(DeskPratic.fctGeral.VALIDA_CAMPO);
	  descVeiPla = new UnJLabel();
	  descVeiPla.setName("VEIPLADES");
	  descVeiPla.setText("lbDescPlaca");
	  descVeiPla.setMinimumSize(new Dimension(80, 19));
	  descVeiPla.setPreferredSize(new Dimension(80, 19));
	  descVeiPla.setFont(new Font("Arial", Font.BOLD, 11));
	  veiPla.setLabelDescricao(descVeiPla);
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
	  funCod.setLabelDescricao(getLbDescMot());
	  funCod.setMinimumSize(new Dimension(80, 19));
	  funCod.setMaximumSize(new Dimension(80, 19));
	  funCod.setPreferredSize(new Dimension(80, 19));
	  funCod.setName("funcod");
	  funCod.setTipoValidacao("es_funcionarios");
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
	if (lbDescFunCod == null) {
	  lbDescFunCod = new UnJLabel();
	  lbDescFunCod.setMinimumSize(new Dimension(110, 19));
	  lbDescFunCod.setPreferredSize(new Dimension(110, 19));
	  lbDescFunCod.setText("Nome\u00A0do\u00A0motorista:");
	}
	return lbDescFunCod;
  }

  private UnEdit getFunNom() {
	if (funNom == null) {
	  funNom = new UnEdit();
	  funNom.setName("funnom");
	  funNom.setCampoObrigatorio(false);
	  funNom.setName2("Nome funcion�rio");
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
	  kmInic.setName2("Km�Saida");
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
	  kmFina.setName2("Km�Inicial");
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

  private UnJLabel getLbDescMot() {
	if (lbDescMot == null) {
	  lbDescMot = new UnJLabel();
	  lbDescMot.setName("FUNNOM");
	  lbDescMot.setText("lbDescMot");
	  lbDescMot.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescMot;
  }

  private UnJLabel getLbCalcValorFrete() {
	if (lbCalcValorFrete == null) {
	  lbCalcValorFrete = new UnJLabel();
	  lbCalcValorFrete.setPreferredSize(new Dimension(100, 19));
	  lbCalcValorFrete.setMinimumSize(new Dimension(100, 19));
	  lbCalcValorFrete.setMaximumSize(new Dimension(100, 19));
	  lbCalcValorFrete.setText(" R$ 0,00 ");
	  lbCalcValorFrete.setOpaque(true);
	  lbCalcValorFrete.setHorizontalAlignment(SwingConstants.CENTER);
	  lbCalcValorFrete.setBackground(Color.LIGHT_GRAY);
	  lbCalcValorFrete.setFont(new Font("Arial", Font.BOLD, 11));

	}
	return lbCalcValorFrete;
  }

  private UnJLabel getDescVeiPla() {
	if (descVeiPla == null) {
	  descVeiPla = new UnJLabel();
	}
	return descVeiPla;
  }

  private UnJLabel getLbDescCidOrigem() {
	if (lbDescCidOrigem == null) {
	  lbDescCidOrigem = new UnJLabel();
	  lbDescCidOrigem.setName("ORIPREDES");
	  lbDescCidOrigem.setMaximumSize(new Dimension(33333, 19));
	  lbDescCidOrigem.setMinimumSize(new Dimension(100, 19));
	  lbDescCidOrigem.setPreferredSize(new Dimension(100, 19));
	  lbDescCidOrigem.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescCidOrigem.setText("lbDescCidOrigem");

	}
	return lbDescCidOrigem;
  }

  private EditPratic getOriPre() {
	if (oriPre == null) {
	  oriPre = new EditPratic();
	  oriPre.setMaximumSize(new Dimension(40, 19));
	  oriPre.setMinimumSize(new Dimension(40, 19));
	  oriPre.setLabelDescricao(getLbDescCidOrigem());
	  oriPre.setCampoObrigatorio(false);
	  oriPre.setTipoValidacao("MUNICIPIOS");
	  oriPre.setName("ORIPRE");

	}
	return oriPre;
  }

  private UnJLabel getLbDescCidDestino() {
	if (lbDescCidDestino == null) {
	  lbDescCidDestino = new UnJLabel();
	  lbDescCidDestino.setName("DESPREDES");
	  lbDescCidDestino.setPreferredSize(new Dimension(90, 19));
	  lbDescCidDestino.setMaximumSize(new Dimension(333333, 19));
	  lbDescCidDestino.setMinimumSize(new Dimension(90, 19));
	  lbDescCidDestino.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescCidDestino.setText("lbDescCidDestino");

	}
	return lbDescCidDestino;
  }

  private EditPratic getDesPre() {
	if (desPre == null) {
	  desPre = new EditPratic();
	  desPre.setPreferredSize(new Dimension(80, 19));
	  desPre.setMaximumSize(new Dimension(80, 19));
	  desPre.setMinimumSize(new Dimension(80, 19));
	  desPre.setLabelDescricao(getLbDescCidDestino());
	  desPre.setTipoValidacao("MUNICIPIOS");
	  desPre.setName("despre");
	  desPre.setCampoObrigatorio(false);
	}
	return desPre;
  }

  private UnJLabel getLbDataItem() {
	if (lbDataItem == null) {
	  lbDataItem = new UnJLabel();
	  lbDataItem.setMaximumSize(new Dimension(110, 20));
	  lbDataItem.setPreferredSize(new Dimension(110, 20));
	  lbDataItem.setMinimumSize(new Dimension(110, 20));
	  lbDataItem.setText("Data:");
	}
	return lbDataItem;
  }

  private UnJLabel getLbDeptoItem() {
	if (lbDeptoItem == null) {
	  lbDeptoItem = new UnJLabel();
	  lbDeptoItem.setPreferredSize(new Dimension(110, 20));
	  lbDeptoItem.setMaximumSize(new Dimension(110, 20));
	  lbDeptoItem.setMinimumSize(new Dimension(110, 20));
	  lbDeptoItem.setForeground(Color.BLUE);
	  lbDeptoItem.setText("Departamento:");
	}
	return lbDeptoItem;
  }

  private editFormatado getDataItem() {
	if (dataItem == null) {
	  dataItem = new editFormatado();
	  dataItem.setTipoFormatacao(4);
	  dataItem.setName("CDCDAT");
	  dataItem.setCampoObrigatorio(false);
	}
	return dataItem;
  }

  private EditPratic getDeptoItem() {
	if (deptoItem == null) {
	  deptoItem = new EditPratic();
	  deptoItem.setCampoEmpresa(empCod);
	  deptoItem.setTipoValidacao("DEPARTAMENTOS");
	  deptoItem.setLabelDescricao(getLbDescDepto());
	  deptoItem.setName("DEPCOD");
	  deptoItem.setCampoObrigatorio(false);
	}
	return deptoItem;
  }

  private UnJLabel getLbGrupoItem() {
	if (lbGrupoItem == null) {
	  lbGrupoItem = new UnJLabel();
	  lbGrupoItem.setMaximumSize(new Dimension(110, 20));
	  lbGrupoItem.setPreferredSize(new Dimension(110, 20));
	  lbGrupoItem.setMinimumSize(new Dimension(110, 20));
	  lbGrupoItem.setForeground(Color.BLUE);
	  lbGrupoItem.setText("Grupo:");
	}
	return lbGrupoItem;
  }

  private UnJLabel getLbSubGrupoItem() {
	if (lbSubGrupoItem == null) {
	  lbSubGrupoItem = new UnJLabel();
	  lbSubGrupoItem.setMaximumSize(new Dimension(110, 20));
	  lbSubGrupoItem.setPreferredSize(new Dimension(110, 20));
	  lbSubGrupoItem.setMinimumSize(new Dimension(110, 20));
	  lbSubGrupoItem.setForeground(Color.BLUE);
	  lbSubGrupoItem.setText("Sub-Grupo:");
	}
	return lbSubGrupoItem;
  }

  private EditPratic getGrupoItem() {
	if (grupoItem == null) {
	  grupoItem = new EditPratic();
	  grupoItem.setMaximumSize(new Dimension(40, 20));
	  grupoItem.setMinimumSize(new Dimension(40, 20));
	  grupoItem.setPreferredSize(new Dimension(40, 20));
	  grupoItem.setCampoEmpresa(empCod);
	  grupoItem.setLabelDescricao(getLbDescGrupoItem());
	  grupoItem.setName("GRUCOD");
	  grupoItem.setTipoValidacao("grupos_despesas");
	  grupoItem.setCampoObrigatorio(false);
	}
	return grupoItem;
  }

  private EditPratic getSubGrupoItem() {
	if (subGrupoItem == null) {
	  subGrupoItem = new EditPratic();
	  subGrupoItem.setPreferredSize(new Dimension(40, 20));
	  subGrupoItem.setMinimumSize(new Dimension(40, 20));
	  subGrupoItem.setMaximumSize(new Dimension(40, 20));
	  subGrupoItem.setCampoEmpresa(empCod);
	  subGrupoItem.setLabelDescricao(getLbDescSubGrupoItem());
	  subGrupoItem.setName("SUBCOD");
	  subGrupoItem.setTipoValidacao("ES_SUB_GRUPO_DEPESAS/GRUPOS_DEPESAS");
	  subGrupoItem.setCampoObrigatorio(false);
	}
	return subGrupoItem;
  }

  private UnJLabel getLbQtdItem() {
	if (lbQtdItem == null) {
	  lbQtdItem = new UnJLabel();
	  lbQtdItem.setText("Quantidade:");
	}
	return lbQtdItem;
  }

  private UnJLabel getLbValorItem() {
	if (lbValorItem == null) {
	  lbValorItem = new UnJLabel();
	  lbValorItem.setText("Valor:");
	}
	return lbValorItem;
  }

  private editFormatado getQuantItem() {
	if (quantItem == null) {
	  quantItem = new editFormatado();
	  quantItem.setQuantidadeCasasDecimais(6);
	  quantItem.setTipoFormatacao(7);
	  quantItem.setName("CDCQTD");
	  quantItem.setCampoObrigatorio(false);
	}
	return quantItem;
  }

  private editFormatado getValorItem() {
	if (valorItem == null) {
	  valorItem = new editFormatado();
	  valorItem.setHorizontalAlignment(SwingConstants.CENTER);
	  valorItem.setTipoFormatacao(7);
	  valorItem.setName("CDCVAL");
	  valorItem.setCampoObrigatorio(false);
	}
	return valorItem;
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
	  btnLancar.setMaximumSize(new Dimension(30, 20));
	  btnLancar.setMinimumSize(new Dimension(30, 20));
	  btnLancar.setTipoFormatacao("lancar");
	  btnLancar.setPreferredSize(new Dimension(30, 20));
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
	  ipvObs.setPreferredSize(new Dimension(30, 20));
	  ipvObs.setName("IPVOBS");
	  ipvObs.setMnemonic(KeyEvent.VK_UNDEFINED);
	  ipvObs.setMinimumSize(new Dimension(30, 20));
	  ipvObs.setMaximumSize(new Dimension(30, 20));
	  ipvObs.setMaximoLength("900");
	}
	return ipvObs;
  }

  private UnJLabel getLbCodLancamento() {
	if (lbCodLancamento == null) {
	  lbCodLancamento = new UnJLabel();
	  lbCodLancamento.setMinimumSize(new Dimension(110, 19));
	  lbCodLancamento.setPreferredSize(new Dimension(110, 19));
	  lbCodLancamento.setForeground(Color.BLUE);
	  lbCodLancamento.setText("C\u00F3d. de Lan\u00E7amento:");
	}
	return lbCodLancamento;
  }

  private EditPratic getCodLan() {
	if (codLan == null) {
	  codLan = new EditPratic();
	  codLan.setMaximumSize(new Dimension(40, 19));
	  codLan.setMinimumSize(new Dimension(40, 19));
	  codLan.setCampoEmpresa(super.getEmpCod());
	  codLan.setHorizontalAlignment(JTextField.CENTER);
	  codLan.setFont(new Font("Arial", Font.BOLD, 12));
	  codLan.setCampoSegundaChave(getFilCod());
	  // codLan.setTipoValidacao("pedven_SERVICO");
	  codLan.setName("");
	  codLan.setCampoLimpaTelaAutomatico(false);
	}
	return codLan;
  }

  private UnJLabel getNjlblSequncia() {
	if (njlblSequncia == null) {
	  njlblSequncia = new UnJLabel();
	  njlblSequncia.setHorizontalAlignment(SwingConstants.RIGHT);
	  njlblSequncia.setText("Sequ\u00EAncia:");
	}
	return njlblSequncia;
  }

  private UnJLabel getLabelSequencia() {
	if (labelSequencia == null) {
	  labelSequencia = new UnJLabel();
	  labelSequencia.setMaximumSize(new Dimension(85, 19));
	  labelSequencia.setMinimumSize(new Dimension(85, 19));
	  labelSequencia.setPreferredSize(new Dimension(85, 19));
	  labelSequencia.setBorder(new LineBorder(Color.GRAY));
	  labelSequencia.setHorizontalAlignment(SwingConstants.CENTER);
	  labelSequencia.setName("CDCSEQ");
	  labelSequencia.setText("0000");
	}
	return labelSequencia;
  }
}
