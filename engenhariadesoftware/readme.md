
---

> Exercicios  -  13/02/2026

---

<br>

 1. Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly.
    
<br>

A programação resolve problemas imediatos, enquanto a Engenharia de Software foca na longevidade. A diferença fundamental é o fator tempo: a engenharia aplica rigor e responsabilidade para garantir que o código continue confiável e seguro ao longo de todo o seu ciclo de vida.

<br>

> ---

<br>

 2. Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.

<br>

O foco da boa engenharia é a sustentabilidade. Um software deve ser capaz de evoluir diante de mudanças, escalar conforme o crescimento e equilibrar custos e benefícios (trade-offs). Se o sistema não consegue se adaptar ao tempo e à escala, ele não foi bem "engenheirado".

<br>

> ---

<br>

 3. Listar e explicar 3 exemplos de tradeoffs

<br>

Engenharia é a arte de escolher entre vantagens e custos. Os principais exemplos são:

Velocidade vs. Dívida Técnica: Ganha-se rapidez no lançamento, mas o código fica mais difícil de manter.

Consistência vs. Disponibilidade: Escolha entre dados idênticos para todos ou um sistema que nunca sai do ar.

Abstração vs. Performance: Optar por facilidade de escrita (código legível) em troca de um maior consumo de hardware.

<br>

---

> Exercicios  -   20-02-2026

---

<br>

 1. Software é intangível

<br>

O que eu entendi é que, diferente de um engenheiro civil que constrói um prédio que você consegue ver e tocar, o nosso trabalho como engenheiro de software é criar algo digital. Mesmo que o software seja "invisível" ou intangível, ele é tão real quanto uma ponte. Se a gente comete um erro no código, o impacto no mundo real pode ser enorme, então precisamos ter o mesmo rigor e seriedade que qualquer outra engenharia.

<br>

> ---

<br>

 2. Engenharia de Software = Programação + tempo, escalabilidade e trade-offs

<br>

Para mim, a grande diferença é que programar é só resolver um problema agora, mas fazer engenharia é pensar no futuro. É o que o texto diz sobre "programação integrada ao tempo". Não basta o código funcionar hoje; ele tem que ser fácil de manter daqui a dois anos, aguentar o aumento de usuários (escalabilidade) e a gente precisa saber que cada escolha que fazemos hoje vai ter um preço ou uma consequência lá na frente (trade-offs).

<br>

> ---

<br>

 3. Requisitos não funcionais - (Listar 5 requisitos não funcionais e descrevê-los com suas palavras)
 
 <br>   

Desempenho: É o quão rápido o sistema responde. Ninguém gosta de sistema lento ou que demora para processar uma consulta no banco.

Disponibilidade: É o sistema estar no ar quando o usuário precisar. Se o servidor cai direto, a disponibilidade é baixa.

Segurança: É garantir que só quem tem permissão veja os dados e que o sistema esteja protegido contra invasões.

Manutenibilidade: É o quão fácil é mexer no código depois. Um código bem escrito facilita a vida de quem vai corrigir um bug ou criar uma função nova.

Confiabilidade: É poder confiar que o sistema vai fazer o que deve fazer sem dar erro toda hora.

<br>

> ---

<br>

 4. Trade-offs (negociação entre requisitos não funcionais) - (Citar e descrever 3 cenários de trade-offs)

<br>

Segurança vs. Usabilidade: Se eu colocar mil senhas e autenticações, o sistema fica super seguro, mas o usuário vai achar horrível de usar porque demora demais para logar.

Custo vs. Disponibilidade: Para o sistema nunca cair, eu precisaria pagar vários servidores de reserva, o que é muito caro. Às vezes o trade-off é aceitar que o sistema fique fora do ar por alguns minutos para economizar dinheiro.

Simplicidade vs. Recursos: Fazer um sistema com muitas funções deixa ele robusto, mas o código fica muito complexo e difícil de manter. Às vezes é melhor deixar o sistema mais simples para garantir que ele seja fácil de consertar.

<br>

---

> Exercicio  -  23-02-2026

---

<br>

5 - É possível testar tudo?

<br>

> Codigo
int blech(int j){
  j = j - 1; // deveria ser j = j + 1
  j = j / 30000;
  return j;
}

<br>

Na real, não. Por mais que a gente tente, conforme o sistema cresce, as combinações de dados e caminhos no código ficam infinitas. Na engenharia, a gente foca em testar o que é mais crítico, porque tentar testar cada detalhe impossível custaria muito tempo e dinheiro.

