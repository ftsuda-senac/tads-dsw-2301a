export function buscarDadosJson(urlJson, params) {
    // Versão com função anônima
    return new Promise(function (resolve, reject) {
      const xhr = new XMLHttpRequest();
      let urlAjustada = urlJson;
      if (params) {
        urlAjustada = urlAjustada + '?' + params
      }
      xhr.open('GET', urlAjustada, true);

      xhr.setRequestHeader('Content-type', 'application/json');

      xhr.onload = function () {
        if (xhr.status === 200) {
          const dadosArr = JSON.parse(xhr.responseText);
          resolve(dadosArr);
        } else {
          reject({
            status: xhr.status,
            mensagem: 'Erro na requisição'
          });
        }
      };
      xhr.send();
    });
  }

  export function enviarDados(urlJson, dados) {
    return new Promise(function(resolve, reject) {
      let xhr = new XMLHttpRequest();
      xhr.open('POST', urlJson, true);
      xhr.setRequestHeader('Content-Type', 'application/json');

      xhr.onload = function() {
        if (xhr.status === 200 || xhr.status === 201) {
          resolve(JSON.parse(xhr.responseText));
        } else {
            let erroObj = {}
            const erros = JSON.parse(xhr.responseText)?.errors;
            for (const erro of erros) {
                erroObj = {...erroObj, [erro.field]: erro.defaultMessage}
            }
            console.log(JSON.stringify(erroObj));
          reject({
            codigo:  xhr.status,
            mensagem: 'Erro ao enviar dados',
            erros: erroObj
          });
        }
      };
      xhr.send(JSON.stringify(dados));
    });
  }
