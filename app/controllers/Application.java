package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;

import models.*;

public class Application extends Controller {

    static Form<Pessoa> form_pessoa = Form.form(Pessoa.class);

    /**
    * Result index, que redireciona para list
    */
    public static Result index()
    {
        return redirect(routes.Application.list());
    }

    /**
    * Lista pessoas cadastradas
    */
    public static Result list()
    {
		return ok(
			list.render(Pessoa.all())
		);
	}

    /**
    * Apaga pessoa
    * @param id Id da pessoa excluida
    */
    public static Result delete(Long id)
    {
        Pessoa.find.ref(id).delete();
        return redirect(routes.Application.list());
    }

    public static Result update(Long id)
    {
        return null;
    }

    public static Result create()
    {
        return null;
    }

}
