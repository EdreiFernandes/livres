import 'dart:convert';
import 'dart:developer';

import 'package:app_livres/classes/model/preComunidade.dart';
import 'package:http/http.dart' as http;

Future<List<PreComunidade>> precomunidades = PreComunidadeAPI.getPrecomunidades();

class PreComunidadeAPI {
  static Future<List<PreComunidade>> getPrecomunidades() async {
    final precomunidades = List<PreComunidade>();

    var url = "http://livresbs.herokuapp.com/api/precomunidade";

    var response = await http.get(url);
    print("RESPONSE STATUS PROJETOS ${response.statusCode}");
    if (response.statusCode == 200) {
      var responseJson = json.decode(response.body);
      log("RESPONSE PRECOMUNIDADE ==> ${response.body}");

      List listResponse = responseJson;
      print("LISTA ==> $listResponse");
      for (Map map in listResponse) {
        print("MAP ==> $map");
        PreComunidade p = PreComunidade.fromJson(map);
        print("P ==> ${p.nome}");
        precomunidades.add(p);
      }
      print(precomunidades[0].nome);
      return precomunidades;
    } else {
      print("RESPONSE STATUS PROJETOS ${response.statusCode}");
      return null;
    }
  }

  static Future<PreComunidade> postPrecomunidade(nome) async {
    var url = "http://livresbs.herokuapp.com/api/precomunidade";

    var header = {"Content-Type": "application/json"};
    Map params = {"nome": nome};

    var _body = json.encode(params);
    log(_body);
    var response = await http.post(url, body: _body, headers: header);

    print('Response Status Post: ${response.statusCode}');

    var precomunidade;

    if (response.statusCode == 200) {
      Map mapResponse = json.decode(response.body);
      precomunidade = PreComunidade.fromJson(mapResponse);
      log("FEZ O POST");
    } else {
      precomunidade = null;
    }

    return precomunidade;
  }
}
