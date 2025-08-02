package payment_system.utils;

public class MessageUtil {

    public static String erroCategoriaNaoEncontrada(String nome) {
        return "Categoria não encontrada com o nome: " + nome;
    }

    public static String erroServicoNaoEncontrado(String nome) {
        return "Serviço de pagamento não encontrado com o nome: " + nome;
    }

    public static String erroUsuarioNaoEncontrado(String email) {
        return "Usuário não encontrado com o email: " + email;
    }
}