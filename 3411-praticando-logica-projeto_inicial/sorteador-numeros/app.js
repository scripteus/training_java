function gerarNumerosAleatorios(min, max) {
    // Gera um número aleatório entre min e max (ambos incluídos)
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function sortear() {
    // Pega os valores dos inputs
    let quantidade = parseInt(document.getElementById('quantidade').value);
    let de = parseInt(document.getElementById('de').value);
    let ate = parseInt(document.getElementById('ate').value);

    // Validações antes de iniciar o sorteio
    if (isNaN(quantidade) || isNaN(de) || isNaN(ate)) {
        alert('Por favor, preencha todos os campos corretamente.');
        return;
    }

    if (de > ate) {
        alert('O valor "Do número" deve ser menor ou igual ao "Até o número".');
        return;
    }

    if (quantidade > (ate - de + 1)) {
        alert('A quantidade de números a serem sorteados não pode ser maior que o intervalo disponível.');
        return;
    }

    let numerosSorteados = new Set(); // Usando Set para evitar números duplicados

    while (numerosSorteados.size < quantidade) {
        numerosSorteados.add(gerarNumerosAleatorios(de, ate));
    }

    // Exibe o resultado
    let resultado = document.getElementById('resultado');
    resultado.innerHTML = `<label class="texto__paragrafo">Números sorteados: ${[...numerosSorteados].join(', ')}</label>`;
    
    alterarStatusDoBotao();
}

function alterarStatusDoBotao() {
    let botao = document.getElementById('btn-reiniciar');
    botao.classList.toggle('container__botao-desabilitado');
    botao.classList.toggle('container__botao');
}

function reiniciar() {
    document.getElementById('quantidade').value = '';
    document.getElementById('de').value = '';
    document.getElementById('ate').value = '';
    document.getElementById('resultado').innerHTML = '';
    alterarStatusDoBotao();
}
