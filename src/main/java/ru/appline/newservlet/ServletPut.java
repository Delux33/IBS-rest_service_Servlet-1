package ru.appline.newservlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.newservlet.logic.Model;
import ru.appline.newservlet.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        JsonObject jsonObject = gson.fromJson(String.valueOf(jb), JsonObject.class);
        int id = jsonObject.get("id").getAsInt();

        response.setContentType("application/json;charset=utf-8");

        PrintWriter pw = response.getWriter();
        boolean isValidId = model.getFromList().containsKey(id);

        if (isValidId) {
            User user = model.getFromList().get(id);

            user.setName(jsonObject.get("name").getAsString());
            user.setSurname(jsonObject.get("surname").getAsString());
            user.setSalary(jsonObject.get("salary").getAsDouble());

            model.add(id, user);

            pw.print(gson.toJson(model.getFromList()));
        } else {
            pw.print(gson.fromJson("{\n\"Такого пользователя для изменений\" : \"нет\"\n}", JsonObject.class));

            pw.print(gson.toJson(model.getFromList()));
        }
    }
}
