package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import play.libs.Json;

import views.html.*;

import models.*;

import java.util.List;
import java.util.Iterator;

public class Application extends Controller {

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
        Pessoa.delete(id);
        return redirect(routes.Application.list());
    }

    /**
    * Visualiza pagina de alteração de pessoa
    * @param id Código da pessoa
    */
    public static Result edit(Long id)
    {
        Form<Pessoa> pessoaForm = form(Pessoa.class).fill(
            Pessoa.find.ref(id)
        );
        return ok(
            editForm.render(id, pessoaForm)
        );
    }

    /**
    * Recebe dados de formulario de alteração de pessoa
    * @param id Código da pessoa
    */
    public static Result update(Long id)
    {
        Form<Pessoa> pessoaForm = form(Pessoa.class).bindFromRequest();
        if (pessoaForm.hasErrors()) {
            return badRequest(editForm.render(id, pessoaForm));
        }
        pessoaForm.get().update(id);
        return redirect(routes.Application.list());
    }

    /**
    * Visualiza pagina de criacao de novas pessoas
    */
    public static Result create()
    {
        Form<Pessoa> pessoaForm = form(Pessoa.class);
        return ok(
            createForm.render(pessoaForm)
        );
    }

    /**
    * Recebe dados de formulario de criação de nova pessoa
    */
    public static Result save()
    {
        Form<Pessoa> pessoaForm = form(Pessoa.class).bindFromRequest();
        if (pessoaForm.hasErrors())
            return badRequest(createForm.render(pessoaForm));

        pessoaForm.get().save();

        return redirect(routes.Application.list());
    }


    /**
    * Método que para consulta de pessoas via JSON
    */
    public static Result restPage()
    {
        List<Pessoa> pessoas = Pessoa.all();
        if (pessoas != null)
            return ok(Json.toJson(pessoas));
        else
            return badRequest("Nenhuma pessoa cadastrada!");
    }
}
