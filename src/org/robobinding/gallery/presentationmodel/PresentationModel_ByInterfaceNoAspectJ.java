package org.robobinding.gallery.presentationmodel;

import java.util.List;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.gallery.model.adapterview.SampleStrings;
import org.robobinding.gallery.model.byinterfacenoaspectj.StringItemPresentationModel_ByInterfaceNoAspectJ;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.property.ObservableBean;
import org.robobinding.property.PropertyChangeListener;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class PresentationModel_ByInterfaceNoAspectJ implements ObservableBean {
    private final PresentationModelChangeSupport presentationModelChangeSupport;

    public PresentationModel_ByInterfaceNoAspectJ() {
	presentationModelChangeSupport = new PresentationModelChangeSupport(this);
    }

    @ItemPresentationModel(value = StringItemPresentationModel_ByInterfaceNoAspectJ.class)
    public List<String> getStrings() {
	return SampleStrings.getSample();
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
