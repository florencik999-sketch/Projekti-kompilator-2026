import org.example.ExecutableStatement;
import org.example.ExecutionContext;
import org.example.SimpleParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main_Class {
    public static void main(String[] args) throws Exception {
        // Update path to your .gg file here
        String path = "grammar.gg";
        List<String> lines = Files.readAllLines(Paths.get(path));

        SimpleParser parser = new SimpleParser();
        List<ExecutableStatement> program = parser.parse(lines);

        ExecutionContext context = new ExecutionContext();

        for (ExecutableStatement stmt : program) {
            stmt.execute(context);
        }
    }
}