package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.PersonMenu;
import View.Lib_Menu;

public class SubsListController extends MouseAdapter implements ActionListener,KeyListener{
	PersonMenu model;
	Lib_Menu view;

	public SubsListController(Lib_Menu view) {
		this.model = new PersonMenu();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent caller) {
		switch(caller.getActionCommand())
				{
				//case("Save"):
					//model.Save_panel4(view);
					//break;			
				case("Update"):
					model.Update_panel4(view);
					break;			
				case("Delete"):
					model.Delete_panel4(view);
				}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		model.mouseklicked_panel4(view);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		model.keyreleased_panel4(view);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}