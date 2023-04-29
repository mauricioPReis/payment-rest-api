package fadesp.paymentrestapi.service;

import fadesp.paymentrestapi.model.Payment;

public interface PaymentService {
    /**
     * Metodo para criacao de pagamento no banco de dodos
     *
     * @param payment pagamento para ser adicionado
     */
    void createPayment(Payment payment);

    /**
     * Metodo para editar os pagamentos no banco
     *
     * @param payment pagamento a ser editado
     * @param debitCode id do pagamento a ser editado
     */
    void editPayment(Payment payment, int debitCode);

    /**
     * Metodo para retornar um pagamento pelo seu Id
     *
     * @param debitCode id da pagamento do pesquisado
     * @return retorna um <code>Pagamento</code>
     */
    Payment fetchPaymentById(int debitCode);

    /**
     * Metodo para retornar um pagamento pelo CPF ou CNPJ
     *
     * @param payerType id da pagamento do pesquisado
     * @return retorna um <code>Pagamento</code>
     */
    Payment fetchPaymentByPayerType(String payerType);

    /**
     * Metodo para retornar um pagamento de acordo com o Status
     *
     * @param paymentStatus id da pagamento do pesquisado
     * @return retorna um <code>Pagamento</code>
     */
    Payment fetchPaymentByStatus(String paymentStatus);

    /**
     * Lista todas as pessoas no banco
     *
     * @return retorna um <code>Iterable<Pessoa></code>
     */
    Iterable<Payment> searchAllPayments();
}
