



/*
public void cadastrarClienteComAnimal(Cliente cliente, Animal animal) throws SQLException {
    Connection conexaoPrincipal = null;
    try {
        conexaoPrincipal = DataBaseUtil.getConnection();
        conexaoPrincipal.setAutoCommit(false); // Inicia a transação

        // Chama o método do repositório que USA a conexão fornecida
        clienteRepository.inserirCliente(cliente, conexaoPrincipal);
        
        // Supondo que animalRepository também tenha um método sobrecarregado
        // animal.setDono(cliente); // Associa o dono ao animal
        // animalRepository.inserirAnimal(animal, conexaoPrincipal);

        conexaoPrincipal.commit(); // TUDO OK! Camada de Serviço faz o commit.

    } catch (SQLException e) {
        if (conexaoPrincipal != null) {
            try {
                conexaoPrincipal.rollback(); // DEU ERRO! Camada de Serviço faz o rollback.
            } catch (SQLException exRollback) {
                exRollback.printStackTrace(); // Logar erro no rollback
            }
        }
        throw e; // Propaga a exceção original
    } finally {
        if (conexaoPrincipal != null) {
            try {
                conexaoPrincipal.setAutoCommit(true); // Restaura o padrão
                conexaoPrincipal.close(); // Camada de Serviço fecha a conexão.
            } catch (SQLException exClose) {
                exClose.printStackTrace(); // Logar erro ao fechar
            }
        }
    }
}
*/