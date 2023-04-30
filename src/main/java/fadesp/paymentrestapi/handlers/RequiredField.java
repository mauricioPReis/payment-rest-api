package fadesp.paymentrestapi.handlers;

public class RequiredField extends BusinessException{
    /**
     * Retorna uma excecao caso um dos campos obrigatorio nao seja preenchido
     *
     * @param campo nome do campo ausente
     */
    public RequiredField(String campo) {
        super("O campo "+campo+" é obrigatorio!!");

    }
}
