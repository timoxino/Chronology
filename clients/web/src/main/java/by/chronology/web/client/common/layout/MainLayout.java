package by.chronology.web.client.common.layout;

import by.chronology.web.client.common.Constants;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

/**
 * Main page stretchable layout that is divided into 4 sections: header, navigation, body and footer.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 2/19/13
 */
public class MainLayout implements IsWidget{

    public Widget asWidget() {

        final BorderLayoutContainer borderLayoutContainer = new BorderLayoutContainer();
        borderLayoutContainer.setBorders(true);
        borderLayoutContainer.setNorthWidget(createContentPanel(Constants.Layout.Main.HEADER_PANEL_LABEL), createBorderLayoutData(100, new Margins(5)));
        borderLayoutContainer.setWestWidget(createContentPanel(Constants.Layout.Main.NAVIGATION_PANEL_LABEL), createBorderLayoutData(150, new Margins(0, 5, 0, 5)));
        borderLayoutContainer.setCenterWidget(createContentPanel(Constants.Layout.Main.BODY_PANEL_LABEL), new MarginData(0, 5, 0, 0));
        borderLayoutContainer.setSouthWidget(createContentPanel(Constants.Layout.Main.FOOTER_LABEL), createBorderLayoutData(100, new Margins(5)));

        final SimpleContainer simple = new SimpleContainer();
        simple.add(borderLayoutContainer, new MarginData(0, 15, 15, 0));

        return simple;
    }

    private BorderLayoutData createBorderLayoutData(double size, Margins margins)
    {
        final BorderLayoutData borderLayoutData = new BorderLayoutData(size);
        borderLayoutData.setCollapsible(true);
        borderLayoutData.setSplit(true);
        borderLayoutData.setCollapseMini(true);
        borderLayoutData.setMargins(margins);
        return borderLayoutData;
    }

    private ContentPanel createContentPanel(String label)
    {
        final ContentPanel panel = new ContentPanel();
        panel.setHeadingText(label);
        return panel;
    }
}
