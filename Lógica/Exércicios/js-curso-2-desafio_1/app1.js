let alterandoTexto = document.querySelector('h1');
alterandoTexto.innerHTML = "Hora do Desafio";

function clickBotaoConsolo() {
    texto = console.log("O consolo foi usado!");
}

function clickBotaoAlert() {
    aviso = alert("Eu amo JS!");
}

function clickBotaoPrompt() {
    cidade = prompt("Escreva uma cidade do Brasil: ");
    alert(`Estive em ${cidade} e lembrei de você.`);
}

function clickBotaoSoma() {
    segundoNumero = prompt("Escreva um número: ");
    primeiroNumero = prompt("Escreva um número: ");
    alert(`A soma entre ${primeiroNumero} e ${segundoNumero} é ${parseInt(primeiroNumero) + parseInt(segundoNumero)}`);
}