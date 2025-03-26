function gerarNumerosAleatorios(min, max) {
    // Gera um número aleatório entre min e max
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}

function sortear() {
    
    // Pega os valores dos inputs
    let quantidade = parseInt(document.getElementById('quantidade').value);
    let de = parseInt(document.getElementById('de').value);
    let ate = parseInt(document.getElementById('ate').value);

    let numerosSorteados = [];

    // Sorteia os números
    for (let i = 0; i < quantidade; i++) {
        let numeroSorteado = gerarNumerosAleatorios(de, ate);

        // Verifica se o número já foi sorteado
        while (numerosSorteados.includes(numeroSorteado)) {
            numeroSorteado = gerarNumerosAleatorios(de, ate);
        }
            numerosSorteados.push(numeroSorteado);
        }

    if (ate >= de) {
    // Se o número "de" for maior que "ate" retorne um erro
    alert('Campo "Do número" deve ser inferior ao campo "Até o número".');
        return;
    }

    // Mostra o resultado na label "resultado"
    let resultado = document.getElementById('resultado');
    resultado.innerHTML = `<label class="texto__paragrafo">Números sorteados:  ${numerosSorteados}</label>`;
    alterarStatusDoBotao();
}

function alterarStatusDoBotao () {
    let botao = document.getElementById('btn-reiniciar');
    if (botao.classList.contains('container__botao-desabilitado')) {
        botao.classList.remove('container__botao-desabilitado');
        botao.classList.add('container__botao');
    } else {
        botao.classList.remove('container__botao');
        botao.classList.add('container__botao-desabilitado');
    }
}

function reiniciar() {
    document.getElementById('quantidade').value = '';
    document.getElementById('de').value = '';
    document.getElementById('ate').value = '';
    document.getElementById('resultado').innerHTML = '';
    alterarStatusDoBotao();
}