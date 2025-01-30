import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "SaaSquatchPrinter",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Prints the company name in different styles.")
public class SaaSquatchPrinter implements Callable<Integer> {

    @Option(names = {"-s", "--style"}, description = "Choose style: [default, uppercase, lowercase, fancy]")
    private String style = "default";

    private static final String COMPANY_NAME = "SaaSquatch";

    @Override
    public Integer call() {
        String output;
        switch (style.toLowerCase()) {
            case "uppercase":
                output = COMPANY_NAME.toUpperCase();
                break;
            case "lowercase":
                output = COMPANY_NAME.toLowerCase();
                break;
            case "fancy":
                output = "✨ " + COMPANY_NAME + " ✨";
                break;
            default:
                output = COMPANY_NAME;
        }
        System.out.println(output);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new SaaSquatchPrinter()).execute(args);
        System.exit(exitCode);
    }
}
