package com.ped.simple.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DragEndEvent;
import com.google.gwt.event.dom.client.DragEndHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.ped.simple.client.Teaching;
import com.ped.simple.client.TeachingType;

public class main implements EntryPoint {

	private Teaching TAP = new Teaching(TeachingType.COURS, "pNarbel", 10, 1, 1, null, "Tech Ava de Prog");//new int[1]);
	private Teaching ALD = new Teaching(TeachingType.COURS, "dBromberg", 10, 5, 1, null, "Archi Log Distrib");
	private Teaching CP = new Teaching(TeachingType.COURS, "xBlanc", 10, 5, 1, null, "Conduite Projet");
	
	private Label itemTAP;
	private Label itemALD;
	private Label itemCP;
	
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		
		Tree tree = new Tree();
		tree.setStyleName("dialogVPanel");
		rootPanel.add(tree, 1, 1);
		tree.setSize("50px", "100px");
		
		itemTAP = new Label("TAP");
		itemTAP.getElement().setPropertyObject("teachingObject", TAP);
		itemTAP.getElement().setDraggable(Element.DRAGGABLE_AUTO);
		
		itemTAP.addDragStartHandler(new DragStartHandler() {
			public void onDragStart(DragStartEvent event) {
				event.setData("css", "module1");
				event.setData("name", ((Teaching) itemTAP.getElement().getPropertyObject("teachingObject")).getTeacher());
				event.setData("id", String.valueOf(((Teaching) itemTAP.getElement().getPropertyObject("teachingObject")).getModule()));
				event.getDataTransfer().setDragImage(itemTAP.getElement(), 10, 10);
			}
		});
		
		/*
		itemTAP.addDragEndHandler(new DragEndHandler() {
			@Override
			public void onDragEnd(DragEndEvent event) {
				//all session is already planned
				itemTAP.setText("coucou");
				//if(TAP.getSceances().length >= TAP.getNbSceance()) {
					//itemTAP.getElement().setDraggable(Element.DRAGGABLE_FALSE);
					//itemTAP.getElement().
				//}
			}
		});
		*/
		
		
		itemALD = new Label("ALD");
		itemALD.getElement().setPropertyObject("teachingObject", ALD);
		itemALD.getElement().setDraggable(Element.DRAGGABLE_TRUE);
		
		itemALD.addDragStartHandler(new DragStartHandler() {
			public void onDragStart(DragStartEvent event) {
				event.setData("css", "module2");
				event.setData("name", ((Teaching) itemALD.getElement().getPropertyObject("teachingObject")).getTeacher());
				event.setData("id", String.valueOf(((Teaching) itemALD.getElement().getPropertyObject("teachingObject")).getModule()));
				event.getDataTransfer().setDragImage(itemALD.getElement(), 10, 10);
			}
		});
		
		/*
		itemCP = new Label("CP");
		itemCP.getElement().setPropertyObject("teachingObject", CP);
		itemCP.getElement().setDraggable(Element.DRAGGABLE_TRUE);
		
		itemCP.addDragStartHandler(new DragStartHandler() {
			public void onDragStart(DragStartEvent event) {
				event.setData("css", "module3");
				event.setData("name", ((Teaching) itemCP.getElement().getPropertyObject("teachingObject")).getTeacher());
				event.setData("id", String.valueOf(((Teaching) itemCP.getElement().getPropertyObject("teachingObject")).getId()));
				event.getDataTransfer().setDragImage(itemCP.getElement(), 10, 10);
			}
		});
		*/
		
		TreeItem cours = new TreeItem("cours");
		cours.addItem(createTreeItem(TAP));
		cours.addItem(createTreeItem(ALD));
		cours.addItem(createTreeItem(CP));
		tree.addItem(cours);
		
		final FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("test");
		flexTable.setBorderWidth(1);
		flexTable.setCellSpacing(0);
		rootPanel.add(flexTable, 150, 10);
		flexTable.setSize("620px", "500px");
		
		//day's column
		Label mondayL = new Label();
		mondayL.setText("Lundi");
		mondayL.setSize("50px", "70px");
		mondayL.setStyleName("notEditable");
		flexTable.setWidget(1, 0, mondayL);
		
		Label tuesdayL = new Label();
		tuesdayL.setText("Mardi");
		tuesdayL.setSize("50px", "70px");
		tuesdayL.setStyleName("notEditable");
		flexTable.setWidget(2, 0, tuesdayL);
		
		Label wedL = new Label();
		wedL.setText("Mercredi");
		wedL.setSize("50px", "70px");
		wedL.setStyleName("notEditable");
		flexTable.setWidget(3, 0, wedL);
		
		Label thursdayL = new Label();
		thursdayL.setText("Jeudi");
		thursdayL.setSize("50px", "70px");
		thursdayL.setStyleName("notEditable");
		flexTable.setWidget(4, 0, thursdayL);
		
		Label fridayL = new Label();
		fridayL.setText("Vendredi");
		fridayL.setSize("50px", "70px");
		fridayL.setStyleName("notEditable");
		flexTable.setWidget(5, 0, fridayL);
		
		//hour's row
		Label h1 = new Label();
		h1.setText("8h - 9h20");
		h1.setSize("100px", "50px");
		h1.setStyleName("notEditable");
		flexTable.setWidget(0, 1, h1);
		
