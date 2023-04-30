package fadesp.paymentrestapi.handlers;

public class IdNotFound extends BusinessException {
    /**
     * retorna uma excecao caso nao seja localizado o id
     *
     * @param id    id do <code>campo</code> nao foi localizado no banco
     * @param campo campo em que o <code> id </code> está nao foi localizado
     */
    public IdNotFound(Long id, String campo){
        super("O id "+ id +" do campo "+ campo +" não foi encontrado");
    }
}
