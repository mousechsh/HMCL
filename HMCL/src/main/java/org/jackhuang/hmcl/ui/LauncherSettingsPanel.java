/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.ui;

import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jackhuang.hmcl.util.C;
import org.jackhuang.hmcl.api.HMCLog;
import org.jackhuang.hmcl.api.ui.Theme;
import org.jackhuang.hmcl.setting.Settings;
import org.jackhuang.hmcl.core.download.DownloadType;
import org.jackhuang.hmcl.util.MathUtils;
import org.jackhuang.hmcl.util.sys.IOUtils;
import org.jackhuang.hmcl.util.MessageBox;
import org.jackhuang.hmcl.util.lang.SupportedLocales;
import org.jackhuang.hmcl.util.ui.JFontComboBox;
import org.jackhuang.hmcl.util.ui.JSystemFileChooser;
import org.jackhuang.hmcl.util.ui.Page;
import org.jackhuang.hmcl.util.ui.SwingUtils;

/**
 *
 * @author huangyuhui
 */
public class LauncherSettingsPanel extends RepaintPage {
    
    public LauncherSettingsPanel() {
        setRepainter(this);
    }

    void initGui() {
        initComponents();
        
        animationEnabled = Settings.getInstance().isEnableAnimation();

        DefaultComboBoxModel<String> d = new DefaultComboBoxModel<>();
        for (DownloadType type : DownloadType.values())
            d.addElement(type.getName());
        cboDownloadSource.setModel(d);

        d = new DefaultComboBoxModel<>();
        int id = 0;
        for (SupportedLocales type : SupportedLocales.values()) {
            d.addElement(type.showString());
            if (type.name().equals(Settings.getInstance().getLocalization()))
                id = type.ordinal();
        }
        cboLang.setModel(d);
        cboLang.setSelectedIndex(id);
        
        DefaultComboBoxModel<Theme> g = new DefaultComboBoxModel<>();
        for (Theme t : Theme.THEMES.values())
            g.addElement(t);
        cboTheme.setModel(g);

        txtBackgroundPath.setText(Settings.getInstance().getBgpath());
        txtCommonPath.setText(Settings.getInstance().getCommonpath());
        txtProxyHost.setText(Settings.getInstance().getProxyHost());
        txtProxyPort.setText(Settings.getInstance().getProxyPort());
        txtProxyUsername.setText(Settings.getInstance().getProxyUserName());
        txtProxyPassword.setText(Settings.getInstance().getProxyPassword());
        spinnerFontSize.setValue(Settings.getInstance().getFontSize());
        cboFontFamily.setSelectedItem(Settings.getInstance().getFontFamily());
        cboDownloadSource.setSelectedIndex(Settings.getInstance().getDownloadType());
        cboTheme.setSelectedItem(Settings.getInstance().getTheme());
        chkEnableShadow.setSelected(Settings.getInstance().isEnableShadow());
        chkEnableBlur.setSelected(Settings.getInstance().isEnableBlur());
        chkEnableAnimation.setSelected(Settings.getInstance().isEnableAnimation());
        chkDecorated.setSelected(Settings.getInstance().isDecorated());
    }

