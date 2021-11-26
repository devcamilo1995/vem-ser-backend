import static com.mongodb.client.model.Filters.eq;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        // credencial (login)
        MongoCredential credential = MongoCredential.createCredential("root", "admin", "root".toCharArray());
        MongoClient cliente = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase db = cliente.getDatabase("vemserdbc");
        MongoCollection<Document> alunos = db.getCollection("alunos_java");



//        db.createCollection("alunos_java");

        // insert
        Document result = new Document("nome", "Matheus")
                .append("data_nascimento", LocalDate.of(1995, 06, 20))
                .append("curso", new Document("nome", "GTI"))
                .append("notas", Arrays.asList(9, 8, 6))
                .append("habilidades", Arrays.asList(
                        new Document()
                                .append("nome", "ingles")
                                .append("nível", "basico"),
                        new Document()
                                .append("nome", "excel")
                                .append("nível", "intermediário")));

        alunos.insertOne(result);

        // update
        Document query = new Document().append("nome", "Matheus");
        Bson updates = Updates.combine(
                Updates.set("nome", "Matheus Camilo"),
                Updates.set("cnh", "B"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result2 = alunos.updateOne(query, updates, options);

        System.out.println("Modified document count: " + result2.getModifiedCount());
        System.out.println("Upserted id: " + result2.getUpsertedId());

        // find
        Bson projectionFields = Projections.fields(
                Projections.include("nome", "cnh"),
                Projections.excludeId());

        Document doc = alunos.find(eq("nome", "Matheus Camilo"))
                .projection(projectionFields)
                .first();

        System.out.println(doc);

        // delete
//        Bson query2 = eq("nome", "Matheus Camilo");
//        DeleteResult result3 = alunos.deleteOne(query2);
//        System.out.println("Deleted document count: " + result3.getDeletedCount());
    }
}