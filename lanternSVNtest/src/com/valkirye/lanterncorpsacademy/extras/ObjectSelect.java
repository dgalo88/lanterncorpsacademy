package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;

import com.valkirye.lanterncorpsacademy.components.ActionListenerProxy;

@SuppressWarnings("serial")
public class ObjectSelect extends Component{

	private ActionListenerProxy actionListenerProxy = new ActionListenerProxy(
			new EventListenerList());

	private Row row;
//	private Column col;
	
	public ObjectSelect(String string) {

		row = new Row();

		Button btn = new Button(string);
//		btn.setStyle(ButtonStyle.NORMAL_STYLE);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				objectClicked();
			}
		});

		row.add(btn);

	}

	public class item extends Button{

		public item() {

			Row rowI = new Row();
			Column colI = new Column();

			Label lblImagen = new Label();
			lblImagen.setIcon(new ResourceImageReference(
					"/com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg",
					new Extent(30), new Extent(30)));
			colI.add(lblImagen);
			rowI.add(colI);

			colI = new Column();

			Label lblTitulo = new Label("$Nombre");
			Label lblAtaque = new Label("Ataque: AA");
			Label lblDefensa = new Label("Defensa: DD");

			colI.add(lblTitulo);
			colI.add(lblAtaque);
			colI.add(lblDefensa);
			rowI.add(colI);

			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					objectClicked();
				}
			});

		}
	}

	private void objectClicked() {
		actionListenerProxy.fireActionEvent(new ActionEvent(this, null));
	}

	public ActionListenerProxy getActionListenerProxy() {
		return actionListenerProxy;
	}

	public Component getItem() {
		return row;
	}

}