		Label h2 = new Label();
		h2.setText("9h30 - 10h50");
		h2.setSize("100px", "50px");
		h2.setStyleName("notEditable");
		flexTable.setWidget(0, 2, h2);
		
		Label h3 = new Label();
		h3.setText("11h - 12h20");
		h3.setSize("100px", "50px");
		h3.setStyleName("notEditable");
		flexTable.setWidget(0, 3, h3);
		
		Label h4 = new Label();
		h4.setText("13h50 - 15h10");
		h4.setSize("100px", "50px");
		h4.setStyleName("notEditable");
		flexTable.setWidget(0, 4, h4);
		
		Label h5 = new Label();
		h5.setText("15h20 - 16h40");
		h5.setSize("100px", "50px");
		h5.setStyleName("notEditable");
		flexTable.setWidget(0, 5, h5);
		
		Label h6 = new Label();
		h6.setText("16h50 - 18h10");
		h6.setSize("100px", "50px");
		h6.setStyleName("notEditable");
		flexTable.setWidget(0, 6, h6);
		
		
		//grid part
		for (int i=1; i<=5; i++) { //row
			for (int j=1; j<=6; j++) { //column
				
				final VerticalPanel vPanel;
				
				vPanel = new VerticalPanel();
				vPanel.setStyleName("vPanel");
				vPanel.setSize("100%", "100%");
				vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				//vPanel.setBorderWidth(2);
				
				createBackPanel(vPanel);
				
				vPanel.addDomHandler(new DragOverHandler() {
					public void onDragOver(DragOverEvent event) {
					}
				}, DragOverEvent.getType());
				vPanel.addDomHandler(new DropHandler() {
					public void onDrop(DropEvent event) {
						
						if(vPanel.getWidget(0).getElement().getPropertyBoolean("isBackPanel")) {
							vPanel.remove(0);
						}
						
						Label newL = new Label(event.getData("name") + "\n" + event.getData("id"));
						newL.setStyleName(event.getData("css"));
						newL.setSize("100%", "100%");
						newL.getElement().setDraggable(Element.DRAGGABLE_TRUE);
						
						
						//String data = event.getData("css");
						String name = event.getData("name");
						String id = event.getData("id");
						//newL.getElement().setPropertyObject("teachingObject", new Teaching(Integer.valueOf(id), TeachingType.COURS, name, 10, 5, 1, null));
						
						newL.getElement().setPropertyObject("teachingObject", new Teaching(TeachingType.COURS, name, 10, 5, 1, null, id));
						
						addEventLabel(newL, vPanel);
						vPanel.add(newL);
					}
				}, DropEvent.getType());
				
				
				flexTable.setWidget(i, j, vPanel);
				
			} //column
		} //row
	} //end onModuleLoad

	public void addEventLabel(final Label l, final VerticalPanel parent) {
		
		//au moment du survol
		l.addMouseOverHandler(new MouseOverHandler() {
			//plop
			@Override
			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				//DOM.setStyleAttribute(l.getElement(), "backgroundColor", "red");
				l.setStyleDependentName("overPanel", true);
			}
		});
		
		l.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				// TODO Auto-generated method stub
				//DOM.setStyleAttribute(l.getElement(), "backgroundColor", "white");
				//l.setStyleName(l.getStyleName());
				l.removeStyleDependentName("overPanel");
			}
		});
	
		//au moment ou on le saisit
		l.addDragStartHandler(new DragStartHandler() {
			public void onDragStart(DragStartEvent event) {
				event.setData("css", l.getStyleName());
				event.setData("name", ((Teaching) ((Label) event.getSource()).getElement().getPropertyObject("teachingObject")).getTeacher());
				event.setData("id", String.valueOf(((Teaching) l.getElement().getPropertyObject("teachingObject")).getModule()));
				event.getDataTransfer().setDragImage(((Label) event.getSource()).getElement(), 10, 10);
			}
		});
		
		//on a deplace l'objet
		l.addDragEndHandler(new DragEndHandler() {
			public void onDragEnd(DragEndEvent event) {
					
				if(parent.remove(l)) {
					if(parent.getWidgetCount() == 0) {
						createBackPanel(parent);
					}
				}	
			}
		});
	} //end addEventLabel

	public void createBackPanel(final VerticalPanel parent) {
		Label backLabel = new Label();
		
		backLabel.getElement().setPropertyBoolean("isBackPanel", true);
		
		backLabel.setSize("100%", "100%");
		backLabel.setStyleName("back");
		parent.add(backLabel);
	}	

	public Label createTreeItem(Teaching teaching) {
		
		final Label item = new Label(teaching.getModule());
		
		item.getElement().setPropertyObject("teachingObject", teaching);
		item.getElement().setDraggable(Element.DRAGGABLE_TRUE);
		
		item.addDragStartHandler(new DragStartHandler() {
			public void onDragStart(DragStartEvent event) {
				event.setData("css", "module3");
				event.setData("name", ((Teaching) item.getElement().getPropertyObject("teachingObject")).getTeacher());
				event.setData("id", String.valueOf(((Teaching) item.getElement().getPropertyObject("teachingObject")).getModule()));
				event.getDataTransfer().setDragImage(item.getElement(), 10, 10);
			}
		});
		
		return item;
	}
	
}
