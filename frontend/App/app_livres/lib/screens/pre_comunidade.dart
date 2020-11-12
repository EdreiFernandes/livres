import 'dart:developer';

import 'package:app_livres/classes/model/preComunidade.dart';
import 'package:app_livres/classes/requestAPI/preComunidadeAPI.dart';
import 'package:flutter/material.dart';

class PreComunidadeScreen extends StatefulWidget {
  _PreComunidadeScreen createState() => _PreComunidadeScreen();
}

Future<List<PreComunidade>> precomunidades = PreComunidadeAPI.getPrecomunidades();

final nomePreComunidade = TextEditingController();

class _PreComunidadeScreen extends State<PreComunidadeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Pré-Comunidade"),
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
        centerTitle: true,
      ),
      body: _body(precomunidades),
      floatingActionButton: FloatingActionButton(
        onPressed: addPrecomunidade,
        child: Icon(Icons.add),
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
      ),
    );
  }

  _body(precomunidades) {
    return FutureBuilder(
      future: precomunidades,
      builder: (context, snapshot) {
        if (snapshot.hasError) {
          return Text("Erro ao Acessar os Dados");
        }

        if (!snapshot.hasData) {
          return Center(
            child: CircularProgressIndicator(
              strokeWidth: 10,
            ),
          );
        }
        List<PreComunidade> precomunidades = snapshot.data;
        print(precomunidades[0].nome);
        return _conteudoBody(precomunidades);
      },
    );
  }

  _conteudoBody(precomunidades) {
    return ListView.builder(
      scrollDirection: Axis.vertical,
      shrinkWrap: true,
      itemCount: precomunidades.length,
      itemBuilder: (context, index) {
        if (precomunidades != null) {
          return ListTile(
            leading: CircleAvatar(
              child: Icon(Icons.group),
              backgroundColor: Color.fromARGB(255, 41, 171, 226),
              foregroundColor: Colors.white,
            ),
            title: Text(precomunidades[index].nome),
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
                    onPressed: () {},
                  ),
                ],
              ),
            ),
            onTap: () {},
          );
        } else {
          return Text("Não Há PreComunidades Cadastradas");
        }
      },
    );
  }

  addPrecomunidade() {
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
                      hintText: "Nome da Pré-Comunidade",
                      border: InputBorder.none,
                    ),
                    maxLines: 3,
                    controller: nomePreComunidade,
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
                      onPressed: () {
                        log(nomePreComunidade.text);
                        PreComunidadeAPI.postPrecomunidade(nomePreComunidade.text);
                        Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => PreComunidadeScreen()));
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
}

/*
  Widget listPreComunidade(nomePreComunidade) {
  return ListTile(
      leading: CircleAvatar(
        child: Icon(Icons.group),
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
        foregroundColor: Colors.white,
      ),
      title: Text(nomePreComunidade),
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
              onPressed: () {},
            ),
          ],
        ),
      ),
      onTap: () {},
    );*/

/*class PreComunidadeList extends StatelessWidget {
   _retorno(precomunidades);
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      scrollDirection: Axis.vertical,
      shrinkWrap: true,
      itemCount: 10,
      itemBuilder: (context, index) {
        return Card(
          child: ListTile(
            leading: CircleAvatar(
              child: Icon(Icons.group),
              backgroundColor: Color.fromARGB(255, 41, 171, 226),
              foregroundColor: Colors.white,
            ),
            title: Text('Pré-Comunidade ' + (index + 1).toString()),
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
                    onPressed: () {},
                  ),
                ],
              ),
            ),
            onTap: () {},
          ),
        );
      },
    );
  }
}*/
