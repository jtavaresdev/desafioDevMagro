# Projeto DevMagro 🚀
link: https://docs.google.com/document/d/12ek1Wsd_ibuwTOjHtLPZwEWdy5-A7cRoO2Bf-v5G1_s/edit?tab=t.0

## Descrição do Projeto
Sistema de cadastro de usuários via CLI (Interface de Linha de Comando) desenvolvido em Java, com foco em práticas de Orientação a Objetos, manipulação de arquivos e tratamento de exceções.

## 🎯 Objetivos
- Criar um sistema de cadastro flexível e robusto
- Manipular arquivos de texto
- Implementar validações de dados
- Demonstrar conhecimentos em Java IO e Orientação a Objetos

## 🛠 Tecnologias Utilizadas
- Linguagem: Java 17
- Paradigma: Programação Orientada a Objetos
- Bibliotecas: java.io, java.util

## 📋 Funcionalidades

### Cadastro de Usuário
- Leitura de perguntas a partir de um arquivo externo
- Coleta de informações pessoais
- Validações de dados:
  * Nome com mínimo de 10 caracteres
  * Email com "@" obrigatório
  * Idade superior a 18 anos
  * Altura no formato de número com vírgula
- Prevenção de cadastros com emails duplicados

### Gerenciamento de Formulário
- Adicionar novas perguntas automaticamente
- Deletar perguntas (exceto as 4 iniciais)
- Listar usuários cadastrados
- Busca de usuários por nome ou email
