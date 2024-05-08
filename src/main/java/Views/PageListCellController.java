package Views;

import conexion.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.ViewTransitionModelInterface;

public class PageListCellController {

    @FXML
    private Label itemName;

    @FXML
    private Label pageNameLabel;

    protected Page parent;
    private PageListCell model;
    private ViewTransitionModelInterface vtm;

    public void setModel(PageListCell cell) {
        this.model = cell;
    }



    public void updateView(Page item) {
        if (item == null) {
            pageNameLabel.setText("");
        } else {
            pageNameLabel.setText(item.toString());
        }
    }

    @FXML
    void onItemClicked(MouseEvent event) {
        if (this.model != null && this.model.getItem() != null) {
            model.showItem();
        }
    }

    @FXML
    void onClickedPageNameLabel(MouseEvent event) {
        if (this.model != null && this.model.getItem() != null) {
            model.showItem();
        }
    }

    public Label getItemName() {
        return itemName;
    }

    public void setItemName(Label itemName) {
        this.itemName = itemName;
    }

    public ViewTransitionModelInterface getVtm() {
        return vtm;
    }

    public void setVtm(ViewTransitionModelInterface vtm) {
        this.vtm = vtm;
    }

    public Label getPageNameLabel() {
        return pageNameLabel;
    }

    public void setPageNameLabel(Label pageNameLabel) {
        this.pageNameLabel = pageNameLabel;
    }

    public PageListCell getModel() {
        return model;
    }

    public Page getParent() {
        return parent;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }
}
