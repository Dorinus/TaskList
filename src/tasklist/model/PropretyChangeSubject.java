package tasklist.model;

import java.beans.PropertyChangeListener;

public interface PropretyChangeSubject
{
  void addPropretyChangeListener(PropertyChangeListener listener);
  void addPropretyChangeListener( String eventName,PropertyChangeListener listener);
  void removePropretyChangeListener(PropertyChangeListener listener);
  void removePropretyChangeListener( String eventName,PropertyChangeListener listener);

}
