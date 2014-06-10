package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index()
    {
        redirect(routes.Application.list(""));
    }

    public static Result list(String filtro)
    {
		return ok(
			list.render(
				Pessoa.page(filtro), filtro
			)
		);
	}

}
