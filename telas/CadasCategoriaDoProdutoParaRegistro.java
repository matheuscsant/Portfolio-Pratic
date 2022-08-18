package br.com.praticsistemas.pratic.faturamento.cadastros;

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
import javax.swing.border.BevelBorder;

import br.com.praticsistemas.pratic.DeskPratic;
import br.com.praticsistemas.pratic.templates.UnCadastro;
import br.com.praticsistemas.pratic.util.objetos.EditPratic;
import br.com.praticsistemas.unprtcomps.telas.UnEdit;
import br.com.praticsistemas.unprtcomps.telas.UnJLabel;

public class CadasCategoriaDoProdutoParaRegistro extends UnCadastro {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbCod;
  private EditPratic creCod;
  private UnEdit creNom;
  private UnJLabel lbTipProdRes;
  private EditPratic tprCod;
  private UnJLabel lbResPro;
  private EditPratic treCod;
  private UnJLabel lbDescProReg;
  private UnJLabel lbDescRegPro;

  public CadasCategoriaDoProdutoParaRegistro() {
	initialize();
  }

  private void initialize() {
	setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_CATEGORIA_REGISTRO");
	this.setTitle("Cadastro de Categoria do Produto para Registro");
	this.setCodigoTela("4308");
	this.setSize(new Dimension(712, 179));
	this.setBotaoImprimir(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.setCampoTelaTrabalho(getCreCod());
	this.setCampoFocoAberturaTela(getCreCod());
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.abrirCadasCategoriaDoProdutoParaRegistro = null;
	  }
	});
  }

  public boolean gravaTela() {

	int param = 1;

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_CATEGORIA_REGISTRO", 5, 2));
	  stp.registerOutParameter(param++, Types.BIGINT);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setStp(stp);
	  getProc().setInt(param++, getCreCod(), stp);
	  getProc().setString(param++, getCreNom(), stp);
	  getProc().setInt(param++, getTprCod(), stp);
	  getProc().setInt(param++, getTreCod(), stp);
	  getProc().setString(param++, getAcaoTela());

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

	return true;
  }

  private JPanel getPanelCentral() {
	if (panelCentral == null) {
	  panelCentral = new JPanel();
	  panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  GridBagLayout gbl_panelCentral = new GridBagLayout();
	  gbl_panelCentral.columnWidths = new int[] { 72, 53, 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 25, 25, 25, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_lbCod = new GridBagConstraints();
	  gbc_lbCod.anchor = GridBagConstraints.WEST;
	  gbc_lbCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCod.gridx = 0;
	  gbc_lbCod.gridy = 0;
	  panelCentral.add(getLbCod(), gbc_lbCod);
	  GridBagConstraints gbc_Cod = new GridBagConstraints();
	  gbc_Cod.insets = new Insets(2, 3, 0, 0);
	  gbc_Cod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_Cod.gridx = 1;
	  gbc_Cod.gridy = 0;
	  panelCentral.add(getCreCod(), gbc_Cod);
	  GridBagConstraints gbc_creNom = new GridBagConstraints();
	  gbc_creNom.insets = new Insets(2, 3, 0, 3);
	  gbc_creNom.fill = GridBagConstraints.HORIZONTAL;
	  gbc_creNom.gridx = 2;
	  gbc_creNom.gridy = 0;
	  panelCentral.add(getCreNom(), gbc_creNom);
	  GridBagConstraints gbc_lbTipProdRes = new GridBagConstraints();
	  gbc_lbTipProdRes.anchor = GridBagConstraints.WEST;
	  gbc_lbTipProdRes.insets = new Insets(2, 3, 0, 0);
	  gbc_lbTipProdRes.gridx = 0;
	  gbc_lbTipProdRes.gridy = 1;
	  panelCentral.add(getLbTipProdRes(), gbc_lbTipProdRes);
	  GridBagConstraints gbc_tprCod = new GridBagConstraints();
	  gbc_tprCod.insets = new Insets(2, 3, 0, 0);
	  gbc_tprCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_tprCod.gridx = 1;
	  gbc_tprCod.gridy = 1;
	  panelCentral.add(getTprCod(), gbc_tprCod);
	  GridBagConstraints gbc_lbDescProReg = new GridBagConstraints();
	  gbc_lbDescProReg.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescProReg.fill = GridBagConstraints.BOTH;
	  gbc_lbDescProReg.gridx = 2;
	  gbc_lbDescProReg.gridy = 1;
	  panelCentral.add(getLbDescProReg(), gbc_lbDescProReg);
	  GridBagConstraints gbc_lbResPro = new GridBagConstraints();
	  gbc_lbResPro.anchor = GridBagConstraints.WEST;
	  gbc_lbResPro.insets = new Insets(2, 3, 0, 0);
	  gbc_lbResPro.gridx = 0;
	  gbc_lbResPro.gridy = 2;
	  panelCentral.add(getLbResPro(), gbc_lbResPro);
	  GridBagConstraints gbc_treCod = new GridBagConstraints();
	  gbc_treCod.insets = new Insets(2, 3, 0, 0);
	  gbc_treCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_treCod.gridx = 1;
	  gbc_treCod.gridy = 2;
	  panelCentral.add(getTreCod(), gbc_treCod);
	  GridBagConstraints gbc_lbDescRegPro = new GridBagConstraints();
	  gbc_lbDescRegPro.fill = GridBagConstraints.BOTH;
	  gbc_lbDescRegPro.insets = new Insets(2, 3, 0, 3);
	  gbc_lbDescRegPro.gridx = 2;
	  gbc_lbDescRegPro.gridy = 2;
	  panelCentral.add(getLbDescRegPro(), gbc_lbDescRegPro);
	}
	return panelCentral;
  }

  private UnJLabel getLbCod() {
	if (lbCod == null) {
	  lbCod = new UnJLabel();
	  lbCod.setForeground(Color.BLUE);
	  lbCod.setText("C\u00F3digo: ");
	}
	return lbCod;
  }

  private EditPratic getCreCod() {
	if (creCod == null) {
	  creCod = new EditPratic();
	  creCod.setCampoResultSetAutomatico(false);
	  creCod.setTipoValidacao("CATEGORIA_REGISTRO");
	  creCod.setName("CRECOD");
	}
	return creCod;
  }

  private UnEdit getCreNom() {
	if (creNom == null) {
	  creNom = new UnEdit();
	  creNom.setName("CRENOM");
	}
	return creNom;
  }

  private UnJLabel getLbTipProdRes() {
	if (lbTipProdRes == null) {
	  lbTipProdRes = new UnJLabel();
	  lbTipProdRes.setText("Tipo de Produto p/ Registro:");
	  lbTipProdRes.setForeground(Color.BLUE);
	}
	return lbTipProdRes;
  }

  private EditPratic getTprCod() {
	if (tprCod == null) {
	  tprCod = new EditPratic();
	  tprCod.setTipoValidacao("TIPO_PRODUTO_REGISTRO");
	  tprCod.setName("TPRCOD");
	  tprCod.setLabelDescricao(getLbDescProReg());
	}
	return tprCod;
  }

  private UnJLabel getLbResPro() {
	if (lbResPro == null) {
	  lbResPro = new UnJLabel();
	  lbResPro.setText("Tipo de Registro do Produto:");
	  lbResPro.setForeground(Color.BLUE);
	}
	return lbResPro;
  }

  private EditPratic getTreCod() {
	if (treCod == null) {
	  treCod = new EditPratic();
	  treCod.setTipoValidacao("tipo_registro");
	  treCod.setName("TRECOD");
	  treCod.setLabelDescricao(getLbDescRegPro());
	}
	return treCod;
  }

  private UnJLabel getLbDescProReg() {
	if (lbDescProReg == null) {
	  lbDescProReg = new UnJLabel();
	  lbDescProReg.setName("TPRCODDES");
	  lbDescProReg.setFont(new Font("Arial", Font.BOLD, 12));
	  lbDescProReg.setText("lbDescProReg");
	}
	return lbDescProReg;
  }

  private UnJLabel getLbDescRegPro() {
	if (lbDescRegPro == null) {
	  lbDescRegPro = new UnJLabel();
	  lbDescRegPro.setFont(new Font("Arial", Font.BOLD, 12));
	  lbDescRegPro.setText("lbDescRegPro");
	  lbDescRegPro.setName("TRECODDES");
	}
	return lbDescRegPro;
  }
}
