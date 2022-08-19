package br.com.praticsistemas.pratic.faturamento.cadastros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class CadasTipoDeProdutoParaRegistro extends UnCadastro {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbCodProd;
  private EditPratic tipCodProd;
  private UnEdit descTipCodProd;

  public CadasTipoDeProdutoParaRegistro() {
	initialize();
  }

  private void initialize() {
	setCampoTelaTrabalho(getTipCodProd());
	setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_TIPO_PRODUTO_REGISTRO");
	this.setTitle("Cadastro Tipo de produto para Registro");
	this.setCodigoTela("4306");
	this.setSize(new Dimension(537, 128));
	this.setBotaoImprimir(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.setCampoFocoAberturaTela(getTipCodProd());
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.cadasTipoDeProdutoParaRegistro = null;
	  }
	});
  }

  public boolean gravaTela() {

	int param = 1;

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_TIPO_PRODUTO_REGISTRO", 3, 2));
	  stp.registerOutParameter(param++, Types.BIGINT);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setStp(stp);
	  getProc().setInt(param++, getTipCodProd(), stp);
	  getProc().setString(param++, getDescTipCodProd(), stp);
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
	  gbl_panelCentral.columnWidths = new int[] { 54, 62, 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 0, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_lbCodProd = new GridBagConstraints();
	  gbc_lbCodProd.fill = GridBagConstraints.BOTH;
	  gbc_lbCodProd.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCodProd.gridx = 0;
	  gbc_lbCodProd.gridy = 0;
	  panelCentral.add(getLbTipCodProd(), gbc_lbCodProd);
	  GridBagConstraints gbc_CodProd = new GridBagConstraints();
	  gbc_CodProd.insets = new Insets(2, 3, 0, 0);
	  gbc_CodProd.fill = GridBagConstraints.HORIZONTAL;
	  gbc_CodProd.gridx = 1;
	  gbc_CodProd.gridy = 0;
	  panelCentral.add(getTipCodProd(), gbc_CodProd);
	  GridBagConstraints gbc_DescCod = new GridBagConstraints();
	  gbc_DescCod.insets = new Insets(2, 3, 0, 3);
	  gbc_DescCod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_DescCod.gridx = 2;
	  gbc_DescCod.gridy = 0;
	  panelCentral.add(getDescTipCodProd(), gbc_DescCod);
	}
	return panelCentral;
  }

  private UnJLabel getLbTipCodProd() {
	if (lbCodProd == null) {
	  lbCodProd = new UnJLabel();
	  lbCodProd.setForeground(Color.BLUE);
	  lbCodProd.setText("C\u00F3digo:");

	}
	return lbCodProd;
  }

  private EditPratic getTipCodProd() {
	if (tipCodProd == null) {
	  tipCodProd = new EditPratic();
	  tipCodProd.setCampoResultSetAutomatico(false);
	  tipCodProd.setTipoValidacao("TIPO_PRODUTO_REGISTRO");
	  tipCodProd.setName("tprcod");
	}
	return tipCodProd;
  }

  private UnEdit getDescTipCodProd() {
	if (descTipCodProd == null) {
	  descTipCodProd = new UnEdit();
	  descTipCodProd.setName("tprnom");
	  descTipCodProd.setText("");
	}
	return descTipCodProd;
  }
}
