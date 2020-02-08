package com.sdze.sql.metier;

import java.util.List;

import com.sdze.sql.entite.Compose;

public interface ComposeMetier {
	public Compose SaveCompose(Compose cmp);
	public void deleteCompose(Long id);
	public Compose getCompose(Long id);
	public List<Compose> getComposes();

}
