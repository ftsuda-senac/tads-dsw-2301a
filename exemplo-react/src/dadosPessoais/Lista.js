import React, { useEffect, useState } from 'react';
import { buscarDadosJson } from './xhr';

export default function Lista() {

  const [dadosArr, setDadosArr] = useState([])

  useEffect(() => {
    console.log('Acessou carregarAoEntrar')
      buscarDadosJson('http://localhost:8080/dados-pessoais').then((dadosArr) => {
        setDadosArr(dadosArr);
    }).catch((err) => {

    })
  }, [])
  
  return (
    <div className="container-md">
      <div className="row">
        <h1>Exemplo Listagem com React</h1>
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Apelido</th>
              <th>Nome</th>
              <th>Contato</th>
              <th>Data nascimento</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody id="tlista">
            {
              dadosArr.length > 0 &&
              dadosArr.map((dado, idx) => {
                return (
                  <tr key={idx}>
                    <td>{dado.apelido}</td>
                    <td>{dado.nome}</td>
                    <td>
                      <p>E-mail: {dado.email}</p>
                      <p>Telefone: {dado.telefone}</p>
                    </td>
                    <td>{dado.dataNascimento}</td>
                    <td>
                      <a href="#" className="btn btn-info">Editar</a>
                      <button className="btn btn-danger">Excluir</button>
                    </td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>

      </div>
    </div>
  )
}