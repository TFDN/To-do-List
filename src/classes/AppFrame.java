package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
	
	private TitleBar  title;
	private list  list; 
	private ButtonPanel btnPanel;
	
	private JButton addTask;
	private JButton clear;
	
	//Constrcuctor
	AppFrame()
	{
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		title = new TitleBar();
		list = new list();
		btnPanel = new ButtonPanel();
		this.add(title,BorderLayout.NORTH);
		this.add(btnPanel,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		addTask = btnPanel.getneAddTask();
		clear = btnPanel.getclear();
		
		addListeners();
	
	}
		
	public void addListeners()
	{
		
		addTask.addMouseListener(new MouseAdapter()
		{
			@Override 
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				task.getdone().addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						task.changeState();
						revalidate();
					}
				});
				revalidate();
						
			}
		});
			
		
	}


}
