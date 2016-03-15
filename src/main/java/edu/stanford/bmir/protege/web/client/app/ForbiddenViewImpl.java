package edu.stanford.bmir.protege.web.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 14/03/16
 */
public class ForbiddenViewImpl extends Composite implements ForbiddenView {

    interface ForbiddenViewImplUiBinder extends UiBinder<HTMLPanel, ForbiddenViewImpl> {

    }

    private static ForbiddenViewImplUiBinder ourUiBinder = GWT.create(ForbiddenViewImplUiBinder.class);

    public ForbiddenViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}