import java.util.List;

public class Main {

    /**
     * Método auxiliar para recriar e executar comandos a partir da string de log carregada.
     */
    private static void recoverAndExecute(String log, Light light, CeilingFan fan) {
        Command command = null;
        System.out.print("RECOVERING ACTION: " + log + " -> ");
        
        // Lógica de recuperação/fábrica (cria o objeto Command a partir da string)
        if (log.equals("LIGHT_ON")) {
            command = new LightOnCommand(light);
        } else if (log.equals("FAN_MEDIUM")) {
            command = new CeilingFanMediumCommand(fan);
        }
        // Adicione mais casos para outros comandos aqui...

        if (command != null) {
            command.execute(); // Re-executa o comando na ordem
        } else {
            System.out.println("Comando desconhecido: " + log);
        }
    }

    public static void main(String[] args) {
        // 1. SETUP (Dispositivos e Histórico)
        Light salaLight = new Light("Sala");
        CeilingFan salaFan = new CeilingFan();
        CommandHistoryManager historyManager = new CommandHistoryManager();
        
        // 2. AÇÕES ANTES DA PANE (Execute + Log)
        System.out.println("--- SIMULAÇÃO DE USO NORMAL ---");
        
        Command cmd1 = new LightOnCommand(salaLight);
        cmd1.execute();
        historyManager.addCommandLog(cmd1.getLogData());

        Command cmd2 = new CeilingFanMediumCommand(salaFan);
        cmd2.execute();
        historyManager.addCommandLog(cmd2.getLogData());
        
        // 3. BACKUP/STORE: Salva o histórico de ações no disco
        historyManager.store(); 
        
        // 4. SIMULAÇÃO DA PANE ELÉTRICA (Dispositivos são desligados/resetados)
        System.out.println("\n--- PANE ELÉTRICA: SIMULAÇÃO DE PERDA DE ESTADO ---");
        salaLight.off(); // Estado inicial (OFF)
        salaFan.off();   // Estado inicial (OFF)
        
        // 5. RESTAURAÇÃO/RECOVERY (Load + Re-execute)
        System.out.println("\n--- INICIANDO PROCESSO DE RESTAURAÇÃO (load()) ---");
        List<String> logs = historyManager.load(); // Carrega o histórico de ações do arquivo
        
        System.out.println("\n--- RE-EXECUTANDO AÇÕES PARA RESTAURAR ESTADO ---");
        for (String log : logs) {
            recoverAndExecute(log, salaLight, salaFan);
        }

        // 6. VERIFICAÇÃO DO ESTADO FINAL
        System.out.println("\n--- ESTADO FINAL DOS DISPOSITIVOS APÓS RESTAURAÇÃO ---");
    }
}