public interface Command {
    /**
     * Executa a ação do comando no dispositivo Receiver.
     */
    void execute();

    /**
     * Desfaz a ação.
     */
    void undo();

    /**
     * Retorna a representação em string do comando para ser logada/persistida
     * para o processo de backup e restauração.
     * @return String de log.
     */
    String getLogData();
}