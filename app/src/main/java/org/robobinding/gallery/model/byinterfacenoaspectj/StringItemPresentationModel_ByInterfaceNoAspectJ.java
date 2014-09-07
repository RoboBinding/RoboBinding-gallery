package org.robobinding.gallery.model.byinterfacenoaspectj;

import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.property.ObservableBean;
import org.robobinding.property.PropertyChangeListener;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class StringItemPresentationModel_ByInterfaceNoAspectJ implements ItemPresentationModel<String>, ObservableBean {
    private final PresentationModelChangeSupport presentationModelChangeSupport;

    private String value;

    public StringItemPresentationModel_ByInterfaceNoAspectJ() {
	presentationModelChangeSupport = new PresentationModelChangeSupport(this);
    }
    
    @Override
    public void updateData(int index, String bean) {
	value = bean;
	presentationModelChangeSupport.refreshPresentationModel();
    }

    public String getValue() {
	return value;
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
	presentationModelChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
	presentationModelChangeSupport.removePropertyChangeListener(propertyName, listener);
    }
}
