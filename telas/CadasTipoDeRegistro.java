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

public class CadasTipoDeRegistro extends UnCadastro {

  private static final long serialVersionUID = 1L;
  private JPanel panelCentral;
  private UnJLabel lbCod;
  private EditPratic treCod;
  private UnEdit treNom;

  public CadasTipoDeRegistro() {
	initialize();
  }

  private void initialize() {
	setCampoTelaTrabalhoSqlViewMontaTela("ES_VIEW_TIPO_REGISTRO");
	this.setTitle("Tipo de Registro");
	this.setCodigoTela("4307");
	this.setSize(new Dimension(537, 128));
	this.setBotaoImprimir(false);
	this.getContentPane().add(getPanelCentral(), BorderLayout.CENTER);
	this.setCampoTelaTrabalho(getTreCod());
	this.setCampoFocoAberturaTela(getTreCod());
	this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
	  public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
		DeskPratic.telasFinan.abrirCadasTipoDeRegistro = null;
	  }
	});
  }

  public boolean gravaTela() {

	int param = 1;

	try {
	  stp = getConexao().prepareCall(getProc().montaParametros("ES_FAZ_TIPO_REGISTRO", 3, 2));
	  stp.registerOutParameter(param++, Types.BIGINT);
	  stp.registerOutParameter(param++, Types.VARCHAR);

	  getProc().setStp(stp);
	  getProc().setInt(param++, getTreCod(), stp);
	  getProc().setString(param++, getTreNom(), stp);
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
	  gbl_panelCentral.columnWidths = new int[] { 0, 50, 0, 0 };
	  gbl_panelCentral.rowHeights = new int[] { 25, 0 };
	  gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
	  gbl_panelCentral.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	  panelCentral.setLayout(gbl_panelCentral);
	  GridBagConstraints gbc_lbCod = new GridBagConstraints();
	  gbc_lbCod.anchor = GridBagConstraints.EAST;
	  gbc_lbCod.insets = new Insets(2, 3, 0, 0);
	  gbc_lbCod.gridx = 0;
	  gbc_lbCod.gridy = 0;
	  panelCentral.add(getLbCod(), gbc_lbCod);
	  GridBagConstraints gbc_Cod = new GridBagConstraints();
	  gbc_Cod.insets = new Insets(2, 3, 0, 0);
	  gbc_Cod.fill = GridBagConstraints.HORIZONTAL;
	  gbc_Cod.gridx = 1;
	  gbc_Cod.gridy = 0;
	  panelCentral.add(getTreCod(), gbc_Cod);
	  GridBagConstraints gbc_treNom = new GridBagConstraints();
	  gbc_treNom.insets = new Insets(2, 3, 0, 3);
	  gbc_treNom.fill = GridBagConstraints.HORIZONTAL;
	  gbc_treNom.gridx = 2;
	  gbc_treNom.gridy = 0;
	  panelCentral.add(getTreNom(), gbc_treNom);
	}
	return panelCentral;
  }

  private UnJLabel getLbCod() {
	if (lbCod == null) {
	  lbCod = new UnJLabel();
	  lbCod.setForeground(Color.BLUE);
	  lbCod.setText("C\u00F3digo:");
	}
	return lbCod;
  }

  private EditPratic getTreCod() {
	if (treCod == null) {
	  treCod = new EditPratic();
	  treCod.setTipoValidacao("tipo_registro");
	  treCod.setName("trecod");
	}
	return treCod;
  }

  private UnEdit getTreNom() {
	if (treNom == null) {
	  treNom = new UnEdit();
	  treNom.setName("trenom");
	  treNom.setText("");
	}
	return treNom;
  }
}
