package io;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public interface Score {

	public void input(ScoreDTO dto);

	public void print(DefaultTableModel model);

	public void save();

	public void load();

	public void search(DefaultTableModel model);

	public void tot_desc();
}
