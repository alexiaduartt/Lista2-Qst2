import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandHistoryManager {
    private List<String> commandLog = new ArrayList<>();
    private static final String FILE_NAME = "command_history.txt";

    /**
     * Adiciona a string de log (ação) à lista de histórico.
     */
    public void addCommandLog(String logData) {
        commandLog.add(logData);
        System.out.println("LOG: " + logData + " stored in history.");
    }

    /**
     * Simula o método store(): Salva a lista de logs no disco.
     */
    public void store() {
        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            for (String log : commandLog) {
                writer.println(log);
            }
            System.out.println("\n--- BACKUP COMPLETO (store()) ---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simula o método load(): Carrega a lista de logs do disco.
     * @return Lista de strings de logs carregados.
     */
    public List<String> load() {
        List<String> loadedLog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedLog.add(line);
            }
            System.out.println("--- HISTÓRICO CARREGADO (load()) ---\n");
        } catch (FileNotFoundException e) {
             System.out.println("Arquivo de histórico não encontrado. Iniciando do zero.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedLog;
    }
}