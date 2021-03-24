$(function() {

    //nao permitir caracteres alfanumericos e adicionar casas decimais
    var decimal = $('.js-decimal')
    decimal.maskMoney();

    //nao permitir caracteres alfanumericos e remover casas decimais
    var plain = $('.js-plain');
    plain.maskMoney({ precision: 0 })

});