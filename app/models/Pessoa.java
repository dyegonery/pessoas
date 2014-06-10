package models;

import java.util.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Pessoa extends Model {


	@Id
	public Long id;

	@Required
	public String nome;

	@Formats.DateTime(pattern='dd/MM/yyyy')
	public Date data_nascimento;

	public static Finder<Long,Pessoa> find = new Finder(
		Long.class, Pessoa.class
	);

	public static Page<Pessoa> page(String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .getPage(page);
    }

}