    @Override
    public void onCreate() {
        initGui();
        super.onCreate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModpack = new javax.swing.JLabel();
        lblRestart = new javax.swing.JLabel();
        tabLauncherSettings = new NewTabPane();
        pnlGeneral = new Page().setAnimationEnabled(Settings.getInstance().isEnableAnimation());
        lblProxy = new javax.swing.JLabel();
        lblProxyHost = new javax.swing.JLabel();
        txtProxyHost = new javax.swing.JTextField();
        lblProxyPort = new javax.swing.JLabel();
        txtProxyPort = new javax.swing.JTextField();
        lblProxyUserName = new javax.swing.JLabel();
        txtProxyUsername = new javax.swing.JTextField();
        lblProxyPassword = new javax.swing.JLabel();
        txtProxyPassword = new javax.swing.JTextField();
        cboDownloadSource = new javax.swing.JComboBox();
        lblDownloadSource = new javax.swing.JLabel();
        lblCommonPath = new javax.swing.JLabel();
        txtCommonPath = new javax.swing.JTextField();
        btnSetCommonPath = new javax.swing.JButton();
        btnCheckUpdate = new javax.swing.JButton();
        btnMCBBS = new javax.swing.JButton();
        cboLang = new javax.swing.JComboBox();
        lblLang = new javax.swing.JLabel();
        pnlUI = new Page().setAnimationEnabled(Settings.getInstance().isEnableAnimation());
        lblTheme = new javax.swing.JLabel();
        cboTheme = new javax.swing.JComboBox();
        lblBackground = new javax.swing.JLabel();
        txtBackgroundPath = new javax.swing.JTextField();
        chkEnableShadow = new javax.swing.JCheckBox();
        chkEnableBlur = new javax.swing.JCheckBox();
        chkEnableAnimation = new javax.swing.JCheckBox();
        chkDecorated = new javax.swing.JCheckBox();
        btnSelBackgroundPath = new javax.swing.JButton();
        cboFontFamily = new JFontComboBox();
        lblFont = new javax.swing.JLabel();
        spinnerFontSize = new javax.swing.JSpinner();
        lblExample = new javax.swing.JLabel();
        pnlAbout = new Page().setAnimationEnabled(Settings.getInstance().isEnableAnimation());
        lblAbout = new javax.swing.JLabel();

        lblModpack.setText(C.i18n("launcher.modpack")); // NOI18N
        lblModpack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModpack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModpackMouseClicked(evt);
            }
        });

        lblRestart.setText(C.i18n("launcher.restart")); // NOI18N

        lblProxy.setText(C.i18n("launcher.proxy")); // NOI18N

        lblProxyHost.setText(C.i18n("proxy.host")); // NOI18N

        txtProxyHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyHostFocusLost(evt);
            }
        });

        lblProxyPort.setText(C.i18n("proxy.port")); // NOI18N

        txtProxyPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyPortFocusLost(evt);
            }
        });

        lblProxyUserName.setText(C.i18n("proxy.username")); // NOI18N

        txtProxyUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyUsernameFocusLost(evt);
            }
        });

        lblProxyPassword.setText(C.i18n("proxy.password")); // NOI18N

        txtProxyPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyPasswordFocusLost(evt);
            }
        });

        cboDownloadSource.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDownloadSourceItemStateChanged(evt);
            }
        });

        lblDownloadSource.setText(C.i18n("launcher.download_source")); // NOI18N

        lblCommonPath.setText(C.i18n("launcher.common_location")); // NOI18N

        txtCommonPath.setToolTipText(C.i18n("launcher.commpath_tooltip")); // NOI18N
        txtCommonPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCommonPathFocusLost(evt);
            }
        });

        btnSetCommonPath.setText(C.i18n("ui.button.explore")); // NOI18N
        btnSetCommonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetCommonPathActionPerformed(evt);
            }
        });

        btnCheckUpdate.setText(C.i18n("launcher.update_launcher")); // NOI18N
        btnCheckUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckUpdateActionPerformed(evt);
            }
        });

        btnMCBBS.setText("MCBBS");
        btnMCBBS.setToolTipText("");
        btnMCBBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCBBSActionPerformed(evt);
            }
        });

        cboLang.setModel(new DefaultComboBoxModel(new String[]{C.i18n("color.blue"),C.i18n("color.green"),C.i18n("color.purple"),C.i18n("color.dark_blue"),C.i18n("color.orange"),C.i18n("color.red")}));
        cboLang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLangItemStateChanged(evt);
            }
        });

        lblLang.setText(C.i18n("launcher.lang")); // NOI18N

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(btnCheckUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMCBBS)
                        .addGap(0, 418, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblProxy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProxyHost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDownloadSource)
                            .addComponent(lblCommonPath)
                            .addComponent(lblLang))
                        .addGap(28, 28, 28)
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(txtCommonPath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSetCommonPath))
                            .addComponent(cboDownloadSource, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommonPath)
                    .addComponent(txtCommonPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetCommonPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDownloadSource)
                    .addComponent(cboDownloadSource, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxy)
                    .addComponent(lblProxyHost)
                    .addComponent(txtProxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyPort)
                    .addComponent(txtProxyUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyUserName)
                    .addComponent(txtProxyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCBBS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabLauncherSettings.addTab(C.i18n("launcher.tab.general"), pnlGeneral); // NOI18N

        lblTheme.setText(C.i18n("launcher.theme")); // NOI18N

        cboTheme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThemeItemStateChanged(evt);
            }
        });

        lblBackground.setText(C.i18n("launcher.background_location")); // NOI18N
        lblBackground.setToolTipText("");

        txtBackgroundPath.setToolTipText(C.i18n("launcher.background_tooltip")); // NOI18N
        txtBackgroundPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBackgroundPathFocusLost(evt);
            }
        });

        chkEnableShadow.setText(C.i18n("launcher.enable_shadow")); // NOI18N
        chkEnableShadow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableShadowItemStateChanged(evt);
            }
        });

        chkEnableBlur.setText(C.i18n("launcher.enable_blur")); // NOI18N
        chkEnableBlur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableBlurItemStateChanged(evt);
            }
        });

        chkEnableAnimation.setText(C.i18n("launcher.enable_animation")); // NOI18N
        chkEnableAnimation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableAnimationItemStateChanged(evt);
            }
        });

        chkDecorated.setText(C.i18n("launcher.decorated")); // NOI18N
        chkDecorated.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkDecoratedItemStateChanged(evt);
            }
        });

        btnSelBackgroundPath.setText(C.i18n("ui.button.explore")); // NOI18N
        btnSelBackgroundPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelBackgroundPathActionPerformed(evt);
            }
        });

        cboFontFamily.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFontFamilyItemStateChanged(evt);
            }
        });

        lblFont.setText(C.i18n("launcher.log_font")); // NOI18N

        spinnerFontSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerFontSizeStateChanged(evt);
            }
        });

        lblExample.setText("19:10:10 [Client Thread/INFO]: Example");

        javax.swing.GroupLayout pnlUILayout = new javax.swing.GroupLayout(pnlUI);
        pnlUI.setLayout(pnlUILayout);
        pnlUILayout.setHorizontalGroup(
            pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUILayout.createSequentialGroup()
                        .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDecorated)
                            .addGroup(pnlUILayout.createSequentialGroup()
                                .addComponent(chkEnableShadow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkEnableBlur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkEnableAnimation)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(pnlUILayout.createSequentialGroup()
                        .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBackground)
                            .addComponent(lblFont)
                            .addComponent(lblTheme))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTheme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlUILayout.createSequentialGroup()
                                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBackgroundPath)
                                    .addComponent(cboFontFamily, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSelBackgroundPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerFontSize)))
                            .addGroup(pnlUILayout.createSequentialGroup()
                                .addComponent(lblExample)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlUILayout.setVerticalGroup(
            pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBackground)
                    .addComponent(txtBackgroundPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelBackgroundPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFontFamily, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFont)
                    .addComponent(spinnerFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblExample)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTheme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(pnlUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEnableShadow)
                    .addComponent(chkEnableBlur)
                    .addComponent(chkEnableAnimation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkDecorated)
                .addContainerGap())
        );

        tabLauncherSettings.addTab(C.i18n("launcher.tab.ui"), pnlUI); // NOI18N

        lblAbout.setText(C.i18n("launcher.about")); // NOI18N
        lblAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlAboutLayout = new javax.swing.GroupLayout(pnlAbout);
        pnlAbout.setLayout(pnlAboutLayout);
        pnlAboutLayout.setHorizontalGroup(
            pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnlAboutLayout.setVerticalGroup(
            pnlAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabLauncherSettings.addTab(C.i18n("launcher.tab.about"), pnlAbout); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModpack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRestart))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tabLauncherSettings)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabLauncherSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModpack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRestart)
                .addContainerGap())
        );

        tabLauncherSettings.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void cboDownloadSourceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDownloadSourceItemStateChanged
        Settings.getInstance().setDownloadType(cboDownloadSource.getSelectedIndex());
    }//GEN-LAST:event_cboDownloadSourceItemStateChanged

    private void btnSelBackgroundPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelBackgroundPathActionPerformed
        JSystemFileChooser fc = new JSystemFileChooser();
        fc.setFileSelectionMode(JSystemFileChooser.FILES_ONLY);
        fc.setDialogTitle(C.i18n("launcher.choose_bgpath"));
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
        if (fc.showOpenDialog(this) != JSystemFileChooser.APPROVE_OPTION || fc.getSelectedFile() == null)
            return;
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            path = IOUtils.removeLastSeparator(path);
            txtBackgroundPath.setText(path);
            Settings.getInstance().setBgpath(path);
            MainFrame.INSTANCE.loadBackground();
        } catch (IOException e) {
            HMCLog.warn("Failed to set background path.", e);
            MessageBox.show(C.i18n("ui.label.failed_set") + e.getMessage());
        }
    }//GEN-LAST:event_btnSelBackgroundPathActionPerformed

    private void txtBackgroundPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBackgroundPathFocusLost
        Settings.getInstance().setBgpath(txtBackgroundPath.getText());
        MainFrame.INSTANCE.loadBackground();
    }//GEN-LAST:event_txtBackgroundPathFocusLost

    private void btnCheckUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckUpdateActionPerformed
        Settings.UPDATE_CHECKER.process(true);
        Settings.UPDATE_CHECKER.checkOutdate();
    }//GEN-LAST:event_btnCheckUpdateActionPerformed

    private void cboThemeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThemeItemStateChanged
        Settings.getInstance().setTheme(((Theme) cboTheme.getSelectedItem()).id);
    }//GEN-LAST:event_cboThemeItemStateChanged

    private void lblModpackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModpackMouseClicked
        SwingUtils.openLink("http://huangyuhui.duapp.com/link.php?type=modpack");
    }//GEN-LAST:event_lblModpackMouseClicked

    private void cboLangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLangItemStateChanged
        Settings.getInstance().setLocalization(SupportedLocales.values()[cboLang.getSelectedIndex()].name());
    }//GEN-LAST:event_cboLangItemStateChanged

    private void chkEnableShadowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableShadowItemStateChanged
        Settings.getInstance().setEnableShadow(chkEnableShadow.isSelected());
    }//GEN-LAST:event_chkEnableShadowItemStateChanged

    private void chkDecoratedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkDecoratedItemStateChanged
        Settings.getInstance().setDecorated(chkDecorated.isSelected());
    }//GEN-LAST:event_chkDecoratedItemStateChanged

    private void txtProxyHostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyHostFocusLost
        Settings.getInstance().setProxyHost(txtProxyHost.getText());
    }//GEN-LAST:event_txtProxyHostFocusLost

    private void txtProxyPortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyPortFocusLost
        Settings.getInstance().setProxyPort(txtProxyPort.getText());
    }//GEN-LAST:event_txtProxyPortFocusLost

    private void txtProxyUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyUsernameFocusLost
        Settings.getInstance().setProxyUserName(txtProxyUsername.getText());
    }//GEN-LAST:event_txtProxyUsernameFocusLost

    private void txtProxyPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyPasswordFocusLost
        Settings.getInstance().setProxyPassword(txtProxyPassword.getText());
    }//GEN-LAST:event_txtProxyPasswordFocusLost

    private void btnMCBBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCBBSActionPerformed
        SwingUtils.openLink(C.URL_PUBLISH);
    }//GEN-LAST:event_btnMCBBSActionPerformed

    private void chkEnableBlurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableBlurItemStateChanged
        Settings.getInstance().setEnableBlur(chkEnableBlur.isSelected());
    }//GEN-LAST:event_chkEnableBlurItemStateChanged

    private void chkEnableAnimationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableAnimationItemStateChanged
        Settings.getInstance().setEnableAnimation(chkEnableAnimation.isSelected());
    }//GEN-LAST:event_chkEnableAnimationItemStateChanged

    private void btnSetCommonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetCommonPathActionPerformed
        JSystemFileChooser fc = new JSystemFileChooser();
        fc.setFileSelectionMode(JSystemFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle(C.i18n("launcher.choose_commonpath"));
        fc.setMultiSelectionEnabled(false);
        if (fc.showOpenDialog(this) != JSystemFileChooser.APPROVE_OPTION || fc.getSelectedFile() == null)
            return;
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            txtCommonPath.setText(path);
            Settings.getInstance().setCommonpath(path);
        } catch (IOException e) {
            HMCLog.warn("Failed to set common path.", e);
            MessageBox.show(C.i18n("ui.label.failed_set") + e.getMessage());
        }
    }//GEN-LAST:event_btnSetCommonPathActionPerformed

    private void txtCommonPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCommonPathFocusLost
        Settings.getInstance().setCommonpath(txtCommonPath.getText());
    }//GEN-LAST:event_txtCommonPathFocusLost

    private void cboFontFamilyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFontFamilyItemStateChanged
        Settings.getInstance().setFontFamily(evt.getItem().toString());
        lblExample.setFont(Settings.getInstance().getConsoleFont());
    }//GEN-LAST:event_cboFontFamilyItemStateChanged

    private void spinnerFontSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerFontSizeStateChanged
        Settings.getInstance().setFontSize(MathUtils.parseInt(spinnerFontSize.getValue().toString(), 12));
        lblExample.setFont(Settings.getInstance().getConsoleFont());
    }//GEN-LAST:event_spinnerFontSizeStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckUpdate;
    private javax.swing.JButton btnMCBBS;
    private javax.swing.JButton btnSelBackgroundPath;
    private javax.swing.JButton btnSetCommonPath;
    private javax.swing.JComboBox cboDownloadSource;
    private javax.swing.JComboBox cboFontFamily;
    private javax.swing.JComboBox cboLang;
    private javax.swing.JComboBox cboTheme;
    private javax.swing.JCheckBox chkDecorated;
    private javax.swing.JCheckBox chkEnableAnimation;
    private javax.swing.JCheckBox chkEnableBlur;
    private javax.swing.JCheckBox chkEnableShadow;
    private javax.swing.JLabel lblAbout;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCommonPath;
    private javax.swing.JLabel lblDownloadSource;
    private javax.swing.JLabel lblExample;
    private javax.swing.JLabel lblFont;
    private javax.swing.JLabel lblLang;
    private javax.swing.JLabel lblModpack;
    private javax.swing.JLabel lblProxy;
    private javax.swing.JLabel lblProxyHost;
    private javax.swing.JLabel lblProxyPassword;
    private javax.swing.JLabel lblProxyPort;
    private javax.swing.JLabel lblProxyUserName;
    private javax.swing.JLabel lblRestart;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JPanel pnlAbout;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlUI;
    private javax.swing.JSpinner spinnerFontSize;
    private javax.swing.JTabbedPane tabLauncherSettings;
    private javax.swing.JTextField txtBackgroundPath;
    private javax.swing.JTextField txtCommonPath;
    private javax.swing.JTextField txtProxyHost;
    private javax.swing.JTextField txtProxyPassword;
    private javax.swing.JTextField txtProxyPort;
    private javax.swing.JTextField txtProxyUsername;
    // End of variables declaration//GEN-END:variables
}
