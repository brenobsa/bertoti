const API_URL = '/api/treinos';

document.addEventListener('DOMContentLoaded', carregarTreinos);

async function carregarTreinos() {
    try {
        const res = await fetch(API_URL);
        if (!res.ok) throw new Error('Erro ao buscar treinos');
        const treinos = await res.json();
        renderizarCards(treinos);
    } catch (e) {
        console.error('Falha de comunicação com a API:', e);
        document.getElementById('board-treinos').innerHTML = `
            <div class="loading" style="color: #ef4444;">
                Não foi possível conectar ao banco de dados.<br>
                Verifique se o Spring Boot e o MySQL estão rodando.
            </div>
        `;
    }
}

function renderizarCards(treinos) {
    const board = document.getElementById('board-treinos');
    board.innerHTML = '';

    treinos.sort((a, b) => a.identificador.localeCompare(b.identificador));

    treinos.forEach(treino => {
        const card = document.createElement('div');
        card.className = 'card-treino';

        const exerciciosRows = treino.exercicios.map(e => `
            <div class="grid-linha item-linha" id="linha-exercicio-${e.id}">
                <div class="bloco-dado nome" id="view-nome-${e.id}">${e.nome}</div>
                <div class="bloco-dado" id="view-series-${e.id}">${e.series}</div>
                <div class="bloco-dado" id="view-rep-${e.id}">${e.repeticoes}</div>
                <div class="bloco-acoes" id="view-acoes-${e.id}">
                    <button class="btn-icon" onclick="ativarEdicao(${e.id}, '${e.nome}', ${e.series}, ${e.repeticoes})" title="Editar">✏️</button>
                </div>
            </div>
        `).join('');

        card.innerHTML = `
            <div class="banner-treino">Treino ${treino.identificador}</div>

            <div class="grid-linha">
                <span class="cabecalho-coluna exercicio">Exercício</span>
                <span class="cabecalho-coluna">Série</span>
                <span class="cabecalho-coluna">Reps</span>
                <span class="cabecalho-coluna" style="text-align: center;">Ações</span>
            </div>

            <div class="lista-itens" id="lista-${treino.identificador}">
                ${exerciciosRows.length ? exerciciosRows : '<div style="color:#94a3b8; text-align:center; padding:12px; font-size:0.85rem;">Sem exercícios ainda</div>'}
            </div>

            <form class="form-inputs" onsubmit="adicionarExercicio(event, '${treino.identificador}')">
                <div class="grid-linha">
                    <input type="text" class="input-app text" placeholder="Exercício" required id="nome-${treino.identificador}">
                    <input type="number" class="input-app" placeholder="Série" min="1" required id="series-${treino.identificador}">
                    <input type="number" class="input-app" placeholder="Rep" min="1" required id="rep-${treino.identificador}">
                    <div></div>
                </div>
                <button type="submit" class="btn-acao">
                    <span>+ Adicionar Mais</span>
                </button>
            </form>
        `;

        board.appendChild(card);
    });
}

function ativarEdicao(id, nomeAtual, seriesAtuais, repAtuais) {
    const linha = document.getElementById(`linha-exercicio-${id}`);
    linha.innerHTML = `
        <input type="text" class="input-app text edit-input" id="edit-nome-${id}" value="${nomeAtual}">
        <input type="number" class="input-app edit-input" min="1" id="edit-series-${id}" value="${seriesAtuais}">
        <input type="number" class="input-app edit-input" min="1" id="edit-rep-${id}" value="${repAtuais}">
        <div class="bloco-acoes">
            <button class="btn-icon save" onclick="salvarEdicao(${id})" title="Salvar">💾</button>
            <button class="btn-icon cancel" onclick="carregarTreinos()" title="Cancelar">❌</button>
        </div>
    `;
}

async function salvarEdicao(id) {
    const nome = document.getElementById(`edit-nome-${id}`).value.trim();
    const series = parseInt(document.getElementById(`edit-series-${id}`).value, 10);
    const repeticoes = parseInt(document.getElementById(`edit-rep-${id}`).value, 10);

    if (!nome || isNaN(series) || isNaN(repeticoes)) {
        alert('Preencha todos os campos corretamente.');
        return;
    }

    try {
        const res = await fetch(`${API_URL}/exercicios/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome, series, repeticoes })
        });

        if (res.ok) {
            carregarTreinos();
        } else {
            alert('Erro ao atualizar o exercício.');
        }
    } catch (e) {
        console.error('Erro de requisição:', e);
    }
}

async function adicionarExercicio(event, treinoId) {
    event.preventDefault();

    const inputNome = document.getElementById(`nome-${treinoId}`);
    const inputSeries = document.getElementById(`series-${treinoId}`);
    const inputRep = document.getElementById(`rep-${treinoId}`);

    const novoExercicio = {
        nome: inputNome.value.trim(),
        series: parseInt(inputSeries.value, 10),
        repeticoes: parseInt(inputRep.value, 10)
    };

    try {
        const res = await fetch(`${API_URL}/${treinoId}/exercicios`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novoExercicio)
        });

        if (res.ok) {
            inputNome.value = '';
            inputSeries.value = '';
            inputRep.value = '';
            carregarTreinos();
        } else {
            alert('Erro ao salvar no banco de dados.');
        }
    } catch (err) {
        console.error('Falha de rede:', err);
    }
}