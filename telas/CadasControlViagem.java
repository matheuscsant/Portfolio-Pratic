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
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.JTextComponent;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastroEmpresa;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnEdit;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePratic;
import br.com.praticsistemas.unprtlib.numeros.Numeros;
import br.com.praticsistemas.unprtlib.telas.CompTelas;
import br.com.praticsistemas.unprtcomps.telas.JButton.UnJButton;
import br.com.praticsistemas.unprtcomps.telas.UnJTextoLivre;
import java.awt.event.KeyEvent;

public class CadasControlViagem extends UnCadastroEmpresa {

  private static final long serialVersionUID = 1L;

  private JPanel panelCentral;
  private UnJTablePratic TabelaRes;
  private JPanel panelCampos;
  private UnJLabel lbFilial;
  private EditPratic filCod;
  private UnJLabel lbPlacaVeiculo;
  private UnJLabel lbCodMot;
  private editFormatado placaCod;
  private EditPratic codMot;
  private UnJLabel lbNomeMot;
  private UnEdit nomeMot;
  private UnJLabel lbPeriodoViagem;
  private editFormatado dataInic;
  private UnJLabel lbA;
  private editFormatado dataFim;
  private UnJLabel lbCidOrigem;
  private UnJLabel lbCidDestino;
  private UnJLabel lbKmSaida;
  private editFormatado kmSaida;
  private UnJLabel lbKmChegada;
  private editFormatado kmChegada;
  private UnJLabel lbKmRodado;
  private UnJLabel lbPesPorTon;
  private editFormatado pesPorTon;
  private UnJLabel lbValorTon;
  private editFormatado valorTon;
  private UnJLabel lbValorFrete;
  private UnJLabel lbObservacoes;
  private UnEdit observacoes;
  private UnJLabel lbFilCod;
  private String identificador = null;
  private UnJLabel lbDescMot;
  private UnJLabel lbCalcValorFrete;
  private UnJLabel descPlaca;
  private UnJLabel lbDescCidOrigem;
  private EditPratic cidOrigem;
  private UnJLabel lbDescCidDestino;
  private EditPratic cidFim;
  private JPanel panelItems;
  private UnJLabel lbDataItem;
  private UnJLabel lbDeptoItem;
  private editFormatado DataItem;
  private EditPratic DeptoItem;
  private UnJLabel lbGrupoItem;
  private UnJLabel lbSubGrupoItem;
  private EditPratic GrupoItem;
  private EditPratic SubGrupoItem;
  private UnJLabel lbQtdItem;
  private UnJLabel lbValorItem;
  private EditPratic QuantItem;
  private EditPratic ValorItem;
  private UnJLabel lbDescGrupoItem;
  private UnJLabel lbDescSubGrupoItem;
  private UnJLabel lbDescDepto;
  private UnJButton btnLancar;
  private UnJTextoLivre ipvObs;

  public CadasControlViagem() {
	initialize();
	limpaTela();
	montaTela("");
  }

