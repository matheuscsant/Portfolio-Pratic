package br.com.praticsistemas.pratic.faturamento.cadastros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastroEmpresa;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.editFormatado;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;
import br.com.praticsistemas.unprtcomps.telas.UnJTextArea;
import br.com.praticsistemas.unprtlib.TrataString;
import br.com.praticsistemas.unprtlib.telas.CompTelas;

public class CadasContratoDeTransporte extends UnCadastroEmpresa {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private JPanel panelFilial;
  private UnJLabel lbFilCod;
  private EditPratic filCod;
  private UnJLabel lbDescFilCod;
  private JPanel panelCamposSup;
  private UnJLabel lbCteCod;
  private EditPratic cteCod;
  private UnJLabel lbPedNff;
  private UnJLabel lbPedDnf;
  private UnJLabel lbCliCod;
  private EditPratic cliCod;
  private UnJLabel cliCodDes;
  private UnJLabel lbCliCodCnp;
  private UnJLabel lbCliCodEnd;
  private UnJLabel lbVeiPla;
  private editFormatado veiPla;
  private UnJLabel lbVeiRB1;
  private editFormatado veiRB1;
  private UnJLabel cliCodEnd;
  private UnJLabel cliCodCnp;
  private UnJLabel lbVeiRB2;
  private editFormatado veiRB2;
  private UnJLabel lbVeiRB3;
  private editFormatado veiRB3;
  private JTabbedPane orelhas;
  private JPanel panelServicoRealizado;
  private UnJLabel lbRemetente;
  private UnJLabel lbMotNom;
  private EditPratic motNom;
  private UnJLabel lbMotCpf;
  private UnJLabel lbRemeNome;
  private UnJLabel lbRemeDoc;
  private UnJLabel remeDoc;
  private UnJLabel remeNome;
  private UnJLabel lbRemeEnd;
  private UnJLabel remeEnd;
  private UnJLabel lbRemeCid;
  private UnJLabel remeCid;
  private UnJLabel lbDestinatario;
  private UnJLabel lbDestNome;
  private UnJLabel destNome;
  private UnJLabel lbDestDoc;
  private UnJLabel destDoc;
  private UnJLabel lbDestEnd;
  private UnJLabel destEnd;
  private UnJLabel lbDestCid;
  private UnJLabel destCid;
  private UnJLabel lbExpedidor;
  private UnJLabel lbExpeNome;
  private UnJLabel expeNome;
  private UnJLabel lbExpeDoc;
  private UnJLabel expeDoc;
  private UnJLabel lbExpeEnd;
  private UnJLabel expeEnd;
  private UnJLabel lbExpeCid;
  private UnJLabel expeCid;
  private UnJLabel lbRecebedor;
  private UnJLabel lbReceNome;
  private UnJLabel receNome;
  private UnJLabel lbReceDoc;
  private UnJLabel receDoc;
  private UnJLabel lbReceEnd;
  private UnJLabel receEnd;
  private UnJLabel lbReceCid;
  private UnJLabel receCid;
  private UnJLabel lbDesDom;
  private UnJLabel desDom;
  private UnJLabel lbPesoCarregado;
  private UnJLabel pesoCarregado;
  private UnJLabel lbValOca;
  private UnJLabel lbCroRen;
  private editFormatado valOca;
  private editFormatado croRen;
  private UnJLabel lbCroDes;
  private editFormatado croDes;
  private UnJLabel lbCroPed;
  private editFormatado croPed;
  private UnJLabel lbPerInsValIns;
  private editFormatado perIns;
  private editFormatado valIns;
  private UnJLabel lbCroImr;
  private editFormatado croImr;
  private UnJLabel lbTotAdt;
  private editFormatado totAdt;
  private UnJLabel lbCroOcr;
  private editFormatado croOcr;
  private UnJLabel lbCroOde;
  private editFormatado croOde;
  private UnJLabel lbCroSeg;
  private editFormatado croSeg;
  private UnJLabel lbTotalSaldo;
  private UnJLabel totalSaldo;
  private UnJLabel lbTotalLiquido;
  private UnJLabel lbPer;
  private UnJLabel totalLiquido;
  private UnJLabel pedNff;
  private UnJLabel pedDnf;
  private JPanel panelCondicoesEspecificas;
  private UnJLabel lbRespPagamento;
  private UnJLabel respPagamento;
  private UnJLabel lbPrevisaoEntrega;
  private UnJLabel previsaoEntrega;
  private UnJLabel lbCroEst;
  private editFormatado croEst;
  private UnJLabel lbNfes;
  private UnJLabel lbCtes;
  private UnJLabel lbSesSen;
  private editFormatado sesSen;
  private UnJLabel lbObsGer;
  private EditPratic obsGer;
  private UnJLabel lbDescObsGer;
  private editFormatado motCpf;
  private UnJTextArea nfes;
  private UnJTextArea ctes;

  public CadasContratoDeTransporte() {

	initialize();

  }

