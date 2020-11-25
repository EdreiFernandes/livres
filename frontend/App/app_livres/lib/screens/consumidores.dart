import 'dart:developer';

import 'package:app_livres/classes/model/consumidor.dart';

import 'package:app_livres/classes/requestAPI/consumidorAPI.dart';
import 'package:app_livres/classes/requestAPI/preComunidadeAPI.dart';
import 'package:app_livres/screens/consumidores_novo.dart';
import 'package:flutter/material.dart';

class ConsumidoresScreen extends StatefulWidget {
  _ConsumidoresScreen createState() => _ConsumidoresScreen();
}

Future<List<Consumidor>> consumidoresAll;

final nomePreComunidade = TextEditingController();

class _ConsumidoresScreen extends State<ConsumidoresScreen> {
  @override
  void initState() {
    super.initState();
    consumidoresAll = ConsumidorAPI.getConsumidores();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Consumidor"),
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
        centerTitle: true,
      ),
      body: _body(consumidores),
      floatingActionButton: FloatingActionButton(
        key: Key('floating'),
        onPressed: () async {
          await Navigator.of(context).push(_createRoute(ConsumidoresScreenNE()));
          setState(() {
            consumidoresAll = ConsumidorAPI.getConsumidores();
          });
        },
        child: Icon(Icons.add),
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
      ),
    );
  }

  Widget _body(consumidores) {
    return FutureBuilder(
      future: consumidoresAll,
      builder: (context, snapshot) {
        if (snapshot.hasError) {
          return Text("Erro ao Acessar os Dados");
        }

        if (!snapshot.hasData) {
          return Center(
            child: CircularProgressIndicator(),
          );
        }
        List<Consumidor> consumidores = snapshot.data;
        print(consumidores[0].nome);
        return _conteudoBody(consumidores);
      },
    );
  }

  Widget _conteudoBody(consumidores) {
    return ListView.builder(
      scrollDirection: Axis.vertical,
      shrinkWrap: true,
      itemCount: consumidores.length,
      itemBuilder: (context, index) {
        if (consumidores != null) {
          return ListTile(
            leading: CircleAvatar(
              child: Icon(Icons.person),
              backgroundColor: Color.fromARGB(255, 41, 171, 226),
              foregroundColor: Colors.white,
            ),
            title: Text(consumidores[index].nome),
            subtitle: Text("CPF: ${formataCpf(consumidores[index].cpf)}"),
            trailing: Container(
              width: 100,
              child: Row(
                children: [
                  IconButton(
                    icon: Icon(Icons.edit),
                    color: Colors.orange,
                    onPressed: () {},
                  ),
                  IconButton(
                    icon: Icon(Icons.delete),
                    color: Colors.red,
                    onPressed: () async {
                      bool fez = await ConsumidorAPI.deleteConsumidor(consumidores[index].cpf);

                      if (fez) {
                        log("entrou no coiso");
                        final snack = SnackBar(content: Text("Consumidor(a) ${consumidores[index].nome} Excluído(a) com Sucesso!"));

                        setState(() {
                          consumidoresAll = ConsumidorAPI.getConsumidores();
                          ;
                        });

                        Scaffold.of(context).showSnackBar(snack);
                      } else {
                        setState(() {
                          SnackBar(content: Text("Erro ao Excluir o(a) Consumidor(a) ${consumidores[index].nome}"));
                        });
                      }
                    },
                  ),
                ],
              ),
            ),
            onTap: () {},
          );
        } else {
          return Text("Não Há Consumidores Cadastrados");
        }
      },
    );
  }

  String _valueDrop = "1";
  addConsumidores() {
    return showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(32.0))),
          contentPadding: EdgeInsets.only(top: 10.0),
          content: Container(
            width: 50.0,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                Padding(
                  padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 30.0),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: "Nome do Consumidor",
                      border: InputBorder.none,
                    ),
                    maxLines: 3,
                    controller: nomePreComunidade,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 30.0),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: "Sobrenome do Consumidor",
                      border: InputBorder.none,
                    ),
                    maxLines: 3,
                    controller: nomePreComunidade,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 30.0),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: "CPF do Consumidor",
                      border: InputBorder.none,
                    ),
                    maxLines: 3,
                    controller: nomePreComunidade,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 30.0),
                  child: TextField(
                    obscureText: true,
                    decoration: InputDecoration(
                      hintText: "Senha do Consumidor",
                      border: InputBorder.none,
                    ),
                    controller: nomePreComunidade,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 30.0),
                  child: DropdownButton(
                    items: ["1", "2", "3"].map((String value) {
                      return new DropdownMenuItem(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                    value: _valueDrop,
                    onChanged: (String novoItem) {
                      setState(() {
                        _valueDrop = novoItem;
                      });
                    },
                  ),
                ),
                InkWell(
                  child: Container(
                    padding: EdgeInsets.only(top: 20.0, bottom: 20.0),
                    decoration: BoxDecoration(
                      color: Color.fromARGB(255, 41, 171, 226),
                      borderRadius: BorderRadius.only(bottomLeft: Radius.circular(32.0), bottomRight: Radius.circular(32.0)),
                    ),
                    child: FlatButton(
                      child: Text(
                        "Adicionar",
                        style: TextStyle(color: Colors.white),
                        textAlign: TextAlign.center,
                      ),
                      onPressed: () async {
                        log(nomePreComunidade.text);
                        Navigator.of(context).pop(true);
                        await PreComunidadeAPI.postPrecomunidade(nomePreComunidade.text);
                        precomunidades = PreComunidadeAPI.getPrecomunidades();

                        setState(() {
                          consumidoresAll = ConsumidorAPI.getConsumidores();
                        });
                      },
                    ),
                  ),
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  formataCpf(cpf) {
    String formata = cpf[0] + cpf[1] + cpf[2] + "." + cpf[3] + cpf[4] + cpf[5] + "." + cpf[6] + cpf[7] + cpf[8] + "-" + cpf[9] + cpf[10];
    return formata;
  }
}

Route _createRoute(page) {
  return PageRouteBuilder(
    pageBuilder: (context, animation, secondaryAnimation) => page,
    transitionsBuilder: (context, animation, secondaryAnimation, child) {
      var begin = Offset(0.0, 1.0);
      var end = Offset.zero;
      var curve = Curves.ease;

      var tween = Tween(begin: begin, end: end).chain(CurveTween(curve: curve));

      return SlideTransition(
        position: animation.drive(tween),
        child: child,
      );
    },
  );
}
