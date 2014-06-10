package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class Pessoa extends Model {


	@Id
	public Long id;

	@Constraints.Required
	public String nome;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date data_nascimento;

	public static Finder<Long,Pessoa> find = new Finder<Long,Pessoa>(Long.class, Pessoa.class);

	public static List<Pessoa> all()
	{
		return find.all();
	}

}