  private void initialize() {
  	this.setCampoChaveTelaEstrangeiro(true);
	this.setCampoTelaTrabalho(getCteCod());
	this.setCampoFocoAberturaTela(getCteCod());
	this.setTitle("Cadastro de Contrato de Transporte");
	this.setResizable(true);
	this.setCodigoTela("4311");
	this.setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_CONTRATO_RODOVIARIO");
	this.setSize(new Dimension(1030, 650));
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasContratoDeTransporte = null;
	  }
	});

  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
	  GridBagConstraints gbc_panelCamposSup = new GridBagConstraints();
	  gbc_panelCamposSup.fill = GridBagConstraints.BOTH;
	  gbc_panelCamposSup.gridx = 0;
	  gbc_panelCamposSup.gridy = 1;
	  panelCentral.add(getPanelCamposSup(), gbc_panelCamposSup);
	  GridBagConstraints gbc_orelhas = new GridBagConstraints();
	  gbc_orelhas.fill = GridBagConstraints.BOTH;
	  gbc_orelhas.gridx = 0;
	  gbc_orelhas.gridy = 2;
	  panelCentral.add(getOrelhas(), gbc_orelhas);
	}
	return panelCentral;
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
	  gbc_lbFilCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbFilCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbFilCod.gridx = 0;
	  gbc_lbFilCod.gridy = 0;
	  panelFilial.add(getLbFilCod(), gbc_lbFilCod);
	  GridBagConstraints gbc_filCod = new GridBagConstraints();
	  gbc_filCod.insets = new Insets(2, 3, 0, 0);
	  gbc_filCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_filCod.gridx = 1;
	  gbc_filCod.gridy = 0;
	  panelFilial.add(getFilCod(), gbc_filCod);
	  GridBagConstraints gbc_lbDescFilCod = new GridBagConstraints();
	  gbc_lbDescFilCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_lbDescFilCod.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescFilCod.gridx = 2;
	  gbc_lbDescFilCod.gridy = 0;
	  panelFilial.add(getLbDescFilCod(), gbc_lbDescFilCod);
	}
	return panelFilial;
  }

  private UnJLabel getLbFilCod() {
	if (lbFilCod == null) {
	  lbFilCod = new UnJLabel();
	  lbFilCod.setText("Filial:");
	  lbFilCod.setMinimumSize(new Dimension(110, 25));
	  lbFilCod.setPreferredSize(new Dimension(110, 25));
	  lbFilCod.setForeground(Color.BLUE);
	}
	return lbFilCod;
  }

  private EditPratic getFilCod() {
	if (filCod == null) {
	  filCod = new EditPratic();
	  filCod.setTipoValidacao("filiais");
	  filCod.setName("filcod");
	  filCod.setName2("Código da Filial");
	  filCod.setAuxiliarDeTrabalho("filcod");
	  filCod.setCampoEmpresa(super.getEmpCod());
	  filCod.setCampoLimpaTelaAutomatico(false);
	  filCod.setLabelDescricao(getLbDescFilCod());
	}
	return filCod;
  }

  private UnJLabel getLbDescFilCod() {
	if (lbDescFilCod == null) {
	  lbDescFilCod = new UnJLabel();
	  lbDescFilCod.setText("lbDescFilCod");
	  lbDescFilCod.setFont(new Font("Arial", Font.BOLD, 12));
	  lbDescFilCod.limpar();
	}
	return lbDescFilCod;
  }

  private JPanel getPanelCamposSup() {
	if (panelCamposSup == null) {
	  panelCamposSup = new JPanel();
	  panelCamposSup.setBorder(new TitledBorder(
		  new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
		  "Campos Cadastro de Contrato de Transporte", TitledBorder.LEADING, TitledBorder.TOP, null,
		  Color.RED));
	  GridBagLayout gbl_panelCamposSup = new GridBagLayout();
	  gbl_panelCamposSup.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCamposSup.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
	  gbl_panelCamposSup.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCamposSup.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCamposSup.setLayout(gbl_panelCamposSup);
	  GridBagConstraints gbc_lbCteCod = new GridBagConstraints();
	  gbc_lbCteCod.anchor = GridBagConstraints.EAST;
	  gbc_lbCteCod.fill = GridBagConstraints.VERTICAL;
	  gbc_lbCteCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCteCod.gridx = 0;
	  gbc_lbCteCod.gridy = 0;
	  panelCamposSup.add(getLbCteCod(), gbc_lbCteCod);
	  GridBagConstraints gbc_cteCod = new GridBagConstraints();
	  gbc_cteCod.gridwidth = 2;
	  gbc_cteCod.insets = new Insets(2, 3, 0, 0);
	  gbc_cteCod.fill = GridBagConstraints.BOTH;
	  gbc_cteCod.gridx = 1;
	  gbc_cteCod.gridy = 0;
	  panelCamposSup.add(getCteCod(), gbc_cteCod);
	  GridBagConstraints gbc_lbPedNff = new GridBagConstraints();
	  gbc_lbPedNff.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPedNff.fill = GridBagConstraints.BOTH;
	  gbc_lbPedNff.gridx = 3;
	  gbc_lbPedNff.gridy = 0;
	  panelCamposSup.add(getLbPedNff(), gbc_lbPedNff);
	  GridBagConstraints gbc_pedNff = new GridBagConstraints();
	  gbc_pedNff.insets = new Insets(2, 3, 0, 0);
	  gbc_pedNff.fill = GridBagConstraints.BOTH;
	  gbc_pedNff.gridwidth = 2;
	  gbc_pedNff.gridx = 4;
	  gbc_pedNff.gridy = 0;
	  panelCamposSup.add(getPedNff(), gbc_pedNff);
	  GridBagConstraints gbc_lbPedDnf = new GridBagConstraints();
	  gbc_lbPedDnf.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPedDnf.anchor = GridBagConstraints.EAST;
	  gbc_lbPedDnf.gridx = 6;
	  gbc_lbPedDnf.gridy = 0;
	  panelCamposSup.add(getLbPedDnf(), gbc_lbPedDnf);
	  GridBagConstraints gbc_pedDnf = new GridBagConstraints();
	  gbc_pedDnf.insets = new Insets(2, 3, 0, 0);
	  gbc_pedDnf.gridwidth = 3;
	  gbc_pedDnf.fill = GridBagConstraints.BOTH;
	  gbc_pedDnf.gridx = 7;
	  gbc_pedDnf.gridy = 0;
	  panelCamposSup.add(getPedDnf(), gbc_pedDnf);
	  GridBagConstraints gbc_lbCliCod = new GridBagConstraints();
	  gbc_lbCliCod.anchor = GridBagConstraints.EAST;
	  gbc_lbCliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCod.fill = GridBagConstraints.VERTICAL;
	  gbc_lbCliCod.gridx = 0;
	  gbc_lbCliCod.gridy = 1;
	  panelCamposSup.add(getLbCliCod(), gbc_lbCliCod);
	  GridBagConstraints gbc_cliCod = new GridBagConstraints();
	  gbc_cliCod.gridwidth = 2;
	  gbc_cliCod.insets = new Insets(2, 3, 0, 0);
	  gbc_cliCod.fill = GridBagConstraints.BOTH;
	  gbc_cliCod.gridx = 1;
	  gbc_cliCod.gridy = 1;
	  panelCamposSup.add(getCliCod(), gbc_cliCod);
	  GridBagConstraints gbc_cliCodDes = new GridBagConstraints();
	  gbc_cliCodDes.insets = new Insets(2, 3, 0, 3);
	  gbc_cliCodDes.fill = GridBagConstraints.BOTH;
	  gbc_cliCodDes.gridwidth = 9;
	  gbc_cliCodDes.gridx = 3;
	  gbc_cliCodDes.gridy = 1;
	  panelCamposSup.add(getCliCodDes(), gbc_cliCodDes);
	  GridBagConstraints gbc_lbCliCodCnp = new GridBagConstraints();
	  gbc_lbCliCodCnp.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCodCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCodCnp.gridx = 12;
	  gbc_lbCliCodCnp.gridy = 1;
	  panelCamposSup.add(getLbCliCodCnp(), gbc_lbCliCodCnp);
	  GridBagConstraints gbc_cliCodCnp = new GridBagConstraints();
	  gbc_cliCodCnp.gridwidth = 2;
	  gbc_cliCodCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_cliCodCnp.fill = GridBagConstraints.BOTH;
	  gbc_cliCodCnp.gridx = 13;
	  gbc_cliCodCnp.gridy = 1;
	  panelCamposSup.add(getCliCodCnp(), gbc_cliCodCnp);
	  GridBagConstraints gbc_lbCliCodEnd = new GridBagConstraints();
	  gbc_lbCliCodEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCodEnd.anchor = GridBagConstraints.EAST;
	  gbc_lbCliCodEnd.gridx = 0;
	  gbc_lbCliCodEnd.gridy = 2;
	  panelCamposSup.add(getLbCliCodEnd(), gbc_lbCliCodEnd);
	  GridBagConstraints gbc_cliCodEnd = new GridBagConstraints();
	  gbc_cliCodEnd.insets = new Insets(2, 3, 0, 3);
	  gbc_cliCodEnd.fill = GridBagConstraints.BOTH;
	  gbc_cliCodEnd.gridwidth = 14;
	  gbc_cliCodEnd.gridx = 1;
	  gbc_cliCodEnd.gridy = 2;
	  panelCamposSup.add(getCliCodEnd(), gbc_cliCodEnd);
	  GridBagConstraints gbc_lbVeiPla = new GridBagConstraints();
	  gbc_lbVeiPla.anchor = GridBagConstraints.EAST;
	  gbc_lbVeiPla.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiPla.gridx = 0;
	  gbc_lbVeiPla.gridy = 3;
	  panelCamposSup.add(getLbVeiPla(), gbc_lbVeiPla);
	  GridBagConstraints gbc_veiPla = new GridBagConstraints();
	  gbc_veiPla.gridwidth = 2;
	  gbc_veiPla.insets = new Insets(2, 3, 0, 0);
	  gbc_veiPla.fill = GridBagConstraints.HORIZONTAL;
	  gbc_veiPla.gridx = 1;
	  gbc_veiPla.gridy = 3;
	  panelCamposSup.add(getVeiPla(), gbc_veiPla);
	  GridBagConstraints gbc_lbVeiRB1 = new GridBagConstraints();
	  gbc_lbVeiRB1.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB1.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB1.gridx = 3;
	  gbc_lbVeiRB1.gridy = 3;
	  panelCamposSup.add(getLbVeiRB1(), gbc_lbVeiRB1);
	  GridBagConstraints gbc_veiRB1 = new GridBagConstraints();
	  gbc_veiRB1.gridwidth = 2;
	  gbc_veiRB1.anchor = GridBagConstraints.WEST;
	  gbc_veiRB1.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB1.gridx = 4;
	  gbc_veiRB1.gridy = 3;
	  panelCamposSup.add(getVeiRB1(), gbc_veiRB1);
	  GridBagConstraints gbc_lbVeiRB2 = new GridBagConstraints();
	  gbc_lbVeiRB2.gridwidth = 2;
	  gbc_lbVeiRB2.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB2.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB2.gridx = 6;
	  gbc_lbVeiRB2.gridy = 3;
	  panelCamposSup.add(getLbVeiRB2(), gbc_lbVeiRB2);
	  GridBagConstraints gbc_veiRB2 = new GridBagConstraints();
	  gbc_veiRB2.fill = GridBagConstraints.BOTH;
	  gbc_veiRB2.gridwidth = 2;
	  gbc_veiRB2.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB2.gridx = 8;
	  gbc_veiRB2.gridy = 3;
	  panelCamposSup.add(getVeiRB2(), gbc_veiRB2);
	  GridBagConstraints gbc_lbVeiRB3 = new GridBagConstraints();
	  gbc_lbVeiRB3.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB3.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB3.gridwidth = 2;
	  gbc_lbVeiRB3.gridx = 10;
	  gbc_lbVeiRB3.gridy = 3;
	  panelCamposSup.add(getLbVeiRB3(), gbc_lbVeiRB3);
	  GridBagConstraints gbc_veiRB3 = new GridBagConstraints();
	  gbc_veiRB3.gridwidth = 2;
	  gbc_veiRB3.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB3.fill = GridBagConstraints.HORIZONTAL;
	  gbc_veiRB3.gridx = 12;
	  gbc_veiRB3.gridy = 3;
	  panelCamposSup.add(getVeiRB3(), gbc_veiRB3);
	  GridBagConstraints gbc_lbMotNom = new GridBagConstraints();
	  gbc_lbMotNom.anchor = GridBagConstraints.EAST;
	  gbc_lbMotNom.fill = GridBagConstraints.VERTICAL;
	  gbc_lbMotNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMotNom.gridx = 0;
	  gbc_lbMotNom.gridy = 4;
	  panelCamposSup.add(getLbMotNom(), gbc_lbMotNom);
	  GridBagConstraints gbc_motNom = new GridBagConstraints();
	  gbc_motNom.insets = new Insets(2, 3, 0, 0);
	  gbc_motNom.gridwidth = 11;
	  gbc_motNom.fill = GridBagConstraints.HORIZONTAL;
	  gbc_motNom.gridx = 1;
	  gbc_motNom.gridy = 4;
	  panelCamposSup.add(getMotNom(), gbc_motNom);
	  GridBagConstraints gbc_lbMotCpf = new GridBagConstraints();
	  gbc_lbMotCpf.anchor = GridBagConstraints.EAST;
	  gbc_lbMotCpf.fill = GridBagConstraints.VERTICAL;
	  gbc_lbMotCpf.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMotCpf.gridx = 12;
	  gbc_lbMotCpf.gridy = 4;
	  panelCamposSup.add(getLbMotCpf(), gbc_lbMotCpf);
	  GridBagConstraints gbc_motCpf = new GridBagConstraints();
	  gbc_motCpf.insets = new Insets(2, 3, 0, 3);
	  gbc_motCpf.gridwidth = 2;
	  gbc_motCpf.fill = GridBagConstraints.BOTH;
	  gbc_motCpf.gridx = 13;
	  gbc_motCpf.gridy = 4;
	  panelCamposSup.add(getMotCpf(), gbc_motCpf);
	}
	return panelCamposSup;
  }

  private UnJLabel getLbCteCod() {
	if (lbCteCod == null) {
	  lbCteCod = new UnJLabel();
	  lbCteCod.setForeground(Color.BLUE);
	  lbCteCod.setText("C\u00F3digo de Conhecimento:");
	  lbCteCod.setMinimumSize(new Dimension(130, 19));
	  lbCteCod.setPreferredSize(new Dimension(130, 19));
	}
	return lbCteCod;
  }

  private EditPratic getCteCod() {
	if (cteCod == null) {
	  cteCod = new EditPratic();
	  cteCod.setTipoValidacao("pedven/cte");
	  cteCod.setCampoLimpaTelaAutomatico(false);
	  cteCod.setName("CTECOD");
	  cteCod.setPreferredSize(new Dimension(40, 19));
	  cteCod.setMinimumSize(new Dimension(40, 19));
	}
	return cteCod;
  }

  private UnJLabel getLbPedNff() {
	if (lbPedNff == null) {
	  lbPedNff = new UnJLabel();
	  lbPedNff.setText("N\u00B0 CTE:");
	  lbPedNff.setPreferredSize(new Dimension(40, 19));
	  lbPedNff.setMinimumSize(new Dimension(40, 19));
	}
	return lbPedNff;
  }

  private UnJLabel getLbPedDnf() {
	if (lbPedDnf == null) {
	  lbPedDnf = new UnJLabel();
	  lbPedDnf.setText("Emiss\u00E3o CTE:");
	  lbPedDnf.setPreferredSize(new Dimension(70, 19));
	  lbPedDnf.setMinimumSize(new Dimension(70, 19));
	}
	return lbPedDnf;
  }

  private UnJLabel getLbCliCod() {
	if (lbCliCod == null) {
	  lbCliCod = new UnJLabel();
	  lbCliCod.setText("C\u00F3digo do Subcontratado:");
	  lbCliCod.setPreferredSize(new Dimension(130, 19));
	  lbCliCod.setMinimumSize(new Dimension(130, 19));
	  lbCliCod.setForeground(Color.BLUE);
	}
	return lbCliCod;
  }

  private EditPratic getCliCod() {
	if (cliCod == null) {
	  cliCod = new EditPratic();
	  cliCod.setTipoValidacao("cli_geral");
	  cliCod.setName2("Código do Cliente");
	  cliCod.setSoNumeros(true);
	  cliCod.setName("CLICOD");
	  cliCod.setLabelDescricao(getCliCodDes());
	}
	return cliCod;
  }

  private UnJLabel getCliCodDes() {
	if (cliCodDes == null) {
	  cliCodDes = new UnJLabel();
	  cliCodDes.setName("CLICODDES");
	  cliCodDes.setText("lbCliCodDes");
	  cliCodDes.setFont(new Font("Arial", Font.BOLD, 11));

	}
	return cliCodDes;
  }

  private UnJLabel getLbCliCodCnp() {
	if (lbCliCodCnp == null) {
	  lbCliCodCnp = new UnJLabel();
	  lbCliCodCnp.setText("CPF/CNPJ:");
	  lbCliCodCnp.setPreferredSize(new Dimension(60, 19));
	  lbCliCodCnp.setMinimumSize(new Dimension(60, 19));
	}
	return lbCliCodCnp;
  }

  private UnJLabel getLbCliCodEnd() {
	if (lbCliCodEnd == null) {
	  lbCliCodEnd = new UnJLabel();
	  lbCliCodEnd.setText("Endere\u00E7o Propriet\u00E1rio:");
	  lbCliCodEnd.setPreferredSize(new Dimension(130, 19));
	  lbCliCodEnd.setMinimumSize(new Dimension(130, 19));
	  lbCliCodEnd.setForeground(Color.BLACK);
	}
	return lbCliCodEnd;
  }

  private UnJLabel getLbVeiPla() {
	if (lbVeiPla == null) {
	  lbVeiPla = new UnJLabel();
	  lbVeiPla.setText("Placa Cavalo:");
	  lbVeiPla.setPreferredSize(new Dimension(130, 19));
	  lbVeiPla.setMinimumSize(new Dimension(130, 19));
	  lbVeiPla.setForeground(Color.BLACK);
	}
	return lbVeiPla;
  }

  private editFormatado getVeiPla() {
	if (veiPla == null) {
	  veiPla = new editFormatado();
	  veiPla.setTipoFormatacao(16);
	  veiPla.setSoNumeros(false);
	  veiPla.setPreferredSize(new Dimension(100, 19));
	  veiPla.setName("veipla");
	  veiPla.setMinimumSize(new Dimension(100, 19));
	}
	return veiPla;
  }

  private UnJLabel getLbVeiRB1() {
	if (lbVeiRB1 == null) {
	  lbVeiRB1 = new UnJLabel();
	  lbVeiRB1.setText("Placa Carreta 1:");
	  lbVeiRB1.setPreferredSize(new Dimension(100, 19));
	  lbVeiRB1.setMinimumSize(new Dimension(100, 19));
	}
	return lbVeiRB1;
  }

  private editFormatado getVeiRB1() {
	if (veiRB1 == null) {
	  veiRB1 = new editFormatado();
	  veiRB1.setCampoObrigatorio(false);
	  veiRB1.setTipoFormatacao(16);
	  veiRB1.setSoNumeros(false);
	  veiRB1.setPreferredSize(new Dimension(100, 19));
	  veiRB1.setName("VEIRB1");
	  veiRB1.setMinimumSize(new Dimension(100, 19));
	}
	return veiRB1;
  }

  private UnJLabel getCliCodEnd() {
	if (cliCodEnd == null) {
	  cliCodEnd = new UnJLabel();
	  cliCodEnd.setName("CLICODEND");
	  cliCodEnd.setFont(new Font("Arial", Font.BOLD, 11));

	}
	return cliCodEnd;
  }

  private UnJLabel getCliCodCnp() {
	if (cliCodCnp == null) {
	  cliCodCnp = new UnJLabel();
	  cliCodCnp.setName("CLICODCNP");
	  cliCodCnp.setToolTipText("");
	  cliCodCnp.setPreferredSize(new Dimension(150, 19));
	  cliCodCnp.setMinimumSize(new Dimension(150, 19));

	}
	return cliCodCnp;
  }

  private UnJLabel getLbVeiRB2() {
	if (lbVeiRB2 == null) {
	  lbVeiRB2 = new UnJLabel();
	  lbVeiRB2.setText("Placa Carreta 2:");
	  lbVeiRB2.setPreferredSize(new Dimension(100, 19));
	  lbVeiRB2.setMinimumSize(new Dimension(100, 19));
	}
	return lbVeiRB2;
  }

  private editFormatado getVeiRB2() {
	if (veiRB2 == null) {
	  veiRB2 = new editFormatado();
	  veiRB2.setCampoObrigatorio(false);
	  veiRB2.setTipoFormatacao(16);
	  veiRB2.setSoNumeros(false);
	  veiRB2.setPreferredSize(new Dimension(100, 19));
	  veiRB2.setName("VEIRB2");
	  veiRB2.setMinimumSize(new Dimension(100, 19));
	}
	return veiRB2;
  }

  private UnJLabel getLbVeiRB3() {
	if (lbVeiRB3 == null) {
	  lbVeiRB3 = new UnJLabel();
	  lbVeiRB3.setText("Placa Carreta 3:");
	  lbVeiRB3.setPreferredSize(new Dimension(100, 19));
	  lbVeiRB3.setMinimumSize(new Dimension(100, 19));
	}
	return lbVeiRB3;
  }

  private editFormatado getVeiRB3() {
	if (veiRB3 == null) {
	  veiRB3 = new editFormatado();
	  veiRB3.setCampoObrigatorio(false);
	  veiRB3.setTipoFormatacao(16);
	  veiRB3.setSoNumeros(false);
	  veiRB3.setPreferredSize(new Dimension(100, 19));
	  veiRB3.setName("VEIRB3");
	  veiRB3.setMinimumSize(new Dimension(100, 19));
	}
	return veiRB3;
  }

  private JTabbedPane getOrelhas() {
	if (orelhas == null) {
	  orelhas = new JTabbedPane();
	  orelhas.setFocusable(false);
	  orelhas.addTab("Servi\u00E7o Realizado",
		  new ImageIcon(CadasContratoDeTransporte.class.getResource("/groovy/ui/icons/folder_page.png")),
		  getPanelServicoRealizado(), null);
	  orelhas.addTab("Condi\u00E7\u00F5es Espec\u00EDficas",
		  new ImageIcon(CadasContratoDeTransporte.class.getResource("/groovy/ui/icons/find.png")),
		  getPanelCondicoesEspecificas(), null);
	}
	return orelhas;
  }

  private JPanel getPanelServicoRealizado() {
	if (panelServicoRealizado == null) {
	  panelServicoRealizado = new JPanel();
	  GridBagLayout gbl_panelServicoRealizado = new GridBagLayout();
	  gbl_panelServicoRealizado.columnWidths = new int[] { 0, 0, 0, 0, 65, 0, 0, 0 };
	  gbl_panelServicoRealizado.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		  0 };
	  gbl_panelServicoRealizado.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0,
		  Double.MIN_VALUE };
	  gbl_panelServicoRealizado.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelServicoRealizado.setLayout(gbl_panelServicoRealizado);
	  GridBagConstraints gbc_lbRemetente = new GridBagConstraints();
	  gbc_lbRemetente.fill = GridBagConstraints.BOTH;
	  gbc_lbRemetente.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemetente.gridx = 0;
	  gbc_lbRemetente.gridy = 0;
	  panelServicoRealizado.add(getLbRemetente(), gbc_lbRemetente);
	  GridBagConstraints gbc_lbRemeNome = new GridBagConstraints();
	  gbc_lbRemeNome.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeNome.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeNome.gridx = 1;
	  gbc_lbRemeNome.gridy = 0;
	  panelServicoRealizado.add(getLbRemeNome(), gbc_lbRemeNome);
	  GridBagConstraints gbc_remeNome = new GridBagConstraints();
	  gbc_remeNome.fill = GridBagConstraints.BOTH;
	  gbc_remeNome.insets = new Insets(2, 3, 0, 0);
	  gbc_remeNome.gridx = 2;
	  gbc_remeNome.gridy = 0;
	  panelServicoRealizado.add(getRemeNome(), gbc_remeNome);
	  GridBagConstraints gbc_lbDesDom = new GridBagConstraints();
	  gbc_lbDesDom.fill = GridBagConstraints.BOTH;
	  gbc_lbDesDom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDesDom.gridx = 3;
	  gbc_lbDesDom.gridy = 0;
	  panelServicoRealizado.add(getLbDesDom(), gbc_lbDesDom);
	  GridBagConstraints gbc_desDom = new GridBagConstraints();
	  gbc_desDom.gridwidth = 3;
	  gbc_desDom.insets = new Insets(2, 3, 0, 0);
	  gbc_desDom.fill = GridBagConstraints.BOTH;
	  gbc_desDom.gridx = 4;
	  gbc_desDom.gridy = 0;
	  panelServicoRealizado.add(getDesDom(), gbc_desDom);
	  GridBagConstraints gbc_lbRemeDoc = new GridBagConstraints();
	  gbc_lbRemeDoc.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeDoc.gridx = 1;
	  gbc_lbRemeDoc.gridy = 1;
	  panelServicoRealizado.add(getLbRemeDoc(), gbc_lbRemeDoc);
	  GridBagConstraints gbc_remeDoc = new GridBagConstraints();
	  gbc_remeDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_remeDoc.fill = GridBagConstraints.BOTH;
	  gbc_remeDoc.gridx = 2;
	  gbc_remeDoc.gridy = 1;
	  panelServicoRealizado.add(getRemeDoc(), gbc_remeDoc);
	  GridBagConstraints gbc_lbPesoCarregado = new GridBagConstraints();
	  gbc_lbPesoCarregado.fill = GridBagConstraints.BOTH;
	  gbc_lbPesoCarregado.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesoCarregado.gridx = 3;
	  gbc_lbPesoCarregado.gridy = 1;
	  panelServicoRealizado.add(getLbPesoCarregado(), gbc_lbPesoCarregado);
	  GridBagConstraints gbc_pesoCarregado = new GridBagConstraints();
	  gbc_pesoCarregado.fill = GridBagConstraints.BOTH;
	  gbc_pesoCarregado.insets = new Insets(2, 3, 0, 0);
	  gbc_pesoCarregado.gridwidth = 3;
	  gbc_pesoCarregado.gridx = 4;
	  gbc_pesoCarregado.gridy = 1;
	  panelServicoRealizado.add(getPesoCarregado(), gbc_pesoCarregado);
	  GridBagConstraints gbc_lbRemeEnd = new GridBagConstraints();
	  gbc_lbRemeEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeEnd.gridx = 1;
	  gbc_lbRemeEnd.gridy = 2;
	  panelServicoRealizado.add(getLbRemeEnd(), gbc_lbRemeEnd);
	  GridBagConstraints gbc_remeEnd = new GridBagConstraints();
	  gbc_remeEnd.fill = GridBagConstraints.BOTH;
	  gbc_remeEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_remeEnd.gridx = 2;
	  gbc_remeEnd.gridy = 2;
	  panelServicoRealizado.add(getRemeEnd(), gbc_remeEnd);
	  GridBagConstraints gbc_lbValOca = new GridBagConstraints();
	  gbc_lbValOca.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValOca.fill = GridBagConstraints.BOTH;
	  gbc_lbValOca.gridx = 3;
	  gbc_lbValOca.gridy = 2;
	  panelServicoRealizado.add(getLbValOca(), gbc_lbValOca);
	  GridBagConstraints gbc_valOca = new GridBagConstraints();
	  gbc_valOca.insets = new Insets(2, 3, 0, 3);
	  gbc_valOca.gridwidth = 3;
	  gbc_valOca.fill = GridBagConstraints.BOTH;
	  gbc_valOca.gridx = 4;
	  gbc_valOca.gridy = 2;
	  panelServicoRealizado.add(getValOca(), gbc_valOca);
	  GridBagConstraints gbc_lbRemeCid = new GridBagConstraints();
	  gbc_lbRemeCid.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeCid.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeCid.gridx = 1;
	  gbc_lbRemeCid.gridy = 3;
	  panelServicoRealizado.add(getLbRemeCid(), gbc_lbRemeCid);
	  GridBagConstraints gbc_remeCid = new GridBagConstraints();
	  gbc_remeCid.fill = GridBagConstraints.BOTH;
	  gbc_remeCid.insets = new Insets(2, 3, 0, 0);
	  gbc_remeCid.gridx = 2;
	  gbc_remeCid.gridy = 3;
	  panelServicoRealizado.add(getRemeCid(), gbc_remeCid);
	  GridBagConstraints gbc_lbCroRen = new GridBagConstraints();
	  gbc_lbCroRen.fill = GridBagConstraints.BOTH;
	  gbc_lbCroRen.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroRen.gridx = 3;
	  gbc_lbCroRen.gridy = 3;
	  panelServicoRealizado.add(getLbCroRen(), gbc_lbCroRen);
	  GridBagConstraints gbc_croRen = new GridBagConstraints();
	  gbc_croRen.insets = new Insets(2, 3, 0, 3);
	  gbc_croRen.gridwidth = 3;
	  gbc_croRen.fill = GridBagConstraints.BOTH;
	  gbc_croRen.gridx = 4;
	  gbc_croRen.gridy = 3;
	  panelServicoRealizado.add(getCroRen(), gbc_croRen);
	  GridBagConstraints gbc_lbDestinatario = new GridBagConstraints();
	  gbc_lbDestinatario.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestinatario.gridx = 0;
	  gbc_lbDestinatario.gridy = 4;
	  panelServicoRealizado.add(getLbDestinatario(), gbc_lbDestinatario);
	  GridBagConstraints gbc_lbDestNome = new GridBagConstraints();
	  gbc_lbDestNome.fill = GridBagConstraints.BOTH;
	  gbc_lbDestNome.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestNome.gridx = 1;
	  gbc_lbDestNome.gridy = 4;
	  panelServicoRealizado.add(getLbDestNome(), gbc_lbDestNome);
	  GridBagConstraints gbc_destNome = new GridBagConstraints();
	  gbc_destNome.fill = GridBagConstraints.BOTH;
	  gbc_destNome.insets = new Insets(2, 3, 0, 0);
	  gbc_destNome.gridx = 2;
	  gbc_destNome.gridy = 4;
	  panelServicoRealizado.add(getDestNome(), gbc_destNome);
	  GridBagConstraints gbc_lbCroDes = new GridBagConstraints();
	  gbc_lbCroDes.fill = GridBagConstraints.BOTH;
	  gbc_lbCroDes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroDes.gridx = 3;
	  gbc_lbCroDes.gridy = 4;
	  panelServicoRealizado.add(getLbCroDes(), gbc_lbCroDes);
	  GridBagConstraints gbc_croDes = new GridBagConstraints();
	  gbc_croDes.insets = new Insets(2, 3, 0, 3);
	  gbc_croDes.gridwidth = 3;
	  gbc_croDes.fill = GridBagConstraints.BOTH;
	  gbc_croDes.gridx = 4;
	  gbc_croDes.gridy = 4;
	  panelServicoRealizado.add(getCroDes(), gbc_croDes);
	  GridBagConstraints gbc_lbDestDoc = new GridBagConstraints();
	  gbc_lbDestDoc.fill = GridBagConstraints.BOTH;
	  gbc_lbDestDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestDoc.gridx = 1;
	  gbc_lbDestDoc.gridy = 5;
	  panelServicoRealizado.add(getLbDestDoc(), gbc_lbDestDoc);
	  GridBagConstraints gbc_destDoc = new GridBagConstraints();
	  gbc_destDoc.fill = GridBagConstraints.BOTH;
	  gbc_destDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_destDoc.gridx = 2;
	  gbc_destDoc.gridy = 5;
	  panelServicoRealizado.add(getDestDoc(), gbc_destDoc);
	  GridBagConstraints gbc_lbCroPed = new GridBagConstraints();
	  gbc_lbCroPed.fill = GridBagConstraints.BOTH;
	  gbc_lbCroPed.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroPed.gridx = 3;
	  gbc_lbCroPed.gridy = 5;
	  panelServicoRealizado.add(getLbCroPed(), gbc_lbCroPed);
	  GridBagConstraints gbc_croPed = new GridBagConstraints();
	  gbc_croPed.insets = new Insets(2, 3, 0, 3);
	  gbc_croPed.gridwidth = 3;
	  gbc_croPed.fill = GridBagConstraints.BOTH;
	  gbc_croPed.gridx = 4;
	  gbc_croPed.gridy = 5;
	  panelServicoRealizado.add(getCroPed(), gbc_croPed);
	  GridBagConstraints gbc_lbDestEnd = new GridBagConstraints();
	  gbc_lbDestEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbDestEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestEnd.gridx = 1;
	  gbc_lbDestEnd.gridy = 6;
	  panelServicoRealizado.add(getLbDestEnd(), gbc_lbDestEnd);
	  GridBagConstraints gbc_destEnd = new GridBagConstraints();
	  gbc_destEnd.fill = GridBagConstraints.BOTH;
	  gbc_destEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_destEnd.gridx = 2;
	  gbc_destEnd.gridy = 6;
	  panelServicoRealizado.add(getDestEnd(), gbc_destEnd);
	  GridBagConstraints gbc_lbSesSen = new GridBagConstraints();
	  gbc_lbSesSen.insets = new Insets(2, 3, 0, 0);
	  gbc_lbSesSen.fill = GridBagConstraints.BOTH;
	  gbc_lbSesSen.gridx = 3;
	  gbc_lbSesSen.gridy = 6;
	  panelServicoRealizado.add(getLbSesSen(), gbc_lbSesSen);
	  GridBagConstraints gbc_sesSen = new GridBagConstraints();
	  gbc_sesSen.insets = new Insets(2, 3, 0, 3);
	  gbc_sesSen.gridwidth = 3;
	  gbc_sesSen.fill = GridBagConstraints.HORIZONTAL;
	  gbc_sesSen.gridx = 4;
	  gbc_sesSen.gridy = 6;
	  panelServicoRealizado.add(getSesSen(), gbc_sesSen);
	  GridBagConstraints gbc_lbDestCid = new GridBagConstraints();
	  gbc_lbDestCid.fill = GridBagConstraints.BOTH;
	  gbc_lbDestCid.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestCid.gridx = 1;
	  gbc_lbDestCid.gridy = 7;
	  panelServicoRealizado.add(getLbDestCid(), gbc_lbDestCid);
	  GridBagConstraints gbc_destCid = new GridBagConstraints();
	  gbc_destCid.fill = GridBagConstraints.BOTH;
	  gbc_destCid.insets = new Insets(2, 3, 0, 0);
	  gbc_destCid.gridx = 2;
	  gbc_destCid.gridy = 7;
	  panelServicoRealizado.add(getDestCid(), gbc_destCid);
	  GridBagConstraints gbc_lbPerInsValIns = new GridBagConstraints();
	  gbc_lbPerInsValIns.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPerInsValIns.fill = GridBagConstraints.BOTH;
	  gbc_lbPerInsValIns.gridx = 3;
	  gbc_lbPerInsValIns.gridy = 7;
	  panelServicoRealizado.add(getLbPerInsValIns(), gbc_lbPerInsValIns);
	  GridBagConstraints gbc_perIns = new GridBagConstraints();
	  gbc_perIns.insets = new Insets(2, 3, 0, 0);
	  gbc_perIns.fill = GridBagConstraints.BOTH;
	  gbc_perIns.gridx = 4;
	  gbc_perIns.gridy = 7;
	  panelServicoRealizado.add(getPerIns(), gbc_perIns);
	  GridBagConstraints gbc_lbPer = new GridBagConstraints();
	  gbc_lbPer.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPer.anchor = GridBagConstraints.EAST;
	  gbc_lbPer.gridx = 5;
	  gbc_lbPer.gridy = 7;
	  panelServicoRealizado.add(getLbPer(), gbc_lbPer);
	  GridBagConstraints gbc_valIns = new GridBagConstraints();
	  gbc_valIns.insets = new Insets(2, 3, 0, 3);
	  gbc_valIns.fill = GridBagConstraints.BOTH;
	  gbc_valIns.gridx = 6;
	  gbc_valIns.gridy = 7;
	  panelServicoRealizado.add(getValIns(), gbc_valIns);
	  GridBagConstraints gbc_lbExpedidor = new GridBagConstraints();
	  gbc_lbExpedidor.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpedidor.gridx = 0;
	  gbc_lbExpedidor.gridy = 8;
	  panelServicoRealizado.add(getLbExpedidor(), gbc_lbExpedidor);
	  GridBagConstraints gbc_lbExpeNome = new GridBagConstraints();
	  gbc_lbExpeNome.fill = GridBagConstraints.BOTH;
	  gbc_lbExpeNome.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpeNome.gridx = 1;
	  gbc_lbExpeNome.gridy = 8;
	  panelServicoRealizado.add(getLbExpeNome(), gbc_lbExpeNome);
	  GridBagConstraints gbc_expeNome = new GridBagConstraints();
	  gbc_expeNome.fill = GridBagConstraints.BOTH;
	  gbc_expeNome.insets = new Insets(2, 3, 0, 0);
	  gbc_expeNome.gridx = 2;
	  gbc_expeNome.gridy = 8;
	  panelServicoRealizado.add(getExpeNome(), gbc_expeNome);
	  GridBagConstraints gbc_lbCroImr = new GridBagConstraints();
	  gbc_lbCroImr.fill = GridBagConstraints.BOTH;
	  gbc_lbCroImr.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroImr.gridx = 3;
	  gbc_lbCroImr.gridy = 8;
	  panelServicoRealizado.add(getLbCroImr(), gbc_lbCroImr);
	  GridBagConstraints gbc_croImr = new GridBagConstraints();
	  gbc_croImr.insets = new Insets(2, 3, 0, 3);
	  gbc_croImr.gridwidth = 3;
	  gbc_croImr.fill = GridBagConstraints.BOTH;
	  gbc_croImr.gridx = 4;
	  gbc_croImr.gridy = 8;
	  panelServicoRealizado.add(getCroImr(), gbc_croImr);
	  GridBagConstraints gbc_lbExpeDoc = new GridBagConstraints();
	  gbc_lbExpeDoc.fill = GridBagConstraints.BOTH;
	  gbc_lbExpeDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpeDoc.gridx = 1;
	  gbc_lbExpeDoc.gridy = 9;
	  panelServicoRealizado.add(getLbExpeDoc(), gbc_lbExpeDoc);
	  GridBagConstraints gbc_expeDoc = new GridBagConstraints();
	  gbc_expeDoc.fill = GridBagConstraints.BOTH;
	  gbc_expeDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_expeDoc.gridx = 2;
	  gbc_expeDoc.gridy = 9;
	  panelServicoRealizado.add(getExpeDoc(), gbc_expeDoc);
	  GridBagConstraints gbc_lbTotAdt = new GridBagConstraints();
	  gbc_lbTotAdt.anchor = GridBagConstraints.EAST;
	  gbc_lbTotAdt.gridx = 3;
	  gbc_lbTotAdt.gridy = 9;
	  panelServicoRealizado.add(getLbTotAdt(), gbc_lbTotAdt);
	  GridBagConstraints gbc_totAdt = new GridBagConstraints();
	  gbc_totAdt.insets = new Insets(2, 3, 0, 3);
	  gbc_totAdt.gridwidth = 3;
	  gbc_totAdt.fill = GridBagConstraints.BOTH;
	  gbc_totAdt.gridx = 4;
	  gbc_totAdt.gridy = 9;
	  panelServicoRealizado.add(getTotAdt(), gbc_totAdt);
	  GridBagConstraints gbc_lbExpeEnd = new GridBagConstraints();
	  gbc_lbExpeEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbExpeEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpeEnd.gridx = 1;
	  gbc_lbExpeEnd.gridy = 10;
	  panelServicoRealizado.add(getLbExpeEnd(), gbc_lbExpeEnd);
	  GridBagConstraints gbc_expeEnd = new GridBagConstraints();
	  gbc_expeEnd.fill = GridBagConstraints.BOTH;
	  gbc_expeEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_expeEnd.gridx = 2;
	  gbc_expeEnd.gridy = 10;
	  panelServicoRealizado.add(getExpeEnd(), gbc_expeEnd);
	  GridBagConstraints gbc_lbCroOcr = new GridBagConstraints();
	  gbc_lbCroOcr.fill = GridBagConstraints.BOTH;
	  gbc_lbCroOcr.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroOcr.gridx = 3;
	  gbc_lbCroOcr.gridy = 10;
	  panelServicoRealizado.add(getLbCroOcr(), gbc_lbCroOcr);
	  GridBagConstraints gbc_croOcr = new GridBagConstraints();
	  gbc_croOcr.insets = new Insets(2, 3, 0, 3);
	  gbc_croOcr.gridwidth = 3;
	  gbc_croOcr.fill = GridBagConstraints.BOTH;
	  gbc_croOcr.gridx = 4;
	  gbc_croOcr.gridy = 10;
	  panelServicoRealizado.add(getCroOcr(), gbc_croOcr);
	  GridBagConstraints gbc_lbExpeCid = new GridBagConstraints();
	  gbc_lbExpeCid.fill = GridBagConstraints.BOTH;
	  gbc_lbExpeCid.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpeCid.gridx = 1;
	  gbc_lbExpeCid.gridy = 11;
	  panelServicoRealizado.add(getLbExpeCid(), gbc_lbExpeCid);
	  GridBagConstraints gbc_expeCid = new GridBagConstraints();
	  gbc_expeCid.fill = GridBagConstraints.BOTH;
	  gbc_expeCid.insets = new Insets(2, 3, 0, 0);
	  gbc_expeCid.gridx = 2;
	  gbc_expeCid.gridy = 11;
	  panelServicoRealizado.add(getExpeCid(), gbc_expeCid);
	  GridBagConstraints gbc_lbCroOde = new GridBagConstraints();
	  gbc_lbCroOde.fill = GridBagConstraints.BOTH;
	  gbc_lbCroOde.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroOde.gridx = 3;
	  gbc_lbCroOde.gridy = 11;
	  panelServicoRealizado.add(getLbCroOde(), gbc_lbCroOde);
	  GridBagConstraints gbc_croOde = new GridBagConstraints();
	  gbc_croOde.insets = new Insets(2, 3, 0, 3);
	  gbc_croOde.gridwidth = 3;
	  gbc_croOde.fill = GridBagConstraints.BOTH;
	  gbc_croOde.gridx = 4;
	  gbc_croOde.gridy = 11;
	  panelServicoRealizado.add(getCroOde(), gbc_croOde);
	  GridBagConstraints gbc_lbRecebedor = new GridBagConstraints();
	  gbc_lbRecebedor.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecebedor.gridx = 0;
	  gbc_lbRecebedor.gridy = 12;
	  panelServicoRealizado.add(getLbRecebedor(), gbc_lbRecebedor);
	  GridBagConstraints gbc_lbReceNome = new GridBagConstraints();
	  gbc_lbReceNome.fill = GridBagConstraints.BOTH;
	  gbc_lbReceNome.insets = new Insets(2, 3, 0, 0);
	  gbc_lbReceNome.gridx = 1;
	  gbc_lbReceNome.gridy = 12;
	  panelServicoRealizado.add(getLbReceNome(), gbc_lbReceNome);
	  GridBagConstraints gbc_receNome = new GridBagConstraints();
	  gbc_receNome.fill = GridBagConstraints.BOTH;
	  gbc_receNome.insets = new Insets(2, 3, 0, 0);
	  gbc_receNome.gridx = 2;
	  gbc_receNome.gridy = 12;
	  panelServicoRealizado.add(getReceNome(), gbc_receNome);
	  GridBagConstraints gbc_lbCroSeg = new GridBagConstraints();
	  gbc_lbCroSeg.fill = GridBagConstraints.BOTH;
	  gbc_lbCroSeg.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroSeg.gridx = 3;
	  gbc_lbCroSeg.gridy = 12;
	  panelServicoRealizado.add(getLbCroSeg(), gbc_lbCroSeg);
	  GridBagConstraints gbc_croSeg = new GridBagConstraints();
	  gbc_croSeg.insets = new Insets(2, 3, 0, 3);
	  gbc_croSeg.gridwidth = 3;
	  gbc_croSeg.fill = GridBagConstraints.BOTH;
	  gbc_croSeg.gridx = 4;
	  gbc_croSeg.gridy = 12;
	  panelServicoRealizado.add(getCroSeg(), gbc_croSeg);
	  GridBagConstraints gbc_lbReceDoc = new GridBagConstraints();
	  gbc_lbReceDoc.fill = GridBagConstraints.BOTH;
	  gbc_lbReceDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_lbReceDoc.gridx = 1;
	  gbc_lbReceDoc.gridy = 13;
	  panelServicoRealizado.add(getLbReceDoc(), gbc_lbReceDoc);
	  GridBagConstraints gbc_receDoc = new GridBagConstraints();
	  gbc_receDoc.fill = GridBagConstraints.BOTH;
	  gbc_receDoc.insets = new Insets(2, 3, 0, 0);
	  gbc_receDoc.gridx = 2;
	  gbc_receDoc.gridy = 13;
	  panelServicoRealizado.add(getReceDoc(), gbc_receDoc);
	  GridBagConstraints gbc_lbTotalSaldo = new GridBagConstraints();
	  gbc_lbTotalSaldo.fill = GridBagConstraints.BOTH;
	  gbc_lbTotalSaldo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotalSaldo.gridx = 3;
	  gbc_lbTotalSaldo.gridy = 13;
	  panelServicoRealizado.add(getLbTotalSaldo(), gbc_lbTotalSaldo);
	  GridBagConstraints gbc_totalSaldo = new GridBagConstraints();
	  gbc_totalSaldo.insets = new Insets(2, 3, 0, 3);
	  gbc_totalSaldo.fill = GridBagConstraints.BOTH;
	  gbc_totalSaldo.gridwidth = 3;
	  gbc_totalSaldo.gridx = 4;
	  gbc_totalSaldo.gridy = 13;
	  panelServicoRealizado.add(getTotalSaldo(), gbc_totalSaldo);
	  GridBagConstraints gbc_lbReceEnd = new GridBagConstraints();
	  gbc_lbReceEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbReceEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbReceEnd.gridx = 1;
	  gbc_lbReceEnd.gridy = 14;
	  panelServicoRealizado.add(getLbReceEnd(), gbc_lbReceEnd);
	  GridBagConstraints gbc_receEnd = new GridBagConstraints();
	  gbc_receEnd.fill = GridBagConstraints.BOTH;
	  gbc_receEnd.insets = new Insets(2, 0, 0, 0);
	  gbc_receEnd.gridx = 2;
	  gbc_receEnd.gridy = 14;
	  panelServicoRealizado.add(getReceEnd(), gbc_receEnd);
	  GridBagConstraints gbc_lbTotalLiquido = new GridBagConstraints();
	  gbc_lbTotalLiquido.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotalLiquido.gridx = 3;
	  gbc_lbTotalLiquido.gridy = 14;
	  panelServicoRealizado.add(getLbTotalLiquido(), gbc_lbTotalLiquido);
	  GridBagConstraints gbc_totalLiquido = new GridBagConstraints();
	  gbc_totalLiquido.fill = GridBagConstraints.BOTH;
	  gbc_totalLiquido.insets = new Insets(2, 3, 0, 3);
	  gbc_totalLiquido.gridwidth = 3;
	  gbc_totalLiquido.gridx = 4;
	  gbc_totalLiquido.gridy = 14;
	  panelServicoRealizado.add(getTotalLiquido(), gbc_totalLiquido);
	  GridBagConstraints gbc_lbReceCid = new GridBagConstraints();
	  gbc_lbReceCid.fill = GridBagConstraints.BOTH;
	  gbc_lbReceCid.insets = new Insets(2, 3, 0, 0);
	  gbc_lbReceCid.gridx = 1;
	  gbc_lbReceCid.gridy = 15;
	  panelServicoRealizado.add(getLbReceCid(), gbc_lbReceCid);
	  GridBagConstraints gbc_receCid = new GridBagConstraints();
	  gbc_receCid.insets = new Insets(2, 3, 0, 0);
	  gbc_receCid.fill = GridBagConstraints.BOTH;
	  gbc_receCid.gridx = 2;
	  gbc_receCid.gridy = 15;
	  panelServicoRealizado.add(getReceCid(), gbc_receCid);
	}
	return panelServicoRealizado;
  }

  private UnJLabel getLbRemetente() {
	if (lbRemetente == null) {
	  lbRemetente = new UnJLabel();
	  lbRemetente.setFont(new Font("Arial", Font.BOLD, 15));
	  lbRemetente.setText("Remetente");
	  lbRemetente.setPreferredSize(new Dimension(100, 19));
	  lbRemetente.setMinimumSize(new Dimension(100, 19));
	}
	return lbRemetente;
  }

  private UnJLabel getLbMotNom() {
	if (lbMotNom == null) {
	  lbMotNom = new UnJLabel();
	  lbMotNom.setText("Motorista:");
	  lbMotNom.setPreferredSize(new Dimension(130, 19));
	  lbMotNom.setMinimumSize(new Dimension(130, 19));
	}
	return lbMotNom;
  }

  private EditPratic getMotNom() {
	if (motNom == null) {
	  motNom = new EditPratic();
	  motNom.setCampoObrigatorio(false);
	  motNom.setName("MOTNOM");
	}
	return motNom;
  }

  private UnJLabel getLbMotCpf() {
	if (lbMotCpf == null) {
	  lbMotCpf = new UnJLabel();
	  lbMotCpf.setText("CPF/CNPJ:");
	  lbMotCpf.setPreferredSize(new Dimension(60, 19));
	  lbMotCpf.setMinimumSize(new Dimension(60, 19));
	}
	return lbMotCpf;
  }

  private UnJLabel getLbRemeNome() {
	if (lbRemeNome == null) {
	  lbRemeNome = new UnJLabel();
	  lbRemeNome.setText("Raz\u00E3o Social:");
	  lbRemeNome.setPreferredSize(new Dimension(90, 19));
	  lbRemeNome.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeNome;
  }

  private UnJLabel getLbRemeDoc() {
	if (lbRemeDoc == null) {
	  lbRemeDoc = new UnJLabel();
	  lbRemeDoc.setText("CPF/CNPJ:");
	  lbRemeDoc.setPreferredSize(new Dimension(90, 19));
	  lbRemeDoc.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeDoc;
  }

  private UnJLabel getRemeDoc() {
	if (remeDoc == null) {
	  remeDoc = new UnJLabel();
	  remeDoc.setPreferredSize(new Dimension(500, 19));
	  remeDoc.setName("REME_DOC");
	  remeDoc.setMinimumSize(new Dimension(500, 19));
	}
	return remeDoc;
  }

  private UnJLabel getRemeNome() {
	if (remeNome == null) {
	  remeNome = new UnJLabel();
	  remeNome.setPreferredSize(new Dimension(500, 19));
	  remeNome.setName("REME_NOME");
	  remeNome.setMinimumSize(new Dimension(500, 19));
	}
	return remeNome;
  }

  private UnJLabel getLbRemeEnd() {
	if (lbRemeEnd == null) {
	  lbRemeEnd = new UnJLabel();
	  lbRemeEnd.setText("Endere\u00E7o:");
	  lbRemeEnd.setPreferredSize(new Dimension(90, 19));
	  lbRemeEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeEnd;
  }

  private UnJLabel getRemeEnd() {
	if (remeEnd == null) {
	  remeEnd = new UnJLabel();
	  remeEnd.setPreferredSize(new Dimension(500, 19));
	  remeEnd.setName("REME_END");
	  remeEnd.setMinimumSize(new Dimension(500, 19));
	}
	return remeEnd;
  }

  private UnJLabel getLbRemeCid() {
	if (lbRemeCid == null) {
	  lbRemeCid = new UnJLabel();
	  lbRemeCid.setText("Cidade:");
	  lbRemeCid.setPreferredSize(new Dimension(90, 19));
	  lbRemeCid.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeCid;
  }

  private UnJLabel getRemeCid() {
	if (remeCid == null) {
	  remeCid = new UnJLabel();
	  remeCid.setPreferredSize(new Dimension(500, 19));
	  remeCid.setName("REME_CID");
	  remeCid.setMinimumSize(new Dimension(500, 19));
	}
	return remeCid;
  }

  private UnJLabel getLbDestinatario() {
	if (lbDestinatario == null) {
	  lbDestinatario = new UnJLabel();
	  lbDestinatario.setText("Destinat\u00E1rio");
	  lbDestinatario.setPreferredSize(new Dimension(100, 19));
	  lbDestinatario.setMinimumSize(new Dimension(100, 19));
	  lbDestinatario.setFont(new Font("Arial", Font.BOLD, 15));
	}
	return lbDestinatario;
  }

  private UnJLabel getLbDestNome() {
	if (lbDestNome == null) {
	  lbDestNome = new UnJLabel();
	  lbDestNome.setText("Raz\u00E3o Social:");
	  lbDestNome.setPreferredSize(new Dimension(90, 19));
	  lbDestNome.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestNome;
  }

  private UnJLabel getDestNome() {
	if (destNome == null) {
	  destNome = new UnJLabel();
	  destNome.setPreferredSize(new Dimension(500, 19));
	  destNome.setName("DEST_NOME");
	  destNome.setMinimumSize(new Dimension(500, 19));
	}
	return destNome;
  }

  private UnJLabel getLbDestDoc() {
	if (lbDestDoc == null) {
	  lbDestDoc = new UnJLabel();
	  lbDestDoc.setText("CPF/CNPJ:");
	  lbDestDoc.setPreferredSize(new Dimension(90, 19));
	  lbDestDoc.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestDoc;
  }

  private UnJLabel getDestDoc() {
	if (destDoc == null) {
	  destDoc = new UnJLabel();
	  destDoc.setPreferredSize(new Dimension(500, 19));
	  destDoc.setName("DEST_DOC");
	  destDoc.setMinimumSize(new Dimension(500, 19));
	}
	return destDoc;
  }

  private UnJLabel getLbDestEnd() {
	if (lbDestEnd == null) {
	  lbDestEnd = new UnJLabel();
	  lbDestEnd.setText("Endere\u00E7o:");
	  lbDestEnd.setPreferredSize(new Dimension(90, 19));
	  lbDestEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestEnd;
  }

  private UnJLabel getDestEnd() {
	if (destEnd == null) {
	  destEnd = new UnJLabel();
	  destEnd.setPreferredSize(new Dimension(500, 19));
	  destEnd.setName("DEST_END");
	  destEnd.setMinimumSize(new Dimension(500, 19));
	}
	return destEnd;
  }

  private UnJLabel getLbDestCid() {
	if (lbDestCid == null) {
	  lbDestCid = new UnJLabel();
	  lbDestCid.setText("Cidade:");
	  lbDestCid.setPreferredSize(new Dimension(90, 19));
	  lbDestCid.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestCid;
  }

  private UnJLabel getDestCid() {
	if (destCid == null) {
	  destCid = new UnJLabel();
	  destCid.setPreferredSize(new Dimension(500, 19));
	  destCid.setName("DEST_CID");
	  destCid.setMinimumSize(new Dimension(500, 19));
	}
	return destCid;
  }

  private UnJLabel getLbExpedidor() {
	if (lbExpedidor == null) {
	  lbExpedidor = new UnJLabel();
	  lbExpedidor.setText("Expedidor");
	  lbExpedidor.setPreferredSize(new Dimension(100, 19));
	  lbExpedidor.setMinimumSize(new Dimension(100, 19));
	  lbExpedidor.setFont(new Font("Arial", Font.BOLD, 15));
	}
	return lbExpedidor;
  }

  private UnJLabel getLbExpeNome() {
	if (lbExpeNome == null) {
	  lbExpeNome = new UnJLabel();
	  lbExpeNome.setText("Raz\u00E3o Social:");
	  lbExpeNome.setPreferredSize(new Dimension(90, 19));
	  lbExpeNome.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpeNome;
  }

  private UnJLabel getExpeNome() {
	if (expeNome == null) {
	  expeNome = new UnJLabel();
	  expeNome.setPreferredSize(new Dimension(500, 19));
	  expeNome.setName("EXPE_NOME");
	  expeNome.setMinimumSize(new Dimension(500, 19));
	}
	return expeNome;
  }

  private UnJLabel getLbExpeDoc() {
	if (lbExpeDoc == null) {
	  lbExpeDoc = new UnJLabel();
	  lbExpeDoc.setText("CPF/CNPJ:");
	  lbExpeDoc.setPreferredSize(new Dimension(90, 19));
	  lbExpeDoc.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpeDoc;
  }

  private UnJLabel getExpeDoc() {
	if (expeDoc == null) {
	  expeDoc = new UnJLabel();
	  expeDoc.setPreferredSize(new Dimension(500, 19));
	  expeDoc.setName("EXPE_DOC");
	  expeDoc.setMinimumSize(new Dimension(500, 19));
	}
	return expeDoc;
  }

  private UnJLabel getLbExpeEnd() {
	if (lbExpeEnd == null) {
	  lbExpeEnd = new UnJLabel();
	  lbExpeEnd.setText("Endere\u00E7o:");
	  lbExpeEnd.setPreferredSize(new Dimension(90, 19));
	  lbExpeEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpeEnd;
  }

  private UnJLabel getExpeEnd() {
	if (expeEnd == null) {
	  expeEnd = new UnJLabel();
	  expeEnd.setPreferredSize(new Dimension(500, 19));
	  expeEnd.setName("EXPE_END");
	  expeEnd.setMinimumSize(new Dimension(500, 19));
	}
	return expeEnd;
  }

  private UnJLabel getLbExpeCid() {
	if (lbExpeCid == null) {
	  lbExpeCid = new UnJLabel();
	  lbExpeCid.setText("Cidade:");
	  lbExpeCid.setPreferredSize(new Dimension(90, 19));
	  lbExpeCid.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpeCid;
  }

  private UnJLabel getExpeCid() {
	if (expeCid == null) {
	  expeCid = new UnJLabel();
	  expeCid.setPreferredSize(new Dimension(500, 19));
	  expeCid.setName("EXPE_CID");
	  expeCid.setMinimumSize(new Dimension(500, 19));
	}
	return expeCid;
  }

  private UnJLabel getLbRecebedor() {
	if (lbRecebedor == null) {
	  lbRecebedor = new UnJLabel();
	  lbRecebedor.setText("Recebedor");
	  lbRecebedor.setPreferredSize(new Dimension(100, 19));
	  lbRecebedor.setMinimumSize(new Dimension(100, 19));
	  lbRecebedor.setFont(new Font("Arial", Font.BOLD, 15));
	}
	return lbRecebedor;
  }

  private UnJLabel getLbReceNome() {
	if (lbReceNome == null) {
	  lbReceNome = new UnJLabel();
	  lbReceNome.setText("Raz\u00E3o Social:");
	  lbReceNome.setPreferredSize(new Dimension(90, 19));
	  lbReceNome.setMinimumSize(new Dimension(90, 19));
	}
	return lbReceNome;
  }

  private UnJLabel getReceNome() {
	if (receNome == null) {
	  receNome = new UnJLabel();
	  receNome.setPreferredSize(new Dimension(500, 19));
	  receNome.setName("RECE_NOME");
	  receNome.setMinimumSize(new Dimension(500, 19));
	}
	return receNome;
  }

  private UnJLabel getLbReceDoc() {
	if (lbReceDoc == null) {
	  lbReceDoc = new UnJLabel();
	  lbReceDoc.setText("CPF/CNPJ:");
	  lbReceDoc.setPreferredSize(new Dimension(90, 19));
	  lbReceDoc.setMinimumSize(new Dimension(90, 19));
	}
	return lbReceDoc;
  }

  private UnJLabel getReceDoc() {
	if (receDoc == null) {
	  receDoc = new UnJLabel();
	  receDoc.setPreferredSize(new Dimension(500, 19));
	  receDoc.setName("RECE_DOC");
	  receDoc.setMinimumSize(new Dimension(500, 19));
	}
	return receDoc;
  }

  private UnJLabel getLbReceEnd() {
	if (lbReceEnd == null) {
	  lbReceEnd = new UnJLabel();
	  lbReceEnd.setText("Endere\u00E7o:");
	  lbReceEnd.setPreferredSize(new Dimension(90, 19));
	  lbReceEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbReceEnd;
  }

  private UnJLabel getReceEnd() {
	if (receEnd == null) {
	  receEnd = new UnJLabel();
	  receEnd.setPreferredSize(new Dimension(500, 19));
	  receEnd.setName("RECE_END");
	  receEnd.setMinimumSize(new Dimension(500, 19));
	}
	return receEnd;
  }

  private UnJLabel getLbReceCid() {
	if (lbReceCid == null) {
	  lbReceCid = new UnJLabel();
	  lbReceCid.setText("Cidade:");
	  lbReceCid.setPreferredSize(new Dimension(90, 19));
	  lbReceCid.setMinimumSize(new Dimension(90, 19));
	}
	return lbReceCid;
  }

  private UnJLabel getReceCid() {
	if (receCid == null) {
	  receCid = new UnJLabel();
	  receCid.setPreferredSize(new Dimension(500, 19));
	  receCid.setName("RECE_CID");
	  receCid.setMinimumSize(new Dimension(500, 19));
	}
	return receCid;
  }

  private UnJLabel getLbDesDom() {
	if (lbDesDom == null) {
	  lbDesDom = new UnJLabel();
	  lbDesDom.setText("Mercadoria:");
	  lbDesDom.setPreferredSize(new Dimension(90, 19));
	  lbDesDom.setMinimumSize(new Dimension(90, 19));
	  lbDesDom.setForeground(Color.BLACK);
	}
	return lbDesDom;
  }

  private UnJLabel getDesDom() {
	if (desDom == null) {
	  desDom = new UnJLabel();
	  desDom.setHorizontalAlignment(SwingConstants.RIGHT);
	  desDom.setName("DESDOM");
	  desDom.setPreferredSize(new Dimension(130, 19));
	  desDom.setMinimumSize(new Dimension(130, 19));
	}
	return desDom;
  }

  private UnJLabel getLbPesoCarregado() {
	if (lbPesoCarregado == null) {
	  lbPesoCarregado = new UnJLabel();
	  lbPesoCarregado.setText("Peso Carregado:");
	  lbPesoCarregado.setPreferredSize(new Dimension(90, 19));
	  lbPesoCarregado.setMinimumSize(new Dimension(90, 19));
	  lbPesoCarregado.setForeground(Color.BLACK);
	}
	return lbPesoCarregado;
  }

  private UnJLabel getPesoCarregado() {
	if (pesoCarregado == null) {
	  pesoCarregado = new UnJLabel();
	  pesoCarregado.setHorizontalAlignment(SwingConstants.RIGHT);
	  pesoCarregado.setPreferredSize(new Dimension(130, 19));
	  pesoCarregado.setName("PESO_CARREGADO");
	  pesoCarregado.setMinimumSize(new Dimension(130, 19));
	}
	return pesoCarregado;
  }

  private UnJLabel getLbValOca() {
	if (lbValOca == null) {
	  lbValOca = new UnJLabel();
	  lbValOca.setText("Valor/Tonelada:");
	  lbValOca.setPreferredSize(new Dimension(90, 19));
	  lbValOca.setMinimumSize(new Dimension(90, 19));
	  lbValOca.setForeground(Color.BLACK);
	}
	return lbValOca;
  }

  private UnJLabel getLbCroRen() {
	if (lbCroRen == null) {
	  lbCroRen = new UnJLabel();
	  lbCroRen.setText("Rendimento Bruto:");
	  lbCroRen.setPreferredSize(new Dimension(90, 19));
	  lbCroRen.setMinimumSize(new Dimension(90, 19));
	  lbCroRen.setForeground(Color.BLACK);
	}
	return lbCroRen;
  }

  private editFormatado getValOca() {
	if (valOca == null) {
	  valOca = new editFormatado();
	  valOca.setCampoObrigatorio(false);
	  valOca.setTipoFormatacao(7);
	  valOca.setName("VALOCA");
	}
	return valOca;
  }

  private editFormatado getCroRen() {
	if (croRen == null) {
	  croRen = new editFormatado();
	  croRen.setCampoObrigatorio(false);
	  croRen.setTipoFormatacao(7);
	  croRen.setName("CROREN");
	}
	return croRen;
  }

  private UnJLabel getLbCroDes() {
	if (lbCroDes == null) {
	  lbCroDes = new UnJLabel();
	  lbCroDes.setText("Descontos:");
	  lbCroDes.setPreferredSize(new Dimension(90, 19));
	  lbCroDes.setMinimumSize(new Dimension(90, 19));
	  lbCroDes.setForeground(Color.BLACK);
	}
	return lbCroDes;
  }

  private editFormatado getCroDes() {
	if (croDes == null) {
	  croDes = new editFormatado();
	  croDes.setCampoObrigatorio(false);
	  croDes.setTipoFormatacao(7);
	  croDes.setName("CRODES");
	}
	return croDes;
  }

  private UnJLabel getLbCroPed() {
	if (lbCroPed == null) {
	  lbCroPed = new UnJLabel();
	  lbCroPed.setText("Ped\u00E1gio:");
	  lbCroPed.setPreferredSize(new Dimension(90, 19));
	  lbCroPed.setMinimumSize(new Dimension(90, 19));
	  lbCroPed.setForeground(Color.BLACK);
	}
	return lbCroPed;
  }

  private editFormatado getCroPed() {
	if (croPed == null) {
	  croPed = new editFormatado();
	  croPed.setCampoObrigatorio(false);
	  croPed.setTipoFormatacao(7);
	  croPed.setName("CROPED");
	}
	return croPed;
  }

  private UnJLabel getLbPerInsValIns() {
	if (lbPerInsValIns == null) {
	  lbPerInsValIns = new UnJLabel();
	  lbPerInsValIns.setText("INSS:");
	  lbPerInsValIns.setPreferredSize(new Dimension(90, 19));
	  lbPerInsValIns.setMinimumSize(new Dimension(90, 19));
	  lbPerInsValIns.setForeground(Color.BLACK);
	}
	return lbPerInsValIns;
  }

  private editFormatado getPerIns() {
	if (perIns == null) {
	  perIns = new editFormatado();
	  perIns.setCampoObrigatorio(false);
	  perIns.setTipoFormatacao(7);
	  perIns.setName("PERINS");
	  perIns.setText(" R$ 0,00 ");
	}
	return perIns;
  }

  private editFormatado getValIns() {
	if (valIns == null) {
	  valIns = new editFormatado();
	  valIns.setCampoObrigatorio(false);
	  valIns.setTipoFormatacao(7);
	  valIns.setName("VALINS");
	}
	return valIns;
  }

  private UnJLabel getLbCroImr() {
	if (lbCroImr == null) {
	  lbCroImr = new UnJLabel();
	  lbCroImr.setText("I.R.:");
	  lbCroImr.setPreferredSize(new Dimension(90, 19));
	  lbCroImr.setMinimumSize(new Dimension(90, 19));
	  lbCroImr.setForeground(Color.BLACK);
	}
	return lbCroImr;
  }

  private editFormatado getCroImr() {
	if (croImr == null) {
	  croImr = new editFormatado();
	  croImr.setCampoObrigatorio(false);
	  croImr.setTipoFormatacao(7);
	  croImr.setName("CROIMR");
	}
	return croImr;
  }

  private UnJLabel getLbTotAdt() {
	if (lbTotAdt == null) {
	  lbTotAdt = new UnJLabel();
	  lbTotAdt.setText("Total Adiantamento:");
	  lbTotAdt.setPreferredSize(new Dimension(110, 19));
	  lbTotAdt.setMinimumSize(new Dimension(110, 19));
	  lbTotAdt.setForeground(Color.BLACK);
	}
	return lbTotAdt;
  }

  private editFormatado getTotAdt() {
	if (totAdt == null) {
	  totAdt = new editFormatado();
	  totAdt.setCampoObrigatorio(false);
	  totAdt.setTipoFormatacao(7);
	  totAdt.setName("TOTADT");
	}
	return totAdt;
  }

  private UnJLabel getLbCroOcr() {
	if (lbCroOcr == null) {
	  lbCroOcr = new UnJLabel();
	  lbCroOcr.setText("Outros Cr\u00E9ditos:");
	  lbCroOcr.setPreferredSize(new Dimension(110, 19));
	  lbCroOcr.setMinimumSize(new Dimension(110, 19));
	  lbCroOcr.setForeground(Color.BLACK);
	}
	return lbCroOcr;
  }

  private editFormatado getCroOcr() {
	if (croOcr == null) {
	  croOcr = new editFormatado();
	  croOcr.setCampoObrigatorio(false);
	  croOcr.setTipoFormatacao(7);
	  croOcr.setName("CROOCR");
	}
	return croOcr;
  }

  private UnJLabel getLbCroOde() {
	if (lbCroOde == null) {
	  lbCroOde = new UnJLabel();
	  lbCroOde.setText("Outros D\u00E9bitos:");
	  lbCroOde.setPreferredSize(new Dimension(110, 19));
	  lbCroOde.setMinimumSize(new Dimension(110, 19));
	  lbCroOde.setForeground(Color.BLACK);
	}
	return lbCroOde;
  }

  private editFormatado getCroOde() {
	if (croOde == null) {
	  croOde = new editFormatado();
	  croOde.setCampoObrigatorio(false);
	  croOde.setTipoFormatacao(7);
	  croOde.setName("CROOCR");
	}
	return croOde;
  }

  private UnJLabel getLbCroSeg() {
	if (lbCroSeg == null) {
	  lbCroSeg = new UnJLabel();
	  lbCroSeg.setText("Seguro:");
	  lbCroSeg.setPreferredSize(new Dimension(110, 19));
	  lbCroSeg.setMinimumSize(new Dimension(110, 19));
	  lbCroSeg.setForeground(Color.BLACK);
	}
	return lbCroSeg;
  }

  private editFormatado getCroSeg() {
	if (croSeg == null) {
	  croSeg = new editFormatado();
	  croSeg.setCampoObrigatorio(false);
	  croSeg.setTipoFormatacao(7);
	  croSeg.setName("CROSEG");
	}
	return croSeg;
  }

  private UnJLabel getLbTotalSaldo() {
	if (lbTotalSaldo == null) {
	  lbTotalSaldo = new UnJLabel();
	  lbTotalSaldo.setText("Total de Saldo:");
	  lbTotalSaldo.setPreferredSize(new Dimension(110, 19));
	  lbTotalSaldo.setMinimumSize(new Dimension(110, 19));
	  lbTotalSaldo.setForeground(Color.BLACK);
	}
	return lbTotalSaldo;
  }

  private UnJLabel getTotalSaldo() {
	if (totalSaldo == null) {
	  totalSaldo = new UnJLabel();
	  totalSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
	  totalSaldo.setPreferredSize(new Dimension(130, 19));
	  totalSaldo.setName("TOTAL_SALDO");
	  totalSaldo.setMinimumSize(new Dimension(130, 19));
	}
	return totalSaldo;
  }

  private UnJLabel getLbTotalLiquido() {
	if (lbTotalLiquido == null) {
	  lbTotalLiquido = new UnJLabel();
	  lbTotalLiquido.setText("Total L\u00EDquido:");
	  lbTotalLiquido.setPreferredSize(new Dimension(110, 19));
	  lbTotalLiquido.setMinimumSize(new Dimension(110, 19));
	  lbTotalLiquido.setForeground(Color.BLACK);
	}
	return lbTotalLiquido;
  }

  private UnJLabel getLbPer() {
	if (lbPer == null) {
	  lbPer = new UnJLabel();
	  lbPer.setText("%");
	}
	return lbPer;
  }

  private UnJLabel getTotalLiquido() {
	if (totalLiquido == null) {
	  totalLiquido = new UnJLabel();
	  totalLiquido.setHorizontalAlignment(SwingConstants.RIGHT);
	  totalLiquido.setPreferredSize(new Dimension(130, 19));
	  totalLiquido.setName("TOTAL_LIQUIDO");
	  totalLiquido.setMinimumSize(new Dimension(130, 19));
	}
	return totalLiquido;
  }

  public boolean montaTela(String codigo) {

	if (getEmpCod().isVazio() || getFilCod().isVazio() || getCteCod().isVazio()
		|| !getCteCod().isVazio() && TrataString.isNullOrVazia(codigo)) {
	  limpaTela();
	  return false;
	}

	try {

	  String query = "select EMPCOD, FILCOD, CTECOD, CLICOD, CLICODDES, CLICODCNP, CLICODEND, VEIPLA, VEIRB1, VEIRB2, VEIRB3, MOTNOM, MOTCPF, VALOCA, CROREN, CRODES, CROPED, SESSEN, "
		  + "PERINS, VALINS, CROIMR, TOTADT, CROOCR, CROODE, CROSEG, CROEST, OBSGER, OBSGERDES, CROTMP, TOTAL_SALDO, TOTAL_LIQUIDO, PEDNFF, PEDDNF, RESP_PAGAMENTO, PREVISAO_ENTREGA, REME_NOME, "
		  + "REME_DOC, REME_END, REME_CID, DEST_NOME, DEST_DOC, DEST_END, DEST_CID, EXPE_NOME, EXPE_DOC, EXPE_END, EXPE_CID, RECE_NOME, RECE_DOC, RECE_END, RECE_CID, NFES, CTES, DESDOM, PESO_CARREGADO, "
		  + "RESP_PAGAMENTO, PREVISAO_ENTREGA, CROEST, NFES, CTES "
		  + "from ES_VIEW_CONTRATO_RODOVIARIO where empcod = '" + getEmpCod().getText()
		  + "' and filcod = " + getFilCod().getText() + " and ctecod = " + codigo;
	  res = getSelecao().executeQuery(query);

	  if (res.next()) {
		setAcaoTela("A");
		limpaTela();
		CompTelas.montaCamposResultSet(res, getPanelServicoRealizado(), false);
		CompTelas.montaCamposResultSet(res, getPanelCamposSup(), false);
		CompTelas.montaCamposResultSet(res, getPanelCondicoesEspecificas(), false);
		getNfes().setText(TrataString.insereQuebraLinha(res.getString("NFES")));
		getCtes().setText(TrataString.insereQuebraLinha(res.getString("CTES")));
		setMensagemExclusao("Tem certeza que deseja excluir O REGISTRO: \n ->> " + codigo + " ?");

	  }
	  else {
		setAcaoTela("I");
		limpaTela();
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

  private UnJLabel getPedNff() {
	if (pedNff == null) {
	  pedNff = new UnJLabel();
	  pedNff.setName("PEDNFF");
	}
	return pedNff;
  }

  private UnJLabel getPedDnf() {
	if (pedDnf == null) {
	  pedDnf = new UnJLabel();
	  pedDnf.setName("PEDDNF");
	}
	return pedDnf;
  }

  public boolean limpaTela() {

	super.limpaTela();
	CompTelas.limparCampos(getPanelServicoRealizado(), false);
	limpaCamposCondicaoEspecifica();
	limpaCamposServicoRealizado();
	limpaCamposSup();

	return true;
  }

  public boolean limpaCamposServicoRealizado() {

	CompTelas.limparCampos(getPanelServicoRealizado(), false);
	getRemeNome().setText("");
	getRemeDoc().setText("");
	getRemeEnd().setText("");
	getRemeCid().setText("");
	getDestNome().setText("");
	getDestDoc().setText("");
	getDestEnd().setText("");
	getDestCid().setText("");
	getExpeNome().setText("");
	getExpeDoc().setText("");
	getExpeEnd().setText("");
	getExpeCid().setText("");
	getReceNome().setText("");
	getReceDoc().setText("");
	getReceEnd().setText("");
	getReceCid().setText("");
	getDesDom().setText("");
	getPesoCarregado().setText("");
	getTotalSaldo().setText("");
	getTotalLiquido().setText("");

	return true;
  }

  public boolean limpaCamposSup() {

	CompTelas.limparCampos(getPanelCamposSup(), false);
	getPedNff().setText("");
	getPedDnf().setText("");
	getCliCodCnp().setText("");
	getCliCodEnd().setText("");

	return true;
  }

  public boolean limpaCamposCondicaoEspecifica() {

	CompTelas.limparCampos(getPanelCondicoesEspecificas(), false);
	getRespPagamento().setText("");
	getPrevisaoEntrega().setText("");

	return true;
  }

  private JPanel getPanelCondicoesEspecificas() {
	if (panelCondicoesEspecificas == null) {
	  panelCondicoesEspecificas = new JPanel();
	  GridBagLayout gbl_panelCondicoesEspecificas = new GridBagLayout();
	  gbl_panelCondicoesEspecificas.columnWidths = new int[] { 0, 0, 0, 34, 0, 0 };
	  gbl_panelCondicoesEspecificas.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCondicoesEspecificas.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
		  Double.MIN_VALUE };
	  gbl_panelCondicoesEspecificas.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
		  Double.MIN_VALUE };
	  panelCondicoesEspecificas.setLayout(gbl_panelCondicoesEspecificas);
	  GridBagConstraints gbc_lbRespPagamento = new GridBagConstraints();
	  gbc_lbRespPagamento.fill = GridBagConstraints.BOTH;
	  gbc_lbRespPagamento.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRespPagamento.gridx = 0;
	  gbc_lbRespPagamento.gridy = 0;
	  panelCondicoesEspecificas.add(getLbRespPagamento(), gbc_lbRespPagamento);
	  GridBagConstraints gbc_respPagamento = new GridBagConstraints();
	  gbc_respPagamento.gridwidth = 3;
	  gbc_respPagamento.insets = new Insets(2, 3, 0, 0);
	  gbc_respPagamento.fill = GridBagConstraints.BOTH;
	  gbc_respPagamento.gridx = 1;
	  gbc_respPagamento.gridy = 0;
	  panelCondicoesEspecificas.add(getRespPagamento(), gbc_respPagamento);
	  GridBagConstraints gbc_lbPrevisaoEntrega = new GridBagConstraints();
	  gbc_lbPrevisaoEntrega.fill = GridBagConstraints.BOTH;
	  gbc_lbPrevisaoEntrega.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPrevisaoEntrega.gridx = 0;
	  gbc_lbPrevisaoEntrega.gridy = 1;
	  panelCondicoesEspecificas.add(getLbPrevisaoEntrega(), gbc_lbPrevisaoEntrega);
	  GridBagConstraints gbc_previsaoEntrega = new GridBagConstraints();
	  gbc_previsaoEntrega.gridwidth = 3;
	  gbc_previsaoEntrega.fill = GridBagConstraints.BOTH;
	  gbc_previsaoEntrega.insets = new Insets(2, 3, 0, 0);
	  gbc_previsaoEntrega.gridx = 1;
	  gbc_previsaoEntrega.gridy = 1;
	  panelCondicoesEspecificas.add(getPrevisaoEntrega(), gbc_previsaoEntrega);
	  GridBagConstraints gbc_lbCroEst = new GridBagConstraints();
	  gbc_lbCroEst.anchor = GridBagConstraints.EAST;
	  gbc_lbCroEst.fill = GridBagConstraints.VERTICAL;
	  gbc_lbCroEst.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroEst.gridx = 0;
	  gbc_lbCroEst.gridy = 2;
	  panelCondicoesEspecificas.add(getLbCroEst(), gbc_lbCroEst);
	  GridBagConstraints gbc_croEst = new GridBagConstraints();
	  gbc_croEst.gridwidth = 3;
	  gbc_croEst.insets = new Insets(2, 3, 0, 0);
	  gbc_croEst.fill = GridBagConstraints.BOTH;
	  gbc_croEst.gridx = 1;
	  gbc_croEst.gridy = 2;
	  panelCondicoesEspecificas.add(getCroEst(), gbc_croEst);
	  GridBagConstraints gbc_lbObsGer = new GridBagConstraints();
	  gbc_lbObsGer.fill = GridBagConstraints.BOTH;
	  gbc_lbObsGer.insets = new Insets(2, 3, 0, 0);
	  gbc_lbObsGer.gridx = 0;
	  gbc_lbObsGer.gridy = 3;
	  panelCondicoesEspecificas.add(getLbObsGer(), gbc_lbObsGer);
	  GridBagConstraints gbc_obsGer = new GridBagConstraints();
	  gbc_obsGer.insets = new Insets(2, 3, 0, 0);
	  gbc_obsGer.gridwidth = 2;
	  gbc_obsGer.fill = GridBagConstraints.BOTH;
	  gbc_obsGer.gridx = 1;
	  gbc_obsGer.gridy = 3;
	  panelCondicoesEspecificas.add(getObsGer(), gbc_obsGer);
	  GridBagConstraints gbc_lbDescObsGer = new GridBagConstraints();
	  gbc_lbDescObsGer.fill = GridBagConstraints.BOTH;
	  gbc_lbDescObsGer.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescObsGer.gridwidth = 2;
	  gbc_lbDescObsGer.gridx = 3;
	  gbc_lbDescObsGer.gridy = 3;
	  panelCondicoesEspecificas.add(getLbDescObsGer(), gbc_lbDescObsGer);
	  GridBagConstraints gbc_lbNfes = new GridBagConstraints();
	  gbc_lbNfes.fill = GridBagConstraints.BOTH;
	  gbc_lbNfes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbNfes.gridx = 0;
	  gbc_lbNfes.gridy = 4;
	  panelCondicoesEspecificas.add(getLbNfes(), gbc_lbNfes);
	  GridBagConstraints gbc_nfes = new GridBagConstraints();
	  gbc_nfes.anchor = GridBagConstraints.WEST;
	  gbc_nfes.insets = new Insets(2, 3, 0, 3);
	  gbc_nfes.gridwidth = 4;
	  gbc_nfes.fill = GridBagConstraints.VERTICAL;
	  gbc_nfes.gridx = 1;
	  gbc_nfes.gridy = 4;
	  panelCondicoesEspecificas.add(getNfes(), gbc_nfes);
	  GridBagConstraints gbc_lbCtes = new GridBagConstraints();
	  gbc_lbCtes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCtes.fill = GridBagConstraints.BOTH;
	  gbc_lbCtes.gridx = 0;
	  gbc_lbCtes.gridy = 5;
	  panelCondicoesEspecificas.add(getLbCtes(), gbc_lbCtes);
	  GridBagConstraints gbc_ctes = new GridBagConstraints();
	  gbc_ctes.anchor = GridBagConstraints.WEST;
	  gbc_ctes.insets = new Insets(2, 3, 2, 3);
	  gbc_ctes.gridwidth = 4;
	  gbc_ctes.fill = GridBagConstraints.VERTICAL;
	  gbc_ctes.gridx = 1;
	  gbc_ctes.gridy = 5;
	  panelCondicoesEspecificas.add(getCtes(), gbc_ctes);
	}
	return panelCondicoesEspecificas;
  }

  private UnJLabel getLbRespPagamento() {
	if (lbRespPagamento == null) {
	  lbRespPagamento = new UnJLabel();
	  lbRespPagamento.setText("O Pagamento de Descarga fica a:");
	  lbRespPagamento.setPreferredSize(new Dimension(200, 19));
	  lbRespPagamento.setMinimumSize(new Dimension(200, 19));
	  lbRespPagamento.setForeground(Color.BLACK);
	}
	return lbRespPagamento;
  }

  private UnJLabel getRespPagamento() {
	if (respPagamento == null) {
	  respPagamento = new UnJLabel();
	  respPagamento.setName("RESP_PAGAMENTO");
	  respPagamento.setPreferredSize(new Dimension(120, 19));
	  respPagamento.setMinimumSize(new Dimension(120, 19));
	}
	return respPagamento;
  }

  private UnJLabel getLbPrevisaoEntrega() {
	if (lbPrevisaoEntrega == null) {
	  lbPrevisaoEntrega = new UnJLabel();
	  lbPrevisaoEntrega.setText("Agendamento da Descarga para:");
	  lbPrevisaoEntrega.setPreferredSize(new Dimension(200, 19));
	  lbPrevisaoEntrega.setMinimumSize(new Dimension(200, 19));
	  lbPrevisaoEntrega.setForeground(Color.BLACK);
	}
	return lbPrevisaoEntrega;
  }

  private UnJLabel getPrevisaoEntrega() {
	if (previsaoEntrega == null) {
	  previsaoEntrega = new UnJLabel();
	  previsaoEntrega.setPreferredSize(new Dimension(120, 19));
	  previsaoEntrega.setName("PREVISAO_ENTREGA");
	  previsaoEntrega.setMinimumSize(new Dimension(120, 19));
	}
	return previsaoEntrega;
  }

  private UnJLabel getLbCroEst() {
	if (lbCroEst == null) {
	  lbCroEst = new UnJLabel();
	  lbCroEst.setText("Fra\u00E7\u00E3o de Estadia:");
	  lbCroEst.setPreferredSize(new Dimension(200, 19));
	  lbCroEst.setMinimumSize(new Dimension(200, 19));
	  lbCroEst.setForeground(Color.BLACK);
	}
	return lbCroEst;
  }

  private editFormatado getCroEst() {
	if (croEst == null) {
	  croEst = new editFormatado();
	  croEst.setCampoObrigatorio(false);
	  croEst.setTipoFormatacao(7);
	  croEst.setName("CROEST");
	}
	return croEst;
  }

  private UnJLabel getLbNfes() {
	if (lbNfes == null) {
	  lbNfes = new UnJLabel();
	  lbNfes.setHorizontalAlignment(SwingConstants.LEFT);
	  lbNfes.setVerticalAlignment(SwingConstants.TOP);
	  lbNfes.setText("Notas Fiscais:");
	  lbNfes.setPreferredSize(new Dimension(200, 19));
	  lbNfes.setMinimumSize(new Dimension(200, 19));
	  lbNfes.setForeground(Color.BLACK);
	}
	return lbNfes;
  }

  private UnJLabel getLbCtes() {
	if (lbCtes == null) {
	  lbCtes = new UnJLabel();
	  lbCtes.setVerticalAlignment(SwingConstants.TOP);
	  lbCtes.setText("Conhecimentos Transportes:");
	  lbCtes.setPreferredSize(new Dimension(200, 19));
	  lbCtes.setMinimumSize(new Dimension(200, 19));
	  lbCtes.setForeground(Color.BLACK);
	}
	return lbCtes;
  }

  public boolean gravaTela() {

	if (validaTela() == false) {
	  return false;
	}

	try {

	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_CONTRATO_RODOVIARIO", 25, 2));

	  int param = 1;

	  getProc().setStp(stp);
	  stp.registerOutParameter(param++, java.sql.Types.INTEGER);
	  stp.registerOutParameter(param++, java.sql.Types.VARCHAR);

	  getProc().setString(param++, getEmpCod(), stp);
	  getProc().setShort(param++, getFilCod(), stp);
	  getProc().setInt(param++, getCteCod(), stp);
	  getProc().setInt(param++, getCliCod(), stp);
	  getProc().setString(param++, getVeiPla(), stp);
	  getProc().setString(param++, getVeiRB1(), stp);
	  getProc().setString(param++, getVeiRB2(), stp);
	  getProc().setString(param++, getVeiRB3(), stp);
	  getProc().setDouble(param++, getValOca(), stp);
	  getProc().setDouble(param++, getCroRen(), stp);
	  getProc().setDouble(param++, getCroDes(), stp);
	  getProc().setDouble(param++, getCroPed(), stp);
	  getProc().setDouble(param++, getSesSen(), stp);
	  getProc().setDouble(param++, getPerIns(), stp);
	  getProc().setDouble(param++, getValIns(), stp);
	  getProc().setDouble(param++, getCroImr(), stp);
	  getProc().setDouble(param++, getTotAdt(), stp);
	  getProc().setDouble(param++, getCroOcr(), stp);
	  getProc().setDouble(param++, getCroOde(), stp);
	  getProc().setDouble(param++, getCroSeg(), stp);
	  getProc().setDouble(param++, getCroEst(), stp);
	  getProc().setShort(param++, getObsGer(), stp);
	  getProc().setString(param++, getMotNom(), stp);
	  getProc().setString(param++, getMotCpf(), stp);
	  getProc().setString(param++, getAcaoTela(), stp);

	  stp.execute();
	  getProc().finalizarProcedure(stp, 1, 2);
	  setMensagem(getProc().getProcedureMensagem());

	  if (getProc().getProcedureProcesso() == 0) {
		mostraMensagem(getProc().getProcedureMensagem());
		return false;
	  }

	  if (getAcaoTela().equalsIgnoreCase("E")) {
		limpaTela();
		getCteCod().requestFocus();
	  }
	  else if (getAcaoTela().equalsIgnoreCase("I")) {
		getCteCod().setEnabled(true);
		getCteCod().setText(String.valueOf(getProc().getProcedureProcesso()));
		getCteCod().requestFocus();
	  }
	  else {
		getCteCod().requestFocus();
	  }

	  montaTela(getCteCod().getText());
	  getCteCod().requestFocus();

	} catch (SQLException sqlEx) {
	  getErro().setErro(sqlEx);
	  return false;
	} catch (Exception ex) {
	  getErro().setErro(ex);
	  return false;
	}

	return true;
  }

  public boolean validaTela() {

	if (CompTelas.validaTelaAutomatico(getPanelCamposSup(), false) == false) {
	  return false;
	}

	else if (CompTelas.validaTelaAutomatico(getPanelServicoRealizado(), false) == false) {
	  getOrelhas().setSelectedComponent(getPanelServicoRealizado());
	  return false;
	}

	else if (CompTelas.validaTelaAutomatico(getPanelCondicoesEspecificas(), false) == false) {
	  getOrelhas().setSelectedComponent(getPanelCondicoesEspecificas());
	  return false;
	}

	return true;

  }

  private UnJLabel getLbSesSen() {
	if (lbSesSen == null) {
	  lbSesSen = new UnJLabel();
	  lbSesSen.setText("SEST/SENAN:");
	  lbSesSen.setPreferredSize(new Dimension(90, 19));
	  lbSesSen.setMinimumSize(new Dimension(90, 19));
	  lbSesSen.setForeground(Color.BLACK);
	}
	return lbSesSen;
  }

  private editFormatado getSesSen() {
	if (sesSen == null) {
	  sesSen = new editFormatado();
	  sesSen.setTipoFormatacao(7);
	  sesSen.setName("SESSEN");
	  sesSen.setCampoObrigatorio(false);
	}
	return sesSen;
  }

  private UnJLabel getLbObsGer() {
	if (lbObsGer == null) {
	  lbObsGer = new UnJLabel();
	  lbObsGer.setText("Condi\u00E7\u00F5es Gerais:");
	  lbObsGer.setPreferredSize(new Dimension(200, 19));
	  lbObsGer.setMinimumSize(new Dimension(200, 19));
	  lbObsGer.setForeground(Color.BLACK);
	}
	return lbObsGer;
  }

  private EditPratic getObsGer() {
	if (obsGer == null) {
	  obsGer = new EditPratic();
	  obsGer.setTipoValidacao("observacoes");
	  obsGer.setPreferredSize(new Dimension(50, 19));
	  obsGer.setName("OBSGER");
	  obsGer.setMinimumSize(new Dimension(50, 19));
	  obsGer.setHorizontalAlignment(SwingConstants.CENTER);
	  obsGer.setLabelDescricao(getLbDescObsGer());
	}
	return obsGer;
  }

  private UnJLabel getLbDescObsGer() {
	if (lbDescObsGer == null) {
	  lbDescObsGer = new UnJLabel();
	  lbDescObsGer.setFont(new Font("Arial", Font.BOLD, 12));
	  lbDescObsGer.setName("OBSGERDES");
	}
	return lbDescObsGer;
  }

  private editFormatado getMotCpf() {
	if (motCpf == null) {
	  motCpf = new editFormatado();
	  motCpf.setTipoFormatacao(6);
	  motCpf.setCampoObrigatorio(false);
	  motCpf.setName("MOTCPF");
	}
	return motCpf;
  }

  private UnJTextArea getNfes() {
	if (nfes == null) {
	  nfes = new UnJTextArea();
	  nfes.setEditable(false);
	  nfes.setBackground(Color.LIGHT_GRAY);
	  nfes.setPreferredSize(new Dimension(470, 100));
	  nfes.setName("NFES");
	  nfes.setMinimumSize(new Dimension(470, 100));
	}
	return nfes;
  }

  private UnJTextArea getCtes() {
	if (ctes == null) {
	  ctes = new UnJTextArea();
	  ctes.setEditable(false);
	  ctes.setBackground(Color.LIGHT_GRAY);
	  ctes.setName("CTES");
	  ctes.setMinimumSize(new Dimension(470, 100));
	  ctes.setPreferredSize(new Dimension(470, 100));
	}
	return ctes;
  }
}