  private void initialize() {
	this.setMinimumSize(new Dimension(900, 690));
	this.setPreferredSize(new Dimension(900, 690));
	this.setSize(new Dimension(900, 528));
	this.setTitle("Controle de Viagem");
	this.setCodigoTela("4305");
	this.setFocoAutomaticoGravaTela(false);
	this.setCampoFocoAberturaTela(getPlacaCod());
	getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasControlViagem = null; // Evento para não bloquear a tela
														 // de abrir
	  }
	});

  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 884, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 212, 83, 142, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
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
	  panelCampos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelCampos = new GridBagLayout();
	  gbl_panelCampos.columnWidths = new int[] { 106, 76, 0, 22, 115, 0, 0, 80, 0, 22, 68, 0, 0, 0, 0, 0,
		  0 };
	  gbl_panelCampos.rowHeights = new int[] { 25, 25, 25, 25, 25, 25, 25, 25, 0 };
	  gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  Double.MIN_VALUE };
	  panelCampos.setLayout(gbl_panelCampos);
	  GridBagConstraints gbc_lbFilial = new GridBagConstraints();
	  gbc_lbFilial.insets = new Insets(2, 3, 2, 3);
	  gbc_lbFilial.anchor = GridBagConstraints.WEST;
	  gbc_lbFilial.gridx = 0;
	  gbc_lbFilial.gridy = 0;
	  panelCampos.add(getLbFilial(), gbc_lbFilial);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 2, 3);
	  gbc_filCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 0;
	  panelCampos.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbFilCod = new GridBagConstraints();
	  gbc_lbFilCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbFilCod.insets = new Insets(2, 3, 2, 3);
	  gbc_lbFilCod.gridwidth = 4;
	  gbc_lbFilCod.gridx = 2;
	  gbc_lbFilCod.gridy = 0;
	  panelCampos.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_menuItem = new GridBagConstraints();
	  gbc_menuItem.gridx = 10;
	  gbc_menuItem.gridy = 0;

	  GridBagConstraints gbc_lbPlacaVeiculo = new GridBagConstraints();
	  gbc_lbPlacaVeiculo.insets = new Insets(2, 3, 2, 3);
	  gbc_lbPlacaVeiculo.anchor = GridBagConstraints.WEST;
	  gbc_lbPlacaVeiculo.gridx = 0;
	  gbc_lbPlacaVeiculo.gridy = 1;
	  panelCampos.add(getlbPlacaVeiculo(), gbc_lbPlacaVeiculo);
	  GridBagConstraints gbc_placaCod = new GridBagConstraints();
	  gbc_placaCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_placaCod.insets = new Insets(2, 3, 2, 3);
	  gbc_placaCod.gridx = 1;
	  gbc_placaCod.gridy = 1;
	  panelCampos.add(getPlacaCod(), gbc_placaCod);
	  GridBagConstraints gbc_descPlaca = new GridBagConstraints();
	  gbc_descPlaca.anchor = GridBagConstraints.WEST;
	  gbc_descPlaca.insets = new Insets(2, 3, 2, 3);
	  gbc_descPlaca.gridwidth = 4;
	  gbc_descPlaca.gridx = 2;
	  gbc_descPlaca.gridy = 1;
	  panelCampos.add(getDescPlaca(), gbc_descPlaca);
	  GridBagConstraints gbc_lbCodMot = new GridBagConstraints();
	  gbc_lbCodMot.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCodMot.anchor = GridBagConstraints.WEST;
	  gbc_lbCodMot.gridx = 6;
	  gbc_lbCodMot.gridy = 1;
	  panelCampos.add(getlbCodMot(), gbc_lbCodMot);
	  GridBagConstraints gbc_codMot = new GridBagConstraints();
	  gbc_codMot.insets = new Insets(2, 3, 2, 3);
	  gbc_codMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_codMot.gridx = 7;
	  gbc_codMot.gridy = 1;
	  panelCampos.add(getCodMot(), gbc_codMot);
	  GridBagConstraints gbc_lbDescMot = new GridBagConstraints();
	  gbc_lbDescMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbDescMot.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescMot.gridwidth = 8;
	  gbc_lbDescMot.gridx = 8;
	  gbc_lbDescMot.gridy = 1;
	  panelCampos.add(getLbDescMot(), gbc_lbDescMot);
	  GridBagConstraints gbc_lbNomeMot = new GridBagConstraints();
	  gbc_lbNomeMot.insets = new Insets(2, 3, 2, 3);
	  gbc_lbNomeMot.anchor = GridBagConstraints.WEST;
	  gbc_lbNomeMot.gridx = 0;
	  gbc_lbNomeMot.gridy = 2;
	  panelCampos.add(getlbNomeMot(), gbc_lbNomeMot);
	  GridBagConstraints gbc_nomeMot = new GridBagConstraints();
	  gbc_nomeMot.gridwidth = 12;
	  gbc_nomeMot.insets = new Insets(2, 3, 2, 3);
	  gbc_nomeMot.fill = GridBagConstraints.HORIZONTAL;
	  gbc_nomeMot.gridx = 1;
	  gbc_nomeMot.gridy = 2;
	  panelCampos.add(getNomeMot(), gbc_nomeMot);
	  GridBagConstraints gbc_lbPeriodoViagem = new GridBagConstraints();
	  gbc_lbPeriodoViagem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbPeriodoViagem.anchor = GridBagConstraints.WEST;
	  gbc_lbPeriodoViagem.gridx = 0;
	  gbc_lbPeriodoViagem.gridy = 3;
	  panelCampos.add(getlbPeriodoViagem(), gbc_lbPeriodoViagem);
	  GridBagConstraints gbc_dataInic = new GridBagConstraints();
	  gbc_dataInic.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataInic.insets = new Insets(2, 3, 2, 3);
	  gbc_dataInic.gridx = 1;
	  gbc_dataInic.gridy = 3;
	  panelCampos.add(getDataInic(), gbc_dataInic);
	  GridBagConstraints gbc_lbA = new GridBagConstraints();
	  gbc_lbA.insets = new Insets(2, 3, 2, 3);
	  gbc_lbA.gridx = 2;
	  gbc_lbA.gridy = 3;
	  panelCampos.add(getlbA(), gbc_lbA);
	  GridBagConstraints gbc_dataFim = new GridBagConstraints();
	  gbc_dataFim.insets = new Insets(2, 3, 2, 3);
	  gbc_dataFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_dataFim.gridx = 3;
	  gbc_dataFim.gridy = 3;
	  panelCampos.add(getDataFim(), gbc_dataFim);
	  GridBagConstraints gbc_lbCidOrigem = new GridBagConstraints();
	  gbc_lbCidOrigem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCidOrigem.anchor = GridBagConstraints.WEST;
	  gbc_lbCidOrigem.gridx = 0;
	  gbc_lbCidOrigem.gridy = 4;
	  panelCampos.add(getLbCidOrigem(), gbc_lbCidOrigem);
	  GridBagConstraints gbc_cidOrigem = new GridBagConstraints();
	  gbc_cidOrigem.insets = new Insets(2, 3, 2, 3);
	  gbc_cidOrigem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cidOrigem.gridx = 1;
	  gbc_cidOrigem.gridy = 4;
	  panelCampos.add(getCidOrigem(), gbc_cidOrigem);
	  GridBagConstraints gbc_lbDescCidOrigem = new GridBagConstraints();
	  gbc_lbDescCidOrigem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescCidOrigem.fill = GridBagConstraints.BOTH;
	  gbc_lbDescCidOrigem.gridwidth = 4;
	  gbc_lbDescCidOrigem.gridx = 2;
	  gbc_lbDescCidOrigem.gridy = 4;
	  panelCampos.add(getLbDescCidOrigem(), gbc_lbDescCidOrigem);
	  GridBagConstraints gbc_lbCidDestino = new GridBagConstraints();
	  gbc_lbCidDestino.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCidDestino.anchor = GridBagConstraints.EAST;
	  gbc_lbCidDestino.gridx = 6;
	  gbc_lbCidDestino.gridy = 4;
	  panelCampos.add(getLbCidDestino(), gbc_lbCidDestino);
	  GridBagConstraints gbc_cidFim = new GridBagConstraints();
	  gbc_cidFim.insets = new Insets(2, 3, 2, 3);
	  gbc_cidFim.fill = GridBagConstraints.HORIZONTAL;
	  gbc_cidFim.gridx = 7;
	  gbc_cidFim.gridy = 4;
	  panelCampos.add(getCidDestino(), gbc_cidFim);
	  GridBagConstraints gbc_lbDescCidDestino = new GridBagConstraints();
	  gbc_lbDescCidDestino.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbDescCidDestino.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescCidDestino.gridwidth = 5;
	  gbc_lbDescCidDestino.gridx = 8;
	  gbc_lbDescCidDestino.gridy = 4;
	  panelCampos.add(getLbDescCidDestino(), gbc_lbDescCidDestino);
	  GridBagConstraints gbc_lbKmSaida = new GridBagConstraints();
	  gbc_lbKmSaida.insets = new Insets(2, 3, 2, 3);
	  gbc_lbKmSaida.anchor = GridBagConstraints.WEST;
	  gbc_lbKmSaida.gridx = 0;
	  gbc_lbKmSaida.gridy = 5;
	  panelCampos.add(getLbKmSaida(), gbc_lbKmSaida);
	  GridBagConstraints gbc_kmSaida = new GridBagConstraints();
	  gbc_kmSaida.insets = new Insets(2, 3, 2, 3);
	  gbc_kmSaida.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmSaida.gridx = 1;
	  gbc_kmSaida.gridy = 5;
	  panelCampos.add(getKmSaida(), gbc_kmSaida);
	  GridBagConstraints gbc_lbKmChegada = new GridBagConstraints();
	  gbc_lbKmChegada.insets = new Insets(2, 3, 2, 3);
	  gbc_lbKmChegada.anchor = GridBagConstraints.EAST;
	  gbc_lbKmChegada.gridx = 4;
	  gbc_lbKmChegada.gridy = 5;
	  panelCampos.add(getLbKmChegada(), gbc_lbKmChegada);
	  GridBagConstraints gbc_kmChegada = new GridBagConstraints();
	  gbc_kmChegada.gridwidth = 2;
	  gbc_kmChegada.insets = new Insets(2, 3, 2, 3);
	  gbc_kmChegada.fill = GridBagConstraints.HORIZONTAL;
	  gbc_kmChegada.gridx = 5;
	  gbc_kmChegada.gridy = 5;
	  panelCampos.add(getKmChegada(), gbc_kmChegada);
	  GridBagConstraints gbc_lbKmRodado = new GridBagConstraints();
	  gbc_lbKmRodado.fill = GridBagConstraints.BOTH;
	  gbc_lbKmRodado.gridwidth = 2;
	  gbc_lbKmRodado.insets = new Insets(2, 3, 2, 3);
	  gbc_lbKmRodado.gridx = 7;
	  gbc_lbKmRodado.gridy = 5;
	  panelCampos.add(getLbKmRodado(), gbc_lbKmRodado);
	  GridBagConstraints gbc_lbPesPorTon = new GridBagConstraints();
	  gbc_lbPesPorTon.insets = new Insets(2, 3, 2, 3);
	  gbc_lbPesPorTon.anchor = GridBagConstraints.WEST;
	  gbc_lbPesPorTon.gridx = 0;
	  gbc_lbPesPorTon.gridy = 6;
	  panelCampos.add(getlbPesPorTon(), gbc_lbPesPorTon);
	  GridBagConstraints gbc_pesPorTon = new GridBagConstraints();
	  gbc_pesPorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_pesPorTon.insets = new Insets(2, 3, 2, 3);
	  gbc_pesPorTon.gridx = 1;
	  gbc_pesPorTon.gridy = 6;
	  panelCampos.add(getPesPorTon(), gbc_pesPorTon);
	  GridBagConstraints gbc_lbValorTon = new GridBagConstraints();
	  gbc_lbValorTon.insets = new Insets(2, 3, 2, 3);
	  gbc_lbValorTon.anchor = GridBagConstraints.EAST;
	  gbc_lbValorTon.gridx = 4;
	  gbc_lbValorTon.gridy = 6;
	  panelCampos.add(getLbValorTon(), gbc_lbValorTon);
	  GridBagConstraints gbc_valorTon = new GridBagConstraints();
	  gbc_valorTon.insets = new Insets(2, 3, 2, 3);
	  gbc_valorTon.gridwidth = 2;
	  gbc_valorTon.fill = GridBagConstraints.HORIZONTAL;
	  gbc_valorTon.gridx = 5;
	  gbc_valorTon.gridy = 6;
	  panelCampos.add(getValorTon(), gbc_valorTon);
	  GridBagConstraints gbc_lbValorFrete = new GridBagConstraints();
	  gbc_lbValorFrete.anchor = GridBagConstraints.WEST;
	  gbc_lbValorFrete.insets = new Insets(2, 3, 2, 3);
	  gbc_lbValorFrete.gridwidth = 2;
	  gbc_lbValorFrete.gridx = 7;
	  gbc_lbValorFrete.gridy = 6;
	  panelCampos.add(getLbValorFrete(), gbc_lbValorFrete);
	  GridBagConstraints gbc_lbCalcValorFrete = new GridBagConstraints();
	  gbc_lbCalcValorFrete.insets = new Insets(2, 3, 2, 3);
	  gbc_lbCalcValorFrete.fill = GridBagConstraints.BOTH;
	  gbc_lbCalcValorFrete.gridwidth = 3;
	  gbc_lbCalcValorFrete.gridx = 9;
	  gbc_lbCalcValorFrete.gridy = 6;
	  panelCampos.add(getLbCalcValorFrete(), gbc_lbCalcValorFrete);
	  GridBagConstraints gbc_lbObservacoes = new GridBagConstraints();
	  gbc_lbObservacoes.insets = new Insets(2, 3, 2, 3);
	  gbc_lbObservacoes.anchor = GridBagConstraints.WEST;
	  gbc_lbObservacoes.gridx = 0;
	  gbc_lbObservacoes.gridy = 7;
	  panelCampos.add(getLbObservacoes(), gbc_lbObservacoes);
	  GridBagConstraints gbc_observacoes = new GridBagConstraints();
	  gbc_observacoes.gridwidth = 12;
	  gbc_observacoes.insets = new Insets(2, 3, 2, 3);
	  gbc_observacoes.fill = GridBagConstraints.BOTH;
	  gbc_observacoes.gridx = 1;
	  gbc_observacoes.gridy = 7;
	  panelCampos.add(getObservacoes(), gbc_observacoes);
	}
	return panelCampos;
  }

  public boolean montaTela(String codigo) {

	limpaTela();

	return getTabelaRes().montaTela("");

  }

  private void montarValorKm() {
	double total = getKmChegada().getValorDecimal() - getKmSaida().getValorDecimal();
	getLbKmRodado().setText(Numeros.formatarDecimalVariavel(total, 2) + " Km rodados");
	getLbKmRodado().setAuxiliarDeTrabalho(String.valueOf(total));

  }

  private void montarValorFrete() {
	double totalFrete = getValorTon().getValorDecimal() * getPesPorTon().getValorDecimal();
	getLbCalcValorFrete().setText("R$ " + Numeros.formatarDecimalVariavel(totalFrete, 2));
	getLbCalcValorFrete().setAuxiliarDeTrabalho(String.valueOf(totalFrete));

  }

  public boolean montaTelaItens() {

	getTabelaRes().limpaTebela();

	return true;
  }

  public void limparItens() {

	CompTelas.limparCampos(getPanelItems(), false);
	getIpvObs().limpar();
  }

  public boolean gravaTelaItens(String acao) {

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_MOVIMENTACAO_VEICULO_CA", 11, 2));
	  int param = 1;
	  int seq = 0;
	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, Types.INTEGER);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setLong(param++, getIdentificador());
	  getProc().setInt(param++, seq);
	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setInt(param++, getFilCod(), stp);
	  getProc().setDate(param++, getDataItem(), stp);
	  getProc().setInt(param++, getDeptoItem(), stp);
	  getProc().setInt(param++, getGrupoItem(), stp);
	  getProc().setInt(param++, getSubGrupoItem(), stp);
	  getProc().setDouble(param++, getQuantItem(), stp);
	  getProc().setDouble(param++, getValorItem(), stp);
	  getProc().setString(param++, acao);
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

	if (!acao.equals("EA")) {
	  limparItens();
	}

	montaTelaItens();
	getDataItem().requestFocus();

	return true;
  }

  public boolean validaTelaItens() {

	JTextComponent campo = null;
	String erro = "";

	if (DataItem.isVazio()) {
	  erro = "A DATA deve ser preenchida !";
	  campo = DataItem;
	}
	else if (DeptoItem.isVazio()) {
	  erro = "O DEPARTAMENTO deve ser preenchido !";
	  campo = DeptoItem;
	}
	else if (GrupoItem.isVazio()) {
	  erro = "O GRUPO deve ser preenchido !";
	  campo = GrupoItem;
	}
	else if (SubGrupoItem.isVazio()) {
	  erro = "O SUB-GRUPO deve ser preenchido !";
	  campo = SubGrupoItem;
	}
	else if (QuantItem.isVazio()) {
	  erro = "A QUANTIDADE deve ser preenchida !";
	  campo = QuantItem;
	}
	else if (ValorItem.isVazio()) {
	  erro = "O VALOR deve ser preenchido !";
	  campo = ValorItem;
	}

	if (!erro.equalsIgnoreCase("")) {
	  mostraMensagem(erro);
	  campo.requestFocus();

	  return false;
	}

	return true;

  }

  public boolean gravaTela() {

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_MOVIMENTACAO_VEICULO_2", 19, 2));

	  String tipoMov = "C"; // dlkfdslkfsdlfsdl
	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setLong(param++, getIdentificador());
	  getProc().setString(param++, getPlacaCod(), stp);

	  getProc().setInt(param++, getCodMot(), stp);

	  if (getCodMot().isVazio()) {
		getProc().setString(param++, getNomeMot(), stp);
	  }
	  else {
		getProc().setString(param++, getlbNomeMot(), stp);
	  }

	  getProc().setDate(param++, getDataInic(), stp);
	  getProc().setDouble(param++, getPesPorTon(), stp);
	  getProc().setDouble(param++, getKmSaida(), stp);
	  getProc().setDouble(param++, getKmChegada(), stp);
	  getProc().setString(param++, getObservacoes(), stp);
	  getProc().setTimestamp(param++, new Timestamp(new Date().getTime()));
	  getProc().setInt(param++, DeskPratic.getUsuarioSistema().getUsuCod()); // Confirmar com

	  getProc().setDouble(param++, getValorTon(), stp);
	  getProc().setString(param++, getCidOrigem(), stp);
	  getProc().setString(param++, getCidDestino(), stp);
	  getProc().setDate(param++, getDataFim(), stp);
	  getProc().setString(param++, tipoMov, stp);
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
	  getPlacaCod().requestFocus();
	}

	return true;
  }

  public String getIdentificador() {
	return identificador;
  }

  public boolean limpaTela() {
	getLbKmRodado().setText(" 0 KM rodados");
	getLbKmRodado().setAuxiliarDeTrabalho("0");
	return super.limpaTela();
  }

  public boolean buscarNome() {

	if (getCodMot().isVazio()) {
	  getNomeMot().setEnabled(true);
	  return false;
	}

	try {
	  res = getSelecao().executeQuery(
		  "select funnom from es_funcionarios where funcod = " + getCodMot().getText() + "");
	  if (res.next()) {
		getNomeMot().setText(res.getString("funnom"));
		getNomeMot().limpar();
		getNomeMot().setEnabled(false);
		getDataInic().requestFocus();
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

  private UnJTablePratic getTabelaRes() {
	if (TabelaRes == null) {
	  TabelaRes = new UnJTablePratic();
	  TabelaRes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  TabelaRes.setCampoTitulosTabela("Data, Depto., Grupo, Subgrupo, Quantidade, Valor");
	  TabelaRes.setCampoDadosTabelaView("ES_VIEW_MOVIMENTACAO_VEICULO_CA");
	  TabelaRes.setCampoDadosTabela("CDCDAT, DEPCODDES, GRUCODDES, SUBCODDES, CDCQTD, CDCVAL");
	  TabelaRes.setCampoTitulosTabelaTamanhos("110, 150, 400, 400, 110, 110");
	  TabelaRes.getTabela().setBackground(Color.white);
	  TabelaRes.setConexao(DeskPratic.getConexao());
	  TabelaRes.setCampoFocoAlterarItens(getPlacaCod());
	  TabelaRes.setFocusable(false);
	  TabelaRes.setPanelCampos(getPanelCentral());
	  TabelaRes.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	  TabelaRes.addUnJTablePraticListener(
		  new br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticListener() {
			public void acaoExcluirItemTabela(
				br.com.praticsistemas.unprtcomps.telas.jtable.UnJTablePraticEvent e) {
			  gravaTelaItens("E");
			}
		  });
	}
	return TabelaRes;
  }

  private UnJLabel getLbFilial() {
	if (lbFilial == null) {
	  lbFilial = new UnJLabel();
	  lbFilial.setForeground(Color.BLUE);
	  lbFilial.setText("Filial: ");
	}
	return lbFilial;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setName("filcod");
	  filCod.setName2("Código da Filial Inicial");
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setTipoValidacao("filiais");
	  filCod.setCampoEmpresa(getEmpCod());
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("lbFilCod");
	  lbFilCod.setPreferredSize(new Dimension(100, 14));
	  lbFilCod.setMinimumSize(new Dimension(100, 14));
	  lbFilCod.setMaximumSize(new Dimension(100, 14));
	  lbFilCod.setFont(new Font("Arial", Font.BOLD, 11));
	  filCod.setLabelDescricao(lbFilCod);
	  filCod.setCampoLimpaTelaAutomatico(false);
	}
	return filCod;
  }

  private UnJLabel getLbFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("lbFilCod");
	  lbFilCod.limpar();

	}
	return lbFilCod;
  }

  private UnJLabel getlbPlacaVeiculo() {
	if (lbPlacaVeiculo == null) {
	  lbPlacaVeiculo = new UnJLabel();
	  lbPlacaVeiculo.setForeground(Color.BLUE);
	  lbPlacaVeiculo.setText("Placa\u00A0do\u00A0Ve\u00EDculo: ");
	}
	return lbPlacaVeiculo;
  }

  private UnJLabel getlbCodMot() {
	if (lbCodMot == null) {
	  lbCodMot = new UnJLabel();
	  lbCodMot.setForeground(Color.BLUE);
	  lbCodMot.setText("C\u00F3d.\u00A0Motorista:");
	}
	return lbCodMot;
  }

  private editFormatado getPlacaCod() {
	if (placaCod == null) {
	  placaCod = new editFormatado();
	  placaCod.setName("veipla");
	  placaCod.setName2("Placa V\u00E9iculo do Ve\u00EDculo");
	  placaCod.setTipoValidacao("veiculo");
	  placaCod.setAuxiliarDeTrabalho("placa");
	  placaCod.setTipoFormatacao(16);
	  placaCod.setSoNumeros(false);
	  placaCod.setInputVerifier(DeskPratic.fctGeral.VALIDA_CAMPO);
	  descPlaca = new UnJLabel();
	  descPlaca.setText("lbDescPlaca");
	  descPlaca.setMinimumSize(new Dimension(80, 19));
	  descPlaca.setPreferredSize(new Dimension(80, 19));
	  descPlaca.setFont(new Font("Arial", Font.BOLD, 11));
	  placaCod.setLabelDescricao(descPlaca);
	  placaCod.addUnEditListener(new br.com.praticsistemas.unprtcomps.editFormatadoListener() {
		public void mostraPesquisa(br.com.praticsistemas.unprtcomps.editFormatadoEvent e) {
		  pesquisar(placaCod);
		}
	  });
	}
	return placaCod;

  }

  private EditPratic getCodMot() {
	if (codMot == null) {
	  codMot = new EditPratic();
	  codMot.setName("funcod");
	  codMot.setTipoValidacao("es_funcionarios");
	  codMot.setCampoObrigatorio(false);
	  codMot.setAuxiliarDeTrabalho("funcod");
	  lbDescMot = new UnJLabel();
	  lbDescMot.setText("lbFunCod");
	  lbDescMot.setMinimumSize(new Dimension(80, 19));
	  lbDescMot.setPreferredSize(new Dimension(80, 19));
	  lbDescMot.setFont(new Font("Arial", Font.BOLD, 11));
	  codMot.setLabelDescricao(lbDescMot);
	  codMot.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
		  if (buscarNome() == false) {
			if (e.getOppositeComponent() != null && e.getOppositeComponent().equals(getDataInic())) {
			  getNomeMot().requestFocus();
			}
		  }
		}
	  });
	}
	return codMot;
  }

  private UnJLabel getlbNomeMot() {
	if (lbNomeMot == null) {
	  lbNomeMot = new UnJLabel();
	  lbNomeMot.setText("Nome\u00A0do\u00A0motorista:");
	}
	return lbNomeMot;
  }

  private UnEdit getNomeMot() {
	if (nomeMot == null) {
	  nomeMot = new UnEdit();
	  nomeMot.setName("funnom");
	  nomeMot.setCampoObrigatorio(false);
	  nomeMot.setName2("Nome funcionário");
	  nomeMot.setMaxLength(73);
	}
	return nomeMot;
  }

  private UnJLabel getlbPeriodoViagem() {
	if (lbPeriodoViagem == null) {
	  lbPeriodoViagem = new UnJLabel();
	  lbPeriodoViagem.setText("Per\u00EDodo\u00A0da\u00A0viagem:");
	}
	return lbPeriodoViagem;
  }

  private editFormatado getDataInic() {
	if (dataInic == null) {
	  dataInic = new editFormatado();
	  dataInic.setCampoObrigatorio(true);
	  dataInic.setTipoFormatacao(4);
	  dataInic.setName("MVEDAT");
	}
	return dataInic;
  }

  private UnJLabel getlbA() {
	if (lbA == null) {
	  lbA = new UnJLabel();
	  lbA.setText("a");
	}
	return lbA;
  }

  private editFormatado getDataFim() {
	if (dataFim == null) {
	  dataFim = new editFormatado();
	  dataFim.setCampoObrigatorio(true);
	  dataFim.setTipoFormatacao(4);
	  dataFim.setName("MVEDTF");
	}
	return dataFim;
  }

  private UnJLabel getLbCidOrigem() {
	if (lbCidOrigem == null) {
	  lbCidOrigem = new UnJLabel();
	  lbCidOrigem.setForeground(Color.BLUE);
	  lbCidOrigem.setText("Cidade\u00A0Origem:");
	}
	return lbCidOrigem;
  }

  private UnJLabel getLbCidDestino() {
	if (lbCidDestino == null) {
	  lbCidDestino = new UnJLabel();
	  lbCidDestino.setForeground(Color.BLUE);
	  lbCidDestino.setText("Cidade Destino:");
	}
	return lbCidDestino;
  }

  private UnJLabel getLbKmSaida() {
	if (lbKmSaida == null) {
	  lbKmSaida = new UnJLabel();
	  lbKmSaida.setText("Km\u00A0Sa\u00EDda:");
	}
	return lbKmSaida;
  }

  private editFormatado getKmSaida() {
	if (kmSaida == null) {
	  kmSaida = new editFormatado();
	  kmSaida.setQuantidadeCasasDecimais(2);
	  kmSaida.setTipoFormatacao(7);
	  kmSaida.setName2("Km Saida");
	  kmSaida.setCampoObrigatorio(false);
	  kmSaida.setName("KMINIC");
	}
	return kmSaida;
  }

  private UnJLabel getLbKmChegada() {
	if (lbKmChegada == null) {
	  lbKmChegada = new UnJLabel();
	  lbKmChegada.setText("Km\u00A0Chegada:");
	}
	return lbKmChegada;
  }

  private editFormatado getKmChegada() {
	if (kmChegada == null) {
	  kmChegada = new editFormatado();
	  kmChegada.setCampoObrigatorio(false);
	  kmChegada.setQuantidadeCasasDecimais(2);
	  kmChegada.setTipoFormatacao(7);
	  kmChegada.setName2("Km Inicial");
	  kmChegada.setName("KMFINA");
	  kmChegada.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montarValorKm();
		}
	  });
	}
	return kmChegada;
  }

  private UnJLabel getLbKmRodado() {
	if (lbKmRodado == null) {
	  lbKmRodado = new UnJLabel();
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

  private UnJLabel getlbPesPorTon() {
	if (lbPesPorTon == null) {
	  lbPesPorTon = new UnJLabel();
	  lbPesPorTon.setText("Peso por Tonelada:");
	}
	return lbPesPorTon;
  }

  private editFormatado getPesPorTon() {
	if (pesPorTon == null) {
	  pesPorTon = new editFormatado();
	  pesPorTon.setQuantidadeCasasDecimais(2);
	  pesPorTon.setTipoFormatacao(7);
	  pesPorTon.setCampoObrigatorio(true);
	  pesPorTon.setName("MVEPES");
	}
	return pesPorTon;
  }

  private UnJLabel getLbValorTon() {
	if (lbValorTon == null) {
	  lbValorTon = new UnJLabel();
	  lbValorTon.setText("Valor por Tonelada:");
	}
	return lbValorTon;
  }

  private editFormatado getValorTon() {
	if (valorTon == null) {
	  valorTon = new editFormatado();
	  valorTon.setCampoObrigatorio(true);
	  valorTon.setName("MVEVAL");
	  valorTon.setQuantidadeCasasDecimais(2);
	  valorTon.setTipoFormatacao(7);
	  valorTon.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
		  montarValorFrete();
		}
	  });
	}
	return valorTon;
  }

  private UnJLabel getLbValorFrete() {
	if (lbValorFrete == null) {
	  lbValorFrete = new UnJLabel();

	  lbValorFrete.setText("Valor\u00A0total\u00A0do\u00A0Frete:");
	}
	return lbValorFrete;
  }

  private UnJLabel getLbObservacoes() {
	if (lbObservacoes == null) {
	  lbObservacoes = new UnJLabel();
	  lbObservacoes.setText("Observa\u00E7\u00F5es:");
	}
	return lbObservacoes;
  }

  private UnEdit getObservacoes() {
	if (observacoes == null) {
	  observacoes = new UnEdit();
	  observacoes.setCampoObrigatorio(false);
	  observacoes.setName("MVEOBS");
	}
	return observacoes;
  }

  private UnJLabel getLbDescMot() {
	if (lbDescMot == null) {
	  lbDescMot = new UnJLabel();
	  lbDescMot.setText("lbDescMot");
	  lbDescMot.setFont(new Font("Arial", Font.BOLD, 11));
	}
	return lbDescMot;
  }

  private UnJLabel getLbCalcValorFrete() {
	if (lbCalcValorFrete == null) {
	  lbCalcValorFrete = new UnJLabel();
	  lbCalcValorFrete.setText(" R$ 0,00 ");
	  lbCalcValorFrete.setOpaque(true);
	  lbCalcValorFrete.setHorizontalAlignment(SwingConstants.CENTER);
	  lbCalcValorFrete.setBackground(Color.LIGHT_GRAY);
	  lbCalcValorFrete.setFont(new Font("Arial", Font.BOLD, 11));

	}
	return lbCalcValorFrete;
  }

  private UnJLabel getDescPlaca() {
	if (descPlaca == null) {
	  descPlaca = new UnJLabel();
	}
	return descPlaca;
  }

  private UnJLabel getLbDescCidOrigem() {
	if (lbDescCidOrigem == null) {
	  lbDescCidOrigem = new UnJLabel();
	  lbDescCidOrigem.setMaximumSize(new Dimension(33333, 19));
	  lbDescCidOrigem.setMinimumSize(new Dimension(100, 19));
	  lbDescCidOrigem.setPreferredSize(new Dimension(100, 19));
	  lbDescCidOrigem.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescCidOrigem.setText("lbDescCidOrigem");

	}
	return lbDescCidOrigem;
  }

  private EditPratic getCidOrigem() {
	if (cidOrigem == null) {
	  cidOrigem = new EditPratic();
	  cidOrigem.setLabelDescricao(getLbDescCidOrigem());
	  cidOrigem.setCampoObrigatorio(false);
	  cidOrigem.setTipoValidacao("MUNICIPIOS");
	  cidOrigem.setName("ORIPRE");

	}
	return cidOrigem;
  }

  private UnJLabel getLbDescCidDestino() {
	if (lbDescCidDestino == null) {
	  lbDescCidDestino = new UnJLabel();
	  lbDescCidDestino.setPreferredSize(new Dimension(90, 19));
	  lbDescCidDestino.setMaximumSize(new Dimension(333333, 19));
	  lbDescCidDestino.setMinimumSize(new Dimension(90, 19));
	  lbDescCidDestino.setFont(new Font("Arial", Font.BOLD, 11));
	  lbDescCidDestino.setText("lbDescCidDestino");

	}
	return lbDescCidDestino;
  }

  private EditPratic getCidDestino() {
	if (cidFim == null) {
	  cidFim = new EditPratic();
	  cidFim.setLabelDescricao(getLbDescCidDestino());
	  cidFim.setTipoValidacao("MUNICIPIOS");
	  cidFim.setName("despre");
	  cidFim.setCampoObrigatorio(false);
	}
	return cidFim;
  }

  private JPanel getPanelItems() {
	if (panelItems == null) {
	  panelItems = new JPanel();
	  panelItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelItems = new GridBagLayout();
	  gbl_panelItems.columnWidths = new int[] { 57, 0, 72, 117, 80, 76, 23, 44, 0, 0, 0, 96, 87, 40, 0 };
	  gbl_panelItems.rowHeights = new int[] { 25, 25, 0 };
	  gbl_panelItems.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelItems.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
	  panelItems.setLayout(gbl_panelItems);
	  GridBagConstraints gbc_lbDataItem = new GridBagConstraints();
	  gbc_lbDataItem.anchor = GridBagConstraints.WEST;
	  gbc_lbDataItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDataItem.gridx = 0;
	  gbc_lbDataItem.gridy = 0;
	  panelItems.add(getLbDataItem(), gbc_lbDataItem);
	  GridBagConstraints gbc_DataItem = new GridBagConstraints();
	  gbc_DataItem.insets = new Insets(2, 3, 2, 3);
	  gbc_DataItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_DataItem.gridx = 1;
	  gbc_DataItem.gridy = 0;
	  panelItems.add(getDataItem(), gbc_DataItem);
	  GridBagConstraints gbc_lbGrupoItem = new GridBagConstraints();
	  gbc_lbGrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbGrupoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbGrupoItem.gridx = 4;
	  gbc_lbGrupoItem.gridy = 0;
	  panelItems.add(getLbGrupoItem(), gbc_lbGrupoItem);
	  GridBagConstraints gbc_GrupoItem = new GridBagConstraints();
	  gbc_GrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_GrupoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_GrupoItem.gridx = 5;
	  gbc_GrupoItem.gridy = 0;
	  panelItems.add(getGrupoItem(), gbc_GrupoItem);
	  GridBagConstraints gbc_lbDescGrupoItem = new GridBagConstraints();
	  gbc_lbDescGrupoItem.gridwidth = 5;
	  gbc_lbDescGrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescGrupoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbDescGrupoItem.gridx = 6;
	  gbc_lbDescGrupoItem.gridy = 0;
	  panelItems.add(getLbDescGrupoItem(), gbc_lbDescGrupoItem);
	  GridBagConstraints gbc_lbQtdItem = new GridBagConstraints();
	  gbc_lbQtdItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbQtdItem.anchor = GridBagConstraints.WEST;
	  gbc_lbQtdItem.gridx = 11;
	  gbc_lbQtdItem.gridy = 0;
	  panelItems.add(getLbQtdItem(), gbc_lbQtdItem);
	  GridBagConstraints gbc_QuantItem = new GridBagConstraints();
	  gbc_QuantItem.insets = new Insets(2, 3, 2, 3);
	  gbc_QuantItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_QuantItem.gridx = 12;
	  gbc_QuantItem.gridy = 0;
	  panelItems.add(getQuantItem(), gbc_QuantItem);
	  GridBagConstraints gbc_ipvObs = new GridBagConstraints();
	  gbc_ipvObs.insets = new Insets(2, 3, 2, 3);
	  gbc_ipvObs.gridx = 13;
	  gbc_ipvObs.gridy = 0;
	  panelItems.add(getIpvObs(), gbc_ipvObs);
	  GridBagConstraints gbc_lbDeptoItem = new GridBagConstraints();
	  gbc_lbDeptoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDeptoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbDeptoItem.gridx = 0;
	  gbc_lbDeptoItem.gridy = 1;
	  panelItems.add(getLbDeptoItem(), gbc_lbDeptoItem);
	  GridBagConstraints gbc_DeptoItem = new GridBagConstraints();
	  gbc_DeptoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_DeptoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_DeptoItem.gridx = 1;
	  gbc_DeptoItem.gridy = 1;
	  panelItems.add(getDeptoItem(), gbc_DeptoItem);
	  GridBagConstraints gbc_lbDescDepto = new GridBagConstraints();
	  gbc_lbDescDepto.gridwidth = 2;
	  gbc_lbDescDepto.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescDepto.anchor = GridBagConstraints.WEST;
	  gbc_lbDescDepto.gridx = 2;
	  gbc_lbDescDepto.gridy = 1;
	  panelItems.add(getLbDescDepto(), gbc_lbDescDepto);
	  GridBagConstraints gbc_lbSubGrupoItem = new GridBagConstraints();
	  gbc_lbSubGrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbSubGrupoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbSubGrupoItem.gridx = 4;
	  gbc_lbSubGrupoItem.gridy = 1;
	  panelItems.add(getLbSubGrupoItem(), gbc_lbSubGrupoItem);
	  GridBagConstraints gbc_SubGrupoItem = new GridBagConstraints();
	  gbc_SubGrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_SubGrupoItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_SubGrupoItem.gridx = 5;
	  gbc_SubGrupoItem.gridy = 1;
	  panelItems.add(getSubGrupoItem(), gbc_SubGrupoItem);
	  GridBagConstraints gbc_lbDescSubGrupoItem = new GridBagConstraints();
	  gbc_lbDescSubGrupoItem.gridwidth = 5;
	  gbc_lbDescSubGrupoItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbDescSubGrupoItem.anchor = GridBagConstraints.WEST;
	  gbc_lbDescSubGrupoItem.gridx = 6;
	  gbc_lbDescSubGrupoItem.gridy = 1;
	  panelItems.add(getLbDescSubGrupoItem(), gbc_lbDescSubGrupoItem);
	  GridBagConstraints gbc_lbValorItem = new GridBagConstraints();
	  gbc_lbValorItem.insets = new Insets(2, 3, 2, 3);
	  gbc_lbValorItem.anchor = GridBagConstraints.WEST;
	  gbc_lbValorItem.gridx = 11;
	  gbc_lbValorItem.gridy = 1;
	  panelItems.add(getLbValorItem(), gbc_lbValorItem);
	  GridBagConstraints gbc_ValorItem = new GridBagConstraints();
	  gbc_ValorItem.insets = new Insets(2, 3, 2, 3);
	  gbc_ValorItem.fill = GridBagConstraints.HORIZONTAL;
	  gbc_ValorItem.gridx = 12;
	  gbc_ValorItem.gridy = 1;
	  panelItems.add(getValorItem(), gbc_ValorItem);
	  GridBagConstraints gbc_btnLancar = new GridBagConstraints();
	  gbc_btnLancar.insets = new Insets(2, 3, 2, 3);
	  gbc_btnLancar.fill = GridBagConstraints.BOTH;
	  gbc_btnLancar.gridx = 13;
	  gbc_btnLancar.gridy = 1;
	  panelItems.add(getBtnLancar(), gbc_btnLancar);
	}
	return panelItems;
  }

  private UnJLabel getLbDataItem() {
	if (lbDataItem == null) {
	  lbDataItem = new UnJLabel();
	  lbDataItem.setText("Data:");
	}
	return lbDataItem;
  }

  private UnJLabel getLbDeptoItem() {
	if (lbDeptoItem == null) {
	  lbDeptoItem = new UnJLabel();
	  lbDeptoItem.setText("Depto:");
	}
	return lbDeptoItem;
  }

  private editFormatado getDataItem() {
	if (DataItem == null) {
	  DataItem = new editFormatado();
	  DataItem.setTipoFormatacao(4);
	  DataItem.setName("CDCDAT");
	  DataItem.setCampoObrigatorio(false);
	}
	return DataItem;
  }

  private EditPratic getDeptoItem() {
	if (DeptoItem == null) {
	  DeptoItem = new EditPratic();
	  DeptoItem.setName("DEPCOD");
	  DeptoItem.setCampoObrigatorio(false);
	}
	return DeptoItem;
  }

  private UnJLabel getLbGrupoItem() {
	if (lbGrupoItem == null) {
	  lbGrupoItem = new UnJLabel();
	  lbGrupoItem.setText("Grupo:");
	}
	return lbGrupoItem;
  }

  private UnJLabel getLbSubGrupoItem() {
	if (lbSubGrupoItem == null) {
	  lbSubGrupoItem = new UnJLabel();
	  lbSubGrupoItem.setText("Sub-Grupo:");
	}
	return lbSubGrupoItem;
  }

  private EditPratic getGrupoItem() {
	if (GrupoItem == null) {
	  GrupoItem = new EditPratic();
	  GrupoItem.setName("GRUCOD");
	  GrupoItem.setCampoObrigatorio(false);
	}
	return GrupoItem;
  }

  private EditPratic getSubGrupoItem() {
	if (SubGrupoItem == null) {
	  SubGrupoItem = new EditPratic();
	  SubGrupoItem.setName("SUBCOD");
	  SubGrupoItem.setCampoObrigatorio(false);
	}
	return SubGrupoItem;
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

  private EditPratic getQuantItem() {
	if (QuantItem == null) {
	  QuantItem = new EditPratic();
	  QuantItem.setName("CDCQTD");
	  QuantItem.setCampoObrigatorio(false);
	}
	return QuantItem;
  }

  private EditPratic getValorItem() {
	if (ValorItem == null) {
	  ValorItem = new EditPratic();
	  QuantItem.setName("CDCVAL");
	  ValorItem.setCampoObrigatorio(false);
	}
	return ValorItem;
  }

  private UnJLabel getLbDescGrupoItem() {
	if (lbDescGrupoItem == null) {
	  lbDescGrupoItem = new UnJLabel();
	  lbDescGrupoItem.setText("lbDescGrupo");
	}
	return lbDescGrupoItem;
  }

  private UnJLabel getLbDescSubGrupoItem() {
	if (lbDescSubGrupoItem == null) {
	  lbDescSubGrupoItem = new UnJLabel();
	  lbDescSubGrupoItem.setText("lbDescSubGrupo");
	}
	return lbDescSubGrupoItem;
  }

  private UnJLabel getLbDescDepto() {
	if (lbDescDepto == null) {
	  lbDescDepto = new UnJLabel();
	  lbDescDepto.setText("lbDescDepto");
	}
	return lbDescDepto;
  }

  private UnJButton getBtnLancar() {
	if (btnLancar == null) {
	  btnLancar = new UnJButton();
	  btnLancar.setTipoFormatacao("lancar");
	  btnLancar.setPreferredSize(new Dimension(50, 20));
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
	  ipvObs.setPreferredSize(new Dimension(50, 20));
	  ipvObs.setName("ipvobs");
	  ipvObs.setMnemonic(KeyEvent.VK_UNDEFINED);
	  ipvObs.setMinimumSize(new Dimension(50, 20));
	  ipvObs.setMaximumSize(new Dimension(333333, 20));
	  ipvObs.setMaximoLength("900");
	}
	return ipvObs;
  }
}
