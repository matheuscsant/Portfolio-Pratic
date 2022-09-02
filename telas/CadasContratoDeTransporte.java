package br.com.praticsistemas.pratic.faturamento.cadastros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
  private UnJLabel lbMotNom;
  private EditPratic motNom;
  private UnJLabel lbMotCpf;
  private UnJLabel remeteCliCnp;
  private UnJLabel remeteCliEnd;
  private UnJLabel remeteMunNom;
  private UnJLabel lbDesDom;
  private UnJLabel lbPesoCarregado;
  private UnJLabel pesoTonelada;
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
  private UnJLabel tomTipDes;
  private UnJLabel lbPrevisaoEntrega;
  private UnJLabel pedPtr;
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
  private JPanel panelRemetente;
  private UnJLabel lbRemeteCliRaz;
  private UnJLabel lbRemeteCliCnp;
  private UnJLabel lbRemeteCliEnd;
  private UnJLabel lbRemeMunNom;
  private JPanel panelRecebedor;
  private UnJLabel lbRecebeCliRaz;
  private UnJLabel recebeCliRaz;
  private UnJLabel lbRecebeCliCnp;
  private UnJLabel recebeCliCnp;
  private UnJLabel lbRecebeCliEnd;
  private UnJLabel recebeCliEnd;
  private UnJLabel lbRecebeMunNom;
  private UnJLabel recebeMunNom;
  private JPanel panelExpedidor;
  private UnJLabel lbExpediCliRaz;
  private UnJLabel lbExpediCliCnp;
  private UnJLabel lbExpediCliEnd;
  private UnJLabel lbExpediMunNom;
  private UnJLabel expediCliRaz;
  private UnJLabel expediCliCnp;
  private UnJLabel expediCliEnd;
  private JPanel panelDestinatario;
  private UnJLabel lbDestinCliRaz;
  private UnJLabel lbDestinCliCnp;
  private UnJLabel lbDestinCliEnd;
  private UnJLabel lbDestinMunNom;
  private UnJLabel destinCliEnd;
  private UnJLabel destinMunNom;
  private UnJLabel destinCliCnp;
  private UnJLabel destinCliRaz;
  private UnJLabel remeteCliRaz;
  private UnJLabel ExpediMunNom;
  private UnJLabel desDom;
  private JPanel panelValoresServRealizado;
  private JPanel panelMercadoria;
  private JScrollPane rolagemCorpo;

  public CadasContratoDeTransporte() {

	initialize();

  }

  private void initialize() {
	this.setCampoChaveTelaEstrangeiro(true);
	this.getAutoscrolls();
	this.setCampoTelaTrabalho(getCteCod());
	this.setCampoFocoAberturaTela(getCteCod());
	this.setTitle("Cadastro de Contrato de Transporte");
	this.setResizable(true);
	this.setCodigoTela("4311");
	this.setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_CONTRATO_RODOVIARIO");
	this.setSize(new Dimension(1030, 740));
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasContratoDeTransporte = null;
	  }
	});
	getBtnImprimir().addMouseListener(new MouseAdapter() {
	  @Override
	  public void mouseClicked(MouseEvent e) {
		DeskPratic.telasFinan.abrirEmitirContratoDeTransporte();
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

  private JPanel getPanelCamposSup() {
	if (panelCamposSup == null) {
	  panelCamposSup = new JPanel();
	  panelCamposSup.setBorder(new TitledBorder(
		  new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
		  "Campos Cadastro de Contrato de Transporte", TitledBorder.LEADING, TitledBorder.TOP, null,
		  Color.RED));
	  GridBagLayout gbl_panelCamposSup = new GridBagLayout();
	  gbl_panelCamposSup.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelCamposSup.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
	  gbl_panelCamposSup.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
	  gbc_pedNff.gridwidth = 3;
	  gbc_pedNff.gridx = 4;
	  gbc_pedNff.gridy = 0;
	  panelCamposSup.add(getPedNff(), gbc_pedNff);
	  GridBagConstraints gbc_lbPedDnf = new GridBagConstraints();
	  gbc_lbPedDnf.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPedDnf.anchor = GridBagConstraints.EAST;
	  gbc_lbPedDnf.gridx = 7;
	  gbc_lbPedDnf.gridy = 0;
	  panelCamposSup.add(getLbPedDnf(), gbc_lbPedDnf);
	  GridBagConstraints gbc_pedDnf = new GridBagConstraints();
	  gbc_pedDnf.insets = new Insets(2, 3, 0, 0);
	  gbc_pedDnf.gridwidth = 3;
	  gbc_pedDnf.fill = GridBagConstraints.BOTH;
	  gbc_pedDnf.gridx = 8;
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
	  gbc_cliCodDes.gridwidth = 10;
	  gbc_cliCodDes.gridx = 3;
	  gbc_cliCodDes.gridy = 1;
	  panelCamposSup.add(getCliCodDes(), gbc_cliCodDes);
	  GridBagConstraints gbc_lbCliCodCnp = new GridBagConstraints();
	  gbc_lbCliCodCnp.fill = GridBagConstraints.BOTH;
	  gbc_lbCliCodCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCliCodCnp.gridx = 13;
	  gbc_lbCliCodCnp.gridy = 1;
	  panelCamposSup.add(getLbCliCodCnp(), gbc_lbCliCodCnp);
	  GridBagConstraints gbc_cliCodCnp = new GridBagConstraints();
	  gbc_cliCodCnp.gridwidth = 2;
	  gbc_cliCodCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_cliCodCnp.fill = GridBagConstraints.BOTH;
	  gbc_cliCodCnp.gridx = 14;
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
	  gbc_cliCodEnd.gridwidth = 15;
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
	  gbc_lbVeiRB1.gridwidth = 2;
	  gbc_lbVeiRB1.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB1.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB1.gridx = 3;
	  gbc_lbVeiRB1.gridy = 3;
	  panelCamposSup.add(getLbVeiRB1(), gbc_lbVeiRB1);
	  GridBagConstraints gbc_veiRB1 = new GridBagConstraints();
	  gbc_veiRB1.gridwidth = 2;
	  gbc_veiRB1.anchor = GridBagConstraints.WEST;
	  gbc_veiRB1.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB1.gridx = 5;
	  gbc_veiRB1.gridy = 3;
	  panelCamposSup.add(getVeiRB1(), gbc_veiRB1);
	  GridBagConstraints gbc_lbVeiRB2 = new GridBagConstraints();
	  gbc_lbVeiRB2.gridwidth = 2;
	  gbc_lbVeiRB2.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB2.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB2.gridx = 7;
	  gbc_lbVeiRB2.gridy = 3;
	  panelCamposSup.add(getLbVeiRB2(), gbc_lbVeiRB2);
	  GridBagConstraints gbc_veiRB2 = new GridBagConstraints();
	  gbc_veiRB2.fill = GridBagConstraints.BOTH;
	  gbc_veiRB2.gridwidth = 2;
	  gbc_veiRB2.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB2.gridx = 9;
	  gbc_veiRB2.gridy = 3;
	  panelCamposSup.add(getVeiRB2(), gbc_veiRB2);
	  GridBagConstraints gbc_lbVeiRB3 = new GridBagConstraints();
	  gbc_lbVeiRB3.insets = new Insets(2, 3, 0, 0);
	  gbc_lbVeiRB3.fill = GridBagConstraints.BOTH;
	  gbc_lbVeiRB3.gridwidth = 2;
	  gbc_lbVeiRB3.gridx = 11;
	  gbc_lbVeiRB3.gridy = 3;
	  panelCamposSup.add(getLbVeiRB3(), gbc_lbVeiRB3);
	  GridBagConstraints gbc_veiRB3 = new GridBagConstraints();
	  gbc_veiRB3.gridwidth = 2;
	  gbc_veiRB3.insets = new Insets(2, 3, 0, 0);
	  gbc_veiRB3.fill = GridBagConstraints.HORIZONTAL;
	  gbc_veiRB3.gridx = 13;
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
	  gbc_motNom.gridwidth = 12;
	  gbc_motNom.fill = GridBagConstraints.HORIZONTAL;
	  gbc_motNom.gridx = 1;
	  gbc_motNom.gridy = 4;
	  panelCamposSup.add(getMotNom(), gbc_motNom);
	  GridBagConstraints gbc_lbMotCpf = new GridBagConstraints();
	  gbc_lbMotCpf.anchor = GridBagConstraints.EAST;
	  gbc_lbMotCpf.fill = GridBagConstraints.VERTICAL;
	  gbc_lbMotCpf.insets = new Insets(2, 3, 0, 0);
	  gbc_lbMotCpf.gridx = 13;
	  gbc_lbMotCpf.gridy = 4;
	  panelCamposSup.add(getLbMotCpf(), gbc_lbMotCpf);
	  GridBagConstraints gbc_motCpf = new GridBagConstraints();
	  gbc_motCpf.insets = new Insets(2, 3, 0, 3);
	  gbc_motCpf.gridwidth = 2;
	  gbc_motCpf.fill = GridBagConstraints.BOTH;
	  gbc_motCpf.gridx = 14;
	  gbc_motCpf.gridy = 4;
	  panelCamposSup.add(getMotCpf(), gbc_motCpf);
	}
	return panelCamposSup;
  }

  private JPanel getPanelServicoRealizado() {
	if (panelServicoRealizado == null) {
	  panelServicoRealizado = new JPanel();
	  GridBagLayout gbl_panelServicoRealizado = new GridBagLayout();
	  gbl_panelServicoRealizado.columnWidths = new int[] { 0, 0, 0, 0, 65, 0, 0, 0 };
	  gbl_panelServicoRealizado.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelServicoRealizado.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0,
		  Double.MIN_VALUE };
	  gbl_panelServicoRealizado.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0,
		  Double.MIN_VALUE };
	  panelServicoRealizado.setLayout(gbl_panelServicoRealizado);
	  GridBagConstraints gbc_panelRemetente = new GridBagConstraints();
	  gbc_panelRemetente.gridheight = 2;
	  gbc_panelRemetente.insets = new Insets(2, 3, 0, 3);
	  gbc_panelRemetente.gridwidth = 3;
	  gbc_panelRemetente.fill = GridBagConstraints.HORIZONTAL;
	  gbc_panelRemetente.gridx = 0;
	  gbc_panelRemetente.gridy = 0;
	  panelServicoRealizado.add(getPanelRemetente(), gbc_panelRemetente);
	  GridBagConstraints gbc_panelMercadoria = new GridBagConstraints();
	  gbc_panelMercadoria.insets = new Insets(2, 3, 0, 3);
	  gbc_panelMercadoria.gridwidth = 4;
	  gbc_panelMercadoria.fill = GridBagConstraints.BOTH;
	  gbc_panelMercadoria.gridx = 3;
	  gbc_panelMercadoria.gridy = 0;
	  panelServicoRealizado.add(getPanelMercadoria(), gbc_panelMercadoria);
	  GridBagConstraints gbc_panelValoresServRealizado = new GridBagConstraints();
	  gbc_panelValoresServRealizado.insets = new Insets(2, 3, 0, 3);
	  gbc_panelValoresServRealizado.gridheight = 4;
	  gbc_panelValoresServRealizado.gridwidth = 4;
	  gbc_panelValoresServRealizado.fill = GridBagConstraints.BOTH;
	  gbc_panelValoresServRealizado.gridx = 3;
	  gbc_panelValoresServRealizado.gridy = 1;
	  panelServicoRealizado.add(getPanelValoresServRealizado(), gbc_panelValoresServRealizado);
	  GridBagConstraints gbc_panelDestinatario = new GridBagConstraints();
	  gbc_panelDestinatario.insets = new Insets(2, 3, 0, 3);
	  gbc_panelDestinatario.gridwidth = 3;
	  gbc_panelDestinatario.fill = GridBagConstraints.BOTH;
	  gbc_panelDestinatario.gridx = 0;
	  gbc_panelDestinatario.gridy = 2;
	  panelServicoRealizado.add(getPanelDestinatario(), gbc_panelDestinatario);
	  GridBagConstraints gbc_panelExpedidor = new GridBagConstraints();
	  gbc_panelExpedidor.insets = new Insets(2, 3, 0, 3);
	  gbc_panelExpedidor.gridwidth = 3;
	  gbc_panelExpedidor.fill = GridBagConstraints.HORIZONTAL;
	  gbc_panelExpedidor.gridx = 0;
	  gbc_panelExpedidor.gridy = 3;
	  panelServicoRealizado.add(getPanelExpedidor(), gbc_panelExpedidor);
	  GridBagConstraints gbc_panelRecebedor = new GridBagConstraints();
	  gbc_panelRecebedor.gridheight = 2;
	  gbc_panelRecebedor.insets = new Insets(2, 3, 0, 3);
	  gbc_panelRecebedor.gridwidth = 3;
	  gbc_panelRecebedor.fill = GridBagConstraints.BOTH;
	  gbc_panelRecebedor.gridx = 0;
	  gbc_panelRecebedor.gridy = 4;
	  panelServicoRealizado.add(getPanelRecebedor(), gbc_panelRecebedor);
	}
	return panelServicoRealizado;
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
	  GridBagConstraints gbc_tomTipDes = new GridBagConstraints();
	  gbc_tomTipDes.gridwidth = 3;
	  gbc_tomTipDes.insets = new Insets(2, 3, 0, 0);
	  gbc_tomTipDes.fill = GridBagConstraints.BOTH;
	  gbc_tomTipDes.gridx = 1;
	  gbc_tomTipDes.gridy = 0;
	  panelCondicoesEspecificas.add(getTomTipDes(), gbc_tomTipDes);
	  GridBagConstraints gbc_lbPrevisaoEntrega = new GridBagConstraints();
	  gbc_lbPrevisaoEntrega.fill = GridBagConstraints.BOTH;
	  gbc_lbPrevisaoEntrega.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPrevisaoEntrega.gridx = 0;
	  gbc_lbPrevisaoEntrega.gridy = 1;
	  panelCondicoesEspecificas.add(getLbPrevisaoEntrega(), gbc_lbPrevisaoEntrega);
	  GridBagConstraints gbc_pedPtr = new GridBagConstraints();
	  gbc_pedPtr.gridwidth = 3;
	  gbc_pedPtr.fill = GridBagConstraints.BOTH;
	  gbc_pedPtr.insets = new Insets(2, 3, 0, 0);
	  gbc_pedPtr.gridx = 1;
	  gbc_pedPtr.gridy = 1;
	  panelCondicoesEspecificas.add(getPedPtr(), gbc_pedPtr);
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

  private JPanel getPanelRemetente() {
	if (panelRemetente == null) {
	  panelRemetente = new JPanel();
	  panelRemetente.setBorder(
		  new TitledBorder(null, "Remetente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelRemetente = new GridBagLayout();
	  gbl_panelRemetente.columnWidths = new int[] { 0, 0, 0 };
	  gbl_panelRemetente.rowHeights = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelRemetente.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelRemetente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelRemetente.setLayout(gbl_panelRemetente);
	  GridBagConstraints gbc_lbRemeteCliRaz = new GridBagConstraints();
	  gbc_lbRemeteCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeteCliRaz.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeteCliRaz.gridx = 0;
	  gbc_lbRemeteCliRaz.gridy = 0;
	  panelRemetente.add(getLbRemeNome(), gbc_lbRemeteCliRaz);
	  GridBagConstraints gbc_remeteCliRaz = new GridBagConstraints();
	  gbc_remeteCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_remeteCliRaz.insets = new Insets(2, 3, 0, 3);
	  gbc_remeteCliRaz.gridx = 1;
	  gbc_remeteCliRaz.gridy = 0;
	  panelRemetente.add(getRemeteCliRaz(), gbc_remeteCliRaz);
	  GridBagConstraints gbc_lbRemeteCliCnp = new GridBagConstraints();
	  gbc_lbRemeteCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeteCliCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeteCliCnp.gridx = 0;
	  gbc_lbRemeteCliCnp.gridy = 1;
	  panelRemetente.add(getLbRemeDoc(), gbc_lbRemeteCliCnp);
	  GridBagConstraints gbc_remeteCliCnp = new GridBagConstraints();
	  gbc_remeteCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_remeteCliCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_remeteCliCnp.gridx = 1;
	  gbc_remeteCliCnp.gridy = 1;
	  panelRemetente.add(getRemeteCliCnp(), gbc_remeteCliCnp);
	  GridBagConstraints gbc_lbRemeteCliEnd = new GridBagConstraints();
	  gbc_lbRemeteCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeteCliEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeteCliEnd.gridx = 0;
	  gbc_lbRemeteCliEnd.gridy = 2;
	  panelRemetente.add(getLbRemeEnd(), gbc_lbRemeteCliEnd);
	  GridBagConstraints gbc_remeteCliEnd = new GridBagConstraints();
	  gbc_remeteCliEnd.insets = new Insets(2, 3, 0, 3);
	  gbc_remeteCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_remeteCliEnd.gridx = 1;
	  gbc_remeteCliEnd.gridy = 2;
	  panelRemetente.add(getRemeteCliEnd(), gbc_remeteCliEnd);
	  GridBagConstraints gbc_lbRemeMunNom = new GridBagConstraints();
	  gbc_lbRemeMunNom.fill = GridBagConstraints.BOTH;
	  gbc_lbRemeMunNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRemeMunNom.gridx = 0;
	  gbc_lbRemeMunNom.gridy = 3;
	  panelRemetente.add(getLbRemeCid(), gbc_lbRemeMunNom);
	  GridBagConstraints gbc_remeteMunNom = new GridBagConstraints();
	  gbc_remeteMunNom.fill = GridBagConstraints.BOTH;
	  gbc_remeteMunNom.insets = new Insets(2, 3, 0, 3);
	  gbc_remeteMunNom.gridx = 1;
	  gbc_remeteMunNom.gridy = 3;
	  panelRemetente.add(getRemeteMunNom(), gbc_remeteMunNom);
	}
	return panelRemetente;
  }

  private JPanel getPanelRecebedor() {
	if (panelRecebedor == null) {
	  panelRecebedor = new JPanel();
	  panelRecebedor.setBorder(
		  new TitledBorder(null, "Recebedor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelRecebedor = new GridBagLayout();
	  gbl_panelRecebedor.columnWidths = new int[] { 0, 0, 0 };
	  gbl_panelRecebedor.rowHeights = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelRecebedor.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelRecebedor.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelRecebedor.setLayout(gbl_panelRecebedor);
	  GridBagConstraints gbc_lbRecebeCliRaz = new GridBagConstraints();
	  gbc_lbRecebeCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_lbRecebeCliRaz.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecebeCliRaz.gridx = 0;
	  gbc_lbRecebeCliRaz.gridy = 0;
	  panelRecebedor.add(getLbReceNome(), gbc_lbRecebeCliRaz);
	  GridBagConstraints gbc_recebeCliRaz = new GridBagConstraints();
	  gbc_recebeCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_recebeCliRaz.insets = new Insets(2, 3, 0, 3);
	  gbc_recebeCliRaz.gridx = 1;
	  gbc_recebeCliRaz.gridy = 0;
	  panelRecebedor.add(getRecebeCliRaz(), gbc_recebeCliRaz);
	  GridBagConstraints gbc_lbRecebeCliCnp = new GridBagConstraints();
	  gbc_lbRecebeCliCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecebeCliCnp.gridx = 0;
	  gbc_lbRecebeCliCnp.gridy = 1;
	  panelRecebedor.add(getLbReceDoc(), gbc_lbRecebeCliCnp);
	  GridBagConstraints gbc_recebeCliCnp = new GridBagConstraints();
	  gbc_recebeCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_recebeCliCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_recebeCliCnp.gridx = 1;
	  gbc_recebeCliCnp.gridy = 1;
	  panelRecebedor.add(getRecebeCliCnp(), gbc_recebeCliCnp);
	  GridBagConstraints gbc_lbRecebeCliEnd = new GridBagConstraints();
	  gbc_lbRecebeCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbRecebeCliEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecebeCliEnd.gridx = 0;
	  gbc_lbRecebeCliEnd.gridy = 2;
	  panelRecebedor.add(getLbReceEnd(), gbc_lbRecebeCliEnd);
	  GridBagConstraints gbc_recebeCliEnd = new GridBagConstraints();
	  gbc_recebeCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_recebeCliEnd.insets = new Insets(2, 3, 0, 3);
	  gbc_recebeCliEnd.gridx = 1;
	  gbc_recebeCliEnd.gridy = 2;
	  panelRecebedor.add(getRecebeCliEnd(), gbc_recebeCliEnd);
	  GridBagConstraints gbc_lbRecebeMunNom = new GridBagConstraints();
	  gbc_lbRecebeMunNom.fill = GridBagConstraints.BOTH;
	  gbc_lbRecebeMunNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbRecebeMunNom.gridx = 0;
	  gbc_lbRecebeMunNom.gridy = 3;
	  panelRecebedor.add(getLbReceCid(), gbc_lbRecebeMunNom);
	  GridBagConstraints gbc_recebeMunNom = new GridBagConstraints();
	  gbc_recebeMunNom.fill = GridBagConstraints.BOTH;
	  gbc_recebeMunNom.insets = new Insets(2, 3, 0, 3);
	  gbc_recebeMunNom.gridx = 1;
	  gbc_recebeMunNom.gridy = 3;
	  panelRecebedor.add(getRecebeMunNom(), gbc_recebeMunNom);
	}
	return panelRecebedor;
  }

  private JPanel getPanelExpedidor() {
	if (panelExpedidor == null) {
	  panelExpedidor = new JPanel();
	  panelExpedidor.setBorder(
		  new TitledBorder(null, "Expedidor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelExpedidor = new GridBagLayout();
	  gbl_panelExpedidor.columnWidths = new int[] { 0, 0, 0 };
	  gbl_panelExpedidor.rowHeights = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelExpedidor.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelExpedidor.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelExpedidor.setLayout(gbl_panelExpedidor);
	  GridBagConstraints gbc_lbExpediCliRaz = new GridBagConstraints();
	  gbc_lbExpediCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_lbExpediCliRaz.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpediCliRaz.gridx = 0;
	  gbc_lbExpediCliRaz.gridy = 0;
	  panelExpedidor.add(getLbExpeNome(), gbc_lbExpediCliRaz);
	  GridBagConstraints gbc_expediCliRaz = new GridBagConstraints();
	  gbc_expediCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_expediCliRaz.insets = new Insets(2, 3, 0, 3);
	  gbc_expediCliRaz.gridx = 1;
	  gbc_expediCliRaz.gridy = 0;
	  panelExpedidor.add(getExpediCliRaz(), gbc_expediCliRaz);
	  GridBagConstraints gbc_lbExpediCliCnp = new GridBagConstraints();
	  gbc_lbExpediCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_lbExpediCliCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpediCliCnp.gridx = 0;
	  gbc_lbExpediCliCnp.gridy = 1;
	  panelExpedidor.add(getLbExpeDoc(), gbc_lbExpediCliCnp);
	  GridBagConstraints gbc_expediCliCnp = new GridBagConstraints();
	  gbc_expediCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_expediCliCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_expediCliCnp.gridx = 1;
	  gbc_expediCliCnp.gridy = 1;
	  panelExpedidor.add(getExpediCliCnp(), gbc_expediCliCnp);
	  GridBagConstraints gbc_lbExpediCliEnd = new GridBagConstraints();
	  gbc_lbExpediCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbExpediCliEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpediCliEnd.gridx = 0;
	  gbc_lbExpediCliEnd.gridy = 2;
	  panelExpedidor.add(getLbExpeEnd(), gbc_lbExpediCliEnd);
	  GridBagConstraints gbc_expediCliEnd = new GridBagConstraints();
	  gbc_expediCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_expediCliEnd.insets = new Insets(2, 3, 0, 3);
	  gbc_expediCliEnd.gridx = 1;
	  gbc_expediCliEnd.gridy = 2;
	  panelExpedidor.add(getExpediCliEnd(), gbc_expediCliEnd);
	  GridBagConstraints gbc_lbExpediMunNom = new GridBagConstraints();
	  gbc_lbExpediMunNom.fill = GridBagConstraints.BOTH;
	  gbc_lbExpediMunNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbExpediMunNom.gridx = 0;
	  gbc_lbExpediMunNom.gridy = 3;
	  panelExpedidor.add(getLbExpeCid(), gbc_lbExpediMunNom);
	  GridBagConstraints gbc_ExpediMunNom = new GridBagConstraints();
	  gbc_ExpediMunNom.fill = GridBagConstraints.BOTH;
	  gbc_ExpediMunNom.insets = new Insets(2, 3, 0, 3);
	  gbc_ExpediMunNom.gridx = 1;
	  gbc_ExpediMunNom.gridy = 3;
	  panelExpedidor.add(getExpediMunNom(), gbc_ExpediMunNom);
	}
	return panelExpedidor;
  }

  private JPanel getPanelDestinatario() {
	if (panelDestinatario == null) {
	  panelDestinatario = new JPanel();
	  panelDestinatario.setBorder(new TitledBorder(null, "Destinat\u00E1rio", TitledBorder.LEADING,
		  TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelDestinatario = new GridBagLayout();
	  gbl_panelDestinatario.columnWidths = new int[] { 0, 0, 0 };
	  gbl_panelDestinatario.rowHeights = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelDestinatario.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelDestinatario.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelDestinatario.setLayout(gbl_panelDestinatario);
	  GridBagConstraints gbc_lbDestinCliRaz = new GridBagConstraints();
	  gbc_lbDestinCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_lbDestinCliRaz.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestinCliRaz.gridx = 0;
	  gbc_lbDestinCliRaz.gridy = 0;
	  panelDestinatario.add(getLbDestNome(), gbc_lbDestinCliRaz);
	  GridBagConstraints gbc_destinCliRaz = new GridBagConstraints();
	  gbc_destinCliRaz.fill = GridBagConstraints.BOTH;
	  gbc_destinCliRaz.insets = new Insets(2, 3, 0, 3);
	  gbc_destinCliRaz.gridx = 1;
	  gbc_destinCliRaz.gridy = 0;
	  panelDestinatario.add(getDestinCliRaz(), gbc_destinCliRaz);
	  GridBagConstraints gbc_lbDestinCliCnp = new GridBagConstraints();
	  gbc_lbDestinCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_lbDestinCliCnp.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestinCliCnp.gridx = 0;
	  gbc_lbDestinCliCnp.gridy = 1;
	  panelDestinatario.add(getLbDestDoc(), gbc_lbDestinCliCnp);
	  GridBagConstraints gbc_destinCliCnp = new GridBagConstraints();
	  gbc_destinCliCnp.fill = GridBagConstraints.BOTH;
	  gbc_destinCliCnp.insets = new Insets(2, 3, 0, 3);
	  gbc_destinCliCnp.gridx = 1;
	  gbc_destinCliCnp.gridy = 1;
	  panelDestinatario.add(getDestinCliCnp(), gbc_destinCliCnp);
	  GridBagConstraints gbc_lbDestinCliEnd = new GridBagConstraints();
	  gbc_lbDestinCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_lbDestinCliEnd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestinCliEnd.gridx = 0;
	  gbc_lbDestinCliEnd.gridy = 2;
	  panelDestinatario.add(getLbDestEnd(), gbc_lbDestinCliEnd);
	  GridBagConstraints gbc_destinCliEnd = new GridBagConstraints();
	  gbc_destinCliEnd.fill = GridBagConstraints.BOTH;
	  gbc_destinCliEnd.insets = new Insets(2, 3, 0, 3);
	  gbc_destinCliEnd.gridx = 1;
	  gbc_destinCliEnd.gridy = 2;
	  panelDestinatario.add(getDestinCliEnd(), gbc_destinCliEnd);
	  GridBagConstraints gbc_lbDestinMunNom = new GridBagConstraints();
	  gbc_lbDestinMunNom.fill = GridBagConstraints.BOTH;
	  gbc_lbDestinMunNom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDestinMunNom.gridx = 0;
	  gbc_lbDestinMunNom.gridy = 3;
	  panelDestinatario.add(getLbDestCid(), gbc_lbDestinMunNom);
	  GridBagConstraints gbc_destinMunNom = new GridBagConstraints();
	  gbc_destinMunNom.fill = GridBagConstraints.BOTH;
	  gbc_destinMunNom.insets = new Insets(2, 3, 0, 3);
	  gbc_destinMunNom.gridx = 1;
	  gbc_destinMunNom.gridy = 3;
	  panelDestinatario.add(getDestinMunNom(), gbc_destinMunNom);
	}
	return panelDestinatario;
  }

  private JPanel getPanelValoresServRealizado() {
	if (panelValoresServRealizado == null) {
	  panelValoresServRealizado = new JPanel();
	  panelValoresServRealizado.setBorder(new TitledBorder(null, "Valores de Servi\u00E7o Realizado",
		  TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelValoresServRealizado = new GridBagLayout();
	  gbl_panelValoresServRealizado.columnWidths = new int[] { 0, 0, 0, 0, 0 };
	  gbl_panelValoresServRealizado.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	  gbl_panelValoresServRealizado.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
		  Double.MIN_VALUE };
	  gbl_panelValoresServRealizado.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		  0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelValoresServRealizado.setLayout(gbl_panelValoresServRealizado);
	  GridBagConstraints gbc_lbValOca = new GridBagConstraints();
	  gbc_lbValOca.insets = new Insets(2, 3, 0, 0);
	  gbc_lbValOca.fill = GridBagConstraints.BOTH;
	  gbc_lbValOca.gridx = 0;
	  gbc_lbValOca.gridy = 0;
	  panelValoresServRealizado.add(getLbValOca(), gbc_lbValOca);
	  GridBagConstraints gbc_valOca = new GridBagConstraints();
	  gbc_valOca.insets = new Insets(2, 3, 0, 3);
	  gbc_valOca.gridwidth = 3;
	  gbc_valOca.fill = GridBagConstraints.BOTH;
	  gbc_valOca.gridx = 1;
	  gbc_valOca.gridy = 0;
	  panelValoresServRealizado.add(getValOca(), gbc_valOca);
	  GridBagConstraints gbc_lbCroRen = new GridBagConstraints();
	  gbc_lbCroRen.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroRen.fill = GridBagConstraints.BOTH;
	  gbc_lbCroRen.gridx = 0;
	  gbc_lbCroRen.gridy = 1;
	  panelValoresServRealizado.add(getLbCroRen(), gbc_lbCroRen);
	  GridBagConstraints gbc_croRen = new GridBagConstraints();
	  gbc_croRen.insets = new Insets(2, 3, 0, 3);
	  gbc_croRen.fill = GridBagConstraints.BOTH;
	  gbc_croRen.gridwidth = 3;
	  gbc_croRen.gridx = 1;
	  gbc_croRen.gridy = 1;
	  panelValoresServRealizado.add(getCroRen(), gbc_croRen);
	  GridBagConstraints gbc_lbCroDes = new GridBagConstraints();
	  gbc_lbCroDes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroDes.fill = GridBagConstraints.BOTH;
	  gbc_lbCroDes.gridx = 0;
	  gbc_lbCroDes.gridy = 2;
	  panelValoresServRealizado.add(getLbCroDes(), gbc_lbCroDes);
	  GridBagConstraints gbc_croDes = new GridBagConstraints();
	  gbc_croDes.insets = new Insets(2, 3, 0, 3);
	  gbc_croDes.fill = GridBagConstraints.BOTH;
	  gbc_croDes.gridwidth = 3;
	  gbc_croDes.gridx = 1;
	  gbc_croDes.gridy = 2;
	  panelValoresServRealizado.add(getCroDes(), gbc_croDes);
	  GridBagConstraints gbc_lbCroPed = new GridBagConstraints();
	  gbc_lbCroPed.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroPed.fill = GridBagConstraints.BOTH;
	  gbc_lbCroPed.gridx = 0;
	  gbc_lbCroPed.gridy = 3;
	  panelValoresServRealizado.add(getLbCroPed(), gbc_lbCroPed);
	  GridBagConstraints gbc_croPed = new GridBagConstraints();
	  gbc_croPed.insets = new Insets(2, 3, 0, 3);
	  gbc_croPed.fill = GridBagConstraints.BOTH;
	  gbc_croPed.gridwidth = 3;
	  gbc_croPed.gridx = 1;
	  gbc_croPed.gridy = 3;
	  panelValoresServRealizado.add(getCroPed(), gbc_croPed);
	  GridBagConstraints gbc_lbSesSen = new GridBagConstraints();
	  gbc_lbSesSen.insets = new Insets(2, 3, 0, 0);
	  gbc_lbSesSen.fill = GridBagConstraints.BOTH;
	  gbc_lbSesSen.gridx = 0;
	  gbc_lbSesSen.gridy = 4;
	  panelValoresServRealizado.add(getLbSesSen(), gbc_lbSesSen);
	  GridBagConstraints gbc_sesSen = new GridBagConstraints();
	  gbc_sesSen.gridwidth = 3;
	  gbc_sesSen.insets = new Insets(2, 3, 0, 3);
	  gbc_sesSen.fill = GridBagConstraints.BOTH;
	  gbc_sesSen.gridx = 1;
	  gbc_sesSen.gridy = 4;
	  panelValoresServRealizado.add(getSesSen(), gbc_sesSen);
	  GridBagConstraints gbc_lbPerInsValIns = new GridBagConstraints();
	  gbc_lbPerInsValIns.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPerInsValIns.fill = GridBagConstraints.BOTH;
	  gbc_lbPerInsValIns.gridx = 0;
	  gbc_lbPerInsValIns.gridy = 5;
	  panelValoresServRealizado.add(getLbPerInsValIns(), gbc_lbPerInsValIns);
	  GridBagConstraints gbc_valIns = new GridBagConstraints();
	  gbc_valIns.insets = new Insets(2, 3, 0, 0);
	  gbc_valIns.fill = GridBagConstraints.BOTH;
	  gbc_valIns.gridx = 1;
	  gbc_valIns.gridy = 5;
	  panelValoresServRealizado.add(getValIns(), gbc_valIns);
	  GridBagConstraints gbc_lbPer = new GridBagConstraints();
	  gbc_lbPer.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPer.fill = GridBagConstraints.BOTH;
	  gbc_lbPer.gridx = 2;
	  gbc_lbPer.gridy = 5;
	  panelValoresServRealizado.add(getLbPer(), gbc_lbPer);
	  GridBagConstraints gbc_perIns = new GridBagConstraints();
	  gbc_perIns.insets = new Insets(2, 3, 0, 3);
	  gbc_perIns.fill = GridBagConstraints.BOTH;
	  gbc_perIns.gridx = 3;
	  gbc_perIns.gridy = 5;
	  panelValoresServRealizado.add(getPerIns(), gbc_perIns);
	  GridBagConstraints gbc_lbCroImr = new GridBagConstraints();
	  gbc_lbCroImr.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroImr.fill = GridBagConstraints.BOTH;
	  gbc_lbCroImr.gridx = 0;
	  gbc_lbCroImr.gridy = 6;
	  panelValoresServRealizado.add(getLbCroImr(), gbc_lbCroImr);
	  GridBagConstraints gbc_croImr = new GridBagConstraints();
	  gbc_croImr.insets = new Insets(2, 3, 0, 3);
	  gbc_croImr.gridwidth = 3;
	  gbc_croImr.fill = GridBagConstraints.BOTH;
	  gbc_croImr.gridx = 1;
	  gbc_croImr.gridy = 6;
	  panelValoresServRealizado.add(getCroImr(), gbc_croImr);
	  GridBagConstraints gbc_lbTotAdt = new GridBagConstraints();
	  gbc_lbTotAdt.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotAdt.fill = GridBagConstraints.BOTH;
	  gbc_lbTotAdt.gridx = 0;
	  gbc_lbTotAdt.gridy = 7;
	  panelValoresServRealizado.add(getLbTotAdt(), gbc_lbTotAdt);
	  GridBagConstraints gbc_totAdt = new GridBagConstraints();
	  gbc_totAdt.insets = new Insets(2, 3, 0, 3);
	  gbc_totAdt.gridwidth = 3;
	  gbc_totAdt.fill = GridBagConstraints.BOTH;
	  gbc_totAdt.gridx = 1;
	  gbc_totAdt.gridy = 7;
	  panelValoresServRealizado.add(getTotAdt(), gbc_totAdt);
	  GridBagConstraints gbc_lbCroOcr = new GridBagConstraints();
	  gbc_lbCroOcr.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroOcr.fill = GridBagConstraints.BOTH;
	  gbc_lbCroOcr.gridx = 0;
	  gbc_lbCroOcr.gridy = 8;
	  panelValoresServRealizado.add(getLbCroOcr(), gbc_lbCroOcr);
	  GridBagConstraints gbc_croOcr = new GridBagConstraints();
	  gbc_croOcr.insets = new Insets(2, 3, 0, 3);
	  gbc_croOcr.gridwidth = 3;
	  gbc_croOcr.fill = GridBagConstraints.BOTH;
	  gbc_croOcr.gridx = 1;
	  gbc_croOcr.gridy = 8;
	  panelValoresServRealizado.add(getCroOcr(), gbc_croOcr);
	  GridBagConstraints gbc_lbCroOde = new GridBagConstraints();
	  gbc_lbCroOde.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroOde.fill = GridBagConstraints.BOTH;
	  gbc_lbCroOde.gridx = 0;
	  gbc_lbCroOde.gridy = 9;
	  panelValoresServRealizado.add(getLbCroOde(), gbc_lbCroOde);
	  GridBagConstraints gbc_croOde = new GridBagConstraints();
	  gbc_croOde.insets = new Insets(2, 3, 0, 3);
	  gbc_croOde.gridwidth = 3;
	  gbc_croOde.fill = GridBagConstraints.BOTH;
	  gbc_croOde.gridx = 1;
	  gbc_croOde.gridy = 9;
	  panelValoresServRealizado.add(getCroOde(), gbc_croOde);
	  GridBagConstraints gbc_lbCroSeg = new GridBagConstraints();
	  gbc_lbCroSeg.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCroSeg.fill = GridBagConstraints.BOTH;
	  gbc_lbCroSeg.gridx = 0;
	  gbc_lbCroSeg.gridy = 10;
	  panelValoresServRealizado.add(getLbCroSeg(), gbc_lbCroSeg);
	  GridBagConstraints gbc_croSeg = new GridBagConstraints();
	  gbc_croSeg.insets = new Insets(2, 3, 0, 3);
	  gbc_croSeg.gridwidth = 3;
	  gbc_croSeg.fill = GridBagConstraints.BOTH;
	  gbc_croSeg.gridx = 1;
	  gbc_croSeg.gridy = 10;
	  panelValoresServRealizado.add(getCroSeg(), gbc_croSeg);
	  GridBagConstraints gbc_lbTotalSaldo = new GridBagConstraints();
	  gbc_lbTotalSaldo.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotalSaldo.fill = GridBagConstraints.BOTH;
	  gbc_lbTotalSaldo.gridx = 0;
	  gbc_lbTotalSaldo.gridy = 11;
	  panelValoresServRealizado.add(getLbTotalSaldo(), gbc_lbTotalSaldo);
	  GridBagConstraints gbc_totalSaldo = new GridBagConstraints();
	  gbc_totalSaldo.insets = new Insets(2, 3, 0, 3);
	  gbc_totalSaldo.gridwidth = 3;
	  gbc_totalSaldo.fill = GridBagConstraints.BOTH;
	  gbc_totalSaldo.gridx = 1;
	  gbc_totalSaldo.gridy = 11;
	  panelValoresServRealizado.add(getTotalSaldo(), gbc_totalSaldo);
	  GridBagConstraints gbc_lbTotalLiquido = new GridBagConstraints();
	  gbc_lbTotalLiquido.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTotalLiquido.fill = GridBagConstraints.BOTH;
	  gbc_lbTotalLiquido.gridx = 0;
	  gbc_lbTotalLiquido.gridy = 12;
	  panelValoresServRealizado.add(getLbTotalLiquido(), gbc_lbTotalLiquido);
	  GridBagConstraints gbc_totalLiquido = new GridBagConstraints();
	  gbc_totalLiquido.insets = new Insets(2, 3, 0, 3);
	  gbc_totalLiquido.gridwidth = 3;
	  gbc_totalLiquido.fill = GridBagConstraints.BOTH;
	  gbc_totalLiquido.gridx = 1;
	  gbc_totalLiquido.gridy = 12;
	  panelValoresServRealizado.add(getTotalLiquido(), gbc_totalLiquido);
	}
	return panelValoresServRealizado;
  }

  private JPanel getPanelMercadoria() {
	if (panelMercadoria == null) {
	  panelMercadoria = new JPanel();
	  panelMercadoria.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es de Mercadoria",
		  TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	  GridBagLayout gbl_panelMercadoria = new GridBagLayout();
	  gbl_panelMercadoria.columnWidths = new int[] { 0, 0, 0 };
	  gbl_panelMercadoria.rowHeights = new int[] { 0, 0, 0 };
	  gbl_panelMercadoria.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelMercadoria.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
	  panelMercadoria.setLayout(gbl_panelMercadoria);
	  GridBagConstraints gbc_lbDesDom = new GridBagConstraints();
	  gbc_lbDesDom.fill = GridBagConstraints.BOTH;
	  gbc_lbDesDom.insets = new Insets(2, 3, 0, 0);
	  gbc_lbDesDom.gridx = 0;
	  gbc_lbDesDom.gridy = 0;
	  panelMercadoria.add(getLbDesDom(), gbc_lbDesDom);
	  GridBagConstraints gbc_desDom = new GridBagConstraints();
	  gbc_desDom.fill = GridBagConstraints.BOTH;
	  gbc_desDom.insets = new Insets(2, 3, 0, 3);
	  gbc_desDom.gridx = 1;
	  gbc_desDom.gridy = 0;
	  panelMercadoria.add(getDesDom(), gbc_desDom);
	  GridBagConstraints gbc_lbPesoCarregado = new GridBagConstraints();
	  gbc_lbPesoCarregado.fill = GridBagConstraints.BOTH;
	  gbc_lbPesoCarregado.insets = new Insets(2, 3, 0, 0);
	  gbc_lbPesoCarregado.gridx = 0;
	  gbc_lbPesoCarregado.gridy = 1;
	  panelMercadoria.add(getLbPesoCarregado(), gbc_lbPesoCarregado);
	  GridBagConstraints gbc_pesoTonelada = new GridBagConstraints();
	  gbc_pesoTonelada.fill = GridBagConstraints.BOTH;
	  gbc_pesoTonelada.insets = new Insets(2, 3, 0, 3);
	  gbc_pesoTonelada.gridx = 1;
	  gbc_pesoTonelada.gridy = 1;
	  panelMercadoria.add(getPesoTonelada(), gbc_pesoTonelada);
	}
	return panelMercadoria;
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
	  cteCod.setName("");
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
	  motNom.setName("MOTNOM");
	}
	return motNom;
  }

  private UnJLabel getLbMotCpf() {
	if (lbMotCpf == null) {
	  lbMotCpf = new UnJLabel();
	  lbMotCpf.setText("CPF:");
	  lbMotCpf.setPreferredSize(new Dimension(60, 19));
	  lbMotCpf.setMinimumSize(new Dimension(60, 19));
	}
	return lbMotCpf;
  }

  private UnJLabel getRemeteCliCnp() {
	if (remeteCliCnp == null) {
	  remeteCliCnp = new UnJLabel();
	  remeteCliCnp.setPreferredSize(new Dimension(500, 19));
	  remeteCliCnp.setName("REMETE_CLICNP");
	  remeteCliCnp.setMinimumSize(new Dimension(500, 19));
	}
	return remeteCliCnp;
  }

  private UnJLabel getRemeteCliEnd() {
	if (remeteCliEnd == null) {
	  remeteCliEnd = new UnJLabel();
	  remeteCliEnd.setPreferredSize(new Dimension(500, 19));
	  remeteCliEnd.setName("REMETE_CLIEND");
	  remeteCliEnd.setMinimumSize(new Dimension(500, 19));
	}
	return remeteCliEnd;
  }

  private UnJLabel getRemeteMunNom() {
	if (remeteMunNom == null) {
	  remeteMunNom = new UnJLabel();
	  remeteMunNom.setPreferredSize(new Dimension(500, 19));
	  remeteMunNom.setName("REMETE_MUNNOM");
	  remeteMunNom.setMinimumSize(new Dimension(500, 19));
	}
	return remeteMunNom;
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

  private UnJLabel getPesoTonelada() {
	if (pesoTonelada == null) {
	  pesoTonelada = new UnJLabel();
	  pesoTonelada.setHorizontalAlignment(SwingConstants.RIGHT);
	  pesoTonelada.setPreferredSize(new Dimension(130, 19));
	  pesoTonelada.setName("PESO_TONELADA");
	  pesoTonelada.setMinimumSize(new Dimension(130, 19));
	}
	return pesoTonelada;
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
	  perIns.setName("VALINS");
	  perIns.setText(" R$ 0,00 ");
	}
	return perIns;
  }

  private editFormatado getValIns() {
	if (valIns == null) {
	  valIns = new editFormatado();
	  valIns.setCampoObrigatorio(false);
	  valIns.setTipoFormatacao(7);
	  valIns.setName("PERINS");
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

	  String query = "select EMPCOD, FILCOD, CTECOD, CLICOD, CLICODDES, CLICODCNP, CLICODEND, VEIPLA, VEIRB1, VEIRB2, VEIRB3, MOTNOM, MOTCPF, VALOCA, CROREN, "
		  + "CRODES, CROPED, SESSEN, PERINS, VALINS, CROIMR, TOTADT, CROOCR, CROODE, CROSEG, CROEST, OBSGER, OBSGERDES, OBSGERMSG, CROTMP, TOTAL_SALDO, "
		  + "TOTAL_LIQUIDO from ES_VIEW_CONTRATO_RODOVIARIO where empcod = '" + getEmpCod().getText()
		  + "' and filcod = " + getFilCod().getText() + " and ctecod = " + codigo;
	  res = getSelecao().executeQuery(query);

	  if (res.next()) {
		setAcaoTela("A");
		limpaTela();
		CompTelas.montaCamposResultSet(res, getPanelValoresServRealizado(), false);
		CompTelas.montaCamposResultSet(res, getPanelCamposSup(), false);
		getObsGer().setText(res.getString("OBSGER"));
		getCroEst().setText(res.getString("CROEST"));

		montaTelaContrato("");
	  }
	  else {
		setAcaoTela("I");
		limpaTela();
		montaTelaContrato("");
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

  public boolean montaTelaContrato(String codigo) {

	try {

	  String query = "select EMPCOD, FILCOD, FILCODDES, PEDCOD, PEDCLI, REMETE, REMETE_CLIRAZ, REMETE_CLIFAN, "
		  + "REMETE_CLICNP, REMETE_CLITE1, REMETE_CLIEST, REMETE_MUNNOM, REMETE_MUNEST, REMETE_CLIBAI, "
		  + "REMETE_CLICEP, REMETE_CLIIES, REMETE_CLIEND, REMETE_CLINUM, REMETE_CLICPL, PEDDAT, "
		  + "PEDFRE, PEDPEF, PEDFRE_PEDPEF, PEDNFF, PEDSER, TRACOD, TRACODDES, TRACODMOT, TRACODMOTDES, VENCOD, VENCODDES, "
		  + "PEDSAI, DESDOM, TOTCAR, OUTROS_CLIEST, OUTROS_CLIEND, OUTROS_CLINUM, OUTROS_CLIBAI, OUTROS_CLIIES, OUTROS_CLITE1, "
		  + "OUTROS_MUNNOM, OUTROS_MUNEST, OUTROS_CLIRAZ, OUTROS_CLIFAN, OUTROS_CLICPL, OUTROS_CLICEP, DESTIN, "
		  + "DESTIN_CLICNP, DESTIN_CLIEST, DESTIN_CLIEND, DESTIN_CLINUM, DESTIN_CLIBAI, DESTIN_CLIIES, "
		  + "DESTIN_CLITE1, DESTIN_MUNNOM, DESTIN_MUNEST, DESTIN_CLIRAZ, DESTIN_CLIFAN, DESTIN_CLICPL, DESTIN_CLICEP, "
		  + "EXPEDI, EXPEDI_CLICNP, EXPEDI_CLIEST, EXPEDI_CLIEND, EXPEDI_CLINUM, EXPEDI_CLIBAI, "
		  + "EXPEDI_CLIIES, EXPEDI_CLITE1, EXPEDI_MUNNOM, EXPEDI_MUNEST, EXPEDI_CLIRAZ, EXPEDI_CLIFAN, EXPEDI_CLICPL, "
		  + "EXPEDI_CLICEP, RECEBE, RECEBE_CLICNP, RECEBE_CLIEST, RECEBE_CLIEND, RECEBE_CLINUM, "
		  + "RECEBE_CLIBAI, RECEBE_CLIIES, RECEBE_CLITE1, RECEBE_MUNNOM, RECEBE_MUNEST, RECEBE_CLIRAZ, "
		  + "RECEBE_CLIFAN, RECEBE_CLICPL, RECEBE_CLICEP, TOMTIP, PESO_TONELADA, TOMTIPDES, NFES, CTES, PEDDNF, PEDPTR "
		  + "from ES_VIEW_PEDVEN_CTE where empcod = '" + getEmpCod().getText() + "' and filcod = "
		  + getFilCod().getText() + " and pedcod = " + getCteCod().getText();
	  res = getSelecao().executeQuery(query);

	  if (res.next()) {
		CompTelas.montaCamposResultSet(res, getPanelDestinatario(), false);
		CompTelas.montaCamposResultSet(res, getPanelExpedidor(), false);
		CompTelas.montaCamposResultSet(res, getPanelRemetente(), false);
		CompTelas.montaCamposResultSet(res, getPanelRecebedor(), false);
		CompTelas.montaCamposResultSet(res, getPanelMercadoria(), false);

		getPedNff().setText(res.getString("PEDNFF"));
		getPedDnf().setText(TrataString.dataTela(res.getString("PEDDNF")));
		getPedPtr().setText(TrataString.dataTela(res.getString("PEDPTR")));
		getTomTipDes().setText(res.getString("TOMTIPDES"));
		getNfes().setText(TrataString.insereQuebraLinha(res.getString("NFES")));
		getCtes().setText(TrataString.insereQuebraLinha(res.getString("CTES")));
		getRemeteCliCnp().setText(TrataString.formatarCnpjCpf(res.getString("REMETE_CLICNP")));
		getExpediCliCnp().setText(TrataString.formatarCnpjCpf(res.getString("EXPEDI_CLICNP")));
		getRecebeCliCnp().setText(TrataString.formatarCnpjCpf(res.getString("RECEBE_CLICNP")));
		getDestinCliCnp().setText(TrataString.formatarCnpjCpf(res.getString("DESTIN_CLICNP")));

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
	}
	return pedNff;
  }

  private UnJLabel getPedDnf() {
	if (pedDnf == null) {
	  pedDnf = new UnJLabel();
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
	getRemeteCliCnp().limpar();
	getRemeteCliEnd().limpar();
	getRemeteMunNom().limpar();
	getPesoTonelada().limpar();
	getTotalSaldo().limpar();
	getTotalLiquido().limpar();

	return true;
  }

  public boolean limpaCamposSup() {

	CompTelas.limparCampos(getPanelCamposSup(), false);
	getPedNff().limpar();
	getPedDnf().limpar();
	getCliCodCnp().limpar();
	getCliCodEnd().limpar();

	return true;
  }

  public boolean limpaCamposCondicaoEspecifica() {

	CompTelas.limparCampos(getPanelCondicoesEspecificas(), false);
	getTomTipDes().limpar();
	getPedPtr().limpar();

	return true;
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

  private UnJLabel getTomTipDes() {
	if (tomTipDes == null) {
	  tomTipDes = new UnJLabel();
	  tomTipDes.setName("TOMTIPDES");
	  tomTipDes.setPreferredSize(new Dimension(120, 19));
	  tomTipDes.setMinimumSize(new Dimension(120, 19));
	}
	return tomTipDes;
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

  private UnJLabel getPedPtr() {
	if (pedPtr == null) {
	  pedPtr = new UnJLabel();
	  pedPtr.setPreferredSize(new Dimension(120, 19));
	  pedPtr.setName("PEDPTR");
	  pedPtr.setMinimumSize(new Dimension(120, 19));
	}
	return pedPtr;
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
	  lbSesSen.setText("SEST/SENAT:");
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
	  lbObsGer.setForeground(Color.BLUE);
	}
	return lbObsGer;
  }

  private EditPratic getObsGer() {
	if (obsGer == null) {
	  obsGer = new EditPratic();
	  obsGer.addFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
		  getBtnAceitar().requestFocus();
		}
	  });
	  obsGer.setTipoValidacao("fp_contrato_trabalho/financeiro");
	  obsGer.setPreferredSize(new Dimension(50, 19));
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

  private UnJLabel getLbRemeNome() {
	if (lbRemeteCliRaz == null) {
	  lbRemeteCliRaz = new UnJLabel();
	  lbRemeteCliRaz.setText("Raz\u00E3o Social:");
	  lbRemeteCliRaz.setPreferredSize(new Dimension(90, 19));
	  lbRemeteCliRaz.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeteCliRaz;
  }

  private UnJLabel getLbRemeDoc() {
	if (lbRemeteCliCnp == null) {
	  lbRemeteCliCnp = new UnJLabel();
	  lbRemeteCliCnp.setText("CPF/CNPJ:");
	  lbRemeteCliCnp.setPreferredSize(new Dimension(90, 19));
	  lbRemeteCliCnp.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeteCliCnp;
  }

  private UnJLabel getLbRemeEnd() {
	if (lbRemeteCliEnd == null) {
	  lbRemeteCliEnd = new UnJLabel();
	  lbRemeteCliEnd.setText("Endere\u00E7o:");
	  lbRemeteCliEnd.setPreferredSize(new Dimension(90, 19));
	  lbRemeteCliEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeteCliEnd;
  }

  private UnJLabel getLbRemeCid() {
	if (lbRemeMunNom == null) {
	  lbRemeMunNom = new UnJLabel();
	  lbRemeMunNom.setText("Cidade:");
	  lbRemeMunNom.setPreferredSize(new Dimension(90, 19));
	  lbRemeMunNom.setMinimumSize(new Dimension(90, 19));
	}
	return lbRemeMunNom;
  }

  private UnJLabel getLbReceNome() {
	if (lbRecebeCliRaz == null) {
	  lbRecebeCliRaz = new UnJLabel();
	  lbRecebeCliRaz.setText("Raz\u00E3o Social:");
	  lbRecebeCliRaz.setPreferredSize(new Dimension(90, 19));
	  lbRecebeCliRaz.setMinimumSize(new Dimension(90, 19));
	}
	return lbRecebeCliRaz;
  }

  private UnJLabel getRecebeCliRaz() {
	if (recebeCliRaz == null) {
	  recebeCliRaz = new UnJLabel();
	  recebeCliRaz.setPreferredSize(new Dimension(500, 19));
	  recebeCliRaz.setName("RECEBE_CLIRAZ");
	  recebeCliRaz.setMinimumSize(new Dimension(500, 19));
	}
	return recebeCliRaz;
  }

  private UnJLabel getLbReceDoc() {
	if (lbRecebeCliCnp == null) {
	  lbRecebeCliCnp = new UnJLabel();
	  lbRecebeCliCnp.setText("CPF/CNPJ:");
	  lbRecebeCliCnp.setPreferredSize(new Dimension(90, 19));
	  lbRecebeCliCnp.setMinimumSize(new Dimension(90, 19));
	}
	return lbRecebeCliCnp;
  }

  private UnJLabel getRecebeCliCnp() {
	if (recebeCliCnp == null) {
	  recebeCliCnp = new UnJLabel();
	  recebeCliCnp.setPreferredSize(new Dimension(500, 19));
	  recebeCliCnp.setName("RECEBE_CLICNP");
	  recebeCliCnp.setMinimumSize(new Dimension(500, 19));
	}
	return recebeCliCnp;
  }

  private UnJLabel getLbReceEnd() {
	if (lbRecebeCliEnd == null) {
	  lbRecebeCliEnd = new UnJLabel();
	  lbRecebeCliEnd.setText("Endere\u00E7o:");
	  lbRecebeCliEnd.setPreferredSize(new Dimension(90, 19));
	  lbRecebeCliEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbRecebeCliEnd;
  }

  private UnJLabel getRecebeCliEnd() {
	if (recebeCliEnd == null) {
	  recebeCliEnd = new UnJLabel();
	  recebeCliEnd.setPreferredSize(new Dimension(500, 19));
	  recebeCliEnd.setName("RECEBE_CLIEND");
	  recebeCliEnd.setMinimumSize(new Dimension(500, 19));
	}
	return recebeCliEnd;
  }

  private UnJLabel getLbReceCid() {
	if (lbRecebeMunNom == null) {
	  lbRecebeMunNom = new UnJLabel();
	  lbRecebeMunNom.setText("Cidade:");
	  lbRecebeMunNom.setPreferredSize(new Dimension(90, 19));
	  lbRecebeMunNom.setMinimumSize(new Dimension(90, 19));
	}
	return lbRecebeMunNom;
  }

  private UnJLabel getRecebeMunNom() {
	if (recebeMunNom == null) {
	  recebeMunNom = new UnJLabel();
	  recebeMunNom.setPreferredSize(new Dimension(500, 19));
	  recebeMunNom.setName("RECEBE_MUNNOM");
	  recebeMunNom.setMinimumSize(new Dimension(500, 19));
	}
	return recebeMunNom;
  }

  private UnJLabel getLbExpeNome() {
	if (lbExpediCliRaz == null) {
	  lbExpediCliRaz = new UnJLabel();
	  lbExpediCliRaz.setText("Raz\u00E3o Social:");
	  lbExpediCliRaz.setPreferredSize(new Dimension(90, 19));
	  lbExpediCliRaz.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpediCliRaz;
  }

  private UnJLabel getLbExpeDoc() {
	if (lbExpediCliCnp == null) {
	  lbExpediCliCnp = new UnJLabel();
	  lbExpediCliCnp.setText("CPF/CNPJ:");
	  lbExpediCliCnp.setPreferredSize(new Dimension(90, 19));
	  lbExpediCliCnp.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpediCliCnp;
  }

  private UnJLabel getLbExpeEnd() {
	if (lbExpediCliEnd == null) {
	  lbExpediCliEnd = new UnJLabel();
	  lbExpediCliEnd.setText("Endere\u00E7o:");
	  lbExpediCliEnd.setPreferredSize(new Dimension(90, 19));
	  lbExpediCliEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpediCliEnd;
  }

  private UnJLabel getLbExpeCid() {
	if (lbExpediMunNom == null) {
	  lbExpediMunNom = new UnJLabel();
	  lbExpediMunNom.setText("Cidade:");
	  lbExpediMunNom.setPreferredSize(new Dimension(90, 19));
	  lbExpediMunNom.setMinimumSize(new Dimension(90, 19));
	}
	return lbExpediMunNom;
  }

  private UnJLabel getExpediCliRaz() {
	if (expediCliRaz == null) {
	  expediCliRaz = new UnJLabel();
	  expediCliRaz.setPreferredSize(new Dimension(500, 19));
	  expediCliRaz.setName("EXPEDI_CLIRAZ");
	  expediCliRaz.setMinimumSize(new Dimension(500, 19));
	}
	return expediCliRaz;
  }

  private UnJLabel getExpediCliCnp() {
	if (expediCliCnp == null) {
	  expediCliCnp = new UnJLabel();
	  expediCliCnp.setPreferredSize(new Dimension(500, 19));
	  expediCliCnp.setName("EXPEDI_CLICNP");
	  expediCliCnp.setMinimumSize(new Dimension(500, 19));
	}
	return expediCliCnp;
  }

  private UnJLabel getExpediCliEnd() {
	if (expediCliEnd == null) {
	  expediCliEnd = new UnJLabel();
	  expediCliEnd.setPreferredSize(new Dimension(500, 19));
	  expediCliEnd.setName("EXPEDI_CLIEND");
	  expediCliEnd.setMinimumSize(new Dimension(500, 19));
	}
	return expediCliEnd;
  }

  private UnJLabel getLbDestNome() {
	if (lbDestinCliRaz == null) {
	  lbDestinCliRaz = new UnJLabel();
	  lbDestinCliRaz.setText("Raz\u00E3o Social:");
	  lbDestinCliRaz.setPreferredSize(new Dimension(90, 19));
	  lbDestinCliRaz.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestinCliRaz;
  }

  private UnJLabel getLbDestDoc() {
	if (lbDestinCliCnp == null) {
	  lbDestinCliCnp = new UnJLabel();
	  lbDestinCliCnp.setText("CPF/CNPJ:");
	  lbDestinCliCnp.setPreferredSize(new Dimension(90, 19));
	  lbDestinCliCnp.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestinCliCnp;
  }

  private UnJLabel getLbDestEnd() {
	if (lbDestinCliEnd == null) {
	  lbDestinCliEnd = new UnJLabel();
	  lbDestinCliEnd.setText("Endere\u00E7o:");
	  lbDestinCliEnd.setPreferredSize(new Dimension(90, 19));
	  lbDestinCliEnd.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestinCliEnd;
  }

  private UnJLabel getLbDestCid() {
	if (lbDestinMunNom == null) {
	  lbDestinMunNom = new UnJLabel();
	  lbDestinMunNom.setText("Cidade:");
	  lbDestinMunNom.setPreferredSize(new Dimension(90, 19));
	  lbDestinMunNom.setMinimumSize(new Dimension(90, 19));
	}
	return lbDestinMunNom;
  }

  private UnJLabel getDestinCliEnd() {
	if (destinCliEnd == null) {
	  destinCliEnd = new UnJLabel();
	  destinCliEnd.setPreferredSize(new Dimension(500, 19));
	  destinCliEnd.setName("DESTIN_CLIEND");
	  destinCliEnd.setMinimumSize(new Dimension(500, 19));
	}
	return destinCliEnd;
  }

  private UnJLabel getDestinMunNom() {
	if (destinMunNom == null) {
	  destinMunNom = new UnJLabel();
	  destinMunNom.setPreferredSize(new Dimension(500, 19));
	  destinMunNom.setName("DESTIN_MUNNOM");
	  destinMunNom.setMinimumSize(new Dimension(500, 19));
	}
	return destinMunNom;
  }

  private UnJLabel getDestinCliCnp() {
	if (destinCliCnp == null) {
	  destinCliCnp = new UnJLabel();
	  destinCliCnp.setPreferredSize(new Dimension(500, 19));
	  destinCliCnp.setName("DESTIN_CLICNP");
	  destinCliCnp.setMinimumSize(new Dimension(500, 19));
	}
	return destinCliCnp;
  }

  private UnJLabel getDestinCliRaz() {
	if (destinCliRaz == null) {
	  destinCliRaz = new UnJLabel();
	  destinCliRaz.setPreferredSize(new Dimension(500, 19));
	  destinCliRaz.setName("DESTIN_CLIRAZ");
	  destinCliRaz.setMinimumSize(new Dimension(500, 19));
	}
	return destinCliRaz;
  }

  private UnJLabel getRemeteCliRaz() {
	if (remeteCliRaz == null) {
	  remeteCliRaz = new UnJLabel();
	  remeteCliRaz.setPreferredSize(new Dimension(500, 19));
	  remeteCliRaz.setName("REMETE_CLIRAZ");
	  remeteCliRaz.setMinimumSize(new Dimension(500, 19));
	}
	return remeteCliRaz;
  }

  private UnJLabel getExpediMunNom() {
	if (ExpediMunNom == null) {
	  ExpediMunNom = new UnJLabel();
	  ExpediMunNom.setPreferredSize(new Dimension(500, 19));
	  ExpediMunNom.setName("EXPEDI_MUNNOM");
	  ExpediMunNom.setMinimumSize(new Dimension(500, 19));
	}
	return ExpediMunNom;
  }

  private UnJLabel getDesDom() {
	if (desDom == null) {
	  desDom = new UnJLabel();
	  desDom.setPreferredSize(new Dimension(130, 19));
	  desDom.setName("DESDOM");
	  desDom.setMinimumSize(new Dimension(130, 19));
	  desDom.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	return desDom;
  }

  public JScrollPane getRolagemCorpo() {
	if (rolagemCorpo == null) {
	  rolagemCorpo = new JScrollPane();
	  rolagemCorpo.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
	  rolagemCorpo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	  rolagemCorpo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	  rolagemCorpo.setViewportView(getPanelServicoRealizado());
	}
	return rolagemCorpo;
  }

}
