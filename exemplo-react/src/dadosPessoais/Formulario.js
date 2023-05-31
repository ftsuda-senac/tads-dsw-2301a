import React, { useEffect, useState} from 'react';
import { buscarDadosJson, enviarDados } from './xhr';

function Input(props) {

  let inputClass = 'form-control'
  if (props.msgErro) {
    inputClass += ' is-invalid'
  }
  return (
    <div className="mb-3">
      <label
        htmlFor={props.id}
        className="form-label">{props.label}</label>
      <input
        type={props.type}
        className={inputClass}
        name={props.name}
        id={props.id}
        placeholder={props.placeholder}
        maxLength={props.maxLength}
        required={props.minLength}
        onChange={props.onChange}
        />
        {
          props.msgErro &&
          <p className="invalid-feedback">{props.msgErro}</p>
        }
    </div>
  )
}

export default function Formulario() {

  const [conhecimentos, setConhecimentos] = useState([]);
  const [dadosPessoais, setDadosPessoais] = useState({});
  const [errosObj, setErrosObj] = useState({});

  useEffect(() => {
    const buscar = async function () {
      try {
        const dados = await buscarDadosJson('http://localhost:8080/conhecimentos');
        setConhecimentos(dados);
      } catch(err) {
        // TODO Tratar erro
      }
    }
    buscar();
  }, [])

  const handleOnChange = function(evt) {
    const propriedade = evt.target.name;
    const valor = evt.target.value;

    const dadosAtualizados = {...dadosPessoais, [propriedade]: valor};
    console.log(JSON.stringify(dadosAtualizados, null, 2));

    setDadosPessoais(dadosAtualizados);
  }

  const handleCheckboxChange = function(evt) {
    const propriedade = evt.target.name;
    const valor = evt.target.value;
    const checked = evt.target.checked;

    let conhecimentos = dadosPessoais.conhecimentos;
    if (!conhecimentos) {
      conhecimentos = [];
    }

    if (checked) {
      conhecimentos.push(valor);
    } else {
      const idx = conhecimentos.indexOf(valor);
      conhecimentos.splice(idx, 1);
    }
    const dadosAtualizados = {...dadosPessoais, [propriedade]: conhecimentos};
    console.log(JSON.stringify(dadosAtualizados, null, 2));

    setDadosPessoais(dadosAtualizados);
  }

  async function handleSubmit(evt) {
    evt.preventDefault();
    try {
      const resultado = await enviarDados('http://localhost:8080/dados-pessoais', dadosPessoais)
    } catch(err) {
      setErrosObj(err.erros);
    }
  }

  return (
    <div className="container-md">
      <div className="row">
        <h1>Exemplo POST via form + validação com React</h1>
        <form id="frmDadosPessoais" noValidate onSubmit={handleSubmit}>
          <Input id="txtNome" type="text" label="Nome" name="nome" placeholder="Nome completo" maxLength={100} required 
            onChange={handleOnChange} msgErro={errosObj.nome} />
          <Input id="txtApelido" type="text" label="Apelido" name="apelido" placeholder="Apelido" maxLength={64} required
            onChange={handleOnChange} msgErro={errosObj.apelido} />
          <Input id="txtEmail" type="email" label="E-mail" name="email" placeholder="E-mail válido" maxLength={200} required
            onChange={handleOnChange} msgErro={errosObj.email} />
          <div className="mb-3">
            <label htmlFor="txtTelefone" className="form-label">Telefone</label>
            <input type="text" className="form-control" name="telefone"
              id="txtTelefone" placeholder="Telefone" maxLength="16"
              onChange={handleOnChange}/>
          </div>
          <div className="mb-3">
            <label htmlFor="txtSenha" className="form-label">Senha</label>
            <input type="password" className="form-control" name="senha"
              id="txtSenha" placeholder="Senha" minLength="8"
              onChange={handleOnChange}/>
          </div>
          <div className="mb-3">
            <label htmlFor="txtDataNascimento" className="form-label">Data nascimento</label>
            <input type="date" className="form-control" name="dataNascimento"
              id="txtDataNascimento" max="2023-04-25"
              onChange={handleOnChange}/>
          </div>
          <fieldset id="fieldConhecimentos">
            <legend>Conhecimentos</legend>
            {
              conhecimentos.length > 0 &&
              conhecimentos.map((con, idx) => {
                return (
                  <div className="form-check form-check-inline">
                    <input className="form-check-input" type="checkbox" name="conhecimentos" id={`chkConhecimento${idx}`} value={con.id} onChange={handleCheckboxChange} />
                    <label className="form-check-label" htmlFor={`chkConhecimento${idx}`}>{con.nome}</label>
                  </div>
                )
              })
            }
          </fieldset>
          <button className="btn btn-success btn-lg" type="submit">Enviar</button>
        </form>
      </div>
    </div>
  )
}