const formNotas = document.getElementById("formNotas");
const resultado = document.querySelector(".result");
const resultadoTitulo = document.getElementById("resultadoTitulo");
const resultadoTexto = document.getElementById("resultadoTexto");
const mediaFinal = document.getElementById("mediaFinal");
const pesoAviso = document.getElementById("pesoAviso");

function pegarNumero(id) {
    return Number(document.getElementById(id).value);
}

function definirSituacao(media, notaMinima) {
    if (media >= notaMinima) {
        return "Aprovado";
    }

    if (media >= notaMinima - 1) {
        return "Recuperacao";
    }

    return "Reprovado";
}

function classeSituacao(situacao) {
    return situacao.toLowerCase();
}

formNotas.addEventListener("submit", function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const notaMinima = pegarNumero("notaMinima");
    const notas = [
        pegarNumero("ac1"),
        pegarNumero("ac2"),
        pegarNumero("af"),
        pegarNumero("ag")
    ];
    const pesos = [
        pegarNumero("pesoAc1"),
        pegarNumero("pesoAc2"),
        pegarNumero("pesoAf"),
        pegarNumero("pesoAg")
    ];

    const somaPesos = pesos.reduce((total, peso) => total + peso, 0);
    if (somaPesos !== 100) {
        pesoAviso.textContent = "A soma dos pesos precisa ser exatamente 100%.";
        pesoAviso.classList.add("error");
        return;
    }

    pesoAviso.textContent = "A soma dos pesos deve ser 100%.";
    pesoAviso.classList.remove("error");

    const media = notas.reduce((total, nota, index) => total + nota * pesos[index], 0) / 100;
    const situacao = definirSituacao(media, notaMinima);
    const nomeAluno = nome || "Aluno";

    resultado.className = "result " + classeSituacao(situacao);
    resultadoTitulo.textContent = situacao;
    resultadoTexto.textContent = `${nomeAluno} ficou com media ${media.toFixed(2)}.`;
    mediaFinal.textContent = media.toFixed(2);
});

formNotas.addEventListener("reset", function () {
    resultado.className = "result";
    resultadoTitulo.textContent = "Preencha as notas";
    resultadoTexto.textContent = "A media e a situacao do aluno aparecem aqui.";
    mediaFinal.textContent = "--";
    pesoAviso.textContent = "A soma dos pesos deve ser 100%.";
    pesoAviso.classList.remove("error");
});
