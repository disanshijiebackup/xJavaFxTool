package com.xwintop.xJavaFxTool.controller.littleTools;

import com.xwintop.xJavaFxTool.services.littleTools.FileRenameToolService;
import com.xwintop.xJavaFxTool.utils.JavaFxViewUtil;
import com.xwintop.xJavaFxTool.view.littleTools.FileRenameToolView;
import com.xwintop.xcore.util.javafx.FileChooserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Getter
@Setter
@Log4j
public class FileRenameToolController extends FileRenameToolView {
    private FileRenameToolService fileRenameToolService = new FileRenameToolService(this);
    private ObservableList<Map<String, String>> ruleTableData = FXCollections.observableArrayList();
    private ObservableList<Map<String, String>> fileInfoTableData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initView();
        initEvent();
        initService();
    }

    private void initView() {
        JavaFxViewUtil.setTableColumnMapValueFactory(orderTableColumn, "order",false);
        JavaFxViewUtil.setTableColumnMapValueFactory(ruleTableColumn, "rule");
        JavaFxViewUtil.setTableColumnMapValueFactory(explainTableColumn, "explain");
        ruleTableView.setItems(ruleTableData);
        JavaFxViewUtil.setTableColumnMapAsCheckBoxValueFactory(statusTableColumn, "status");
        JavaFxViewUtil.setTableColumnMapValueFactory(fileNameTableColumn, "fileName");
        JavaFxViewUtil.setTableColumnMapValueFactory(newFileNameTableColumn, "newFileName");
        JavaFxViewUtil.setTableColumnMapValueFactory(errorInfoTableColumn, "errorInfo");
        JavaFxViewUtil.setTableColumnMapValueFactory(filesPathTableColumn, "filesPath");
        fileInfoTableView.setItems(fileInfoTableData);
    }

    private void initEvent() {

    }

    private void initService() {
    }

    @FXML
    private void addFileAction(ActionEvent event) {
        File file = FileChooserUtil.chooseFile();
        if (file != null) {
            Map<String, String> dataRow = new HashMap<String, String>();
            dataRow.put("status","true");
            dataRow.put("fileName",file.getName());
            dataRow.put("newFileName","");
            dataRow.put("errorInfo","");
            dataRow.put("filesPath",file.getPath());
            fileInfoTableData.add(dataRow);
        }
    }

    @FXML
    private void addFolderAction(ActionEvent event) {
        File folderFile = FileChooserUtil.chooseDirectory();
        if (folderFile != null) {
            for (File file : FileUtils.listFiles(folderFile, null, false)) {
                Map<String, String> dataRow = new HashMap<String, String>();
                dataRow.put("status","true");
                dataRow.put("fileName",file.getName());
                dataRow.put("newFileName","");
                dataRow.put("errorInfo","");
                dataRow.put("filesPath",file.getPath());
                fileInfoTableData.add(dataRow);
            }
        }
    }

    @FXML
    private void previewAction(ActionEvent event) {
    }

    @FXML
    private void renameAction(ActionEvent event) {
    }

    @FXML
    private void addRoleTableAction(ActionEvent event) {
        Map<String, String> dataRow = new HashMap<String, String>();
        dataRow.put("order","true");
        dataRow.put("rule","true");
        dataRow.put("explain","true");
        ruleTableData.add(dataRow);
    }

    @FXML
    private void removeRuleTableAction(ActionEvent event) {
    }

    @FXML
    private void upRuleTableAction(ActionEvent event) {
    }

    @FXML
    private void downRuleTableAction(ActionEvent event) {
    }
}